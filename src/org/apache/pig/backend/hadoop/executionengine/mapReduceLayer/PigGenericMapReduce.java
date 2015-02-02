/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileSystem.Statistics;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.Counters;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobID;
import org.apache.hadoop.mapred.Task;
import org.apache.hadoop.mapred.TaskReport;
import org.apache.hadoop.mapred.jobcontrol.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.pig.PigConfiguration;
import org.apache.pig.PigException;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.HDataType;
import org.apache.pig.backend.hadoop.datastorage.ConfigurationUtil;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners.RollupH2IRGAutoPivotPartitioner;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners.RollupH2IRGPartitioner;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.POStatus;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.PhysicalOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.Result;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.POUserFunc;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.POUserFuncRollupSample;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans.PhysicalPlan;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POForEach;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POJoinPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POLocalRearrange;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POPreCombinerLocalRearrange;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.PORollupCombinerPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.PORollupH2IRGForEach;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.PORollupSampling;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POStore;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.PORollupH2IRGForEach.TupleComparator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.util.PlanHelper;
import org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil;
import org.apache.pig.builtin.LinearRegressionModel;
import org.apache.pig.builtin.PigStorage;
import org.apache.pig.builtin.RegressionModel;
import org.apache.pig.builtin.RollupDimensions;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.SchemaTupleBackend;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.io.NullablePartitionWritable;
import org.apache.pig.impl.io.NullableTuple;
import org.apache.pig.impl.io.PigNullableWritable;
import org.apache.pig.impl.plan.DependencyOrderWalker;
import org.apache.pig.impl.plan.VisitorException;
import org.apache.pig.impl.util.ObjectSerializer;
import org.apache.pig.impl.util.Pair;
import org.apache.pig.impl.util.SpillableMemoryManager;
import org.apache.pig.impl.util.UDFContext;
import org.apache.pig.tools.pigstats.PigStatusReporter;

/**
 * This class is the static Mapper &amp; Reducer classes that
 * are used by Pig to execute Pig Map Reduce jobs. Since
 * there is a reduce phase, the leaf is bound to be a 
 * POLocalRearrange. So the map phase has to separate the
 * key and tuple and collect it into the output
 * collector.
 * 
 * The shuffle and sort phase sorts these keys &amp; tuples
 * and creates key, List&lt;Tuple&gt; and passes the key and
 * iterator to the list. The deserialized POPackage operator
 * is used to package the key, List&lt;Tuple&gt; into pigKey, 
 * Bag&lt;Tuple&gt; where pigKey is of the appropriate pig type and
 * then the result of the package is attached to the reduce
 * plan which is executed if its not empty. Either the result 
 * of the reduce plan or the package res is collected into
 * the output collector. 
 *
 * The index of the tuple (that is, which bag it should be placed in by the
 * package) is packed into the key.  This is done so that hadoop sorts the
 * keys in order of index for join.
 *
 * This class is the base class for PigMapReduce, which has slightly
 * difference among different versions of hadoop. PigMapReduce implementation
 * is located in $PIG_HOME/shims.
 */
public class PigGenericMapReduce {

    public static JobContext sJobContext = null;
    
    /**
     * @deprecated Use {@link UDFContext} instead in the following way to get 
     * the job's {@link Configuration}:
     * <pre>UdfContext.getUdfContext().getJobConf()</pre>
     */
    @Deprecated
    public static Configuration sJobConf = null;
    
    public static final ThreadLocal<Configuration> sJobConfInternal = new ThreadLocal<Configuration>();
    
    public static class Map extends PigMapBase {

        protected long sTime = 0;
        protected long fTime = 0;
        protected long mapWriteTime = 0;
        protected final Log log = LogFactory.getLog(getClass());
        @Override
        public void setup(Context oc) throws InterruptedException, IOException {
            sTime = System.currentTimeMillis();
            log.debug("Mapper Setup");
            super.setup(oc);
        }
        
        @Override
        public void collect(Context oc, Tuple tuple) 
                throws InterruptedException, IOException {
            Byte index = (Byte)tuple.get(0);
            PigNullableWritable key =
                HDataType.getWritableComparableTypes(tuple.get(1), keyType);
            NullableTuple val = new NullableTuple((Tuple)tuple.get(2));
            // Both the key and the value need the index.  The key needs it so
            // that it can be sorted on the index in addition to the key
            // value.  The value needs it so that POPackage can properly
            // assign the tuple to its slot in the projection.
            key.setIndex(index);
            val.setIndex(index);
            
            //sTime = System.currentTimeMillis();
            oc.write(key, val);
            //mapWriteTime += System.currentTimeMillis() - sTime;
        }
        
        @Override
        public void cleanup(Context oc)
                throws InterruptedException, IOException {
            Configuration jConf = oc.getConfiguration();

            fTime = System.currentTimeMillis();
//            String PSformat = PigInputSplitFormat.class.getName();
//                try {
//                    if(oc.getInputFormatClass().getName().equals(PSformat))
//                        return;
//                } catch (ClassNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }

            boolean isH2IRG = jConf.getBoolean(PigConfiguration.PIG_H2IRG_ROLLUP_OPTIMIZABLE, false);
            //If our rule is enabled and is using, there will be a PORollupH2IRGForEach
            //We will create special tuples which are considered as markers for reducers
            //to calculate the remaining results when that reducer goes to the end of the
            //input records. This special tuple will have larger size than the defaut by one
            //dimension. This addition dimension will be the value which are ranged from 0 to
            //number of reducers. By this addition, we can make sure that every reducers can
            //receive these special tuples to finish their works.
            if(isH2IRG) {
                int reducerNo = jConf.getInt("mapred.reduce.tasks", 0); 
                int length = jConf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_TOTAL_FIELD, 0);
                TupleFactory mTupleFactory = TupleFactory.getInstance();
                Tuple group[] = new Tuple[reducerNo];
                int count = 0;
                while(count < reducerNo) {
                    group[count] = mTupleFactory.newTuple();
                    for (int k = 0; k <= length; k++)
                        if(k < length)
                            group[count].append(null);
                        else
                            group[count].append(count);
                    
                    int nAlgebraic = 1;
                    
                    Tuple value = mTupleFactory.newTuple();
                    Tuple []tmp = new Tuple[nAlgebraic];
                    long valtmp = 1;
                    for(int i = 0; i < nAlgebraic; i++){
                        tmp[i] = mTupleFactory.newTuple();
                        tmp[i].append(valtmp);
                        value.append(tmp[i]);
                    }
                    
                    Tuple out = mTupleFactory.newTuple();
                    out.append(0);
                    out.append(group[count]);
                    out.append(value);
                    
                    PigNullableWritable key = HDataType.getWritableComparableTypes(out.get(1), keyType);
                    NullableTuple val = new NullableTuple((Tuple)out.get(2));
                    oc.write(key, val);
                    count++;
                }
                
                Tuple counter = null;
                //get total fields of a normal tuple
                int counterType = 1;
                String taskID = oc.getTaskAttemptID().toString();
                counter = mTupleFactory.newTuple();
                
                counter.append(null);
                counter.append(counterType);
                counter.append(taskID);
                long tTotal = fTime - sTime;
                counter.append(tTotal);
                counter.append(sTime);
                counter.append(fTime);
                counter.append(PigGenericMapBase.mapWriteTime);
                counter.append(PigStorage.tReadParse);
                counter.append(PigGenericMapBase.mapTime);
                counter.append(RollupH2IRGAutoPivotPartitioner.tLookup);
                counter.append(new Integer(0));
                
                //Tuple holds value
                Tuple value = mTupleFactory.newTuple();
                Tuple insideValue = mTupleFactory.newTuple();
                long valtmp = 1;
                insideValue.append(valtmp);
                value.append(insideValue);
                
                //Tuple holds key and value (will be passed to reducer)
                Tuple out = mTupleFactory.newTuple();
                out.append(0);
                out.append(counter);
                out.append(value);
                
                PigNullableWritable key = HDataType.getWritableComparableTypes(out.get(1), keyType);
                NullableTuple val = new NullableTuple((Tuple)out.get(2));
                oc.write(key, val);
            }
                long tTotal = fTime - sTime;
                //System.out.println("tPigRRInit: " + PigRecordReader.pigRecordReaderInitialization);
                System.out.println("MAPPER");
                System.out.println("readparse: \t" + PigStorage.tReadParse);
                System.out.println("mapfunc: \t" + PigGenericMapBase.mapTime);
                System.out.println("mapwrite: \t" + PigGenericMapBase.mapWriteTime);
                System.out.println("setup: \t" + sTime);
                System.out.println("cleanup: \t" + fTime);
                System.out.println("total: \t" + tTotal);
                System.out.println("lookup: " + RollupH2IRGAutoPivotPartitioner.tLookup);
                super.cleanup(oc);
         }
    }

    /**
     * This Mapper class is used for the samplign job of rollup
     * Each key will be output with the value is 1
     */
    public static class MapRollupSample extends PigMapBaseRollupSample {

        protected final Log log = LogFactory.getLog(getClass());
        
        long sTime = 0;
        long fTime = 0;
        
        long swTime = 0;
        long fwTime = 0;
        
        long mapWriteTime = 0;
        
        long mapWrite[] = new long[7];
        
        @Override
        public void setup(Context oc) throws InterruptedException, IOException {
            sTime = System.currentTimeMillis();
            log.debug("Mapper Setup");
            //Configuration jConf = oc.getConfiguration();
            //int length = jConf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_TOTAL_FIELD, 0);
            //mapWrite = new long[length+1];
            super.setup(oc);
        }
        
        @Override
        public void collect(Context oc, Tuple tuple) 
                throws InterruptedException, IOException {

            Byte index = (Byte)tuple.get(0);
            PigNullableWritable key =
                HDataType.getWritableComparableTypes(tuple.get(1), keyType);
            //NullableTuple val = new NullableTuple((Tuple)tuple.get(2));
            Tuple tmpVal = (Tuple)tuple.get(2);
            ((Tuple)tmpVal.get(0)).set(0, new Integer(1));
            NullableTuple val = new NullableTuple(tmpVal);
            key.setIndex(index);
            val.setIndex(index);
            oc.write(key, val);
            /*Tuple tmpKey = (Tuple)tuple.get(1);
            if(tmpKey.get(0) == null && tmpKey.get(1) == null && tmpKey.get(2) == null && tmpKey.get(3) == null && tmpKey.get(4) == null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[0] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) == null && tmpKey.get(2) == null && tmpKey.get(3) == null && tmpKey.get(4) == null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[1] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) != null && tmpKey.get(2) == null && tmpKey.get(3) == null && tmpKey.get(4) == null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[2] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) != null && tmpKey.get(2) != null && tmpKey.get(3) == null && tmpKey.get(4) == null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[3] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) != null && tmpKey.get(2) != null && tmpKey.get(3) != null && tmpKey.get(4) == null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[4] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) != null && tmpKey.get(2) != null && tmpKey.get(3) != null && tmpKey.get(4) != null && tmpKey.get(5) == null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[5] += System.currentTimeMillis() - tStart;
            } else if(tmpKey.get(0) != null && tmpKey.get(1) != null && tmpKey.get(2) != null && tmpKey.get(3) != null && tmpKey.get(4) != null && tmpKey.get(5) != null) {
                long tStart = System.currentTimeMillis();
                oc.write(key, val);
                mapWrite[6] += System.currentTimeMillis() - tStart;
            }*/
        }
        
        @Override
        public void cleanup(Context oc)
                throws InterruptedException, IOException {
            //System.out.println("POSampling Totaltime: " + PORollupSampling.rollupTime);

            fTime = System.currentTimeMillis();
            Configuration jConf = oc.getConfiguration();
            TupleFactory mTupleFactory = TupleFactory.getInstance();
            
            //Tuple holds key
            Tuple counter = null;
            //get total fields of a normal tuple
            int counterType = 1;
            String taskID = oc.getTaskAttemptID().toString();
            counter = mTupleFactory.newTuple();
            
            counter.append(null);
            counter.append(counterType);
            counter.append(taskID);
            counter.append(PORollupSampling.tPOSampling);
            counter.append(POUserFuncRollupSample.tCastProj);
            counter.append(RollupDimensions.rollupTime);
            counter.append((PORollupSampling.tPOSampling - POUserFuncRollupSample.tCastProj - RollupDimensions.rollupTime));
            counter.append((PigGenericMapBaseRollupSample.tCollect - PORollupSampling.tPOSampling));
            counter.append(PigGenericMapBaseRollupSample.tCollect);
            counter.append(PigGenericMapBaseRollupSample.mapTime);
            counter.append(PigGenericMapBaseRollupSample.mapWriteTime);
            long tTotal = fTime - sTime;
            counter.append(tTotal);
            counter.append(sTime);
            counter.append(fTime);
            counter.append((PigGenericMapBaseRollupSample.tCollect - POPreCombinerLocalRearrange.PreCombiner));
            counter.append(POPreCombinerLocalRearrange.PreCombiner);
            counter.append(PigStorage.tReadParse);
            counter.append(PORollupSampling.tCachePOSampling);
            for (int i = 0; i < PigGenericMapBaseRollupSample.mapWrite.length; i++)
                counter.append(PigGenericMapBaseRollupSample.mapWrite[i]);
            
            //Tuple holds value
            Tuple value = mTupleFactory.newTuple();
            Tuple insideValue = mTupleFactory.newTuple();
            long valtmp = 1;
            insideValue.append(valtmp);
            value.append(insideValue);
            
            //Tuple holds key and value (will be passed to reducer)
            Tuple out = mTupleFactory.newTuple();
            out.append(0);
            out.append(counter);
            out.append(value);
            
            PigNullableWritable key = HDataType.getWritableComparableTypes(out.get(1), keyType);
            NullableTuple val = new NullableTuple((Tuple)out.get(2));
            oc.write(key, val);
            
            System.out.println("tPigRRInit: " + PigRecordReader.pigRecordReaderInitialization);
            System.out.println("tReadParse: " + PigStorage.tReadParse);
            System.out.println("tPOSampling: " + PORollupSampling.tPOSampling);
            System.out.println("tCast: " + POUserFuncRollupSample.tCastProj);
            System.out.println("tRollup: " + RollupDimensions.rollupTime);
            System.out.println("tCachePOSampling: " + PORollupSampling.tCachePOSampling);
            System.out.println("tCache: " + (PORollupSampling.tPOSampling - POUserFuncRollupSample.tCastProj - RollupDimensions.rollupTime));
            System.out.println("tPrecombiner: " + (PigGenericMapBaseRollupSample.tCollect - PORollupSampling.tPOSampling));
            System.out.println("tPreCombiner*: " + (PigGenericMapBaseRollupSample.tCollect - POPreCombinerLocalRearrange.PreCombiner));
            System.out.println("tCollect: " + PigGenericMapBaseRollupSample.tCollect);
            System.out.println("tMap: " + PigGenericMapBaseRollupSample.mapTime);
            System.out.println("tMapWriteTime: " + PigGenericMapBaseRollupSample.mapWriteTime);
            System.out.println("tHashing: " + RollupH2IRGPartitioner.tH2IRGHash);
            System.out.println("Map setup-cleanup: " + sTime + " " + fTime + " Total: " + tTotal);
        }
    }
    
    /**
     * This "specialized" map class is ONLY to be used in pig queries with
     * order by a udf. A UDF used for comparison in the order by expects
     * to be handed tuples. Hence this map class ensures that the "key" used
     * in the order by is wrapped into a tuple (if it isn't already a tuple)
     */
    public static class MapWithComparator extends PigMapBase {

        @Override
        public void collect(Context oc, Tuple tuple) 
                throws InterruptedException, IOException {
            
            Object keyTuple = null;
            if(keyType != DataType.TUPLE) {
                Object k = tuple.get(1);
                keyTuple = tf.newTuple(k);
            } else {
                keyTuple = tuple.get(1);
            }
            

            Byte index = (Byte)tuple.get(0);
            PigNullableWritable key =
                HDataType.getWritableComparableTypes(keyTuple, DataType.TUPLE);
            NullableTuple val = new NullableTuple((Tuple)tuple.get(2));
            
            // Both the key and the value need the index.  The key needs it so
            // that it can be sorted on the index in addition to the key
            // value.  The value needs it so that POPackage can properly
            // assign the tuple to its slot in the projection.
            key.setIndex(index);
            val.setIndex(index);
            
            oc.write(key, val);
        }
    }

    /**
     * Used by Skewed Join
     */
    public static class MapWithPartitionIndex extends Map {

        @Override
        public void collect(Context oc, Tuple tuple) 
                throws InterruptedException, IOException {
            
            Byte tupleKeyIdx = 2;
            Byte tupleValIdx = 3;

            Byte index = (Byte)tuple.get(0);
            Integer partitionIndex = -1;
            // for partitioning table, the partition index isn't present
            if (tuple.size() == 3) {
                //super.collect(oc, tuple);
                //return;
                tupleKeyIdx--;
                tupleValIdx--;
            } else {
                partitionIndex = (Integer)tuple.get(1);
            }

            PigNullableWritable key =
                HDataType.getWritableComparableTypes(tuple.get(tupleKeyIdx), keyType);

            NullablePartitionWritable wrappedKey = new NullablePartitionWritable(key);

            NullableTuple val = new NullableTuple((Tuple)tuple.get(tupleValIdx));
            
            // Both the key and the value need the index.  The key needs it so
            // that it can be sorted on the index in addition to the key
            // value.  The value needs it so that POPackage can properly
            // assign the tuple to its slot in the projection.
            wrappedKey.setIndex(index);
            
            // set the partition
            wrappedKey.setPartition(partitionIndex);
            val.setIndex(index);
            oc.write(wrappedKey, val);
        }

        @Override
        protected void runPipeline(PhysicalOperator leaf) 
                throws IOException, InterruptedException {
            
            while(true){
                Result res = leaf.getNextTuple();
                
                if(res.returnStatus==POStatus.STATUS_OK){
                    // For POPartitionRearrange, the result is a bag. 
                    // This operator is used for skewed join
                    if (res.result instanceof DataBag) {
                        Iterator<Tuple> its = ((DataBag)res.result).iterator();
                        while(its.hasNext()) {
                            collect(outputCollector, its.next());
                        }
                    }else{
                        collect(outputCollector, (Tuple)res.result);
                    }
                    continue;
                }
                
                if(res.returnStatus==POStatus.STATUS_EOP) {
                    return;
                }

                if(res.returnStatus==POStatus.STATUS_NULL) {
                    continue;
                }

                if(res.returnStatus==POStatus.STATUS_ERR){
                    // remember that we had an issue so that in 
                    // close() we can do the right thing
                    errorInMap  = true;
                    // if there is an errmessage use it
                    String errMsg;
                    if(res.result != null) {
                        errMsg = "Received Error while " +
                            "processing the map plan: " + res.result;
                    } else {
                        errMsg = "Received Error while " +
                            "processing the map plan.";
                    }

                    int errCode = 2055;
                    throw new ExecException(errMsg, errCode, PigException.BUG);
                }
            }
        }
    }

    abstract public static class Reduce 
            extends Reducer <PigNullableWritable, NullableTuple, PigNullableWritable, Writable> {
        
        protected final Log log = LogFactory.getLog(getClass());
        
        //The reduce plan
        protected PhysicalPlan rp = null;

        // Store operators
        protected List<POStore> stores;
        
        protected long mapInputRecords;
        
        //The POPackage operator which is the
        //root of every Map Reduce plan is
        //obtained through the job conf. The portion
        //remaining after its removal is the reduce
        //plan
        protected POPackage pack;
        
        ProgressableReporter pigReporter;

        protected Context outputCollector;

        protected boolean errorInReduce = false;
        
        PhysicalOperator[] roots;

        private PhysicalOperator leaf;
        
        PigContext pigContext = null;
        protected volatile boolean initialized = false;
        
        private boolean inIllustrator = false;
        
        protected long writeToDiskTime = 0;
        
        protected long reduceWholeStime = 0;
        
        protected long reduceWholeFtime = 0;
        
        protected long swTime = 0;
        
        protected long packTime = 0;
        
        protected long leafTime = 0;
        
        protected int lengthTuple = 0;
        
        protected boolean receivedLast = false;
        
        protected HashMap<String, List<Long>> hm = new HashMap<String, List<Long>>();
        
        /**
         * Set the reduce plan: to be used by local runner for illustrator
         * @param plan Reduce plan
         */
        public void setReducePlan(PhysicalPlan plan) {
            rp = plan;
        }

        /**
         * Configures the Reduce plan, the POPackage operator
         * and the reporter thread
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            super.setup(context);
            reduceWholeStime = System.currentTimeMillis();
            inIllustrator = inIllustrator(context);
            if (inIllustrator)
                pack = getPack(context);
            Configuration jConf = context.getConfiguration();
            SpillableMemoryManager.configure(ConfigurationUtil.toProperties(jConf));
            sJobContext = context;
            sJobConfInternal.set(context.getConfiguration());
            sJobConf = context.getConfiguration();
            try {
                PigContext.setPackageImportList((ArrayList<String>)ObjectSerializer.deserialize(jConf.get("udf.import.list")));
                pigContext = (PigContext)ObjectSerializer.deserialize(jConf.get("pig.pigContext"));
                
                // This attempts to fetch all of the generated code from the distributed cache, and resolve it
                SchemaTupleBackend.initialize(jConf, pigContext);

                if (rp == null)
                    rp = (PhysicalPlan) ObjectSerializer.deserialize(jConf
                            .get("pig.reducePlan"));
                stores = PlanHelper.getPhysicalOperators(rp, POStore.class);

                if (!inIllustrator)
                    pack = (POPackage)ObjectSerializer.deserialize(jConf.get("pig.reduce.package"));
                // To be removed
                if(rp.isEmpty())
                    log.debug("Reduce Plan empty!");
                else{
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    rp.explain(baos);
                    log.debug(baos.toString());
                }
                pigReporter = new ProgressableReporter();
                if(!(rp.isEmpty())) {
                    roots = rp.getRoots().toArray(new PhysicalOperator[1]);
                    leaf = rp.getLeaves().get(0);
                }
                
                // Get the UDF specific context
                MapRedUtil.setupUDFContext(jConf);
            
            } catch (IOException ioe) {
                String msg = "Problem while configuring reduce plan.";
                throw new RuntimeException(msg, ioe);
            }
            log.info("Aliases being processed per job phase (AliasName[line,offset]): " + jConf.get("pig.alias.location"));
            
            String dtzStr = PigMapReduce.sJobConfInternal.get().get("pig.datetime.default.tz");
            if (dtzStr != null && dtzStr.length() > 0) {
                // ensure that the internal timezone is uniformly in UTC offset style
                DateTimeZone.setDefault(DateTimeZone.forOffsetMillis(DateTimeZone.forID(dtzStr).getOffset(null)));
            }
            lengthTuple = jConf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_TOTAL_FIELD, 0);
        }
        
        /**
         * The reduce function which packages the key and List&lt;Tuple&gt;
         * into key, Bag&lt;Tuple&gt; after converting Hadoop type key into Pig type.
         * The package result is either collected as is, if the reduce plan is
         * empty or after passing through the reduce plan.
         */       
        @Override
        protected void reduce(PigNullableWritable key, Iterable<NullableTuple> tupIter, Context context) 
                throws IOException, InterruptedException {            
            
            if (!initialized) {
                initialized = true;
                
                // cache the collector for use in runPipeline()
                // which could additionally be called from close()
                this.outputCollector = context;
                pigReporter.setRep(context);
                PhysicalOperator.setReporter(pigReporter);

                boolean aggregateWarning = "true".equalsIgnoreCase(pigContext.getProperties().getProperty("aggregate.warning"));

                PigHadoopLogger pigHadoopLogger = PigHadoopLogger.getInstance();
                pigHadoopLogger.setAggregate(aggregateWarning);
                PigStatusReporter.setContext(context);
                pigHadoopLogger.setReporter(PigStatusReporter.getInstance());
                
                PhysicalOperator.setPigLogger(pigHadoopLogger);

                if (!inIllustrator)
                    for (POStore store: stores) {
                        MapReducePOStoreImpl impl 
                            = new MapReducePOStoreImpl(context);
                        store.setStoreImpl(impl);
                        store.setUp();
                    }
            }
          
            // In the case we optimize the join, we combine
            // POPackage and POForeach - so we could get many
            // tuples out of the getnext() call of POJoinPackage
            // In this case, we process till we see EOP from 
            // POJoinPacakage.getNext()
            if (pack instanceof POJoinPackage)
            {
                pack.attachInput(key, tupIter.iterator());
                while (true)
                {
                    if (processOnePackageOutput(context))
                        break;
                }
            }
            else {
                // join is not optimized, so package will
                // give only one tuple out for the key
                Tuple tmpKey = (Tuple)key.getValueAsPigType();
                int l = tmpKey.size();
                /*if(l > lengthTuple + 1)
                    processSamplingTuple(tmpKey);
                else {
                    if(l == lengthTuple +1)
                        if (receivedLast == false)
                            receivedLast = true;
                        else
                            return;
                    pack.attachInput(key, tupIter.iterator());
                    processOnePackageOutput(context);
                }*/
                if(tmpKey.get(0) == null && tmpKey.get(1)!=null)
                    processSamplingTuple(tmpKey);
                else {
                    pack.attachInput(key, tupIter.iterator());
                    processOnePackageOutput(context);
                }
            } 
        }
        
        public void processSamplingTuple(Tuple tmpKey) throws ExecException {
            int counterType = (Integer) tmpKey.get(1);
            //if (counterType == 1) {
                String id = (String)tmpKey.get(2);
                List<Long> t = new ArrayList<Long>();
                long Total = (Long)tmpKey.get(3);
                long Start = (Long)tmpKey.get(4);
                long Finish = (Long)tmpKey.get(5);
                long Write = (Long)tmpKey.get(6);
                long ReadParse = (Long)tmpKey.get(7);
                long MapFunc = (Long)tmpKey.get(8);
                long Hash = (Long)tmpKey.get(9);
                if(hm.containsKey(id))
                    t = hm.get(id);
                t.add(new Long(counterType*-1));
                t.add(Total);
                t.add(Start);
                t.add(Finish);
                t.add(Write);
                t.add(ReadParse);
                t.add(MapFunc);
                t.add(Hash);
                hm.put(id, t);/*
            } else {
                String id = (String)tmpKey.get(2);
                List<Long> t = new ArrayList<Long>();
                long cbnTotal = (Long)tmpKey.get(3);
                long cbnStart = (Long)tmpKey.get(4);
                long cbnFinish = (Long)tmpKey.get(5);
                long cbnWrite = (Long)tmpKey.get(6);
                if(hm.containsKey(id))
                    t = hm.get(id);
                t.add(new Long(-2));
                t.add(cbnTotal);
                t.add(cbnStart);
                t.add(cbnFinish);
                t.add(cbnWrite);
                hm.put(id, t);
            }*/
        }
        
        // return: false-more output
        //         true- end of processing
        public boolean processOnePackageOutput(Context oc) 
                throws IOException, InterruptedException {

            long packStart = System.currentTimeMillis();
            Result res = pack.getNextTuple();
            packTime += System.currentTimeMillis() - packStart;
            if(res.returnStatus==POStatus.STATUS_OK){
                Tuple packRes = (Tuple)res.result;
                
                if(rp.isEmpty()){
                    swTime = System.currentTimeMillis();
                    oc.write(null, packRes);
                    writeToDiskTime += System.currentTimeMillis() - swTime;

                    return false;
                }
                for (int i = 0; i < roots.length; i++) {
                    roots[i].attachInput(packRes);
                }
                long leafStart = System.currentTimeMillis();
                runPipeline(leaf);
                leafTime += System.currentTimeMillis() - leafStart;
                
            }
            
            if(res.returnStatus==POStatus.STATUS_NULL) {
                return false;
            }
            
            if(res.returnStatus==POStatus.STATUS_ERR){
                int errCode = 2093;
                String msg = "Encountered error in package operator while processing group.";
                throw new ExecException(msg, errCode, PigException.BUG);
            }
            
            if(res.returnStatus==POStatus.STATUS_EOP) {
                return true;
            }
                
            return false;
            
        }
        
        /**
         * @param leaf
         * @throws InterruptedException
         * @throws IOException 
         */
        protected void runPipeline(PhysicalOperator leaf) 
                throws InterruptedException, IOException {
            
            while(true)
            {
                Result redRes = leaf.getNextTuple();
                if(redRes.returnStatus==POStatus.STATUS_OK){
                    try{
                        swTime = System.currentTimeMillis();
                        outputCollector.write(null, (Tuple)redRes.result);
                        writeToDiskTime += System.currentTimeMillis() - swTime;
                    }catch(Exception e) {
                        throw new IOException(e);
                    }
                    continue;
                }
                
                if(redRes.returnStatus==POStatus.STATUS_EOP) {
                    return;
                }
                
                if(redRes.returnStatus==POStatus.STATUS_NULL) {
                    continue;
                }
                
                if(redRes.returnStatus==POStatus.STATUS_ERR){
                    // remember that we had an issue so that in 
                    // close() we can do the right thing
                    errorInReduce   = true;
                    // if there is an errmessage use it
                    String msg;
                    if(redRes.result != null) {
                        msg = "Received Error while " +
                        "processing the reduce plan: " + redRes.result;
                    } else {
                        msg = "Received Error while " +
                        "processing the reduce plan.";
                    }
                    int errCode = 2090;
                    throw new ExecException(msg, errCode, PigException.BUG);
                }
            }
        }
        
        /**
         * Will be called once all the intermediate keys and values are
         * processed. So right place to stop the reporter thread.
         */
        @Override 
        protected void cleanup(Context context) throws IOException,
                InterruptedException {
            super.cleanup(context);
            if (errorInReduce) {
                // there was an error in reduce - just return
                return;
            }

            if (PigMapReduce.sJobConfInternal.get().get("pig.stream.in.reduce",
                    "false").equals("true")) {
                // If there is a stream in the pipeline we could
                // potentially have more to process - so lets
                // set the flag stating that all map input has been sent
                // already and then lets run the pipeline one more time
                // This will result in nothing happening in the case
                // where there is no stream in the pipeline
                rp.endOfAllInput = true;
                runPipeline(leaf);
            }

            if (!inIllustrator) {
                for (POStore store : stores) {
                    if (!initialized) {
                        MapReducePOStoreImpl impl = new MapReducePOStoreImpl(
                                context);
                        store.setStoreImpl(impl);
                        store.setUp();
                    }
                    store.tearDown();
                }
            }

            // Calling EvalFunc.finish()
            UDFFinishVisitor finisher = new UDFFinishVisitor(rp, new DependencyOrderWalker<PhysicalOperator, PhysicalPlan>(rp));
            
            try {
                finisher.visit();
            } catch (VisitorException e) {
                throw new IOException("Error trying to finish UDFs",e);
            }

            // try {
            // if (context.getInputFormatClass().getName().equals(PSformat)) {
            JobClient jc = new JobClient(new JobConf(context.getConfiguration()));
            TaskReport[] tr = jc.getMapTaskReports(JobID.downgrade(context.getJobID()));
            System.out.println(tr.length);
            for (int i = 0; i < tr.length; i++) {
                System.out.println("\n");
                System.out.println("Whole Map Process " + i);
                System.out.println("start: \t" + tr[i].getStartTime());
                System.out.println("finish: \t" + tr[i].getFinishTime());
                System.out.println("total: \t" + (tr[i].getFinishTime() - tr[i].getStartTime()));
                Counters map = tr[i].getCounters();
                System.out.println("MIR: \t" + map.getCounter(Task.Counter.MAP_INPUT_RECORDS));
                System.out.println("MOR: \t" + map.getCounter(Task.Counter.MAP_OUTPUT_RECORDS));
                System.out.println("CIR: \t" + map.getCounter(Task.Counter.COMBINE_INPUT_RECORDS));
                System.out.println("COR: \t" + map.getCounter(Task.Counter.COMBINE_OUTPUT_RECORDS));
                String id = tr[i].getTaskID().toString();
                id = id.replace("task_", "attempt_");
                id = id.concat("_0");
                System.out.println(id);
                if(hm.containsKey(id)){
                    List<Long> t = hm.get(id);
                    t.add((tr[i].getFinishTime() - tr[i].getStartTime()));
                    t.add(tr[i].getStartTime());
                    t.add(tr[i].getFinishTime());
                    t.add(map.getCounter(Task.Counter.MAP_INPUT_RECORDS));
                    t.add(map.getCounter(Task.Counter.MAP_OUTPUT_RECORDS));
                    t.add(map.getCounter(Task.Counter.COMBINE_INPUT_RECORDS));
                    t.add(map.getCounter(Task.Counter.COMBINE_OUTPUT_RECORDS));
                    hm.put(id, t);
                }
            }
            
            for (Entry<String, List<Long>> entry : hm.entrySet()) {
                String key = entry.getKey() + "\t";
                List<Long> values = entry.getValue();
                for (Long val : values)
                    key = key + val.toString() + "\t";
                System.out.println(key);
            }
            
            TaskReport[] trR = jc.getReduceTaskReports(JobID.downgrade(context.getJobID()));
            System.out.println(trR.length);
            for (int i = 0; i < trR.length; i++) {
                System.out.println("\n");
                System.out.println("Whole Reduce Process");
                System.out.println("start: " + trR[i].getStartTime());
                System.out.println("RIR: " + context.getCounter(Task.Counter.REDUCE_INPUT_RECORDS).getValue()
                        + " -- ROR: " + context.getCounter(Task.Counter.REDUCE_OUTPUT_RECORDS).getValue());
            }
            PhysicalOperator.setReporter(null);
            initialized = false;
            reduceWholeFtime = System.currentTimeMillis();
            System.out.println("reduce WriteToDisk Time: \t" + writeToDiskTime);
            System.out.println("reduce - setup - time: \t" + reduceWholeStime);
            System.out.println("reduce - cleanup - time: \t" + reduceWholeFtime);
            System.out.println("total: \t" + (reduceWholeFtime - reduceWholeStime));
            System.out.println("reduce processing time: \t" + (reduceWholeFtime - reduceWholeStime - writeToDiskTime));
        }
        
        /**
         * Get reducer's illustrator context
         * 
         * @param input Input buffer as output by maps
         * @param pkg package
         * @return reducer's illustrator context
         * @throws IOException
         * @throws InterruptedException
         */
        abstract public Context getIllustratorContext(Job job,
               List<Pair<PigNullableWritable, Writable>> input, POPackage pkg) throws IOException, InterruptedException;
        
        abstract public boolean inIllustrator(Context context);
        
        abstract public POPackage getPack(Context context);
    }

    abstract public static class ReduceRollupSample
            extends
            Reducer<PigNullableWritable, NullableTuple, PigNullableWritable, Writable> {

        protected final Log log = LogFactory.getLog(getClass());

        // The reduce plan
        protected PhysicalPlan rp = null;

        // Store operators
        protected List<POStore> stores;

        protected long mapInputRecords;

        // The POPackage operator which is the
        // root of every Map Reduce plan is
        // obtained through the job conf. The portion
        // remaining after its removal is the reduce
        // plan
        protected POPackage pack;

        ProgressableReporter pigReporter;

        protected Context outputCollector;

        protected boolean errorInReduce = false;

        PhysicalOperator[] roots;

        private PhysicalOperator leaf;

        PigContext pigContext = null;
        protected volatile boolean initialized = false;

        private boolean inIllustrator = false;

        protected long writeToDiskTime = 0;

        protected long reduceWholeStime = 0;

        protected long reduceWholeFtime = 0;

        protected long swTime = 0;
        
        protected long reduceFunc = 0;

        /*FOR ROLLUP ESTIMATION*/
        protected Path d[] = null;

        protected FSDataOutputStream out[] = null;

        protected Path sum = null;

        protected FSDataOutputStream sumout = null;

        protected ArrayList<Result> test = null;

        public long[] tmpCombine;

        protected static final BagFactory mBagFactory = BagFactory.getInstance();

        protected int numReducers = 0;

        private double theta = 0.9;
        
        protected ArrayList<Tuple> samList = new ArrayList<Tuple>();
        
        protected int lengthDimension = 0;
        
        protected long tSampling = 0;
        
        protected long tRollup = 0;
        
        protected long tSpecial = 0;
        
        protected long tEstimate = 0;
        
        protected int autopivot = 0;
        
        public ArrayList<ArrayList<Tuple>> al = null;
        
        public ArrayList<Double> MapWrite0 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite1 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite2 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite3 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite4 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite5 = new ArrayList<Double>();
        public ArrayList<Double> MapWrite6 = new ArrayList<Double>();
        
        public ArrayList<Double> MapWriteAll = new ArrayList<Double>();
        
        public ArrayList<Double> MapWritePv1 = new ArrayList<Double>();
        public ArrayList<Double> MapWritePv2 = new ArrayList<Double>();
        public ArrayList<Double> MapWritePv3 = new ArrayList<Double>();
        public ArrayList<Double> MapWritePv4 = new ArrayList<Double>();
        public ArrayList<Double> MapWritePv5 = new ArrayList<Double>();
        
        public ArrayList<Double> combineRuntime = new ArrayList<Double>();
        
        public ArrayList<Double> combineProcesstime = new ArrayList<Double>();
        
        public ArrayList<Double> combineWritetime = new ArrayList<Double>();
        public ArrayList<Double> combineSorttime = new ArrayList<Double>();
        public ArrayList<Double> mapFinish = new ArrayList<Double>();
        
        public ArrayList<Double> mapPhase = new ArrayList<Double>();
        
        public ArrayList<Double> MORrjEst = new ArrayList<Double>();
        public ArrayList<Double> MORrjEst7 = new ArrayList<Double>();
        
        public ArrayList<Double> MIR = new ArrayList<Double>();
        
        public long[] minimizeSum = null;
        
        public long[] subofSubSum = null;
        
        public double totalEstimate[] = null;
        
        public double partitionRate[] = null;

        /**
         * Set the reduce plan: to be used by local runner for illustrator
         * 
         * @param plan
         *            Reduce plan
         */
        public void setReducePlan(PhysicalPlan plan) {
            rp = plan;
        }

        /**
         * Configures the Reduce plan, the POPackage operator and the reporter
         * thread
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void setup(Context context) throws IOException,
                InterruptedException {
            super.setup(context);
            //System.out.println("SampleReduce");
            reduceWholeStime = System.currentTimeMillis();
            //System.out.println(reduceWholeStime);
            inIllustrator = inIllustrator(context);
            if (inIllustrator)
                pack = getPack(context);
            Configuration jConf = context.getConfiguration();
            SpillableMemoryManager.configure(ConfigurationUtil
                    .toProperties(jConf));
            sJobContext = context;
            sJobConfInternal.set(context.getConfiguration());
            sJobConf = context.getConfiguration();
            try {
                PigContext
                        .setPackageImportList((ArrayList<String>) ObjectSerializer
                                .deserialize(jConf.get("udf.import.list")));
                pigContext = (PigContext) ObjectSerializer.deserialize(jConf
                        .get("pig.pigContext"));

                // This attempts to fetch all of the generated code from the
                // distributed cache, and resolve it
                SchemaTupleBackend.initialize(jConf, pigContext);

                if (rp == null)
                    rp = (PhysicalPlan) ObjectSerializer.deserialize(jConf
                            .get("pig.reducePlan"));
                stores = PlanHelper.getPhysicalOperators(rp, POStore.class);

                if (!inIllustrator)
                    pack = (POPackage) ObjectSerializer.deserialize(jConf
                            .get("pig.reduce.package"));
                // To be removed
                if (rp.isEmpty())
                    log.debug("Reduce Plan empty!");
                else {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    rp.explain(baos);
                    log.debug(baos.toString());
                }
                pigReporter = new ProgressableReporter();
                if (!(rp.isEmpty())) {
                    roots = rp.getRoots().toArray(new PhysicalOperator[1]);
                    leaf = rp.getLeaves().get(0);
                }

                // Get the UDF specific context
                MapRedUtil.setupUDFContext(jConf);

            } catch (IOException ioe) {
                String msg = "Problem while configuring reduce plan.";
                throw new RuntimeException(msg, ioe);
            }
            log.info("Aliases being processed per job phase (AliasName[line,offset]): "
                    + jConf.get("pig.alias.location"));

            String dtzStr = PigMapReduce.sJobConfInternal.get().get(
                    "pig.datetime.default.tz");
            if (dtzStr != null && dtzStr.length() > 0) {
                // ensure that the internal timezone is uniformly in UTC offset
                // style
                DateTimeZone.setDefault(DateTimeZone
                        .forOffsetMillis(DateTimeZone.forID(dtzStr).getOffset(
                                null)));
            }
            lengthDimension = jConf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_TOTAL_FIELD, 0);
            initEstimatedFile(lengthDimension);
            PORollupH2IRGForEach rollup = (PORollupH2IRGForEach) leaf;
            rollup.conditionPosition = lengthDimension - 1;
        }

        /**
         * The reduce function which packages the key and List&lt;Tuple&gt; into
         * key, Bag&lt;Tuple&gt; after converting Hadoop type key into Pig type.
         * The package result is either collected as is, if the reduce plan is
         * empty or after passing through the reduce plan.
         */
        @Override
        protected void reduce(PigNullableWritable key,
                Iterable<NullableTuple> tupIter, Context context)
                throws IOException, InterruptedException {
            long reduceStart = System.currentTimeMillis();
            if (!initialized) {
                initialized = true;

                // cache the collector for use in runPipeline()
                // which could additionally be called from close()
                this.outputCollector = context;
                pigReporter.setRep(context);
                PhysicalOperator.setReporter(pigReporter);

                boolean aggregateWarning = "true".equalsIgnoreCase(pigContext
                        .getProperties().getProperty("aggregate.warning"));

                PigHadoopLogger pigHadoopLogger = PigHadoopLogger.getInstance();
                pigHadoopLogger.setAggregate(aggregateWarning);
                PigStatusReporter.setContext(context);
                pigHadoopLogger.setReporter(PigStatusReporter.getInstance());

                PhysicalOperator.setPigLogger(pigHadoopLogger);

                if (!inIllustrator)
                    for (POStore store : stores) {
                        MapReducePOStoreImpl impl = new MapReducePOStoreImpl(
                                context);
                        store.setStoreImpl(impl);
                        store.setUp();
                    }
            }

            // In the case we optimize the join, we combine
            // POPackage and POForeach - so we could get many
            // tuples out of the getnext() call of POJoinPackage
            // In this case, we process till we see EOP from
            // POJoinPacakage.getNext()
            if (pack instanceof POJoinPackage) {
                pack.attachInput(key, tupIter.iterator());
                while (true) {
                    if (processOnePackageOutput(context))
                        break;
                }
            } else {
                // join is not optimized, so package will
                // give only one tuple out for the key
                long specialS = System.currentTimeMillis();
                Tuple tmpKey = (Tuple)key.getValueAsPigType();
                int l = tmpKey.size();
                if(tmpKey.get(0)!=null &&  tmpKey.get(l-1)!=null) {
                    long rollupS = System.currentTimeMillis();
                    pack.attachInput(key, tupIter.iterator());
                    processOnePackageOutput(context);
                    tRollup+=System.currentTimeMillis() - rollupS;
                } else {
                    //long samplingS = System.currentTimeMillis();
                    processSamplingTuple(tmpKey, tupIter.iterator(), l);
                    //tSampling += System.currentTimeMillis() - samplingS;
                }
                tSpecial += System.currentTimeMillis() - specialS;
            }
            reduceFunc += System.currentTimeMillis() - reduceStart;
        }

        /**
         * initial the ArrayList al initial the tmpCombine array
         * 
         * @param len
         */
        private void initEstimatedFile(int len) {
            
            minimizeSum = new long[len+1];
            subofSubSum = new long[len+1];
            totalEstimate = new double[len+1];
            partitionRate = new double[5];
            partitionRate[0] = (5985+5758+5863+5542+6183+5870+6034+6007+5792+6008)*1.0/10;
            partitionRate[1] = (7307+8178+7038+6952+7337+7694+7206+7259+7528+7420)*1.0/10;
            partitionRate[2] = (11094+11212+10742+10907+11292+12426+11317+11648+11427+11838)*1.0/10;
            partitionRate[3] = (14937+13276+14582+13620+12959+14650+13785+14076+13610+14405)*1.0/10;
            partitionRate[4] = (16181+16519+15121+14231+14121+15431+15121+13121+15983+14212)*1.0/10;
            
            partitionRate[0] = 3500;
            partitionRate[1] = 7500;
            partitionRate[2] = 11000;
            partitionRate[3] = 14000;
            partitionRate[4] = 16000;
            
            /*for (int i = 0; i < 5; i++)
                System.out.println(partitionRate[i]);*/
            
            al = new ArrayList<ArrayList<Tuple>>();
            for (int i = 0; i < len + 1; i++) {
                ArrayList<Tuple> single = new ArrayList<Tuple>();
                al.add(single);
            }
            
            tmpCombine = new long[len];
            for (int i = 0; i < len; i++)
                tmpCombine[i] = 0;
        }

        public void IRGEstimation(Result res) throws ExecException {
            
            TupleFactory mTupleFactory = TupleFactory
                    .getInstance();
            Tuple tmp = mTupleFactory.newTuple();
            tmp = (Tuple) res.result;
            Tuple key = (Tuple) tmp.get(0);
            if (key.size() == lengthDimension)
                key.append(tmp.get(1));
            
            int countNull = 0;
            for (int i = 0; i < key.size() - 1; i++)
                if (key.get(i) == null)
                    countNull++;

            int index = al.size() - countNull - 1;

            al.get(index).add(key);
        }
        
        public Result reformatRes(Result res) throws ExecException {
            TupleFactory mTupleFactory = TupleFactory.getInstance();
            Tuple tmp = mTupleFactory.newTuple();
            tmp = (Tuple) res.result;
            Tuple reformatkey = null;
            reformatkey = mTupleFactory.newTuple();
            Tuple key = (Tuple) tmp.get(0);
            reformatkey.append(key.get(0));
            reformatkey.append(key.get(1));
            reformatkey.append(key.get(2));
            reformatkey.append(key.get(3));
            reformatkey.append(key.get(4));
            reformatkey.append(key.get(5));
            ((Tuple) res.result).set(0, reformatkey);
            return res;
        }
        
        /**
         * Count the number of each type of key which were sent to the reducer after
         * being combined
         * 
         * @param key
         * @param val
         * @throws ExecException
         */
        private void CombineEstimation(Tuple key, long val) throws ExecException {
            for (int i = 0; i < key.size(); i++)
                if (key.get(i) == null) {
                    tmpCombine[i] += val;
                }
        }

        /**
         * Calculate the "best" pivot position
         * 
         * @throws IOException
         */
        public void closeEstimatedFile(ArrayList<ArrayList<Tuple>> al) throws IOException {
            autopivot = AutoPivotSelection(al);
            log.info("Old autopivot using theta: " + autopivot);
            /*autopivot = 1;
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);

            FSDataOutputStream pPivot = fs.create(new Path("/tmp/partition/pivot"));
            pPivot.writeBytes(String.valueOf(autopivot) + "\n");*/
        }

        public int AutoPivotSelection(ArrayList<ArrayList<Tuple>> al) {
            int minPartition;
            try {
                long[] combineStats = tmpCombine;
                for (int i = 0; i < al.size(); i++) {
                    minimizeSum[i] = partition(al, combineStats, i, al.size() - 1);
                }
                minPartition = 0;
                for (int i = 0; i < al.size(); i++) {
                    if (minimizeSum[i] < (minimizeSum[minPartition] * Math.pow(theta, i - minPartition))) {
                        minPartition = i;
                    }
                }
            } catch (IOException e) {
                return out.length - 1 - 2;
            }

            return minPartition;
        }

        public static class TupleComparator implements Comparator<Tuple> {

            @Override
            public int compare(Tuple o1, Tuple o2) {
                long c1 = 0;
                long c2 = 0;
                try {
                    c1 = (Long) o1.get(o1.size() - 1);
                    c2 = (Long) o2.get(o2.size() - 1);
                } catch (ExecException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (c1 < c2)
                    return -1;
                if (c1 == c2)
                    return 0;
                return 1;
            }

        }

        private long partition(ArrayList<ArrayList<Tuple>> al, long[] combineStats, int p, int l)
                throws IOException {

            Collections.sort(al.get(p), Collections
                    .reverseOrder(new TupleComparator()));

            long maxSum = 0;

            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            FSDataOutputStream pOut = fs.create(new Path("/tmp/partition/p"
                    + String.valueOf(p)));

            if (p == 0) {
                maxSum = (Long) al.get(p).get(0).get(l);
                subofSubSum[p] = maxSum;
            } else {
                //maxSum = combineStats[p-1];
                //maxSum = combineStats[p-1];
                maxSum = al.get(p-1).size();
                long[] subSum = new long[numReducers];
                for (int j = 0; j < numReducers; j++) {
                    subSum[j] = 0;
                }
                subSum[0] = maxSum;
                for (int i = 0; i < al.get(p).size(); i++) {
                    int minIndex = 0;
                    for (int j = 1; j < numReducers; j++) {
                        if (subSum[j] < subSum[minIndex]) {
                            minIndex = j;
                        }
                    }

                    subSum[minIndex] += (Long) al.get(p).get(i).get(l);
                    String wrt = "";
                    for (int k = 0; k < l; k++) {
                        wrt = wrt + al.get(p).get(i).get(k) + "\t";
                    }
                    wrt = wrt + String.valueOf(minIndex) + "\n";
                    pOut.writeBytes(wrt);
                }
                pOut.close();
                for (int i = 0; i < numReducers; i++) {
                    subofSubSum[p] +=subSum[i];
                    //System.out.println("P = " + String.valueOf(p) + ", subSum[" + String.valueOf(i) + "]: "
                    //        + String.valueOf(subSum[i]));
                    if (maxSum < subSum[i]) {
                        maxSum = subSum[i];
                    }
                }
            }
            return maxSum;
        }

        public void processSamplingTuple(Tuple tmpKey, Iterator<NullableTuple> tupIter, int l) throws ExecException {
            if(tmpKey.size() == lengthDimension) {
                if(!(tmpKey.get(0) == null && tmpKey.get(1)!=null)) {
                    TupleFactory mTupleFactory = TupleFactory.getInstance();
                    Tuple bags = mTupleFactory.newTuple();
                    bags.append(tmpKey);
                    while (tupIter.hasNext()) {
                        NullableTuple ntup = tupIter.next();
                        Tuple tup = (Tuple)ntup.getValueAsPigType();
                        bags.append(tup);
                    }
                    CombineEstimation(tmpKey, bags.size() - 1);
                    samList.add(bags);
                }
            } else {
                //System.out.println(tmpKey.toString());
                int counterType = (Integer)tmpKey.get(1);
                if( counterType == 1) {
                    long tMapFinished = (Long)tmpKey.get(13);
                    long tMapWriteA = (Long)tmpKey.get(10);
                    long tMapWrite0 = (Long)tmpKey.get(18);
                    long tMapWrite1 = (Long)tmpKey.get(19);
                    long tMapWrite2 = (Long)tmpKey.get(20);
                    long tMapWrite3 = (Long)tmpKey.get(21);
                    long tMapWrite4 = (Long)tmpKey.get(22);
                    long tMapWrite5 = (Long)tmpKey.get(23);
                    long tMapWrite6 = (Long)tmpKey.get(24);
                    MapWrite0.add((double)tMapWrite0);
                    MapWrite1.add((double)tMapWrite1);
                    MapWrite2.add((double)tMapWrite2);
                    MapWrite3.add((double)tMapWrite3);
                    MapWrite4.add((double)tMapWrite4);
                    MapWrite5.add((double)tMapWrite5);
                    MapWrite6.add((double)tMapWrite6);
                    MapWriteAll.add((double)tMapWriteA);
                    mapFinish.add((double)tMapFinished);
                } else {
                    long tTotal = (Long)tmpKey.get(3);
                    long tSetup = (Long)tmpKey.get(4);
                    long tCleanup = (Long)tmpKey.get(5);
                    long tCbnWrite = (Long)tmpKey.get(6);
                    combineProcesstime.add((double)tTotal);
                    combineWritetime.add((double)tCbnWrite);
                }
            }
        }
        
        public static double[] changeToArray(ArrayList<Double> val) {
            double changed[] = new double[val.size()];
            for (int i = 0; i < val.size(); i++)
                changed[i] = (Double) val.get(i);
            return changed;
        }
        
        public Double LinearCalculate(ArrayList<Double> x, ArrayList<Double> y, int type, double realJob) {
            RegressionModel model = new LinearRegressionModel(changeToArray(x), changeToArray(y),type);
            model.compute();
            double[] coefficients = model.getCoefficients();
            if(type == 1) {
                //System.out.println("input x: " + realJob + " ----> \t" + (coefficients[0] + coefficients[1] * realJob * (Math.log(realJob)/Math.log(2))));
                return (coefficients[0] + coefficients[1] * realJob * (Math.log(realJob)/Math.log(2)));
            }
            else {
                //System.out.println("input x: " + realJob + " ----> \t" + (coefficients[0] + coefficients[1] * realJob));
                return (coefficients[0] + coefficients[1] * realJob);
            }
        }
        
        // return: false-more output
        // true- end of processing
        public boolean processOnePackageOutput(Context oc) throws IOException,
                InterruptedException {

            Result res = pack.getNextTuple();
            if (res.returnStatus == POStatus.STATUS_OK) {
                Tuple packRes = (Tuple) res.result;

                if (rp.isEmpty()) {
                    oc.write(null, packRes);
                    return false;
                }
                for (int i = 0; i < roots.length; i++) {
                    roots[i].attachInput(packRes);
                }
                //long rollupS = System.currentTimeMillis();
                runPipeline(leaf);
                //tRollup+=System.currentTimeMillis() - rollupS;

            }

            if (res.returnStatus == POStatus.STATUS_NULL) {
                return false;
            }

            if (res.returnStatus == POStatus.STATUS_ERR) {
                int errCode = 2093;
                String msg = "Encountered error in package operator while processing group.";
                throw new ExecException(msg, errCode, PigException.BUG);
            }

            if (res.returnStatus == POStatus.STATUS_EOP) {
                return true;
            }

            return false;

        }

        /**
         * @param leaf
         * @throws InterruptedException
         * @throws IOException
         */
        protected void runPipeline(PhysicalOperator leaf)
                throws InterruptedException, IOException {

            while (true) {
                Result redRes = leaf.getNextTuple();
                
                if (redRes.returnStatus == POStatus.STATUS_OK) {
                    try {
                        long tEstS = System.currentTimeMillis();
                        IRGEstimation(redRes);
                        redRes = reformatRes(redRes);
                        tEstimate += System.currentTimeMillis() - tEstS;
                        swTime = System.currentTimeMillis();
                        outputCollector.write(null, (Tuple) redRes.result);
                        writeToDiskTime += System.currentTimeMillis() - swTime;
                    } catch (Exception e) {
                        throw new IOException(e);
                    }
                    continue;
                }

                if (redRes.returnStatus == POStatus.STATUS_EOP) {
                    return;
                }

                if (redRes.returnStatus == POStatus.STATUS_NULL) {
                    continue;
                }

                if (redRes.returnStatus == POStatus.STATUS_ERR) {
                    // remember that we had an issue so that in
                    // close() we can do the right thing
                    errorInReduce = true;
                    // if there is an errmessage use it
                    String msg;
                    if (redRes.result != null) {
                        msg = "Received Error while "
                                + "processing the reduce plan: "
                                + redRes.result;
                    } else {
                        msg = "Received Error while "
                                + "processing the reduce plan.";
                    }
                    int errCode = 2090;
                    throw new ExecException(msg, errCode, PigException.BUG);
                }
            }
        }

        /**
         * Will be called once all the intermediate keys and values are
         * processed. So right place to stop the reporter thread.
         */
        @Override 
        protected void cleanup(Context context) throws IOException,
                InterruptedException {
            super.cleanup(context);
            reduceWholeFtime = System.currentTimeMillis();
            //System.out.println(reduceWholeFtime);
            Configuration jConf = context.getConfiguration();
            if (errorInReduce) {
                // there was an error in reduce - just return
                return;
            }

            if (PigMapReduce.sJobConfInternal.get().get("pig.stream.in.reduce",
                    "false").equals("true")) {
                // If there is a stream in the pipeline we could
                // potentially have more to process - so lets
                // set the flag stating that all map input has been sent
                // already and then lets run the pipeline one more time
                // This will result in nothing happening in the case
                // where there is no stream in the pipeline
                rp.endOfAllInput = true;
                runPipeline(leaf);
            }

            if (!inIllustrator) {
                for (POStore store : stores) {
                    if (!initialized) {
                        MapReducePOStoreImpl impl = new MapReducePOStoreImpl(
                                context);
                        store.setStoreImpl(impl);
                        store.setUp();
                    }
                    store.tearDown();
                }
            }

            // Calling EvalFunc.finish()
            UDFFinishVisitor finisher = new UDFFinishVisitor(rp, new DependencyOrderWalker<PhysicalOperator, PhysicalPlan>(rp));
            
            PORollupH2IRGForEach rollup = (PORollupH2IRGForEach) leaf;
            long samplingS = System.currentTimeMillis();
            Result tmp[] = rollup.finish();
            if (tmp != null) {
                Result res = new Result();
                res.result = rollup.returnRes[rollup.returnRes.length - 1].result;
                res.returnStatus = POStatus.STATUS_OK;
                outputCollector.write(null, (Tuple) res.result);
                rollup.returnRes[rollup.returnRes.length - 1] = null;
                TupleFactory mTupleFactory = TupleFactory.getInstance();
                IRGEstimation(res);
                for (int i = lengthDimension - 1; i >= 0; i--)
                    if (rollup.returnRes[i] != null) {
                        res = new Result();
                        res = rollup.returnRes[i];
                        outputCollector.write(null, (Tuple) res.result);
                        rollup.returnRes[i] = null;
                        Tuple tmpT = mTupleFactory.newTuple();
                        tmpT = (Tuple) res.result;
                        IRGEstimation(res);
                        Tuple last = (Tuple) tmpT.get(0);
                        if (last.get(0) == null) {
                            try {
                                numReducers = rollup.getNumReducer();
                                /*for (int m = 0; m < al.size(); m++)
                                    System.out.println(al.get(m).size());
                                
                                for (int n = 0; n < tmpCombine.length; n++)
                                    System.out.println(tmpCombine[n]);*/
                                closeEstimatedFile(al);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
            long sumRORSampling = 0;
            //for (int i = 0; i < al.size(); i++) {
            //    sumRORSampling+= al.get(i).size();
            //}
            
            long SumMIR = 0;
            long MIR2m = 0;
            JobClient jc = new JobClient(new JobConf(context.getConfiguration()));
            
            TaskReport[] tr = jc.getMapTaskReports(JobID.downgrade(context.getJobID()));
            for (int i = 0; i < tr.length; i++) {
                Counters map = tr[i].getCounters();
                if (i == 0) {
                    MIR2m = map.getCounter(Task.Counter.MAP_INPUT_RECORDS);
                }
                SumMIR  += map.getCounter(Task.Counter.MAP_INPUT_RECORDS);
                MIR.add((double)map.getCounter(Task.Counter.MAP_INPUT_RECORDS));
                MORrjEst.add((double)map.getCounter(Task.Counter.MAP_INPUT_RECORDS)*2);
                MORrjEst7.add((double)map.getCounter(Task.Counter.MAP_INPUT_RECORDS)*7);
                MapWritePv1.add((double)(MapWrite0.get(i) + MapWrite6.get(i)));
                MapWritePv2.add((double)(MapWrite1.get(i) + MapWrite6.get(i)));
                MapWritePv3.add((double)(MapWrite2.get(i) + MapWrite6.get(i)));
                MapWritePv4.add((double)(MapWrite3.get(i) + MapWrite6.get(i)));
                MapWritePv5.add((double)(MapWrite4.get(i) + MapWrite6.get(i)));
                combineRuntime.add((double)(tr[i].getFinishTime() - mapFinish.get(i)));
                mapPhase.add((double)(tr[i].getFinishTime() - tr[i].getStartTime()));
            }
            
            double ratio = 0;
            String variableSplit = jConf.get("pig.h2irg.rollup.variablesplit", "");
            if(variableSplit.equals("")) {
                ratio = 128/2;
            } else {
                String []splitted = variableSplit.split(",");
                ratio = 128*1024*1.0 / Double.parseDouble(splitted[splitted.length - 1]);
            }
            
            //System.out.println(MIR2m);
            long ratioRealJob = 128 / 2;
            //System.out.println(ratioRealJob);
            //System.out.println(ratio);
            long MIRrealJob = (long) (MIR2m*ratio);
            //System.out.println(MIRrealJob);

            
            double combineRate[] = new double[lengthDimension+1];
            combineRate[lengthDimension] = 1.0*al.get(lengthDimension).size()/SumMIR;
            
            String inputFile = jConf.get("pig.input.dirs", "");

            long noOfMap = 0;
            if(inputFile!="") {
                Path pPivot = new Path(inputFile);
                FileSystem fs = FileSystem.get(jConf);
                FileStatus stt = fs.getFileStatus(pPivot);
                long fileLength = stt.getLen();
                noOfMap = fileLength/134217728;
                //System.out.println(fileLength + " " + noOfMap);
            }
            
            double pivotRIRavg = combineRate[lengthDimension]*MIRrealJob*noOfMap/numReducers;
            
            double RIRallmap = pivotRIRavg*numReducers;
            
            /*System.out.println("CombineRate");
            for (int i = 0; i < combineRate.length; i++) 
                System.out.print(combineRate[i] + " \t");
            System.out.println();*/
            
            tSampling+=System.currentTimeMillis() - samplingS;
            
            /*double RIRRORrealjob[] = new double[4];
            double RIRRORsampling[] = new double[4];
            for(int i = 0; i < 4; i++) {
                RIRRORrealjob[i] = pivotRIRreal[i] + pivotRORreal[i];
                RIRRORsampling[i] = pivotRIR[i] + pivotRORCreate[i];
            }*/

            /*System.out.print("MOR \t");
            for (int i  = 0; i < MORrjEst7.size(); i++) {
                System.out.print(MORrjEst7.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapAll \t");
            for (int i  = 0; i < mapPhase.size(); i++) {
                System.out.print(mapPhase.get(i) + "\t");
            }
            
            System.out.println();
            
            System.out.print("MapWrite \t");
            for (int i  = 0; i < MapWriteAll.size(); i++) {
                System.out.print(MapWriteAll.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv0 \t");
            for (int i = 0; i < MapWrite0.size(); i++) {
                System.out.print(MapWrite0.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv1 \t");
            for (int i = 0; i < MapWritePv1.size(); i++) {
                System.out.print(MapWritePv1.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv2 \t");
            for (int i = 0; i < MapWritePv2.size(); i++) {
                System.out.print(MapWritePv2.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv3 \t");
            for (int i = 0; i < MapWritePv3.size(); i++) {
                System.out.print(MapWritePv3.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv4 \t");
            for (int i = 0; i < MapWritePv4.size(); i++) {
                System.out.print(MapWritePv4.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("MapWrite-pv5 \t");
            for (int i = 0; i < MapWritePv5.size(); i++) {
                System.out.print(MapWritePv5.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("CombineAll \t");
            for (int i  = 0; i < combineRuntime.size(); i++) {
                System.out.print(combineRuntime.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("CombineProc \t");
            for (int i  = 0; i < combineProcesstime.size(); i++) {
                System.out.print(combineProcesstime.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("CombineSort \t");
            for (int i  = 0; i < combineRuntime.size(); i++) {
                combineSorttime.add((double)(combineRuntime.get(i) - combineProcesstime.get(i)));
                System.out.print(combineSorttime.get(i) + "\t");
            }
            System.out.println();
            
            System.out.print("CombineWrite \t");
            for (int i  = 0; i < combineWritetime.size(); i++) {
                System.out.print(combineWritetime.get(i) + "\t");
            }
            System.out.println();*/
            
            TaskReport[] trR = jc.getReduceTaskReports(JobID.downgrade(context.getJobID()));
            for (int i = 0; i < trR.length; i++) {
                long RIR = context.getCounter(Task.Counter.REDUCE_INPUT_RECORDS).getValue();
                long ROR = context.getCounter(Task.Counter.REDUCE_OUTPUT_RECORDS).getValue();
                long RSB = context.getCounter(Task.Counter.REDUCE_SHUFFLE_BYTES).getValue();
                long tShuffleSort = reduceWholeStime - trR[i].getStartTime();
                long tTotal = reduceWholeFtime - reduceWholeStime - tSpecial + tRollup - tEstimate;
                
                /*System.out.println("Total full: " + (reduceWholeFtime - reduceWholeStime));
                System.out.println("Rollup: " + tRollup);
                System.out.println("Estimate: " + tEstimate);
                System.out.println("Check tuple: " + tSpecial);
                System.out.println("Write: " + writeToDiskTime);*/
                
                double combineRateTest = (1.0*ROR)/RIR;
                double RORtest = pivotRIRavg*combineRateTest;
                double recordSize = 1.0*RSB/RIR + 3;
                double RSBest = recordSize*pivotRIRavg;
                /*System.out.println("tTotal: \t" + tTotal);
                System.out.println("tSortShuffle: \t" + (tShuffleSort*RSBest/(1.0*RSB)));
                System.out.println("tTotalEst: \t" + (tTotal*pivotRIRavg/(1.0*RIR)));
                System.out.println("RIRest: \t" + pivotRIRavg + " - " + RORtest);

                System.out.println("Number of wave: " + Math.ceil(1.0*noOfMap/40));
                
                
                System.out.println("Test Map Estimation - vanilla output 128mb \n");
                System.out.println(MORrjEst7.get(MORrjEst7.size() - 1)*512);
                System.out.println("Map time of 128MB: " + LinearCalculate(MORrjEst7, MapWriteAll, 0, MORrjEst7.get(MORrjEst7.size() - 1)*512));
                System.out.println("Combine phase time of 128MB: " + LinearCalculate(MORrjEst7, combineRuntime, 0, MORrjEst7.get(MORrjEst7.size() - 1)*512));*/
                //System.out.println("Combine process time of 128MB: " + LinearCalculate(MORrjEst7, combineProcesstime, 0, MORrjEst7.get(MORrjEst7.size() - 1)*512));
                //System.out.println("Combine sort time of 128MB: " + LinearCalculate(MORrjEst7, combineRuntime, 0, MORrjEst7.get(MORrjEst7.size() - 1)*512));
                
                double mw0Est = LinearCalculate(MORrjEst, MapWrite6, 0, MIRrealJob)*(Math.ceil(1.0*noOfMap/40));
                double mw1Est = (LinearCalculate(MORrjEst, MapWritePv1, 0, MIRrealJob*2) + partitionRate[0])*(Math.ceil(1.0*noOfMap/40));
                double mw2Est = (LinearCalculate(MORrjEst, MapWritePv2, 0, MIRrealJob*2) + partitionRate[1])*(Math.ceil(1.0*noOfMap/40));
                double mw3Est = (LinearCalculate(MORrjEst, MapWritePv3, 0, MIRrealJob*2) + partitionRate[2])*(Math.ceil(1.0*noOfMap/40));
                double mw4Est = (LinearCalculate(MORrjEst, MapWritePv4, 0, MIRrealJob*2) + partitionRate[3])*(Math.ceil(1.0*noOfMap/40));
                double mw5Est = (LinearCalculate(MORrjEst, MapWritePv5, 0, MIRrealJob*2) + partitionRate[4])*(Math.ceil(1.0*noOfMap/40));
                
                double mwEst[] = new double[6];
                
                mwEst[0] = mw0Est;
                mwEst[1] = mw1Est;
                mwEst[2] = mw2Est;
                mwEst[3] = mw3Est;
                mwEst[4] = mw4Est;
                mwEst[5] = mw5Est;
                
                /*System.out.println("tWriteEst - pv1: \t" + mw1Est);
                System.out.println("tWriteEst - pv2: \t" + mw2Est);
                System.out.println("tWriteEst - pv3: \t" + mw3Est);
                System.out.println("tWriteEst - pv4: \t" + mw4Est);
                System.out.println("tWriteEst - pv5: \t" + mw5Est);*/
                
                for(int m = 0; m < minimizeSum.length - 1; m++) {
                    //System.out.println("Pivot: " + m);
                    //System.out.println(minimizeSum[m]);
                    //System.out.println(minimizeSum[m] + " " + RIRallmap + " " + subofSubSum[m]);
                    double maxRIRest = (minimizeSum[m]*RIRallmap/(1.0*subofSubSum[m]));
                    double reduceRunEst = (tTotal*maxRIRest)/(1.0*RIR);
                    double reduceShuffleSortEst = (tShuffleSort*maxRIRest/(1.0*RSB));
                    //System.out.println("RIR: \t" + maxRIRest);
                    //System.out.println("tReduce: \t" + reduceRunEst);
                    //System.out.println("tSortShuffle: \t" + reduceShuffleSortEst);
                    totalEstimate[m] = reduceRunEst + reduceShuffleSortEst;
                    //System.out.println("Total: " + totalEstimate[m]);
                    System.out.println("Pivot " + m + ":\t" + maxRIRest + "\t" + reduceShuffleSortEst + "\t" + reduceRunEst + "\t" + totalEstimate[m] + "\t" + mwEst[m]);
                }
                
                double choosePivot[] = new double[lengthDimension + 1];
                for (int m = 0; m < choosePivot.length; m++) {
                    choosePivot[m] = 0;
                }
                choosePivot[1] = mw1Est + totalEstimate[1];
                choosePivot[2] = mw2Est + totalEstimate[2];
                choosePivot[3] = mw3Est + totalEstimate[3];
                choosePivot[4] = mw4Est + totalEstimate[4];
                choosePivot[5] = mw5Est + totalEstimate[5];
                
                double min = choosePivot[1];
                int index = 1;
                for (int m = 1; m < choosePivot.length-1; m++) {
                    if(choosePivot[m] < min) { 
                        min = choosePivot[m];
                        index = m;
                    }
                }
                //System.out.println("Choosen pivot from model: " + index);
                //autopivot = index;
                autopivot = 2;
                FileSystem fs = FileSystem.get(jConf);
                FSDataOutputStream pPivot = fs.create(new Path("/tmp/partition/pivot"));
                pPivot.writeBytes(String.valueOf(autopivot) + "\n");
                log.info("New autopivot using model: " + autopivot);
            }
            
            try {
                finisher.visit();
            } catch (VisitorException e) {
                throw new IOException("Error trying to finish UDFs",e);
            }

            //STOP HERE!!!
/*            System.out.println(MIR4m);
            MIR4m = 6353112;
            System.out.println(SumMIR);
            
            long RORSampling = 0;
            for (int i = 0; i < rollup.al.size(); i++)
                RORSampling += rollup.al.get(i).size(); 
            
            double iglobal = (double)(rollup.al.get(lengthDimension).size())/SumMIR;
            double ipivot1 = (double)(tmpCombine[0])/SumMIR;
            double ipivot2 = (double)(tmpCombine[1])/SumMIR;
            double ipivot3 = (double)(tmpCombine[2])/SumMIR;
            double ipivot4 = (double)(tmpCombine[3])/SumMIR;
            
            double opivot1 = (double)(1.0*rollup.al.get(1).size()/tmpCombine[0]);
            double opivot2 = (double)(1.0*rollup.al.get(2).size()/tmpCombine[1]);
            double opivot3 = (double)(1.0*rollup.al.get(3).size()/tmpCombine[2]);
            double opivot4 = (double)(1.0*rollup.al.get(4).size()/tmpCombine[3]);

            //RIR
            System.out.println("iGlobal real: " + iglobal*MIR4m);
            System.out.println("iPivot1 real: " + ipivot1*MIR4m);
            System.out.println("iPivot2 real: " + ipivot2*MIR4m);
            System.out.println("iPivot3 real: " + ipivot3*MIR4m);
            System.out.println("iPivot4 real: " + ipivot4*MIR4m);
            
            double rirPv1 = iglobal*MIR4m + ipivot1*MIR4m;
            double rirPv2 = iglobal*MIR4m + ipivot2*MIR4m;
            double rirPv3 = iglobal*MIR4m + ipivot3*MIR4m;
            double rirPv4 = iglobal*MIR4m + ipivot4*MIR4m;
            
            //ROR
            System.out.println("oGlobal real: " + iglobal*MIR4m);
            System.out.println("oPivot1 real: " + opivot1*MIR4m);
            System.out.println("oPivot2 real: " + opivot2*MIR4m);
            System.out.println("oPivot3 real: " + opivot3*MIR4m);
            System.out.println("oPivot4 real: " + opivot4*MIR4m);
            
            reduceWholeFtime = System.currentTimeMillis();
            //long tRollup = (reduceWholeFtime - reduceWholeStime - tSampling - writeToDiskTime);
            System.out.println("total: " + (reduceWholeFtime - reduceWholeStime));
            System.out.println("tRollup: " + (tRollup - writeToDiskTime  - PORollupH2IRGForEach.rollupEstimation));
            System.out.println("tSampling: " + tSampling);
            System.out.println("tWrite: " + writeToDiskTime);
            
            TaskReport[] trR = jc.getReduceTaskReports(JobID.downgrade(context
                    .getJobID()));
            System.out.println(trR.length);
            for (int i = 0; i < trR.length; i++) {
                long RIR = context.getCounter(Task.Counter.REDUCE_INPUT_RECORDS).getValue();
                long ROR = context.getCounter(Task.Counter.REDUCE_OUTPUT_RECORDS).getValue();
                long tShuffleSort = reduceWholeStime - trR[i].getStartTime();
                
                System.out.println("pivot1");
                double rirrorpv1 = rirPv1*178/20 + 32488819;
                double tWritepv1 = (writeToDiskTime)*32488819/ROR;
                
                double tRolluppv1 = (tRollup - writeToDiskTime - PORollupH2IRGForEach.rollupEstimation)*rirrorpv1/(tmpCombine[0]+rollup.al.get(lengthDimension).size()+RORSampling);
                double tShuffleSortpv1 = tShuffleSort*rirPv1/RIR;
                System.out.println("rirrorpv2: " + rirrorpv1);
                System.out.println("write: " + tWritepv1);
                System.out.println("rollup: " + tRolluppv1);
                System.out.println("shuffle-sort: " + tShuffleSortpv1);
                System.out.println("total: " + (tWritepv1 + tRolluppv1 + tShuffleSortpv1));
                
                System.out.println("pivot2");
                double rirrorpv2 = rirPv2*178/20 + 32488819;
                double tWritepv2 = (writeToDiskTime)*32488819/ROR;
                
                double tRolluppv2 = (tRollup - writeToDiskTime - PORollupH2IRGForEach.rollupEstimation)*rirrorpv2/(tmpCombine[1]+rollup.al.get(lengthDimension).size()+RORSampling);
                double tShuffleSortpv2 = tShuffleSort*rirPv2/RIR;
                System.out.println("rirrorpv2: " + rirrorpv2);
                System.out.println("write: " + tWritepv2);
                System.out.println("rollup: " + tRolluppv2);
                System.out.println("shuffle-sort: " + tShuffleSortpv2);
                System.out.println("total: " + (tWritepv2 + tRolluppv2 + tShuffleSortpv2));
                
                System.out.println("pivot3");
                double rirrorpv3 = rirPv2*178/20 + 32488819;
                double tWritepv3 = (writeToDiskTime)*32488819/ROR;
                
                double tRolluppv3 = (tRollup - writeToDiskTime - PORollupH2IRGForEach.rollupEstimation)*rirrorpv3/(tmpCombine[2]+rollup.al.get(lengthDimension).size()+RORSampling);
                double tShuffleSortpv3 = tShuffleSort*rirPv3/RIR;
                System.out.println("rirrorpv3: " + rirrorpv3);
                System.out.println("write: " + tWritepv3);
                System.out.println("rollup: " + tRolluppv3);
                System.out.println("shuffle-sort: " + tShuffleSortpv3);
                System.out.println("total: " + (tWritepv3 + tRolluppv3 + tShuffleSortpv3));
            }*/
            
            /*String PSformat = PigInputSplitFormat.class.getName();
            // try {
            // if (context.getInputFormatClass().getName().equals(PSformat)) {
            JobClient jc = new JobClient(
                    new JobConf(context.getConfiguration()));
            TaskReport[] tr = jc.getMapTaskReports(JobID.downgrade(context
                    .getJobID()));
            System.out.println(tr.length);
            for (int i = 0; i < tr.length; i++) {
                System.out.println("\n");
                System.out.println("Whole Map Process " + i);
                System.out.println("start: " + tr[i].getStartTime()
                        + " -- finish: " + tr[i].getFinishTime()
                        + " -- total: "
                        + (tr[i].getFinishTime() - tr[i].getStartTime()));
                Counters map = tr[i].getCounters();
                if(data!=null) {
                    data.TotalMapPhase.add((double)(tr[i].getFinishTime() - tr[i].getStartTime()));
                    data.MIR.add((double)map.getCounter(Task.Counter.MAP_INPUT_RECORDS));
                    data.MOR.add((double)map.getCounter(Task.Counter.MAP_OUTPUT_RECORDS));
                    data.COR.add((double)map.getCounter(Task.Counter.COMBINE_OUTPUT_RECORDS));
                    data.MIRMOR.add((double)(map.getCounter(Task.Counter.MAP_INPUT_RECORDS) + map.getCounter(Task.Counter.MAP_OUTPUT_RECORDS)));
                    data.MORCOR.add((double)(map.getCounter(Task.Counter.MAP_OUTPUT_RECORDS) + map.getCounter(Task.Counter.COMBINE_OUTPUT_RECORDS)));
                }
            }

            //Create CombinerSort
            //if(data!=null) {
            for(int i = 0; i < data.MapSetupT.size(); i++) {
                data.CombineSort.add(data.CombineSetupT.get(i) - data.MapCleanupT.get(i));
                data.starCaching.add(data.starPOSampling.get(i) - data.CastProj.get(i) - data.Rollup.get(i));
            }
            
            String ReadParse = "ReadParse: \t";
            String POSampling = "POSampling: \t";
            String StarPOSampling = "POSampling*: \t";
            String CachePoSampling = "CachePOSampling: \t";
            String CastProj = "CastProj: \t";
            String Rollup = "Rollup: \t";
            String Caching = "Caching: \t";
            String StarCaching = "Caching*: \t";
            String PreCombiner = "PreCombiner: \t";
            String StarPreCombiner = "PreCombiner*: \t";
            String LocalRearrange = "LocalRearrange: \t";
            String MapFunc = "MapFunc: \t";
            String MapWrite = "MapWrite: \t";
            String MapTotal = "MapTotal: \t";
            String MapWrite0 = "MapWrite0: \t";
            String MapWrite1 = "MapWrite1: \t";
            String MapWrite2 = "MapWrite2: \t";
            String MapWrite3 = "MapWrite3: \t";
            String MapWrite4 = "MapWrite4: \t";
            String MapWrite5 = "MapWrite5: \t";
            String MapWrite6 = "MapWrite6: \t";

            String CombineSort = "CombineSort: \t";
            String CombineWrite = "CombineWrite: \t";
            String CombineProcess = "CombineProcess: \t";
            String CombineTotal = "CombineTotal: \t";
            
            String TotalMapPhase = "TotalMap: \t";
            
            String MIR = "MIR: \t";
            String MOR = "MOR: \t";
            String COR = "COR: \t";
            
            int count = 0;
            
            while(count < data.POSampling.size()) {
                ReadParse += data.ReadParse.get(count) + "\t";
                POSampling += data.POSampling.get(count) + "\t";
                StarPOSampling += data.starPOSampling.get(count) + "\t";
                CachePoSampling += data.POCacheSampling.get(count) + "\t";
                CastProj += data.CastProj.get(count) + "\t";
                Rollup += data.Rollup.get(count) + "\t";
                Caching += data.Caching.get(count) + "\t";
                StarCaching += data.starCaching.get(count) + "\t";
                PreCombiner += data.PreCombiner.get(count) + "\t";
                StarPreCombiner += data.starPreCombiner.get(count) + "\t";
                LocalRearrange += data.LocalRearrange.get(count) + "\t";
                MapFunc += data.MapFunc.get(count) + "\t";
                MapWrite += data.MapWrite.get(count) + "\t";
                MapTotal += data.MapTotal.get(count) + "\t";
                CombineSort += data.CombineSort.get(count) + "\t";
                CombineWrite += data.CombineWrite.get(count) + "\t";
                CombineProcess += data.CombineProcess.get(count) + "\t";
                CombineTotal += data.CombineTotal.get(count) + "\t";
                TotalMapPhase += data.TotalMapPhase.get(count) + "\t";
                MIR += data.MIR.get(count) + "\t";
                MOR += data.MOR.get(count) + "\t";
                COR += data.COR.get(count) + "\t";
                
                MapWrite0 += data.MapWrite0.get(count) + "\t";
                MapWrite1 += data.MapWrite1.get(count) + "\t";
                MapWrite2 += data.MapWrite2.get(count) + "\t";
                MapWrite3 += data.MapWrite3.get(count) + "\t";
                MapWrite4 += data.MapWrite4.get(count) + "\t";
                MapWrite5 += data.MapWrite5.get(count) + "\t";
                MapWrite6 += data.MapWrite6.get(count) + "\t";
                
                count++;
            }
            System.out.println(ReadParse);
            //System.out.println(POSampling);
            //System.out.println(StarPOSampling);
            //System.out.println(CachePoSampling);
            System.out.println(CastProj);
            System.out.println(Rollup);
            System.out.println(Caching);
            //System.out.println(StarCaching);
            System.out.println(PreCombiner);
            //System.out.println(StarPreCombiner);
            System.out.println(LocalRearrange);
            System.out.println(MapFunc);
            System.out.println(MapWrite);
            System.out.println(MapTotal);
            System.out.println(CombineSort);
            System.out.println(CombineWrite);
            System.out.println(CombineProcess);
            System.out.println(CombineTotal);
            System.out.println(TotalMapPhase);
            System.out.println(MIR);
            System.out.println(MOR);
            System.out.println(COR);
            
            double MIRrj = data.MIR.get(0)*32;
            double MIRMORrj = data.MIR.get(0)*3*32;
            double MORrj = data.MIR.get(0)*2*32;
            //double CORrj = (MORrj * data.COR.get(0))/ data.MOR.get(0);
            double CORrj = MORrj / 2;
            double MORCORrj = MORrj + CORrj;
            //Linear Regression
            System.out.println(" --- ReadParse --- ");
            data.LinearCalculate(data.MIR, data.ReadParse, 0, MIRrj);
            
            System.out.println(" --- CastProj --- ");
            data.LinearCalculate(data.MIR, data.CastProj, 0, MIRrj);
            
            System.out.println(" --- Rollup --- ");
            data.LinearCalculate(data.MIRMOR, data.Rollup, 0, MIRMORrj);
            
            System.out.println(" --- Caching --- ");
            data.LinearCalculate(data.MIRMOR, data.Caching, 0, MIRMORrj);
            
            System.out.println(" --- PreCombiner --- ");
            data.LinearCalculate(data.MOR, data.PreCombiner, 0, MORrj);
            
            System.out.println(" --- LocalRearrange --- ");
            data.LinearCalculate(data.MOR, data.LocalRearrange, 0, MORrj);
            
            System.out.println(" --- MapFunc --- ");
            data.LinearCalculate(data.MIRMOR, data.MapFunc, 0, MIRMORrj);
            
            System.out.println(" --- MapWrite --- ");
            data.LinearCalculate(data.MOR, data.MapWrite, 0, MORrj);
            
            System.out.println(" --- CombineWrite --- ");
            data.LinearCalculate(data.COR, data.CombineWrite, 0, CORrj);
            
            System.out.println(" --- CombinerProcess --- ");
            data.LinearCalculate(data.MORCOR, data.CombineProcess, 0, MORCORrj);
            
            System.out.println(" --- CombinerSort --- ");
            data.LinearCalculate(data.MOR, data.CombineSort, 1, MORrj);
            
            System.out.println(" --- TotalCombine --- ");
            data.LinearCalculate(data.MORCOR, data.CombineTotal, 0, MORCORrj);
            
            System.out.println(" --- TotalMap --- ");
            data.LinearCalculate(data.MIRMOR, data.MapTotal, 0, MIRMORrj);
            
            System.out.println(" --- TotalMapPhase --- ");
            data.LinearCalculate(data.MIRMOR, data.TotalMapPhase, 0, MIRMORrj);
            
            System.out.println(" --- MapWrite0 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite0, 0, MIRrj);
            
            System.out.println(" --- MapWrite1 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite1, 0, MIRrj);
            
            System.out.println(" --- MapWrite2 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite2, 0, MIRrj);
            
            System.out.println(" --- MapWrite3 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite3, 0, MIRrj);
            
            System.out.println(" --- MapWrite4 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite4, 0, MIRrj);
            
            System.out.println(" --- MapWrite5 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite5, 0, MIRrj);
            
            System.out.println(" --- MapWrite6 --- ");
            data.LinearCalculate(data.MIR, data.MapWrite6, 0, MIRrj);
            
            //}
            TaskReport[] trR = jc.getReduceTaskReports(JobID.downgrade(context
                    .getJobID()));
            System.out.println(trR.length);
            for (int i = 0; i < trR.length; i++) {
                System.out.println("\n");
                System.out.println("Whole Reduce Process");
                System.out.println("start: " + trR[i].getStartTime());
                System.out.println("RIR: "
                        + context.getCounter(Task.Counter.REDUCE_INPUT_RECORDS)
                                .getValue()
                        + " -- ROR: "
                        + context
                                .getCounter(Task.Counter.REDUCE_OUTPUT_RECORDS)
                                .getValue());
            }
            PhysicalOperator.setReporter(null);
            initialized = false;
            reduceWholeFtime = System.currentTimeMillis();
            System.out.println("reduce WriteToDisk Time: " + writeToDiskTime);
            System.out.println("reduce - setup - time: " + reduceWholeStime);
            System.out.println("reduce - cleanup - time: " + reduceWholeFtime);
            System.out.println("total: " + (reduceWholeFtime - reduceWholeStime));
            System.out.println("reduce processing time: " + (reduceWholeFtime - reduceWholeStime - writeToDiskTime));
            System.out.println("reduceFunc: " + reduceFunc);
            System.out.println("writeToDisktTime: " + writeToDiskTime);
            System.out.println("RollupCombinerPackage: " + PORollupCombinerPackage.samplingCombiner);
            System.out.println("RollupH2IRGForEach: " + PORollupH2IRGForEach.rollupEstimation);
            System.out.println("reduce rollup processing time: " + (reduceFunc - writeToDiskTime - PORollupCombinerPackage.samplingCombiner - PORollupH2IRGForEach.rollupEstimation));
            
            long sumMIR = 0;
            for (int i = 0; i < data.MIR.size(); i++)
                sumMIR += data.MIR.get(i);
            System.out.println("Sum MIR: " + sumMIR);
            PORollupH2IRGForEach leafIns = null;
            if(leaf instanceof PORollupH2IRGForEach)
                leafIns = (PORollupH2IRGForEach) leaf;
            for (int i = 0; i < leafIns.al.size(); i++) {
                System.out.println(((double)leafIns.al.get(i).size()/sumMIR)*MIRrj);
            }*/
            
        }
        
        /**
         * Get reducer's illustrator context
         * 
         * @param input
         *            Input buffer as output by maps
         * @param pkg
         *            package
         * @return reducer's illustrator context
         * @throws IOException
         * @throws InterruptedException
         */
        abstract public Context getIllustratorContext(Job job,
                List<Pair<PigNullableWritable, Writable>> input, POPackage pkg)
                throws IOException, InterruptedException;

        abstract public boolean inIllustrator(Context context);

        abstract public POPackage getPack(Context context);
    }
    
    /**
     * This "specialized" reduce class is ONLY to be used in pig queries with
     * order by a udf. A UDF used for comparison in the order by expects
     * to be handed tuples. Hence a specialized map class (PigMapReduce.MapWithComparator)
     * ensures that the "key" used in the order by is wrapped into a tuple (if it 
     * isn't already a tuple). This reduce class unwraps this tuple in the case where
     * the map had wrapped into a tuple and handes the "unwrapped" key to the POPackage
     * for processing
     */
    public static class ReduceWithComparator extends PigMapReduce.Reduce {
        
        private byte keyType;
        
        /**
         * Configures the Reduce plan, the POPackage operator
         * and the reporter thread
         */
        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            super.setup(context);
            keyType = pack.getKeyType();
        }

        /**
         * The reduce function which packages the key and List&lt;Tuple&gt;
         * into key, Bag&lt;Tuple&gt; after converting Hadoop type key into Pig type.
         * The package result is either collected as is, if the reduce plan is
         * empty or after passing through the reduce plan.
         */
        @Override
        protected void reduce(PigNullableWritable key, Iterable<NullableTuple> tupIter, Context context) 
                throws IOException, InterruptedException {
            
            if (!initialized) {
                initialized = true;
                
                // cache the collector for use in runPipeline()
                // which could additionally be called from close()
                this.outputCollector = context;
                pigReporter.setRep(context);
                PhysicalOperator.setReporter(pigReporter);

                boolean aggregateWarning = "true".equalsIgnoreCase(pigContext.getProperties().getProperty("aggregate.warning"));
                
                PigHadoopLogger pigHadoopLogger = PigHadoopLogger.getInstance();
                pigHadoopLogger.setAggregate(aggregateWarning);
                PigStatusReporter.setContext(context);
                pigHadoopLogger.setReporter(PigStatusReporter.getInstance());

                PhysicalOperator.setPigLogger(pigHadoopLogger);
                
                for (POStore store: stores) {
                    MapReducePOStoreImpl impl 
                        = new MapReducePOStoreImpl(context);
                    store.setStoreImpl(impl);
                    store.setUp();
                }
            }
            
            // If the keyType is not a tuple, the MapWithComparator.collect()
            // would have wrapped the key into a tuple so that the 
            // comparison UDF used in the order by can process it.
            // We need to unwrap the key out of the tuple and hand it
            // to the POPackage for processing
            if(keyType != DataType.TUPLE) {
                Tuple t = (Tuple)(key.getValueAsPigType());
                try {
                    key = HDataType.getWritableComparableTypes(t.get(0), keyType);
                } catch (ExecException e) {
                    throw e;
                }
            }
            
            pack.attachInput(key, tupIter.iterator());
            
            Result res = pack.getNextTuple();
            if(res.returnStatus==POStatus.STATUS_OK){
                Tuple packRes = (Tuple)res.result;
                
                if(rp.isEmpty()){
                    context.write(null, packRes);
                    return;
                }
                
                rp.attachInput(packRes);

                List<PhysicalOperator> leaves = rp.getLeaves();
                
                PhysicalOperator leaf = leaves.get(0);
                runPipeline(leaf);
                
            }
            
            if(res.returnStatus==POStatus.STATUS_NULL) {
                return;
            }
            
            if(res.returnStatus==POStatus.STATUS_ERR){
                int errCode = 2093;
                String msg = "Encountered error in package operator while processing group.";
                throw new ExecException(msg, errCode, PigException.BUG);
            }

        }

    }
   
}
