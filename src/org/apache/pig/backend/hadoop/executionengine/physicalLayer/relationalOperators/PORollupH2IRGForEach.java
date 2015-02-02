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

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.pig.PigException;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigGenericMapBaseRollupSample;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.POStatus;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.PhysicalOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.Result;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.ExpressionOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.POProject;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.PORelationToExprProject;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.POUserFunc;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans.PhyPlanVisitor;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans.PhysicalPlan;
import org.apache.pig.builtin.RollupDimensions;
import org.apache.pig.data.AccumulativeBag;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.InternalCachedBag;
import org.apache.pig.data.SchemaTupleClassGenerator.GenContext;
import org.apache.pig.data.SchemaTupleFactory;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.data.TupleMaker;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.impl.plan.DependencyOrderWalker;
import org.apache.pig.impl.plan.NodeIdGenerator;
import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.plan.VisitorException;
import org.apache.pig.pen.util.ExampleTuple;
import org.apache.pig.pen.util.LineageTracer;

/**
 * This class provides a new ForEach physical operator to handle the ROLLUP with
 * hybrid IRG when the Rollup Optimizer is activated. This class contains almost
 * the same as POForEach class excepts some functions for the Hybrid IRG stuffs.
 */
// We intentionally skip type checking in backend for performance reasons
@SuppressWarnings("unchecked")
public class PORollupH2IRGForEach extends POForEach {
    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory
            .getLog(PORollupH2IRGForEach.class);

    public List<PhysicalPlan> inputPlans;
    protected List<PhysicalOperator> opsToBeReset;

    protected static final TupleFactory mTupleFactory = TupleFactory
            .getInstance();

    // Since the plan has a generate, this needs to be maintained
    // as the generate can potentially return multiple tuples for
    // same call.
    protected boolean processingPlan = false;

    // its holds the iterators of the databags given by the input expressions
    // which need flattening.
    transient protected Iterator<Tuple>[] its = null;

    // This holds the outputs given out by the input expressions of any datatype
    protected Object[] bags = null;

    // This is the template whcih contains tuples and is flattened out in
    // createTuple() to generate the final output
    protected Object[] data = null;

    // store result types of the plan leaves
    protected byte[] resultTypes = null;

    // store whether or not an accumulative UDF has terminated early
    protected BitSet earlyTermination = null;

    // array version of isToBeFlattened - this is purely
    // for optimization - instead of calling isToBeFlattened.get(i)
    // we can do the quicker array access - isToBeFlattenedArray[i].
    // Also we can store "boolean" values rather than "Boolean" objects
    // so we can also save on the Boolean.booleanValue() calls
    protected boolean[] isToBeFlattenedArray;

    ExampleTuple tIn = null;
    protected int noItems;

    protected PhysicalOperator[] planLeafOps = null;

    protected transient AccumulativeTupleBuffer buffer;

    protected Tuple inpTuple;

    private Schema schema;

    // start adding new variables

    // The first tuple that stores the value of the previous Rollup Dimension
    // for the first IRG
    protected Tuple prevRollupDimension = null;

    // The second tuple that stores the value of the previous Rollup Dimension
    // for the second IRG
    protected Tuple prevRollupDimension2 = null;

    protected Tuple currentRollupDimension = null;

    // This holds the payload values for the first IRG
    protected DataBag[][] tmpResult;

    // This holds the payload values for the second IRG
    protected DataBag[][] tmpResult2;

    // This holds the result tuples for the first IRG
    public Result[] returnRes;

    // This holds the result tuples for the second IRG
    protected Result[] returnRes2;

    // To check if we can work on the second IRG or not
    protected boolean secondPass = false;

    // The pivot position of the rollup operation
    protected int pivot = -1;

    // To check if we finished the first IRG or not
    protected boolean finIRG1 = false;

    // To check if we finished the second IRG or not
    protected boolean finIRG2 = false;

    protected int noUserFunc = 0;

    protected int dimensionSize = 0;

    // These variables below are used in case the rollup operation has been
    // moved to the end of the operation list.
    protected int rollupFieldIndex = 0;

    protected boolean modified_pivot = false;

    protected boolean onlyIRG = false;

    public int conditionPosition = 0;

    protected int rollupSize = 0;

    protected int rollupOldFieldIndex = 0;

    protected Integer output_index[] = null;

    protected boolean finished = false;

    protected boolean isSampler = false;

    protected boolean isIRGSample = false;

    protected Path d[] = null;

    protected FSDataOutputStream out[] = null;

    protected Path sum = null;

    protected FSDataOutputStream sumout = null;

    protected ArrayList<Result> test = null;

    public ArrayList<ArrayList<Tuple>> al = null;

    public long[] tmpCombine;

    protected static final BagFactory mBagFactory = BagFactory.getInstance();

    protected int numReducers = 0;

    private double theta = 0.9;

    protected int lenSample = 0;
    
    protected long mapIR = 0;
    
    protected long mapOR = 0;
    
    protected float aMIR = 0;
    
    protected float aMOR = 0;
    
    protected int mapNo = 0;
    
    protected int countMap = 0;
    
    protected int countCbn = 0;

    protected boolean canOut = false;
    
    public long COR[] = null;
    
    protected long ROR[] = null;
    // finish adding new variables

    public static long rollupEstimation = 0;
    
    /**
     * We create a template for output the fields in a tuple in case the rollup
     * operation has been moved to the end of the operation list
     * 
     * @param len
     */
    public void outputIndexInit(int len) {
        output_index = new Integer[len];
        for (int i = 0; i < len - this.rollupOldFieldIndex; i++)
            if (i < this.rollupOldFieldIndex)
                output_index[i] = i;
            else
                output_index[i] = i + rollupSize;

        int count = this.rollupOldFieldIndex;

        for (int i = len - this.rollupFieldIndex; i < len; i++)
            output_index[i] = count++;
    }

    public void setOnlyIRG() {
        onlyIRG = true;
    }

    /**
     * Set the original index of the first field of Rollup operation In case the
     * rollup operation has been moved to the end of the operation list
     * 
     * @param rofi
     */
    public void setRollupOldFieldIndex(int rofi) {
        this.rollupOldFieldIndex = rofi;
    }

    public int getRollupOldFieldIndex() {
        return this.rollupOldFieldIndex;
    }

    public void setRollupSize(int rs) {
        this.rollupSize = rs;
    }

    public int getRollupSize() {
        return this.rollupSize;
    }

    public void setDimensionSize(int ds) {
        this.dimensionSize = ds;
    }

    public int getDimensionSize() {
        return this.dimensionSize;
    }

    /**
     * Set the updated index of the first field of Rollup operation and also
     * update the new pivot position due to the change of the rollup operation
     * position In case the rollup operation has been moved to the end of the
     * operation list
     * 
     * @param rfi
     */
    public void setRollupFieldIndex(int rfi) {
        this.rollupFieldIndex = rfi;
        pivot = pivot + rollupFieldIndex;
        conditionPosition = pivot;
    }

    public int getRollupFieldIndex() {
        return this.rollupFieldIndex;
    }

    public void setPivot(int pvt) {
        this.pivot = pvt;
    }

    public int getPivot() {
        return this.pivot;
    }

    public void markSampler() {
        isSampler = true;
    }

    public void setNumReducer(int nr) {
        this.numReducers = nr;
    }
    
    public int getNumReducer() {
        return this.numReducers;
    }

    public PORollupH2IRGForEach(OperatorKey k) {
        this(k, -1, null, null);
    }

    public PORollupH2IRGForEach(OperatorKey k, int rp) {
        this(k, rp, null, null);
    }

    public PORollupH2IRGForEach(OperatorKey k, List inp) {
        this(k, -1, inp, null);
    }

    public PORollupH2IRGForEach(OperatorKey k, int rp, List<PhysicalPlan> inp,
            List<Boolean> isToBeFlattened) {
        super(k, rp);
        setUpFlattens(isToBeFlattened);
        this.inputPlans = inp;
        opsToBeReset = new ArrayList<PhysicalOperator>();
        getLeaves();
    }

    public PORollupH2IRGForEach(OperatorKey operatorKey,
            int requestedParallelism, List<PhysicalPlan> innerPlans,
            List<Boolean> flattenList, Schema schema) {
        this(operatorKey, requestedParallelism, innerPlans, flattenList);
        this.schema = schema;
    }

    public void visit(PhyPlanVisitor v) throws VisitorException {
        v.visitPOForEach(this);
    }

    @Override
    public String name() {
        return getAliasString() + "New Rollup H2IRG For Each" + " ("
                + getFlatStr() + ")" + "[" + DataType.findTypeName(resultType)
                + "]" + " - " + mKey.toString();
    }

    String getFlatStr() {
        if (isToBeFlattenedArray == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Boolean b : isToBeFlattenedArray) {
            sb.append(b);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public void setAccumulative() {
        super.setAccumulative();
        for (PhysicalPlan p : inputPlans) {
            Iterator<PhysicalOperator> iter = p.iterator();
            while (iter.hasNext()) {
                PhysicalOperator po = iter.next();
                if (po instanceof ExpressionOperator
                        || po instanceof PODistinct) {
                    po.setAccumulative();
                }
            }
        }
    }

    @Override
    public void setAccumStart() {
        super.setAccumStart();
        for (PhysicalPlan p : inputPlans) {
            Iterator<PhysicalOperator> iter = p.iterator();
            while (iter.hasNext()) {
                PhysicalOperator po = iter.next();
                if (po instanceof ExpressionOperator
                        || po instanceof PODistinct) {
                    po.setAccumStart();
                }
            }
        }
    }

    @Override
    public void setAccumEnd() {
        super.setAccumEnd();
        for (PhysicalPlan p : inputPlans) {
            Iterator<PhysicalOperator> iter = p.iterator();
            while (iter.hasNext()) {
                PhysicalOperator po = iter.next();
                if (po instanceof ExpressionOperator
                        || po instanceof PODistinct) {
                    po.setAccumEnd();
                }
            }
        }
    }

    protected void initROR(int len) {
        ROR = new long[len];
        COR = new long[len];
        for (int i = 0; i < len; i ++) {
            ROR[i] = 0;
            COR[i] = 0;
        }
    }
    
    protected void calculateROR() throws ExecException {
        int len = prevRollupDimension.size();
        for (int pivotSpl = 0; pivotSpl < len - 2; pivotSpl++) {
            ROR[pivotSpl] += computeRollupSampling(pivotSpl);
            Tuple currentRollupDimensionSpl = mTupleFactory.newTuple();
            Tuple prevRollupDimension2Spl = mTupleFactory.newTuple();
            for (int k = 0; k < len; k++) {
                if (k <= pivotSpl) {
                    currentRollupDimensionSpl.append(currentRollupDimension.get(k));
                    prevRollupDimension2Spl.append(prevRollupDimension.get(k));
                } else {
                    currentRollupDimensionSpl.append(null);
                    prevRollupDimension2Spl.append(null);
                }
            }
            ROR[pivotSpl] += computeRollupSampling2(currentRollupDimensionSpl, prevRollupDimension2Spl, pivotSpl);
        }
    }
    
    protected int computeRollupSampling(int pvt) throws ExecException {
        int len = prevRollupDimension.size();
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (DataType.compare(currentRollupDimension.get(i),prevRollupDimension.get(i)) != 0) {
                int x = Math.max(i, pvt);
                count = len -2 - x + 1;
                break;
            }
        }
        if(count > 0)
            return count;
        return 0;
    }
    
    protected int computeRollupSampling2(Tuple currentRollupDimensionSpl, Tuple prevRollupDimension2Spl, int pvt) throws ExecException {
        int count = 0;
        for (int i = 0; i < pvt; i++) {
            if (DataType.compare(currentRollupDimensionSpl.get(i),prevRollupDimension2Spl.get(i)) != 0) {
                count = pvt - 2 - i + 1;
                break;
            }
        }
        if( count > 0 )
            return count;
        return 0;
    }
    
    /**
     * Compute the rollup operation for the first IRG
     * 
     * @throws ExecException
     */
    protected void computeRollup() throws ExecException {
        /*if(isSampler) {
        long tStart = System.currentTimeMillis();
        calculateROR();
        rollupEstimation += System.currentTimeMillis() - tStart;
        }*/
        int len = prevRollupDimension.size();
        int i_multi = -1;
        int index = 0;

        if (rollupFieldIndex != 0)
            index = rollupFieldIndex - 1;

        if (prevRollupDimension.get(len - 1) != null) {
            for (int i = 0; i < rollupFieldIndex; i++)
                if (DataType.compare(currentRollupDimension.get(i),
                        prevRollupDimension.get(i)) != 0) {
                    i_multi = rollupFieldIndex - 1;
                    break;
                }

            for (int i = index; i < len - 1; i++) {
                if (DataType.compare(currentRollupDimension.get(i),
                        prevRollupDimension.get(i)) != 0
                        || (rollupFieldIndex != 0 && finIRG1 == true)
                        || i_multi != -1) {

                    // find the maximum value of the first index that differs
                    // the
                    // currentRollupDimension and prevRollupDimension and the
                    // pivot
                    int i_temp = Math.max(i, i_multi);
                    int x = Math.max(i_temp, pivot);

                    // create the missing tuples for rollup operation in the
                    // first IRG
                    // (in H2IRG) or the IRG(in only IRG)
                    for (int j = len - 2; j >= x; j--) {
                        Tuple group = mTupleFactory.newTuple();
                        for (int k = 0; k < len; k++) {
                            if (k <= j) {
                                group.append(prevRollupDimension.get(k));
                            } else {
                                group.append(null);
                            }
                        }

                        Tuple out = mTupleFactory.newTuple();
                        out.append(group);

                        for (int k = 0; k < noUserFunc; k++)
                            out.append(tmpResult[j + 1][k]);

                        attachInputToPlans(out);
                        //isIRGSample = true;
                        returnRes[j + 1] = processPlan(j);
                        // System.out.println(returnRes[j+1].result.toString() +
                        // "from computeRollup");
                        for (int k = 0; k < noUserFunc; k++) {
                            tmpResult[j + 1][k].clear();
                        }
                    }
                    break;
                }
            }
        } else {
            for (int j = 0; j < len; j++)
                for (int k = 0; k < noUserFunc; k++) {
                    tmpResult[j][k].clear();
                }
        }
    }

    /**
     * Compute the rollup operation for the second IRG
     * 
     * @throws ExecException
     */
    protected void computeRollup2() throws ExecException {
        int len = prevRollupDimension2.size();

        int index = 0;
        int i_multi = -1;

        if (rollupFieldIndex != 0)
            index = rollupFieldIndex - 1;

        for (int i = 0; i < rollupFieldIndex; i++)
            if (DataType.compare(currentRollupDimension.get(i),
                    prevRollupDimension2.get(i)) != 0) {
                i_multi = rollupFieldIndex - 1;
                break;
            }

        for (int i = index; i < pivot; i++) {
            if (DataType.compare(currentRollupDimension.get(i),
                    prevRollupDimension2.get(i)) != 0
                    || finIRG2 == true || i_multi != -1) {
                int x = Math.max(i_multi, i);
                // create the missing tuples for rollup operation in the second
                // IRG
                for (int j = pivot - 2; j >= x; j--) {
                    Tuple group = mTupleFactory.newTuple();
                    for (int k = 0; k < len; k++) {
                        if (k <= j) {
                            group.append(prevRollupDimension2.get(k));
                        } else {
                            group.append(null);
                        }
                    }

                    Tuple out = mTupleFactory.newTuple();
                    out.append(group);
                    for (int k = 0; k < noUserFunc; k++)
                        out.append(tmpResult2[j + 1][k]);

                    attachInputToPlans(out);
                    returnRes2[j + 1] = processPlan(j);
                    for (int k = 0; k < noUserFunc; k++)
                        tmpResult2[j + 1][k].clear();
                }
                break;
            }
        }
    }

    public void testFinish() throws ExecException {
        System.out.println("HAHAHA! I'm done!");
    }
    
    /**
     * Call the final aggregation for the IRGs and return the results.
     * 
     * @return
     * @throws ExecException
     */
    public Result[] finish() throws ExecException {
        if (prevRollupDimension != null) {

            if (rollupFieldIndex == 0)
                currentRollupDimension = mTupleFactory
                        .newTuple(prevRollupDimension.size());

            finIRG1 = true;
            secondPass = false;
            computeRollup();
            secondPass = true;
        }

        if (prevRollupDimension2 == null && prevRollupDimension != null) {
            if (rollupFieldIndex == 0)
                computeFinalAggregation();
            return returnRes;
        }

        if (secondPass) {

            if (rollupFieldIndex == 0)
                currentRollupDimension = mTupleFactory
                        .newTuple(prevRollupDimension2.size());
            finIRG2 = true;
            computeRollup2();
            if (pivot != 0)
                computeFinalAggregation2();
        }

        return returnRes;
    }

    /**
     * Compute the final aggregation for the second IRG
     * 
     * @throws ExecException
     */
    protected void computeFinalAggregation2() throws ExecException {
        Tuple group = mTupleFactory.newTuple();

        for (int k = 0; k < prevRollupDimension2.size(); k++)
            group.append(null);
        Tuple out = mTupleFactory.newTuple();
        out.append(group);
        for (int k = 0; k < noUserFunc; k++)
            out.append(tmpResult2[0][k]);
        attachInputToPlans(out);
        if(returnRes == null) {
            returnRes = new Result[dimensionSize];
            for (int i = 0; i < dimensionSize; i++) {
                returnRes[i] = null;
            }
        }
        if (rollupFieldIndex == 0)
            if(returnRes!=null)
                returnRes[0] = processPlan(-1);
            else
                returnRes2[0] = processPlan(-1);

        for (int i = 0; i < prevRollupDimension2.size(); i++)
            if (returnRes[i] == null && returnRes2[i] != null)
                returnRes[i] = returnRes2[i];
    }

    /**
     * Compute the final aggregation for the first IRG
     * 
     * @throws ExecException
     */
    protected void computeFinalAggregation() throws ExecException {
        Tuple group = mTupleFactory.newTuple();

        for (int k = 0; k < prevRollupDimension.size(); k++)
            group.append(null);
        Tuple out = mTupleFactory.newTuple();
        out.append(group);
        for (int k = 0; k < noUserFunc; k++)
            out.append(tmpResult[0][k]);
        attachInputToPlans(out);
        returnRes[0] = processPlan(-1);
    }

    private boolean isEarlyTerminated() {
        return isEarlyTerminated;
    }

    private void earlyTerminate() {
        isEarlyTerminated = true;
    }

    /**
     * initial the ArrayList al initial the tmpCombine array
     * 
     * @param len
     */
    private void initEstimatedFile(int len) {
        al = new ArrayList<ArrayList<Tuple>>();
        for (int i = 0; i < len + 1; i++) {
            ArrayList<Tuple> single = new ArrayList<Tuple>();
            al.add(single);
        }
        tmpCombine = new long[len];
        for (int i = 0; i < len; i++)
            tmpCombine[i] = 0;
    }

    /**
     * Add the tuple to the correct array-list due to number of null field in it
     * 
     * @param key
     * @throws ExecException
     */
    public void IRGEstimation(Result res) throws ExecException {
        
        TupleFactory mTupleFactory = TupleFactory
                .getInstance();
        Tuple tmp = mTupleFactory.newTuple();
        tmp = (Tuple) res.result;
        Tuple key = (Tuple) tmp.get(0);
        if (key.size() == lenSample)
            key.append(tmp.get(1));
        
        int countNull = 0;
        for (int i = 0; i < key.size() - 1; i++)
            if (key.get(i) == null)
                countNull++;

        int index = al.size() - countNull - 1;

        al.get(index).add(key);
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
    public void closeEstimatedFile() throws IOException {
        for (int i = 0; i < ROR.length; i++)
            System.out.print(ROR[i] + " " + "\t");
        System.out.println("");
        for (int i = 0; i < tmpCombine.length; i++)
            System.out.print(tmpCombine[i] + " " + "\t");
        System.out.println("");
        for (int i = 0; i < al.size(); i++)
            System.out.println(al.get(i).size() + " " + "\t");
        System.out.println("");
        int autopivot = AutoPivotSelection();
        log.info("Autopivot: " + autopivot);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream pPivot = fs.create(new Path("/tmp/partition/pivot"));
        pPivot.writeBytes(String.valueOf(autopivot) + "\n");

    }

    public int AutoPivotSelection() {
        long[] minimizeSum = new long[al.size()];
        log.info(al.size());
        int minPartition;
        try {
            long[] combineStats = tmpCombine;
            for (int i = 0; i < al.size(); i++) {
                minimizeSum[i] = partition(combineStats, i, al.size() - 1);
            }
            minPartition = 0;
            for (int i = 0; i < al.size(); i++) {
                if (minimizeSum[i] < (minimizeSum[minPartition] * Math.pow(
                        theta, i - minPartition))) {
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

    private long partition(long[] combineStats, int p, int l)
            throws IOException {

        Collections.sort(al.get(p), Collections
                .reverseOrder(new TupleComparator()));

        long maxSum = 0;

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream pOut = fs.create(new Path("/tmp/partition/p"
                + String.valueOf(p)));

        // pOut.writeBytes(String.valueOf(p) + "\n");

        if (p == 0) {
            maxSum = (Long) al.get(p).get(0).get(l);
        } else {
            maxSum = combineStats[p - 1];
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
                if (maxSum < subSum[i]) {
                    maxSum = subSum[i];
                }
            }
        }
        return maxSum;
    }

    /**
     * Calls getNext on the generate operator inside the nested physical plan
     * and returns it maintaining an additional state to denote the begin and
     * end of the nested plan processing.
     **/
    @Override
    public Result getNextTuple() throws ExecException {
        try {
            //if (!isSampler) 
            {
                Result res = null;
                Result inp = null;
                // The nested plan is under processing
                // So return tuples that the generate oper
                // returns

                // Check if
                if (rollupFieldIndex != 0 && modified_pivot == false
                        && pivot == 0) {
                    modified_pivot = true;
                }

                // Return the result if it's still also in the returnRes
                if (prevRollupDimension != null) {

                    for (int i = prevRollupDimension.size() - 1; i >= 0; i--)
                        if (returnRes[i] != null) {
                            res = returnRes[i];
                            returnRes[i] = null;
                            return res;
                        }
                }

                // Return the result if it's still also in the returnRes2
                // We only go to the for loop if prevRollupDimension2 is not
                // null
                // and we have not called yet the finish function.
                if (prevRollupDimension2 != null && !finished) {
                    for (int i = prevRollupDimension2.size() - 1; i >= 0; i--)
                        if (returnRes2[i] != null) {
                            res = returnRes2[i];
                            returnRes2[i] = null;
                            return res;
                        }
                }

                if (processingPlan) {
                    while (true) {
                        res = processPlan(currentRollupDimension.size() - 1);

                        if (res.returnStatus == POStatus.STATUS_OK) {
                            return res;
                        }
                        if (res.returnStatus == POStatus.STATUS_EOP) {
                            processingPlan = false;
                            for (PhysicalPlan plan : inputPlans) {
                                plan.detachInput();
                            }
                            break;
                        }
                        if (res.returnStatus == POStatus.STATUS_ERR) {
                            return res;
                        }
                        if (res.returnStatus == POStatus.STATUS_NULL) {
                            continue;
                        }
                    }
                }
                // The nested plan processing is done or is
                // yet to begin. So process the input and start
                // nested plan processing on the input tuple
                // read
                while (true) {
                    inp = processInput();
                    if (inp.returnStatus == POStatus.STATUS_EOP
                            || inp.returnStatus == POStatus.STATUS_ERR) {
                        return inp;
                    }
                    if (inp.returnStatus == POStatus.STATUS_NULL) {
                        continue;
                    }

                    inpTuple = (Tuple) inp.result;

                    // Initiate the currentRollupDimension
                    currentRollupDimension = null;

                    if (inp.returnStatus == POStatus.STATUS_EOP) {
                        return inp;
                    }

                    int len = 0;
                    if (inpTuple.getType(0) == DataType.TUPLE) {
                        currentRollupDimension = (Tuple) inpTuple.get(0);
                        len = currentRollupDimension.size();

                        boolean checkLast = false;

                        // The special record which has size larger than the
                        // default
                        // one
                        // to mark that we went through the last record, compute
                        // the
                        // final
                        // rollup aggregation by calling finish()
                        // if (prevRollupDimension != null)
                        // if (len > prevRollupDimension.size())
                        // checkLast = true;

                        if (len > dimensionSize) {
                            checkLast = true;
                        }

                        if (checkLast) {
                            int checkFirstReducer = (Integer) currentRollupDimension
                                    .get(len - 1);
                            Result tmp[] = finish();

                            if (tmp != null) {
                                finished = true; // called finished
                                res = new Result();
                                if(returnRes!=null) {
                                    for(int i = dimensionSize - 1; i >=0; i--)
                                        if(returnRes[i]!=null) {
                                            res.result = returnRes[i].result;
                                            res.returnStatus = POStatus.STATUS_OK;
                                            returnRes[i] = null;
                                            break;
                                        }
                                } else {
                                    for(int i = dimensionSize - 1; i >=0; i--)
                                        if(returnRes2[i]!=null) {
                                            res.result = returnRes2[i].result;
                                            res.returnStatus = POStatus.STATUS_OK;
                                            returnRes2[i] = null;
                                            break;
                                        }
                                }
                                // If this special tuple is not for reducer0
                                // so we just output the remaining results from
                                // the
                                // pivot to the end of the length
                                if (checkFirstReducer != 0) {
                                    for (int i = 0; i < pivot; i++)
                                        if(returnRes!=null)
                                            returnRes[i] = null;
                                        else
                                            returnRes2[i] = null;
                                    if (pivot == 0)
                                        if(returnRes!=null)
                                            returnRes[0] = null;
                                        else
                                            returnRes2[0] = null;
                                }
                                if(currentRollupDimension!=null) {
                                    prevRollupDimension = mTupleFactory.newTuple(dimensionSize);
                                    for (int i = 0; i < currentRollupDimension.size(); i++){
                                        prevRollupDimension.set(i,(currentRollupDimension.get(i)));
                                    }
                                }
                                return res;
                            } else {
                                res = new Result();
                                res.result = null;
                                res.returnStatus = POStatus.STATUS_EOP;
                                return res;
                            }
                        }

                        // Initiate the output index template
                        if (output_index == null && rollupFieldIndex != 0)
                            this.outputIndexInit(len);

                    }

                    if (currentRollupDimension == null) {
                        res.returnStatus = POStatus.STATUS_ERR;
                        return res;
                    }

                    // Check if the field at the (updated - in case we has moved
                    // the
                    // rollup operation to the end of the operation list) pivot
                    // position
                    // of the tuple is null or not. If it is not null, we
                    // compute
                    // the
                    // rollup using the first rollup, else, we compute the it
                    // using
                    // the second IRG
                    if (currentRollupDimension.get(conditionPosition) != null) {
                        secondPass = false;
                        if (prevRollupDimension != null) {
                            computeRollup();
                        } else {
                            noUserFunc = 0;
                            for (int i = 0; i < noItems; i++) {
                                if ((planLeafOps[i]) instanceof POUserFunc) {
                                    noUserFunc++;
                                }
                            }

                            tmpResult = new DataBag[len][noUserFunc];
                            returnRes = new Result[len];

                            for (int i = 0; i < len; i++) {
                                for (int j = 0; j < noUserFunc; j++) {
                                    tmpResult[i][j] = mBagFactory
                                            .newDefaultBag();
                                }
                                returnRes[i] = null;
                            }
                        }
                        //prevRollupDimension = currentRollupDimension;
                        prevRollupDimension = mTupleFactory.newTuple(dimensionSize);
                        for (int i = 0; i < currentRollupDimension.size(); i++){
                            prevRollupDimension.set(i,(currentRollupDimension.get(i)));
                        }
                    } else {
                        secondPass = true;
                        if (prevRollupDimension2 != null) {
                            computeRollup2();
                        } else {
                            noUserFunc = 0;
                            for (int i = 0; i < noItems; i++) {
                                if ((planLeafOps[i]) instanceof POUserFunc) {
                                    noUserFunc++;
                                }
                            }

                            tmpResult2 = new DataBag[len][noUserFunc];
                            returnRes2 = new Result[len];

                            for (int i = 0; i < len; i++) {
                                for (int j = 0; j < noUserFunc; j++) {
                                    tmpResult2[i][j] = mBagFactory
                                            .newDefaultBag();
                                }
                                returnRes2[i] = null;
                            }
                        }
                        //prevRollupDimension2 = currentRollupDimension;
                        prevRollupDimension2 = mTupleFactory.newTuple(dimensionSize);
                        for (int i = 0; i < currentRollupDimension.size(); i++){
                            prevRollupDimension2.set(i,(currentRollupDimension.get(i)));
                        }
                    }
                    attachInputToPlans((Tuple) inp.result);

                    for (PhysicalOperator po : opsToBeReset) {
                        po.reset();
                    }

                    if (isAccumulative()) {
                        for (int i = 0; i < inpTuple.size(); i++) {
                            if (inpTuple.getType(i) == DataType.BAG) {
                                // we only need to check one bag, because all
                                // the
                                // bags
                                // share the same buffer
                                buffer = ((AccumulativeBag) inpTuple.get(i))
                                        .getTuplebuffer();
                                break;
                            }
                        }

                        setAccumStart();
                        while (true) {
                            if (!isEarlyTerminated() && buffer.hasNextBatch()) {
                                try {
                                    buffer.nextBatch();
                                } catch (IOException e) {
                                    throw new ExecException(e);
                                }
                            } else {
                                inpTuple = ((POPackage.POPackageTupleBuffer) buffer)
                                        .illustratorMarkup(null, inpTuple, 0);
                                // buffer.clear();
                                setAccumEnd();
                            }

                            if (!secondPass)
                                returnRes[0] = processPlan(currentRollupDimension
                                        .size() - 1);
                            else if (pivot == 0)
                                returnRes2[0] = processPlan(pivot);
                            else
                                returnRes2[0] = processPlan(pivot - 1);

                            if (res.returnStatus == POStatus.STATUS_BATCH_OK) {
                                // attach same input again to process next batch
                                attachInputToPlans((Tuple) inp.result);
                            } else if (res.returnStatus == POStatus.STATUS_EARLY_TERMINATION) {
                                // if this bubbled up, then we just need to pass
                                // a
                                // null value through the pipe
                                // so that POUserFunc will properly return the
                                // values
                                attachInputToPlans(null);
                                earlyTerminate();
                            } else {
                                break;
                            }
                        }

                    } else {
                        // if we are still in IRG1, we compute the rollup
                        // and store it in the returnRes
                        if (!secondPass)
                            returnRes[0] = processPlan(currentRollupDimension
                                    .size() - 1);
                        // else, we process the rollup and store it in the
                        // returnRes2
                        // if the pivot is zero, it's IRG, else, we process at
                        // the
                        // (pivot - 1)
                        // because the pivot position user specified is always
                        // larger than the
                        // index in the rollup fields by one.
                        else if (pivot == 0)
                            returnRes2[0] = processPlan(pivot);
                        else
                            returnRes2[0] = processPlan(pivot - 1);
                    }

                    processingPlan = true;

                    // We return the result that we stored in returnRes or
                    // returnRes2
                    for (int i = currentRollupDimension.size() - 1; i >= 0; i--) {
                        if (!secondPass) {
                            if (returnRes[i] != null) {
                                res = returnRes[i];
                                returnRes[i] = null;
                                break;
                            }
                        } else {
                            if (returnRes2[i] != null) {
                                res = returnRes2[i];
                                returnRes2[i] = null;
                                break;
                            }
                        }
                    }
                    return res;
                }
            } /*else {
                Result res = null;
                Result inp = null;
                this.setPivot(0);
                long tStart = 0;
                if (rollupFieldIndex != 0 && modified_pivot == false
                        && pivot == 0) {
                    modified_pivot = true;
                }
                
                // Return the result if it's still also in the returnRes
                if (prevRollupDimension != null) {
                    for (int i = prevRollupDimension.size() - 1; i >= 0; i--)
                        if (returnRes[i] != null) {
                            res = returnRes[i];
                            returnRes[i] = null;
                            tStart = System.currentTimeMillis();
                            IRGEstimation(res);
                            Tuple tmp2 = mTupleFactory.newTuple();
                            tmp2 = (Tuple) res.result;
                            Tuple reformatkey = null;
                            reformatkey = mTupleFactory.newTuple(); 
                            Tuple key2 = (Tuple) tmp2.get(0);
                            reformatkey.append(key2.get(0));
                            reformatkey.append(key2.get(1));
                            reformatkey.append(key2.get(2));
                            reformatkey.append(key2.get(3));
                            reformatkey.append(key2.get(4));
                            reformatkey.append(key2.get(5));
                            ((Tuple) res.result).set(0, reformatkey);
                            rollupEstimation += System.currentTimeMillis() - tStart;
                            return res;
                        }
                }

                if (prevRollupDimension2 != null && !finished) {
                    for (int i = prevRollupDimension2.size() - 1; i >= 0; i--)
                        if (returnRes2[i] != null) {
                            res = returnRes2[i];
                            returnRes2[i] = null;
                            return res;
                        }
                }
                
                if (processingPlan) {
                    while (true) {
                        res = processPlan(currentRollupDimension.size() - 1);

                        if (res.returnStatus == POStatus.STATUS_OK) {
                            tStart = System.currentTimeMillis();

                            TupleFactory mTupleFactory = TupleFactory
                                    .getInstance();
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
                            rollupEstimation += System.currentTimeMillis() - tStart;
                            return res;
                        }
                        if (res.returnStatus == POStatus.STATUS_EOP) {
                            processingPlan = false;
                            for (PhysicalPlan plan : inputPlans) {
                                plan.detachInput();
                            }
                            break;
                        }
                        if (res.returnStatus == POStatus.STATUS_ERR) {
                            return res;
                        }
                        if (res.returnStatus == POStatus.STATUS_NULL) {
                            continue;
                        }
                    }
                }

                while (true) {
                    inp = processInput();
                    if (inp.returnStatus == POStatus.STATUS_EOP
                            || inp.returnStatus == POStatus.STATUS_ERR) {
                        return inp;
                    }
                    if (inp.returnStatus == POStatus.STATUS_NULL) {
                        continue;
                    }

                    inpTuple = (Tuple) inp.result;
                    
                    // Initiate the currentRollupDimension
                    currentRollupDimension = null;

                    if (inp.returnStatus == POStatus.STATUS_EOP) {
                        return inp;
                    }

                    int len = 0;
                    if (inpTuple.getType(0) == DataType.TUPLE) {
                        currentRollupDimension = (Tuple) inpTuple.get(0);
                        len = currentRollupDimension.size();
                        lenSample = len;
                    }
                    boolean checkLast = false;

                    if (len > dimensionSize) {
                        checkLast = true;
                    }

                    if (checkLast) {}
                    //tStart = System.currentTimeMillis();
                    if (al == null) {
                        initEstimatedFile(dimensionSize);
                    }
                    
                    if (output_index == null && rollupFieldIndex != 0)
                        this.outputIndexInit(len);
                    
                    //rollupEstimation += System.currentTimeMillis() - tStart;
                    
                    if (currentRollupDimension == null) {
                        res.returnStatus = POStatus.STATUS_ERR;
                        return res;
                    }

                    if (currentRollupDimension.get(len - 1) != null) {
                        secondPass = false;
                        if (prevRollupDimension != null) {
                            computeRollup();
                        } else {
                            noUserFunc = 0;
                            for (int i = 0; i < noItems; i++) {
                                if ((planLeafOps[i]) instanceof POUserFunc) {
                                    noUserFunc++;
                                }
                            }

                            tmpResult = new DataBag[len][noUserFunc];
                            returnRes = new Result[len];

                            for (int i = 0; i < len; i++) {
                                for (int j = 0; j < noUserFunc; j++) {
                                    tmpResult[i][j] = mBagFactory
                                            .newDefaultBag();
                                }
                                returnRes[i] = null;
                            }
                        }
                        prevRollupDimension = mTupleFactory.newTuple(dimensionSize);
                        for (int i = 0; i < currentRollupDimension.size(); i++){
                            prevRollupDimension.set(i,(currentRollupDimension.get(i)));
                        }
                    }

                    attachInputToPlans((Tuple) inp.result);

                    for (PhysicalOperator po : opsToBeReset) {
                        po.reset();
                    }

                    if (isAccumulative()) {
                        for (int i = 0; i < inpTuple.size(); i++) {
                            if (inpTuple.getType(i) == DataType.BAG) {
                                // we only need to check one bag, because all
                                // the
                                // bags
                                // share the same buffer
                                buffer = ((AccumulativeBag) inpTuple.get(i))
                                        .getTuplebuffer();
                                break;
                            }
                        }

                        setAccumStart();
                        while (true) {
                            if (!isEarlyTerminated() && buffer.hasNextBatch()) {
                                try {
                                    buffer.nextBatch();
                                } catch (IOException e) {
                                    throw new ExecException(e);
                                }
                            } else {
                                inpTuple = ((POPackage.POPackageTupleBuffer) buffer)
                                        .illustratorMarkup(null, inpTuple, 0);
                                // buffer.clear();
                                setAccumEnd();
                            }

                            returnRes[0] = processPlan(currentRollupDimension.size() - 1);

                            if (res.returnStatus == POStatus.STATUS_BATCH_OK) {
                                attachInputToPlans((Tuple) inp.result);
                            } else if (res.returnStatus == POStatus.STATUS_EARLY_TERMINATION) {
                                attachInputToPlans(null);
                                earlyTerminate();
                            } else {
                                break;
                            }
                        }

                    } else {
                        if (!secondPass) {
                                returnRes[0] = processPlan(currentRollupDimension.size() - 1);
                        }
                    }

                    processingPlan = true;

                    for (int i = currentRollupDimension.size() - 1; i >= 0; i--) {
                        if (returnRes[i] != null) {
                            res = returnRes[i];
                            tStart = System.currentTimeMillis();
                            IRGEstimation(res);
                            rollupEstimation += System.currentTimeMillis() - tStart;
                            returnRes[i] = null;
                            break;
                        }
                    }
                    tStart = System.currentTimeMillis();
                    // reformat result.
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
                    rollupEstimation += System.currentTimeMillis() - tStart;
                    return res;
                }
            }*/

        } catch (RuntimeException e) {
            throw new ExecException(
                    "Error while executing RollupH2IRGForEach at "
                            + this.getOriginalLocations(), e);
        }
    }

    private boolean isEarlyTerminated = false;
    private TupleMaker<? extends Tuple> tupleMaker;

    private boolean knownSize = false;

    protected Result processPlan(int pos) throws ExecException {
        if (schema != null && tupleMaker == null) {
            // Note here that if SchemaTuple is currently turned on, then any
            // UDF's in the chain
            // must follow good practices. Namely, they should not append to the
            // Tuple that comes
            // out of an iterator (a practice which is fairly common, but is not
            // recommended).
            tupleMaker = SchemaTupleFactory.getInstance(schema, false,
                    GenContext.FOREACH);
            if (tupleMaker != null) {
                knownSize = true;
            }
        }
        if (tupleMaker == null) {
            tupleMaker = TupleFactory.getInstance();
        }

        Result res = new Result();

        // We check if all the databags have exhausted the tuples. If so we
        // enforce the reading of new data by setting data and its to null
        if (its != null) {
            boolean restartIts = true;
            for (int i = 0; i < noItems; ++i) {
                if (its[i] != null && isToBeFlattenedArray[i] == true) {
                    restartIts &= !its[i].hasNext();
                }
            }
            // this means that all the databags have reached their last
            // elements. so we need to force reading of fresh databags
            if (restartIts) {
                its = null;
                data = null;
            }
        }

        if (its == null) {
            // getNext being called for the first time OR starting with a set of
            // new data from inputs
            its = new Iterator[noItems];
            bags = new Object[noItems];
            earlyTermination = new BitSet(noItems);

            int cnt = 0;

            for (int i = 0; i < noItems; ++i) {
                // Getting the iterators
                // populate the input data
                Result inputData = null;
                switch (resultTypes[i]) {
                case DataType.BAG:
                case DataType.TUPLE:
                case DataType.BYTEARRAY:
                case DataType.MAP:
                case DataType.BOOLEAN:
                case DataType.INTEGER:
                case DataType.DOUBLE:
                case DataType.LONG:
                case DataType.FLOAT:
                case DataType.BIGINTEGER:
                case DataType.BIGDECIMAL:
                case DataType.DATETIME:
                case DataType.CHARARRAY:
                    inputData = planLeafOps[i].getNext(resultTypes[i]);
                    // We stores the payloads that we want to compute the rollup
                    // in tmpResult
                    // for the first IRG and in tmpResult2 for the second IRG
                    if (((planLeafOps[i]) instanceof POUserFunc )//&& !isSampler)
                            && (inputData.result != null) && (pos != -1)) {
                        if (!secondPass) {
                            tmpResult[pos][cnt++].add(mTupleFactory
                                    .newTuple(inputData.result));
                        } else {
                            tmpResult2[pos][cnt++].add(mTupleFactory
                                    .newTuple(inputData.result));
                        }
                    }
                    break;
                default: {
                    int errCode = 2080;
                    String msg = "Foreach currently does not handle type "
                            + DataType.findTypeName(resultTypes[i]);
                    throw new ExecException(msg, errCode, PigException.BUG);
                }

                }

                // we accrue information about what accumulators have early
                // terminated
                // in the case that they all do, we can finish
                if (inputData.returnStatus == POStatus.STATUS_EARLY_TERMINATION) {
                    if (!earlyTermination.get(i))
                        earlyTermination.set(i);

                    continue;
                }

                if (inputData.returnStatus == POStatus.STATUS_BATCH_OK) {
                    continue;
                }

                if (inputData.returnStatus == POStatus.STATUS_EOP) {
                    // we are done with all the elements. Time to return.
                    its = null;
                    bags = null;
                    return inputData;
                }
                // if we see a error just return it
                if (inputData.returnStatus == POStatus.STATUS_ERR) {
                    return inputData;
                }

                bags[i] = inputData.result;

                if (inputData.result instanceof DataBag
                        && isToBeFlattenedArray[i]) {
                    its[i] = ((DataBag) bags[i]).iterator();
                } else {
                    its[i] = null;
                }
            }
        }

        // if accumulating, we haven't got data yet for some fields, just return
        if (isAccumulative() && isAccumStarted()) {
            if (earlyTermination.cardinality() < noItems) {
                res.returnStatus = POStatus.STATUS_BATCH_OK;
            } else {
                res.returnStatus = POStatus.STATUS_EARLY_TERMINATION;
            }
            return res;
        }

        while (true) {
            if (data == null) {
                // getNext being called for the first time or starting on new
                // input data
                // we instantiate the template array and start populating it
                // with data
                data = new Object[noItems];
                for (int i = 0; i < noItems; ++i) {
                    if (isToBeFlattenedArray[i] && bags[i] instanceof DataBag) {
                        if (its[i].hasNext()) {
                            data[i] = its[i].next();
                        } else {
                            // the input set is null, so we return. This is
                            // caught above and this function recalled with
                            // new inputs.
                            its = null;
                            data = null;
                            res.returnStatus = POStatus.STATUS_NULL;
                            return res;
                        }
                    } else {
                        data[i] = bags[i];
                    }

                }
                if (getReporter() != null) {
                    getReporter().progress();
                }
                // createTuple(data);

                res.result = createTuple(data);

                res.returnStatus = POStatus.STATUS_OK;
                return res;
            } else {
                // we try to find the last expression which needs flattening and
                // start iterating over it
                // we also try to update the template array
                for (int index = noItems - 1; index >= 0; --index) {
                    if (its[index] != null && isToBeFlattenedArray[index]) {
                        if (its[index].hasNext()) {
                            data[index] = its[index].next();
                            res.result = createTuple(data);
                            res.returnStatus = POStatus.STATUS_OK;
                            return res;
                        } else {
                            its[index] = ((DataBag) bags[index]).iterator();
                            data[index] = its[index].next();
                        }
                    }
                }
            }
        }
    }

    /**
     * We create a new tuple for the final flattened tuple, in case the rollup
     * operation has been moved to the end of the operation list, we re-order
     * the fields as the same order as the input's by using the output_index we
     * initialized before.
     * 
     * @param data
     *            array that is the template for the final flattened tuple
     * @return the final flattened tuple
     */
    protected Tuple createTuple_(Object[] data) throws ExecException {
        Tuple out = tupleMaker.newTuple();
        Tuple temp = mTupleFactory.newTuple();
        int idx = 0;
        for (int i = 0; i < data.length; ++i) {
            Object in = data[i];

            if ((isToBeFlattenedArray[i] || rollupFieldIndex != 0)
                    && in instanceof Tuple) {
                Tuple t = (Tuple) in;
                int size = t.size();

                if (rollupFieldIndex != 0) {
                    if (!isToBeFlattenedArray[i]) {
                        for (int j = 0; j < size; j++)
                            temp.append(t.get(output_index[j]));
                        Object inn = temp;
                        out.append(inn);
                    } else {
                        for (int j = 0; j < size; j++)
                            out.append(t.get(output_index[j]));
                    }
                } else {
                    for (int j = 0; j < size; ++j) {
                        if (knownSize) {
                            out.set(idx++, t.get(j));
                        } else {
                            out.append(t.get(j));
                        }
                    }
                }
            } else {
                if (knownSize) {
                    out.set(idx++, in);
                } else {
                    out.append(in);
                }
            }
        }
        if (inpTuple != null) {
            return illustratorMarkup(inpTuple, out, 0);
        } else {
            return illustratorMarkup2(data, out);
        }
    }

    protected Tuple createTuple(Object[] data) throws ExecException {
        Tuple out =  tupleMaker.newTuple();

        int idx = 0;
        for(int i = 0; i < data.length; ++i) {
            Object in = data[i];

            if(isToBeFlattenedArray[i] && in instanceof Tuple) {
                Tuple t = (Tuple)in;
                int size = t.size();
                for(int j = 0; j < size; ++j) {
                    if (knownSize) {
                        out.set(idx++, t.get(j));
                    } else {
                    out.append(t.get(j));
                }
                }
            } else {
                if (knownSize) {
                    out.set(idx++, in);
            } else {
                out.append(in);
            }
        }
        }
        if (inpTuple != null) {
            return illustratorMarkup(inpTuple, out, 0);
        } else {
            return illustratorMarkup2(data, out);
        }
    }
    
    /**
     * Make a deep copy of this operator.
     * 
     * @throws CloneNotSupportedException
     */
    @Override
    public PORollupH2IRGForEach clone() throws CloneNotSupportedException {
        List<PhysicalPlan> plans = new ArrayList<PhysicalPlan>(inputPlans
                .size());
        for (PhysicalPlan plan : inputPlans) {
            plans.add(plan.clone());
        }
        List<Boolean> flattens = null;
        if (isToBeFlattenedArray != null) {
            flattens = new ArrayList<Boolean>(isToBeFlattenedArray.length);
            for (boolean b : isToBeFlattenedArray) {
                flattens.add(b);
            }
        }

        List<PhysicalOperator> ops = new ArrayList<PhysicalOperator>(
                opsToBeReset.size());
        for (PhysicalOperator op : opsToBeReset) {
            ops.add(op);
        }
        PORollupH2IRGForEach clone = new PORollupH2IRGForEach(new OperatorKey(
                mKey.scope, NodeIdGenerator.getGenerator().getNextNodeId(
                        mKey.scope)), requestedParallelism, plans, flattens);
        clone.setOpsToBeReset(ops);
        clone.setResultType(getResultType());
        clone.addOriginalLocation(alias, getOriginalLocations());
        clone.setPivot(pivot);
        clone.setRollupFieldIndex(rollupFieldIndex);
        clone.setRollupOldFieldIndex(rollupOldFieldIndex);
        clone.setRollupSize(rollupSize);
        clone.setDimensionSize(dimensionSize);
        return clone;
    }

    protected void attachInputToPlans(Tuple t) {
        // super.attachInput(t);
        for (PhysicalPlan p : inputPlans) {
            p.attachInput(t);
        }
    }

    public void getLeaves() {
        if (inputPlans != null) {
            int i = -1;
            if (isToBeFlattenedArray == null) {
                isToBeFlattenedArray = new boolean[inputPlans.size()];
            }
            planLeafOps = new PhysicalOperator[inputPlans.size()];
            for (PhysicalPlan p : inputPlans) {
                ++i;
                PhysicalOperator leaf = p.getLeaves().get(0);
                planLeafOps[i] = leaf;
                if (leaf instanceof POProject
                        && leaf.getResultType() == DataType.TUPLE
                        && ((POProject) leaf).isProjectToEnd()) {
                    isToBeFlattenedArray[i] = true;
                }
            }
        }
        // we are calculating plan leaves
        // so lets reinitialize
        reInitialize();
    }

    private void reInitialize() {
        if (planLeafOps != null) {
            noItems = planLeafOps.length;
            resultTypes = new byte[noItems];
            for (int i = 0; i < resultTypes.length; i++) {
                resultTypes[i] = planLeafOps[i].getResultType();
            }
        } else {
            noItems = 0;
            resultTypes = null;
        }

        if (inputPlans != null) {
            for (PhysicalPlan pp : inputPlans) {
                try {
                    ResetFinder lf = new ResetFinder(pp, opsToBeReset);
                    lf.visit();
                } catch (VisitorException ve) {
                    String errMsg = "Internal Error:  Unexpected error looking for nested operators which need to be reset in FOREACH";
                    throw new RuntimeException(errMsg, ve);
                }
            }
        }
    }

    public List<PhysicalPlan> getInputPlans() {
        return inputPlans;
    }

    public void setInputPlans(List<PhysicalPlan> plans) {
        inputPlans = plans;
        planLeafOps = null;
        getLeaves();
    }

    public void addInputPlan(PhysicalPlan plan, boolean flatten) {
        inputPlans.add(plan);
        // add to planLeafOps
        // copy existing leaves
        PhysicalOperator[] newPlanLeafOps = new PhysicalOperator[planLeafOps.length + 1];
        for (int i = 0; i < planLeafOps.length; i++) {
            newPlanLeafOps[i] = planLeafOps[i];
        }
        // add to the end
        newPlanLeafOps[planLeafOps.length] = plan.getLeaves().get(0);
        planLeafOps = newPlanLeafOps;

        // add to isToBeFlattenedArray
        // copy existing values
        boolean[] newIsToBeFlattenedArray = new boolean[isToBeFlattenedArray.length + 1];
        for (int i = 0; i < isToBeFlattenedArray.length; i++) {
            newIsToBeFlattenedArray[i] = isToBeFlattenedArray[i];
        }
        // add to end
        newIsToBeFlattenedArray[isToBeFlattenedArray.length] = flatten;
        isToBeFlattenedArray = newIsToBeFlattenedArray;

        // we just added a leaf - reinitialize
        reInitialize();
    }

    public void setToBeFlattened(List<Boolean> flattens) {
        setUpFlattens(flattens);
    }

    public List<Boolean> getToBeFlattened() {
        List<Boolean> result = null;
        if (isToBeFlattenedArray != null) {
            result = new ArrayList<Boolean>();
            for (int i = 0; i < isToBeFlattenedArray.length; i++) {
                result.add(isToBeFlattenedArray[i]);
            }
        }
        return result;
    }

    public boolean inProcessing() {
        return processingPlan;
    }

    protected void setUpFlattens(List<Boolean> isToBeFlattened) {
        if (isToBeFlattened == null) {
            isToBeFlattenedArray = null;
        } else {
            isToBeFlattenedArray = new boolean[isToBeFlattened.size()];
            int i = 0;
            for (Iterator<Boolean> it = isToBeFlattened.iterator(); it
                    .hasNext();) {
                isToBeFlattenedArray[i++] = it.next();
            }
        }
    }

    /**
     * Visits a pipeline and calls reset on all the nodes. Currently only pays
     * attention to limit nodes, each of which need to be told to reset their
     * limit.
     */
    protected class ResetFinder extends PhyPlanVisitor {

        ResetFinder(PhysicalPlan plan, List<PhysicalOperator> toBeReset) {
            super(plan,
                    new DependencyOrderWalker<PhysicalOperator, PhysicalPlan>(
                            plan));
        }

        @Override
        public void visitDistinct(PODistinct d) throws VisitorException {
            // FIXME: add only if limit is present
            opsToBeReset.add(d);
        }

        @Override
        public void visitLimit(POLimit limit) throws VisitorException {
            opsToBeReset.add(limit);
        }

        @Override
        public void visitSort(POSort sort) throws VisitorException {
            // FIXME: add only if limit is present
            opsToBeReset.add(sort);
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans
         * .PhyPlanVisitor
         * #visitProject(org.apache.pig.backend.hadoop.executionengine
         * .physicalLayer.expressionOperators.POProject)
         */
        @Override
        public void visitProject(POProject proj) throws VisitorException {
            if (proj instanceof PORelationToExprProject) {
                opsToBeReset.add(proj);
            }
        }
    }

    /**
     * @return the opsToBeReset
     */
    public List<PhysicalOperator> getOpsToBeReset() {
        return opsToBeReset;
    }

    /**
     * @param opsToBeReset
     *            the opsToBeReset to set
     */
    public void setOpsToBeReset(List<PhysicalOperator> opsToBeReset) {
        this.opsToBeReset = opsToBeReset;
    }

    protected Tuple illustratorMarkup2(Object[] in, Object out) {
        if (illustrator != null) {
            ExampleTuple tOut = new ExampleTuple((Tuple) out);
            illustrator.getLineage().insert(tOut);
            boolean synthetic = false;
            for (Object tIn : in) {
                synthetic |= ((ExampleTuple) tIn).synthetic;
                illustrator.getLineage().union(tOut, (Tuple) tIn);
            }
            illustrator.addData(tOut);
            int i;
            for (i = 0; i < noItems; ++i) {
                if (((DataBag) bags[i]).size() < 2) {
                    break;
                }
            }
            if (i >= noItems && !illustrator.getEqClassesShared()) {
                illustrator.getEquivalenceClasses().get(0).add(tOut);
            }
            tOut.synthetic = synthetic;
            return tOut;
        } else {
            return (Tuple) out;
        }
    }

    @Override
    public Tuple illustratorMarkup(Object in, Object out, int eqClassIndex) {
        if (illustrator != null) {
            ExampleTuple tOut = new ExampleTuple((Tuple) out);
            illustrator.addData(tOut);
            if (!illustrator.getEqClassesShared()) {
                illustrator.getEquivalenceClasses().get(0).add(tOut);
            }
            LineageTracer lineageTracer = illustrator.getLineage();
            lineageTracer.insert(tOut);
            tOut.synthetic = ((ExampleTuple) in).synthetic;
            lineageTracer.union((ExampleTuple) in, tOut);
            return tOut;
        } else {
            return (Tuple) out;
        }
    }

}