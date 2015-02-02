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
package org.apache.pig.newplan.logical.relational;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.util.Pair;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.OperatorPlan;
import org.apache.pig.newplan.PlanVisitor;
import org.apache.pig.newplan.ReverseDependencyOrderWalker;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.optimizer.AllSameRalationalNodesVisitor;

/**
 * Rollup operator implementation for data rollup computation.
 * This class provides a new ForEach logical operator to implement
 * IRG and Hybrid IRG approaches for rollup computation.
 */

public class LORollupH2IRGForEach extends LogicalRelationalOperator {

    private static final long serialVersionUID = 2L;

    private LogicalPlan innerPlan;
    
    private int pivot = -1;

    private int rollupFieldIndex = 0;
    
    private int rollupOldFieldIndex = 0;
    
    private int rollupSize = 0;
    
    private boolean isOnlyIRG = false;
    
    private int dimensionSize = 0;
    
    public LORollupH2IRGForEach(OperatorPlan plan) {
        super("LORollupH2IRGForEach", plan);
    }

    public LORollupH2IRGForEach(LOForEach foreach) throws FrontendException {
        super("LORollupH2IRGForEach", foreach.getPlan());
        this.setInnerPlan(foreach.getInnerPlan());
        this.setRequestedParallelism(foreach.getRequestedParallelism());
        this.setAlias(foreach.getAlias());
        this.setSchema(foreach.getSchema());
        this.setLocation(foreach.getLocation());
        Iterator<Operator> its = foreach.getInnerPlan().getOperators();
        while (its.hasNext()) {
            Operator opr = its.next();
            AttachPrjToNew(opr, this);
        }
    }
    /**
     * Set isOnlyIRG to true in case we will use IRG
     */
    public void setOnlyIRG() {
        isOnlyIRG = true;
    }
    
    /**
     * get isOnlyIRG value
     * @return
     */
    public boolean getOnlyIRG() {
        return isOnlyIRG;
    }
    
    /**
     * Set the start position of the rollup
     * @param rofi
     */
    public void setRollupOldFieldIndex(int rofi) {
        this.rollupOldFieldIndex = rofi;
    }
    
    /**
     * Get the value of the start position of rollup
     * @return
     */
    public int getRollupOldFieldIndex() {
        return this.rollupOldFieldIndex;
    }
    
    /**
     * Set number of fields that involve in rollup operator
     * @param ru_len
     */
    public void setRollupSize(int rs) {
        this.rollupSize = rs;
    }
    
    /**
     * Get number of fields that involve in rollup operator
     * @return
     */
    public int getRollupSize() {
        return this.rollupSize;
    }
    
    /**
     * Set the new position of rollup after being optimized
     * @param rfi
     */
    public void setRollupFieldIndex(int rfi) {
        this.rollupFieldIndex = rfi;
    }
    
    /**
     * Get the new position of rollup after being optimized
     * @return
     */
    public int getRollupFieldIndex() {
        return this.rollupFieldIndex;
    }
    
    /**
     * Set pivot position for rollup
     * @param pvt
     */
    public void setPivot(int pvt) {
        this.pivot = pvt;
    }
    
    /**
     * Get pivot position for rollup
     * @return
     */
    public int getPivot() {
        return this.pivot;
    }
    
    /**
     * Set number of fields involve in CUBE clause
     * @param ds
     */
    public void setDimensionSize(int ds) {
        this.dimensionSize = ds;
    }
    
    /**
     * Get number of fields involve in CUBE clause
     * @return
     */
    public int getDimensionSize() {
        return this.dimensionSize;
    }
    
    /**
     * Attach ProjectExpression from old LOForEach operator to 
     * new LORollupH2IRGForEach operator
     * @param opr
     * @param hfe
     * @throws FrontendException
     */
    private void AttachPrjToNew(Operator opr, LORollupH2IRGForEach hfe) throws FrontendException {
        
        if (opr instanceof LOGenerate) {
            LOGenerate log = (LOGenerate) opr;
            List<LogicalExpressionPlan> leps = log.getOutputPlans();
            for (LogicalExpressionPlan lep : leps) {
                Iterator<Operator> its = lep.getOperators();
                while (its.hasNext()) {
                    Operator opr2 = its.next();
                    if (opr2 instanceof ProjectExpression) {
                        if (((ProjectExpression) opr2).getAttachedRelationalOp() instanceof LOForEach)
                                ((ProjectExpression) opr2).setAttachedRelationalOp(hfe);
                        Pair<List<LOInnerLoad>, Boolean> a = findReacheableInnerLoadFromBoundaryProject((ProjectExpression)opr2);
                        List<LOInnerLoad> innerLoads = a.first;
                        boolean needNewUid = a.second;
                    }
                }
            }
        } else if (opr instanceof LOInnerLoad) {
            LOInnerLoad loi = (LOInnerLoad) opr;
            
            if (loi.getProjection().getAttachedRelationalOp() instanceof LOForEach)
                loi.getProjection().setAttachedRelationalOp(hfe);
        }
    }

    public LogicalPlan getInnerPlan() {
        return innerPlan;
    }

    public void setInnerPlan(LogicalPlan p) {
        innerPlan = p;
    }

    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (!(other instanceof LORollupH2IRGForEach)) {
            return false;
        }

        return innerPlan.isEqual(((LORollupH2IRGForEach) other).innerPlan);
    }

    @Override
    public LogicalSchema getSchema() throws FrontendException {
        List<Operator> ll = innerPlan.getSinks();
        if (ll != null) {
            schema = ((LogicalRelationalOperator) ll.get(0)).getSchema();
        }

        return schema;
    }

    @Override
    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalRelationalNodesVisitor)) {
            throw new FrontendException("Expected LogicalPlanVisitor", 2222);
        }
        ((LogicalRelationalNodesVisitor) v).visit(this);
    }

    /**
     * Find the LOInnerLoad of the inner plan corresponding to the project, and
     * also find whether there is a LOForEach in inner plan along the way
     * @param project
     * @return
     * @throws FrontendException
     */
    public static Pair<List<LOInnerLoad>, Boolean> findReacheableInnerLoadFromBoundaryProject(ProjectExpression project)
            throws FrontendException {
        boolean needNewUid = false;
        LogicalRelationalOperator referred = project.findReferent();
        // If it is nested foreach, generate new uid
        if (referred instanceof LORollupH2IRGForEach)
            needNewUid = true;
        List<Operator> srcs = referred.getPlan().getSources();
        List<LOInnerLoad> innerLoads = new ArrayList<LOInnerLoad>();
        for (Operator src : srcs) {
            if (src instanceof LOInnerLoad) {
                if (src == referred) {
                    innerLoads.add((LOInnerLoad) src);
                    continue;
                }

                Stack<Operator> stack = new Stack<Operator>();
                List<Operator> succs = referred.getPlan().getSuccessors(src);
                if (succs != null) {
                    for (Operator succ : succs) {
                        stack.push(succ);
                    }
                }

                while (!stack.isEmpty()) {
                    Operator op = stack.pop();
                    if (op == referred) {
                        innerLoads.add((LOInnerLoad) src);
                        break;
                    } else {
                        List<Operator> ops = referred.getPlan().getSuccessors(op);
                        if (ops != null) {
                            for (Operator o : ops) {
                                stack.push(o);
                            }
                        }
                    }
                }
            }
        }
        return new Pair<List<LOInnerLoad>, Boolean>(innerLoads, needNewUid);
    }

    public LogicalSchema dumpNestedSchema(String alias, String nestedAlias) throws FrontendException {
        NestedRelationalOperatorFinder opFinder = new NestedRelationalOperatorFinder(innerPlan, nestedAlias);
        opFinder.visit();

        if (opFinder.getMatchedOperator() != null) {
            LogicalSchema nestedSc = opFinder.getMatchedOperator().getSchema();
            return nestedSc;
        }
        return null;
    }

    private static class NestedRelationalOperatorFinder extends AllSameRalationalNodesVisitor {
        String aliasOfOperator;
        LogicalRelationalOperator opFound = null;

        public NestedRelationalOperatorFinder(LogicalPlan plan, String alias) throws FrontendException {
            super(plan, new ReverseDependencyOrderWalker(plan));
            aliasOfOperator = alias;
        }

        public LogicalRelationalOperator getMatchedOperator() {
            return opFound;
        }

        @Override
        public void execute(LogicalRelationalOperator op) throws FrontendException {
            if (op.getAlias() != null && op.getAlias().equals(aliasOfOperator))
                opFound = op;
        }
    }
}
