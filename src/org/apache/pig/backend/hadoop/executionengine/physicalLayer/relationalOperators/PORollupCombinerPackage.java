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
package org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.pig.builtin.LinearRegressionModel;
import org.apache.pig.builtin.RegressionModel;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigMapReduce;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.POStatus;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.Result;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans.PhyPlanVisitor;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.InternalCachedBag;
import org.apache.pig.data.NonSpillableDataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.io.NullableTuple;
import org.apache.pig.impl.plan.NodeIdGenerator;
import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.plan.VisitorException;
import org.apache.pig.impl.util.Pair;
/**
 * The package operator that packages the globally rearranged tuples into
 * output format after the combiner stage.  It differs from POPackage in that
 * it does not use the index in the NullableTuple to find the bag to put a
 * tuple in.  Instead, the inputs are put in a bag corresponding to their 
 * offset in the tuple.
 */
public class PORollupCombinerPackage extends POPackage {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static BagFactory mBagFactory = BagFactory.getInstance();
    private static TupleFactory mTupleFactory = TupleFactory.getInstance();

    private boolean[] mBags; // For each field, indicates whether or not it
                             // needs to be put in a bag.
    
    private Map<Integer, Integer> keyLookup;
    
    private int numBags;
    
    private boolean isSampler = false;
    
    private boolean fromReduce = false;
    
    public ArrayList<Double> ReadParse = new ArrayList<Double>();
    public ArrayList<Double> POCacheSampling = new ArrayList<Double>();
    public ArrayList<Double> POSampling = new ArrayList<Double>();
    public ArrayList<Double> starPOSampling = new ArrayList<Double>();
    public ArrayList<Double> CastProj = new ArrayList<Double>();
    public ArrayList<Double> Rollup = new ArrayList<Double>();
    public ArrayList<Double> Caching = new ArrayList<Double>();
    public ArrayList<Double> starCaching = new ArrayList<Double>();
    public ArrayList<Double> PreCombiner = new ArrayList<Double>();
    public ArrayList<Double> starPreCombiner = new ArrayList<Double>();
    public ArrayList<Double> LocalRearrange = new ArrayList<Double>();
    public ArrayList<Double> MapFunc = new ArrayList<Double>();
    public ArrayList<Double> MapWrite = new ArrayList<Double>();
    public ArrayList<Double> MapTotal = new ArrayList<Double>();
    public ArrayList<Double> MapSetupT = new ArrayList<Double>();
    public ArrayList<Double> MapCleanupT = new ArrayList<Double>();
    
    public ArrayList<Double> MapWrite0 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite1 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite2 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite3 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite4 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite5 = new ArrayList<Double>();
    public ArrayList<Double> MapWrite6 = new ArrayList<Double>();
    
    public ArrayList<Double> CombineWrite = new ArrayList<Double>();
    public ArrayList<Double> CombineTotal = new ArrayList<Double>();
    public ArrayList<Double> CombineSetupT = new ArrayList<Double>();
    public ArrayList<Double> CombineCleanupT = new ArrayList<Double>();
    public ArrayList<Double> CombineProcess = new ArrayList<Double>();
    public ArrayList<Double> CombineSort = new ArrayList<Double>();
    
    public ArrayList<Double> MIR = new ArrayList<Double>();
    public ArrayList<Double> MOR = new ArrayList<Double>();
    public ArrayList<Double> COR = new ArrayList<Double>();
    public ArrayList<Double> MIRMOR = new ArrayList<Double>();
    public ArrayList<Double> MORCOR = new ArrayList<Double>();
    
    public ArrayList<Double> TotalMapPhase = new ArrayList<Double>();
    
    public static long samplingCombiner = 0;
    
    public void setFromReduce(boolean fr) {
        this.fromReduce = fr;
    }

    public boolean getFromReduce() {
        return this.fromReduce;
    }
    
    public void setIsSampler(boolean is) {
        this.isSampler = is;
    }

    public boolean getIsSamper() {
        return this.isSampler;
    }
    
    /**
     * A new POPostCombinePackage will be constructed as a near clone of the
     * provided POPackage.
     * @param pkg POPackage to clone.
     * @param bags for each field, indicates whether it should be a bag (true)
     * or a simple field (false).
     */
    public PORollupCombinerPackage(POPackage pkg, boolean[] bags) {
        super(new OperatorKey(pkg.getOperatorKey().scope,
            NodeIdGenerator.getGenerator().getNextNodeId(pkg.getOperatorKey().scope)),
            pkg.getRequestedParallelism(), pkg.getInputs());
        resultType = pkg.getResultType();
        keyType = pkg.keyType;
        numInputs = 1;
        inner = new boolean[1];
        for (int i = 0; i < pkg.inner.length; i++) {
            inner[i] = true;
        }
        if (bags != null) {
            mBags = Arrays.copyOf(bags, bags.length);
        }
        numBags = 0;
        for (int i = 0; i < mBags.length; i++) {
            if (mBags[i]) numBags++;            
        }
    }

    @Override
    public String name() {
        return "PORollupCombinerPackage" + "[" + DataType.findTypeName(resultType) + "]" + "{" + DataType.findTypeName(keyType) + "}" +" - " + mKey.toString();
    }
    
    @Override
    public void visit(PhyPlanVisitor v) throws VisitorException {
        v.visitRollupCombinerPackage(this);
    }
    
    /**
     * @param keyInfo the keyInfo to set
     */
    public void setKeyInfo(Map<Integer, Pair<Boolean, Map<Integer, Integer>>> keyInfo) {
        this.keyInfo = keyInfo;
        // TODO: IMPORTANT ASSUMPTION: Currently we only combine in the
        // group case and not in cogroups. So there should only
        // be one LocalRearrange from which we get the keyInfo for
        // which field in the value is in the key. This LocalRearrange
        // has an index of 0. When we do support combiner in Cogroups
        // THIS WILL NEED TO BE REVISITED.
        Pair<Boolean, Map<Integer, Integer>> lrKeyInfo =
            keyInfo.get(0); // assumption: only group are "combinable", hence index 0
        keyLookup = lrKeyInfo.second;
    }

    private DataBag createDataBag(int numBags) {
        String bagType = null;
        if (PigMapReduce.sJobConfInternal.get() != null) {
               bagType = PigMapReduce.sJobConfInternal.get().get("pig.cachedbag.type");                   
           }
                                                         
        if (bagType != null && bagType.equalsIgnoreCase("default")) {
            return new NonSpillableDataBag();
        }
        return new InternalCachedBag(numBags);      
    }
    
    @Override
    public Result getNextTuple() throws ExecException {
        int keyField = -1;
        //Create numInputs bags
        Object[] fields = new Object[mBags.length];
        for (int i = 0; i < mBags.length; i++) {
            if (mBags[i]) fields[i] = createDataBag(numBags);
        }
        
        // For each indexed tup in the inp, split them up and place their
        // fields into the proper bags.  If the given field isn't a bag, just
        // set the value as is.
        while (tupIter.hasNext()) {
            NullableTuple ntup = tupIter.next();
            //System.out.println("POCbnPkg: " + ntup.toString());
            Tuple tup = (Tuple)ntup.getValueAsPigType();
            
            int tupIndex = 0; // an index for accessing elements from 
                              // the value (tup) that we have currently
            for(int i = 0; i < mBags.length; i++) {
                Integer keyIndex = keyLookup.get(i);
                if(keyIndex == null && mBags[i]) {
                    // the field for this index is not the
                    // key - so just take it from the "value"
                    // we were handed - Currently THIS HAS TO BE A BAG
                    // In future if this changes, THIS WILL NEED TO BE
                    // REVISITED.
                    ((DataBag)fields[i]).add((Tuple)tup.get(tupIndex));
                    tupIndex++;
                } else {
                    // the field for this index is in the key
                    fields[i] = key;
                }
            }
        }
        
        // The successor of the PORollupCombinerPackage as of 
        // now SHOULD be a POForeach which has been adjusted
        // to look for its inputs by projecting from the corresponding
        // positions in the PORollupCombinerPackage output.
        // So we will NOT be adding the key in the result here but merely 
        // putting all bags into a result tuple and returning it. 
        Tuple res;
        
        res = mTupleFactory.newTuple(mBags.length);
        for (int i = 0; i < mBags.length; i++) res.set(i, fields[i]);
        //if(this.isSampler && this.fromReduce)
        //Change the values after combining for each key to 1
        //this is used for counting and estimating the pivot position
        //long cbnStart = System.currentTimeMillis();
        /*{
            InternalCachedBag original = (InternalCachedBag)fields[1];
            InternalCachedBag forSample = new InternalCachedBag(1);
            TupleFactory mTupleFactory = TupleFactory.getInstance();
            Tuple tmp = mTupleFactory.newTuple();
            tmp.append(1);
            for(int i = 0; i < original.size(); i++)
                forSample.add(tmp);
            res.set(1, forSample);
        }*/
        
        /*Tuple special = (Tuple) res.get(0);
        if(special.get(0) == null && special.get(1)!=null) {
            //System.out.println(res.toString());
            if((Integer)special.get(1)==1) {
                String taskID = (String)special.get(2);
                long tPOSampling = (Long)special.get(3);
                long tCastProj = (Long)special.get(4);
                long tRollup = (Long)special.get(5);
                long tCaching = (Long)special.get(6);
                long tPreCombiner = (Long)special.get(7);
                long tLocalRearrange = (Long)special.get(8);
                long tMapFunc = (Long)special.get(9);
                long tMapWrite = (Long)special.get(10);
                long tTotal = (Long)special.get(11);
                long setupTime = (Long)special.get(12);
                long cleanupTime = (Long)special.get(13);
                long sPreCombiner = (Long)special.get(14);
                long sPOSampling = (Long)special.get(15);
                long tReadParse = (Long)special.get(16);
                long tCachePOSampling = (Long)special.get(17);
                long tMapWrite0 = (Long)special.get(18);
                long tMapWrite1 = (Long)special.get(19);
                long tMapWrite2 = (Long)special.get(20);
                long tMapWrite3 = (Long)special.get(21);
                long tMapWrite4 = (Long)special.get(22);
                long tMapWrite5 = (Long)special.get(23);
                long tMapWrite6 = (Long)special.get(24);
                POSampling.add((double)tPOSampling);
                CastProj.add((double)tCastProj);
                Rollup.add((double)tRollup);
                Caching.add((double)tCaching);
                PreCombiner.add((double)tPreCombiner);
                LocalRearrange.add((double)tLocalRearrange);
                MapFunc.add((double)tMapFunc);
                MapWrite.add((double)tMapWrite);
                MapTotal.add((double)tTotal);
                MapSetupT.add((double)setupTime);
                MapCleanupT.add((double)cleanupTime);
                starPreCombiner.add((double)sPreCombiner);
                starPOSampling.add((double)sPOSampling);
                ReadParse.add((double)tReadParse);
                POCacheSampling.add((double)tCachePOSampling);
                MapWrite0.add((double)tMapWrite0);
                MapWrite1.add((double)tMapWrite1);
                MapWrite2.add((double)tMapWrite2);
                MapWrite3.add((double)tMapWrite3);
                MapWrite4.add((double)tMapWrite4);
                MapWrite5.add((double)tMapWrite5);
                MapWrite6.add((double)tMapWrite6);
            } else if ((Integer)special.get(1) == 2) {
                long combineWTime = (Long)special.get(3);
                long tTotal = (Long)special.get(4);
                long setupTime = (Long)special.get(5);
                CombineWrite.add((double)combineWTime);
                CombineTotal.add((double)tTotal);
                CombineSetupT.add((double)setupTime);
                CombineCleanupT.add((double)(setupTime - tTotal));
                CombineProcess.add((double)(tTotal-combineWTime));
            }
        }*/
        //samplingCombiner += System.currentTimeMillis() - cbnStart;
        Result r = new Result();
        //System.out.println("Return in POCbnPkg: " + res.toString());
        r.result = res;
        r.returnStatus = POStatus.STATUS_OK;
        return r;
    }

    public static double[] changeToArray(ArrayList<Double> val) {
        double changed[] = new double[val.size()];
        for (int i = 0; i < val.size(); i++)
            changed[i] = (Double) val.get(i);
        return changed;
    }
    
    public void testFinish() throws ExecException {
        System.out.println(POSampling);
    }
    
    public void LinearCalculate(ArrayList<Double> x, ArrayList<Double> y, int type, double realJob) {
        RegressionModel model = new LinearRegressionModel(changeToArray(x), changeToArray(y),type);
        model.compute();
        double[] coefficients = model.getCoefficients();
        if(type == 1)
            System.out.println("input x: " + realJob + " ----> \t" + (coefficients[0] + coefficients[1] * realJob * (Math.log(realJob)/Math.log(2))));
        else
            System.out.println("input x: " + realJob + " ----> \t" + (coefficients[0] + coefficients[1] * realJob));
    }
}
