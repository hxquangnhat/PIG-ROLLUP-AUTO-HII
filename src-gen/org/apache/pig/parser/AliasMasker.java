// $ANTLR 3.4 /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g 2014-12-22 11:35:36

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AliasMasker extends TreeParser {
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


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	}
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps;
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias )
            ? alias
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:82:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query82);
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


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement | assert_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;

        AliasMasker.assert_statement_return assert_statement6 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement | assert_statement )
            int alt2=4;
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:85:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement94);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:86:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:88:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement136);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


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
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:91:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause7 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:91:17: ( split_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:91:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement145);
            split_clause7=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause7.getTree());


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


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:94:1: assert_statement : assert_clause ;
    public final AliasMasker.assert_statement_return assert_statement() throws RecognitionException {
        AliasMasker.assert_statement_return retval = new AliasMasker.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.assert_clause_return assert_clause8 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:94:17: ( assert_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:94:19: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement153);
            assert_clause8=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause8.getTree());


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


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:97:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:97:19: ( realias_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:97:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement162);
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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:101:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT10=null;
        AliasMasker.alias_return alias11 =null;

        AliasMasker.op_clause_return op_clause12 =null;

        AliasMasker.parallel_clause_return parallel_clause13 =null;


        CommonTree STATEMENT10_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:102:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:102:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT10=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT10_tree = (CommonTree)adaptor.dupNode(STATEMENT10);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:102:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:102:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement182);
                    alias11=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement195);
            op_clause12=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause12.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:103:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:103:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement197);
                    parallel_clause13=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause13.getTree());


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
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:106:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS14=null;
        CommonTree IDENTIFIER16=null;
        AliasMasker.alias_return alias15 =null;


        CommonTree REALIAS14_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:106:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:106:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS14=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS14_tree = (CommonTree)adaptor.dupNode(REALIAS14);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause212);
            alias15=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias15.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_1, IDENTIFIER16_tree);
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
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:109:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL17=null;
        CommonTree INTEGER18=null;

        CommonTree PARALLEL17_tree=null;
        CommonTree INTEGER18_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:110:5: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:110:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL17=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL17_tree = (CommonTree)adaptor.dupNode(PARALLEL17);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER18=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER18_tree = (CommonTree)adaptor.dupNode(INTEGER18);


            adaptor.addChild(root_1, INTEGER18_tree);
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
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:113:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER19=null;

        CommonTree IDENTIFIER19_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:114:5: ( IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:114:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER19=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER19_tree = (CommonTree)adaptor.dupNode(IDENTIFIER19);


            adaptor.addChild(root_0, IDENTIFIER19_tree);
            }


            if ( state.backtracking==0 ) {
                        aliasSeen.add((IDENTIFIER19!=null?IDENTIFIER19.getText():null));
                        IDENTIFIER19.getToken().setText(getMask((IDENTIFIER19!=null?IDENTIFIER19.getText():null)));
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
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:121:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause20 =null;

        AliasMasker.load_clause_return load_clause21 =null;

        AliasMasker.group_clause_return group_clause22 =null;

        AliasMasker.store_clause_return store_clause23 =null;

        AliasMasker.filter_clause_return filter_clause24 =null;

        AliasMasker.distinct_clause_return distinct_clause25 =null;

        AliasMasker.limit_clause_return limit_clause26 =null;

        AliasMasker.sample_clause_return sample_clause27 =null;

        AliasMasker.order_clause_return order_clause28 =null;

        AliasMasker.rank_clause_return rank_clause29 =null;

        AliasMasker.cross_clause_return cross_clause30 =null;

        AliasMasker.join_clause_return join_clause31 =null;

        AliasMasker.union_clause_return union_clause32 =null;

        AliasMasker.stream_clause_return stream_clause33 =null;

        AliasMasker.mr_clause_return mr_clause34 =null;

        AliasMasker.split_clause_return split_clause35 =null;

        AliasMasker.foreach_clause_return foreach_clause36 =null;

        AliasMasker.cube_clause_return cube_clause37 =null;

        AliasMasker.assert_clause_return assert_clause38 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:121:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt5=19;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case RANK:
                {
                alt5=10;
                }
                break;
            case CROSS:
                {
                alt5=11;
                }
                break;
            case JOIN:
                {
                alt5=12;
                }
                break;
            case UNION:
                {
                alt5=13;
                }
                break;
            case STREAM:
                {
                alt5=14;
                }
                break;
            case MAPREDUCE:
                {
                alt5=15;
                }
                break;
            case SPLIT:
                {
                alt5=16;
                }
                break;
            case FOREACH:
                {
                alt5=17;
                }
                break;
            case CUBE:
                {
                alt5=18;
                }
                break;
            case ASSERT:
                {
                alt5=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:121:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause266);
                    define_clause20=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:122:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause280);
                    load_clause21=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:123:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause294);
                    group_clause22=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:124:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause308);
                    store_clause23=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:125:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause322);
                    filter_clause24=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:126:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause336);
                    distinct_clause25=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:127:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause350);
                    limit_clause26=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:128:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause364);
                    sample_clause27=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:129:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause378);
                    order_clause28=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:130:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause392);
                    rank_clause29=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:131:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause406);
                    cross_clause30=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:132:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause420);
                    join_clause31=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:133:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause434);
                    union_clause32=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:134:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause448);
                    stream_clause33=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:135:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause462);
                    mr_clause34=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:136:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause476);
                    split_clause35=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:137:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause490);
                    foreach_clause36=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:138:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause504);
                    cube_clause37=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:139:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause518);
                    assert_clause38=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause38.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:142:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE39=null;
        CommonTree IDENTIFIER40=null;
        AliasMasker.cmd_return cmd41 =null;

        AliasMasker.func_clause_return func_clause42 =null;


        CommonTree DEFINE39_tree=null;
        CommonTree IDENTIFIER40_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:143:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:143:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE39=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE39_tree = (CommonTree)adaptor.dupNode(DEFINE39);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER40=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause535); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER40_tree = (CommonTree)adaptor.dupNode(IDENTIFIER40);


            adaptor.addChild(root_1, IDENTIFIER40_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:143:29: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:143:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause540);
                    cmd41=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:143:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause544);
                    func_clause42=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause42.getTree());


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
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:146:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND43=null;
        AliasMasker.ship_clause_return ship_clause44 =null;

        AliasMasker.cache_clause_return cache_clause45 =null;

        AliasMasker.input_clause_return input_clause46 =null;

        AliasMasker.output_clause_return output_clause47 =null;

        AliasMasker.error_clause_return error_clause48 =null;


        CommonTree EXECCOMMAND43_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:147:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:147:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND43=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND43_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND43);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd575);
                	    ship_clause44=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause44.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd579);
                	    cache_clause45=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause45.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd583);
                	    input_clause46=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause46.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd587);
                	    output_clause47=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause47.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:148:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd591);
                	    error_clause48=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause48.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
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
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:151:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP49=null;
        AliasMasker.path_list_return path_list50 =null;


        CommonTree SHIP49_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:152:5: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:152:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP49=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP49_tree = (CommonTree)adaptor.dupNode(SHIP49);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP49_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:152:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:152:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause613);
                        path_list50=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list50.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:155:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING51=null;

        CommonTree QUOTEDSTRING51_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:156:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:156:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING51=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list629); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING51_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING51);


            	    adaptor.addChild(root_0, QUOTEDSTRING51_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:159:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE52=null;
        AliasMasker.path_list_return path_list53 =null;


        CommonTree CACHE52_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:160:5: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:160:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE52=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE52_tree = (CommonTree)adaptor.dupNode(CACHE52);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE52_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause647);
            path_list53=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list53.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:163:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT54=null;
        AliasMasker.stream_cmd_return stream_cmd55 =null;


        CommonTree INPUT54_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:164:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:164:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT54=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT54_tree = (CommonTree)adaptor.dupNode(INPUT54);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT54_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:164:16: ( stream_cmd )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:164:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause666);
            	    stream_cmd55=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd55.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:167:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN56=null;
        CommonTree STDOUT58=null;
        CommonTree QUOTEDSTRING60=null;
        AliasMasker.func_clause_return func_clause57 =null;

        AliasMasker.func_clause_return func_clause59 =null;

        AliasMasker.func_clause_return func_clause61 =null;


        CommonTree STDIN56_tree=null;
        CommonTree STDOUT58_tree=null;
        CommonTree QUOTEDSTRING60_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:168:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:168:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN56=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN56_tree = (CommonTree)adaptor.dupNode(STDIN56);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN56_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:168:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:168:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd686);
                                func_clause57=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause57.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:169:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT58=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT58_tree = (CommonTree)adaptor.dupNode(STDOUT58);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT58_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:169:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:169:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd701);
                                func_clause59=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause59.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:170:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING60_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:170:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:170:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd716);
                                func_clause61=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause61.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:173:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT62=null;
        AliasMasker.stream_cmd_return stream_cmd63 =null;


        CommonTree OUTPUT62_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:174:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:174:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT62=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause734); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT62_tree = (CommonTree)adaptor.dupNode(OUTPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:174:17: ( stream_cmd )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:174:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause736);
            	    stream_cmd63=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd63.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:177:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR64=null;
        CommonTree QUOTEDSTRING65=null;
        CommonTree INTEGER66=null;

        CommonTree STDERROR64_tree=null;
        CommonTree QUOTEDSTRING65_tree=null;
        CommonTree INTEGER66_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR64=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR64_tree = (CommonTree)adaptor.dupNode(STDERROR64);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR64_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING65=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause758); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING65_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING65);


                        adaptor.addChild(root_1, QUOTEDSTRING65_tree);
                        }


                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:178:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER66=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause760); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER66_tree = (CommonTree)adaptor.dupNode(INTEGER66);


                                adaptor.addChild(root_1, INTEGER66_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:181:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD67=null;
        AliasMasker.filename_return filename68 =null;

        AliasMasker.func_clause_return func_clause69 =null;

        AliasMasker.as_clause_return as_clause70 =null;


        CommonTree LOAD67_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD67=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause781); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD67_tree = (CommonTree)adaptor.dupNode(LOAD67);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause783);
            filename68=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename68.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause785);
                    func_clause69=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause69.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:182:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause788);
                    as_clause70=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause70.getTree());


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
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:185:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING71=null;

        CommonTree QUOTEDSTRING71_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:186:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:186:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING71=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING71_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING71);


            adaptor.addChild(root_0, QUOTEDSTRING71_tree);
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
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:189:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS72=null;
        AliasMasker.field_def_list_return field_def_list73 =null;


        CommonTree AS72_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:196:5: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:196:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS72=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS72_tree = (CommonTree)adaptor.dupNode(AS72);


            root_1 = (CommonTree)adaptor.becomeRoot(AS72_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause831);
            field_def_list73=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list73.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:199:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF74=null;
        CommonTree IDENTIFIER75=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77=null;
        AliasMasker.type_return type76 =null;

        AliasMasker.type_return type78 =null;


        CommonTree FIELD_DEF74_tree=null;
        CommonTree IDENTIFIER75_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:200:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:200:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF74=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER75=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (CommonTree)adaptor.dupNode(IDENTIFIER75);


                    adaptor.addChild(root_1, IDENTIFIER75_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:200:31: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:200:31: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def852);
                            type76=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type76.getTree());


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
                    	if (inAsOrGenClause) {
                    		if (aliasSeen.contains((IDENTIFIER75!=null?IDENTIFIER75.getText():null))) {
                    			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)),
                    				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER75!=null?IDENTIFIER75.getText():null));
                    		}
                    	}
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:208:7: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER77=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER77_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER77);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def869);
                    type78=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type78.getTree());


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
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:211:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def79 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:212:5: ( ( field_def )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= FIELD_DEF && LA22_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:212:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list884);
            	    field_def79=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def79.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type80 =null;

        AliasMasker.tuple_type_return tuple_type81 =null;

        AliasMasker.bag_type_return bag_type82 =null;

        AliasMasker.map_type_return map_type83 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
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
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type894);
                    simple_type80=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type80.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type898);
                    tuple_type81=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type81.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type902);
                    bag_type82=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type82.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:215:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type906);
                    map_type83=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type83.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:218:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set84=null;

        CommonTree set84_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:219:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set84=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMAL||input.LA(1)==BIGINTEGER||input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set84_tree = (CommonTree)adaptor.dupNode(set84);


                adaptor.addChild(root_0, set84_tree);
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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:222:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE85=null;
        AliasMasker.field_def_list_return field_def_list86 =null;


        CommonTree TUPLE_TYPE85_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:223:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:223:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE85=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type970); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE85_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE85);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE85_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:223:21: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= FIELD_DEF && LA24_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:223:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type972);
                        field_def_list86=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list86.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:226:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE87=null;
        CommonTree IDENTIFIER88=null;
        AliasMasker.tuple_type_return tuple_type89 =null;


        CommonTree BAG_TYPE87_tree=null;
        CommonTree IDENTIFIER88_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE87=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type990); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE87_tree = (CommonTree)adaptor.dupNode(BAG_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:19: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER88=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type992); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER88_tree = (CommonTree)adaptor.dupNode(IDENTIFIER88);


                        adaptor.addChild(root_1, IDENTIFIER88_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:31: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:227:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type995);
                        tuple_type89=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type89.getTree());


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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:230:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE90=null;
        AliasMasker.type_return type91 =null;


        CommonTree MAP_TYPE90_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:230:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:230:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE90=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1009); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE90_tree = (CommonTree)adaptor.dupNode(MAP_TYPE90);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE90_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:230:24: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BIGDECIMAL||LA27_0==BIGINTEGER||LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DATETIME||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:230:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1011);
                        type91=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type91.getTree());


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
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:233:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF92=null;
        CommonTree FUNC94=null;
        AliasMasker.func_name_return func_name93 =null;

        AliasMasker.func_name_return func_name95 =null;

        AliasMasker.func_args_return func_args96 =null;


        CommonTree FUNC_REF92_tree=null;
        CommonTree FUNC94_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:234:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:234:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF92=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF92_tree = (CommonTree)adaptor.dupNode(FUNC_REF92);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1031);
                    func_name93=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name93.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:235:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC94=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC94_tree = (CommonTree)adaptor.dupNode(FUNC94);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1045);
                    func_name95=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name95.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:235:25: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:235:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1047);
                            func_args96=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args96.getTree());


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
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:238:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set98=null;
        AliasMasker.eid_return eid97 =null;

        AliasMasker.eid_return eid99 =null;


        CommonTree set98_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:239:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:239:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1063);
            eid97=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid97.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:239:11: ( ( PERIOD | DOLLAR ) eid )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOLLAR||LA30_0==PERIOD) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:239:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set98=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set98_tree = (CommonTree)adaptor.dupNode(set98);


            	        adaptor.addChild(root_0, set98_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1077);
            	    eid99=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid99.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
                }
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
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:242:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING100=null;

        CommonTree QUOTEDSTRING100_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:243:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==QUOTEDSTRING) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:243:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING100=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1093); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING100_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING100);


            	    adaptor.addChild(root_0, QUOTEDSTRING100_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:246:1: cube_clause : ^( CUBE cube_item ) ;
    public final AliasMasker.cube_clause_return cube_clause() throws RecognitionException {
        AliasMasker.cube_clause_return retval = new AliasMasker.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE101=null;
        AliasMasker.cube_item_return cube_item102 =null;


        CommonTree CUBE101_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:247:5: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:247:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE101=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE101_tree = (CommonTree)adaptor.dupNode(CUBE101);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE101_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1111);
            cube_item102=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item102.getTree());


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
    // $ANTLR end "cube_clause"


    public static class h2irg_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "h2irg_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:250:1: h2irg_clause : ( pivot_clause | autopivot_clause );
    public final AliasMasker.h2irg_clause_return h2irg_clause() throws RecognitionException {
        AliasMasker.h2irg_clause_return retval = new AliasMasker.h2irg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.pivot_clause_return pivot_clause103 =null;

        AliasMasker.autopivot_clause_return autopivot_clause104 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:251:5: ( pivot_clause | autopivot_clause )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==PIVOT) ) {
                alt32=1;
            }
            else if ( (LA32_0==CHUNKSIZE) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:251:7: pivot_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_pivot_clause_in_h2irg_clause1126);
                    pivot_clause103=pivot_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, pivot_clause103.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:251:22: autopivot_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_autopivot_clause_in_h2irg_clause1130);
                    autopivot_clause104=autopivot_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, autopivot_clause104.getTree());


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
    // $ANTLR end "h2irg_clause"


    public static class pivot_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:254:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AliasMasker.pivot_clause_return pivot_clause() throws RecognitionException {
        AliasMasker.pivot_clause_return retval = new AliasMasker.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT105=null;
        CommonTree INTEGER106=null;

        CommonTree PIVOT105_tree=null;
        CommonTree INTEGER106_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:255:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:255:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT105=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1146); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT105_tree = (CommonTree)adaptor.dupNode(PIVOT105);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT105_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER106=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER106_tree = (CommonTree)adaptor.dupNode(INTEGER106);


            adaptor.addChild(root_1, INTEGER106_tree);
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
    // $ANTLR end "pivot_clause"


    public static class autopivot_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "autopivot_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:258:1: autopivot_clause : chunksize_clause rate_clause ;
    public final AliasMasker.autopivot_clause_return autopivot_clause() throws RecognitionException {
        AliasMasker.autopivot_clause_return retval = new AliasMasker.autopivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.chunksize_clause_return chunksize_clause107 =null;

        AliasMasker.rate_clause_return rate_clause108 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:259:5: ( chunksize_clause rate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:259:7: chunksize_clause rate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_chunksize_clause_in_autopivot_clause1163);
            chunksize_clause107=chunksize_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, chunksize_clause107.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rate_clause_in_autopivot_clause1165);
            rate_clause108=rate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rate_clause108.getTree());


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
    // $ANTLR end "autopivot_clause"


    public static class chunksize_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chunksize_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:262:1: chunksize_clause : ^( CHUNKSIZE INTEGER ) ;
    public final AliasMasker.chunksize_clause_return chunksize_clause() throws RecognitionException {
        AliasMasker.chunksize_clause_return retval = new AliasMasker.chunksize_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CHUNKSIZE109=null;
        CommonTree INTEGER110=null;

        CommonTree CHUNKSIZE109_tree=null;
        CommonTree INTEGER110_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:263:5: ( ^( CHUNKSIZE INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:263:7: ^( CHUNKSIZE INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CHUNKSIZE109=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_chunksize_clause1180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CHUNKSIZE109_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE109);


            root_1 = (CommonTree)adaptor.becomeRoot(CHUNKSIZE109_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER110=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_chunksize_clause1182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER110_tree = (CommonTree)adaptor.dupNode(INTEGER110);


            adaptor.addChild(root_1, INTEGER110_tree);
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
    // $ANTLR end "chunksize_clause"


    public static class rate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rate_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:266:1: rate_clause : ^( RATE DOUBLENUMBER ) ;
    public final AliasMasker.rate_clause_return rate_clause() throws RecognitionException {
        AliasMasker.rate_clause_return retval = new AliasMasker.rate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RATE111=null;
        CommonTree DOUBLENUMBER112=null;

        CommonTree RATE111_tree=null;
        CommonTree DOUBLENUMBER112_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:267:5: ( ^( RATE DOUBLENUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:267:7: ^( RATE DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RATE111=(CommonTree)match(input,RATE,FOLLOW_RATE_in_rate_clause1199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RATE111_tree = (CommonTree)adaptor.dupNode(RATE111);


            root_1 = (CommonTree)adaptor.becomeRoot(RATE111_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            DOUBLENUMBER112=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_rate_clause1201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLENUMBER112_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER112);


            adaptor.addChild(root_1, DOUBLENUMBER112_tree);
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
    // $ANTLR end "rate_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:270:1: cube_item : rel ( cube_by_clause ) ;
    public final AliasMasker.cube_item_return cube_item() throws RecognitionException {
        AliasMasker.cube_item_return retval = new AliasMasker.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel113 =null;

        AliasMasker.cube_by_clause_return cube_by_clause114 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:271:5: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:271:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1216);
            rel113=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel113.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:271:11: ( cube_by_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:271:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1220);
            cube_by_clause114=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause114.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:274:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AliasMasker.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AliasMasker.cube_by_clause_return retval = new AliasMasker.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY115=null;
        AliasMasker.cube_or_rollup_return cube_or_rollup116 =null;


        CommonTree BY115_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:275:5: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:275:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY115=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY115_tree = (CommonTree)adaptor.dupNode(BY115);


            root_1 = (CommonTree)adaptor.becomeRoot(BY115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1239);
            cube_or_rollup116=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup116.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:278:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AliasMasker.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AliasMasker.cube_or_rollup_return retval = new AliasMasker.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_rollup_list_return cube_rollup_list117 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:279:5: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:279:7: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:279:7: ( cube_rollup_list )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==CUBE||LA33_0==ROLLUP) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:279:7: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1254);
            	    cube_rollup_list117=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list117.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:282:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) );
    public final AliasMasker.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AliasMasker.cube_rollup_list_return retval = new AliasMasker.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE118=null;
        CommonTree ROLLUP120=null;
        AliasMasker.cube_by_expr_list_return cube_by_expr_list119 =null;

        AliasMasker.cube_by_expr_list_return cube_by_expr_list121 =null;

        AliasMasker.pivot_clause_return pivot_clause122 =null;

        AliasMasker.chunksize_clause_return chunksize_clause123 =null;

        AliasMasker.rate_clause_return rate_clause124 =null;


        CommonTree CUBE118_tree=null;
        CommonTree ROLLUP120_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:5: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==CUBE) ) {
                alt35=1;
            }
            else if ( (LA35_0==ROLLUP) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:7: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE118=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE118_tree = (CommonTree)adaptor.dupNode(CUBE118);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE118_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1272);
                    cube_by_expr_list119=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list119.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:37: ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP120=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP120_tree = (CommonTree)adaptor.dupNode(ROLLUP120);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP120_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1282);
                    cube_by_expr_list121=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list121.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:65: ( pivot_clause | ( chunksize_clause rate_clause ) )?
                    int alt34=3;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==PIVOT) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==CHUNKSIZE) ) {
                        alt34=2;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:67: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1286);
                            pivot_clause122=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause122.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:82: ( chunksize_clause rate_clause )
                            {
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:82: ( chunksize_clause rate_clause )
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:283:84: chunksize_clause rate_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_chunksize_clause_in_cube_rollup_list1292);
                            chunksize_clause123=chunksize_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, chunksize_clause123.getTree());


                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_rate_clause_in_cube_rollup_list1294);
                            rate_clause124=rate_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, rate_clause124.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:286:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AliasMasker.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AliasMasker.cube_by_expr_list_return retval = new AliasMasker.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_by_expr_return cube_by_expr125 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:287:5: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:287:7: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:287:7: ( cube_by_expr )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==BIGDECIMALNUMBER||LA36_0==BIGINTEGERNUMBER||LA36_0==CUBE||LA36_0==DIV||LA36_0==DOLLARVAR||LA36_0==DOUBLENUMBER||LA36_0==FALSE||LA36_0==FLOATNUMBER||LA36_0==GROUP||LA36_0==IDENTIFIER||LA36_0==INTEGER||LA36_0==LONGINTEGER||LA36_0==MINUS||LA36_0==NULL||LA36_0==PERCENT||LA36_0==PLUS||LA36_0==QUOTEDSTRING||LA36_0==STAR||LA36_0==TRUE||(LA36_0 >= BAG_VAL && LA36_0 <= BIN_EXPR)||(LA36_0 >= CASE_COND && LA36_0 <= CASE_EXPR)||(LA36_0 >= CAST_EXPR && LA36_0 <= EXPR_IN_PAREN)||LA36_0==FUNC_EVAL||(LA36_0 >= MAP_VAL && LA36_0 <= NEG)||LA36_0==TUPLE_VAL) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:287:7: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1314);
            	    cube_by_expr125=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr125.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:290:1: cube_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AliasMasker.cube_by_expr_return retval = new AliasMasker.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR128=null;
        AliasMasker.col_range_return col_range126 =null;

        AliasMasker.expr_return expr127 =null;


        CommonTree STAR128_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:291:5: ( col_range | expr | STAR )
            int alt37=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt37=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt37=2;
                }
                break;
            case STAR:
                {
                int LA37_3 = input.LA(2);

                if ( (LA37_3==DOWN) ) {
                    alt37=2;
                }
                else if ( (LA37_3==EOF||LA37_3==UP||LA37_3==BIGDECIMALNUMBER||LA37_3==BIGINTEGERNUMBER||LA37_3==CHUNKSIZE||LA37_3==CUBE||LA37_3==DIV||LA37_3==DOLLARVAR||LA37_3==DOUBLENUMBER||LA37_3==FALSE||LA37_3==FLOATNUMBER||LA37_3==GROUP||LA37_3==IDENTIFIER||LA37_3==INTEGER||LA37_3==LONGINTEGER||LA37_3==MINUS||LA37_3==NULL||LA37_3==PERCENT||(LA37_3 >= PIVOT && LA37_3 <= PLUS)||LA37_3==QUOTEDSTRING||LA37_3==STAR||LA37_3==TRUE||(LA37_3 >= BAG_VAL && LA37_3 <= BIN_EXPR)||(LA37_3 >= CASE_COND && LA37_3 <= CASE_EXPR)||(LA37_3 >= CAST_EXPR && LA37_3 <= EXPR_IN_PAREN)||LA37_3==FUNC_EVAL||(LA37_3 >= MAP_VAL && LA37_3 <= NEG)||LA37_3==TUPLE_VAL) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:291:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1328);
                    col_range126=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range126.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:291:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1332);
                    expr127=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr127.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:291:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR128=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR128_tree = (CommonTree)adaptor.dupNode(STAR128);


                    adaptor.addChild(root_0, STAR128_tree);
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


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:294:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set129=null;
        AliasMasker.group_item_return group_item130 =null;

        AliasMasker.group_type_return group_type131 =null;

        AliasMasker.partition_clause_return partition_clause132 =null;


        CommonTree set129_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set129=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set129_tree = (CommonTree)adaptor.dupNode(set129);


                root_1 = (CommonTree)adaptor.becomeRoot(set129_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:30: ( group_item )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==ASSERT||LA38_0==COGROUP||(LA38_0 >= CROSS && LA38_0 <= CUBE)||LA38_0==DEFINE||LA38_0==DISTINCT||LA38_0==FILTER||LA38_0==FOREACH||LA38_0==GROUP||LA38_0==IDENTIFIER||LA38_0==JOIN||(LA38_0 >= LIMIT && LA38_0 <= LOAD)||LA38_0==MAPREDUCE||LA38_0==ORDER||LA38_0==RANK||LA38_0==SAMPLE||LA38_0==SPLIT||(LA38_0 >= STORE && LA38_0 <= STREAM)||LA38_0==UNION) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1361);
            	    group_item130=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item130.getTree());


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


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:42: ( group_type )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==QUOTEDSTRING) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1364);
                    group_type131=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type131.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:54: ( partition_clause )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==PARTITION) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:295:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1367);
                    partition_clause132=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause132.getTree());


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
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:298:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING133=null;

        CommonTree QUOTEDSTRING133_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:298:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:298:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING133=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1379); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING133_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING133);


            adaptor.addChild(root_0, QUOTEDSTRING133_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:301:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL136=null;
        CommonTree ANY137=null;
        CommonTree set138=null;
        AliasMasker.rel_return rel134 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause135 =null;


        CommonTree ALL136_tree=null;
        CommonTree ANY137_tree=null;
        CommonTree set138_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1392);
            rel134=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel134.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:11: ( join_group_by_clause | ALL | ANY )
            int alt41=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt41=1;
                }
                break;
            case ALL:
                {
                alt41=2;
                }
                break;
            case ANY:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1396);
                    join_group_by_clause135=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause135.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL136=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL136_tree = (CommonTree)adaptor.dupNode(ALL136);


                    adaptor.addChild(root_0, ALL136_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY137=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY137_tree = (CommonTree)adaptor.dupNode(ANY137);


                    adaptor.addChild(root_0, ANY137_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:302:48: ( INNER | OUTER )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==INNER||LA42_0==OUTER) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set138=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set138_tree = (CommonTree)adaptor.dupNode(set138);


                        adaptor.addChild(root_0, set138_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:305:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias139 =null;

        AliasMasker.op_clause_return op_clause140 =null;

        AliasMasker.parallel_clause_return parallel_clause141 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==IDENTIFIER) ) {
                alt44=1;
            }
            else if ( (LA44_0==ASSERT||LA44_0==COGROUP||(LA44_0 >= CROSS && LA44_0 <= CUBE)||LA44_0==DEFINE||LA44_0==DISTINCT||LA44_0==FILTER||LA44_0==FOREACH||LA44_0==GROUP||LA44_0==JOIN||(LA44_0 >= LIMIT && LA44_0 <= LOAD)||LA44_0==MAPREDUCE||LA44_0==ORDER||LA44_0==RANK||LA44_0==SAMPLE||LA44_0==SPLIT||(LA44_0 >= STORE && LA44_0 <= STREAM)||LA44_0==UNION) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1430);
                    alias139=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:15: ( op_clause ( parallel_clause )? )
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1436);
                    op_clause140=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause140.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:27: ( parallel_clause )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==PARALLEL) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:306:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1438);
                            parallel_clause141=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause141.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
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
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:309:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR145=null;
        AliasMasker.flatten_clause_return flatten_clause142 =null;

        AliasMasker.col_range_return col_range143 =null;

        AliasMasker.expr_return expr144 =null;

        AliasMasker.field_def_list_return field_def_list146 =null;


        CommonTree STAR145_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:7: ( flatten_clause | col_range | expr | STAR )
            int alt45=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt45=1;
                }
                break;
            case COL_RANGE:
                {
                alt45=2;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt45=3;
                }
                break;
            case STAR:
                {
                int LA45_4 = input.LA(2);

                if ( (LA45_4==DOWN) ) {
                    alt45=3;
                }
                else if ( (LA45_4==EOF||LA45_4==UP||LA45_4==BIGDECIMALNUMBER||LA45_4==BIGINTEGERNUMBER||LA45_4==CUBE||LA45_4==DIV||LA45_4==DOLLARVAR||LA45_4==DOUBLENUMBER||LA45_4==FALSE||LA45_4==FLATTEN||LA45_4==FLOATNUMBER||LA45_4==GROUP||LA45_4==IDENTIFIER||LA45_4==INTEGER||LA45_4==LONGINTEGER||LA45_4==MINUS||LA45_4==NULL||LA45_4==PERCENT||LA45_4==PLUS||LA45_4==QUOTEDSTRING||LA45_4==STAR||LA45_4==TRUE||(LA45_4 >= BAG_VAL && LA45_4 <= BIN_EXPR)||(LA45_4 >= CASE_COND && LA45_4 <= CASE_EXPR)||(LA45_4 >= CAST_EXPR && LA45_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA45_4==FUNC_EVAL||(LA45_4 >= MAP_VAL && LA45_4 <= NEG)||LA45_4==TUPLE_VAL) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1466);
                    flatten_clause142=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause142.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1470);
                    col_range143=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range143.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1474);
                    expr144=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr144.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR145=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR145_tree = (CommonTree)adaptor.dupNode(STAR145);


                    adaptor.addChild(root_0, STAR145_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:52: ( field_def_list )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0 >= FIELD_DEF && LA46_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:316:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1482);
                    field_def_list146=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list146.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:319:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN147=null;
        AliasMasker.expr_return expr148 =null;


        CommonTree FLATTEN147_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:320:5: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:320:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN147=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1498); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN147_tree = (CommonTree)adaptor.dupNode(FLATTEN147);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN147_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1500);
            expr148=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr148.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:323:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE149=null;
        AliasMasker.alias_return alias150 =null;

        AliasMasker.filename_return filename151 =null;

        AliasMasker.func_clause_return func_clause152 =null;


        CommonTree STORE149_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:324:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:324:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE149=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1517); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE149_tree = (CommonTree)adaptor.dupNode(STORE149);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE149_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1519);
            alias150=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias150.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1521);
            filename151=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename151.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:324:31: ( func_clause )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FUNC||LA47_0==FUNC_REF) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:324:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1523);
                    func_clause152=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause152.getTree());


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
    // $ANTLR end "store_clause"


    public static class assert_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:327:1: assert_clause : ^( ASSERT alias cond ( comment )? ) ;
    public final AliasMasker.assert_clause_return assert_clause() throws RecognitionException {
        AliasMasker.assert_clause_return retval = new AliasMasker.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT153=null;
        AliasMasker.alias_return alias154 =null;

        AliasMasker.cond_return cond155 =null;

        AliasMasker.comment_return comment156 =null;


        CommonTree ASSERT153_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:328:5: ( ^( ASSERT alias cond ( comment )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:328:7: ^( ASSERT alias cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT153=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1541); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT153_tree = (CommonTree)adaptor.dupNode(ASSERT153);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT153_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_assert_clause1543);
            alias154=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias154.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1545);
            cond155=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond155.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:328:28: ( comment )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==QUOTEDSTRING) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:328:28: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1547);
                    comment156=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment156.getTree());


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
    // $ANTLR end "assert_clause"


    public static class comment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:331:1: comment : QUOTEDSTRING ;
    public final AliasMasker.comment_return comment() throws RecognitionException {
        AliasMasker.comment_return retval = new AliasMasker.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING157=null;

        CommonTree QUOTEDSTRING157_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:331:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:331:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING157=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1559); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING157_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING157);


            adaptor.addChild(root_0, QUOTEDSTRING157_tree);
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
    // $ANTLR end "comment"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:334:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER158=null;
        AliasMasker.rel_return rel159 =null;

        AliasMasker.cond_return cond160 =null;


        CommonTree FILTER158_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:335:5: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:335:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER158=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER158_tree = (CommonTree)adaptor.dupNode(FILTER158);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER158_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1576);
            rel159=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel159.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1578);
            cond160=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond160.getTree());


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
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:338:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR161=null;
        CommonTree AND164=null;
        CommonTree NOT167=null;
        CommonTree NULL169=null;
        CommonTree NOT171=null;
        CommonTree BOOL_COND177=null;
        AliasMasker.cond_return cond162 =null;

        AliasMasker.cond_return cond163 =null;

        AliasMasker.cond_return cond165 =null;

        AliasMasker.cond_return cond166 =null;

        AliasMasker.cond_return cond168 =null;

        AliasMasker.expr_return expr170 =null;

        AliasMasker.rel_op_return rel_op172 =null;

        AliasMasker.expr_return expr173 =null;

        AliasMasker.expr_return expr174 =null;

        AliasMasker.in_eval_return in_eval175 =null;

        AliasMasker.func_eval_return func_eval176 =null;

        AliasMasker.expr_return expr178 =null;


        CommonTree OR161_tree=null;
        CommonTree AND164_tree=null;
        CommonTree NOT167_tree=null;
        CommonTree NULL169_tree=null;
        CommonTree NOT171_tree=null;
        CommonTree BOOL_COND177_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:339:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt50=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt50=1;
                }
                break;
            case AND:
                {
                alt50=2;
                }
                break;
            case NOT:
                {
                alt50=3;
                }
                break;
            case NULL:
                {
                alt50=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt50=5;
                }
                break;
            case IN:
                {
                alt50=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt50=7;
                }
                break;
            case BOOL_COND:
                {
                alt50=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:339:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR161=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR161_tree = (CommonTree)adaptor.dupNode(OR161);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR161_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1597);
                    cond162=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond162.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1599);
                    cond163=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond163.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:340:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND164=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND164_tree = (CommonTree)adaptor.dupNode(AND164);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND164_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1613);
                    cond165=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond165.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1615);
                    cond166=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond166.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:341:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT167=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT167_tree = (CommonTree)adaptor.dupNode(NOT167);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT167_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1629);
                    cond168=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond168.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:342:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL169=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL169_tree = (CommonTree)adaptor.dupNode(NULL169);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL169_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1643);
                    expr170=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr170.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:342:20: ( NOT )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==NOT) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:342:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT171=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1645); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT171_tree = (CommonTree)adaptor.dupNode(NOT171);


                            adaptor.addChild(root_1, NOT171_tree);
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
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:343:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1658);
                    rel_op172=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op172.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1660);
                    expr173=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr173.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1662);
                    expr174=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr174.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:344:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1672);
                    in_eval175=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval175.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:345:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1680);
                    func_eval176=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval176.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:346:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND177=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND177_tree = (CommonTree)adaptor.dupNode(BOOL_COND177);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND177_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1692);
                    expr178=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr178.getTree());


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
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:349:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AliasMasker.in_eval_return in_eval() throws RecognitionException {
        AliasMasker.in_eval_return retval = new AliasMasker.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN179=null;
        CommonTree IN_LHS180=null;
        CommonTree IN_RHS182=null;
        AliasMasker.expr_return expr181 =null;

        AliasMasker.expr_return expr183 =null;


        CommonTree IN179_tree=null;
        CommonTree IN_LHS180_tree=null;
        CommonTree IN_RHS182_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:350:5: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:350:7: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN179=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1709); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN179_tree = (CommonTree)adaptor.dupNode(IN179);


            root_1 = (CommonTree)adaptor.becomeRoot(IN179_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:350:13: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==IN_LHS) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:350:15: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS180=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1715); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS180_tree = (CommonTree)adaptor.dupNode(IN_LHS180);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS180_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1717);
            	    expr181=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr181.getTree());


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
            	    IN_RHS182=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1723); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS182_tree = (CommonTree)adaptor.dupNode(IN_RHS182);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS182_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1725);
            	    expr183=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr183.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
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
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:353:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL184=null;
        AliasMasker.func_name_return func_name185 =null;

        AliasMasker.real_arg_return real_arg186 =null;


        CommonTree FUNC_EVAL184_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:354:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:354:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL184=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1747); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL184_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL184);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL184_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1749);
            func_name185=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name185.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:354:30: ( real_arg )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==BIGDECIMALNUMBER||LA52_0==BIGINTEGERNUMBER||LA52_0==CUBE||LA52_0==DIV||LA52_0==DOLLARVAR||LA52_0==DOUBLENUMBER||LA52_0==FALSE||LA52_0==FLOATNUMBER||LA52_0==GROUP||LA52_0==IDENTIFIER||LA52_0==INTEGER||LA52_0==LONGINTEGER||LA52_0==MINUS||LA52_0==NULL||LA52_0==PERCENT||LA52_0==PLUS||LA52_0==QUOTEDSTRING||LA52_0==STAR||LA52_0==TRUE||(LA52_0 >= BAG_VAL && LA52_0 <= BIN_EXPR)||(LA52_0 >= CASE_COND && LA52_0 <= CASE_EXPR)||LA52_0==CAST_EXPR||LA52_0==EXPR_IN_PAREN||LA52_0==FUNC_EVAL||(LA52_0 >= MAP_VAL && LA52_0 <= NEG)||LA52_0==TUPLE_VAL) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:354:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1751);
            	    real_arg186=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg186.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop52;
                }
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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:357:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR188=null;
        AliasMasker.expr_return expr187 =null;


        CommonTree STAR188_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:358:5: ( expr | STAR )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==BIGDECIMALNUMBER||LA53_0==BIGINTEGERNUMBER||LA53_0==CUBE||LA53_0==DIV||LA53_0==DOLLARVAR||LA53_0==DOUBLENUMBER||LA53_0==FALSE||LA53_0==FLOATNUMBER||LA53_0==GROUP||LA53_0==IDENTIFIER||LA53_0==INTEGER||LA53_0==LONGINTEGER||LA53_0==MINUS||LA53_0==NULL||LA53_0==PERCENT||LA53_0==PLUS||LA53_0==QUOTEDSTRING||LA53_0==TRUE||(LA53_0 >= BAG_VAL && LA53_0 <= BIN_EXPR)||(LA53_0 >= CASE_COND && LA53_0 <= CASE_EXPR)||LA53_0==CAST_EXPR||LA53_0==EXPR_IN_PAREN||LA53_0==FUNC_EVAL||(LA53_0 >= MAP_VAL && LA53_0 <= NEG)||LA53_0==TUPLE_VAL) ) {
                alt53=1;
            }
            else if ( (LA53_0==STAR) ) {
                int LA53_2 = input.LA(2);

                if ( (LA53_2==DOWN) ) {
                    alt53=1;
                }
                else if ( (LA53_2==EOF||LA53_2==UP||LA53_2==BIGDECIMALNUMBER||LA53_2==BIGINTEGERNUMBER||LA53_2==CUBE||LA53_2==DIV||LA53_2==DOLLARVAR||LA53_2==DOUBLENUMBER||LA53_2==FALSE||LA53_2==FLOATNUMBER||LA53_2==GROUP||LA53_2==IDENTIFIER||LA53_2==INTEGER||LA53_2==LONGINTEGER||LA53_2==MINUS||LA53_2==NULL||LA53_2==PERCENT||LA53_2==PLUS||LA53_2==QUOTEDSTRING||LA53_2==STAR||LA53_2==TRUE||(LA53_2 >= BAG_VAL && LA53_2 <= BIN_EXPR)||(LA53_2 >= CASE_COND && LA53_2 <= CASE_EXPR)||LA53_2==CAST_EXPR||LA53_2==EXPR_IN_PAREN||LA53_2==FUNC_EVAL||(LA53_2 >= MAP_VAL && LA53_2 <= NEG)||LA53_2==TUPLE_VAL) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:358:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1767);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr187.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:358:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR188=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR188_tree = (CommonTree)adaptor.dupNode(STAR188);


                    adaptor.addChild(root_0, STAR188_tree);
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
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:361:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS189=null;
        CommonTree MINUS192=null;
        CommonTree STAR195=null;
        CommonTree DIV198=null;
        CommonTree PERCENT201=null;
        CommonTree CAST_EXPR204=null;
        CommonTree NEG209=null;
        CommonTree CAST_EXPR211=null;
        CommonTree EXPR_IN_PAREN214=null;
        AliasMasker.expr_return expr190 =null;

        AliasMasker.expr_return expr191 =null;

        AliasMasker.expr_return expr193 =null;

        AliasMasker.expr_return expr194 =null;

        AliasMasker.expr_return expr196 =null;

        AliasMasker.expr_return expr197 =null;

        AliasMasker.expr_return expr199 =null;

        AliasMasker.expr_return expr200 =null;

        AliasMasker.expr_return expr202 =null;

        AliasMasker.expr_return expr203 =null;

        AliasMasker.type_return type205 =null;

        AliasMasker.expr_return expr206 =null;

        AliasMasker.const_expr_return const_expr207 =null;

        AliasMasker.var_expr_return var_expr208 =null;

        AliasMasker.expr_return expr210 =null;

        AliasMasker.type_cast_return type_cast212 =null;

        AliasMasker.expr_return expr213 =null;

        AliasMasker.expr_return expr215 =null;


        CommonTree PLUS189_tree=null;
        CommonTree MINUS192_tree=null;
        CommonTree STAR195_tree=null;
        CommonTree DIV198_tree=null;
        CommonTree PERCENT201_tree=null;
        CommonTree CAST_EXPR204_tree=null;
        CommonTree NEG209_tree=null;
        CommonTree CAST_EXPR211_tree=null;
        CommonTree EXPR_IN_PAREN214_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:362:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt54=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt54=1;
                }
                break;
            case MINUS:
                {
                int LA54_2 = input.LA(2);

                if ( (synpred104_AliasMasker()) ) {
                    alt54=2;
                }
                else if ( (synpred109_AliasMasker()) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt54=3;
                }
                break;
            case DIV:
                {
                alt54=4;
                }
                break;
            case PERCENT:
                {
                alt54=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA54_6 = input.LA(2);

                if ( (synpred108_AliasMasker()) ) {
                    alt54=6;
                }
                else if ( (synpred112_AliasMasker()) ) {
                    alt54=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 6, input);

                    throw nvae;

                }
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
                alt54=7;
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
                {
                alt54=8;
                }
                break;
            case NEG:
                {
                alt54=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt54=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:362:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS189=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS189_tree = (CommonTree)adaptor.dupNode(PLUS189);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS189_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1788);
                    expr190=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr190.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1790);
                    expr191=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr191.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:363:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS192=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1802); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS192_tree = (CommonTree)adaptor.dupNode(MINUS192);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS192_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1804);
                    expr193=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr193.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1806);
                    expr194=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr194.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:364:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR195=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR195_tree = (CommonTree)adaptor.dupNode(STAR195);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR195_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1820);
                    expr196=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr196.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1822);
                    expr197=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr197.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:365:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV198=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV198_tree = (CommonTree)adaptor.dupNode(DIV198);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1836);
                    expr199=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr199.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1838);
                    expr200=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr200.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:366:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT201=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT201_tree = (CommonTree)adaptor.dupNode(PERCENT201);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT201_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1852);
                    expr202=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr202.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1854);
                    expr203=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr203.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:367:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR204=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR204_tree = (CommonTree)adaptor.dupNode(CAST_EXPR204);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR204_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1868);
                    type205=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type205.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1870);
                    expr206=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr206.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:368:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1880);
                    const_expr207=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr207.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:369:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1888);
                    var_expr208=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr208.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:370:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG209=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG209_tree = (CommonTree)adaptor.dupNode(NEG209);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG209_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1900);
                    expr210=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr210.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:371:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR211=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR211_tree = (CommonTree)adaptor.dupNode(CAST_EXPR211);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR211_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1914);
                    type_cast212=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast212.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1916);
                    expr213=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr213.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:372:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN214=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN214_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN214);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN214_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1930);
                    expr215=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr215.getTree());


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
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:375:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type216 =null;

        AliasMasker.map_type_return map_type217 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast218 =null;

        AliasMasker.bag_type_cast_return bag_type_cast219 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:376:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt55=4;
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
                alt55=1;
                }
                break;
            case MAP_TYPE:
                {
                alt55=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt55=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:376:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1945);
                    simple_type216=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type216.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:376:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1949);
                    map_type217=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type217.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:376:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1953);
                    tuple_type_cast218=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast218.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:376:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1957);
                    bag_type_cast219=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast219.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:379:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST220=null;
        AliasMasker.type_cast_return type_cast221 =null;


        CommonTree TUPLE_TYPE_CAST220_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:380:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:380:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST220=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST220_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST220);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST220_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:380:26: ( type_cast )*
                loop56:
                do {
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==BIGDECIMAL||LA56_0==BIGINTEGER||LA56_0==BOOLEAN||LA56_0==BYTEARRAY||LA56_0==CHARARRAY||LA56_0==DATETIME||LA56_0==DOUBLE||LA56_0==FLOAT||LA56_0==INT||LA56_0==LONG||LA56_0==BAG_TYPE_CAST||LA56_0==MAP_TYPE||LA56_0==TUPLE_TYPE_CAST) ) {
                        alt56=1;
                    }


                    switch (alt56) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:380:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1974);
                	    type_cast221=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast221.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop56;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:383:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST222=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast223 =null;


        CommonTree BAG_TYPE_CAST222_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:384:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:384:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST222=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1992); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST222_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST222);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST222_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:384:24: ( tuple_type_cast )?
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==TUPLE_TYPE_CAST) ) {
                    alt57=1;
                }
                switch (alt57) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:384:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1994);
                        tuple_type_cast223=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast223.getTree());


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
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:387:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr224 =null;

        AliasMasker.dot_proj_return dot_proj225 =null;

        AliasMasker.pound_proj_return pound_proj226 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:388:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:388:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2010);
            projectable_expr224=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr224.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:388:24: ( dot_proj | pound_proj )*
            loop58:
            do {
                int alt58=3;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==PERIOD) ) {
                    alt58=1;
                }
                else if ( (LA58_0==POUND) ) {
                    alt58=2;
                }


                switch (alt58) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:388:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2014);
            	    dot_proj225=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj225.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:388:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2018);
            	    pound_proj226=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj226.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop58;
                }
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
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:391:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval227 =null;

        AliasMasker.col_ref_return col_ref228 =null;

        AliasMasker.bin_expr_return bin_expr229 =null;

        AliasMasker.case_expr_return case_expr230 =null;

        AliasMasker.case_cond_return case_cond231 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt59=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt59=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt59=2;
                }
                break;
            case BIN_EXPR:
                {
                alt59=3;
                }
                break;
            case CASE_EXPR:
                {
                alt59=4;
                }
                break;
            case CASE_COND:
                {
                alt59=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2034);
                    func_eval227=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval227.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2038);
                    col_ref228=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2042);
                    bin_expr229=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr229.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2046);
                    case_expr230=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr230.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:392:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2050);
                    case_cond231=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond231.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:395:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD232=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index233 =null;


        CommonTree PERIOD232_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:396:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:396:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD232=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD232_tree = (CommonTree)adaptor.dupNode(PERIOD232);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD232_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:396:17: ( col_alias_or_index )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==CUBE||LA60_0==DOLLARVAR||LA60_0==GROUP||LA60_0==IDENTIFIER) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:396:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2067);
            	    col_alias_or_index233=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index233.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:399:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias234 =null;

        AliasMasker.col_index_return col_index235 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:399:20: ( col_alias | col_index )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==CUBE||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            else if ( (LA61_0==DOLLARVAR) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:399:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2079);
                    col_alias234=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias234.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:399:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2083);
                    col_index235=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index235.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:402:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set236=null;

        CommonTree set236_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:403:5: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set236=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set236_tree = (CommonTree)adaptor.dupNode(set236);


                adaptor.addChild(root_0, set236_tree);
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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:408:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR237=null;

        CommonTree DOLLARVAR237_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:409:5: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:409:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR237=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR237_tree = (CommonTree)adaptor.dupNode(DOLLARVAR237);


            adaptor.addChild(root_0, DOLLARVAR237_tree);
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
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE238=null;
        CommonTree DOUBLE_PERIOD240=null;
        AliasMasker.col_ref_return col_ref239 =null;

        AliasMasker.col_ref_return col_ref241 =null;


        CommonTree COL_RANGE238_tree=null;
        CommonTree DOUBLE_PERIOD240_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE238=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2136); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE238_tree = (CommonTree)adaptor.dupNode(COL_RANGE238);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:26: ( col_ref )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==CUBE||LA62_0==DOLLARVAR||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2138);
                    col_ref239=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref239.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD240=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD240_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD240);


            adaptor.addChild(root_1, DOUBLE_PERIOD240_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:49: ( col_ref )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==CUBE||LA63_0==DOLLARVAR||LA63_0==GROUP||LA63_0==IDENTIFIER) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:412:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2143);
                    col_ref241=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref241.getTree());


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
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:415:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND242=null;
        CommonTree set243=null;

        CommonTree POUND242_tree=null;
        CommonTree set243_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:416:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:416:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND242=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND242_tree = (CommonTree)adaptor.dupNode(POUND242);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set243=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set243_tree = (CommonTree)adaptor.dupNode(set243);


                adaptor.addChild(root_1, set243_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:419:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR244=null;
        AliasMasker.cond_return cond245 =null;

        AliasMasker.expr_return expr246 =null;

        AliasMasker.expr_return expr247 =null;


        CommonTree BIN_EXPR244_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:420:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:420:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR244=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2187); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR244_tree = (CommonTree)adaptor.dupNode(BIN_EXPR244);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR244_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2189);
            cond245=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond245.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2191);
            expr246=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr246.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2193);
            expr247=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr247.getTree());


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
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:423:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AliasMasker.case_expr_return case_expr() throws RecognitionException {
        AliasMasker.case_expr_return retval = new AliasMasker.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR248=null;
        CommonTree CASE_EXPR_LHS249=null;
        CommonTree CASE_EXPR_RHS251=null;
        AliasMasker.expr_return expr250 =null;

        AliasMasker.expr_return expr252 =null;


        CommonTree CASE_EXPR248_tree=null;
        CommonTree CASE_EXPR_LHS249_tree=null;
        CommonTree CASE_EXPR_RHS251_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:5: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:7: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR248=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR248_tree = (CommonTree)adaptor.dupNode(CASE_EXPR248);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR248_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:20: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==CASE_EXPR_LHS) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:22: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS249=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2216); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS249_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS249);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS249_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2218);
            	    expr250=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr250.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:46: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt64=0;
            	    loop64:
            	    do {
            	        int alt64=2;
            	        int LA64_0 = input.LA(1);

            	        if ( (LA64_0==CASE_EXPR_RHS) ) {
            	            alt64=1;
            	        }


            	        switch (alt64) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:424:48: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS251=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2226); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS251_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS251);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS251_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2228);
            	    	    expr252=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr252.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt64 >= 1 ) break loop64;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(64, input);
            	                throw eee;
            	        }
            	        cnt64++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
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
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:427:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AliasMasker.case_cond_return case_cond() throws RecognitionException {
        AliasMasker.case_cond_return retval = new AliasMasker.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND253=null;
        CommonTree WHEN254=null;
        CommonTree THEN256=null;
        AliasMasker.cond_return cond255 =null;

        AliasMasker.expr_return expr257 =null;


        CommonTree CASE_COND253_tree=null;
        CommonTree WHEN254_tree=null;
        CommonTree THEN256_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:5: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:7: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND253=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND253_tree = (CommonTree)adaptor.dupNode(CASE_COND253);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND253_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN254=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN254_tree = (CommonTree)adaptor.dupNode(WHEN254);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN254_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:28: ( cond )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==AND||LA66_0==IN||(LA66_0 >= NOT && LA66_0 <= NUM_OP_NE)||LA66_0==OR||(LA66_0 >= STR_OP_EQ && LA66_0 <= STR_OP_NE)||LA66_0==BOOL_COND||LA66_0==FUNC_EVAL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:28: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2258);
            	    cond255=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond255.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
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
            THEN256=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN256_tree = (CommonTree)adaptor.dupNode(THEN256);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN256_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:44: ( expr )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==BIGDECIMALNUMBER||LA67_0==BIGINTEGERNUMBER||LA67_0==CUBE||LA67_0==DIV||LA67_0==DOLLARVAR||LA67_0==DOUBLENUMBER||LA67_0==FALSE||LA67_0==FLOATNUMBER||LA67_0==GROUP||LA67_0==IDENTIFIER||LA67_0==INTEGER||LA67_0==LONGINTEGER||LA67_0==MINUS||LA67_0==NULL||LA67_0==PERCENT||LA67_0==PLUS||LA67_0==QUOTEDSTRING||LA67_0==STAR||LA67_0==TRUE||(LA67_0 >= BAG_VAL && LA67_0 <= BIN_EXPR)||(LA67_0 >= CASE_COND && LA67_0 <= CASE_EXPR)||LA67_0==CAST_EXPR||LA67_0==EXPR_IN_PAREN||LA67_0==FUNC_EVAL||(LA67_0 >= MAP_VAL && LA67_0 <= NEG)||LA67_0==TUPLE_VAL) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:428:44: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2267);
            	    expr257=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr257.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:431:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT258=null;
        CommonTree INTEGER260=null;
        CommonTree LONGINTEGER261=null;
        AliasMasker.rel_return rel259 =null;

        AliasMasker.expr_return expr262 =null;


        CommonTree LIMIT258_tree=null;
        CommonTree INTEGER260_tree=null;
        CommonTree LONGINTEGER261_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT258=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT258_tree = (CommonTree)adaptor.dupNode(LIMIT258);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT258_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2289);
            rel259=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel259.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:20: ( INTEGER | LONGINTEGER | expr )
            int alt68=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA68_1 = input.LA(2);

                if ( (synpred135_AliasMasker()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA68_2 = input.LA(2);

                if ( (synpred136_AliasMasker()) ) {
                    alt68=2;
                }
                else if ( (true) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt68=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }

            switch (alt68) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER260=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER260_tree = (CommonTree)adaptor.dupNode(INTEGER260);


                    adaptor.addChild(root_1, INTEGER260_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER261=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER261_tree = (CommonTree)adaptor.dupNode(LONGINTEGER261);


                    adaptor.addChild(root_1, LONGINTEGER261_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2301);
                    expr262=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr262.getTree());


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
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:435:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE263=null;
        CommonTree DOUBLENUMBER265=null;
        AliasMasker.rel_return rel264 =null;

        AliasMasker.expr_return expr266 =null;


        CommonTree SAMPLE263_tree=null;
        CommonTree DOUBLENUMBER265_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE263=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE263_tree = (CommonTree)adaptor.dupNode(SAMPLE263);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE263_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2323);
            rel264=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel264.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:22: ( DOUBLENUMBER | expr )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==DOUBLENUMBER) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred137_AliasMasker()) ) {
                    alt69=1;
                }
                else if ( (true) ) {
                    alt69=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA69_0==BIGDECIMALNUMBER||LA69_0==BIGINTEGERNUMBER||LA69_0==CUBE||LA69_0==DIV||LA69_0==DOLLARVAR||LA69_0==FALSE||LA69_0==FLOATNUMBER||LA69_0==GROUP||LA69_0==IDENTIFIER||LA69_0==INTEGER||LA69_0==LONGINTEGER||LA69_0==MINUS||LA69_0==NULL||LA69_0==PERCENT||LA69_0==PLUS||LA69_0==QUOTEDSTRING||LA69_0==STAR||LA69_0==TRUE||(LA69_0 >= BAG_VAL && LA69_0 <= BIN_EXPR)||(LA69_0 >= CASE_COND && LA69_0 <= CASE_EXPR)||LA69_0==CAST_EXPR||LA69_0==EXPR_IN_PAREN||LA69_0==FUNC_EVAL||(LA69_0 >= MAP_VAL && LA69_0 <= NEG)||LA69_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER265=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER265_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER265);


                    adaptor.addChild(root_1, DOUBLENUMBER265_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2331);
                    expr266=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr266.getTree());


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
    // $ANTLR end "sample_clause"


    public static class rank_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:439:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AliasMasker.rank_clause_return rank_clause() throws RecognitionException {
        AliasMasker.rank_clause_return retval = new AliasMasker.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK267=null;
        AliasMasker.rel_return rel268 =null;

        AliasMasker.rank_by_statement_return rank_by_statement269 =null;


        CommonTree RANK267_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:440:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:440:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK267=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2347); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK267_tree = (CommonTree)adaptor.dupNode(RANK267);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK267_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2349);
            rel268=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel268.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:440:16: ( rank_by_statement )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==BY) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:440:18: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2353);
                    rank_by_statement269=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement269.getTree());


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
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:443:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AliasMasker.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AliasMasker.rank_by_statement_return retval = new AliasMasker.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY270=null;
        CommonTree DENSE272=null;
        AliasMasker.rank_by_clause_return rank_by_clause271 =null;


        CommonTree BY270_tree=null;
        CommonTree DENSE272_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:444:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:444:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY270=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY270_tree = (CommonTree)adaptor.dupNode(BY270);


            root_1 = (CommonTree)adaptor.becomeRoot(BY270_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2372);
            rank_by_clause271=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause271.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:444:25: ( DENSE )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==DENSE) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:444:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE272=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE272_tree = (CommonTree)adaptor.dupNode(DENSE272);


                    adaptor.addChild(root_1, DENSE272_tree);
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
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:447:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AliasMasker.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AliasMasker.rank_by_clause_return retval = new AliasMasker.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR273=null;
        CommonTree set274=null;
        AliasMasker.rank_col_return rank_col275 =null;


        CommonTree STAR273_tree=null;
        CommonTree set274_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:448:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==STAR) ) {
                alt74=1;
            }
            else if ( (LA74_0==CUBE||LA74_0==DOLLARVAR||LA74_0==GROUP||LA74_0==IDENTIFIER||LA74_0==COL_RANGE) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:448:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR273=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR273_tree = (CommonTree)adaptor.dupNode(STAR273);


                    adaptor.addChild(root_0, STAR273_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:448:9: ( ASC | DESC )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==ASC||LA72_0==DESC) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set274=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set274_tree = (CommonTree)adaptor.dupNode(set274);


                                adaptor.addChild(root_0, set274_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:449:7: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:449:7: ( rank_col )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==CUBE||LA73_0==DOLLARVAR||LA73_0==GROUP||LA73_0==IDENTIFIER||LA73_0==COL_RANGE) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:449:7: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2410);
                    	    rank_col275=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col275.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:452:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.rank_col_return rank_col() throws RecognitionException {
        AliasMasker.rank_col_return retval = new AliasMasker.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set278=null;
        AliasMasker.col_range_return col_range276 =null;

        AliasMasker.col_ref_return col_ref277 =null;


        CommonTree set278_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:4: ( col_range | col_ref )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==COL_RANGE) ) {
                alt75=1;
            }
            else if ( (LA75_0==CUBE||LA75_0==DOLLARVAR||LA75_0==GROUP||LA75_0==IDENTIFIER) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2423);
                    col_range276=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range276.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2427);
                    col_ref277=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref277.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:453:28: ( ASC | DESC )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==ASC||LA76_0==DESC) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set278=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set278_tree = (CommonTree)adaptor.dupNode(set278);


                        adaptor.addChild(root_0, set278_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:456:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER279=null;
        AliasMasker.rel_return rel280 =null;

        AliasMasker.order_by_clause_return order_by_clause281 =null;

        AliasMasker.func_clause_return func_clause282 =null;


        CommonTree ORDER279_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:457:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:457:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER279=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER279_tree = (CommonTree)adaptor.dupNode(ORDER279);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER279_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2457);
            rel280=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel280.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2459);
            order_by_clause281=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause281.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:457:36: ( func_clause )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==FUNC||LA77_0==FUNC_REF) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:457:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2461);
                    func_clause282=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause282.getTree());


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
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:460:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR283=null;
        CommonTree set284=null;
        AliasMasker.order_col_return order_col285 =null;


        CommonTree STAR283_tree=null;
        CommonTree set284_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:461:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==STAR) ) {
                alt80=1;
            }
            else if ( (LA80_0==CUBE||LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==IDENTIFIER||LA80_0==COL_RANGE) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:461:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR283=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR283_tree = (CommonTree)adaptor.dupNode(STAR283);


                    adaptor.addChild(root_0, STAR283_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:461:12: ( ASC | DESC )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==ASC||LA78_0==DESC) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set284=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set284_tree = (CommonTree)adaptor.dupNode(set284);


                                adaptor.addChild(root_0, set284_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:462:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:462:7: ( order_col )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==CUBE||LA79_0==DOLLARVAR||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==COL_RANGE) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:462:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2496);
                    	    order_col285=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col285.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt79 >= 1 ) break loop79;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(79, input);
                                throw eee;
                        }
                        cnt79++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:465:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set288=null;
        AliasMasker.col_range_return col_range286 =null;

        AliasMasker.col_ref_return col_ref287 =null;


        CommonTree set288_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:7: ( col_range | col_ref )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==COL_RANGE) ) {
                alt81=1;
            }
            else if ( (LA81_0==CUBE||LA81_0==DOLLARVAR||LA81_0==GROUP||LA81_0==IDENTIFIER) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2511);
                    col_range286=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range286.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2515);
                    col_ref287=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref287.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:466:29: ( ASC | DESC )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==ASC||LA82_0==DESC) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set288=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set288_tree = (CommonTree)adaptor.dupNode(set288);


                        adaptor.addChild(root_0, set288_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:469:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT289=null;
        AliasMasker.rel_return rel290 =null;

        AliasMasker.partition_clause_return partition_clause291 =null;


        CommonTree DISTINCT289_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:470:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:470:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT289=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2542); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT289_tree = (CommonTree)adaptor.dupNode(DISTINCT289);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT289_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2544);
            rel290=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel290.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:470:23: ( partition_clause )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==PARTITION) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:470:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2546);
                    partition_clause291=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause291.getTree());


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
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:473:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION292=null;
        AliasMasker.func_name_return func_name293 =null;


        CommonTree PARTITION292_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:474:5: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:474:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION292=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2564); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION292_tree = (CommonTree)adaptor.dupNode(PARTITION292);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION292_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2566);
            func_name293=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name293.getTree());


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
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:477:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS294=null;
        AliasMasker.rel_list_return rel_list295 =null;

        AliasMasker.partition_clause_return partition_clause296 =null;


        CommonTree CROSS294_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:478:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:478:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS294=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2583); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS294_tree = (CommonTree)adaptor.dupNode(CROSS294);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2585);
            rel_list295=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list295.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:478:25: ( partition_clause )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==PARTITION) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:478:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2587);
                    partition_clause296=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause296.getTree());


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
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:481:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel297 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:482:5: ( ( rel )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:482:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:482:7: ( rel )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==ASSERT||LA85_0==COGROUP||(LA85_0 >= CROSS && LA85_0 <= CUBE)||LA85_0==DEFINE||LA85_0==DISTINCT||LA85_0==FILTER||LA85_0==FOREACH||LA85_0==GROUP||LA85_0==IDENTIFIER||LA85_0==JOIN||(LA85_0 >= LIMIT && LA85_0 <= LOAD)||LA85_0==MAPREDUCE||LA85_0==ORDER||LA85_0==RANK||LA85_0==SAMPLE||LA85_0==SPLIT||(LA85_0 >= STORE && LA85_0 <= STREAM)||LA85_0==UNION) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:482:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2603);
            	    rel297=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel297.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt85 >= 1 ) break loop85;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
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


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:485:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN298=null;
        AliasMasker.join_sub_clause_return join_sub_clause299 =null;

        AliasMasker.join_type_return join_type300 =null;

        AliasMasker.partition_clause_return partition_clause301 =null;


        CommonTree JOIN298_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN298=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2619); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN298_tree = (CommonTree)adaptor.dupNode(JOIN298);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN298_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2621);
            join_sub_clause299=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause299.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:31: ( join_type )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==QUOTEDSTRING) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2623);
                    join_type300=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type300.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:42: ( partition_clause )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==PARTITION) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:486:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2626);
                    partition_clause301=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause301.getTree());


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
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:489:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING302=null;

        CommonTree QUOTEDSTRING302_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:489:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:489:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING302=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING302_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING302);


            adaptor.addChild(root_0, QUOTEDSTRING302_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:492:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set304=null;
        CommonTree OUTER305=null;
        AliasMasker.join_item_return join_item303 =null;

        AliasMasker.join_item_return join_item306 =null;

        AliasMasker.join_item_return join_item307 =null;


        CommonTree set304_tree=null;
        CommonTree OUTER305_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:493:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==JOIN_ITEM) ) {
                int LA90_1 = input.LA(2);

                if ( (synpred163_AliasMasker()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }
            switch (alt90) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:493:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2651);
                    join_item303=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item303.getTree());


                    _last = (CommonTree)input.LT(1);
                    set304=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set304_tree = (CommonTree)adaptor.dupNode(set304);


                        adaptor.addChild(root_0, set304_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:496:16: ( OUTER )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==OUTER) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:496:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER305=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2706); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER305_tree = (CommonTree)adaptor.dupNode(OUTER305);


                            adaptor.addChild(root_0, OUTER305_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2709);
                    join_item306=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item306.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:497:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:497:7: ( join_item )+
                    int cnt89=0;
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==JOIN_ITEM) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:497:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2717);
                    	    join_item307=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item307.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt89 >= 1 ) break loop89;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(89, input);
                                throw eee;
                        }
                        cnt89++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:500:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM308=null;
        AliasMasker.rel_return rel309 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause310 =null;


        CommonTree JOIN_ITEM308_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:501:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:501:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM308=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2730); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM308_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM308);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM308_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2732);
            rel309=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel309.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2734);
            join_group_by_clause310=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause310.getTree());


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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:504:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY311=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr312 =null;


        CommonTree BY311_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:505:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:505:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY311=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2751); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY311_tree = (CommonTree)adaptor.dupNode(BY311);


            root_1 = (CommonTree)adaptor.becomeRoot(BY311_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:505:13: ( join_group_by_expr )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==BIGDECIMALNUMBER||LA91_0==BIGINTEGERNUMBER||LA91_0==CUBE||LA91_0==DIV||LA91_0==DOLLARVAR||LA91_0==DOUBLENUMBER||LA91_0==FALSE||LA91_0==FLOATNUMBER||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==INTEGER||LA91_0==LONGINTEGER||LA91_0==MINUS||LA91_0==NULL||LA91_0==PERCENT||LA91_0==PLUS||LA91_0==QUOTEDSTRING||LA91_0==STAR||LA91_0==TRUE||(LA91_0 >= BAG_VAL && LA91_0 <= BIN_EXPR)||(LA91_0 >= CASE_COND && LA91_0 <= CASE_EXPR)||(LA91_0 >= CAST_EXPR && LA91_0 <= EXPR_IN_PAREN)||LA91_0==FUNC_EVAL||(LA91_0 >= MAP_VAL && LA91_0 <= NEG)||LA91_0==TUPLE_VAL) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:505:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2753);
            	    join_group_by_expr312=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr312.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt91 >= 1 ) break loop91;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(91, input);
                        throw eee;
                }
                cnt91++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:508:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR315=null;
        AliasMasker.col_range_return col_range313 =null;

        AliasMasker.expr_return expr314 =null;


        CommonTree STAR315_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:509:5: ( col_range | expr | STAR )
            int alt92=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt92=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt92=2;
                }
                break;
            case STAR:
                {
                int LA92_3 = input.LA(2);

                if ( (LA92_3==DOWN) ) {
                    alt92=2;
                }
                else if ( (LA92_3==EOF||LA92_3==UP||LA92_3==BIGDECIMALNUMBER||LA92_3==BIGINTEGERNUMBER||LA92_3==CUBE||LA92_3==DIV||LA92_3==DOLLARVAR||LA92_3==DOUBLENUMBER||LA92_3==FALSE||LA92_3==FLOATNUMBER||LA92_3==GROUP||LA92_3==IDENTIFIER||LA92_3==INTEGER||LA92_3==LONGINTEGER||LA92_3==MINUS||LA92_3==NULL||LA92_3==PERCENT||LA92_3==PLUS||LA92_3==QUOTEDSTRING||LA92_3==STAR||LA92_3==TRUE||(LA92_3 >= BAG_VAL && LA92_3 <= BIN_EXPR)||(LA92_3 >= CASE_COND && LA92_3 <= CASE_EXPR)||(LA92_3 >= CAST_EXPR && LA92_3 <= EXPR_IN_PAREN)||LA92_3==FUNC_EVAL||(LA92_3 >= MAP_VAL && LA92_3 <= NEG)||LA92_3==TUPLE_VAL) ) {
                    alt92=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }

            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:509:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2769);
                    col_range313=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range313.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:509:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2773);
                    expr314=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr314.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:509:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR315=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR315_tree = (CommonTree)adaptor.dupNode(STAR315);


                    adaptor.addChild(root_0, STAR315_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:512:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION316=null;
        CommonTree ONSCHEMA317=null;
        AliasMasker.rel_list_return rel_list318 =null;


        CommonTree UNION316_tree=null;
        CommonTree ONSCHEMA317_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:513:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:513:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION316=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION316_tree = (CommonTree)adaptor.dupNode(UNION316);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION316_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:513:16: ( ONSCHEMA )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==ONSCHEMA) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:513:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA317=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA317_tree = (CommonTree)adaptor.dupNode(ONSCHEMA317);


                    adaptor.addChild(root_1, ONSCHEMA317_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2797);
            rel_list318=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list318.getTree());


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
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:516:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH319=null;
        AliasMasker.rel_return rel320 =null;

        AliasMasker.foreach_plan_return foreach_plan321 =null;


        CommonTree FOREACH319_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:517:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:517:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH319=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH319_tree = (CommonTree)adaptor.dupNode(FOREACH319);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH319_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2816);
            rel320=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel320.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2818);
            foreach_plan321=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan321.getTree());


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
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:520:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE322=null;
        CommonTree FOREACH_PLAN_COMPLEX324=null;
        AliasMasker.generate_clause_return generate_clause323 =null;

        AliasMasker.nested_blk_return nested_blk325 =null;


        CommonTree FOREACH_PLAN_SIMPLE322_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX324_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:521:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==FOREACH_PLAN_SIMPLE) ) {
                alt94=1;
            }
            else if ( (LA94_0==FOREACH_PLAN_COMPLEX) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:521:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE322=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE322_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE322);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE322_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2837);
                    generate_clause323=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause323.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:522:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX324=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX324_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX324);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX324_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2851);
                    nested_blk325=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk325.getTree());


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
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:525:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command326 =null;

        AliasMasker.generate_clause_return generate_clause327 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:526:5: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:526:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:526:7: ( nested_command )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( ((LA95_0 >= NESTED_CMD && LA95_0 <= NESTED_CMD_ASSI)) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:526:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2866);
            	    nested_command326=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command326.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2869);
            generate_clause327=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause327.getTree());


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


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:529:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE328=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item329 =null;


        CommonTree GENERATE328_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:530:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:530:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE328=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE328_tree = (CommonTree)adaptor.dupNode(GENERATE328);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE328_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:530:19: ( flatten_generated_item )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==BIGDECIMALNUMBER||LA96_0==BIGINTEGERNUMBER||LA96_0==CUBE||LA96_0==DIV||LA96_0==DOLLARVAR||LA96_0==DOUBLENUMBER||LA96_0==FALSE||LA96_0==FLATTEN||LA96_0==FLOATNUMBER||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==INTEGER||LA96_0==LONGINTEGER||LA96_0==MINUS||LA96_0==NULL||LA96_0==PERCENT||LA96_0==PLUS||LA96_0==QUOTEDSTRING||LA96_0==STAR||LA96_0==TRUE||(LA96_0 >= BAG_VAL && LA96_0 <= BIN_EXPR)||(LA96_0 >= CASE_COND && LA96_0 <= CASE_EXPR)||(LA96_0 >= CAST_EXPR && LA96_0 <= EXPR_IN_PAREN)||LA96_0==FUNC_EVAL||(LA96_0 >= MAP_VAL && LA96_0 <= NEG)||LA96_0==TUPLE_VAL) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:530:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2886);
            	    flatten_generated_item329=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item329.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:533:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD330=null;
        CommonTree IDENTIFIER331=null;
        CommonTree NESTED_CMD_ASSI333=null;
        CommonTree IDENTIFIER334=null;
        AliasMasker.nested_op_return nested_op332 =null;

        AliasMasker.expr_return expr335 =null;


        CommonTree NESTED_CMD330_tree=null;
        CommonTree IDENTIFIER331_tree=null;
        CommonTree NESTED_CMD_ASSI333_tree=null;
        CommonTree IDENTIFIER334_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:534:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==NESTED_CMD) ) {
                alt97=1;
            }
            else if ( (LA97_0==NESTED_CMD_ASSI) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:534:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD330=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD330_tree = (CommonTree)adaptor.dupNode(NESTED_CMD330);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD330_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER331=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2906); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER331_tree = (CommonTree)adaptor.dupNode(IDENTIFIER331);


                    adaptor.addChild(root_1, IDENTIFIER331_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2908);
                    nested_op332=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op332.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:535:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI333=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI333_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI333);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI333_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER334=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER334_tree = (CommonTree)adaptor.dupNode(IDENTIFIER334);


                    adaptor.addChild(root_1, IDENTIFIER334_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2924);
                    expr335=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr335.getTree());


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
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:538:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj336 =null;

        AliasMasker.nested_filter_return nested_filter337 =null;

        AliasMasker.nested_sort_return nested_sort338 =null;

        AliasMasker.nested_distinct_return nested_distinct339 =null;

        AliasMasker.nested_limit_return nested_limit340 =null;

        AliasMasker.nested_cross_return nested_cross341 =null;

        AliasMasker.nested_foreach_return nested_foreach342 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:538:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt98=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt98=1;
                }
                break;
            case FILTER:
                {
                alt98=2;
                }
                break;
            case ORDER:
                {
                alt98=3;
                }
                break;
            case DISTINCT:
                {
                alt98=4;
                }
                break;
            case LIMIT:
                {
                alt98=5;
                }
                break;
            case CROSS:
                {
                alt98=6;
                }
                break;
            case FOREACH:
                {
                alt98=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;

            }

            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:538:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2935);
                    nested_proj336=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj336.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:539:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2949);
                    nested_filter337=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter337.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:540:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2963);
                    nested_sort338=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort338.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:541:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2977);
                    nested_distinct339=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct339.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:542:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2991);
                    nested_limit340=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit340.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:543:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3005);
                    nested_cross341=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross341.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:544:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3019);
                    nested_foreach342=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach342.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:547:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ343=null;
        AliasMasker.col_ref_return col_ref344 =null;

        AliasMasker.col_ref_return col_ref345 =null;


        CommonTree NESTED_PROJ343_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:548:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:548:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ343=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3034); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ343_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ343);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3036);
            col_ref344=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref344.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:548:30: ( col_ref )+
            int cnt99=0;
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==CUBE||LA99_0==DOLLARVAR||LA99_0==GROUP||LA99_0==IDENTIFIER) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:548:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3038);
            	    col_ref345=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref345.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt99 >= 1 ) break loop99;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(99, input);
                        throw eee;
                }
                cnt99++;
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
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:551:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER346=null;
        AliasMasker.nested_op_input_return nested_op_input347 =null;

        AliasMasker.cond_return cond348 =null;


        CommonTree FILTER346_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:552:5: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:552:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER346=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER346_tree = (CommonTree)adaptor.dupNode(FILTER346);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER346_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3058);
            nested_op_input347=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input347.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3060);
            cond348=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond348.getTree());


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
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:555:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER349=null;
        AliasMasker.nested_op_input_return nested_op_input350 =null;

        AliasMasker.order_by_clause_return order_by_clause351 =null;

        AliasMasker.func_clause_return func_clause352 =null;


        CommonTree ORDER349_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:556:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:556:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER349=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3077); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER349_tree = (CommonTree)adaptor.dupNode(ORDER349);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER349_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3079);
            nested_op_input350=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input350.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3081);
            order_by_clause351=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause351.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:556:48: ( func_clause )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FUNC||LA100_0==FUNC_REF) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:556:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3083);
                    func_clause352=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause352.getTree());


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
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:559:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT353=null;
        AliasMasker.nested_op_input_return nested_op_input354 =null;


        CommonTree DISTINCT353_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:560:5: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:560:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT353=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT353_tree = (CommonTree)adaptor.dupNode(DISTINCT353);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT353_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3103);
            nested_op_input354=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input354.getTree());


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
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:563:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT355=null;
        CommonTree INTEGER357=null;
        AliasMasker.nested_op_input_return nested_op_input356 =null;

        AliasMasker.expr_return expr358 =null;


        CommonTree LIMIT355_tree=null;
        CommonTree INTEGER357_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT355=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT355_tree = (CommonTree)adaptor.dupNode(LIMIT355);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT355_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3122);
            nested_op_input356=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input356.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:32: ( INTEGER | expr )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==INTEGER) ) {
                int LA101_1 = input.LA(2);

                if ( (synpred181_AliasMasker()) ) {
                    alt101=1;
                }
                else if ( (true) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA101_0==BIGDECIMALNUMBER||LA101_0==BIGINTEGERNUMBER||LA101_0==CUBE||LA101_0==DIV||LA101_0==DOLLARVAR||LA101_0==DOUBLENUMBER||LA101_0==FALSE||LA101_0==FLOATNUMBER||LA101_0==GROUP||LA101_0==IDENTIFIER||LA101_0==LONGINTEGER||LA101_0==MINUS||LA101_0==NULL||LA101_0==PERCENT||LA101_0==PLUS||LA101_0==QUOTEDSTRING||LA101_0==STAR||LA101_0==TRUE||(LA101_0 >= BAG_VAL && LA101_0 <= BIN_EXPR)||(LA101_0 >= CASE_COND && LA101_0 <= CASE_EXPR)||LA101_0==CAST_EXPR||LA101_0==EXPR_IN_PAREN||LA101_0==FUNC_EVAL||(LA101_0 >= MAP_VAL && LA101_0 <= NEG)||LA101_0==TUPLE_VAL) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER357=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3126); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER357_tree = (CommonTree)adaptor.dupNode(INTEGER357);


                    adaptor.addChild(root_1, INTEGER357_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3130);
                    expr358=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr358.getTree());


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
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:567:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS359=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list360 =null;


        CommonTree CROSS359_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:567:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:567:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS359=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS359_tree = (CommonTree)adaptor.dupNode(CROSS359);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS359_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3147);
            nested_op_input_list360=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list360.getTree());


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
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:570:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH361=null;
        AliasMasker.nested_op_input_return nested_op_input362 =null;

        AliasMasker.generate_clause_return generate_clause363 =null;


        CommonTree FOREACH361_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:570:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:570:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH361=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH361_tree = (CommonTree)adaptor.dupNode(FOREACH361);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH361_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3162);
            nested_op_input362=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input362.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3164);
            generate_clause363=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause363.getTree());


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
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:573:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input364 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:573:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:573:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:573:24: ( nested_op_input )+
            int cnt102=0;
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==CUBE||LA102_0==DOLLARVAR||LA102_0==GROUP||LA102_0==IDENTIFIER||LA102_0==NESTED_PROJ) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:573:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3175);
            	    nested_op_input364=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input364.getTree());


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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:576:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref365 =null;

        AliasMasker.nested_proj_return nested_proj366 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:576:17: ( col_ref | nested_proj )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==CUBE||LA103_0==DOLLARVAR||LA103_0==GROUP||LA103_0==IDENTIFIER) ) {
                alt103=1;
            }
            else if ( (LA103_0==NESTED_PROJ) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:576:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3185);
                    col_ref365=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref365.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:576:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3189);
                    nested_proj366=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj366.getTree());


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


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:579:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM367=null;
        CommonTree set369=null;
        AliasMasker.rel_return rel368 =null;

        AliasMasker.as_clause_return as_clause370 =null;


        CommonTree STREAM367_tree=null;
        CommonTree set369_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:580:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:580:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM367=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM367_tree = (CommonTree)adaptor.dupNode(STREAM367);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM367_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3206);
            rel368=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel368.getTree());


            _last = (CommonTree)input.LT(1);
            set369=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set369_tree = (CommonTree)adaptor.dupNode(set369);


                adaptor.addChild(root_1, set369_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:580:50: ( as_clause )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==AS) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:580:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3218);
                    as_clause370=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause370.getTree());


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
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:583:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE371=null;
        CommonTree QUOTEDSTRING372=null;
        CommonTree EXECCOMMAND376=null;
        AliasMasker.path_list_return path_list373 =null;

        AliasMasker.store_clause_return store_clause374 =null;

        AliasMasker.load_clause_return load_clause375 =null;


        CommonTree MAPREDUCE371_tree=null;
        CommonTree QUOTEDSTRING372_tree=null;
        CommonTree EXECCOMMAND376_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE371=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE371_tree = (CommonTree)adaptor.dupNode(MAPREDUCE371);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE371_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING372=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING372_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING372);


            adaptor.addChild(root_1, QUOTEDSTRING372_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:33: ( path_list )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==QUOTEDSTRING) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3240);
                    path_list373=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list373.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3243);
            store_clause374=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause374.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3245);
            load_clause375=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause375.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:69: ( EXECCOMMAND )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==EXECCOMMAND) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:584:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND376=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND376_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND376);


                    adaptor.addChild(root_1, EXECCOMMAND376_tree);
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
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:587:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT377=null;
        AliasMasker.rel_return rel378 =null;

        AliasMasker.split_branch_return split_branch379 =null;

        AliasMasker.split_otherwise_return split_otherwise380 =null;


        CommonTree SPLIT377_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT377=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT377_tree = (CommonTree)adaptor.dupNode(SPLIT377);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT377_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3267);
            rel378=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel378.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:20: ( split_branch )+
            int cnt107=0;
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==SPLIT_BRANCH) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3269);
            	    split_branch379=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch379.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt107 >= 1 ) break loop107;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(107, input);
                        throw eee;
                }
                cnt107++;
            } while (true);


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:34: ( split_otherwise )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==OTHERWISE) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:588:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3272);
                    split_otherwise380=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise380.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:591:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH381=null;
        AliasMasker.alias_return alias382 =null;

        AliasMasker.cond_return cond383 =null;


        CommonTree SPLIT_BRANCH381_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:592:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:592:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH381=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3290); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH381_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH381);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH381_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3292);
            alias382=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias382.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3294);
            cond383=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond383.getTree());


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
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:595:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE384=null;
        AliasMasker.alias_return alias385 =null;


        CommonTree OTHERWISE384_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:596:5: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:596:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE384=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE384_tree = (CommonTree)adaptor.dupNode(OTHERWISE384);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE384_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3313);
            alias385=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias385.getTree());


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
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:599:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref386 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref387 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:599:9: ( alias_col_ref | dollar_col_ref )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==CUBE||LA109_0==GROUP||LA109_0==IDENTIFIER) ) {
                alt109=1;
            }
            else if ( (LA109_0==DOLLARVAR) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:599:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3324);
                    alias_col_ref386=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref386.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:599:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3328);
                    dollar_col_ref387=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref387.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:602:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP388=null;
        CommonTree CUBE389=null;
        CommonTree IDENTIFIER390=null;

        CommonTree GROUP388_tree=null;
        CommonTree CUBE389_tree=null;
        CommonTree IDENTIFIER390_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:603:5: ( GROUP | CUBE | IDENTIFIER )
            int alt110=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt110=1;
                }
                break;
            case CUBE:
                {
                alt110=2;
                }
                break;
            case IDENTIFIER:
                {
                alt110=3;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:603:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP388=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3341); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP388_tree = (CommonTree)adaptor.dupNode(GROUP388);


                    adaptor.addChild(root_0, GROUP388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:604:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE389=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref3349); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE389_tree = (CommonTree)adaptor.dupNode(CUBE389);


                    adaptor.addChild(root_0, CUBE389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:605:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER390=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER390_tree = (CommonTree)adaptor.dupNode(IDENTIFIER390);


                    adaptor.addChild(root_0, IDENTIFIER390_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER390!=null?IDENTIFIER390.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER390.token.setText( sb.toString() );
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:620:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR391=null;

        CommonTree DOLLARVAR391_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:621:5: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:621:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR391=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR391_tree = (CommonTree)adaptor.dupNode(DOLLARVAR391);


            adaptor.addChild(root_0, DOLLARVAR391_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:624:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal392 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:624:12: ( literal )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:624:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3387);
            literal392=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal392.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar393 =null;

        AliasMasker.map_return map394 =null;

        AliasMasker.bag_return bag395 =null;

        AliasMasker.tuple_return tuple396 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:9: ( scalar | map | bag | tuple )
            int alt111=4;
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
                alt111=1;
                }
                break;
            case MAP_VAL:
                {
                alt111=2;
                }
                break;
            case BAG_VAL:
                {
                alt111=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt111=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }

            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3396);
                    scalar393=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar393.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3400);
                    map394=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map394.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3404);
                    bag395=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag395.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:627:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3408);
                    tuple396=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple396.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING398=null;
        CommonTree NULL399=null;
        CommonTree TRUE400=null;
        CommonTree FALSE401=null;
        AliasMasker.num_scalar_return num_scalar397 =null;


        CommonTree QUOTEDSTRING398_tree=null;
        CommonTree NULL399_tree=null;
        CommonTree TRUE400_tree=null;
        CommonTree FALSE401_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt112=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt112=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt112=2;
                }
                break;
            case NULL:
                {
                alt112=3;
                }
                break;
            case TRUE:
                {
                alt112=4;
                }
                break;
            case FALSE:
                {
                alt112=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }

            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3417);
                    num_scalar397=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar397.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING398=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3421); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING398_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING398);


                    adaptor.addChild(root_0, QUOTEDSTRING398_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL399=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL399_tree = (CommonTree)adaptor.dupNode(NULL399);


                    adaptor.addChild(root_0, NULL399_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE400=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE400_tree = (CommonTree)adaptor.dupNode(TRUE400);


                    adaptor.addChild(root_0, TRUE400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:630:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE401=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE401_tree = (CommonTree)adaptor.dupNode(FALSE401);


                    adaptor.addChild(root_0, FALSE401_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:633:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AliasMasker.num_scalar_return num_scalar() throws RecognitionException {
        AliasMasker.num_scalar_return retval = new AliasMasker.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS402=null;
        CommonTree set403=null;

        CommonTree MINUS402_tree=null;
        CommonTree set403_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:633:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:633:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:633:14: ( MINUS )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==MINUS) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:633:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS402=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS402_tree = (CommonTree)adaptor.dupNode(MINUS402);


                    adaptor.addChild(root_0, MINUS402_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set403=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set403_tree = (CommonTree)adaptor.dupNode(set403);


                adaptor.addChild(root_0, set403_tree);
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
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:636:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL404=null;
        AliasMasker.keyvalue_return keyvalue405 =null;


        CommonTree MAP_VAL404_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:637:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:637:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL404=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3484); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL404_tree = (CommonTree)adaptor.dupNode(MAP_VAL404);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL404_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:637:18: ( keyvalue )*
                loop114:
                do {
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==KEY_VAL_PAIR) ) {
                        alt114=1;
                    }


                    switch (alt114) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:637:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3486);
                	    keyvalue405=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue405.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop114;
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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:640:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR406=null;
        AliasMasker.map_key_return map_key407 =null;

        AliasMasker.const_expr_return const_expr408 =null;


        CommonTree KEY_VAL_PAIR406_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:641:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:641:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR406=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3504); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR406_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR406);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR406_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3506);
            map_key407=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key407.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3508);
            const_expr408=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr408.getTree());


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
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:644:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING409=null;

        CommonTree QUOTEDSTRING409_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:644:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:644:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING409=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING409_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING409);


            adaptor.addChild(root_0, QUOTEDSTRING409_tree);
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
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:647:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL410=null;
        AliasMasker.tuple_return tuple411 =null;


        CommonTree BAG_VAL410_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:648:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:648:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL410=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3534); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL410_tree = (CommonTree)adaptor.dupNode(BAG_VAL410);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL410_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:648:18: ( tuple )*
                loop115:
                do {
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==TUPLE_VAL) ) {
                        alt115=1;
                    }


                    switch (alt115) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:648:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3536);
                	    tuple411=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple411.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop115;
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
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:651:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL412=null;
        AliasMasker.literal_return literal413 =null;


        CommonTree TUPLE_VAL412_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:652:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:652:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL412=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL412_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL412);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL412_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:652:20: ( literal )*
                loop116:
                do {
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==BIGDECIMALNUMBER||LA116_0==BIGINTEGERNUMBER||LA116_0==DOUBLENUMBER||LA116_0==FALSE||LA116_0==FLOATNUMBER||LA116_0==INTEGER||LA116_0==LONGINTEGER||LA116_0==MINUS||LA116_0==NULL||LA116_0==QUOTEDSTRING||LA116_0==TRUE||LA116_0==BAG_VAL||LA116_0==MAP_VAL||LA116_0==TUPLE_VAL) ) {
                        alt116=1;
                    }


                    switch (alt116) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:652:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3556);
                	    literal413=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal413.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop116;
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
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:656:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT415=null;
        CommonTree RETURNS416=null;
        CommonTree DEFINE417=null;
        CommonTree LOAD418=null;
        CommonTree FILTER419=null;
        CommonTree FOREACH420=null;
        CommonTree CUBE421=null;
        CommonTree ROLLUP422=null;
        CommonTree PIVOT423=null;
        CommonTree CHUNKSIZE424=null;
        CommonTree RATE425=null;
        CommonTree MATCHES426=null;
        CommonTree ORDER427=null;
        CommonTree RANK428=null;
        CommonTree DISTINCT429=null;
        CommonTree COGROUP430=null;
        CommonTree JOIN431=null;
        CommonTree CROSS432=null;
        CommonTree UNION433=null;
        CommonTree SPLIT434=null;
        CommonTree INTO435=null;
        CommonTree IF436=null;
        CommonTree ALL437=null;
        CommonTree AS438=null;
        CommonTree BY439=null;
        CommonTree USING440=null;
        CommonTree INNER441=null;
        CommonTree OUTER442=null;
        CommonTree PARALLEL443=null;
        CommonTree PARTITION444=null;
        CommonTree GROUP445=null;
        CommonTree AND446=null;
        CommonTree OR447=null;
        CommonTree NOT448=null;
        CommonTree GENERATE449=null;
        CommonTree FLATTEN450=null;
        CommonTree EVAL451=null;
        CommonTree ASC452=null;
        CommonTree DESC453=null;
        CommonTree BOOLEAN454=null;
        CommonTree INT455=null;
        CommonTree LONG456=null;
        CommonTree FLOAT457=null;
        CommonTree DOUBLE458=null;
        CommonTree DATETIME459=null;
        CommonTree CHARARRAY460=null;
        CommonTree BIGINTEGER461=null;
        CommonTree BIGDECIMAL462=null;
        CommonTree BYTEARRAY463=null;
        CommonTree BAG464=null;
        CommonTree TUPLE465=null;
        CommonTree MAP466=null;
        CommonTree IS467=null;
        CommonTree NULL468=null;
        CommonTree TRUE469=null;
        CommonTree FALSE470=null;
        CommonTree STREAM471=null;
        CommonTree THROUGH472=null;
        CommonTree STORE473=null;
        CommonTree MAPREDUCE474=null;
        CommonTree SHIP475=null;
        CommonTree CACHE476=null;
        CommonTree INPUT477=null;
        CommonTree OUTPUT478=null;
        CommonTree STDERROR479=null;
        CommonTree STDIN480=null;
        CommonTree STDOUT481=null;
        CommonTree LIMIT482=null;
        CommonTree SAMPLE483=null;
        CommonTree LEFT484=null;
        CommonTree RIGHT485=null;
        CommonTree FULL486=null;
        CommonTree IDENTIFIER487=null;
        CommonTree TOBAG488=null;
        CommonTree TOMAP489=null;
        CommonTree TOTUPLE490=null;
        CommonTree ASSERT491=null;
        AliasMasker.rel_str_op_return rel_str_op414 =null;


        CommonTree IMPORT415_tree=null;
        CommonTree RETURNS416_tree=null;
        CommonTree DEFINE417_tree=null;
        CommonTree LOAD418_tree=null;
        CommonTree FILTER419_tree=null;
        CommonTree FOREACH420_tree=null;
        CommonTree CUBE421_tree=null;
        CommonTree ROLLUP422_tree=null;
        CommonTree PIVOT423_tree=null;
        CommonTree CHUNKSIZE424_tree=null;
        CommonTree RATE425_tree=null;
        CommonTree MATCHES426_tree=null;
        CommonTree ORDER427_tree=null;
        CommonTree RANK428_tree=null;
        CommonTree DISTINCT429_tree=null;
        CommonTree COGROUP430_tree=null;
        CommonTree JOIN431_tree=null;
        CommonTree CROSS432_tree=null;
        CommonTree UNION433_tree=null;
        CommonTree SPLIT434_tree=null;
        CommonTree INTO435_tree=null;
        CommonTree IF436_tree=null;
        CommonTree ALL437_tree=null;
        CommonTree AS438_tree=null;
        CommonTree BY439_tree=null;
        CommonTree USING440_tree=null;
        CommonTree INNER441_tree=null;
        CommonTree OUTER442_tree=null;
        CommonTree PARALLEL443_tree=null;
        CommonTree PARTITION444_tree=null;
        CommonTree GROUP445_tree=null;
        CommonTree AND446_tree=null;
        CommonTree OR447_tree=null;
        CommonTree NOT448_tree=null;
        CommonTree GENERATE449_tree=null;
        CommonTree FLATTEN450_tree=null;
        CommonTree EVAL451_tree=null;
        CommonTree ASC452_tree=null;
        CommonTree DESC453_tree=null;
        CommonTree BOOLEAN454_tree=null;
        CommonTree INT455_tree=null;
        CommonTree LONG456_tree=null;
        CommonTree FLOAT457_tree=null;
        CommonTree DOUBLE458_tree=null;
        CommonTree DATETIME459_tree=null;
        CommonTree CHARARRAY460_tree=null;
        CommonTree BIGINTEGER461_tree=null;
        CommonTree BIGDECIMAL462_tree=null;
        CommonTree BYTEARRAY463_tree=null;
        CommonTree BAG464_tree=null;
        CommonTree TUPLE465_tree=null;
        CommonTree MAP466_tree=null;
        CommonTree IS467_tree=null;
        CommonTree NULL468_tree=null;
        CommonTree TRUE469_tree=null;
        CommonTree FALSE470_tree=null;
        CommonTree STREAM471_tree=null;
        CommonTree THROUGH472_tree=null;
        CommonTree STORE473_tree=null;
        CommonTree MAPREDUCE474_tree=null;
        CommonTree SHIP475_tree=null;
        CommonTree CACHE476_tree=null;
        CommonTree INPUT477_tree=null;
        CommonTree OUTPUT478_tree=null;
        CommonTree STDERROR479_tree=null;
        CommonTree STDIN480_tree=null;
        CommonTree STDOUT481_tree=null;
        CommonTree LIMIT482_tree=null;
        CommonTree SAMPLE483_tree=null;
        CommonTree LEFT484_tree=null;
        CommonTree RIGHT485_tree=null;
        CommonTree FULL486_tree=null;
        CommonTree IDENTIFIER487_tree=null;
        CommonTree TOBAG488_tree=null;
        CommonTree TOMAP489_tree=null;
        CommonTree TOTUPLE490_tree=null;
        CommonTree ASSERT491_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:656:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt117=78;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt117=1;
                }
                break;
            case IMPORT:
                {
                alt117=2;
                }
                break;
            case RETURNS:
                {
                alt117=3;
                }
                break;
            case DEFINE:
                {
                alt117=4;
                }
                break;
            case LOAD:
                {
                alt117=5;
                }
                break;
            case FILTER:
                {
                alt117=6;
                }
                break;
            case FOREACH:
                {
                alt117=7;
                }
                break;
            case CUBE:
                {
                alt117=8;
                }
                break;
            case ROLLUP:
                {
                alt117=9;
                }
                break;
            case PIVOT:
                {
                alt117=10;
                }
                break;
            case CHUNKSIZE:
                {
                alt117=11;
                }
                break;
            case RATE:
                {
                alt117=12;
                }
                break;
            case MATCHES:
                {
                alt117=13;
                }
                break;
            case ORDER:
                {
                alt117=14;
                }
                break;
            case RANK:
                {
                alt117=15;
                }
                break;
            case DISTINCT:
                {
                alt117=16;
                }
                break;
            case COGROUP:
                {
                alt117=17;
                }
                break;
            case JOIN:
                {
                alt117=18;
                }
                break;
            case CROSS:
                {
                alt117=19;
                }
                break;
            case UNION:
                {
                alt117=20;
                }
                break;
            case SPLIT:
                {
                alt117=21;
                }
                break;
            case INTO:
                {
                alt117=22;
                }
                break;
            case IF:
                {
                alt117=23;
                }
                break;
            case ALL:
                {
                alt117=24;
                }
                break;
            case AS:
                {
                alt117=25;
                }
                break;
            case BY:
                {
                alt117=26;
                }
                break;
            case USING:
                {
                alt117=27;
                }
                break;
            case INNER:
                {
                alt117=28;
                }
                break;
            case OUTER:
                {
                alt117=29;
                }
                break;
            case PARALLEL:
                {
                alt117=30;
                }
                break;
            case PARTITION:
                {
                alt117=31;
                }
                break;
            case GROUP:
                {
                alt117=32;
                }
                break;
            case AND:
                {
                alt117=33;
                }
                break;
            case OR:
                {
                alt117=34;
                }
                break;
            case NOT:
                {
                alt117=35;
                }
                break;
            case GENERATE:
                {
                alt117=36;
                }
                break;
            case FLATTEN:
                {
                alt117=37;
                }
                break;
            case EVAL:
                {
                alt117=38;
                }
                break;
            case ASC:
                {
                alt117=39;
                }
                break;
            case DESC:
                {
                alt117=40;
                }
                break;
            case BOOLEAN:
                {
                alt117=41;
                }
                break;
            case INT:
                {
                alt117=42;
                }
                break;
            case LONG:
                {
                alt117=43;
                }
                break;
            case FLOAT:
                {
                alt117=44;
                }
                break;
            case DOUBLE:
                {
                alt117=45;
                }
                break;
            case DATETIME:
                {
                alt117=46;
                }
                break;
            case CHARARRAY:
                {
                alt117=47;
                }
                break;
            case BIGINTEGER:
                {
                alt117=48;
                }
                break;
            case BIGDECIMAL:
                {
                alt117=49;
                }
                break;
            case BYTEARRAY:
                {
                alt117=50;
                }
                break;
            case BAG:
                {
                alt117=51;
                }
                break;
            case TUPLE:
                {
                alt117=52;
                }
                break;
            case MAP:
                {
                alt117=53;
                }
                break;
            case IS:
                {
                alt117=54;
                }
                break;
            case NULL:
                {
                alt117=55;
                }
                break;
            case TRUE:
                {
                alt117=56;
                }
                break;
            case FALSE:
                {
                alt117=57;
                }
                break;
            case STREAM:
                {
                alt117=58;
                }
                break;
            case THROUGH:
                {
                alt117=59;
                }
                break;
            case STORE:
                {
                alt117=60;
                }
                break;
            case MAPREDUCE:
                {
                alt117=61;
                }
                break;
            case SHIP:
                {
                alt117=62;
                }
                break;
            case CACHE:
                {
                alt117=63;
                }
                break;
            case INPUT:
                {
                alt117=64;
                }
                break;
            case OUTPUT:
                {
                alt117=65;
                }
                break;
            case STDERROR:
                {
                alt117=66;
                }
                break;
            case STDIN:
                {
                alt117=67;
                }
                break;
            case STDOUT:
                {
                alt117=68;
                }
                break;
            case LIMIT:
                {
                alt117=69;
                }
                break;
            case SAMPLE:
                {
                alt117=70;
                }
                break;
            case LEFT:
                {
                alt117=71;
                }
                break;
            case RIGHT:
                {
                alt117=72;
                }
                break;
            case FULL:
                {
                alt117=73;
                }
                break;
            case IDENTIFIER:
                {
                alt117=74;
                }
                break;
            case TOBAG:
                {
                alt117=75;
                }
                break;
            case TOMAP:
                {
                alt117=76;
                }
                break;
            case TOTUPLE:
                {
                alt117=77;
                }
                break;
            case ASSERT:
                {
                alt117=78;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }

            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:656:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3569);
                    rel_str_op414=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op414.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:657:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT415=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT415_tree = (CommonTree)adaptor.dupNode(IMPORT415);


                    adaptor.addChild(root_0, IMPORT415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:658:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS416=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS416_tree = (CommonTree)adaptor.dupNode(RETURNS416);


                    adaptor.addChild(root_0, RETURNS416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:659:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE417=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE417_tree = (CommonTree)adaptor.dupNode(DEFINE417);


                    adaptor.addChild(root_0, DEFINE417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:660:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD418=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD418_tree = (CommonTree)adaptor.dupNode(LOAD418);


                    adaptor.addChild(root_0, LOAD418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:661:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER419=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER419_tree = (CommonTree)adaptor.dupNode(FILTER419);


                    adaptor.addChild(root_0, FILTER419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:662:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH420=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH420_tree = (CommonTree)adaptor.dupNode(FOREACH420);


                    adaptor.addChild(root_0, FOREACH420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:663:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE421=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE421_tree = (CommonTree)adaptor.dupNode(CUBE421);


                    adaptor.addChild(root_0, CUBE421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:664:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP422=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP422_tree = (CommonTree)adaptor.dupNode(ROLLUP422);


                    adaptor.addChild(root_0, ROLLUP422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:665:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT423=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid3641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT423_tree = (CommonTree)adaptor.dupNode(PIVOT423);


                    adaptor.addChild(root_0, PIVOT423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:666:7: CHUNKSIZE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHUNKSIZE424=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_eid3649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHUNKSIZE424_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE424);


                    adaptor.addChild(root_0, CHUNKSIZE424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:667:7: RATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RATE425=(CommonTree)match(input,RATE,FOLLOW_RATE_in_eid3657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RATE425_tree = (CommonTree)adaptor.dupNode(RATE425);


                    adaptor.addChild(root_0, RATE425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:668:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES426=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES426_tree = (CommonTree)adaptor.dupNode(MATCHES426);


                    adaptor.addChild(root_0, MATCHES426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:669:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER427=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3673); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER427_tree = (CommonTree)adaptor.dupNode(ORDER427);


                    adaptor.addChild(root_0, ORDER427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:670:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK428=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK428_tree = (CommonTree)adaptor.dupNode(RANK428);


                    adaptor.addChild(root_0, RANK428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:671:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT429=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT429_tree = (CommonTree)adaptor.dupNode(DISTINCT429);


                    adaptor.addChild(root_0, DISTINCT429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:672:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP430=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP430_tree = (CommonTree)adaptor.dupNode(COGROUP430);


                    adaptor.addChild(root_0, COGROUP430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:673:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN431=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3705); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN431_tree = (CommonTree)adaptor.dupNode(JOIN431);


                    adaptor.addChild(root_0, JOIN431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:674:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS432=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS432_tree = (CommonTree)adaptor.dupNode(CROSS432);


                    adaptor.addChild(root_0, CROSS432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:675:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION433=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION433_tree = (CommonTree)adaptor.dupNode(UNION433);


                    adaptor.addChild(root_0, UNION433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:676:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT434=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT434_tree = (CommonTree)adaptor.dupNode(SPLIT434);


                    adaptor.addChild(root_0, SPLIT434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:677:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO435=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3737); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO435_tree = (CommonTree)adaptor.dupNode(INTO435);


                    adaptor.addChild(root_0, INTO435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:678:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF436=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF436_tree = (CommonTree)adaptor.dupNode(IF436);


                    adaptor.addChild(root_0, IF436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:679:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL437=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL437_tree = (CommonTree)adaptor.dupNode(ALL437);


                    adaptor.addChild(root_0, ALL437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:680:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS438=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS438_tree = (CommonTree)adaptor.dupNode(AS438);


                    adaptor.addChild(root_0, AS438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:681:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY439=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY439_tree = (CommonTree)adaptor.dupNode(BY439);


                    adaptor.addChild(root_0, BY439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:682:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING440=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING440_tree = (CommonTree)adaptor.dupNode(USING440);


                    adaptor.addChild(root_0, USING440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:683:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER441=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER441_tree = (CommonTree)adaptor.dupNode(INNER441);


                    adaptor.addChild(root_0, INNER441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:684:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER442=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3793); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER442_tree = (CommonTree)adaptor.dupNode(OUTER442);


                    adaptor.addChild(root_0, OUTER442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:685:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL443=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL443_tree = (CommonTree)adaptor.dupNode(PARALLEL443);


                    adaptor.addChild(root_0, PARALLEL443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:686:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION444=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION444_tree = (CommonTree)adaptor.dupNode(PARTITION444);


                    adaptor.addChild(root_0, PARTITION444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:687:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP445=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3817); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP445_tree = (CommonTree)adaptor.dupNode(GROUP445);


                    adaptor.addChild(root_0, GROUP445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:688:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND446=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3825); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND446_tree = (CommonTree)adaptor.dupNode(AND446);


                    adaptor.addChild(root_0, AND446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:689:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR447=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3833); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR447_tree = (CommonTree)adaptor.dupNode(OR447);


                    adaptor.addChild(root_0, OR447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:690:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT448=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3841); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT448_tree = (CommonTree)adaptor.dupNode(NOT448);


                    adaptor.addChild(root_0, NOT448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:691:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE449=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE449_tree = (CommonTree)adaptor.dupNode(GENERATE449);


                    adaptor.addChild(root_0, GENERATE449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:692:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN450=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN450_tree = (CommonTree)adaptor.dupNode(FLATTEN450);


                    adaptor.addChild(root_0, FLATTEN450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:693:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL451=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL451_tree = (CommonTree)adaptor.dupNode(EVAL451);


                    adaptor.addChild(root_0, EVAL451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:694:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC452=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3873); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC452_tree = (CommonTree)adaptor.dupNode(ASC452);


                    adaptor.addChild(root_0, ASC452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:695:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC453=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC453_tree = (CommonTree)adaptor.dupNode(DESC453);


                    adaptor.addChild(root_0, DESC453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:696:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN454=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN454_tree = (CommonTree)adaptor.dupNode(BOOLEAN454);


                    adaptor.addChild(root_0, BOOLEAN454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:697:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT455=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT455_tree = (CommonTree)adaptor.dupNode(INT455);


                    adaptor.addChild(root_0, INT455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:698:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG456=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG456_tree = (CommonTree)adaptor.dupNode(LONG456);


                    adaptor.addChild(root_0, LONG456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:699:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT457=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT457_tree = (CommonTree)adaptor.dupNode(FLOAT457);


                    adaptor.addChild(root_0, FLOAT457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:700:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE458=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3921); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE458_tree = (CommonTree)adaptor.dupNode(DOUBLE458);


                    adaptor.addChild(root_0, DOUBLE458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:701:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME459=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME459_tree = (CommonTree)adaptor.dupNode(DATETIME459);


                    adaptor.addChild(root_0, DATETIME459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:702:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY460=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY460_tree = (CommonTree)adaptor.dupNode(CHARARRAY460);


                    adaptor.addChild(root_0, CHARARRAY460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:703:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER461=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3945); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER461_tree = (CommonTree)adaptor.dupNode(BIGINTEGER461);


                    adaptor.addChild(root_0, BIGINTEGER461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:704:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL462=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL462_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL462);


                    adaptor.addChild(root_0, BIGDECIMAL462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:705:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY463=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY463_tree = (CommonTree)adaptor.dupNode(BYTEARRAY463);


                    adaptor.addChild(root_0, BYTEARRAY463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:706:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG464=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG464_tree = (CommonTree)adaptor.dupNode(BAG464);


                    adaptor.addChild(root_0, BAG464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:707:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE465=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3977); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE465_tree = (CommonTree)adaptor.dupNode(TUPLE465);


                    adaptor.addChild(root_0, TUPLE465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:708:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP466=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3985); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP466_tree = (CommonTree)adaptor.dupNode(MAP466);


                    adaptor.addChild(root_0, MAP466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:709:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS467=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3993); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS467_tree = (CommonTree)adaptor.dupNode(IS467);


                    adaptor.addChild(root_0, IS467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:710:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL468=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid4001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL468_tree = (CommonTree)adaptor.dupNode(NULL468);


                    adaptor.addChild(root_0, NULL468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:711:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE469=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid4009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE469_tree = (CommonTree)adaptor.dupNode(TRUE469);


                    adaptor.addChild(root_0, TRUE469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:712:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE470=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid4017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE470_tree = (CommonTree)adaptor.dupNode(FALSE470);


                    adaptor.addChild(root_0, FALSE470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:713:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM471=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid4025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM471_tree = (CommonTree)adaptor.dupNode(STREAM471);


                    adaptor.addChild(root_0, STREAM471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:714:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH472=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid4033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH472_tree = (CommonTree)adaptor.dupNode(THROUGH472);


                    adaptor.addChild(root_0, THROUGH472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:715:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE473=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid4041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE473_tree = (CommonTree)adaptor.dupNode(STORE473);


                    adaptor.addChild(root_0, STORE473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:716:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE474=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid4049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE474_tree = (CommonTree)adaptor.dupNode(MAPREDUCE474);


                    adaptor.addChild(root_0, MAPREDUCE474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:717:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP475=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid4057); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP475_tree = (CommonTree)adaptor.dupNode(SHIP475);


                    adaptor.addChild(root_0, SHIP475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:718:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE476=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid4065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE476_tree = (CommonTree)adaptor.dupNode(CACHE476);


                    adaptor.addChild(root_0, CACHE476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:719:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT477=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid4073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT477_tree = (CommonTree)adaptor.dupNode(INPUT477);


                    adaptor.addChild(root_0, INPUT477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:720:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT478=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid4081); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT478_tree = (CommonTree)adaptor.dupNode(OUTPUT478);


                    adaptor.addChild(root_0, OUTPUT478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:721:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR479=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid4089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR479_tree = (CommonTree)adaptor.dupNode(STDERROR479);


                    adaptor.addChild(root_0, STDERROR479_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:722:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN480=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid4097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN480_tree = (CommonTree)adaptor.dupNode(STDIN480);


                    adaptor.addChild(root_0, STDIN480_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:723:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT481=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid4105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT481_tree = (CommonTree)adaptor.dupNode(STDOUT481);


                    adaptor.addChild(root_0, STDOUT481_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:724:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT482=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT482_tree = (CommonTree)adaptor.dupNode(LIMIT482);


                    adaptor.addChild(root_0, LIMIT482_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:725:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE483=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE483_tree = (CommonTree)adaptor.dupNode(SAMPLE483);


                    adaptor.addChild(root_0, SAMPLE483_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:726:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT484=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT484_tree = (CommonTree)adaptor.dupNode(LEFT484);


                    adaptor.addChild(root_0, LEFT484_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:727:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT485=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT485_tree = (CommonTree)adaptor.dupNode(RIGHT485);


                    adaptor.addChild(root_0, RIGHT485_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:728:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL486=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL486_tree = (CommonTree)adaptor.dupNode(FULL486);


                    adaptor.addChild(root_0, FULL486_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:729:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER487=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER487_tree = (CommonTree)adaptor.dupNode(IDENTIFIER487);


                    adaptor.addChild(root_0, IDENTIFIER487_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:730:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG488=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4161); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG488_tree = (CommonTree)adaptor.dupNode(TOBAG488);


                    adaptor.addChild(root_0, TOBAG488_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:731:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP489=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP489_tree = (CommonTree)adaptor.dupNode(TOMAP489);


                    adaptor.addChild(root_0, TOMAP489_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 77 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:732:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE490=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE490_tree = (CommonTree)adaptor.dupNode(TOTUPLE490);


                    adaptor.addChild(root_0, TOTUPLE490_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 78 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:733:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT491=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT491_tree = (CommonTree)adaptor.dupNode(ASSERT491);


                    adaptor.addChild(root_0, ASSERT491_tree);
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
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:737:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES498=null;
        AliasMasker.rel_op_eq_return rel_op_eq492 =null;

        AliasMasker.rel_op_ne_return rel_op_ne493 =null;

        AliasMasker.rel_op_gt_return rel_op_gt494 =null;

        AliasMasker.rel_op_gte_return rel_op_gte495 =null;

        AliasMasker.rel_op_lt_return rel_op_lt496 =null;

        AliasMasker.rel_op_lte_return rel_op_lte497 =null;


        CommonTree STR_OP_MATCHES498_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:738:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt118=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt118=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt118=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt118=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt118=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt118=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt118=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt118=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;

            }

            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:738:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4199);
                    rel_op_eq492=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq492.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:739:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4207);
                    rel_op_ne493=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne493.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:740:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4215);
                    rel_op_gt494=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt494.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:741:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4223);
                    rel_op_gte495=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte495.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:742:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4231);
                    rel_op_lt496=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt496.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:743:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4239);
                    rel_op_lte497=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte497.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:744:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES498=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES498_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES498);


                    adaptor.addChild(root_0, STR_OP_MATCHES498_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:747:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set499=null;

        CommonTree set499_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:748:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set499=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set499_tree = (CommonTree)adaptor.dupNode(set499);


                adaptor.addChild(root_0, set499_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:752:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set500=null;

        CommonTree set500_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:753:5: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set500=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set500_tree = (CommonTree)adaptor.dupNode(set500);


                adaptor.addChild(root_0, set500_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:757:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set501=null;

        CommonTree set501_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:758:5: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set501=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set501_tree = (CommonTree)adaptor.dupNode(set501);


                adaptor.addChild(root_0, set501_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:762:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set502=null;

        CommonTree set502_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:763:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set502=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set502_tree = (CommonTree)adaptor.dupNode(set502);


                adaptor.addChild(root_0, set502_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:767:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set503=null;

        CommonTree set503_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:768:5: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set503=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set503_tree = (CommonTree)adaptor.dupNode(set503);


                adaptor.addChild(root_0, set503_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:772:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set504=null;

        CommonTree set504_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:773:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set504=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set504_tree = (CommonTree)adaptor.dupNode(set504);


                adaptor.addChild(root_0, set504_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:777:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set505=null;

        CommonTree set505_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:778:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set505=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set505_tree = (CommonTree)adaptor.dupNode(set505);


                adaptor.addChild(root_0, set505_tree);
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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred104_AliasMasker
    public final void synpred104_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:363:7: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:363:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred104_AliasMasker1802); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred104_AliasMasker1804);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred104_AliasMasker1806);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred104_AliasMasker

    // $ANTLR start synpred108_AliasMasker
    public final void synpred108_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:367:7: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:367:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred108_AliasMasker1866); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred108_AliasMasker1868);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred108_AliasMasker1870);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred108_AliasMasker

    // $ANTLR start synpred109_AliasMasker
    public final void synpred109_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:368:7: ( const_expr )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:368:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred109_AliasMasker1880);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_AliasMasker

    // $ANTLR start synpred112_AliasMasker
    public final void synpred112_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:371:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:371:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred112_AliasMasker1912); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred112_AliasMasker1914);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred112_AliasMasker1916);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred112_AliasMasker

    // $ANTLR start synpred135_AliasMasker
    public final void synpred135_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:22: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred135_AliasMasker2293); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_AliasMasker

    // $ANTLR start synpred136_AliasMasker
    public final void synpred136_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:32: ( LONGINTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:432:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred136_AliasMasker2297); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred136_AliasMasker

    // $ANTLR start synpred137_AliasMasker
    public final void synpred137_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:24: ( DOUBLENUMBER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:436:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred137_AliasMasker2327); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred137_AliasMasker

    // $ANTLR start synpred163_AliasMasker
    public final void synpred163_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:493:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:493:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred163_AliasMasker2651);
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


        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:496:16: ( OUTER )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==OUTER) ) {
            alt127=1;
        }
        switch (alt127) {
            case 1 :
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:496:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred163_AliasMasker2706); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred163_AliasMasker2709);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred163_AliasMasker

    // $ANTLR start synpred181_AliasMasker
    public final void synpred181_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:34: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AliasMasker.g:564:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred181_AliasMasker3126); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred181_AliasMasker

    // Delegated rules

    public final boolean synpred163_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred163_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred181_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred181_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0100000000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement182 = new BitSet(new long[]{0x009080044C800400L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_op_clause_in_general_statement195 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement197 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause212 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause535 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd575 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd579 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd583 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd587 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd591 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause613 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list629 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause666 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd701 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause736 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause758 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause783 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause785 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def850 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x0800100000010000L});
    public static final BitSet FOLLOW_type_in_field_def852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_simple_type_in_type894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type990 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type992 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1009 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1029 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1045 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1047 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1063 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_set_in_func_name1067 = new BitSet(new long[]{0xEEF3A0455CEF5F50L,0xFD2C6C27B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_eid_in_func_name1077 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1093 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_pivot_clause_in_h2irg_clause1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_autopivot_clause_in_h2irg_clause1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1148 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_chunksize_clause_in_autopivot_clause1163 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rate_clause_in_autopivot_clause1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_chunksize_clause1180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_chunksize_clause1182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RATE_in_rate_clause1199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_rate_clause1201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1216 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1237 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1239 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1254 = new BitSet(new long[]{0x0000000008000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1282 = new BitSet(new long[]{0x0000000000400008L,0x0000002000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_chunksize_clause_in_cube_rollup_list1292 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rate_clause_in_cube_rollup_list1294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1314 = new BitSet(new long[]{0x028820A80800A002L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1361 = new BitSet(new long[]{0x029080044C800408L,0x6108060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_type_in_group_clause1364 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1367 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1392 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1396 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1400 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1404 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_alias_in_rel1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1436 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1466 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1470 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1474 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1478 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1498 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1500 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1519 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1521 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_assert_clause1543 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_assert_clause1545 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1547 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1576 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_filter_clause1578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1597 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_cond1599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1613 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_cond1615 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1643 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_NOT_in_cond1645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1660 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond1662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1717 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1723 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1725 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1749 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1751 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_real_arg1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1788 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1804 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1806 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1820 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1834 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1836 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1838 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1850 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1852 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1854 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1866 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1868 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1870 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1898 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1900 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1912 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1914 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1972 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1974 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2010 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2014 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2018 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2067 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2138 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2141 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2189 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2191 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2193 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2258 = new BitSet(new long[]{0x1000000000000048L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_THEN_in_case_cond2265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2267 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2289 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2293 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2323 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2327 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2349 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2372 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2391 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2410 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2423 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2427 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2457 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2459 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2477 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2496 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2511 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2515 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2544 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2566 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2583 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2585 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2603 = new BitSet(new long[]{0x029080044C800402L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2621 = new BitSet(new long[]{0x0000000000000008L,0x0000020400000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2623 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2651 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2653 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2717 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2730 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2732 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2734 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2753 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2792 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2794 = new BitSet(new long[]{0x029080044C800400L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2818 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2835 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2837 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2851 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2866 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2884 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2886 = new BitSet(new long[]{0x028920A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2906 = new BitSet(new long[]{0x0010800404000000L,0x0000000020000400L,0x0002000000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2908 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2922 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_nested_command2924 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3036 = new BitSet(new long[]{0x0280002008000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3038 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3056 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3058 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_nested_filter3060 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3079 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3081 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3103 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3122 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3145 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3162 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3164 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3175 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3206 = new BitSet(new long[]{0x0200100000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3208 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3238 = new BitSet(new long[]{0x0000000000000000L,0x2000020000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3240 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3245 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3269 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3292 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_split_branch3294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3311 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3313 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3442 = new BitSet(new long[]{0x000800800000A000L,0x0000000000002001L});
    public static final BitSet FOLLOW_set_in_num_scalar3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3486 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3504 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3506 = new BitSet(new long[]{0x000820800000A000L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3536 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3554 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3556 = new BitSet(new long[]{0x000820800000A008L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_eid3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RATE_in_eid3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid4001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid4057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred104_AliasMasker1802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred104_AliasMasker1804 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred104_AliasMasker1806 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred108_AliasMasker1866 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred108_AliasMasker1868 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred108_AliasMasker1870 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred109_AliasMasker1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred112_AliasMasker1912 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred112_AliasMasker1914 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred112_AliasMasker1916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred135_AliasMasker2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred136_AliasMasker2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred137_AliasMasker2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred163_AliasMasker2651 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_synpred163_AliasMasker2653 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred163_AliasMasker2706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred163_AliasMasker2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred181_AliasMasker3126 = new BitSet(new long[]{0x0000000000000002L});

}