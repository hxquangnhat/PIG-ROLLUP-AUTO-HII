// $ANTLR 3.4 /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g 2014-12-22 11:35:30

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.NumValCarrier;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOCube;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LORank;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.math.BigDecimal;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", "AS", "ASC", "ASSERT", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", "BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", "CHUNKSIZE", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", "FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", "IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PIVOT", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "RATE", "REGISTER", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", "CASE_EXPR_LHS", "CASE_EXPR_RHS", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "IN_LHS", "IN_RHS", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AMPERSAND=5;
    public static final int AND=6;
    public static final int ARROBA=7;
    public static final int AS=8;
    public static final int ASC=9;
    public static final int ASSERT=10;
    public static final int BAG=11;
    public static final int BIGDECIMAL=12;
    public static final int BIGDECIMALNUMBER=13;
    public static final int BIGINTEGER=14;
    public static final int BIGINTEGERNUMBER=15;
    public static final int BOOLEAN=16;
    public static final int BY=17;
    public static final int BYTEARRAY=18;
    public static final int CACHE=19;
    public static final int CASE=20;
    public static final int CHARARRAY=21;
    public static final int CHUNKSIZE=22;
    public static final int COGROUP=23;
    public static final int COLON=24;
    public static final int COMMA=25;
    public static final int CROSS=26;
    public static final int CUBE=27;
    public static final int DATETIME=28;
    public static final int DCOLON=29;
    public static final int DEFINE=30;
    public static final int DENSE=31;
    public static final int DESC=32;
    public static final int DIGIT=33;
    public static final int DISTINCT=34;
    public static final int DIV=35;
    public static final int DOLLAR=36;
    public static final int DOLLARVAR=37;
    public static final int DOUBLE=38;
    public static final int DOUBLENUMBER=39;
    public static final int DOUBLE_PERIOD=40;
    public static final int ELSE=41;
    public static final int END=42;
    public static final int EQUAL=43;
    public static final int EXECCOMMAND=44;
    public static final int FALSE=45;
    public static final int FAT_ARROW=46;
    public static final int FILTER=47;
    public static final int FLATTEN=48;
    public static final int FLOAT=49;
    public static final int FLOATINGPOINT=50;
    public static final int FLOATNUMBER=51;
    public static final int FOREACH=52;
    public static final int FULL=53;
    public static final int GENERATE=54;
    public static final int GROUP=55;
    public static final int ID=56;
    public static final int IDENTIFIER=57;
    public static final int IF=58;
    public static final int IMPORT=59;
    public static final int IN=60;
    public static final int INNER=61;
    public static final int INPUT=62;
    public static final int INT=63;
    public static final int INTEGER=64;
    public static final int INTO=65;
    public static final int INVOKE=66;
    public static final int IS=67;
    public static final int JOIN=68;
    public static final int LEFT=69;
    public static final int LEFT_BRACKET=70;
    public static final int LEFT_CURLY=71;
    public static final int LEFT_PAREN=72;
    public static final int LETTER=73;
    public static final int LIMIT=74;
    public static final int LOAD=75;
    public static final int LONG=76;
    public static final int LONGINTEGER=77;
    public static final int MAP=78;
    public static final int MAPREDUCE=79;
    public static final int MINUS=80;
    public static final int ML_COMMENT=81;
    public static final int MULTILINE_QUOTEDSTRING=82;
    public static final int NOT=83;
    public static final int NULL=84;
    public static final int NUM_OP_EQ=85;
    public static final int NUM_OP_GT=86;
    public static final int NUM_OP_GTE=87;
    public static final int NUM_OP_LT=88;
    public static final int NUM_OP_LTE=89;
    public static final int NUM_OP_NE=90;
    public static final int ONSCHEMA=91;
    public static final int OR=92;
    public static final int ORDER=93;
    public static final int OTHERWISE=94;
    public static final int OUTER=95;
    public static final int OUTPUT=96;
    public static final int PARALLEL=97;
    public static final int PARTITION=98;
    public static final int PERCENT=99;
    public static final int PERIOD=100;
    public static final int PIVOT=101;
    public static final int PLUS=102;
    public static final int POUND=103;
    public static final int QMARK=104;
    public static final int QUOTEDSTRING=105;
    public static final int RANK=106;
    public static final int RATE=107;
    public static final int REGISTER=108;
    public static final int RETURNS=109;
    public static final int RIGHT=110;
    public static final int RIGHT_BRACKET=111;
    public static final int RIGHT_CURLY=112;
    public static final int RIGHT_PAREN=113;
    public static final int ROLLUP=114;
    public static final int SAMPLE=115;
    public static final int SEMI_COLON=116;
    public static final int SHIP=117;
    public static final int SL_COMMENT=118;
    public static final int SPECIALCHAR=119;
    public static final int SPLIT=120;
    public static final int STAR=121;
    public static final int STDERROR=122;
    public static final int STDIN=123;
    public static final int STDOUT=124;
    public static final int STORE=125;
    public static final int STREAM=126;
    public static final int STR_OP_EQ=127;
    public static final int STR_OP_GT=128;
    public static final int STR_OP_GTE=129;
    public static final int STR_OP_LT=130;
    public static final int STR_OP_LTE=131;
    public static final int STR_OP_MATCHES=132;
    public static final int STR_OP_NE=133;
    public static final int THEN=134;
    public static final int THROUGH=135;
    public static final int TRUE=136;
    public static final int TUPLE=137;
    public static final int UNION=138;
    public static final int USING=139;
    public static final int VOID=140;
    public static final int WHEN=141;
    public static final int WS=142;
    public static final int ANY=143;
    public static final int BAG_TYPE=144;
    public static final int BAG_TYPE_CAST=145;
    public static final int BAG_VAL=146;
    public static final int BIN_EXPR=147;
    public static final int BOOL=148;
    public static final int BOOL_COND=149;
    public static final int CASE_COND=150;
    public static final int CASE_EXPR=151;
    public static final int CASE_EXPR_LHS=152;
    public static final int CASE_EXPR_RHS=153;
    public static final int CAST_EXPR=154;
    public static final int COL_RANGE=155;
    public static final int EXPR_IN_PAREN=156;
    public static final int FIELD_DEF=157;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=158;
    public static final int FOREACH_PLAN_COMPLEX=159;
    public static final int FOREACH_PLAN_SIMPLE=160;
    public static final int FUNC=161;
    public static final int FUNC_EVAL=162;
    public static final int FUNC_REF=163;
    public static final int INVOKER_FUNC_EVAL=164;
    public static final int IN_LHS=165;
    public static final int IN_RHS=166;
    public static final int JOIN_ITEM=167;
    public static final int KEY_VAL_PAIR=168;
    public static final int MACRO_BODY=169;
    public static final int MACRO_DEF=170;
    public static final int MACRO_INLINE=171;
    public static final int MAP_TYPE=172;
    public static final int MAP_VAL=173;
    public static final int NEG=174;
    public static final int NESTED_CMD=175;
    public static final int NESTED_CMD_ASSI=176;
    public static final int NESTED_PROJ=177;
    public static final int PARAMS=178;
    public static final int QUERY=179;
    public static final int REALIAS=180;
    public static final int RETURN_VAL=181;
    public static final int SPLIT_BRANCH=182;
    public static final int STATEMENT=183;
    public static final int TOBAG=184;
    public static final int TOMAP=185;
    public static final int TOTUPLE=186;
    public static final int TUPLE_TYPE=187;
    public static final int TUPLE_TYPE_CAST=188;
    public static final int TUPLE_VAL=189;
    public static final int EVAL=190;
    public static final int MATCHES=191;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

    public String getLastRel() {
        return builder.getLastRel();
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query87); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query89);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:162:1: statement : ( general_statement | split_statement | realias_statement | assert_statement | register_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;

        LogicalPlanGenerator.assert_statement_return assert_statement6 =null;

        LogicalPlanGenerator.register_statement_return register_statement7 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:2: ( general_statement | split_statement | realias_statement | assert_statement | register_statement )
            int alt2=5;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            case ASSERT:
                {
                alt2=4;
                }
                break;
            case REGISTER:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement111);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement116);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:175:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement121);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:176:4: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement126);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:177:4: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement131);
                    register_statement7=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement7.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:17: ( split_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement140);
            split_clause8=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause8.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:19: ( realias_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement149);
            realias_clause9=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause9.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:1: assert_statement : assert_clause ;
    public final LogicalPlanGenerator.assert_statement_return assert_statement() throws RecognitionException {
        LogicalPlanGenerator.assert_statement_return retval = new LogicalPlanGenerator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.assert_clause_return assert_clause10 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:18: ( assert_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement158);
            assert_clause10=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause10.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_statement"


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final LogicalPlanGenerator.register_statement_return register_statement() throws RecognitionException {
        LogicalPlanGenerator.register_statement_return retval = new LogicalPlanGenerator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER11=null;
        CommonTree QUOTEDSTRING12=null;
        CommonTree USING13=null;
        CommonTree IDENTIFIER14=null;
        CommonTree AS15=null;
        CommonTree IDENTIFIER16=null;

        CommonTree REGISTER11_tree=null;
        CommonTree QUOTEDSTRING12_tree=null;
        CommonTree USING13_tree=null;
        CommonTree IDENTIFIER14_tree=null;
        CommonTree AS15_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER11=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER11_tree = (CommonTree)adaptor.dupNode(REGISTER11);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


            adaptor.addChild(root_1, QUOTEDSTRING12_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:28: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:29: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING13=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING13_tree = (CommonTree)adaptor.dupNode(USING13);


                    adaptor.addChild(root_1, USING13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


                    adaptor.addChild(root_1, IDENTIFIER14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS15=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS15_tree = (CommonTree)adaptor.dupNode(AS15);


                    adaptor.addChild(root_1, AS15_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


                    adaptor.addChild(root_1, IDENTIFIER16_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                // registers are handled by QueryParserDriver and are not actually part of the logical plan
                // so we just ignore them here
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias18 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause19 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:16: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement203);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias18!=null?alias18.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement214);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement216);
                    parallel_clause19=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause19.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:205:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS20=null;
        CommonTree IDENTIFIER22=null;
        LogicalPlanGenerator.alias_return alias21 =null;


        CommonTree REALIAS20_tree=null;
        CommonTree IDENTIFIER22_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS20=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS20_tree = (CommonTree)adaptor.dupNode(REALIAS20);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS20_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause235);
            alias21=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias21.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


            adaptor.addChild(root_1, IDENTIFIER22_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER22!=null?IDENTIFIER22.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input,
            	            new SourceLocation( (PigParserNode)IDENTIFIER22 ), (IDENTIFIER22!=null?IDENTIFIER22.getText():null));
            	    }
            	    builder.putOperator( (alias21!=null?alias21.name:null), (LogicalRelationalOperator)op );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:217:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL23=null;
        CommonTree INTEGER24=null;

        CommonTree PARALLEL23_tree=null;
        CommonTree INTEGER24_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:2: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL23=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL23_tree = (CommonTree)adaptor.dupNode(PARALLEL23);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL23_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER24=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER24_tree = (CommonTree)adaptor.dupNode(INTEGER24);


            adaptor.addChild(root_1, INTEGER24_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER24!=null?INTEGER24.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER25=null;

        CommonTree IDENTIFIER25_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:27: ( IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER25=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER25_tree = (CommonTree)adaptor.dupNode(IDENTIFIER25);


            adaptor.addChild(root_0, IDENTIFIER25_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER25!=null?IDENTIFIER25.getText():null); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause26 =null;

        LogicalPlanGenerator.load_clause_return load_clause27 =null;

        LogicalPlanGenerator.group_clause_return group_clause28 =null;

        LogicalPlanGenerator.store_clause_return store_clause29 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause30 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause31 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause32 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause33 =null;

        LogicalPlanGenerator.order_clause_return order_clause34 =null;

        LogicalPlanGenerator.rank_clause_return rank_clause35 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause36 =null;

        LogicalPlanGenerator.join_clause_return join_clause37 =null;

        LogicalPlanGenerator.union_clause_return union_clause38 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause39 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause40 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause41 =null;

        LogicalPlanGenerator.cube_clause_return cube_clause42 =null;

        LogicalPlanGenerator.assert_clause_return assert_clause43 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=18;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt6=1;
                }
                break;
            case LOAD:
                {
                alt6=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt6=3;
                }
                break;
            case STORE:
                {
                alt6=4;
                }
                break;
            case FILTER:
                {
                alt6=5;
                }
                break;
            case DISTINCT:
                {
                alt6=6;
                }
                break;
            case LIMIT:
                {
                alt6=7;
                }
                break;
            case SAMPLE:
                {
                alt6=8;
                }
                break;
            case ORDER:
                {
                alt6=9;
                }
                break;
            case RANK:
                {
                alt6=10;
                }
                break;
            case CROSS:
                {
                alt6=11;
                }
                break;
            case JOIN:
                {
                alt6=12;
                }
                break;
            case UNION:
                {
                alt6=13;
                }
                break;
            case STREAM:
                {
                alt6=14;
                }
                break;
            case MAPREDUCE:
                {
                alt6=15;
                }
                break;
            case FOREACH:
                {
                alt6=16;
                }
                break;
            case CUBE:
                {
                alt6=17;
                }
                break;
            case ASSERT:
                {
                alt6=18;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause302);
                    define_clause26=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:229:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause316);
                    load_clause27=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause27!=null?load_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:230:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause332);
                    group_clause28=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause28!=null?group_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:231:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause348);
                    store_clause29=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause29!=null?store_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:232:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause364);
                    filter_clause30=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause30!=null?filter_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:233:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause31=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause31!=null?distinct_clause31.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:234:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause396);
                    limit_clause32=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause32.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause32!=null?limit_clause32.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:235:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause412);
                    sample_clause33=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause33.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause33!=null?sample_clause33.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:236:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause428);
                    order_clause34=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause34.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause34!=null?order_clause34.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:237:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause444);
                    rank_clause35=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause35.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (rank_clause35!=null?rank_clause35.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:238:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause460);
                    cross_clause36=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause36.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause36!=null?cross_clause36.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:239:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause476);
                    join_clause37=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause37.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause37!=null?join_clause37.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:240:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause492);
                    union_clause38=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause38.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause38!=null?union_clause38.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:241:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause508);
                    stream_clause39=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause39.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause39!=null?stream_clause39.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:242:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause524);
                    mr_clause40=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause40.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause40!=null?mr_clause40.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:243:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause540);
                    foreach_clause41=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause41.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause41!=null?foreach_clause41.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause556);
                    cube_clause42=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause42.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cube_clause42!=null?cube_clause42.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:245:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause572);
                    assert_clause43=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause43.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (assert_clause43!=null?assert_clause43.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:248:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE44=null;
        CommonTree DEFINE47=null;
        LogicalPlanGenerator.alias_return alias45 =null;

        LogicalPlanGenerator.cmd_return cmd46 =null;

        LogicalPlanGenerator.alias_return alias48 =null;

        LogicalPlanGenerator.func_clause_return func_clause49 =null;


        CommonTree DEFINE44_tree=null;
        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DEFINE) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==DOWN) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==IDENTIFIER) ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==EXECCOMMAND) ) {
                            alt7=1;
                        }
                        else if ( (LA7_3==FUNC||LA7_3==FUNC_REF) ) {
                            alt7=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE44=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE44_tree = (CommonTree)adaptor.dupNode(DEFINE44);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE44_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause588);
                    alias45=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias45.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause590);
                    cmd46=cmd((alias45!=null?alias45.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd46.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias45!=null?alias45.name:null), (cmd46!=null?cmd46.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause607);
                    alias48=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias48.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause609);
                    func_clause49=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause49.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias48!=null?alias48.name:null), (func_clause49!=null?func_clause49.funcSpec:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:259:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND50=null;
        LogicalPlanGenerator.ship_clause_return ship_clause51 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause52 =null;

        LogicalPlanGenerator.input_clause_return input_clause53 =null;

        LogicalPlanGenerator.output_clause_return output_clause54 =null;

        LogicalPlanGenerator.error_clause_return error_clause55 =null;


        CommonTree EXECCOMMAND50_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND50=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND50_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND50);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND50_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
                loop8:
                do {
                    int alt8=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt8=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt8=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt8=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt8=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt8=5;
                        }
                        break;

                    }

                    switch (alt8) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd642);
                	    ship_clause51=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause51.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd647);
                	    cache_clause52=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause52.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd652);
                	    input_clause53=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause53.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd656);
                	    output_clause54=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause54.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd660);
                	    error_clause55=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause55.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND50!=null?EXECCOMMAND50.getText():null) ), shipPaths,
                       cachePaths, (input_clause53!=null?input_clause53.inputHandleSpecs:null), (output_clause54!=null?output_clause54.outputHandleSpecs:null),
                       (error_clause55!=null?error_clause55.dir:null), (error_clause55!=null?error_clause55.limit:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP56=null;
        LogicalPlanGenerator.path_list_return path_list57 =null;


        CommonTree SHIP56_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP56=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP56_tree = (CommonTree)adaptor.dupNode(SHIP56);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP56_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: ( path_list[$paths] )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause685);
                        path_list57=path_list(paths);

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list57.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING58=null;

        CommonTree QUOTEDSTRING58_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:2: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING58=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list702); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING58_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING58);


            	    adaptor.addChild(root_0, QUOTEDSTRING58_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING58!=null?QUOTEDSTRING58.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:281:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE59=null;
        LogicalPlanGenerator.path_list_return path_list60 =null;


        CommonTree CACHE59_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:2: ( ^( CACHE path_list[$paths] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE59=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE59_tree = (CommonTree)adaptor.dupNode(CACHE59);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause722);
            path_list60=path_list(paths);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list60.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:285:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT61=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd62 =null;


        CommonTree INPUT61_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT61=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT61_tree = (CommonTree)adaptor.dupNode(INPUT61);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT61_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:13: ( stream_cmd[true] )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause749);
            	    stream_cmd62=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd62.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd62!=null?stream_cmd62.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:292:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN63=null;
        CommonTree STDOUT65=null;
        CommonTree QUOTEDSTRING67=null;
        LogicalPlanGenerator.func_clause_return func_clause64 =null;

        LogicalPlanGenerator.func_clause_return func_clause66 =null;

        LogicalPlanGenerator.func_clause_return func_clause68 =null;


        CommonTree STDIN63_tree=null;
        CommonTree STDOUT65_tree=null;
        CommonTree QUOTEDSTRING67_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt15=1;
                }
                break;
            case STDOUT:
                {
                alt15=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN63=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN63_tree = (CommonTree)adaptor.dupNode(STDIN63);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN63_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd795);
                                func_clause64=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause64.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause64!=null?func_clause64.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:306:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT65=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT65_tree = (CommonTree)adaptor.dupNode(STDOUT65);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT65_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd822);
                                func_clause66=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause66.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause66!=null?func_clause66.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:308:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING67=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING67_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING67);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING67_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING67!=null?QUOTEDSTRING67.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:7: ( func_clause[ft] )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd849);
                                func_clause68=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause68.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause68!=null?func_clause68.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:312:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT69=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd70 =null;


        CommonTree OUTPUT69_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT69=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause877); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT69_tree = (CommonTree)adaptor.dupNode(OUTPUT69);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:14: ( stream_cmd[false] )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause881);
            	    stream_cmd70=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd70.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd70!=null?stream_cmd70.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:319:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR71=null;
        CommonTree QUOTEDSTRING72=null;
        CommonTree INTEGER73=null;

        CommonTree STDERROR71_tree=null;
        CommonTree QUOTEDSTRING72_tree=null;
        CommonTree INTEGER73_tree=null;


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR71=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR71_tree = (CommonTree)adaptor.dupNode(STDERROR71);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR71_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING72=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause919); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING72_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING72);


                        adaptor.addChild(root_1, QUOTEDSTRING72_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING72!=null?QUOTEDSTRING72.getText():null) );
                                }

                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:9: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER73=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause941); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER73_tree = (CommonTree)adaptor.dupNode(INTEGER73);


                                adaptor.addChild(root_1, INTEGER73_tree);
                                }


                                if ( state.backtracking==0 ) {
                                              retval.limit = Integer.parseInt( (INTEGER73!=null?INTEGER73.getText():null) );
                                          }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD74=null;
        LogicalPlanGenerator.filename_return filename75 =null;

        LogicalPlanGenerator.func_clause_return func_clause76 =null;

        LogicalPlanGenerator.as_clause_return as_clause77 =null;


        CommonTree LOAD74_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD74=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause994); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD74_tree = (CommonTree)adaptor.dupNode(LOAD74);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD74_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause996);
            filename75=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename75.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause998);
                    func_clause76=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause76.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause1002);
                    as_clause77=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename75!=null?filename75.filename:null), (func_clause76!=null?func_clause76.funcSpec:null), (as_clause77!=null?as_clause77.logicalSchema:null)  );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:346:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING78=null;

        CommonTree QUOTEDSTRING78_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING78=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING78_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING78);


            adaptor.addChild(root_0, QUOTEDSTRING78_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING78!=null?QUOTEDSTRING78.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:350:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS79=null;
        LogicalPlanGenerator.field_def_list_return field_def_list80 =null;


        CommonTree AS79_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:2: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS79=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1039); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS79_tree = (CommonTree)adaptor.dupNode(AS79);


            root_1 = (CommonTree)adaptor.becomeRoot(AS79_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1041);
            field_def_list80=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list80.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list80!=null?field_def_list80.schema:null));
                    retval.logicalSchema = (field_def_list80!=null?field_def_list80.schema:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:358:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
    public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF81=null;
        CommonTree IDENTIFIER82=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84=null;
        LogicalPlanGenerator.type_return type83 =null;

        LogicalPlanGenerator.type_return type85 =null;


        CommonTree FIELD_DEF81_tree=null;
        CommonTree IDENTIFIER82_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84_tree=null;


            byte datatype = DataType.NULL;
            if (nvc==null) {
                nvc =new NumValCarrier();
            }

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                alt22=1;
            }
            else if ( (LA22_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF81=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF81_tree = (CommonTree)adaptor.dupNode(FIELD_DEF81);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER82=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER82_tree = (CommonTree)adaptor.dupNode(IDENTIFIER82);


                    adaptor.addChild(root_1, IDENTIFIER82_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:28: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:30: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1075);
                            type83=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type83.getTree());


                            if ( state.backtracking==0 ) { datatype = (type83!=null?type83.datatype:null);}

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER82!=null?IDENTIFIER82.getText():null), (type83!=null?type83.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER84=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER84_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER84);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:36: ( type )
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:38: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1098);
                    type85=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type85.getTree());


                    if ( state.backtracking==0 ) { datatype = (type85!=null?type85.datatype:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema ( nvc.makeNameFromDataType(datatype) , (type85!=null?type85.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:375:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def86 =null;




            retval.schema = new LogicalSchema();
            NumValCarrier nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:2: ( ( field_def[nvc] )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= FIELD_DEF && LA23_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:6: field_def[nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1129);
            	    field_def86=field_def(nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def86.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def86!=null?field_def86.fieldSchema:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:384:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type87 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type88 =null;

        LogicalPlanGenerator.bag_type_return bag_type89 =null;

        LogicalPlanGenerator.map_type_return map_type90 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:2: ( simple_type | tuple_type | bag_type | map_type )
            int alt24=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt24=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt24=2;
                }
                break;
            case BAG_TYPE:
                {
                alt24=3;
                }
                break;
            case MAP_TYPE:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1149);
                    simple_type87=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type87.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type87!=null?simple_type87.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:389:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1159);
                    tuple_type88=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type88.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type88!=null?tuple_type88.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:394:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1169);
                    bag_type89=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type89.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type89!=null?bag_type89.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:399:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1179);
                    map_type90=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type90.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type90!=null?map_type90.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:406:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN91=null;
        CommonTree INT92=null;
        CommonTree LONG93=null;
        CommonTree FLOAT94=null;
        CommonTree DOUBLE95=null;
        CommonTree BIGINTEGER96=null;
        CommonTree BIGDECIMAL97=null;
        CommonTree DATETIME98=null;
        CommonTree CHARARRAY99=null;
        CommonTree BYTEARRAY100=null;

        CommonTree BOOLEAN91_tree=null;
        CommonTree INT92_tree=null;
        CommonTree LONG93_tree=null;
        CommonTree FLOAT94_tree=null;
        CommonTree DOUBLE95_tree=null;
        CommonTree BIGINTEGER96_tree=null;
        CommonTree BIGDECIMAL97_tree=null;
        CommonTree DATETIME98_tree=null;
        CommonTree CHARARRAY99_tree=null;
        CommonTree BYTEARRAY100_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt25=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case LONG:
                {
                alt25=3;
                }
                break;
            case FLOAT:
                {
                alt25=4;
                }
                break;
            case DOUBLE:
                {
                alt25=5;
                }
                break;
            case BIGINTEGER:
                {
                alt25=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt25=7;
                }
                break;
            case DATETIME:
                {
                alt25=8;
                }
                break;
            case CHARARRAY:
                {
                alt25=9;
                }
                break;
            case BYTEARRAY:
                {
                alt25=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN91=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN91_tree = (CommonTree)adaptor.dupNode(BOOLEAN91);


                    adaptor.addChild(root_0, BOOLEAN91_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT92=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT92_tree = (CommonTree)adaptor.dupNode(INT92);


                    adaptor.addChild(root_0, INT92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:409:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG93=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG93_tree = (CommonTree)adaptor.dupNode(LONG93);


                    adaptor.addChild(root_0, LONG93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:410:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT94=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT94_tree = (CommonTree)adaptor.dupNode(FLOAT94);


                    adaptor.addChild(root_0, FLOAT94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:411:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE95=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE95_tree = (CommonTree)adaptor.dupNode(DOUBLE95);


                    adaptor.addChild(root_0, DOUBLE95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:412:4: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER96=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER96_tree = (CommonTree)adaptor.dupNode(BIGINTEGER96);


                    adaptor.addChild(root_0, BIGINTEGER96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:413:4: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL97=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL97_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL97);


                    adaptor.addChild(root_0, BIGDECIMAL97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:414:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME98=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME98_tree = (CommonTree)adaptor.dupNode(DATETIME98);


                    adaptor.addChild(root_0, DATETIME98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:415:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY99=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY99_tree = (CommonTree)adaptor.dupNode(CHARARRAY99);


                    adaptor.addChild(root_0, CHARARRAY99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:416:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY100=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY100_tree = (CommonTree)adaptor.dupNode(BYTEARRAY100);


                    adaptor.addChild(root_0, BYTEARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:419:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE101=null;
        LogicalPlanGenerator.field_def_list_return field_def_list102 =null;


        CommonTree TUPLE_TYPE101_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE101=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE101_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE101);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE101_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:7: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1287);
                        field_def_list102=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list102.getTree());


                        if ( state.backtracking==0 ) {
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list102!=null?field_def_list102.schema:null));
                                    retval.logicalSchema = (field_def_list102!=null?field_def_list102.schema:null);
                                }

                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE103=null;
        CommonTree IDENTIFIER104=null;
        LogicalPlanGenerator.tuple_type_return tuple_type105 =null;


        CommonTree BAG_TYPE103_tree=null;
        CommonTree IDENTIFIER104_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE103=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE103_tree = (CommonTree)adaptor.dupNode(BAG_TYPE103);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE103_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER104=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1329); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER104_tree = (CommonTree)adaptor.dupNode(IDENTIFIER104);


                        adaptor.addChild(root_1, IDENTIFIER104_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1332);
                        tuple_type105=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type105.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if ((tuple_type105!=null?tuple_type105.logicalSchema:null)!=null && (tuple_type105!=null?tuple_type105.logicalSchema:null).size()==1 && (tuple_type105!=null?tuple_type105.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type105!=null?tuple_type105.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER104!=null?IDENTIFIER104.getText():null), (tuple_type105!=null?tuple_type105.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
                   }
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE106=null;
        LogicalPlanGenerator.type_return type107 =null;


        CommonTree MAP_TYPE106_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:2: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE106=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE106_tree = (CommonTree)adaptor.dupNode(MAP_TYPE106);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE106_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1357);
                        type107=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type107.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   LogicalSchema s = null;
                   if( (type107!=null?type107.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type107!=null?type107.logicalSchema:null), (type107!=null?type107.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:456:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF108=null;
        CommonTree FUNC110=null;
        LogicalPlanGenerator.func_name_return func_name109 =null;

        LogicalPlanGenerator.func_name_return func_name111 =null;

        LogicalPlanGenerator.func_args_return func_args112 =null;


        CommonTree FUNC_REF108_tree=null;
        CommonTree FUNC110_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FUNC_REF) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNC) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF108=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF108_tree = (CommonTree)adaptor.dupNode(FUNC_REF108);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF108_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1388);
                    func_name109=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name109.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name109!=null?func_name109.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name109!=null?func_name109.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC110=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC110_tree = (CommonTree)adaptor.dupNode(FUNC110);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC110_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1404);
                    func_name111=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name111.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1406);
                            func_args112=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args112.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name111!=null?func_name111.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args112!=null?func_args112.args:null) != null )
                                   argList = (func_args112!=null?func_args112.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name111!=null?func_name111.funcName:null), argList, ft );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:478:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD113=null;
        CommonTree DOLLAR114=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD113_tree=null;
        CommonTree DOLLAR114_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1436);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOLLAR||LA33_0==PERIOD) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==PERIOD) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==DOLLAR) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD113=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1450); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD113_tree = (CommonTree)adaptor.dupNode(PERIOD113);


            	            adaptor.addChild(root_0, PERIOD113_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD113!=null?PERIOD113.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR114=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1456); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR114_tree = (CommonTree)adaptor.dupNode(DOLLAR114);


            	            adaptor.addChild(root_0, DOLLAR114_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR114!=null?DOLLAR114.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1472);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:488:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING115=null;
        CommonTree MULTILINE_QUOTEDSTRING116=null;

        CommonTree QUOTEDSTRING115_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING116_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt34=0;
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==QUOTEDSTRING) ) {
                    alt34=1;
                }
                else if ( (LA34_0==MULTILINE_QUOTEDSTRING) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING115=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1501); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING115_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING115);


            	    adaptor.addChild(root_0, QUOTEDSTRING115_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING115!=null?QUOTEDSTRING115.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:491:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING116=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING116_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING116);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING116_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING116!=null?MULTILINE_QUOTEDSTRING116.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class pivot_clause_return extends TreeRuleReturnScope {
        public int pivot;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:1: pivot_clause returns [int pivot] : ^( PIVOT INTEGER ) ;
    public final LogicalPlanGenerator.pivot_clause_return pivot_clause() throws RecognitionException {
        LogicalPlanGenerator.pivot_clause_return retval = new LogicalPlanGenerator.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT117=null;
        CommonTree INTEGER118=null;

        CommonTree PIVOT117_tree=null;
        CommonTree INTEGER118_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:502:2: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:502:4: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT117=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1539); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT117_tree = (CommonTree)adaptor.dupNode(PIVOT117);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT117_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER118=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1541); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER118_tree = (CommonTree)adaptor.dupNode(INTEGER118);


            adaptor.addChild(root_1, INTEGER118_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.pivot = Integer.parseInt( (INTEGER118!=null?INTEGER118.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pivot_clause"


    public static class chunksize_clause_return extends TreeRuleReturnScope {
        public int chunksize;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chunksize_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:508:1: chunksize_clause returns [int chunksize] : ^( CHUNKSIZE INTEGER ) ;
    public final LogicalPlanGenerator.chunksize_clause_return chunksize_clause() throws RecognitionException {
        LogicalPlanGenerator.chunksize_clause_return retval = new LogicalPlanGenerator.chunksize_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CHUNKSIZE119=null;
        CommonTree INTEGER120=null;

        CommonTree CHUNKSIZE119_tree=null;
        CommonTree INTEGER120_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:509:2: ( ^( CHUNKSIZE INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:509:4: ^( CHUNKSIZE INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CHUNKSIZE119=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_chunksize_clause1563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CHUNKSIZE119_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE119);


            root_1 = (CommonTree)adaptor.becomeRoot(CHUNKSIZE119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER120=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_chunksize_clause1565); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER120_tree = (CommonTree)adaptor.dupNode(INTEGER120);


            adaptor.addChild(root_1, INTEGER120_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.chunksize = Integer.parseInt( (INTEGER120!=null?INTEGER120.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "chunksize_clause"


    public static class rate_clause_return extends TreeRuleReturnScope {
        public double rate;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rate_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:515:1: rate_clause returns [double rate] : ^( RATE DOUBLENUMBER ) ;
    public final LogicalPlanGenerator.rate_clause_return rate_clause() throws RecognitionException {
        LogicalPlanGenerator.rate_clause_return retval = new LogicalPlanGenerator.rate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RATE121=null;
        CommonTree DOUBLENUMBER122=null;

        CommonTree RATE121_tree=null;
        CommonTree DOUBLENUMBER122_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:516:2: ( ^( RATE DOUBLENUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:516:4: ^( RATE DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RATE121=(CommonTree)match(input,RATE,FOLLOW_RATE_in_rate_clause1587); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RATE121_tree = (CommonTree)adaptor.dupNode(RATE121);


            root_1 = (CommonTree)adaptor.becomeRoot(RATE121_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            DOUBLENUMBER122=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_rate_clause1589); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLENUMBER122_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER122);


            adaptor.addChild(root_1, DOUBLENUMBER122_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.rate = Double.parseDouble( (DOUBLENUMBER122!=null?DOUBLENUMBER122.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rate_clause"


    protected static class cube_clause_scope {
        LOCube cubeOp;
        MultiMap<Integer, LogicalExpressionPlan> cubePlans;
        List<String> operations;
        int inputIndex;
        int pivot;
        int chunksize;
        double rate;
    }
    protected Stack cube_clause_stack = new Stack();


    public static class cube_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:522:1: cube_clause returns [String alias] : ^( CUBE cube_item ) ;
    public final LogicalPlanGenerator.cube_clause_return cube_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        cube_clause_stack.push(new cube_clause_scope());
        LogicalPlanGenerator.cube_clause_return retval = new LogicalPlanGenerator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE123=null;
        LogicalPlanGenerator.cube_item_return cube_item124 =null;


        CommonTree CUBE123_tree=null;


            ((cube_clause_scope)cube_clause_stack.peek()).cubeOp = builder.createCubeOp();
            ((GScope_scope)GScope_stack.peek()).currentOp = ((cube_clause_scope)cube_clause_stack.peek()).cubeOp;
            ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((cube_clause_scope)cube_clause_stack.peek()).operations = new ArrayList<String>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:539:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:539:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE123=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1625); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE123_tree = (CommonTree)adaptor.dupNode(CUBE123);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE123_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1627);
            cube_item124=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item124.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                   retval.alias = builder.buildCubeOp( loc, ((cube_clause_scope)cube_clause_stack.peek()).cubeOp, ((statement_scope)statement_stack.peek()).alias,
                   ((statement_scope)statement_stack.peek()).inputAlias, ((cube_clause_scope)cube_clause_stack.peek()).operations, ((cube_clause_scope)cube_clause_stack.peek()).cubePlans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            cube_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:547:1: cube_item : rel ( cube_by_clause ) ;
    public final LogicalPlanGenerator.cube_item_return cube_item() throws RecognitionException {
        LogicalPlanGenerator.cube_item_return retval = new LogicalPlanGenerator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel125 =null;

        LogicalPlanGenerator.cube_by_clause_return cube_by_clause126 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:548:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:548:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1644);
            rel125=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel125.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:548:8: ( cube_by_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:548:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1648);
            cube_by_clause126=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause126.getTree());


            if ( state.backtracking==0 ) {
                   ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = (cube_by_clause126!=null?cube_by_clause126.plans:null);
                   ((cube_clause_scope)cube_clause_stack.peek()).operations = (cube_by_clause126!=null?cube_by_clause126.operations:null);
               }

            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:1: cube_by_clause returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ^( BY cube_or_rollup ) ;
    public final LogicalPlanGenerator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        LogicalPlanGenerator.cube_by_clause_return retval = new LogicalPlanGenerator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY127=null;
        LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup128 =null;


        CommonTree BY127_tree=null;


            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:560:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:560:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY127=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1675); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY127_tree = (CommonTree)adaptor.dupNode(BY127);


            root_1 = (CommonTree)adaptor.becomeRoot(BY127_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1677);
            cube_or_rollup128=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup128.getTree());


            if ( state.backtracking==0 ) { retval.operations = (cube_or_rollup128!=null?cube_or_rollup128.operations:null); retval.plans = (cube_or_rollup128!=null?cube_or_rollup128.plans:null); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:563:1: cube_or_rollup returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ( cube_rollup_list )+ ;
    public final LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        LogicalPlanGenerator.cube_or_rollup_return retval = new LogicalPlanGenerator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list129 =null;




            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:568:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:568:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:568:4: ( cube_rollup_list )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==CUBE||LA35_0==ROLLUP) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:568:6: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1700);
            	    cube_rollup_list129=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list129.getTree());


            	    if ( state.backtracking==0 ) {
            	           retval.operations.add((cube_rollup_list129!=null?cube_rollup_list129.operation:null));
            	           retval.plans.put( ((cube_clause_scope)cube_clause_stack.peek()).inputIndex, (cube_rollup_list129!=null?cube_rollup_list129.plans:null));
            	           ((cube_clause_scope)cube_clause_stack.peek()).inputIndex++;
            	       }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        public String operation;
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:576:1: cube_rollup_list returns [String operation, List<LogicalExpressionPlan> plans] : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) );
    public final LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        LogicalPlanGenerator.cube_rollup_list_return retval = new LogicalPlanGenerator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE130=null;
        CommonTree ROLLUP132=null;
        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list131 =null;

        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list133 =null;

        LogicalPlanGenerator.pivot_clause_return pivot_clause134 =null;

        LogicalPlanGenerator.chunksize_clause_return chunksize_clause135 =null;

        LogicalPlanGenerator.rate_clause_return rate_clause136 =null;


        CommonTree CUBE130_tree=null;
        CommonTree ROLLUP132_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:2: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==CUBE) ) {
                alt37=1;
            }
            else if ( (LA37_0==ROLLUP) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:4: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE130=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE130_tree = (CommonTree)adaptor.dupNode(CUBE130);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE130_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "CUBE"; }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1732);
                    cube_by_expr_list131=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list131.getTree());


                    if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list131!=null?cube_by_expr_list131.plans:null); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:98: ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP132=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP132_tree = (CommonTree)adaptor.dupNode(ROLLUP132);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP132_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "ROLLUP"; }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1746);
                    cube_by_expr_list133=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list133.getTree());


                    if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list133!=null?cube_by_expr_list133.plans:null); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:192: ( pivot_clause | ( chunksize_clause rate_clause ) )?
                    int alt36=3;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==PIVOT) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==CHUNKSIZE) ) {
                        alt36=2;
                    }
                    switch (alt36) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:194: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1752);
                            pivot_clause134=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause134.getTree());


                            if ( state.backtracking==0 ) { builder.setPivotRollupCubeOp(((cube_clause_scope)cube_clause_stack.peek()).cubeOp, (pivot_clause134!=null?pivot_clause134.pivot:0)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:286: ( chunksize_clause rate_clause )
                            {
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:286: ( chunksize_clause rate_clause )
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:288: chunksize_clause rate_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_chunksize_clause_in_cube_rollup_list1760);
                            chunksize_clause135=chunksize_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, chunksize_clause135.getTree());


                            if ( state.backtracking==0 ) { builder.setChunkSizeRollupCubeOp(((cube_clause_scope)cube_clause_stack.peek()).cubeOp, (chunksize_clause135!=null?chunksize_clause135.chunksize:0)); }

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_rate_clause_in_cube_rollup_list1764);
                            rate_clause136=rate_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, rate_clause136.getTree());


                            if ( state.backtracking==0 ) { builder.setRateRollupCubeOp(((cube_clause_scope)cube_clause_stack.peek()).cubeOp, (rate_clause136!=null?rate_clause136.rate:0.0)); }

                            if ( state.backtracking==0 ) {
                            }
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:583:1: cube_by_expr_list returns [List<LogicalExpressionPlan> plans] : ( cube_by_expr )+ ;
    public final LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_list_return retval = new LogicalPlanGenerator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_by_expr_return cube_by_expr137 =null;




            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:587:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:587:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:587:4: ( cube_by_expr )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==BIGDECIMALNUMBER||LA38_0==BIGINTEGERNUMBER||LA38_0==CUBE||LA38_0==DIV||LA38_0==DOLLARVAR||LA38_0==DOUBLENUMBER||LA38_0==FALSE||LA38_0==FLOATNUMBER||LA38_0==GROUP||LA38_0==IDENTIFIER||LA38_0==INTEGER||LA38_0==LONGINTEGER||LA38_0==MINUS||LA38_0==NULL||LA38_0==PERCENT||LA38_0==PLUS||LA38_0==QUOTEDSTRING||LA38_0==STAR||LA38_0==TRUE||(LA38_0 >= BAG_VAL && LA38_0 <= BIN_EXPR)||(LA38_0 >= CASE_COND && LA38_0 <= CASE_EXPR)||(LA38_0 >= CAST_EXPR && LA38_0 <= EXPR_IN_PAREN)||LA38_0==FUNC_EVAL||LA38_0==INVOKER_FUNC_EVAL||(LA38_0 >= MAP_VAL && LA38_0 <= NEG)||LA38_0==TUPLE_VAL) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:587:6: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1793);
            	    cube_by_expr137=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr137.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (cube_by_expr137!=null?cube_by_expr137.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:590:1: cube_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_return retval = new LogicalPlanGenerator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR140=null;
        LogicalPlanGenerator.col_range_return col_range138 =null;

        LogicalPlanGenerator.expr_return expr139 =null;


        CommonTree STAR140_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:594:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt39=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt39=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt39=2;
                }
                break;
            case STAR:
                {
                int LA39_3 = input.LA(2);

                if ( (LA39_3==DOWN) ) {
                    alt39=2;
                }
                else if ( (LA39_3==EOF||LA39_3==UP||LA39_3==BIGDECIMALNUMBER||LA39_3==BIGINTEGERNUMBER||LA39_3==CHUNKSIZE||LA39_3==CUBE||LA39_3==DIV||LA39_3==DOLLARVAR||LA39_3==DOUBLENUMBER||LA39_3==FALSE||LA39_3==FLOATNUMBER||LA39_3==GROUP||LA39_3==IDENTIFIER||LA39_3==INTEGER||LA39_3==LONGINTEGER||LA39_3==MINUS||LA39_3==NULL||LA39_3==PERCENT||(LA39_3 >= PIVOT && LA39_3 <= PLUS)||LA39_3==QUOTEDSTRING||LA39_3==STAR||LA39_3==TRUE||(LA39_3 >= BAG_VAL && LA39_3 <= BIN_EXPR)||(LA39_3 >= CASE_COND && LA39_3 <= CASE_EXPR)||(LA39_3 >= CAST_EXPR && LA39_3 <= EXPR_IN_PAREN)||LA39_3==FUNC_EVAL||LA39_3==INVOKER_FUNC_EVAL||(LA39_3 >= MAP_VAL && LA39_3 <= NEG)||LA39_3==TUPLE_VAL) ) {
                    alt39=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:594:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1816);
                    col_range138=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range138.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1822);
                    expr139=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR140=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR140_tree = (CommonTree)adaptor.dupNode(STAR140);


                    adaptor.addChild(root_0, STAR140_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR140 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 0, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    protected static class group_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP141=null;
        CommonTree COGROUP145=null;
        LogicalPlanGenerator.group_item_return group_item142 =null;

        LogicalPlanGenerator.group_type_return group_type143 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause144 =null;

        LogicalPlanGenerator.group_item_return group_item146 =null;

        LogicalPlanGenerator.group_type_return group_type147 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause148 =null;


        CommonTree GROUP141_tree=null;
        CommonTree COGROUP145_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp();
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==GROUP) ) {
                alt46=1;
            }
            else if ( (LA46_0==COGROUP) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP141=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP141_tree = (CommonTree)adaptor.dupNode(GROUP141);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP141_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:13: ( group_item )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==ARROBA||LA40_0==ASSERT||LA40_0==COGROUP||(LA40_0 >= CROSS && LA40_0 <= CUBE)||LA40_0==DEFINE||LA40_0==DISTINCT||LA40_0==FILTER||LA40_0==FOREACH||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==JOIN||(LA40_0 >= LIMIT && LA40_0 <= LOAD)||LA40_0==MAPREDUCE||LA40_0==ORDER||LA40_0==RANK||LA40_0==SAMPLE||(LA40_0 >= STORE && LA40_0 <= STREAM)||LA40_0==UNION) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1869);
                    	    group_item142=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item142.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:25: ( group_type )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==QUOTEDSTRING) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1874);
                            group_type143=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type143.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type143!=null?group_type143.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:146: ( partition_clause )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==PARTITION) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:620:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1881);
                            partition_clause144=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause144.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause144!=null?partition_clause144.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP145=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1896); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP145_tree = (CommonTree)adaptor.dupNode(COGROUP145);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP145_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:15: ( group_item )+
                    int cnt43=0;
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==ARROBA||LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==IDENTIFIER||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1898);
                    	    group_item146=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item146.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt43 >= 1 ) break loop43;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(43, input);
                                throw eee;
                        }
                        cnt43++;
                    } while (true);


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:27: ( group_type )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==QUOTEDSTRING) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1903);
                            group_type147=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type147.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type147!=null?group_type147.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:147: ( partition_clause )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==PARTITION) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:626:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1910);
                            partition_clause148=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause148.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause148!=null?partition_clause148.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:634:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING149=null;

        CommonTree QUOTEDSTRING149_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:635:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:635:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING149=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING149_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING149);


            adaptor.addChild(root_0, QUOTEDSTRING149_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING149!=null?QUOTEDSTRING149.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING149 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:641:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL152=null;
        CommonTree ANY153=null;
        CommonTree INNER154=null;
        CommonTree OUTER155=null;
        LogicalPlanGenerator.rel_return rel150 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause151 =null;


        CommonTree ALL152_tree=null;
        CommonTree ANY153_tree=null;
        CommonTree INNER154_tree=null;
        CommonTree OUTER155_tree=null;

         boolean inner = false; 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1951);
            rel150=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel150.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:8: ( join_group_by_clause | ALL | ANY )
            int alt47=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt47=1;
                }
                break;
            case ALL:
                {
                alt47=2;
                }
                break;
            case ANY:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1955);
                    join_group_by_clause151=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause151.getTree());


                    if ( state.backtracking==0 ) {
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause151!=null?join_group_by_clause151.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:647:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL152=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL152_tree = (CommonTree)adaptor.dupNode(ALL152);


                    adaptor.addChild(root_0, ALL152_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL152 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:656:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY153=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item2003); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY153_tree = (CommonTree)adaptor.dupNode(ANY153);


                    adaptor.addChild(root_0, ANY153_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY153 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:665:11: ( INNER | OUTER )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==INNER) ) {
                alt48=1;
            }
            else if ( (LA48_0==OUTER) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:665:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER154=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item2028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER154_tree = (CommonTree)adaptor.dupNode(INNER154);


                    adaptor.addChild(root_0, INNER154_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:665:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER155=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item2034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER155_tree = (CommonTree)adaptor.dupNode(OUTER155);


                    adaptor.addChild(root_0, OUTER155_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:674:1: rel : ( alias | previous_rel | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias156 =null;

        LogicalPlanGenerator.previous_rel_return previous_rel157 =null;

        LogicalPlanGenerator.inline_op_return inline_op158 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:675:2: ( alias | previous_rel | inline_op )
            int alt49=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt49=1;
                }
                break;
            case ARROBA:
                {
                alt49=2;
                }
                break;
            case ASSERT:
            case COGROUP:
            case CROSS:
            case CUBE:
            case DEFINE:
            case DISTINCT:
            case FILTER:
            case FOREACH:
            case GROUP:
            case JOIN:
            case LIMIT:
            case LOAD:
            case MAPREDUCE:
            case ORDER:
            case RANK:
            case SAMPLE:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:675:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel2052);
                    alias156=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias156.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias156!=null?alias156.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:679:4: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel2062);
                    previous_rel157=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel157.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (previous_rel157!=null?previous_rel157.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:683:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel2072);
                    inline_op158=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op158.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:1: previous_rel returns [String name] : ARROBA ;
    public final LogicalPlanGenerator.previous_rel_return previous_rel() throws RecognitionException {
        LogicalPlanGenerator.previous_rel_return retval = new LogicalPlanGenerator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA159=null;

        CommonTree ARROBA159_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:35: ( ARROBA )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:37: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA159=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel2084); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA159_tree = (CommonTree)adaptor.dupNode(ARROBA159);


            adaptor.addChild(root_0, ARROBA159_tree);
            }


            if ( state.backtracking==0 ) { retval.name = builder.getLastRel(new SourceLocation((PigParserNode)ARROBA159)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "previous_rel"


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:689:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause160 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause161 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:2: ( op_clause ( parallel_clause )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op2106);
            op_clause160=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause160.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:14: ( parallel_clause )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==PARALLEL) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op2108);
                    parallel_clause161=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, parallel_clause161.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause160!=null?op_clause160.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause160!=null?op_clause160.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:705:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR165=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause162 =null;

        LogicalPlanGenerator.col_range_return col_range163 =null;

        LogicalPlanGenerator.expr_return expr164 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list166 =null;


        CommonTree STAR165_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt51=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt51=1;
                }
                break;
            case COL_RANGE:
                {
                alt51=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt51=3;
                }
                break;
            case STAR:
                {
                int LA51_4 = input.LA(2);

                if ( (LA51_4==DOWN) ) {
                    alt51=3;
                }
                else if ( (LA51_4==EOF||LA51_4==UP||LA51_4==BIGDECIMALNUMBER||LA51_4==BIGINTEGERNUMBER||LA51_4==CUBE||LA51_4==DIV||LA51_4==DOLLARVAR||LA51_4==DOUBLENUMBER||LA51_4==FALSE||LA51_4==FLATTEN||LA51_4==FLOATNUMBER||LA51_4==GROUP||LA51_4==IDENTIFIER||LA51_4==INTEGER||LA51_4==LONGINTEGER||LA51_4==MINUS||LA51_4==NULL||LA51_4==PERCENT||LA51_4==PLUS||LA51_4==QUOTEDSTRING||LA51_4==STAR||LA51_4==TRUE||(LA51_4 >= BAG_VAL && LA51_4 <= BIN_EXPR)||(LA51_4 >= CASE_COND && LA51_4 <= CASE_EXPR)||(LA51_4 >= CAST_EXPR && LA51_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA51_4==FUNC_EVAL||LA51_4==INVOKER_FUNC_EVAL||(LA51_4 >= MAP_VAL && LA51_4 <= NEG)||LA51_4==TUPLE_VAL) ) {
                    alt51=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item2134);
                    flatten_clause162=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause162.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item2144);
                    col_range163=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range163.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:711:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item2152);
                    expr164=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr164.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:712:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR165=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item2160); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR165_tree = (CommonTree)adaptor.dupNode(STAR165);


                    adaptor.addChild(root_0, STAR165_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR165 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:718:4: ( field_def_list )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0 >= FIELD_DEF && LA52_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:718:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item2179);
                    field_def_list166=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list166.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list166!=null?field_def_list166.schema:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:721:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN167=null;
        LogicalPlanGenerator.expr_return expr168 =null;


        CommonTree FLATTEN167_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:722:2: ( ^( FLATTEN expr[$plan] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:722:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN167=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN167_tree = (CommonTree)adaptor.dupNode(FLATTEN167);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN167_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause2199);
            expr168=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr168.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:725:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE169=null;
        LogicalPlanGenerator.rel_return rel170 =null;

        LogicalPlanGenerator.filename_return filename171 =null;

        LogicalPlanGenerator.func_clause_return func_clause172 =null;


        CommonTree STORE169_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:726:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:726:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE169=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE169_tree = (CommonTree)adaptor.dupNode(STORE169);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE169_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2219);
            rel170=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel170.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2221);
            filename171=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename171.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:726:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FUNC||LA53_0==FUNC_REF) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:726:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2223);
                    func_clause172=func_clause(FunctionType.STOREFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause172.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE169 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename171!=null?filename171.filename:null), (func_clause172!=null?func_clause172.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class assert_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:734:1: assert_clause returns [String alias] : ^( ASSERT rel cond[exprPlan] ( comment )? ) ;
    public final LogicalPlanGenerator.assert_clause_return assert_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.assert_clause_return retval = new LogicalPlanGenerator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT173=null;
        LogicalPlanGenerator.rel_return rel174 =null;

        LogicalPlanGenerator.cond_return cond175 =null;

        LogicalPlanGenerator.comment_return comment176 =null;


        CommonTree ASSERT173_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:740:2: ( ^( ASSERT rel cond[exprPlan] ( comment )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:740:4: ^( ASSERT rel cond[exprPlan] ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT173=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT173_tree = (CommonTree)adaptor.dupNode(ASSERT173);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT173_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause2259);
            rel174=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel174.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause2261);
            cond175=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond175.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:740:33: ( comment )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==QUOTEDSTRING) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:740:33: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause2264);
                    comment176=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment176.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ASSERT173 );
                   retval.alias = builder.buildAssertOp(loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (cond175!=null?cond175.expr:null), (comment176!=null?comment176.comment:null), exprPlan);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "assert_clause"


    public static class comment_return extends TreeRuleReturnScope {
        public String comment;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:748:1: comment returns [String comment] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.comment_return comment() throws RecognitionException {
        LogicalPlanGenerator.comment_return retval = new LogicalPlanGenerator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING177=null;

        CommonTree QUOTEDSTRING177_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:749:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:749:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING177=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING177_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING177);


            adaptor.addChild(root_0, QUOTEDSTRING177_tree);
            }


            if ( state.backtracking==0 ) { retval.comment = builder.unquote( (QUOTEDSTRING177!=null?QUOTEDSTRING177.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comment"


    public static class filter_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:752:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER178=null;
        LogicalPlanGenerator.rel_return rel179 =null;

        LogicalPlanGenerator.cond_return cond180 =null;


        CommonTree FILTER178_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER178=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER178_tree = (CommonTree)adaptor.dupNode(FILTER178);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER178_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2314);
            rel179=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel179.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2316);
            cond180=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond180.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER178 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:766:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR181=null;
        CommonTree AND182=null;
        CommonTree NOT183=null;
        CommonTree NULL184=null;
        CommonTree NOT186=null;
        CommonTree STR_OP_MATCHES193=null;
        CommonTree BOOL_COND196=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr185 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq187 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne188 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt189 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte190 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt191 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte192 =null;

        LogicalPlanGenerator.in_eval_return in_eval194 =null;

        LogicalPlanGenerator.func_eval_return func_eval195 =null;


        CommonTree OR181_tree=null;
        CommonTree AND182_tree=null;
        CommonTree NOT183_tree=null;
        CommonTree NULL184_tree=null;
        CommonTree NOT186_tree=null;
        CommonTree STR_OP_MATCHES193_tree=null;
        CommonTree BOOL_COND196_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:767:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
            int alt56=14;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt56=1;
                }
                break;
            case AND:
                {
                alt56=2;
                }
                break;
            case NOT:
                {
                alt56=3;
                }
                break;
            case NULL:
                {
                alt56=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt56=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt56=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt56=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt56=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt56=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt56=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt56=11;
                }
                break;
            case IN:
                {
                alt56=12;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt56=13;
                }
                break;
            case BOOL_COND:
                {
                alt56=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:767:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR181=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR181_tree = (CommonTree)adaptor.dupNode(OR181);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR181_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2346);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2353);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR181 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:772:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND182=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND182_tree = (CommonTree)adaptor.dupNode(AND182);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND182_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2374);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2381);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND182 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:777:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT183=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2396); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT183_tree = (CommonTree)adaptor.dupNode(NOT183);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT183_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2402);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT183 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:782:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL184=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL184_tree = (CommonTree)adaptor.dupNode(NULL184);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL184_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2419);
                    expr185=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr185.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:782:28: ( NOT )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==NOT) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:782:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT186=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2422); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT186_tree = (CommonTree)adaptor.dupNode(NOT186);


                            adaptor.addChild(root_1, NOT186_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new IsNullExpression( exprPlan, (expr185!=null?expr185.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL184 ) );
                           if( NOT186 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT186 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:791:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond2437);
                    rel_op_eq187=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq187.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2443);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2450);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq187!=null?((CommonTree)rel_op_eq187.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:796:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond2465);
                    rel_op_ne188=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne188.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2471);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2478);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne188!=null?((CommonTree)rel_op_ne188.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:801:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond2493);
                    rel_op_lt189=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt189.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2499);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2506);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt189!=null?((CommonTree)rel_op_lt189.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:806:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2521);
                    rel_op_lte190=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte190.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2527);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2534);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte190!=null?((CommonTree)rel_op_lte190.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:811:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2549);
                    rel_op_gt191=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt191.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2555);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2562);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt191!=null?((CommonTree)rel_op_gt191.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:816:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2577);
                    rel_op_gte192=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte192.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2583);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2590);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte192!=null?((CommonTree)rel_op_gte192.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:821:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES193=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES193_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES193);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES193_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2611);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2618);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES193 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:826:4: in_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2631);
                    in_eval194=in_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval194.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (in_eval194!=null?in_eval194.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:830:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2642);
                    func_eval195=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval195.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval195!=null?func_eval195.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:834:4: ^( BOOL_COND e1= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND196=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND196_tree = (CommonTree)adaptor.dupNode(BOOL_COND196);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND196_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2661);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e1!=null?e1.expr:null);
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)BOOL_COND196 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:841:1: in_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) ;
    public final LogicalPlanGenerator.in_eval_return in_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.in_eval_return retval = new LogicalPlanGenerator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN197=null;
        CommonTree IN_LHS198=null;
        CommonTree IN_RHS199=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree IN197_tree=null;
        CommonTree IN_LHS198_tree=null;
        CommonTree IN_RHS199_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:2: ( ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:4: ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN197=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2690); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN197_tree = (CommonTree)adaptor.dupNode(IN197);


            root_1 = (CommonTree)adaptor.becomeRoot(IN197_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:10: ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==IN_LHS) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:12: ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS198=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2696); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS198_tree = (CommonTree)adaptor.dupNode(IN_LHS198);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS198_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2702);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_RHS199=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2722); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS199_tree = (CommonTree)adaptor.dupNode(IN_RHS199);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS199_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2728);
            	    rhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, rhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert IN tree to nested or expressions. Please also see
                    // QueryParser.g for how IN tree is constructed from IN expression.
                    EqualExpression firstBoolExpr = new EqualExpression(plan, lhsExprs.get(0), rhsExprs.get(0));
                    if (lhsExprs.size() == 1) {
                        retval.expr = firstBoolExpr;
                    } else {
                        OrExpression currOrExpr = null;
                        OrExpression prevOrExpr = null;
                        for (int i = 1; i < lhsExprs.size(); i++) {
                            EqualExpression boolExpr = new EqualExpression(plan, lhsExprs.get(i), rhsExprs.get(i));
                            currOrExpr = new OrExpression( plan, prevOrExpr == null ? firstBoolExpr : prevOrExpr, boolExpr );
                            prevOrExpr = currOrExpr;
                        }
                        retval.expr = currOrExpr;
                    }
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:868:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) );
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree package_name=null;
        CommonTree function_name=null;
        CommonTree is_static=null;
        CommonTree FUNC_EVAL200=null;
        CommonTree INVOKER_FUNC_EVAL203=null;
        LogicalPlanGenerator.func_name_return func_name201 =null;

        LogicalPlanGenerator.real_arg_return real_arg202 =null;

        LogicalPlanGenerator.real_arg_return real_arg204 =null;


        CommonTree package_name_tree=null;
        CommonTree function_name_tree=null;
        CommonTree is_static_tree=null;
        CommonTree FUNC_EVAL200_tree=null;
        CommonTree INVOKER_FUNC_EVAL203_tree=null;


            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:872:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FUNC_EVAL) ) {
                alt60=1;
            }
            else if ( (LA60_0==INVOKER_FUNC_EVAL) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:872:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL200=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL200_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL200);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL200_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2767);
                    func_name201=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name201.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:872:27: ( real_arg[$plan] )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==BIGDECIMALNUMBER||LA58_0==BIGINTEGERNUMBER||LA58_0==CUBE||LA58_0==DIV||LA58_0==DOLLARVAR||LA58_0==DOUBLENUMBER||LA58_0==FALSE||LA58_0==FLOATNUMBER||LA58_0==GROUP||LA58_0==IDENTIFIER||LA58_0==INTEGER||LA58_0==LONGINTEGER||LA58_0==MINUS||LA58_0==NULL||LA58_0==PERCENT||LA58_0==PLUS||LA58_0==QUOTEDSTRING||LA58_0==STAR||LA58_0==TRUE||(LA58_0 >= BAG_VAL && LA58_0 <= BIN_EXPR)||(LA58_0 >= CASE_COND && LA58_0 <= CASE_EXPR)||(LA58_0 >= CAST_EXPR && LA58_0 <= EXPR_IN_PAREN)||LA58_0==FUNC_EVAL||LA58_0==INVOKER_FUNC_EVAL||(LA58_0 >= MAP_VAL && LA58_0 <= NEG)||LA58_0==TUPLE_VAL) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:872:29: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2771);
                    	    real_arg202=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg202.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg202!=null?real_arg202.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(func_name201!=null?((CommonTree)func_name201.start):null) );
                           retval.expr = builder.buildUDF( loc, plan, (func_name201!=null?func_name201.funcName:null), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:877:4: ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL203=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL203_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL203);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    package_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    package_name_tree = (CommonTree)adaptor.dupNode(package_name);


                    adaptor.addChild(root_1, package_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    function_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2799); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    function_name_tree = (CommonTree)adaptor.dupNode(function_name);


                    adaptor.addChild(root_1, function_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    is_static=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    is_static_tree = (CommonTree)adaptor.dupNode(is_static);


                    adaptor.addChild(root_1, is_static_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:877:95: ( real_arg[$plan] )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==BIGDECIMALNUMBER||LA59_0==BIGINTEGERNUMBER||LA59_0==CUBE||LA59_0==DIV||LA59_0==DOLLARVAR||LA59_0==DOUBLENUMBER||LA59_0==FALSE||LA59_0==FLOATNUMBER||LA59_0==GROUP||LA59_0==IDENTIFIER||LA59_0==INTEGER||LA59_0==LONGINTEGER||LA59_0==MINUS||LA59_0==NULL||LA59_0==PERCENT||LA59_0==PLUS||LA59_0==QUOTEDSTRING||LA59_0==STAR||LA59_0==TRUE||(LA59_0 >= BAG_VAL && LA59_0 <= BIN_EXPR)||(LA59_0 >= CASE_COND && LA59_0 <= CASE_EXPR)||(LA59_0 >= CAST_EXPR && LA59_0 <= EXPR_IN_PAREN)||LA59_0==FUNC_EVAL||LA59_0==INVOKER_FUNC_EVAL||(LA59_0 >= MAP_VAL && LA59_0 <= NEG)||LA59_0==TUPLE_VAL) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:877:97: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2807);
                    	    real_arg204=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg204.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg204!=null?real_arg204.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)function_name );
                           retval.expr = builder.buildInvokerUDF( loc, plan, (package_name!=null?package_name.getText():null), (function_name!=null?function_name.getText():null), Boolean.parseBoolean((is_static!=null?is_static.getText():null)), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:884:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR205=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR205_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:885:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt61=3;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt61=1;
                }
                break;
            case STAR:
                {
                int LA61_2 = input.LA(2);

                if ( (LA61_2==DOWN) ) {
                    alt61=1;
                }
                else if ( (LA61_2==EOF||LA61_2==UP||LA61_2==BIGDECIMALNUMBER||LA61_2==BIGINTEGERNUMBER||LA61_2==CUBE||LA61_2==DIV||LA61_2==DOLLARVAR||LA61_2==DOUBLENUMBER||LA61_2==FALSE||LA61_2==FLOATNUMBER||LA61_2==GROUP||LA61_2==IDENTIFIER||LA61_2==INTEGER||LA61_2==LONGINTEGER||LA61_2==MINUS||LA61_2==NULL||LA61_2==PERCENT||LA61_2==PLUS||LA61_2==QUOTEDSTRING||LA61_2==STAR||LA61_2==TRUE||(LA61_2 >= BAG_VAL && LA61_2 <= BIN_EXPR)||(LA61_2 >= CASE_COND && LA61_2 <= CASE_EXPR)||(LA61_2 >= CAST_EXPR && LA61_2 <= EXPR_IN_PAREN)||LA61_2==FUNC_EVAL||LA61_2==INVOKER_FUNC_EVAL||(LA61_2 >= MAP_VAL && LA61_2 <= NEG)||LA61_2==TUPLE_VAL) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:885:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2839);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:886:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR205=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR205_tree = (CommonTree)adaptor.dupNode(STAR205);


                    adaptor.addChild(root_0, STAR205_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR205 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:891:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2861);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:894:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS206=null;
        CommonTree MINUS207=null;
        CommonTree STAR208=null;
        CommonTree DIV209=null;
        CommonTree PERCENT210=null;
        CommonTree NEG213=null;
        CommonTree CAST_EXPR214=null;
        CommonTree EXPR_IN_PAREN216=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr211 =null;

        LogicalPlanGenerator.var_expr_return var_expr212 =null;

        LogicalPlanGenerator.type_cast_return type_cast215 =null;


        CommonTree PLUS206_tree=null;
        CommonTree MINUS207_tree=null;
        CommonTree STAR208_tree=null;
        CommonTree DIV209_tree=null;
        CommonTree PERCENT210_tree=null;
        CommonTree NEG213_tree=null;
        CommonTree CAST_EXPR214_tree=null;
        CommonTree EXPR_IN_PAREN216_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:895:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt62=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt62=1;
                }
                break;
            case MINUS:
                {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==DOWN) ) {
                    alt62=2;
                }
                else if ( (LA62_2==BIGDECIMALNUMBER||LA62_2==BIGINTEGERNUMBER||LA62_2==DOUBLENUMBER||LA62_2==FLOATNUMBER||LA62_2==INTEGER||LA62_2==LONGINTEGER) ) {
                    alt62=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt62=3;
                }
                break;
            case DIV:
                {
                alt62=4;
                }
                break;
            case PERCENT:
                {
                alt62=5;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case TUPLE_VAL:
                {
                alt62=6;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt62=7;
                }
                break;
            case NEG:
                {
                alt62=8;
                }
                break;
            case CAST_EXPR:
                {
                alt62=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt62=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:895:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS206=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS206_tree = (CommonTree)adaptor.dupNode(PLUS206);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS206_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2886);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2893);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS206 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:900:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS207=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS207_tree = (CommonTree)adaptor.dupNode(MINUS207);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS207_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2914);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2921);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS207 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:905:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR208=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR208_tree = (CommonTree)adaptor.dupNode(STAR208);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR208_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2942);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2949);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR208 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:910:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV209=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV209_tree = (CommonTree)adaptor.dupNode(DIV209);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV209_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2970);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2977);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV209 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:915:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT210=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2992); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT210_tree = (CommonTree)adaptor.dupNode(PERCENT210);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT210_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2998);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3005);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT210 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:920:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr3018);
                    const_expr211=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr211.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr211!=null?const_expr211.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:924:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr3029);
                    var_expr212=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr212.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr212!=null?var_expr212.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:928:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG213=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr3042); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG213_tree = (CommonTree)adaptor.dupNode(NEG213);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG213_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3048);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:933:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR214=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr3063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR214_tree = (CommonTree)adaptor.dupNode(CAST_EXPR214);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR214_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr3065);
                    type_cast215=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast215.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3071);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast215!=null?type_cast215.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast215!=null?((CommonTree)type_cast215.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:938:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN216=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr3087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN216_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN216);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN216_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3093);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:944:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type217 =null;

        LogicalPlanGenerator.map_type_return map_type218 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast219 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast220 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:945:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt63=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt63=1;
                }
                break;
            case MAP_TYPE:
                {
                alt63=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt63=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt63=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:945:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast3115);
                    simple_type217=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type217.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type217!=null?simple_type217.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:949:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast3125);
                    map_type218=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type218.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type218!=null?map_type218.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:953:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast3135);
                    tuple_type_cast219=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast219.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast219!=null?tuple_type_cast219.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:957:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast3145);
                    bag_type_cast220=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast220.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast220!=null?bag_type_cast220.logicalSchema:null), DataType.BAG );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:963:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST221=null;
        LogicalPlanGenerator.type_cast_return type_cast222 =null;


        CommonTree TUPLE_TYPE_CAST221_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:967:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:967:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST221=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST221_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST221);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST221_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:967:23: ( type_cast )*
                loop64:
                do {
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==BIGDECIMAL||LA64_0==BIGINTEGER||LA64_0==BOOLEAN||LA64_0==BYTEARRAY||LA64_0==CHARARRAY||LA64_0==DATETIME||LA64_0==DOUBLE||LA64_0==FLOAT||LA64_0==INT||LA64_0==LONG||LA64_0==BAG_TYPE_CAST||LA64_0==MAP_TYPE||LA64_0==TUPLE_TYPE_CAST) ) {
                        alt64=1;
                    }


                    switch (alt64) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:967:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast3174);
                	    type_cast222=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast222.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast222!=null?type_cast222.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop64;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST223=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast224 =null;


        CommonTree BAG_TYPE_CAST223_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST223=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST223_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST223);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST223_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:21: ( tuple_type_cast )?
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==TUPLE_TYPE_CAST) ) {
                    alt65=1;
                }
                switch (alt65) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast3203);
                        tuple_type_cast224=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast224.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast224!=null?tuple_type_cast224.logicalSchema:null), DataType.TUPLE ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:980:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr225 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj226 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj227 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:985:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:985:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr3230);
            projectable_expr225=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr225.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr225!=null?projectable_expr225.expr:null); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:986:4: ( dot_proj | pound_proj )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==PERIOD) ) {
                    alt66=1;
                }
                else if ( (LA66_0==POUND) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:986:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr3240);
            	    dot_proj226=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj226.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj226!=null?dot_proj226.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }

            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;

            	                 if( (dot_proj226!=null?dot_proj226.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }

            	                 Object val = (dot_proj226!=null?dot_proj226.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }

            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj226!=null?dot_proj226.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj226!=null?((CommonTree)dot_proj226.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr3254);
            	    pound_proj227=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj227.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj227!=null?pound_proj227.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj227!=null?((CommonTree)pound_proj227.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
                  }
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1058:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval228 =null;

        LogicalPlanGenerator.col_ref_return col_ref229 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr230 =null;

        LogicalPlanGenerator.case_expr_return case_expr231 =null;

        LogicalPlanGenerator.case_cond_return case_cond232 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] )
            int alt67=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt67=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt67=2;
                }
                break;
            case BIN_EXPR:
                {
                alt67=3;
                }
                break;
            case CASE_EXPR:
                {
                alt67=4;
                }
                break;
            case CASE_COND:
                {
                alt67=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr3284);
                    func_eval228=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval228.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval228!=null?func_eval228.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1063:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr3295);
                    col_ref229=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref229.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref229!=null?col_ref229.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1067:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr3306);
                    bin_expr230=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr230.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr230!=null?bin_expr230.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1071:4: case_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr3317);
                    case_expr231=case_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr231.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_expr231!=null?case_expr231.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1075:4: case_cond[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr3328);
                    case_cond232=case_cond(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond232.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_cond232!=null?case_cond232.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1081:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD233=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index234 =null;


        CommonTree PERIOD233_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1085:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1085:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD233=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj3354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD233_tree = (CommonTree)adaptor.dupNode(PERIOD233);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD233_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1085:14: ( col_alias_or_index )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1085:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj3358);
            	    col_alias_or_index234=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index234.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index234!=null?col_alias_or_index234.col:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias235 =null;

        LogicalPlanGenerator.col_index_return col_index236 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1089:2: ( col_alias | col_index )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==CUBE||LA69_0==GROUP||LA69_0==IDENTIFIER) ) {
                alt69=1;
            }
            else if ( (LA69_0==DOLLARVAR) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1089:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index3378);
                    col_alias235=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias235.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias235!=null?col_alias235.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1089:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index3384);
                    col_index236=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index236.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index236!=null?col_index236.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1092:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP237=null;
        CommonTree CUBE238=null;
        CommonTree IDENTIFIER239=null;

        CommonTree GROUP237_tree=null;
        CommonTree CUBE238_tree=null;
        CommonTree IDENTIFIER239_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:2: ( GROUP | CUBE | IDENTIFIER )
            int alt70=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt70=1;
                }
                break;
            case CUBE:
                {
                alt70=2;
                }
                break;
            case IDENTIFIER:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP237=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP237_tree = (CommonTree)adaptor.dupNode(GROUP237);


                    adaptor.addChild(root_0, GROUP237_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP237!=null?GROUP237.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1094:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE238=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE238_tree = (CommonTree)adaptor.dupNode(CUBE238);


                    adaptor.addChild(root_0, CUBE238_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (CUBE238!=null?CUBE238.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1095:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER239=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER239_tree = (CommonTree)adaptor.dupNode(IDENTIFIER239);


                    adaptor.addChild(root_0, IDENTIFIER239_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER239!=null?IDENTIFIER239.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1098:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR240=null;

        CommonTree DOLLARVAR240_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1099:2: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1099:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR240=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR240_tree = (CommonTree)adaptor.dupNode(DOLLARVAR240);


            adaptor.addChild(root_0, DOLLARVAR240_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR240!=null?DOLLARVAR240.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1103:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE241=null;
        CommonTree DOUBLE_PERIOD242=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE241_tree=null;
        CommonTree DOUBLE_PERIOD242_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE241=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE241_tree = (CommonTree)adaptor.dupNode(COL_RANGE241);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE241_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:17: (startExpr= col_ref[$plan] )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3454);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD242=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3459); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD242_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD242);


            adaptor.addChild(root_1, DOUBLE_PERIOD242_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:61: (endExpr= col_ref[$plan] )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3466);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex,
                                (startExpr!=null?startExpr.expr:null),
                                (endExpr!=null?endExpr.expr:null)
                            );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1116:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND243=null;
        CommonTree QUOTEDSTRING244=null;
        CommonTree NULL245=null;

        CommonTree POUND243_tree=null;
        CommonTree QUOTEDSTRING244_tree=null;
        CommonTree NULL245_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND243=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND243_tree = (CommonTree)adaptor.dupNode(POUND243);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND243_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:13: ( QUOTEDSTRING | NULL )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==QUOTEDSTRING) ) {
                alt73=1;
            }
            else if ( (LA73_0==NULL) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }
            switch (alt73) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING244=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING244_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING244);


                    adaptor.addChild(root_1, QUOTEDSTRING244_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING244!=null?QUOTEDSTRING244.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL245=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL245_tree = (CommonTree)adaptor.dupNode(NULL245);


                    adaptor.addChild(root_1, NULL245_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1120:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR246=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond247 =null;


        CommonTree BIN_EXPR246_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1121:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1121:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR246=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3522); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR246_tree = (CommonTree)adaptor.dupNode(BIN_EXPR246);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR246_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr3524);
            cond247=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond247.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3531);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3538);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond247!=null?cond247.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1128:1: case_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) ;
    public final LogicalPlanGenerator.case_expr_return case_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_expr_return retval = new LogicalPlanGenerator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR248=null;
        CommonTree CASE_EXPR_LHS249=null;
        CommonTree CASE_EXPR_RHS250=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree CASE_EXPR248_tree=null;
        CommonTree CASE_EXPR_LHS249_tree=null;
        CommonTree CASE_EXPR_RHS250_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:2: ( ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:4: ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR248=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr3567); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR248_tree = (CommonTree)adaptor.dupNode(CASE_EXPR248);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR248_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:17: ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==CASE_EXPR_LHS) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    {
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) )
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1133:21: ^( CASE_EXPR_LHS lhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS249=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr3575); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS249_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS249);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS249_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr3581);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }


            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1134:19: ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    int cnt74=0;
            	    loop74:
            	    do {
            	        int alt74=2;
            	        int LA74_0 = input.LA(1);

            	        if ( (LA74_0==CASE_EXPR_RHS) ) {
            	            alt74=1;
            	        }


            	        switch (alt74) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1134:21: ^( CASE_EXPR_RHS rhs= expr[$plan] )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS250=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr3612); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS250_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS250);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS250_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr3618);
            	    	    rhs=expr(plan);

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, rhs.getTree());


            	    	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt74 >= 1 ) break loop74;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(74, input);
            	                throw eee;
            	        }
            	        cnt74++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = rhsExprs.size() % 2 == 1;
                    LogicalExpression elseExpr = hasElse ? rhsExprs.get(rhsExprs.size()-1)
                                                         : new ConstantExpression(plan, null);

                    int numWhenBranches = rhsExprs.size() / 2;
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            new EqualExpression( plan, lhsExprs.get(i), rhsExprs.get(2*i) ), rhsExprs.get(2*i+1),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1156:1: case_cond[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) ;
    public final LogicalPlanGenerator.case_cond_return case_cond(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_cond_return retval = new LogicalPlanGenerator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND251=null;
        CommonTree WHEN252=null;
        CommonTree THEN254=null;
        LogicalPlanGenerator.cond_return cond253 =null;

        LogicalPlanGenerator.expr_return expr255 =null;


        CommonTree CASE_COND251_tree=null;
        CommonTree WHEN252_tree=null;
        CommonTree THEN254_tree=null;


            List<LogicalExpression> conds = new ArrayList<LogicalExpression>();
            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1161:2: ( ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1161:4: ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND251=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3658); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND251_tree = (CommonTree)adaptor.dupNode(CASE_COND251);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND251_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN252=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3662); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN252_tree = (CommonTree)adaptor.dupNode(WHEN252);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN252_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1161:25: ( cond[$plan] )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==AND||LA76_0==IN||(LA76_0 >= NOT && LA76_0 <= NUM_OP_NE)||LA76_0==OR||(LA76_0 >= STR_OP_EQ && LA76_0 <= STR_OP_NE)||LA76_0==BOOL_COND||LA76_0==FUNC_EVAL||LA76_0==INVOKER_FUNC_EVAL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1161:27: cond[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3666);
            	    cond253=cond(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond253.getTree());


            	    if ( state.backtracking==0 ) { conds.add((cond253!=null?cond253.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            THEN254=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3694); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN254_tree = (CommonTree)adaptor.dupNode(THEN254);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN254_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1162:25: ( expr[$plan] )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==BIGDECIMALNUMBER||LA77_0==BIGINTEGERNUMBER||LA77_0==CUBE||LA77_0==DIV||LA77_0==DOLLARVAR||LA77_0==DOUBLENUMBER||LA77_0==FALSE||LA77_0==FLOATNUMBER||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==INTEGER||LA77_0==LONGINTEGER||LA77_0==MINUS||LA77_0==NULL||LA77_0==PERCENT||LA77_0==PLUS||LA77_0==QUOTEDSTRING||LA77_0==STAR||LA77_0==TRUE||(LA77_0 >= BAG_VAL && LA77_0 <= BIN_EXPR)||(LA77_0 >= CASE_COND && LA77_0 <= CASE_EXPR)||LA77_0==CAST_EXPR||LA77_0==EXPR_IN_PAREN||LA77_0==FUNC_EVAL||LA77_0==INVOKER_FUNC_EVAL||(LA77_0 >= MAP_VAL && LA77_0 <= NEG)||LA77_0==TUPLE_VAL) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1162:27: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3698);
            	    expr255=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr255.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr255!=null?expr255.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = exprs.size() != conds.size();
                    LogicalExpression elseExpr = hasElse ? exprs.remove(exprs.size()-1)
                                                         : new ConstantExpression(plan, null);
                    Collections.reverse(exprs);
                    Collections.reverse(conds);
                    int numWhenBranches = conds.size();
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            conds.get(i), exprs.get(i),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT256=null;
        CommonTree INTEGER258=null;
        CommonTree LONGINTEGER259=null;
        LogicalPlanGenerator.rel_return rel257 =null;

        LogicalPlanGenerator.expr_return expr260 =null;


        CommonTree LIMIT256_tree=null;
        CommonTree INTEGER258_tree=null;
        CommonTree LONGINTEGER259_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT256=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT256_tree = (CommonTree)adaptor.dupNode(LIMIT256);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT256_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3742);
            rel257=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel257.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt78=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA78_1 = input.LA(2);

                if ( (synpred148_LogicalPlanGenerator()) ) {
                    alt78=1;
                }
                else if ( (true) ) {
                    alt78=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA78_2 = input.LA(2);

                if ( (synpred149_LogicalPlanGenerator()) ) {
                    alt78=2;
                }
                else if ( (true) ) {
                    alt78=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt78=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER258=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER258_tree = (CommonTree)adaptor.dupNode(INTEGER258);


                    adaptor.addChild(root_1, INTEGER258_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT256 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER258!=null?INTEGER258.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1196:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER259=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER259_tree = (CommonTree)adaptor.dupNode(LONGINTEGER259);


                    adaptor.addChild(root_1, LONGINTEGER259_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT256 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER259!=null?LONGINTEGER259.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1201:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3766);
                    expr260=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr260.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT256 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1209:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE261=null;
        CommonTree DOUBLENUMBER263=null;
        LogicalPlanGenerator.rel_return rel262 =null;

        LogicalPlanGenerator.expr_return expr264 =null;


        CommonTree SAMPLE261_tree=null;
        CommonTree DOUBLENUMBER263_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE261=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE261_tree = (CommonTree)adaptor.dupNode(SAMPLE261);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE261_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3804);
            rel262=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel262.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==DOUBLENUMBER) ) {
                int LA79_1 = input.LA(2);

                if ( (synpred150_LogicalPlanGenerator()) ) {
                    alt79=1;
                }
                else if ( (true) ) {
                    alt79=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA79_0==BIGDECIMALNUMBER||LA79_0==BIGINTEGERNUMBER||LA79_0==CUBE||LA79_0==DIV||LA79_0==DOLLARVAR||LA79_0==FALSE||LA79_0==FLOATNUMBER||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==INTEGER||LA79_0==LONGINTEGER||LA79_0==MINUS||LA79_0==NULL||LA79_0==PERCENT||LA79_0==PLUS||LA79_0==QUOTEDSTRING||LA79_0==STAR||LA79_0==TRUE||(LA79_0 >= BAG_VAL && LA79_0 <= BIN_EXPR)||(LA79_0 >= CASE_COND && LA79_0 <= CASE_EXPR)||LA79_0==CAST_EXPR||LA79_0==EXPR_IN_PAREN||LA79_0==FUNC_EVAL||LA79_0==INVOKER_FUNC_EVAL||(LA79_0 >= MAP_VAL && LA79_0 <= NEG)||LA79_0==TUPLE_VAL) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER263=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER263_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER263);


                    adaptor.addChild(root_1, DOUBLENUMBER263_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE261 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER263!=null?DOUBLENUMBER263.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER263 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1221:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3818);
                    expr264=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr264.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE261 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr264!=null?expr264.expr:null));
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    protected static class rank_clause_scope {
        LORank rankOp;
    }
    protected Stack rank_clause_stack = new Stack();


    public static class rank_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1229:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
    public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        rank_clause_stack.push(new rank_clause_scope());
        LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK265=null;
        LogicalPlanGenerator.rel_return rel266 =null;

        LogicalPlanGenerator.rank_by_statement_return rank_by_statement267 =null;


        CommonTree RANK265_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createRankOp();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1239:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1239:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK265=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK265_tree = (CommonTree)adaptor.dupNode(RANK265);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK265_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3866);
            rel266=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel266.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1239:16: ( rank_by_statement )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==BY) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1239:16: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3868);
                    rank_by_statement267=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	SourceLocation loc = new SourceLocation( (PigParserNode) ((CommonTree)retval.start) );

            	List<LogicalExpressionPlan> tempPlans = (rank_by_statement267!=null?rank_by_statement267.plans:null);
            	List<Boolean> tempAscFlags = (rank_by_statement267!=null?rank_by_statement267.ascFlags:null);

            	if(tempPlans == null && tempAscFlags == null) {
            		tempPlans = new ArrayList<LogicalExpressionPlan>();
            		tempAscFlags = new ArrayList<Boolean>();

            		((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsRowNumber( true );
            	}

            	((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsDenseRank( (rank_by_statement267!=null?rank_by_statement267.isDenseRank:null) != null?(rank_by_statement267!=null?rank_by_statement267.isDenseRank:null):false );

            	retval.alias = builder.buildRankOp( loc, (LORank)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, tempPlans, tempAscFlags );
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            rank_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        public Boolean isDenseRank;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1259:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
    public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY268=null;
        CommonTree DENSE270=null;
        LogicalPlanGenerator.rank_by_clause_return rank_by_clause269 =null;


        CommonTree BY268_tree=null;
        CommonTree DENSE270_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();
            retval.isDenseRank = false;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1265:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1265:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY268=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3894); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY268_tree = (CommonTree)adaptor.dupNode(BY268);


            root_1 = (CommonTree)adaptor.becomeRoot(BY268_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3896);
            rank_by_clause269=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause269.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1265:25: ( DENSE )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==DENSE) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1265:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE270=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE270_tree = (CommonTree)adaptor.dupNode(DENSE270);


                    adaptor.addChild(root_1, DENSE270_tree);
                    }


                    if ( state.backtracking==0 ) { retval.isDenseRank =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	retval.plans = (rank_by_clause269!=null?rank_by_clause269.plans:null);
            	retval.ascFlags = (rank_by_clause269!=null?rank_by_clause269.ascFlags:null);
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1272:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR271=null;
        CommonTree ASC272=null;
        CommonTree DESC273=null;
        LogicalPlanGenerator.rank_col_return rank_col274 =null;


        CommonTree STAR271_tree=null;
        CommonTree ASC272_tree=null;
        CommonTree DESC273_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==STAR) ) {
                alt84=1;
            }
            else if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }
            switch (alt84) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR271=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR271_tree = (CommonTree)adaptor.dupNode(STAR271);


                    adaptor.addChild(root_0, STAR271_tree);
                    }


                    if ( state.backtracking==0 ) {
                    		LogicalExpressionPlan plan = new LogicalExpressionPlan();
                    		builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR271 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                    		retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1282:4: ( ASC | DESC )?
                    int alt82=3;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==ASC) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==DESC) ) {
                        alt82=2;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1282:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC272=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3938); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC272_tree = (CommonTree)adaptor.dupNode(ASC272);


                            adaptor.addChild(root_0, ASC272_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1282:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC273=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3944); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC273_tree = (CommonTree)adaptor.dupNode(DESC273);


                            adaptor.addChild(root_0, DESC273_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1283:4: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1283:4: ( rank_col )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER||LA83_0==COL_RANGE) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1283:6: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3956);
                    	    rank_col274=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col274.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (rank_col274!=null?rank_col274.plan:null) );
                    	           retval.ascFlags.add( (rank_col274!=null?rank_col274.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt83 >= 1 ) break loop83;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1290:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
        LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC276=null;
        CommonTree DESC277=null;
        CommonTree ASC279=null;
        CommonTree DESC280=null;
        LogicalPlanGenerator.col_range_return col_range275 =null;

        LogicalPlanGenerator.col_ref_return col_ref278 =null;


        CommonTree ASC276_tree=null;
        CommonTree DESC277_tree=null;
        CommonTree ASC279_tree=null;
        CommonTree DESC280_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1295:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==COL_RANGE) ) {
                alt87=1;
            }
            else if ( (LA87_0==CUBE||LA87_0==DOLLARVAR||LA87_0==GROUP||LA87_0==IDENTIFIER) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1295:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3982);
                    col_range275=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range275.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1295:21: ( ASC | DESC )?
                    int alt85=3;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==ASC) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==DESC) ) {
                        alt85=2;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1295:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC276=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3986); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC276_tree = (CommonTree)adaptor.dupNode(ASC276);


                            adaptor.addChild(root_0, ASC276_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1295:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC277=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3990); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC277_tree = (CommonTree)adaptor.dupNode(DESC277);


                            adaptor.addChild(root_0, DESC277_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1296:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col4000);
                    col_ref278=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref278.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1296:19: ( ASC | DESC )?
                    int alt86=3;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==ASC) ) {
                        alt86=1;
                    }
                    else if ( (LA86_0==DESC) ) {
                        alt86=2;
                    }
                    switch (alt86) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1296:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC279=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col4005); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC279_tree = (CommonTree)adaptor.dupNode(ASC279);


                            adaptor.addChild(root_0, ASC279_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1296:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC280=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col4009); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC280_tree = (CommonTree)adaptor.dupNode(DESC280);


                            adaptor.addChild(root_0, DESC280_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1299:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER281=null;
        LogicalPlanGenerator.rel_return rel282 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause283 =null;

        LogicalPlanGenerator.func_clause_return func_clause284 =null;


        CommonTree ORDER281_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1304:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1304:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER281=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause4039); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER281_tree = (CommonTree)adaptor.dupNode(ORDER281);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause4041);
            rel282=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel282.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause4043);
            order_by_clause283=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause283.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1304:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==FUNC||LA88_0==FUNC_REF) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1304:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause4045);
                    func_clause284=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause284.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER281 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause283!=null?order_by_clause283.plans:null),
                       (order_by_clause283!=null?order_by_clause283.ascFlags:null), (func_clause284!=null?func_clause284.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR285=null;
        CommonTree ASC286=null;
        CommonTree DESC287=null;
        LogicalPlanGenerator.order_col_return order_col288 =null;


        CommonTree STAR285_tree=null;
        CommonTree ASC286_tree=null;
        CommonTree DESC287_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==STAR) ) {
                alt91=1;
            }
            else if ( (LA91_0==CUBE||LA91_0==DOLLARVAR||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==COL_RANGE) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }
            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR285=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause4072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR285_tree = (CommonTree)adaptor.dupNode(STAR285);


                    adaptor.addChild(root_0, STAR285_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR285 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1324:4: ( ASC | DESC )?
                    int alt89=3;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==ASC) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==DESC) ) {
                        alt89=2;
                    }
                    switch (alt89) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1324:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC286=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause4081); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC286_tree = (CommonTree)adaptor.dupNode(ASC286);


                            adaptor.addChild(root_0, ASC286_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1324:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC287=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause4087); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC287_tree = (CommonTree)adaptor.dupNode(DESC287);


                            adaptor.addChild(root_0, DESC287_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1325:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1325:4: ( order_col )+
                    int cnt90=0;
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1325:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause4099);
                    	    order_col288=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col288.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col288!=null?order_col288.plan:null) );
                    	           retval.ascFlags.add( (order_col288!=null?order_col288.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt90 >= 1 ) break loop90;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(90, input);
                                throw eee;
                        }
                        cnt90++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1332:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC290=null;
        CommonTree DESC291=null;
        CommonTree ASC293=null;
        CommonTree DESC294=null;
        LogicalPlanGenerator.col_range_return col_range289 =null;

        LogicalPlanGenerator.col_ref_return col_ref292 =null;


        CommonTree ASC290_tree=null;
        CommonTree DESC291_tree=null;
        CommonTree ASC293_tree=null;
        CommonTree DESC294_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1337:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==COL_RANGE) ) {
                alt94=1;
            }
            else if ( (LA94_0==CUBE||LA94_0==DOLLARVAR||LA94_0==GROUP||LA94_0==IDENTIFIER) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1337:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col4125);
                    col_range289=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range289.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1337:21: ( ASC | DESC )?
                    int alt92=3;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==ASC) ) {
                        alt92=1;
                    }
                    else if ( (LA92_0==DESC) ) {
                        alt92=2;
                    }
                    switch (alt92) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1337:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC290=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4129); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC290_tree = (CommonTree)adaptor.dupNode(ASC290);


                            adaptor.addChild(root_0, ASC290_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1337:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC291=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4133); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC291_tree = (CommonTree)adaptor.dupNode(DESC291);


                            adaptor.addChild(root_0, DESC291_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col4143);
                    col_ref292=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref292.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:19: ( ASC | DESC )?
                    int alt93=3;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==ASC) ) {
                        alt93=1;
                    }
                    else if ( (LA93_0==DESC) ) {
                        alt93=2;
                    }
                    switch (alt93) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC293=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4148); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC293_tree = (CommonTree)adaptor.dupNode(ASC293);


                            adaptor.addChild(root_0, ASC293_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC294=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4152); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC294_tree = (CommonTree)adaptor.dupNode(DESC294);


                            adaptor.addChild(root_0, DESC294_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1341:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT295=null;
        LogicalPlanGenerator.rel_return rel296 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause297 =null;


        CommonTree DISTINCT295_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT295=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause4172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT295_tree = (CommonTree)adaptor.dupNode(DISTINCT295);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT295_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause4174);
            rel296=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel296.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:20: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause4176);
                    partition_clause297=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause297.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT295 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause297!=null?partition_clause297.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1349:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION298=null;
        LogicalPlanGenerator.func_name_return func_name299 =null;


        CommonTree PARTITION298_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:2: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION298=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause4199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION298_tree = (CommonTree)adaptor.dupNode(PARTITION298);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION298_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause4201);
            func_name299=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name299.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name299!=null?func_name299.funcName:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1356:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS300=null;
        LogicalPlanGenerator.rel_list_return rel_list301 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause302 =null;


        CommonTree CROSS300_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1357:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1357:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS300=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause4223); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS300_tree = (CommonTree)adaptor.dupNode(CROSS300);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS300_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause4225);
            rel_list301=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list301.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1357:22: ( partition_clause )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==PARTITION) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1357:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause4227);
                    partition_clause302=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause302.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS300 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list301!=null?rel_list301.aliasList:null), (partition_clause302!=null?partition_clause302.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1364:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel303 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1366:2: ( ( rel )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1366:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1366:4: ( rel )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==ARROBA||LA97_0==ASSERT||LA97_0==COGROUP||(LA97_0 >= CROSS && LA97_0 <= CUBE)||LA97_0==DEFINE||LA97_0==DISTINCT||LA97_0==FILTER||LA97_0==FOREACH||LA97_0==GROUP||LA97_0==IDENTIFIER||LA97_0==JOIN||(LA97_0 >= LIMIT && LA97_0 <= LOAD)||LA97_0==MAPREDUCE||LA97_0==ORDER||LA97_0==RANK||LA97_0==SAMPLE||(LA97_0 >= STORE && LA97_0 <= STREAM)||LA97_0==UNION) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1366:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list4255);
            	    rel303=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel303.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt97 >= 1 ) break loop97;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    protected static class join_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1369:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN304=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause305 =null;

        LogicalPlanGenerator.join_type_return join_type306 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause307 =null;


        CommonTree JOIN304_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN304=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause4294); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN304_tree = (CommonTree)adaptor.dupNode(JOIN304);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN304_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause4296);
            join_sub_clause305=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause305.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:28: ( join_type )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==QUOTEDSTRING) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause4298);
                    join_type306=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type306.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:39: ( partition_clause )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==PARTITION) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause4301);
                    partition_clause307=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause307.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN304 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type306!=null?join_type306.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause307!=null?partition_clause307.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1396:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING308=null;

        CommonTree QUOTEDSTRING308_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1397:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1397:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING308=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type4322); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING308_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING308);


            adaptor.addChild(root_0, QUOTEDSTRING308_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING308!=null?QUOTEDSTRING308.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING308 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1403:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT310=null;
        CommonTree RIGHT311=null;
        CommonTree FULL312=null;
        CommonTree OUTER313=null;
        LogicalPlanGenerator.join_item_return join_item309 =null;

        LogicalPlanGenerator.join_item_return join_item314 =null;

        LogicalPlanGenerator.join_item_return join_item315 =null;


        CommonTree LEFT310_tree=null;
        CommonTree RIGHT311_tree=null;
        CommonTree FULL312_tree=null;
        CommonTree OUTER313_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==JOIN_ITEM) ) {
                int LA103_1 = input.LA(2);

                if ( (synpred180_LogicalPlanGenerator()) ) {
                    alt103=1;
                }
                else if ( (true) ) {
                    alt103=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4337);
                    join_item309=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item309.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:14: ( LEFT | RIGHT | FULL )
                    int alt100=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt100=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt100=2;
                        }
                        break;
                    case FULL:
                        {
                        alt100=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;

                    }

                    switch (alt100) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT310=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause4341); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT310_tree = (CommonTree)adaptor.dupNode(LEFT310);


                            adaptor.addChild(root_0, LEFT310_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1406:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT311=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause4360); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT311_tree = (CommonTree)adaptor.dupNode(RIGHT311);


                            adaptor.addChild(root_0, RIGHT311_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1408:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL312=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause4379); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL312_tree = (CommonTree)adaptor.dupNode(FULL312);


                            adaptor.addChild(root_0, FULL312_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1409:66: ( OUTER )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==OUTER) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1409:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER313=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause4385); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER313_tree = (CommonTree)adaptor.dupNode(OUTER313);


                            adaptor.addChild(root_0, OUTER313_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4388);
                    join_item314=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item314.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1412:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1412:4: ( join_item )+
                    int cnt102=0;
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==JOIN_ITEM) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1412:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause4398);
                    	    join_item315=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item315.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt102 >= 1 ) break loop102;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(102, input);
                                throw eee;
                        }
                        cnt102++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1415:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM316=null;
        LogicalPlanGenerator.rel_return rel317 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause318 =null;


        CommonTree JOIN_ITEM316_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1416:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1416:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM316=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item4411); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM316_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM316);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM316_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item4413);
            rel317=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel317.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item4415);
            join_group_by_clause318=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause318.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause318!=null?join_group_by_clause318.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1425:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY319=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr320 =null;


        CommonTree BY319_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1429:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1429:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY319=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause4442); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY319_tree = (CommonTree)adaptor.dupNode(BY319);


            root_1 = (CommonTree)adaptor.becomeRoot(BY319_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1429:10: ( join_group_by_expr )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==BIGDECIMALNUMBER||LA104_0==BIGINTEGERNUMBER||LA104_0==CUBE||LA104_0==DIV||LA104_0==DOLLARVAR||LA104_0==DOUBLENUMBER||LA104_0==FALSE||LA104_0==FLOATNUMBER||LA104_0==GROUP||LA104_0==IDENTIFIER||LA104_0==INTEGER||LA104_0==LONGINTEGER||LA104_0==MINUS||LA104_0==NULL||LA104_0==PERCENT||LA104_0==PLUS||LA104_0==QUOTEDSTRING||LA104_0==STAR||LA104_0==TRUE||(LA104_0 >= BAG_VAL && LA104_0 <= BIN_EXPR)||(LA104_0 >= CASE_COND && LA104_0 <= CASE_EXPR)||(LA104_0 >= CAST_EXPR && LA104_0 <= EXPR_IN_PAREN)||LA104_0==FUNC_EVAL||LA104_0==INVOKER_FUNC_EVAL||(LA104_0 >= MAP_VAL && LA104_0 <= NEG)||LA104_0==TUPLE_VAL) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1429:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause4446);
            	    join_group_by_expr320=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr320.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr320!=null?join_group_by_expr320.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1432:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR323=null;
        LogicalPlanGenerator.col_range_return col_range321 =null;

        LogicalPlanGenerator.expr_return expr322 =null;


        CommonTree STAR323_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1436:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt105=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt105=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt105=2;
                }
                break;
            case STAR:
                {
                int LA105_3 = input.LA(2);

                if ( (LA105_3==DOWN) ) {
                    alt105=2;
                }
                else if ( (LA105_3==EOF||LA105_3==UP||LA105_3==BIGDECIMALNUMBER||LA105_3==BIGINTEGERNUMBER||LA105_3==CUBE||LA105_3==DIV||LA105_3==DOLLARVAR||LA105_3==DOUBLENUMBER||LA105_3==FALSE||LA105_3==FLOATNUMBER||LA105_3==GROUP||LA105_3==IDENTIFIER||LA105_3==INTEGER||LA105_3==LONGINTEGER||LA105_3==MINUS||LA105_3==NULL||LA105_3==PERCENT||LA105_3==PLUS||LA105_3==QUOTEDSTRING||LA105_3==STAR||LA105_3==TRUE||(LA105_3 >= BAG_VAL && LA105_3 <= BIN_EXPR)||(LA105_3 >= CASE_COND && LA105_3 <= CASE_EXPR)||(LA105_3 >= CAST_EXPR && LA105_3 <= EXPR_IN_PAREN)||LA105_3==FUNC_EVAL||LA105_3==INVOKER_FUNC_EVAL||(LA105_3 >= MAP_VAL && LA105_3 <= NEG)||LA105_3==TUPLE_VAL) ) {
                    alt105=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }

            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1436:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr4471);
                    col_range321=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range321.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1437:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr4477);
                    expr322=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr322.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1438:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR323=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr4483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR323_tree = (CommonTree)adaptor.dupNode(STAR323);


                    adaptor.addChild(root_0, STAR323_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR323 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1445:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION324=null;
        CommonTree ONSCHEMA325=null;
        LogicalPlanGenerator.rel_list_return rel_list326 =null;


        CommonTree UNION324_tree=null;
        CommonTree ONSCHEMA325_tree=null;


            boolean onSchema = false;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION324=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause4508); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION324_tree = (CommonTree)adaptor.dupNode(UNION324);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION324_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:13: ( ONSCHEMA )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==ONSCHEMA) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA325=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause4512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA325_tree = (CommonTree)adaptor.dupNode(ONSCHEMA325);


                    adaptor.addChild(root_1, ONSCHEMA325_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause4519);
            rel_list326=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list326.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION324 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list326!=null?rel_list326.aliasList:null), onSchema );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1456:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH327=null;
        LogicalPlanGenerator.rel_return rel328 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan329 =null;


        CommonTree FOREACH327_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1465:2: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1465:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH327=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH327_tree = (CommonTree)adaptor.dupNode(FOREACH327);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause4557);
            rel328=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel328.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause4559);
            foreach_plan329=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan329.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH327 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan329!=null?foreach_plan329.plan:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE330=null;
        CommonTree FOREACH_PLAN_COMPLEX332=null;
        LogicalPlanGenerator.generate_clause_return generate_clause331 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk333 =null;


        CommonTree FOREACH_PLAN_SIMPLE330_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX332_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1489:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==FOREACH_PLAN_SIMPLE) ) {
                alt107=1;
            }
            else if ( (LA107_0==FOREACH_PLAN_COMPLEX) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1489:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE330=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE330_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE330);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE330_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan4597);
                    generate_clause331=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause331.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1490:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX332=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX332_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX332);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX332_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan4608);
                    nested_blk333=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk333.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command334 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause335 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:12: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:14: ( nested_command )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( ((LA108_0 >= NESTED_CMD && LA108_0 <= NESTED_CMD_ASSI)) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk4619);
            	    nested_command334=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command334.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk4622);
            generate_clause335=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause335.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1496:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD336=null;
        CommonTree IDENTIFIER337=null;
        CommonTree NESTED_CMD_ASSI339=null;
        CommonTree IDENTIFIER340=null;
        LogicalPlanGenerator.nested_op_return nested_op338 =null;

        LogicalPlanGenerator.expr_return expr341 =null;


        CommonTree NESTED_CMD336_tree=null;
        CommonTree IDENTIFIER337_tree=null;
        CommonTree NESTED_CMD_ASSI339_tree=null;
        CommonTree IDENTIFIER340_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1504:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NESTED_CMD) ) {
                alt109=1;
            }
            else if ( (LA109_0==NESTED_CMD_ASSI) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1504:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD336=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD336_tree = (CommonTree)adaptor.dupNode(NESTED_CMD336);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD336_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER337=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER337_tree = (CommonTree)adaptor.dupNode(IDENTIFIER337);


                    adaptor.addChild(root_1, IDENTIFIER337_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command4648);
                    nested_op338=nested_op((IDENTIFIER337!=null?IDENTIFIER337.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op338.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER337!=null?IDENTIFIER337.getText():null), (nested_op338!=null?nested_op338.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER337!=null?IDENTIFIER337.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1510:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI339=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI339_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI339);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI339_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER340=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4668); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER340_tree = (CommonTree)adaptor.dupNode(IDENTIFIER340);


                    adaptor.addChild(root_1, IDENTIFIER340_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command4670);
                    expr341=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr341.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER340!=null?IDENTIFIER340.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1516:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj342 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter343 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort344 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct345 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit346 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross347 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach348 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt110=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt110=1;
                }
                break;
            case FILTER:
                {
                alt110=2;
                }
                break;
            case ORDER:
                {
                alt110=3;
                }
                break;
            case DISTINCT:
                {
                alt110=4;
                }
                break;
            case LIMIT:
                {
                alt110=5;
                }
                break;
            case CROSS:
                {
                alt110=6;
                }
                break;
            case FOREACH:
                {
                alt110=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op4692);
                    nested_proj342=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj342.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj342!=null?nested_proj342.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1518:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op4700);
                    nested_filter343=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter343.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter343!=null?nested_filter343.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1519:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op4708);
                    nested_sort344=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort344.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort344!=null?nested_sort344.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1520:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4717);
                    nested_distinct345=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct345.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct345!=null?nested_distinct345.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1521:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4725);
                    nested_limit346=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit346.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit346!=null?nested_limit346.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1522:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4733);
                    nested_cross347=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross347.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross347!=null?nested_cross347.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1523:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4741);
                    nested_foreach348=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach348.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach348!=null?nested_foreach348.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1526:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ349=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ349_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1531:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1531:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ349=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ349_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ349);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ349_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4777);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1533:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt111=0;
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1533:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4792);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt111 >= 1 ) break loop111;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(111, input);
                        throw eee;
                }
                cnt111++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1545:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER350=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input351 =null;

        LogicalPlanGenerator.cond_return cond352 =null;


        CommonTree FILTER350_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1552:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1552:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER350=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER350_tree = (CommonTree)adaptor.dupNode(FILTER350);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER350_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4847);
            nested_op_input351=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input351.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4849);
            cond352=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond352.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER350 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input351!=null?nested_op_input351.op:null), plan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1560:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER353=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input354 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause355 =null;

        LogicalPlanGenerator.func_clause_return func_clause356 =null;


        CommonTree ORDER353_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER353=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4883); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER353_tree = (CommonTree)adaptor.dupNode(ORDER353);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER353_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4885);
            nested_op_input354=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input354.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4887);
            order_by_clause355=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause355.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==FUNC||LA112_0==FUNC_REF) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4889);
                    func_clause356=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause356.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER353 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input354!=null?nested_op_input354.op:null),
                       (order_by_clause355!=null?order_by_clause355.plans:null), (order_by_clause355!=null?order_by_clause355.ascFlags:null), (func_clause356!=null?func_clause356.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1575:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT357=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input358 =null;


        CommonTree DISTINCT357_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1579:2: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1579:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT357=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT357_tree = (CommonTree)adaptor.dupNode(DISTINCT357);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT357_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4921);
            nested_op_input358=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input358.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT357 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input358!=null?nested_op_input358.op:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1586:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT359=null;
        CommonTree INTEGER361=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input360 =null;

        LogicalPlanGenerator.expr_return expr362 =null;


        CommonTree LIMIT359_tree=null;
        CommonTree INTEGER361_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT359=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4954); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT359_tree = (CommonTree)adaptor.dupNode(LIMIT359);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT359_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4956);
            nested_op_input360=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input360.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:29: ( INTEGER | expr[exprPlan] )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==INTEGER) ) {
                int LA113_1 = input.LA(2);

                if ( (synpred197_LogicalPlanGenerator()) ) {
                    alt113=1;
                }
                else if ( (true) ) {
                    alt113=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 113, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||LA113_0==CAST_EXPR||LA113_0==EXPR_IN_PAREN||LA113_0==FUNC_EVAL||LA113_0==INVOKER_FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }
            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER361=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER361_tree = (CommonTree)adaptor.dupNode(INTEGER361);


                    adaptor.addChild(root_1, INTEGER361_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT359 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input360!=null?nested_op_input360.op:null),
                               Integer.valueOf( (INTEGER361!=null?INTEGER361.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1599:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4970);
                    expr362=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr362.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT359 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input360!=null?nested_op_input360.op:null), exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1608:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS363=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list364 =null;


        CommonTree CROSS363_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1612:2: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1612:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS363=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross5003); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS363_tree = (CommonTree)adaptor.dupNode(CROSS363);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS363_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross5005);
            nested_op_input_list364=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list364.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS363 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list364!=null?nested_op_input_list364.opList:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1619:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH365=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input366 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause367 =null;


        CommonTree FOREACH365_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH365=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach5037); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH365_tree = (CommonTree)adaptor.dupNode(FOREACH365);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH365_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach5039);
            nested_op_input366=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input366.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach5041);
            generate_clause367=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause367.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH365 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input366!=null?nested_op_input366.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1637:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE368=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item369 =null;


        CommonTree GENERATE368_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1645:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1645:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE368=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause5070); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE368_tree = (CommonTree)adaptor.dupNode(GENERATE368);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE368_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1645:16: ( flatten_generated_item )+
            int cnt114=0;
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==BIGDECIMALNUMBER||LA114_0==BIGINTEGERNUMBER||LA114_0==CUBE||LA114_0==DIV||LA114_0==DOLLARVAR||LA114_0==DOUBLENUMBER||LA114_0==FALSE||LA114_0==FLATTEN||LA114_0==FLOATNUMBER||LA114_0==GROUP||LA114_0==IDENTIFIER||LA114_0==INTEGER||LA114_0==LONGINTEGER||LA114_0==MINUS||LA114_0==NULL||LA114_0==PERCENT||LA114_0==PLUS||LA114_0==QUOTEDSTRING||LA114_0==STAR||LA114_0==TRUE||(LA114_0 >= BAG_VAL && LA114_0 <= BIN_EXPR)||(LA114_0 >= CASE_COND && LA114_0 <= CASE_EXPR)||(LA114_0 >= CAST_EXPR && LA114_0 <= EXPR_IN_PAREN)||LA114_0==FUNC_EVAL||LA114_0==INVOKER_FUNC_EVAL||(LA114_0 >= MAP_VAL && LA114_0 <= NEG)||LA114_0==TUPLE_VAL) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1645:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause5074);
            	    flatten_generated_item369=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item369.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item369!=null?flatten_generated_item369.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item369!=null?flatten_generated_item369.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item369!=null?flatten_generated_item369.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt114 >= 1 ) break loop114;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(114, input);
                        throw eee;
                }
                cnt114++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE368 ),
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, plans, flattenFlags, schemas );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1660:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref370 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj371 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1664:2: ( col_ref[plan] | nested_proj[null] )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER) ) {
                alt115=1;
            }
            else if ( (LA115_0==NESTED_PROJ) ) {
                alt115=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }
            switch (alt115) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1664:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input5140);
                    col_ref370=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref370.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref370!=null?((CommonTree)col_ref370.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref370!=null?col_ref370.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1670:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input5151);
                    nested_proj371=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj371.getTree());


                    if ( state.backtracking==0 ) {
                           retval.op = (nested_proj371!=null?nested_proj371.op:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1676:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input372 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1678:2: ( ( nested_op_input )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1678:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1678:4: ( nested_op_input )+
            int cnt116=0;
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==CUBE||LA116_0==DOLLARVAR||LA116_0==GROUP||LA116_0==IDENTIFIER||LA116_0==NESTED_PROJ) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1678:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list5177);
            	    nested_op_input372=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input372.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input372!=null?nested_op_input372.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt116 >= 1 ) break loop116;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(116, input);
                        throw eee;
                }
                cnt116++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1681:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM373=null;
        CommonTree EXECCOMMAND375=null;
        CommonTree IDENTIFIER376=null;
        LogicalPlanGenerator.rel_return rel374 =null;

        LogicalPlanGenerator.as_clause_return as_clause377 =null;


        CommonTree STREAM373_tree=null;
        CommonTree EXECCOMMAND375_tree=null;
        CommonTree IDENTIFIER376_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1686:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1686:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM373=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause5202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM373_tree = (CommonTree)adaptor.dupNode(STREAM373);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM373_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause5204);
            rel374=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel374.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1686:18: ( EXECCOMMAND | IDENTIFIER )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==EXECCOMMAND) ) {
                alt117=1;
            }
            else if ( (LA117_0==IDENTIFIER) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1686:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND375=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause5208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND375_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND375);


                    adaptor.addChild(root_1, EXECCOMMAND375_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND375!=null?EXECCOMMAND375.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1687:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER376=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause5231); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER376_tree = (CommonTree)adaptor.dupNode(IDENTIFIER376);


                    adaptor.addChild(root_1, IDENTIFIER376_tree);
                    }


                    if ( state.backtracking==0 ) {
                                           cmd = builder.lookupCommand( (IDENTIFIER376!=null?IDENTIFIER376.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER376!=null?IDENTIFIER376.getText():null) + "]";
                                               throw new ParserValidationException( input,
                                                   new SourceLocation( (PigParserNode)IDENTIFIER376 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:20: ( as_clause )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==AS) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause5273);
                    as_clause377=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause377.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause377!=null?as_clause377.logicalSchema:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE378=null;
        CommonTree QUOTEDSTRING379=null;
        CommonTree EXECCOMMAND383=null;
        LogicalPlanGenerator.path_list_return path_list380 =null;

        LogicalPlanGenerator.store_clause_return store_clause381 =null;

        LogicalPlanGenerator.load_clause_return load_clause382 =null;


        CommonTree MAPREDUCE378_tree=null;
        CommonTree QUOTEDSTRING379_tree=null;
        CommonTree EXECCOMMAND383_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1709:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1709:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE378=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause5301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE378_tree = (CommonTree)adaptor.dupNode(MAPREDUCE378);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE378_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING379=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause5303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING379_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING379);


            adaptor.addChild(root_1, QUOTEDSTRING379_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1709:30: ( path_list[paths] )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==QUOTEDSTRING) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1709:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause5305);
                    path_list380=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list380.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause5316);
            store_clause381=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause381.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause5325);
            load_clause382=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause382.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1712:6: ( EXECCOMMAND )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==EXECCOMMAND) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1712:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND383=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause5332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND383_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND383);


                    adaptor.addChild(root_1, EXECCOMMAND383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING379!=null?QUOTEDSTRING379.getText():null) ), builder.unquote( (EXECCOMMAND383!=null?EXECCOMMAND383.getText():null) ),
                       paths, (store_clause381!=null?store_clause381.alias:null), (load_clause382!=null?load_clause382.alias:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1720:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT384=null;
        LogicalPlanGenerator.rel_return rel385 =null;

        LogicalPlanGenerator.split_branch_return split_branch386 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise387 =null;


        CommonTree SPLIT384_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT384=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause5352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT384_tree = (CommonTree)adaptor.dupNode(SPLIT384);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT384_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause5360);
            rel385=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel385.getTree());


            if ( state.backtracking==0 ) {
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT384 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1727:7: ( split_branch )+
            int cnt121=0;
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==SPLIT_BRANCH) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1727:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause5376);
            	    split_branch386=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch386.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt121 >= 1 ) break loop121;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(121, input);
                        throw eee;
                }
                cnt121++;
            } while (true);


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1727:21: ( split_otherwise )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==OTHERWISE) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1727:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause5379);
                    split_otherwise387=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise387.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1731:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH388=null;
        LogicalPlanGenerator.alias_return alias389 =null;

        LogicalPlanGenerator.cond_return cond390 =null;


        CommonTree SPLIT_BRANCH388_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1737:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1737:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH388=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch5408); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH388_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH388);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH388_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch5410);
            alias389=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias389.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch5412);
            cond390=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond390.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias389!=null?((CommonTree)alias389.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias389!=null?alias389.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1745:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE391=null;
        LogicalPlanGenerator.alias_return alias392 =null;


        CommonTree OTHERWISE391_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1750:2: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1750:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE391=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise5446); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE391_tree = (CommonTree)adaptor.dupNode(OTHERWISE391);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE391_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise5448);
            alias392=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias392.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias392!=null?((CommonTree)alias392.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias392!=null?alias392.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1758:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref393 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref394 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1759:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==CUBE||LA123_0==GROUP||LA123_0==IDENTIFIER) ) {
                alt123=1;
            }
            else if ( (LA123_0==DOLLARVAR) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }
            switch (alt123) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1759:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref5468);
                    alias_col_ref393=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref393.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref393!=null?alias_col_ref393.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1760:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref5476);
                    dollar_col_ref394=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref394.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref394!=null?dollar_col_ref394.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1763:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP395=null;
        CommonTree CUBE396=null;
        CommonTree IDENTIFIER397=null;

        CommonTree GROUP395_tree=null;
        CommonTree CUBE396_tree=null;
        CommonTree IDENTIFIER397_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1764:2: ( GROUP | CUBE | IDENTIFIER )
            int alt124=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt124=1;
                }
                break;
            case CUBE:
                {
                alt124=2;
                }
                break;
            case IDENTIFIER:
                {
                alt124=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1764:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP395=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref5493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP395_tree = (CommonTree)adaptor.dupNode(GROUP395);


                    adaptor.addChild(root_0, GROUP395_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP395 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP395!=null?GROUP395.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1769:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE396=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref5503); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE396_tree = (CommonTree)adaptor.dupNode(CUBE396);


                    adaptor.addChild(root_0, CUBE396_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)CUBE396 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (CUBE396!=null?CUBE396.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1774:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER397=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref5513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER397_tree = (CommonTree)adaptor.dupNode(IDENTIFIER397);


                    adaptor.addChild(root_0, IDENTIFIER397_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER397 );
                           String alias = (IDENTIFIER397!=null?IDENTIFIER397.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }

                           // PIG-3581
                           // check within foreach scope before looking at outer scope for scalar
                           if( inForeachPlan && (((foreach_plan_scope)foreach_plan_stack.peek()).operators).containsKey(alias)) {
                               retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                   ((foreach_plan_scope)foreach_plan_stack.peek()).operators, ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                           } else {
                               Operator op = builder.lookupOperator( alias );
                               if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                                   retval.expr = new ScalarExpression( plan, op,
                                       inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                                   retval.expr.setLocation( loc );
                               } else if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1812:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR398=null;

        CommonTree DOLLARVAR398_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1813:2: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1813:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR398=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5532); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR398_tree = (CommonTree)adaptor.dupNode(DOLLARVAR398);


            adaptor.addChild(root_0, DOLLARVAR398_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR398!=null?DOLLARVAR398.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR398 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1821:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal399 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1822:2: ( literal )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1822:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr5551);
            literal399=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal399.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal399!=null?literal399.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1829:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar400 =null;

        LogicalPlanGenerator.map_return map401 =null;

        LogicalPlanGenerator.bag_return bag402 =null;

        LogicalPlanGenerator.tuple_return tuple403 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:2: ( scalar | map | bag | tuple )
            int alt125=4;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
                {
                alt125=1;
                }
                break;
            case MAP_VAL:
                {
                alt125=2;
                }
                break;
            case BAG_VAL:
                {
                alt125=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt125=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;

            }

            switch (alt125) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal5569);
                    scalar400=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar400.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar400!=null?scalar400.value:null);
                           retval.type = (scalar400!=null?scalar400.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1835:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal5579);
                    map401=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map401.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map401!=null?map401.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1840:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal5589);
                    bag402=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag402.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag402!=null?bag402.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1845:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal5599);
                    tuple403=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple403.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple403!=null?tuple403.value:null);
                           retval.type = DataType.TUPLE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1852:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING405=null;
        CommonTree NULL406=null;
        CommonTree TRUE407=null;
        CommonTree FALSE408=null;
        LogicalPlanGenerator.num_scalar_return num_scalar404 =null;


        CommonTree QUOTEDSTRING405_tree=null;
        CommonTree NULL406_tree=null;
        CommonTree TRUE407_tree=null;
        CommonTree FALSE408_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1853:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt126=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt126=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt126=2;
                }
                break;
            case NULL:
                {
                alt126=3;
                }
                break;
            case TRUE:
                {
                alt126=4;
                }
                break;
            case FALSE:
                {
                alt126=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;

            }

            switch (alt126) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1853:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar5617);
                    num_scalar404=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar404.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar404!=null?num_scalar404.type:0);
                           retval.value = (num_scalar404!=null?num_scalar404.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1858:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING405=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING405_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING405);


                    adaptor.addChild(root_0, QUOTEDSTRING405_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING405!=null?QUOTEDSTRING405.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1863:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL406=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL406_tree = (CommonTree)adaptor.dupNode(NULL406);


                    adaptor.addChild(root_0, NULL406_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1867:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE407=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE407_tree = (CommonTree)adaptor.dupNode(TRUE407);


                    adaptor.addChild(root_0, TRUE407_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE408=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE408_tree = (CommonTree)adaptor.dupNode(FALSE408);


                    adaptor.addChild(root_0, FALSE408_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1879:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS409=null;
        CommonTree INTEGER410=null;
        CommonTree LONGINTEGER411=null;
        CommonTree FLOATNUMBER412=null;
        CommonTree DOUBLENUMBER413=null;
        CommonTree BIGINTEGERNUMBER414=null;
        CommonTree BIGDECIMALNUMBER415=null;

        CommonTree MINUS409_tree=null;
        CommonTree INTEGER410_tree=null;
        CommonTree LONGINTEGER411_tree=null;
        CommonTree FLOATNUMBER412_tree=null;
        CommonTree DOUBLENUMBER413_tree=null;
        CommonTree BIGINTEGERNUMBER414_tree=null;
        CommonTree BIGDECIMALNUMBER415_tree=null;


            int sign = 1;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:4: ( MINUS )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==MINUS) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS409=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS409_tree = (CommonTree)adaptor.dupNode(MINUS409);


                    adaptor.addChild(root_0, MINUS409_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1884:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt128=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt128=1;
                }
                break;
            case LONGINTEGER:
                {
                alt128=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt128=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt128=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt128=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt128=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;

            }

            switch (alt128) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1884:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER410=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER410_tree = (CommonTree)adaptor.dupNode(INTEGER410);


                    adaptor.addChild(root_0, INTEGER410_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER410!=null?INTEGER410.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1889:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER411=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER411_tree = (CommonTree)adaptor.dupNode(LONGINTEGER411);


                    adaptor.addChild(root_0, LONGINTEGER411_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER411!=null?LONGINTEGER411.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1894:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER412=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER412_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER412);


                    adaptor.addChild(root_0, FLOATNUMBER412_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER412!=null?FLOATNUMBER412.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1899:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER413=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5737); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER413_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER413);


                    adaptor.addChild(root_0, DOUBLENUMBER413_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER413!=null?DOUBLENUMBER413.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1904:6: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER414=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar5751); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER414_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER414);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER414_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGINTEGER;
                             retval.value = builder.parseBigInteger( (BIGINTEGERNUMBER414!=null?BIGINTEGERNUMBER414.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigInteger)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1912:6: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER415=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar5765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER415_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER415);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER415_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGDECIMAL;
                             retval.value = builder.parseBigDecimal( (BIGDECIMALNUMBER415!=null?BIGDECIMALNUMBER415.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigDecimal)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1923:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL416=null;
        LogicalPlanGenerator.keyvalue_return keyvalue417 =null;


        CommonTree MAP_VAL416_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1925:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1925:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL416=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL416_tree = (CommonTree)adaptor.dupNode(MAP_VAL416);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL416_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1925:15: ( keyvalue )*
                loop129:
                do {
                    int alt129=2;
                    int LA129_0 = input.LA(1);

                    if ( (LA129_0==KEY_VAL_PAIR) ) {
                        alt129=1;
                    }


                    switch (alt129) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1925:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map5801);
                	    keyvalue417=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue417.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue417!=null?keyvalue417.key:null), (keyvalue417!=null?keyvalue417.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop129;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1931:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR418=null;
        LogicalPlanGenerator.map_key_return map_key419 =null;

        LogicalPlanGenerator.literal_return literal420 =null;


        CommonTree KEY_VAL_PAIR418_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1932:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1932:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR418=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5828); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR418_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR418);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR418_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue5830);
            map_key419=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key419.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue5832);
            literal420=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal420.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key419!=null?map_key419.value:null);
                   retval.value = (literal420!=null?literal420.value:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1939:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING421=null;

        CommonTree QUOTEDSTRING421_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1940:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1940:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING421=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING421_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING421);


            adaptor.addChild(root_0, QUOTEDSTRING421_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING421!=null?QUOTEDSTRING421.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1943:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL422=null;
        LogicalPlanGenerator.tuple_return tuple423 =null;


        CommonTree BAG_VAL422_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:2: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL422=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag5874); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL422_tree = (CommonTree)adaptor.dupNode(BAG_VAL422);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL422_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:15: ( tuple )*
                loop130:
                do {
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==TUPLE_VAL) ) {
                        alt130=1;
                    }


                    switch (alt130) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag5878);
                	    tuple423=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple423.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple423!=null?tuple423.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop130;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1951:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL424=null;
        LogicalPlanGenerator.literal_return literal425 =null;


        CommonTree TUPLE_VAL424_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL424=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple5910); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL424_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL424);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL424_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:17: ( literal )*
                loop131:
                do {
                    int alt131=2;
                    int LA131_0 = input.LA(1);

                    if ( (LA131_0==BIGDECIMALNUMBER||LA131_0==BIGINTEGERNUMBER||LA131_0==DOUBLENUMBER||LA131_0==FALSE||LA131_0==FLOATNUMBER||LA131_0==INTEGER||LA131_0==LONGINTEGER||LA131_0==MINUS||LA131_0==NULL||LA131_0==QUOTEDSTRING||LA131_0==TRUE||LA131_0==BAG_VAL||LA131_0==MAP_VAL||LA131_0==TUPLE_VAL) ) {
                        alt131=1;
                    }


                    switch (alt131) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple5914);
                	    literal425=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal425.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal425!=null?literal425.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop131;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT427=null;
        CommonTree RETURNS428=null;
        CommonTree DEFINE429=null;
        CommonTree LOAD430=null;
        CommonTree FILTER431=null;
        CommonTree FOREACH432=null;
        CommonTree MATCHES433=null;
        CommonTree ORDER434=null;
        CommonTree DISTINCT435=null;
        CommonTree COGROUP436=null;
        CommonTree CUBE437=null;
        CommonTree ROLLUP438=null;
        CommonTree PIVOT439=null;
        CommonTree CHUNKSIZE440=null;
        CommonTree RATE441=null;
        CommonTree JOIN442=null;
        CommonTree CROSS443=null;
        CommonTree UNION444=null;
        CommonTree SPLIT445=null;
        CommonTree INTO446=null;
        CommonTree IF447=null;
        CommonTree ALL448=null;
        CommonTree AS449=null;
        CommonTree BY450=null;
        CommonTree USING451=null;
        CommonTree INNER452=null;
        CommonTree OUTER453=null;
        CommonTree PARALLEL454=null;
        CommonTree PARTITION455=null;
        CommonTree GROUP456=null;
        CommonTree AND457=null;
        CommonTree OR458=null;
        CommonTree NOT459=null;
        CommonTree GENERATE460=null;
        CommonTree FLATTEN461=null;
        CommonTree EVAL462=null;
        CommonTree ASC463=null;
        CommonTree DESC464=null;
        CommonTree BOOLEAN465=null;
        CommonTree INT466=null;
        CommonTree LONG467=null;
        CommonTree FLOAT468=null;
        CommonTree DOUBLE469=null;
        CommonTree BIGINTEGER470=null;
        CommonTree BIGDECIMAL471=null;
        CommonTree DATETIME472=null;
        CommonTree CHARARRAY473=null;
        CommonTree BYTEARRAY474=null;
        CommonTree BAG475=null;
        CommonTree TUPLE476=null;
        CommonTree MAP477=null;
        CommonTree IS478=null;
        CommonTree NULL479=null;
        CommonTree TRUE480=null;
        CommonTree FALSE481=null;
        CommonTree STREAM482=null;
        CommonTree THROUGH483=null;
        CommonTree STORE484=null;
        CommonTree MAPREDUCE485=null;
        CommonTree SHIP486=null;
        CommonTree CACHE487=null;
        CommonTree INPUT488=null;
        CommonTree OUTPUT489=null;
        CommonTree STDERROR490=null;
        CommonTree STDIN491=null;
        CommonTree STDOUT492=null;
        CommonTree LIMIT493=null;
        CommonTree SAMPLE494=null;
        CommonTree LEFT495=null;
        CommonTree RIGHT496=null;
        CommonTree FULL497=null;
        CommonTree IDENTIFIER498=null;
        CommonTree TOBAG499=null;
        CommonTree TOMAP500=null;
        CommonTree TOTUPLE501=null;
        CommonTree ASSERT502=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op426 =null;


        CommonTree IMPORT427_tree=null;
        CommonTree RETURNS428_tree=null;
        CommonTree DEFINE429_tree=null;
        CommonTree LOAD430_tree=null;
        CommonTree FILTER431_tree=null;
        CommonTree FOREACH432_tree=null;
        CommonTree MATCHES433_tree=null;
        CommonTree ORDER434_tree=null;
        CommonTree DISTINCT435_tree=null;
        CommonTree COGROUP436_tree=null;
        CommonTree CUBE437_tree=null;
        CommonTree ROLLUP438_tree=null;
        CommonTree PIVOT439_tree=null;
        CommonTree CHUNKSIZE440_tree=null;
        CommonTree RATE441_tree=null;
        CommonTree JOIN442_tree=null;
        CommonTree CROSS443_tree=null;
        CommonTree UNION444_tree=null;
        CommonTree SPLIT445_tree=null;
        CommonTree INTO446_tree=null;
        CommonTree IF447_tree=null;
        CommonTree ALL448_tree=null;
        CommonTree AS449_tree=null;
        CommonTree BY450_tree=null;
        CommonTree USING451_tree=null;
        CommonTree INNER452_tree=null;
        CommonTree OUTER453_tree=null;
        CommonTree PARALLEL454_tree=null;
        CommonTree PARTITION455_tree=null;
        CommonTree GROUP456_tree=null;
        CommonTree AND457_tree=null;
        CommonTree OR458_tree=null;
        CommonTree NOT459_tree=null;
        CommonTree GENERATE460_tree=null;
        CommonTree FLATTEN461_tree=null;
        CommonTree EVAL462_tree=null;
        CommonTree ASC463_tree=null;
        CommonTree DESC464_tree=null;
        CommonTree BOOLEAN465_tree=null;
        CommonTree INT466_tree=null;
        CommonTree LONG467_tree=null;
        CommonTree FLOAT468_tree=null;
        CommonTree DOUBLE469_tree=null;
        CommonTree BIGINTEGER470_tree=null;
        CommonTree BIGDECIMAL471_tree=null;
        CommonTree DATETIME472_tree=null;
        CommonTree CHARARRAY473_tree=null;
        CommonTree BYTEARRAY474_tree=null;
        CommonTree BAG475_tree=null;
        CommonTree TUPLE476_tree=null;
        CommonTree MAP477_tree=null;
        CommonTree IS478_tree=null;
        CommonTree NULL479_tree=null;
        CommonTree TRUE480_tree=null;
        CommonTree FALSE481_tree=null;
        CommonTree STREAM482_tree=null;
        CommonTree THROUGH483_tree=null;
        CommonTree STORE484_tree=null;
        CommonTree MAPREDUCE485_tree=null;
        CommonTree SHIP486_tree=null;
        CommonTree CACHE487_tree=null;
        CommonTree INPUT488_tree=null;
        CommonTree OUTPUT489_tree=null;
        CommonTree STDERROR490_tree=null;
        CommonTree STDIN491_tree=null;
        CommonTree STDOUT492_tree=null;
        CommonTree LIMIT493_tree=null;
        CommonTree SAMPLE494_tree=null;
        CommonTree LEFT495_tree=null;
        CommonTree RIGHT496_tree=null;
        CommonTree FULL497_tree=null;
        CommonTree IDENTIFIER498_tree=null;
        CommonTree TOBAG499_tree=null;
        CommonTree TOMAP500_tree=null;
        CommonTree TOTUPLE501_tree=null;
        CommonTree ASSERT502_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt132=77;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt132=1;
                }
                break;
            case IMPORT:
                {
                alt132=2;
                }
                break;
            case RETURNS:
                {
                alt132=3;
                }
                break;
            case DEFINE:
                {
                alt132=4;
                }
                break;
            case LOAD:
                {
                alt132=5;
                }
                break;
            case FILTER:
                {
                alt132=6;
                }
                break;
            case FOREACH:
                {
                alt132=7;
                }
                break;
            case MATCHES:
                {
                alt132=8;
                }
                break;
            case ORDER:
                {
                alt132=9;
                }
                break;
            case DISTINCT:
                {
                alt132=10;
                }
                break;
            case COGROUP:
                {
                alt132=11;
                }
                break;
            case CUBE:
                {
                alt132=12;
                }
                break;
            case ROLLUP:
                {
                alt132=13;
                }
                break;
            case PIVOT:
                {
                alt132=14;
                }
                break;
            case CHUNKSIZE:
                {
                alt132=15;
                }
                break;
            case RATE:
                {
                alt132=16;
                }
                break;
            case JOIN:
                {
                alt132=17;
                }
                break;
            case CROSS:
                {
                alt132=18;
                }
                break;
            case UNION:
                {
                alt132=19;
                }
                break;
            case SPLIT:
                {
                alt132=20;
                }
                break;
            case INTO:
                {
                alt132=21;
                }
                break;
            case IF:
                {
                alt132=22;
                }
                break;
            case ALL:
                {
                alt132=23;
                }
                break;
            case AS:
                {
                alt132=24;
                }
                break;
            case BY:
                {
                alt132=25;
                }
                break;
            case USING:
                {
                alt132=26;
                }
                break;
            case INNER:
                {
                alt132=27;
                }
                break;
            case OUTER:
                {
                alt132=28;
                }
                break;
            case PARALLEL:
                {
                alt132=29;
                }
                break;
            case PARTITION:
                {
                alt132=30;
                }
                break;
            case GROUP:
                {
                alt132=31;
                }
                break;
            case AND:
                {
                alt132=32;
                }
                break;
            case OR:
                {
                alt132=33;
                }
                break;
            case NOT:
                {
                alt132=34;
                }
                break;
            case GENERATE:
                {
                alt132=35;
                }
                break;
            case FLATTEN:
                {
                alt132=36;
                }
                break;
            case EVAL:
                {
                alt132=37;
                }
                break;
            case ASC:
                {
                alt132=38;
                }
                break;
            case DESC:
                {
                alt132=39;
                }
                break;
            case BOOLEAN:
                {
                alt132=40;
                }
                break;
            case INT:
                {
                alt132=41;
                }
                break;
            case LONG:
                {
                alt132=42;
                }
                break;
            case FLOAT:
                {
                alt132=43;
                }
                break;
            case DOUBLE:
                {
                alt132=44;
                }
                break;
            case BIGINTEGER:
                {
                alt132=45;
                }
                break;
            case BIGDECIMAL:
                {
                alt132=46;
                }
                break;
            case DATETIME:
                {
                alt132=47;
                }
                break;
            case CHARARRAY:
                {
                alt132=48;
                }
                break;
            case BYTEARRAY:
                {
                alt132=49;
                }
                break;
            case BAG:
                {
                alt132=50;
                }
                break;
            case TUPLE:
                {
                alt132=51;
                }
                break;
            case MAP:
                {
                alt132=52;
                }
                break;
            case IS:
                {
                alt132=53;
                }
                break;
            case NULL:
                {
                alt132=54;
                }
                break;
            case TRUE:
                {
                alt132=55;
                }
                break;
            case FALSE:
                {
                alt132=56;
                }
                break;
            case STREAM:
                {
                alt132=57;
                }
                break;
            case THROUGH:
                {
                alt132=58;
                }
                break;
            case STORE:
                {
                alt132=59;
                }
                break;
            case MAPREDUCE:
                {
                alt132=60;
                }
                break;
            case SHIP:
                {
                alt132=61;
                }
                break;
            case CACHE:
                {
                alt132=62;
                }
                break;
            case INPUT:
                {
                alt132=63;
                }
                break;
            case OUTPUT:
                {
                alt132=64;
                }
                break;
            case STDERROR:
                {
                alt132=65;
                }
                break;
            case STDIN:
                {
                alt132=66;
                }
                break;
            case STDOUT:
                {
                alt132=67;
                }
                break;
            case LIMIT:
                {
                alt132=68;
                }
                break;
            case SAMPLE:
                {
                alt132=69;
                }
                break;
            case LEFT:
                {
                alt132=70;
                }
                break;
            case RIGHT:
                {
                alt132=71;
                }
                break;
            case FULL:
                {
                alt132=72;
                }
                break;
            case IDENTIFIER:
                {
                alt132=73;
                }
                break;
            case TOBAG:
                {
                alt132=74;
                }
                break;
            case TOMAP:
                {
                alt132=75;
                }
                break;
            case TOTUPLE:
                {
                alt132=76;
                }
                break;
            case ASSERT:
                {
                alt132=77;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;

            }

            switch (alt132) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid5939);
                    rel_str_op426=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op426.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op426!=null?rel_str_op426.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1961:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT427=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5949); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT427_tree = (CommonTree)adaptor.dupNode(IMPORT427);


                    adaptor.addChild(root_0, IMPORT427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT427!=null?IMPORT427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1962:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS428=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5959); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS428_tree = (CommonTree)adaptor.dupNode(RETURNS428);


                    adaptor.addChild(root_0, RETURNS428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS428!=null?RETURNS428.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1963:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE429=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE429_tree = (CommonTree)adaptor.dupNode(DEFINE429);


                    adaptor.addChild(root_0, DEFINE429_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE429!=null?DEFINE429.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1964:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD430=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD430_tree = (CommonTree)adaptor.dupNode(LOAD430);


                    adaptor.addChild(root_0, LOAD430_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD430!=null?LOAD430.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1965:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER431=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER431_tree = (CommonTree)adaptor.dupNode(FILTER431);


                    adaptor.addChild(root_0, FILTER431_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER431!=null?FILTER431.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1966:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH432=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5999); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH432_tree = (CommonTree)adaptor.dupNode(FOREACH432);


                    adaptor.addChild(root_0, FOREACH432_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH432!=null?FOREACH432.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1967:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES433=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid6009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES433_tree = (CommonTree)adaptor.dupNode(MATCHES433);


                    adaptor.addChild(root_0, MATCHES433_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES433!=null?MATCHES433.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1968:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER434=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid6019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER434_tree = (CommonTree)adaptor.dupNode(ORDER434);


                    adaptor.addChild(root_0, ORDER434_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER434!=null?ORDER434.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1969:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT435=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid6029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT435_tree = (CommonTree)adaptor.dupNode(DISTINCT435);


                    adaptor.addChild(root_0, DISTINCT435_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT435!=null?DISTINCT435.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1970:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP436=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid6039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP436_tree = (CommonTree)adaptor.dupNode(COGROUP436);


                    adaptor.addChild(root_0, COGROUP436_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP436!=null?COGROUP436.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1971:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE437=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid6049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE437_tree = (CommonTree)adaptor.dupNode(CUBE437);


                    adaptor.addChild(root_0, CUBE437_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CUBE437!=null?CUBE437.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1972:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP438=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid6059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP438_tree = (CommonTree)adaptor.dupNode(ROLLUP438);


                    adaptor.addChild(root_0, ROLLUP438_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ROLLUP438!=null?ROLLUP438.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1973:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT439=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid6069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT439_tree = (CommonTree)adaptor.dupNode(PIVOT439);


                    adaptor.addChild(root_0, PIVOT439_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PIVOT439!=null?PIVOT439.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1974:7: CHUNKSIZE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHUNKSIZE440=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_eid6079); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHUNKSIZE440_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE440);


                    adaptor.addChild(root_0, CHUNKSIZE440_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHUNKSIZE440!=null?CHUNKSIZE440.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1975:7: RATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RATE441=(CommonTree)match(input,RATE,FOLLOW_RATE_in_eid6089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RATE441_tree = (CommonTree)adaptor.dupNode(RATE441);


                    adaptor.addChild(root_0, RATE441_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RATE441!=null?RATE441.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1976:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN442=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid6099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN442_tree = (CommonTree)adaptor.dupNode(JOIN442);


                    adaptor.addChild(root_0, JOIN442_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN442!=null?JOIN442.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1977:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS443=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid6109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS443_tree = (CommonTree)adaptor.dupNode(CROSS443);


                    adaptor.addChild(root_0, CROSS443_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS443!=null?CROSS443.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1978:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION444=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid6119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION444_tree = (CommonTree)adaptor.dupNode(UNION444);


                    adaptor.addChild(root_0, UNION444_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION444!=null?UNION444.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1979:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT445=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid6129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT445_tree = (CommonTree)adaptor.dupNode(SPLIT445);


                    adaptor.addChild(root_0, SPLIT445_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT445!=null?SPLIT445.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1980:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO446=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid6139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO446_tree = (CommonTree)adaptor.dupNode(INTO446);


                    adaptor.addChild(root_0, INTO446_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO446!=null?INTO446.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1981:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF447=(CommonTree)match(input,IF,FOLLOW_IF_in_eid6149); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF447_tree = (CommonTree)adaptor.dupNode(IF447);


                    adaptor.addChild(root_0, IF447_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF447!=null?IF447.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1982:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL448=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid6159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL448_tree = (CommonTree)adaptor.dupNode(ALL448);


                    adaptor.addChild(root_0, ALL448_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL448!=null?ALL448.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS449=(CommonTree)match(input,AS,FOLLOW_AS_in_eid6169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS449_tree = (CommonTree)adaptor.dupNode(AS449);


                    adaptor.addChild(root_0, AS449_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS449!=null?AS449.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1984:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY450=(CommonTree)match(input,BY,FOLLOW_BY_in_eid6179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY450_tree = (CommonTree)adaptor.dupNode(BY450);


                    adaptor.addChild(root_0, BY450_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY450!=null?BY450.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1985:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING451=(CommonTree)match(input,USING,FOLLOW_USING_in_eid6189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING451_tree = (CommonTree)adaptor.dupNode(USING451);


                    adaptor.addChild(root_0, USING451_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING451!=null?USING451.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1986:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER452=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid6199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER452_tree = (CommonTree)adaptor.dupNode(INNER452);


                    adaptor.addChild(root_0, INNER452_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER452!=null?INNER452.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1987:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER453=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid6209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER453_tree = (CommonTree)adaptor.dupNode(OUTER453);


                    adaptor.addChild(root_0, OUTER453_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER453!=null?OUTER453.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1988:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL454=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid6219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL454_tree = (CommonTree)adaptor.dupNode(PARALLEL454);


                    adaptor.addChild(root_0, PARALLEL454_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL454!=null?PARALLEL454.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1989:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION455=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid6229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION455_tree = (CommonTree)adaptor.dupNode(PARTITION455);


                    adaptor.addChild(root_0, PARTITION455_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION455!=null?PARTITION455.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1990:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP456=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid6239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP456_tree = (CommonTree)adaptor.dupNode(GROUP456);


                    adaptor.addChild(root_0, GROUP456_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP456!=null?GROUP456.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1991:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND457=(CommonTree)match(input,AND,FOLLOW_AND_in_eid6249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND457_tree = (CommonTree)adaptor.dupNode(AND457);


                    adaptor.addChild(root_0, AND457_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND457!=null?AND457.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1992:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR458=(CommonTree)match(input,OR,FOLLOW_OR_in_eid6259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR458_tree = (CommonTree)adaptor.dupNode(OR458);


                    adaptor.addChild(root_0, OR458_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR458!=null?OR458.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1993:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT459=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid6269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT459_tree = (CommonTree)adaptor.dupNode(NOT459);


                    adaptor.addChild(root_0, NOT459_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT459!=null?NOT459.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1994:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE460=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid6279); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE460_tree = (CommonTree)adaptor.dupNode(GENERATE460);


                    adaptor.addChild(root_0, GENERATE460_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE460!=null?GENERATE460.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1995:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN461=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid6289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN461_tree = (CommonTree)adaptor.dupNode(FLATTEN461);


                    adaptor.addChild(root_0, FLATTEN461_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN461!=null?FLATTEN461.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1996:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL462=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid6299); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL462_tree = (CommonTree)adaptor.dupNode(EVAL462);


                    adaptor.addChild(root_0, EVAL462_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL462!=null?EVAL462.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1997:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC463=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid6309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC463_tree = (CommonTree)adaptor.dupNode(ASC463);


                    adaptor.addChild(root_0, ASC463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC463!=null?ASC463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1998:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC464=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid6319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC464_tree = (CommonTree)adaptor.dupNode(DESC464);


                    adaptor.addChild(root_0, DESC464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC464!=null?DESC464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1999:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN465=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid6329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN465_tree = (CommonTree)adaptor.dupNode(BOOLEAN465);


                    adaptor.addChild(root_0, BOOLEAN465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN465!=null?BOOLEAN465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2000:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT466=(CommonTree)match(input,INT,FOLLOW_INT_in_eid6339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT466_tree = (CommonTree)adaptor.dupNode(INT466);


                    adaptor.addChild(root_0, INT466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT466!=null?INT466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2001:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG467=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid6349); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG467_tree = (CommonTree)adaptor.dupNode(LONG467);


                    adaptor.addChild(root_0, LONG467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG467!=null?LONG467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2002:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT468=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid6359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT468_tree = (CommonTree)adaptor.dupNode(FLOAT468);


                    adaptor.addChild(root_0, FLOAT468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT468!=null?FLOAT468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2003:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE469=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid6369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE469_tree = (CommonTree)adaptor.dupNode(DOUBLE469);


                    adaptor.addChild(root_0, DOUBLE469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE469!=null?DOUBLE469.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2004:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER470=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid6379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER470_tree = (CommonTree)adaptor.dupNode(BIGINTEGER470);


                    adaptor.addChild(root_0, BIGINTEGER470_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGINTEGER470!=null?BIGINTEGER470.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2005:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL471=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid6389); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL471_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL471);


                    adaptor.addChild(root_0, BIGDECIMAL471_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGDECIMAL471!=null?BIGDECIMAL471.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2006:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME472=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid6399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME472_tree = (CommonTree)adaptor.dupNode(DATETIME472);


                    adaptor.addChild(root_0, DATETIME472_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DATETIME472!=null?DATETIME472.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2007:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY473=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid6409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY473_tree = (CommonTree)adaptor.dupNode(CHARARRAY473);


                    adaptor.addChild(root_0, CHARARRAY473_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY473!=null?CHARARRAY473.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2008:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY474=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid6419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY474_tree = (CommonTree)adaptor.dupNode(BYTEARRAY474);


                    adaptor.addChild(root_0, BYTEARRAY474_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY474!=null?BYTEARRAY474.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2009:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG475=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid6429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG475_tree = (CommonTree)adaptor.dupNode(BAG475);


                    adaptor.addChild(root_0, BAG475_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG475!=null?BAG475.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2010:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE476=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid6439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE476_tree = (CommonTree)adaptor.dupNode(TUPLE476);


                    adaptor.addChild(root_0, TUPLE476_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE476!=null?TUPLE476.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2011:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP477=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid6449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP477_tree = (CommonTree)adaptor.dupNode(MAP477);


                    adaptor.addChild(root_0, MAP477_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP477!=null?MAP477.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2012:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS478=(CommonTree)match(input,IS,FOLLOW_IS_in_eid6459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS478_tree = (CommonTree)adaptor.dupNode(IS478);


                    adaptor.addChild(root_0, IS478_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS478!=null?IS478.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2013:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL479=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid6469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL479_tree = (CommonTree)adaptor.dupNode(NULL479);


                    adaptor.addChild(root_0, NULL479_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL479!=null?NULL479.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2014:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE480=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid6479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE480_tree = (CommonTree)adaptor.dupNode(TRUE480);


                    adaptor.addChild(root_0, TRUE480_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE480!=null?TRUE480.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2015:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE481=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid6489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE481_tree = (CommonTree)adaptor.dupNode(FALSE481);


                    adaptor.addChild(root_0, FALSE481_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE481!=null?FALSE481.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2016:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM482=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid6499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM482_tree = (CommonTree)adaptor.dupNode(STREAM482);


                    adaptor.addChild(root_0, STREAM482_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM482!=null?STREAM482.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2017:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH483=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid6509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH483_tree = (CommonTree)adaptor.dupNode(THROUGH483);


                    adaptor.addChild(root_0, THROUGH483_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH483!=null?THROUGH483.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2018:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE484=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid6519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE484_tree = (CommonTree)adaptor.dupNode(STORE484);


                    adaptor.addChild(root_0, STORE484_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE484!=null?STORE484.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2019:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE485=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid6529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE485_tree = (CommonTree)adaptor.dupNode(MAPREDUCE485);


                    adaptor.addChild(root_0, MAPREDUCE485_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE485!=null?MAPREDUCE485.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2020:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP486=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid6539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP486_tree = (CommonTree)adaptor.dupNode(SHIP486);


                    adaptor.addChild(root_0, SHIP486_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP486!=null?SHIP486.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2021:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE487=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid6549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE487_tree = (CommonTree)adaptor.dupNode(CACHE487);


                    adaptor.addChild(root_0, CACHE487_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE487!=null?CACHE487.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2022:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT488=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid6559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT488_tree = (CommonTree)adaptor.dupNode(INPUT488);


                    adaptor.addChild(root_0, INPUT488_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT488!=null?INPUT488.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2023:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT489=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid6569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT489_tree = (CommonTree)adaptor.dupNode(OUTPUT489);


                    adaptor.addChild(root_0, OUTPUT489_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT489!=null?OUTPUT489.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2024:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR490=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid6579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR490_tree = (CommonTree)adaptor.dupNode(STDERROR490);


                    adaptor.addChild(root_0, STDERROR490_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR490!=null?STDERROR490.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2025:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN491=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid6589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN491_tree = (CommonTree)adaptor.dupNode(STDIN491);


                    adaptor.addChild(root_0, STDIN491_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN491!=null?STDIN491.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2026:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT492=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT492_tree = (CommonTree)adaptor.dupNode(STDOUT492);


                    adaptor.addChild(root_0, STDOUT492_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT492!=null?STDOUT492.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2027:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT493=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT493_tree = (CommonTree)adaptor.dupNode(LIMIT493);


                    adaptor.addChild(root_0, LIMIT493_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT493!=null?LIMIT493.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2028:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE494=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE494_tree = (CommonTree)adaptor.dupNode(SAMPLE494);


                    adaptor.addChild(root_0, SAMPLE494_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE494!=null?SAMPLE494.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2029:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT495=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT495_tree = (CommonTree)adaptor.dupNode(LEFT495);


                    adaptor.addChild(root_0, LEFT495_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT495!=null?LEFT495.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2030:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT496=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT496_tree = (CommonTree)adaptor.dupNode(RIGHT496);


                    adaptor.addChild(root_0, RIGHT496_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT496!=null?RIGHT496.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2031:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL497=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL497_tree = (CommonTree)adaptor.dupNode(FULL497);


                    adaptor.addChild(root_0, FULL497_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL497!=null?FULL497.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2032:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER498=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6659); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER498_tree = (CommonTree)adaptor.dupNode(IDENTIFIER498);


                    adaptor.addChild(root_0, IDENTIFIER498_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER498!=null?IDENTIFIER498.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2033:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG499=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG499_tree = (CommonTree)adaptor.dupNode(TOBAG499);


                    adaptor.addChild(root_0, TOBAG499_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2034:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP500=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP500_tree = (CommonTree)adaptor.dupNode(TOMAP500);


                    adaptor.addChild(root_0, TOMAP500_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2035:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE501=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE501_tree = (CommonTree)adaptor.dupNode(TOTUPLE501);


                    adaptor.addChild(root_0, TOTUPLE501_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 77 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2036:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT502=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid6699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT502_tree = (CommonTree)adaptor.dupNode(ASSERT502);


                    adaptor.addChild(root_0, ASSERT502_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "ASSERT"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES509=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq503 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne504 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt505 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte506 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt507 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte508 =null;


        CommonTree STR_OP_MATCHES509_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt133=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt133=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt133=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt133=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt133=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt133=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt133=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt133=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }

            switch (alt133) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6712);
                    rel_op_eq503=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq503.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2041:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6723);
                    rel_op_ne504=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne504.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2042:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6734);
                    rel_op_gt505=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt505.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2043:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6745);
                    rel_op_gte506=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte506.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2044:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6756);
                    rel_op_lt507=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt507.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2045:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6767);
                    rel_op_lte508=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte508.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2046:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES509=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES509_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES509);


                    adaptor.addChild(root_0, STR_OP_MATCHES509_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2049:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set510=null;

        CommonTree set510_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2049:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set510=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set510_tree = (CommonTree)adaptor.dupNode(set510);


                adaptor.addChild(root_0, set510_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2052:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set511=null;

        CommonTree set511_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2052:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set511=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set511_tree = (CommonTree)adaptor.dupNode(set511);


                adaptor.addChild(root_0, set511_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2055:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set512=null;

        CommonTree set512_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2055:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set512=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set512_tree = (CommonTree)adaptor.dupNode(set512);


                adaptor.addChild(root_0, set512_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2058:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set513=null;

        CommonTree set513_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2058:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set513=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set513_tree = (CommonTree)adaptor.dupNode(set513);


                adaptor.addChild(root_0, set513_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2061:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set514=null;

        CommonTree set514_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2061:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set514=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set514_tree = (CommonTree)adaptor.dupNode(set514);


                adaptor.addChild(root_0, set514_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2064:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set515=null;

        CommonTree set515_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2064:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set515=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set515_tree = (CommonTree)adaptor.dupNode(set515);


                adaptor.addChild(root_0, set515_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2067:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ516=null;
        CommonTree STR_OP_NE517=null;
        CommonTree STR_OP_GT518=null;
        CommonTree STR_OP_LT519=null;
        CommonTree STR_OP_GTE520=null;
        CommonTree STR_OP_LTE521=null;
        CommonTree STR_OP_MATCHES522=null;

        CommonTree STR_OP_EQ516_tree=null;
        CommonTree STR_OP_NE517_tree=null;
        CommonTree STR_OP_GT518_tree=null;
        CommonTree STR_OP_LT519_tree=null;
        CommonTree STR_OP_GTE520_tree=null;
        CommonTree STR_OP_LTE521_tree=null;
        CommonTree STR_OP_MATCHES522_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2068:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt134=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt134=1;
                }
                break;
            case STR_OP_NE:
                {
                alt134=2;
                }
                break;
            case STR_OP_GT:
                {
                alt134=3;
                }
                break;
            case STR_OP_LT:
                {
                alt134=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt134=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt134=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt134=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;

            }

            switch (alt134) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2068:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ516=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ516_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ516);


                    adaptor.addChild(root_0, STR_OP_EQ516_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ516!=null?STR_OP_EQ516.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2069:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE517=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE517_tree = (CommonTree)adaptor.dupNode(STR_OP_NE517);


                    adaptor.addChild(root_0, STR_OP_NE517_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE517!=null?STR_OP_NE517.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2070:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT518=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT518_tree = (CommonTree)adaptor.dupNode(STR_OP_GT518);


                    adaptor.addChild(root_0, STR_OP_GT518_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT518!=null?STR_OP_GT518.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2071:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT519=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT519_tree = (CommonTree)adaptor.dupNode(STR_OP_LT519);


                    adaptor.addChild(root_0, STR_OP_LT519_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT519!=null?STR_OP_LT519.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2072:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE520=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE520_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE520);


                    adaptor.addChild(root_0, STR_OP_GTE520_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE520!=null?STR_OP_GTE520.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2073:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE521=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE521_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE521);


                    adaptor.addChild(root_0, STR_OP_LTE521_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE521!=null?STR_OP_LTE521.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:2074:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES522=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES522_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES522);


                    adaptor.addChild(root_0, STR_OP_MATCHES522_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES522!=null?STR_OP_MATCHES522.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred148_LogicalPlanGenerator
    public final void synpred148_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred148_LogicalPlanGenerator3746); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_LogicalPlanGenerator

    // $ANTLR start synpred149_LogicalPlanGenerator
    public final void synpred149_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1196:4: ( LONGINTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1196:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred149_LogicalPlanGenerator3756); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_LogicalPlanGenerator

    // $ANTLR start synpred150_LogicalPlanGenerator
    public final void synpred150_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:20: ( DOUBLENUMBER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred150_LogicalPlanGenerator3808); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred150_LogicalPlanGenerator

    // $ANTLR start synpred180_LogicalPlanGenerator
    public final void synpred180_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1404:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred180_LogicalPlanGenerator4337);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1409:66: ( OUTER )?
        int alt149=2;
        int LA149_0 = input.LA(1);

        if ( (LA149_0==OUTER) ) {
            alt149=1;
        }
        switch (alt149) {
            case 1 :
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1409:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred180_LogicalPlanGenerator4385); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred180_LogicalPlanGenerator4388);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred180_LogicalPlanGenerator

    // $ANTLR start synpred197_LogicalPlanGenerator
    public final void synpred197_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:31: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred197_LogicalPlanGenerator4960); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred197_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred150_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred197_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred197_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred180_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred180_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query89 = new BitSet(new long[]{0x0000000000000408L,0x0100100000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement169 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement171 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_USING_in_register_statement174 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement176 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement178 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement203 = new BitSet(new long[]{0x009080044C800400L,0x6008040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_op_clause_in_general_statement214 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause235 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause588 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_define_clause609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd642 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd647 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd652 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd656 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd660 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list702 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause749 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause881 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause919 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause994 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause996 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause998 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause1002 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1071 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x0800100000010000L});
    public static final BitSet FOLLOW_type_in_field_def1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1098 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_simple_type_in_type1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1327 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1329 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1386 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1404 = new BitSet(new long[]{0x0000000000000008L,0x0000020000040000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1436 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1450 = new BitSet(new long[]{0xEEF3A0455CEF5F50L,0xFD2C6827B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1456 = new BitSet(new long[]{0xEEF3A0455CEF5F50L,0xFD2C6827B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_eid_in_func_name1472 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1501 = new BitSet(new long[]{0x0000000000000002L,0x0000020000040000L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511 = new BitSet(new long[]{0x0000000000000002L,0x0000020000040000L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_chunksize_clause1563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_chunksize_clause1565 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RATE_in_rate_clause1587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_rate_clause1589 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1625 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1644 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1675 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1700 = new BitSet(new long[]{0x0000000008000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1728 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1732 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1746 = new BitSet(new long[]{0x0000000000400008L,0x0000002000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_chunksize_clause_in_cube_rollup_list1760 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rate_clause_in_cube_rollup_list1764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1793 = new BitSet(new long[]{0x028820A80800A002L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1869 = new BitSet(new long[]{0x029080044C800488L,0x6008060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_type_in_group_clause1874 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1881 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1896 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1898 = new BitSet(new long[]{0x029080044C800488L,0x6008060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_type_in_group_clause1903 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1910 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1951 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1955 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1979 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ANY_in_group_item2003 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_INNER_in_group_item2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op2106 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item2134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item2144 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item2152 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item2160 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2197 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause2199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2219 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2221 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause2257 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause2259 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_assert_clause2261 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause2264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2314 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_filter_clause2316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2346 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_cond2353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2368 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2374 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_cond2381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2419 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_NOT_in_cond2422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond2437 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2443 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2450 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond2465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2471 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond2493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2499 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2521 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2527 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2534 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2555 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2583 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2611 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2618 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2661 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2696 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2702 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2767 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2771 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2795 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2799 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2803 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2807 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_expr_in_real_arg2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2880 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2886 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2893 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2914 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2921 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2936 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2942 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2949 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2964 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2970 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2977 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2998 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr3005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr3042 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr3048 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr3063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr3065 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr3071 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr3087 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr3093 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast3174 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast3203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr3230 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr3240 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr3254 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj3354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj3358 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range3447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range3454 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3459 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range3466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj3492 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3496 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj3502 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr3524 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr3531 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr3538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr3567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr3575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr3612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3618 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3666 = new BitSet(new long[]{0x1000000000000048L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_THEN_in_case_cond3694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3698 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3742 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3804 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3818 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3866 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3868 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3896 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3900 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3929 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3956 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3982 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_rank_col4000 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause4039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause4041 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause4043 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause4045 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause4072 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause4099 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_order_col4125 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col4143 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause4172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause4174 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause4176 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause4199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause4201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause4223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause4225 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause4227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list4255 = new BitSet(new long[]{0x029080044C800482L,0x6008040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_JOIN_in_join_clause4294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause4296 = new BitSet(new long[]{0x0000000000000008L,0x0000020400000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause4298 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause4301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4337 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause4341 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause4360 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause4379 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause4385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4398 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item4411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item4413 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item4415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause4442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause4446 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause4508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause4512 = new BitSet(new long[]{0x029080044C800480L,0x6008040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_rel_list_in_union_clause4519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause4555 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause4557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4559 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan4597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan4608 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk4619 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4646 = new BitSet(new long[]{0x0010800404000000L,0x0000000020000400L,0x0002000000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command4648 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4668 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_nested_command4670 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op4692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4777 = new BitSet(new long[]{0x0280002008000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4792 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4847 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_nested_filter4849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4883 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4885 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4887 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4889 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4921 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4954 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4956 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4960 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross5003 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross5005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach5037 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach5039 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach5041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause5070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause5074 = new BitSet(new long[]{0x028920A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list5177 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause5202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause5204 = new BitSet(new long[]{0x0200100000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause5208 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause5231 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause5273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause5301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause5303 = new BitSet(new long[]{0x0000000000000000L,0x2000020000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause5305 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause5316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause5325 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause5332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause5352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause5360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause5376 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause5379 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch5408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch5410 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_split_branch5412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise5446 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise5448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref5476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref5493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref5503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar5682 = new BitSet(new long[]{0x000800800000A000L,0x0000000000002001L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar5751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map5797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map5801 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue5830 = new BitSet(new long[]{0x000820800000A000L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_literal_in_keyvalue5832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag5874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag5878 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple5914 = new BitSet(new long[]{0x000820800000A008L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_rel_str_op_in_eid5939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid6009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid6059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_eid6079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RATE_in_eid6089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid6109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid6119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid6129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid6149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid6159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid6199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid6209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid6219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid6239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid6249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid6259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid6269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid6299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid6309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid6319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid6329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid6369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid6419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid6429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid6449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid6459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid6469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid6479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid6489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid6499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid6519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid6549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid6599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid6609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid6629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid6639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid6649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid6659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid6669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid6699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred148_LogicalPlanGenerator3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred149_LogicalPlanGenerator3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred150_LogicalPlanGenerator3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred180_LogicalPlanGenerator4337 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_synpred180_LogicalPlanGenerator4339 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred180_LogicalPlanGenerator4385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred180_LogicalPlanGenerator4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred197_LogicalPlanGenerator4960 = new BitSet(new long[]{0x0000000000000002L});

}