// $ANTLR 3.4 /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g 2014-12-22 11:35:33

package org.apache.pig.parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for printing Pig script from Ast).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstPrinter extends TreeParser {
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


    public AstPrinter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstPrinter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstPrinter.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g"; }



    public String getResult() { return sb.toString(); }

    private StringBuilder sb = new StringBuilder();



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:53:1: query : ^( QUERY ( statement )* ) ;
    public final AstPrinter.query_return query() throws RecognitionException {
        AstPrinter.query_return retval = new AstPrinter.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstPrinter.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:53:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:53:9: ^( QUERY ( statement )* )
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
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:53:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==IMPORT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:53:18: statement
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:56:1: statement : ( general_statement | split_statement | import_statement | register_statement | assert_statement | realias_statement );
    public final AstPrinter.statement_return statement() throws RecognitionException {
        AstPrinter.statement_return retval = new AstPrinter.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.general_statement_return general_statement3 =null;

        AstPrinter.split_statement_return split_statement4 =null;

        AstPrinter.import_statement_return import_statement5 =null;

        AstPrinter.register_statement_return register_statement6 =null;

        AstPrinter.assert_statement_return assert_statement7 =null;

        AstPrinter.realias_statement_return realias_statement8 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:56:11: ( general_statement | split_statement | import_statement | register_statement | assert_statement | realias_statement )
            int alt2=6;
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
            case IMPORT:
                {
                alt2=3;
                }
                break;
            case REGISTER:
                {
                alt2=4;
                }
                break;
            case ASSERT:
                {
                alt2=5;
                }
                break;
            case REALIAS:
                {
                alt2=6;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:56:13: general_statement
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:57:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:58:13: import_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_import_statement_in_statement124);
                    import_statement5=import_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, import_statement5.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:59:13: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement140);
                    register_statement6=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement6.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:60:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement156);
                    assert_statement7=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement7.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:61:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement172);
                    realias_statement8=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement8.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:64:1: split_statement : split_clause ;
    public final AstPrinter.split_statement_return split_statement() throws RecognitionException {
        AstPrinter.split_statement_return retval = new AstPrinter.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.split_clause_return split_clause9 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:64:17: ( split_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:64:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement181);
            split_clause9=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause9.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:67:1: realias_statement : realias_clause ;
    public final AstPrinter.realias_statement_return realias_statement() throws RecognitionException {
        AstPrinter.realias_statement_return retval = new AstPrinter.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.realias_clause_return realias_clause10 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:67:19: ( realias_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:67:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement190);
            realias_clause10=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause10.getTree());


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


    public static class import_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:70:1: import_statement : ^( IMPORT QUOTEDSTRING ) ;
    public final AstPrinter.import_statement_return import_statement() throws RecognitionException {
        AstPrinter.import_statement_return retval = new AstPrinter.import_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT11=null;
        CommonTree QUOTEDSTRING12=null;

        CommonTree IMPORT11_tree=null;
        CommonTree QUOTEDSTRING12_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:70:18: ( ^( IMPORT QUOTEDSTRING ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:70:20: ^( IMPORT QUOTEDSTRING )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IMPORT11=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_import_statement201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IMPORT11_tree = (CommonTree)adaptor.dupNode(IMPORT11);


            root_1 = (CommonTree)adaptor.becomeRoot(IMPORT11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_import_statement203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


            adaptor.addChild(root_1, QUOTEDSTRING12_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                                   sb.append(" ").append((IMPORT11!=null?IMPORT11.getText():null)).append(" ").append((QUOTEDSTRING12!=null?QUOTEDSTRING12.getText():null));
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
    // $ANTLR end "import_statement"


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:75:1: register_statement : ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? ) ;
    public final AstPrinter.register_statement_return register_statement() throws RecognitionException {
        AstPrinter.register_statement_return retval = new AstPrinter.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER13=null;
        CommonTree QUOTEDSTRING14=null;
        AstPrinter.scripting_udf_clause_return scripting_udf_clause15 =null;


        CommonTree REGISTER13_tree=null;
        CommonTree QUOTEDSTRING14_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:75:20: ( ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:75:22: ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER13=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement218); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER13_tree = (CommonTree)adaptor.dupNode(REGISTER13);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER13_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING14=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING14_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING14);


            adaptor.addChild(root_1, QUOTEDSTRING14_tree);
            }


            if ( state.backtracking==0 ) {
                                        sb.append((REGISTER13!=null?REGISTER13.getText():null)).append(" ").append((QUOTEDSTRING14!=null?QUOTEDSTRING14.getText():null));
                                    }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:77:27: ( scripting_udf_clause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:77:27: scripting_udf_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scripting_udf_clause_in_register_statement224);
                    scripting_udf_clause15=scripting_udf_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, scripting_udf_clause15.getTree());


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
    // $ANTLR end "register_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:80:1: assert_statement : assert_clause ;
    public final AstPrinter.assert_statement_return assert_statement() throws RecognitionException {
        AstPrinter.assert_statement_return retval = new AstPrinter.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.assert_clause_return assert_clause16 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:80:18: ( assert_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:80:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement236);
            assert_clause16=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause16.getTree());


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


    public static class scripting_udf_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_udf_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:83:1: scripting_udf_clause : scripting_language_clause scripting_namespace_clause ;
    public final AstPrinter.scripting_udf_clause_return scripting_udf_clause() throws RecognitionException {
        AstPrinter.scripting_udf_clause_return retval = new AstPrinter.scripting_udf_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scripting_language_clause_return scripting_language_clause17 =null;

        AstPrinter.scripting_namespace_clause_return scripting_namespace_clause18 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:83:22: ( scripting_language_clause scripting_namespace_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:83:24: scripting_language_clause scripting_namespace_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scripting_language_clause_in_scripting_udf_clause245);
            scripting_language_clause17=scripting_language_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, scripting_language_clause17.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scripting_namespace_clause_in_scripting_udf_clause247);
            scripting_namespace_clause18=scripting_namespace_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, scripting_namespace_clause18.getTree());


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
    // $ANTLR end "scripting_udf_clause"


    public static class scripting_language_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_language_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:86:1: scripting_language_clause : ( USING IDENTIFIER ) ;
    public final AstPrinter.scripting_language_clause_return scripting_language_clause() throws RecognitionException {
        AstPrinter.scripting_language_clause_return retval = new AstPrinter.scripting_language_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree USING19=null;
        CommonTree IDENTIFIER20=null;

        CommonTree USING19_tree=null;
        CommonTree IDENTIFIER20_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:86:27: ( ( USING IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:86:29: ( USING IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:86:29: ( USING IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:86:30: USING IDENTIFIER
            {
            _last = (CommonTree)input.LT(1);
            USING19=(CommonTree)match(input,USING,FOLLOW_USING_in_scripting_language_clause257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USING19_tree = (CommonTree)adaptor.dupNode(USING19);


            adaptor.addChild(root_0, USING19_tree);
            }


            _last = (CommonTree)input.LT(1);
            IDENTIFIER20=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_scripting_language_clause259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER20_tree = (CommonTree)adaptor.dupNode(IDENTIFIER20);


            adaptor.addChild(root_0, IDENTIFIER20_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
                                            sb.append(" ").append((USING19!=null?USING19.getText():null)).append(" ").append((IDENTIFIER20!=null?IDENTIFIER20.getText():null));
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
    // $ANTLR end "scripting_language_clause"


    public static class scripting_namespace_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_namespace_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:91:1: scripting_namespace_clause : ( AS IDENTIFIER ) ;
    public final AstPrinter.scripting_namespace_clause_return scripting_namespace_clause() throws RecognitionException {
        AstPrinter.scripting_namespace_clause_return retval = new AstPrinter.scripting_namespace_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS21=null;
        CommonTree IDENTIFIER22=null;

        CommonTree AS21_tree=null;
        CommonTree IDENTIFIER22_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:91:28: ( ( AS IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:91:30: ( AS IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:91:30: ( AS IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:91:31: AS IDENTIFIER
            {
            _last = (CommonTree)input.LT(1);
            AS21=(CommonTree)match(input,AS,FOLLOW_AS_in_scripting_namespace_clause272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS21_tree = (CommonTree)adaptor.dupNode(AS21);


            adaptor.addChild(root_0, AS21_tree);
            }


            _last = (CommonTree)input.LT(1);
            IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_scripting_namespace_clause274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


            adaptor.addChild(root_0, IDENTIFIER22_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
                                             sb.append(" ").append((AS21!=null?AS21.getText():null)).append(" ").append((IDENTIFIER22!=null?IDENTIFIER22.getText():null));
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
    // $ANTLR end "scripting_namespace_clause"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:97:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstPrinter.general_statement_return general_statement() throws RecognitionException {
        AstPrinter.general_statement_return retval = new AstPrinter.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT23=null;
        AstPrinter.alias_return alias24 =null;

        AstPrinter.op_clause_return op_clause25 =null;

        AstPrinter.parallel_clause_return parallel_clause26 =null;


        CommonTree STATEMENT23_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:98:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:98:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT23=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT23_tree = (CommonTree)adaptor.dupNode(STATEMENT23);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT23_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:98:20: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:98:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement297);
                    alias24=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias24.getTree());


                    if ( state.backtracking==0 ) { sb.append(" = "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement312);
            op_clause25=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause25.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:99:19: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:99:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement314);
                    parallel_clause26=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(";\n"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:102:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstPrinter.realias_clause_return realias_clause() throws RecognitionException {
        AstPrinter.realias_clause_return retval = new AstPrinter.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS27=null;
        CommonTree IDENTIFIER29=null;
        AstPrinter.alias_return alias28 =null;


        CommonTree REALIAS27_tree=null;
        CommonTree IDENTIFIER29_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:102:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:102:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS27=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS27_tree = (CommonTree)adaptor.dupNode(REALIAS27);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS27_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause331);
            alias28=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias28.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER29=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER29_tree = (CommonTree)adaptor.dupNode(IDENTIFIER29);


            adaptor.addChild(root_1, IDENTIFIER29_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:105:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstPrinter.parallel_clause_return parallel_clause() throws RecognitionException {
        AstPrinter.parallel_clause_return retval = new AstPrinter.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL30=null;
        CommonTree INTEGER31=null;

        CommonTree PARALLEL30_tree=null;
        CommonTree INTEGER31_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:106:5: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:106:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL30=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause349); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL30_tree = (CommonTree)adaptor.dupNode(PARALLEL30);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL30_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER31=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER31_tree = (CommonTree)adaptor.dupNode(INTEGER31);


            adaptor.addChild(root_1, INTEGER31_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARALLEL30!=null?PARALLEL30.getText():null)).append(" ").append((INTEGER31!=null?INTEGER31.getText():null)); }

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


    public static class pivot_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:109:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AstPrinter.pivot_clause_return pivot_clause() throws RecognitionException {
        AstPrinter.pivot_clause_return retval = new AstPrinter.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT32=null;
        CommonTree INTEGER33=null;

        CommonTree PIVOT32_tree=null;
        CommonTree INTEGER33_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:110:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:110:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT32=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT32_tree = (CommonTree)adaptor.dupNode(PIVOT32);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT32_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER33=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER33_tree = (CommonTree)adaptor.dupNode(INTEGER33);


            adaptor.addChild(root_1, INTEGER33_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PIVOT32!=null?PIVOT32.getText():null)).append(" ").append((INTEGER33!=null?INTEGER33.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chunksize_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:113:1: chunksize_clause : ^( CHUNKSIZE LONG ) ;
    public final AstPrinter.chunksize_clause_return chunksize_clause() throws RecognitionException {
        AstPrinter.chunksize_clause_return retval = new AstPrinter.chunksize_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CHUNKSIZE34=null;
        CommonTree LONG35=null;

        CommonTree CHUNKSIZE34_tree=null;
        CommonTree LONG35_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:114:5: ( ^( CHUNKSIZE LONG ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:114:7: ^( CHUNKSIZE LONG )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CHUNKSIZE34=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_chunksize_clause391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CHUNKSIZE34_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE34);


            root_1 = (CommonTree)adaptor.becomeRoot(CHUNKSIZE34_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            LONG35=(CommonTree)match(input,LONG,FOLLOW_LONG_in_chunksize_clause393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LONG35_tree = (CommonTree)adaptor.dupNode(LONG35);


            adaptor.addChild(root_1, LONG35_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((CHUNKSIZE34!=null?CHUNKSIZE34.getText():null)).append(" ").append((LONG35!=null?LONG35.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:117:1: rate_clause : ^( RATE FLOAT ) ;
    public final AstPrinter.rate_clause_return rate_clause() throws RecognitionException {
        AstPrinter.rate_clause_return retval = new AstPrinter.rate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RATE36=null;
        CommonTree FLOAT37=null;

        CommonTree RATE36_tree=null;
        CommonTree FLOAT37_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:118:5: ( ^( RATE FLOAT ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:118:7: ^( RATE FLOAT )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RATE36=(CommonTree)match(input,RATE,FOLLOW_RATE_in_rate_clause412); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RATE36_tree = (CommonTree)adaptor.dupNode(RATE36);


            root_1 = (CommonTree)adaptor.becomeRoot(RATE36_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            FLOAT37=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_rate_clause414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLOAT37_tree = (CommonTree)adaptor.dupNode(FLOAT37);


            adaptor.addChild(root_1, FLOAT37_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((RATE36!=null?RATE36.getText():null)).append(" ").append((FLOAT37!=null?FLOAT37.getText():null)); }

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


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:121:1: alias : IDENTIFIER ;
    public final AstPrinter.alias_return alias() throws RecognitionException {
        AstPrinter.alias_return retval = new AstPrinter.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER38=null;

        CommonTree IDENTIFIER38_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:122:5: ( IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:122:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER38=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER38_tree = (CommonTree)adaptor.dupNode(IDENTIFIER38);


            adaptor.addChild(root_0, IDENTIFIER38_tree);
            }


            if ( state.backtracking==0 ) { sb.append((IDENTIFIER38!=null?IDENTIFIER38.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:125:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AstPrinter.op_clause_return op_clause() throws RecognitionException {
        AstPrinter.op_clause_return retval = new AstPrinter.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.define_clause_return define_clause39 =null;

        AstPrinter.load_clause_return load_clause40 =null;

        AstPrinter.group_clause_return group_clause41 =null;

        AstPrinter.store_clause_return store_clause42 =null;

        AstPrinter.filter_clause_return filter_clause43 =null;

        AstPrinter.distinct_clause_return distinct_clause44 =null;

        AstPrinter.limit_clause_return limit_clause45 =null;

        AstPrinter.sample_clause_return sample_clause46 =null;

        AstPrinter.order_clause_return order_clause47 =null;

        AstPrinter.rank_clause_return rank_clause48 =null;

        AstPrinter.cross_clause_return cross_clause49 =null;

        AstPrinter.join_clause_return join_clause50 =null;

        AstPrinter.union_clause_return union_clause51 =null;

        AstPrinter.stream_clause_return stream_clause52 =null;

        AstPrinter.mr_clause_return mr_clause53 =null;

        AstPrinter.split_clause_return split_clause54 =null;

        AstPrinter.foreach_clause_return foreach_clause55 =null;

        AstPrinter.cube_clause_return cube_clause56 =null;

        AstPrinter.assert_clause_return assert_clause57 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:125:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=19;
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
            case SPLIT:
                {
                alt6=16;
                }
                break;
            case FOREACH:
                {
                alt6=17;
                }
                break;
            case CUBE:
                {
                alt6=18;
                }
                break;
            case ASSERT:
                {
                alt6=19;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:125:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause442);
                    define_clause39=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:126:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause456);
                    load_clause40=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause40.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:127:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause470);
                    group_clause41=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:128:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause484);
                    store_clause42=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause42.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:129:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause498);
                    filter_clause43=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause43.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:130:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause512);
                    distinct_clause44=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause44.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:131:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause526);
                    limit_clause45=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause45.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:132:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause540);
                    sample_clause46=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause46.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:133:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause554);
                    order_clause47=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause47.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:134:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause568);
                    rank_clause48=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause48.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:135:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause582);
                    cross_clause49=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause49.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:136:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause596);
                    join_clause50=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause50.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:137:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause610);
                    union_clause51=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause51.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:138:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause624);
                    stream_clause52=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause52.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:139:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause638);
                    mr_clause53=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause53.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:140:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause652);
                    split_clause54=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause54.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:141:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause666);
                    foreach_clause55=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause55.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:142:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause680);
                    cube_clause56=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause56.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:143:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause694);
                    assert_clause57=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause57.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:146:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AstPrinter.define_clause_return define_clause() throws RecognitionException {
        AstPrinter.define_clause_return retval = new AstPrinter.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE58=null;
        CommonTree IDENTIFIER59=null;
        AstPrinter.cmd_return cmd60 =null;

        AstPrinter.func_clause_return func_clause61 =null;


        CommonTree DEFINE58_tree=null;
        CommonTree IDENTIFIER59_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:147:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:147:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE58=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause709); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE58_tree = (CommonTree)adaptor.dupNode(DEFINE58);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE58_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER59=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause711); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER59_tree = (CommonTree)adaptor.dupNode(IDENTIFIER59);


            adaptor.addChild(root_1, IDENTIFIER59_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DEFINE58!=null?DEFINE58.getText():null)).append(" ").append((IDENTIFIER59!=null?IDENTIFIER59.getText():null)).append(" "); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:148:9: ( cmd | func_clause )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==EXECCOMMAND) ) {
                alt7=1;
            }
            else if ( (LA7_0==FUNC||LA7_0==FUNC_REF) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:148:11: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause725);
                    cmd60=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd60.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:148:17: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause729);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:151:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstPrinter.cmd_return cmd() throws RecognitionException {
        AstPrinter.cmd_return retval = new AstPrinter.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND62=null;
        AstPrinter.ship_clause_return ship_clause63 =null;

        AstPrinter.cache_clause_return cache_clause64 =null;

        AstPrinter.input_clause_return input_clause65 =null;

        AstPrinter.output_clause_return output_clause66 =null;

        AstPrinter.error_clause_return error_clause67 =null;


        CommonTree EXECCOMMAND62_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:152:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:152:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND62=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd748); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND62_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND62);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND62_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((EXECCOMMAND62!=null?EXECCOMMAND62.getText():null)); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd762);
                	    ship_clause63=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause63.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd766);
                	    cache_clause64=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause64.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd770);
                	    input_clause65=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause65.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd774);
                	    output_clause66=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause66.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:153:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd778);
                	    error_clause67=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause67.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:156:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstPrinter.ship_clause_return ship_clause() throws RecognitionException {
        AstPrinter.ship_clause_return retval = new AstPrinter.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP68=null;
        AstPrinter.path_list_return path_list69 =null;


        CommonTree SHIP68_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:157:5: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:157:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP68=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP68_tree = (CommonTree)adaptor.dupNode(SHIP68);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP68_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((SHIP68!=null?SHIP68.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:157:67: ( path_list )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:157:67: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause802);
                        path_list69=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list69.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:160:1: path_list : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.path_list_return path_list() throws RecognitionException {
        AstPrinter.path_list_return retval = new AstPrinter.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:161:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:161:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list822); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((a!=null?a.getText():null)); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:162:9: (b= QUOTEDSTRING )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:162:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list837); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:165:1: cache_clause : ^( CACHE path_list ) ;
    public final AstPrinter.cache_clause_return cache_clause() throws RecognitionException {
        AstPrinter.cache_clause_return retval = new AstPrinter.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE70=null;
        AstPrinter.path_list_return path_list71 =null;


        CommonTree CACHE70_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:166:5: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:166:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE70=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE70_tree = (CommonTree)adaptor.dupNode(CACHE70);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE70_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((CACHE70!=null?CACHE70.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause861);
            path_list71=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list71.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:169:1: input_clause : ^( INPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.input_clause_return input_clause() throws RecognitionException {
        AstPrinter.input_clause_return retval = new AstPrinter.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT72=null;
        AstPrinter.stream_cmd_return stream_cmd73 =null;

        AstPrinter.stream_cmd_return stream_cmd74 =null;


        CommonTree INPUT72_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:170:5: ( ^( INPUT stream_cmd ( stream_cmd )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:170:7: ^( INPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT72=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause880); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT72_tree = (CommonTree)adaptor.dupNode(INPUT72);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT72_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((INPUT72!=null?INPUT72.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_input_clause892);
            stream_cmd73=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd73.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:171:20: ( stream_cmd )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:171:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause898);
            	    stream_cmd74=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd74.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:174:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstPrinter.stream_cmd_return stream_cmd() throws RecognitionException {
        AstPrinter.stream_cmd_return retval = new AstPrinter.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN75=null;
        CommonTree STDOUT77=null;
        CommonTree QUOTEDSTRING79=null;
        AstPrinter.func_clause_return func_clause76 =null;

        AstPrinter.func_clause_return func_clause78 =null;

        AstPrinter.func_clause_return func_clause80 =null;


        CommonTree STDIN75_tree=null;
        CommonTree STDOUT77_tree=null;
        CommonTree QUOTEDSTRING79_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:175:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:175:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN75=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN75_tree = (CommonTree)adaptor.dupNode(STDIN75);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN75_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN75!=null?STDIN75.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:175:62: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:175:62: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd923);
                                func_clause76=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause76.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:176:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT77=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT77_tree = (CommonTree)adaptor.dupNode(STDOUT77);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT77_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT77!=null?STDOUT77.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:176:64: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:176:64: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd940);
                                func_clause78=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause78.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:177:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING79=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING79_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING79);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING79_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING79!=null?QUOTEDSTRING79.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:177:76: ( func_clause )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:177:76: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd957);
                                func_clause80=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause80.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:180:1: output_clause : ^( OUTPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.output_clause_return output_clause() throws RecognitionException {
        AstPrinter.output_clause_return retval = new AstPrinter.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT81=null;
        AstPrinter.stream_cmd_return stream_cmd82 =null;

        AstPrinter.stream_cmd_return stream_cmd83 =null;


        CommonTree OUTPUT81_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:181:5: ( ^( OUTPUT stream_cmd ( stream_cmd )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:181:7: ^( OUTPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT81=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause975); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT81_tree = (CommonTree)adaptor.dupNode(OUTPUT81);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT81_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((OUTPUT81!=null?OUTPUT81.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_output_clause988);
            stream_cmd82=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd82.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:182:20: ( stream_cmd )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:182:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(","); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause994);
            	    stream_cmd83=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd83.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:185:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstPrinter.error_clause_return error_clause() throws RecognitionException {
        AstPrinter.error_clause_return retval = new AstPrinter.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR84=null;
        CommonTree QUOTEDSTRING85=null;
        CommonTree INTEGER86=null;

        CommonTree STDERROR84_tree=null;
        CommonTree QUOTEDSTRING85_tree=null;
        CommonTree INTEGER86_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:186:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:186:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR84=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause1015); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR84_tree = (CommonTree)adaptor.dupNode(STDERROR84);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR84_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((STDERROR84!=null?STDERROR84.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:187:9: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:187:11: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING85=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause1029); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING85_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING85);


                        adaptor.addChild(root_1, QUOTEDSTRING85_tree);
                        }


                        if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING85!=null?QUOTEDSTRING85.getText():null)); }

                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:187:59: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:187:60: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER86=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause1034); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER86_tree = (CommonTree)adaptor.dupNode(INTEGER86);


                                adaptor.addChild(root_1, INTEGER86_tree);
                                }


                                if ( state.backtracking==0 ) { sb.append(" LIMIT ").append(INTEGER86); }

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


                if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:190:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstPrinter.load_clause_return load_clause() throws RecognitionException {
        AstPrinter.load_clause_return retval = new AstPrinter.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD87=null;
        AstPrinter.filename_return filename88 =null;

        AstPrinter.func_clause_return func_clause89 =null;

        AstPrinter.as_clause_return as_clause90 =null;


        CommonTree LOAD87_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:191:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:191:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD87=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause1061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD87_tree = (CommonTree)adaptor.dupNode(LOAD87);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD87_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LOAD87!=null?LOAD87.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause1065);
            filename88=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename88.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:192:9: ( func_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:192:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause1079);
                    func_clause89=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause89.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:192:51: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:192:51: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause1083);
                    as_clause90=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause90.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:195:1: filename : QUOTEDSTRING ;
    public final AstPrinter.filename_return filename() throws RecognitionException {
        AstPrinter.filename_return retval = new AstPrinter.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING91=null;

        CommonTree QUOTEDSTRING91_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:196:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:196:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING91=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1099); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING91_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING91);


            adaptor.addChild(root_0, QUOTEDSTRING91_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING91!=null?QUOTEDSTRING91.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:199:1: as_clause : ^( AS field_def_list ) ;
    public final AstPrinter.as_clause_return as_clause() throws RecognitionException {
        AstPrinter.as_clause_return retval = new AstPrinter.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS92=null;
        AstPrinter.field_def_list_return field_def_list93 =null;


        CommonTree AS92_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:200:5: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:200:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS92=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS92_tree = (CommonTree)adaptor.dupNode(AS92);


            root_1 = (CommonTree)adaptor.becomeRoot(AS92_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((AS92!=null?AS92.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1120);
            field_def_list93=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list93.getTree());


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
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:203:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) );
    public final AstPrinter.field_def_return field_def() throws RecognitionException {
        AstPrinter.field_def_return retval = new AstPrinter.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF94=null;
        CommonTree IDENTIFIER95=null;
        CommonTree FIELD_DEF97=null;
        AstPrinter.type_return type96 =null;

        AstPrinter.type_return type98 =null;


        CommonTree FIELD_DEF94_tree=null;
        CommonTree IDENTIFIER95_tree=null;
        CommonTree FIELD_DEF97_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:204:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==DOWN) ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2==IDENTIFIER) ) {
                        alt22=1;
                    }
                    else if ( (LA22_2==BIGDECIMAL||LA22_2==BIGINTEGER||LA22_2==BOOLEAN||LA22_2==BYTEARRAY||LA22_2==CHARARRAY||LA22_2==DATETIME||LA22_2==DOUBLE||LA22_2==FLOAT||LA22_2==INT||LA22_2==LONG||LA22_2==BAG_TYPE||LA22_2==MAP_TYPE||LA22_2==TUPLE_TYPE) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:204:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF94=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF94_tree = (CommonTree)adaptor.dupNode(FIELD_DEF94);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER95=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER95_tree = (CommonTree)adaptor.dupNode(IDENTIFIER95);


                    adaptor.addChild(root_1, IDENTIFIER95_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER95!=null?IDENTIFIER95.getText():null)); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:204:65: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:204:67: type
                            {
                            if ( state.backtracking==0 ) {sb.append(":"); }

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1149);
                            type96=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type96.getTree());


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
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:205:7: ^( FIELD_DEF type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF97=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF97_tree = (CommonTree)adaptor.dupNode(FIELD_DEF97);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF97_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1165);
                    type98=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type98.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:208:1: field_def_list : ( field_def ( field_def )+ | field_def );
    public final AstPrinter.field_def_list_return field_def_list() throws RecognitionException {
        AstPrinter.field_def_list_return retval = new AstPrinter.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.field_def_return field_def99 =null;

        AstPrinter.field_def_return field_def100 =null;

        AstPrinter.field_def_return field_def101 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:5: ( field_def ( field_def )+ | field_def )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FIELD_DEF) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred50_AstPrinter()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:7: field_def ( field_def )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list1182);
                    field_def99=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def99.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:37: ( field_def )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==FIELD_DEF) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:39: field_def
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_field_def_in_field_def_list1188);
                    	    field_def100=field_def();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, field_def100.getTree());


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


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:210:7: field_def
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list1201);
                    field_def101=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def101.getTree());


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
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AstPrinter.type_return type() throws RecognitionException {
        AstPrinter.type_return retval = new AstPrinter.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type102 =null;

        AstPrinter.tuple_type_return tuple_type103 =null;

        AstPrinter.bag_type_return bag_type104 =null;

        AstPrinter.map_type_return map_type105 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt25=4;
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
                alt25=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt25=2;
                }
                break;
            case BAG_TYPE:
                {
                alt25=3;
                }
                break;
            case MAP_TYPE:
                {
                alt25=4;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1210);
                    simple_type102=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type102.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1214);
                    tuple_type103=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type103.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1218);
                    bag_type104=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type104.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:213:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1222);
                    map_type105=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type105.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:216:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstPrinter.simple_type_return simple_type() throws RecognitionException {
        AstPrinter.simple_type_return retval = new AstPrinter.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN106=null;
        CommonTree INT107=null;
        CommonTree LONG108=null;
        CommonTree FLOAT109=null;
        CommonTree DOUBLE110=null;
        CommonTree BIGINTEGER111=null;
        CommonTree BIGDECIMAL112=null;
        CommonTree DATETIME113=null;
        CommonTree CHARARRAY114=null;
        CommonTree BYTEARRAY115=null;

        CommonTree BOOLEAN106_tree=null;
        CommonTree INT107_tree=null;
        CommonTree LONG108_tree=null;
        CommonTree FLOAT109_tree=null;
        CommonTree DOUBLE110_tree=null;
        CommonTree BIGINTEGER111_tree=null;
        CommonTree BIGDECIMAL112_tree=null;
        CommonTree DATETIME113_tree=null;
        CommonTree CHARARRAY114_tree=null;
        CommonTree BYTEARRAY115_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:217:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt26=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt26=1;
                }
                break;
            case INT:
                {
                alt26=2;
                }
                break;
            case LONG:
                {
                alt26=3;
                }
                break;
            case FLOAT:
                {
                alt26=4;
                }
                break;
            case DOUBLE:
                {
                alt26=5;
                }
                break;
            case BIGINTEGER:
                {
                alt26=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt26=7;
                }
                break;
            case DATETIME:
                {
                alt26=8;
                }
                break;
            case CHARARRAY:
                {
                alt26=9;
                }
                break;
            case BYTEARRAY:
                {
                alt26=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:217:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN106=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1235); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN106_tree = (CommonTree)adaptor.dupNode(BOOLEAN106);


                    adaptor.addChild(root_0, BOOLEAN106_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN106!=null?BOOLEAN106.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:218:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT107=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1245); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT107_tree = (CommonTree)adaptor.dupNode(INT107);


                    adaptor.addChild(root_0, INT107_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT107!=null?INT107.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:219:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG108=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG108_tree = (CommonTree)adaptor.dupNode(LONG108);


                    adaptor.addChild(root_0, LONG108_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG108!=null?LONG108.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:220:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT109=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT109_tree = (CommonTree)adaptor.dupNode(FLOAT109);


                    adaptor.addChild(root_0, FLOAT109_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT109!=null?FLOAT109.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:221:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE110=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE110_tree = (CommonTree)adaptor.dupNode(DOUBLE110);


                    adaptor.addChild(root_0, DOUBLE110_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE110!=null?DOUBLE110.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:222:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER111=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER111_tree = (CommonTree)adaptor.dupNode(BIGINTEGER111);


                    adaptor.addChild(root_0, BIGINTEGER111_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER111!=null?BIGINTEGER111.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:223:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL112=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL112_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL112);


                    adaptor.addChild(root_0, BIGDECIMAL112_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL112!=null?BIGDECIMAL112.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:224:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME113=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME113_tree = (CommonTree)adaptor.dupNode(DATETIME113);


                    adaptor.addChild(root_0, DATETIME113_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME113!=null?DATETIME113.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:225:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY114=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY114_tree = (CommonTree)adaptor.dupNode(CHARARRAY114);


                    adaptor.addChild(root_0, CHARARRAY114_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY114!=null?CHARARRAY114.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:226:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY115=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1325); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY115_tree = (CommonTree)adaptor.dupNode(BYTEARRAY115);


                    adaptor.addChild(root_0, BYTEARRAY115_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY115!=null?BYTEARRAY115.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:229:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstPrinter.tuple_type_return tuple_type() throws RecognitionException {
        AstPrinter.tuple_type_return retval = new AstPrinter.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE116=null;
        AstPrinter.field_def_list_return field_def_list117 =null;


        CommonTree TUPLE_TYPE116_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:230:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:230:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE116=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE116_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE116);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE116_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:230:21: ( field_def_list )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==FIELD_DEF) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:230:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1344);
                        field_def_list117=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list117.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:233:1: bag_type : ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) ;
    public final AstPrinter.bag_type_return bag_type() throws RecognitionException {
        AstPrinter.bag_type_return retval = new AstPrinter.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE118=null;
        CommonTree IDENTIFIER119=null;
        AstPrinter.tuple_type_return tuple_type120 =null;


        CommonTree BAG_TYPE118_tree=null;
        CommonTree IDENTIFIER119_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:5: ( ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:7: ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE118=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1362); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE118_tree = (CommonTree)adaptor.dupNode(BAG_TYPE118);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE118_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:42: ( ( IDENTIFIER )? tuple_type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==IDENTIFIER||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:44: ( IDENTIFIER )? tuple_type
                        {
                        if ( state.backtracking==0 ) { sb.append("T:"); }

                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:65: ( IDENTIFIER )?
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDENTIFIER) ) {
                            alt28=1;
                        }
                        switch (alt28) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:234:65: IDENTIFIER
                                {
                                _last = (CommonTree)input.LT(1);
                                IDENTIFIER119=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1370); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                IDENTIFIER119_tree = (CommonTree)adaptor.dupNode(IDENTIFIER119);


                                adaptor.addChild(root_1, IDENTIFIER119_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1373);
                        tuple_type120=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type120.getTree());


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


            if ( state.backtracking==0 ) { sb.append("}"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:237:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstPrinter.map_type_return map_type() throws RecognitionException {
        AstPrinter.map_type_return retval = new AstPrinter.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE121=null;
        AstPrinter.type_return type122 =null;


        CommonTree MAP_TYPE121_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:237:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:237:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE121=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE121_tree = (CommonTree)adaptor.dupNode(MAP_TYPE121);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE121_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("map["); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:237:47: ( type )?
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==BIGDECIMAL||LA30_0==BIGINTEGER||LA30_0==BOOLEAN||LA30_0==BYTEARRAY||LA30_0==CHARARRAY||LA30_0==DATETIME||LA30_0==DOUBLE||LA30_0==FLOAT||LA30_0==INT||LA30_0==LONG||LA30_0==BAG_TYPE||LA30_0==MAP_TYPE||LA30_0==TUPLE_TYPE) ) {
                    alt30=1;
                }
                switch (alt30) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:237:47: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1395);
                        type122=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type122.getTree());


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


            if ( state.backtracking==0 ) { sb.append("]"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:240:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstPrinter.func_clause_return func_clause() throws RecognitionException {
        AstPrinter.func_clause_return retval = new AstPrinter.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF123=null;
        CommonTree FUNC125=null;
        AstPrinter.func_name_return func_name124 =null;

        AstPrinter.func_name_return func_name126 =null;

        AstPrinter.func_args_return func_args127 =null;


        CommonTree FUNC_REF123_tree=null;
        CommonTree FUNC125_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:241:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FUNC_REF) ) {
                alt32=1;
            }
            else if ( (LA32_0==FUNC) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:241:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF123=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF123_tree = (CommonTree)adaptor.dupNode(FUNC_REF123);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF123_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1417);
                    func_name124=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name124.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:242:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC125=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC125_tree = (CommonTree)adaptor.dupNode(FUNC125);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC125_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1431);
                    func_name126=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name126.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:242:45: ( func_args )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==MULTILINE_QUOTEDSTRING||LA31_0==QUOTEDSTRING) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:242:45: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1435);
                            func_args127=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args127.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:245:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstPrinter.func_name_return func_name() throws RecognitionException {
        AstPrinter.func_name_return retval = new AstPrinter.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD129=null;
        CommonTree DOLLAR130=null;
        AstPrinter.eid_return eid128 =null;

        AstPrinter.eid_return eid131 =null;


        CommonTree PERIOD129_tree=null;
        CommonTree DOLLAR130_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1453);
            eid128=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid128.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:11: ( ( PERIOD | DOLLAR ) eid )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==DOLLAR||LA34_0==PERIOD) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:13: ( PERIOD | DOLLAR )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==PERIOD) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==DOLLAR) ) {
            	        alt33=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:15: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD129=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1459); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD129_tree = (CommonTree)adaptor.dupNode(PERIOD129);


            	            adaptor.addChild(root_0, PERIOD129_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((PERIOD129!=null?PERIOD129.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:246:53: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR130=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1465); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR130_tree = (CommonTree)adaptor.dupNode(DOLLAR130);


            	            adaptor.addChild(root_0, DOLLAR130_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((DOLLAR130!=null?DOLLAR130.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1471);
            	    eid131=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid131.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop34;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:249:1: func_args : func_first_arg_clause ( func_next_arg_clause )* ;
    public final AstPrinter.func_args_return func_args() throws RecognitionException {
        AstPrinter.func_args_return retval = new AstPrinter.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_first_arg_clause_return func_first_arg_clause132 =null;

        AstPrinter.func_next_arg_clause_return func_next_arg_clause133 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:249:11: ( func_first_arg_clause ( func_next_arg_clause )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:249:13: func_first_arg_clause ( func_next_arg_clause )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_first_arg_clause_in_func_args1483);
            func_first_arg_clause132=func_first_arg_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, func_first_arg_clause132.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:249:35: ( func_next_arg_clause )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==MULTILINE_QUOTEDSTRING||LA35_0==QUOTEDSTRING) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:249:36: func_next_arg_clause
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_next_arg_clause_in_func_args1486);
            	    func_next_arg_clause133=func_next_arg_clause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_next_arg_clause133.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "func_args"


    public static class func_first_arg_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_first_arg_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:252:1: func_first_arg_clause : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstPrinter.func_first_arg_clause_return func_first_arg_clause() throws RecognitionException {
        AstPrinter.func_first_arg_clause_return retval = new AstPrinter.func_first_arg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING134=null;
        CommonTree MULTILINE_QUOTEDSTRING135=null;

        CommonTree QUOTEDSTRING134_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING135_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:252:23: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            else if ( (LA36_0==MULTILINE_QUOTEDSTRING) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:252:27: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING134=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_first_arg_clause1499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING134_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING134);


                    adaptor.addChild(root_0, QUOTEDSTRING134_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING134!=null?QUOTEDSTRING134.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:253:27: MULTILINE_QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MULTILINE_QUOTEDSTRING135=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_first_arg_clause1529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MULTILINE_QUOTEDSTRING135_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING135);


                    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING135_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MULTILINE_QUOTEDSTRING135!=null?MULTILINE_QUOTEDSTRING135.getText():null)); }

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
    // $ANTLR end "func_first_arg_clause"


    public static class func_next_arg_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_next_arg_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:256:1: func_next_arg_clause : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstPrinter.func_next_arg_clause_return func_next_arg_clause() throws RecognitionException {
        AstPrinter.func_next_arg_clause_return retval = new AstPrinter.func_next_arg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING136=null;
        CommonTree MULTILINE_QUOTEDSTRING137=null;

        CommonTree QUOTEDSTRING136_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING137_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:256:22: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==QUOTEDSTRING) ) {
                alt37=1;
            }
            else if ( (LA37_0==MULTILINE_QUOTEDSTRING) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:256:27: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING136=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_next_arg_clause1543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING136_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING136);


                    adaptor.addChild(root_0, QUOTEDSTRING136_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(", ").append((QUOTEDSTRING136!=null?QUOTEDSTRING136.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:257:27: MULTILINE_QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MULTILINE_QUOTEDSTRING137=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_next_arg_clause1573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MULTILINE_QUOTEDSTRING137_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING137);


                    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING137_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(", ").append((MULTILINE_QUOTEDSTRING137!=null?MULTILINE_QUOTEDSTRING137.getText():null)); }

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
    // $ANTLR end "func_next_arg_clause"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:260:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstPrinter.cube_clause_return cube_clause() throws RecognitionException {
        AstPrinter.cube_clause_return retval = new AstPrinter.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE138=null;
        AstPrinter.cube_item_return cube_item139 =null;


        CommonTree CUBE138_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:261:5: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:261:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE138=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1590); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE138_tree = (CommonTree)adaptor.dupNode(CUBE138);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE138_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CUBE138!=null?CUBE138.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1594);
            cube_item139=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item139.getTree());


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


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:264:1: cube_item : rel ( cube_by_clause ) ;
    public final AstPrinter.cube_item_return cube_item() throws RecognitionException {
        AstPrinter.cube_item_return retval = new AstPrinter.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel140 =null;

        AstPrinter.cube_by_clause_return cube_by_clause141 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:265:5: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:265:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1609);
            rel140=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel140.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:265:11: ( cube_by_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:265:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1613);
            cube_by_clause141=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause141.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:268:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstPrinter.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstPrinter.cube_by_clause_return retval = new AstPrinter.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY142=null;
        AstPrinter.cube_or_rollup_return cube_or_rollup143 =null;


        CommonTree BY142_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:269:5: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:269:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY142=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1630); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY142_tree = (CommonTree)adaptor.dupNode(BY142);


            root_1 = (CommonTree)adaptor.becomeRoot(BY142_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY142!=null?BY142.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1634);
            cube_or_rollup143=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup143.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:272:1: cube_or_rollup : cube_rollup_list ( cube_rollup_list )* ;
    public final AstPrinter.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstPrinter.cube_or_rollup_return retval = new AstPrinter.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_rollup_list_return cube_rollup_list144 =null;

        AstPrinter.cube_rollup_list_return cube_rollup_list145 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:273:5: ( cube_rollup_list ( cube_rollup_list )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:273:7: cube_rollup_list ( cube_rollup_list )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1649);
            cube_rollup_list144=cube_rollup_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_rollup_list144.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:273:24: ( cube_rollup_list )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==CUBE||LA38_0==ROLLUP) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:273:26: cube_rollup_list
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1655);
            	    cube_rollup_list145=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list145.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:276:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ) );
    public final AstPrinter.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstPrinter.cube_rollup_list_return retval = new AstPrinter.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE146=null;
        CommonTree ROLLUP148=null;
        AstPrinter.cube_by_expr_list_return cube_by_expr_list147 =null;

        AstPrinter.cube_by_expr_list_return cube_by_expr_list149 =null;


        CommonTree CUBE146_tree=null;
        CommonTree ROLLUP148_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:277:5: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==CUBE) ) {
                alt39=1;
            }
            else if ( (LA39_0==ROLLUP) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:277:7: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE146=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1673); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE146_tree = (CommonTree)adaptor.dupNode(CUBE146);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE146_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE146!=null?CUBE146.getText():null)).append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1677);
                    cube_by_expr_list147=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list147.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:277:96: ^( ROLLUP cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP148=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1687); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP148_tree = (CommonTree)adaptor.dupNode(ROLLUP148);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP148_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP148!=null?ROLLUP148.getText():null)).append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1691);
                    cube_by_expr_list149=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list149.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:280:1: cube_by_expr_list : ( cube_by_expr ( cube_by_expr )* ) ;
    public final AstPrinter.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstPrinter.cube_by_expr_list_return retval = new AstPrinter.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_by_expr_return cube_by_expr150 =null;

        AstPrinter.cube_by_expr_return cube_by_expr151 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:5: ( ( cube_by_expr ( cube_by_expr )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:7: ( cube_by_expr ( cube_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:7: ( cube_by_expr ( cube_by_expr )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:9: cube_by_expr ( cube_by_expr )*
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1710);
            cube_by_expr150=cube_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_expr150.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:22: ( cube_by_expr )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==BIGDECIMALNUMBER||LA40_0==BIGINTEGERNUMBER||LA40_0==CUBE||LA40_0==DIV||LA40_0==DOLLARVAR||LA40_0==DOUBLENUMBER||LA40_0==FALSE||LA40_0==FLOATNUMBER||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==INTEGER||LA40_0==LONGINTEGER||LA40_0==MINUS||LA40_0==NULL||LA40_0==PERCENT||LA40_0==PLUS||LA40_0==QUOTEDSTRING||LA40_0==STAR||LA40_0==TRUE||(LA40_0 >= BAG_VAL && LA40_0 <= BIN_EXPR)||(LA40_0 >= CASE_COND && LA40_0 <= CASE_EXPR)||(LA40_0 >= CAST_EXPR && LA40_0 <= EXPR_IN_PAREN)||LA40_0==FUNC_EVAL||(LA40_0 >= MAP_VAL && LA40_0 <= NEG)||LA40_0==TUPLE_VAL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:281:24: cube_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1716);
            	    cube_by_expr151=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr151.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:284:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstPrinter.cube_by_expr_return retval = new AstPrinter.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR154=null;
        AstPrinter.col_range_return col_range152 =null;

        AstPrinter.expr_return expr153 =null;


        CommonTree STAR154_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:285:5: ( col_range | expr | STAR )
            int alt41=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt41=1;
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
                alt41=2;
                }
                break;
            case STAR:
                {
                int LA41_3 = input.LA(2);

                if ( (LA41_3==DOWN) ) {
                    alt41=2;
                }
                else if ( (LA41_3==EOF||LA41_3==UP||LA41_3==BIGDECIMALNUMBER||LA41_3==BIGINTEGERNUMBER||LA41_3==CUBE||LA41_3==DIV||LA41_3==DOLLARVAR||LA41_3==DOUBLENUMBER||LA41_3==FALSE||LA41_3==FLOATNUMBER||LA41_3==GROUP||LA41_3==IDENTIFIER||LA41_3==INTEGER||LA41_3==LONGINTEGER||LA41_3==MINUS||LA41_3==NULL||LA41_3==PERCENT||LA41_3==PLUS||LA41_3==QUOTEDSTRING||LA41_3==STAR||LA41_3==TRUE||(LA41_3 >= BAG_VAL && LA41_3 <= BIN_EXPR)||(LA41_3 >= CASE_COND && LA41_3 <= CASE_EXPR)||(LA41_3 >= CAST_EXPR && LA41_3 <= EXPR_IN_PAREN)||LA41_3==FUNC_EVAL||(LA41_3 >= MAP_VAL && LA41_3 <= NEG)||LA41_3==TUPLE_VAL) ) {
                    alt41=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 3, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:285:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1734);
                    col_range152=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range152.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:285:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1738);
                    expr153=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr153.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:285:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR154=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR154_tree = (CommonTree)adaptor.dupNode(STAR154);


                    adaptor.addChild(root_0, STAR154_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR154!=null?STAR154.getText():null)); }

                    if ( state.backtracking==0 ) { sb.append(" "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:288:1: group_clause : ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) ;
    public final AstPrinter.group_clause_return group_clause() throws RecognitionException {
        AstPrinter.group_clause_return retval = new AstPrinter.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP155=null;
        CommonTree COGROUP156=null;
        AstPrinter.group_item_return group_item157 =null;

        AstPrinter.group_item_return group_item158 =null;

        AstPrinter.group_type_return group_type159 =null;

        AstPrinter.partition_clause_return partition_clause160 =null;


        CommonTree GROUP155_tree=null;
        CommonTree COGROUP156_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:289:5: ( ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:289:7: ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:289:10: ( GROUP | COGROUP )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==GROUP) ) {
                alt42=1;
            }
            else if ( (LA42_0==COGROUP) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:289:12: GROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    GROUP155=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP155_tree = (CommonTree)adaptor.dupNode(GROUP155);


                    adaptor.addChild(root_1, GROUP155_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP155!=null?GROUP155.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:289:60: COGROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    COGROUP156=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP156_tree = (CommonTree)adaptor.dupNode(COGROUP156);


                    adaptor.addChild(root_1, COGROUP156_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP156!=null?COGROUP156.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_group_item_in_group_clause1783);
            group_item157=group_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, group_item157.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:290:20: ( group_item )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==IDENTIFIER||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||LA43_0==SPLIT||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:290:22: group_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1789);
            	    group_item158=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item158.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:291:7: ( group_type )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==QUOTEDSTRING) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:291:9: group_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1804);
                    group_type159=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type159.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:292:7: ( partition_clause )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==PARTITION) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:292:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1815);
                    partition_clause160=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause160.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:296:1: group_type : QUOTEDSTRING ;
    public final AstPrinter.group_type_return group_type() throws RecognitionException {
        AstPrinter.group_type_return retval = new AstPrinter.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING161=null;

        CommonTree QUOTEDSTRING161_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:296:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:296:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING161=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING161_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING161);


            adaptor.addChild(root_0, QUOTEDSTRING161_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING161!=null?QUOTEDSTRING161.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:299:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstPrinter.group_item_return group_item() throws RecognitionException {
        AstPrinter.group_item_return retval = new AstPrinter.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL164=null;
        CommonTree ANY165=null;
        CommonTree INNER166=null;
        CommonTree OUTER167=null;
        AstPrinter.rel_return rel162 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause163 =null;


        CommonTree ALL164_tree=null;
        CommonTree ANY165_tree=null;
        CommonTree INNER166_tree=null;
        CommonTree OUTER167_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:300:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:300:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1846);
            rel162=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel162.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:300:11: ( join_group_by_clause | ALL | ANY )
            int alt46=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt46=1;
                }
                break;
            case ALL:
                {
                alt46=2;
                }
                break;
            case ANY:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:300:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1850);
                    join_group_by_clause163=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause163.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:301:15: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL164=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL164_tree = (CommonTree)adaptor.dupNode(ALL164);


                    adaptor.addChild(root_0, ALL164_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ALL164!=null?ALL164.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:301:59: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY165=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY165_tree = (CommonTree)adaptor.dupNode(ANY165);


                    adaptor.addChild(root_0, ANY165_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ANY165!=null?ANY165.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:302:13: ( INNER | OUTER )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==INNER) ) {
                alt47=1;
            }
            else if ( (LA47_0==OUTER) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:302:15: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER166=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1892); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER166_tree = (CommonTree)adaptor.dupNode(INNER166);


                    adaptor.addChild(root_0, INNER166_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INNER166!=null?INNER166.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:302:63: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER167=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER167_tree = (CommonTree)adaptor.dupNode(OUTER167);


                    adaptor.addChild(root_0, OUTER167_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((OUTER167!=null?OUTER167.getText():null)); }

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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:305:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AstPrinter.rel_return rel() throws RecognitionException {
        AstPrinter.rel_return retval = new AstPrinter.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_return alias168 =null;

        AstPrinter.op_clause_return op_clause169 =null;

        AstPrinter.parallel_clause_return parallel_clause170 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:306:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==IDENTIFIER) ) {
                alt49=1;
            }
            else if ( (LA49_0==ASSERT||LA49_0==COGROUP||(LA49_0 >= CROSS && LA49_0 <= CUBE)||LA49_0==DEFINE||LA49_0==DISTINCT||LA49_0==FILTER||LA49_0==FOREACH||LA49_0==GROUP||LA49_0==JOIN||(LA49_0 >= LIMIT && LA49_0 <= LOAD)||LA49_0==MAPREDUCE||LA49_0==ORDER||LA49_0==RANK||LA49_0==SAMPLE||LA49_0==SPLIT||(LA49_0 >= STORE && LA49_0 <= STREAM)||LA49_0==UNION) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:306:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1916);
                    alias168=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias168.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:307:7: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:307:7: ( op_clause ( parallel_clause )? )
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:307:9: op_clause ( parallel_clause )?
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1928);
                    op_clause169=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause169.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:307:40: ( parallel_clause )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==PARALLEL) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:307:40: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1930);
                            parallel_clause170=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause170.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(") "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:310:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstPrinter.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstPrinter.flatten_generated_item_return retval = new AstPrinter.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR174=null;
        AstPrinter.flatten_clause_return flatten_clause171 =null;

        AstPrinter.col_range_return col_range172 =null;

        AstPrinter.expr_return expr173 =null;

        AstPrinter.field_def_list_return field_def_list175 =null;


        CommonTree STAR174_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:7: ( flatten_clause | col_range | expr | STAR )
            int alt50=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt50=1;
                }
                break;
            case COL_RANGE:
                {
                alt50=2;
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
                alt50=3;
                }
                break;
            case STAR:
                {
                int LA50_4 = input.LA(2);

                if ( (LA50_4==DOWN) ) {
                    alt50=3;
                }
                else if ( (LA50_4==EOF||LA50_4==UP||LA50_4==BIGDECIMALNUMBER||LA50_4==BIGINTEGERNUMBER||LA50_4==CUBE||LA50_4==DIV||LA50_4==DOLLARVAR||LA50_4==DOUBLENUMBER||LA50_4==FALSE||LA50_4==FLATTEN||LA50_4==FLOATNUMBER||LA50_4==GROUP||LA50_4==IDENTIFIER||LA50_4==INTEGER||LA50_4==LONGINTEGER||LA50_4==MINUS||LA50_4==NULL||LA50_4==PERCENT||LA50_4==PLUS||LA50_4==QUOTEDSTRING||LA50_4==STAR||LA50_4==TRUE||(LA50_4 >= BAG_VAL && LA50_4 <= BIN_EXPR)||(LA50_4 >= CASE_COND && LA50_4 <= CASE_EXPR)||(LA50_4 >= CAST_EXPR && LA50_4 <= FIELD_DEF)||LA50_4==FUNC_EVAL||(LA50_4 >= MAP_VAL && LA50_4 <= NEG)||LA50_4==TUPLE_VAL) ) {
                    alt50=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 4, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1950);
                    flatten_clause171=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause171.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1954);
                    col_range172=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range172.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1958);
                    expr173=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr173.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR174=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1962); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR174_tree = (CommonTree)adaptor.dupNode(STAR174);


                    adaptor.addChild(root_0, STAR174_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR174!=null?STAR174.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:91: ( field_def_list )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FIELD_DEF) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:311:93: field_def_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" AS "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1972);
                    field_def_list175=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list175.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:314:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstPrinter.flatten_clause_return flatten_clause() throws RecognitionException {
        AstPrinter.flatten_clause_return retval = new AstPrinter.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN176=null;
        AstPrinter.expr_return expr177 =null;


        CommonTree FLATTEN176_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:315:5: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:315:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN176=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN176_tree = (CommonTree)adaptor.dupNode(FLATTEN176);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN176_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FLATTEN176!=null?FLATTEN176.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1993);
            expr177=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr177.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:318:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstPrinter.store_clause_return store_clause() throws RecognitionException {
        AstPrinter.store_clause_return retval = new AstPrinter.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE178=null;
        AstPrinter.rel_return rel179 =null;

        AstPrinter.filename_return filename180 =null;

        AstPrinter.func_clause_return func_clause181 =null;


        CommonTree STORE178_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:319:5: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:319:7: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE178=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2012); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE178_tree = (CommonTree)adaptor.dupNode(STORE178);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE178_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STORE178!=null?STORE178.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2016);
            rel179=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel179.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2020);
            filename180=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename180.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:319:94: ( func_clause )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==FUNC||LA52_0==FUNC_REF) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:319:96: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2026);
                    func_clause181=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause181.getTree());


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


    public static class comment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:322:1: comment : QUOTEDSTRING ;
    public final AstPrinter.comment_return comment() throws RecognitionException {
        AstPrinter.comment_return retval = new AstPrinter.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING182=null;

        CommonTree QUOTEDSTRING182_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:323:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:323:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING182=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2043); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING182_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING182);


            adaptor.addChild(root_0, QUOTEDSTRING182_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING182!=null?QUOTEDSTRING182.getText():null)); }

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


    public static class assert_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:326:1: assert_clause : ^( ASSERT rel cond ( comment )? ) ;
    public final AstPrinter.assert_clause_return assert_clause() throws RecognitionException {
        AstPrinter.assert_clause_return retval = new AstPrinter.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT183=null;
        AstPrinter.rel_return rel184 =null;

        AstPrinter.cond_return cond185 =null;

        AstPrinter.comment_return comment186 =null;


        CommonTree ASSERT183_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:327:5: ( ^( ASSERT rel cond ( comment )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:327:7: ^( ASSERT rel cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT183=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT183_tree = (CommonTree)adaptor.dupNode(ASSERT183);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT183_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ASSERT183!=null?ASSERT183.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause2064);
            rel184=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel184.getTree());


            if ( state.backtracking==0 ) {sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause2068);
            cond185=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond185.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:327:110: ( comment )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==QUOTEDSTRING) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:327:112: comment
                    {
                    if ( state.backtracking==0 ) { sb.append(" comment: "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause2076);
                    comment186=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment186.getTree());


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


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:330:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstPrinter.filter_clause_return filter_clause() throws RecognitionException {
        AstPrinter.filter_clause_return retval = new AstPrinter.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER187=null;
        AstPrinter.rel_return rel188 =null;

        AstPrinter.cond_return cond189 =null;


        CommonTree FILTER187_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:331:5: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:331:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER187=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2096); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER187_tree = (CommonTree)adaptor.dupNode(FILTER187);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER187_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER187!=null?FILTER187.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2100);
            rel188=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel188.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2104);
            cond189=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond189.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:334:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstPrinter.cond_return cond() throws RecognitionException {
        AstPrinter.cond_return retval = new AstPrinter.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR190=null;
        CommonTree AND193=null;
        CommonTree NOT196=null;
        CommonTree NULL198=null;
        CommonTree NOT200=null;
        CommonTree BOOL_COND206=null;
        AstPrinter.cond_return cond191 =null;

        AstPrinter.cond_return cond192 =null;

        AstPrinter.cond_return cond194 =null;

        AstPrinter.cond_return cond195 =null;

        AstPrinter.cond_return cond197 =null;

        AstPrinter.expr_return expr199 =null;

        AstPrinter.rel_op_return rel_op201 =null;

        AstPrinter.expr_return expr202 =null;

        AstPrinter.expr_return expr203 =null;

        AstPrinter.in_eval_return in_eval204 =null;

        AstPrinter.func_eval_return func_eval205 =null;

        AstPrinter.expr_return expr207 =null;


        CommonTree OR190_tree=null;
        CommonTree AND193_tree=null;
        CommonTree NOT196_tree=null;
        CommonTree NULL198_tree=null;
        CommonTree NOT200_tree=null;
        CommonTree BOOL_COND206_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:335:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt55=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt55=1;
                }
                break;
            case AND:
                {
                alt55=2;
                }
                break;
            case NOT:
                {
                alt55=3;
                }
                break;
            case NULL:
                {
                alt55=4;
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
                alt55=5;
                }
                break;
            case IN:
                {
                alt55=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt55=7;
                }
                break;
            case BOOL_COND:
                {
                alt55=8;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:335:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR190=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR190_tree = (CommonTree)adaptor.dupNode(OR190);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR190_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2127);
                    cond191=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond191.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((OR190!=null?OR190.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2131);
                    cond192=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond192.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:336:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND193=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND193_tree = (CommonTree)adaptor.dupNode(AND193);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND193_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2149);
                    cond194=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond194.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((AND193!=null?AND193.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2153);
                    cond195=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond195.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:337:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT196=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2167); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT196_tree = (CommonTree)adaptor.dupNode(NOT196);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT196_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((NOT196!=null?NOT196.getText():null)).append(" ("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2171);
                    cond197=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond197.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:338:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL198=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL198_tree = (CommonTree)adaptor.dupNode(NULL198);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2187);
                    expr199=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr199.getTree());


                    if ( state.backtracking==0 ) { sb.append(" IS "); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:338:43: ( NOT )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==NOT) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:338:44: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT200=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2192); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT200_tree = (CommonTree)adaptor.dupNode(NOT200);


                            adaptor.addChild(root_1, NOT200_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append((NOT200!=null?NOT200.getText():null)).append(" "); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append((NULL198!=null?NULL198.getText():null)); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:339:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond2212);
                    rel_op201=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op201.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2214);
                    expr202=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr202.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((rel_op201!=null?rel_op201.result:null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2218);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:340:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2228);
                    in_eval204=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval204.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:341:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2236);
                    func_eval205=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval205.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:342:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND206=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND206_tree = (CommonTree)adaptor.dupNode(BOOL_COND206);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND206_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2248);
                    expr207=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr207.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:345:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* ) ;
    public final AstPrinter.in_eval_return in_eval() throws RecognitionException {
        AstPrinter.in_eval_return retval = new AstPrinter.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN208=null;
        CommonTree IN_LHS209=null;
        CommonTree IN_RHS211=null;
        CommonTree IN_LHS213=null;
        CommonTree IN_RHS215=null;
        AstPrinter.expr_return expr210 =null;

        AstPrinter.expr_return expr212 =null;

        AstPrinter.expr_return expr214 =null;

        AstPrinter.expr_return expr216 =null;


        CommonTree IN208_tree=null;
        CommonTree IN_LHS209_tree=null;
        CommonTree IN_RHS211_tree=null;
        CommonTree IN_LHS213_tree=null;
        CommonTree IN_RHS215_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:346:5: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:346:7: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN208=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN208_tree = (CommonTree)adaptor.dupNode(IN208);


            root_1 = (CommonTree)adaptor.becomeRoot(IN208_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" " + (IN208!=null?IN208.getText():null) + "("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:347:10: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:347:12: ^( IN_LHS expr ) ^( IN_RHS expr )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN_LHS209=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN_LHS209_tree = (CommonTree)adaptor.dupNode(IN_LHS209);


            root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS209_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval2284);
            expr210=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr210.getTree());


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
            IN_RHS211=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2290); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN_RHS211_tree = (CommonTree)adaptor.dupNode(IN_RHS211);


            root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS211_tree, root_2);
            }


            if ( state.backtracking==0 ) { sb.append(", "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval2294);
            expr212=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr212.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            if ( state.backtracking==0 ) {
            }
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:348:10: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==IN_LHS) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:348:12: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS213=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2313); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS213_tree = (CommonTree)adaptor.dupNode(IN_LHS213);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS213_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2317);
            	    expr214=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr214.getTree());


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
            	    IN_RHS215=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2323); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS215_tree = (CommonTree)adaptor.dupNode(IN_RHS215);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS215_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2328);
            	    expr216=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr216.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:351:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );
    public final AstPrinter.func_eval_return func_eval() throws RecognitionException {
        AstPrinter.func_eval_return retval = new AstPrinter.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL217=null;
        CommonTree FUNC_EVAL221=null;
        AstPrinter.func_name_return func_name218 =null;

        AstPrinter.real_arg_return real_arg219 =null;

        AstPrinter.real_arg_return real_arg220 =null;

        AstPrinter.func_name_return func_name222 =null;


        CommonTree FUNC_EVAL217_tree=null;
        CommonTree FUNC_EVAL221_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:352:5: ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:352:7: ^( FUNC_EVAL func_name real_arg ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL217=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL217_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL217);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL217_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2354);
                    func_name218=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name218.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_real_arg_in_func_eval2358);
                    real_arg219=real_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, real_arg219.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:352:59: ( real_arg )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==BIGDECIMALNUMBER||LA57_0==BIGINTEGERNUMBER||LA57_0==CUBE||LA57_0==DIV||LA57_0==DOLLARVAR||LA57_0==DOUBLENUMBER||LA57_0==FALSE||LA57_0==FLOATNUMBER||LA57_0==GROUP||LA57_0==IDENTIFIER||LA57_0==INTEGER||LA57_0==LONGINTEGER||LA57_0==MINUS||LA57_0==NULL||LA57_0==PERCENT||LA57_0==PLUS||LA57_0==QUOTEDSTRING||LA57_0==STAR||LA57_0==TRUE||(LA57_0 >= BAG_VAL && LA57_0 <= BIN_EXPR)||(LA57_0 >= CASE_COND && LA57_0 <= CASE_EXPR)||(LA57_0 >= CAST_EXPR && LA57_0 <= EXPR_IN_PAREN)||LA57_0==FUNC_EVAL||(LA57_0 >= MAP_VAL && LA57_0 <= NEG)||LA57_0==TUPLE_VAL) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:352:61: real_arg
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2364);
                    	    real_arg220=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg220.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:353:7: ^( FUNC_EVAL func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL221=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL221_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL221);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL221_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2382);
                    func_name222=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name222.getTree());


                    if ( state.backtracking==0 ) { sb.append("()"); }

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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:356:1: real_arg : ( expr | STAR | col_range );
    public final AstPrinter.real_arg_return real_arg() throws RecognitionException {
        AstPrinter.real_arg_return retval = new AstPrinter.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR224=null;
        AstPrinter.expr_return expr223 =null;

        AstPrinter.col_range_return col_range225 =null;


        CommonTree STAR224_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:357:5: ( expr | STAR | col_range )
            int alt59=3;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt59=1;
                }
                break;
            case STAR:
                {
                int LA59_2 = input.LA(2);

                if ( (LA59_2==DOWN) ) {
                    alt59=1;
                }
                else if ( (LA59_2==EOF||LA59_2==UP||LA59_2==BIGDECIMALNUMBER||LA59_2==BIGINTEGERNUMBER||LA59_2==CUBE||LA59_2==DIV||LA59_2==DOLLARVAR||LA59_2==DOUBLENUMBER||LA59_2==FALSE||LA59_2==FLOATNUMBER||LA59_2==GROUP||LA59_2==IDENTIFIER||LA59_2==INTEGER||LA59_2==LONGINTEGER||LA59_2==MINUS||LA59_2==NULL||LA59_2==PERCENT||LA59_2==PLUS||LA59_2==QUOTEDSTRING||LA59_2==STAR||LA59_2==TRUE||(LA59_2 >= BAG_VAL && LA59_2 <= BIN_EXPR)||(LA59_2 >= CASE_COND && LA59_2 <= CASE_EXPR)||(LA59_2 >= CAST_EXPR && LA59_2 <= EXPR_IN_PAREN)||LA59_2==FUNC_EVAL||(LA59_2 >= MAP_VAL && LA59_2 <= NEG)||LA59_2==TUPLE_VAL) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt59=3;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:357:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2400);
                    expr223=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr223.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:357:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR224=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR224_tree = (CommonTree)adaptor.dupNode(STAR224);


                    adaptor.addChild(root_0, STAR224_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR224!=null?STAR224.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:357:48: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2410);
                    col_range225=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range225.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:360:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstPrinter.expr_return expr() throws RecognitionException {
        AstPrinter.expr_return retval = new AstPrinter.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS226=null;
        CommonTree MINUS229=null;
        CommonTree STAR232=null;
        CommonTree DIV235=null;
        CommonTree PERCENT238=null;
        CommonTree CAST_EXPR241=null;
        CommonTree NEG246=null;
        CommonTree CAST_EXPR248=null;
        CommonTree EXPR_IN_PAREN251=null;
        AstPrinter.expr_return expr227 =null;

        AstPrinter.expr_return expr228 =null;

        AstPrinter.expr_return expr230 =null;

        AstPrinter.expr_return expr231 =null;

        AstPrinter.expr_return expr233 =null;

        AstPrinter.expr_return expr234 =null;

        AstPrinter.expr_return expr236 =null;

        AstPrinter.expr_return expr237 =null;

        AstPrinter.expr_return expr239 =null;

        AstPrinter.expr_return expr240 =null;

        AstPrinter.type_return type242 =null;

        AstPrinter.expr_return expr243 =null;

        AstPrinter.const_expr_return const_expr244 =null;

        AstPrinter.var_expr_return var_expr245 =null;

        AstPrinter.expr_return expr247 =null;

        AstPrinter.type_cast_return type_cast249 =null;

        AstPrinter.expr_return expr250 =null;

        AstPrinter.expr_return expr252 =null;


        CommonTree PLUS226_tree=null;
        CommonTree MINUS229_tree=null;
        CommonTree STAR232_tree=null;
        CommonTree DIV235_tree=null;
        CommonTree PERCENT238_tree=null;
        CommonTree CAST_EXPR241_tree=null;
        CommonTree NEG246_tree=null;
        CommonTree CAST_EXPR248_tree=null;
        CommonTree EXPR_IN_PAREN251_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:361:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt60=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt60=1;
                }
                break;
            case MINUS:
                {
                int LA60_2 = input.LA(2);

                if ( (synpred109_AstPrinter()) ) {
                    alt60=2;
                }
                else if ( (synpred114_AstPrinter()) ) {
                    alt60=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt60=3;
                }
                break;
            case DIV:
                {
                alt60=4;
                }
                break;
            case PERCENT:
                {
                alt60=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA60_6 = input.LA(2);

                if ( (synpred113_AstPrinter()) ) {
                    alt60=6;
                }
                else if ( (synpred117_AstPrinter()) ) {
                    alt60=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 6, input);

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
                alt60=7;
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
                alt60=8;
                }
                break;
            case NEG:
                {
                alt60=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt60=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:361:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS226=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS226_tree = (CommonTree)adaptor.dupNode(PLUS226);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS226_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2427);
                    expr227=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr227.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PLUS226!=null?PLUS226.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2431);
                    expr228=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr228.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:362:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS229=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS229_tree = (CommonTree)adaptor.dupNode(MINUS229);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS229_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2445);
                    expr230=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr230.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((MINUS229!=null?MINUS229.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2449);
                    expr231=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr231.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:363:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR232=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2461); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR232_tree = (CommonTree)adaptor.dupNode(STAR232);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR232_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2463);
                    expr233=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr233.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR232!=null?STAR232.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2467);
                    expr234=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr234.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:364:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV235=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV235_tree = (CommonTree)adaptor.dupNode(DIV235);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV235_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2481);
                    expr236=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr236.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((DIV235!=null?DIV235.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2485);
                    expr237=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr237.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:365:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT238=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT238_tree = (CommonTree)adaptor.dupNode(PERCENT238);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT238_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2499);
                    expr239=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr239.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PERCENT238!=null?PERCENT238.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2503);
                    expr240=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr240.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:366:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR241=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR241_tree = (CommonTree)adaptor.dupNode(CAST_EXPR241);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR241_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr2519);
                    type242=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type242.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2523);
                    expr243=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr243.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:367:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2533);
                    const_expr244=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:368:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2541);
                    var_expr245=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr245.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:369:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG246=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2551); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG246_tree = (CommonTree)adaptor.dupNode(NEG246);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG246_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((NEG246!=null?NEG246.getText():null)); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2555);
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
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:370:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR248=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR248_tree = (CommonTree)adaptor.dupNode(CAST_EXPR248);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR248_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2571);
                    type_cast249=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast249.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2575);
                    expr250=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr250.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:371:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN251=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN251_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN251);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN251_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2591);
                    expr252=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr252.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:374:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstPrinter.type_cast_return type_cast() throws RecognitionException {
        AstPrinter.type_cast_return retval = new AstPrinter.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type253 =null;

        AstPrinter.map_type_return map_type254 =null;

        AstPrinter.tuple_type_cast_return tuple_type_cast255 =null;

        AstPrinter.bag_type_cast_return bag_type_cast256 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:375:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt61=4;
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
                alt61=1;
                }
                break;
            case MAP_TYPE:
                {
                alt61=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt61=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt61=4;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:375:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2608);
                    simple_type253=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type253.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:375:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2612);
                    map_type254=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type254.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:375:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2616);
                    tuple_type_cast255=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast255.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:375:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2620);
                    bag_type_cast256=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast256.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:378:1: tuple_type_cast : ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) );
    public final AstPrinter.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstPrinter.tuple_type_cast_return retval = new AstPrinter.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST257=null;
        CommonTree TUPLE_TYPE_CAST260=null;
        AstPrinter.type_cast_return type_cast258 =null;

        AstPrinter.type_cast_return type_cast259 =null;

        AstPrinter.type_cast_return type_cast261 =null;


        CommonTree TUPLE_TYPE_CAST257_tree=null;
        CommonTree TUPLE_TYPE_CAST260_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:5: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==TUPLE_TYPE_CAST) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred122_AstPrinter()) ) {
                    alt64=1;
                }
                else if ( (true) ) {
                    alt64=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST257=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST257_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST257);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST257_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2639);
                    type_cast258=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast258.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:61: ( type_cast )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==BIGDECIMAL||LA62_0==BIGINTEGER||LA62_0==BOOLEAN||LA62_0==BYTEARRAY||LA62_0==CHARARRAY||LA62_0==DATETIME||LA62_0==DOUBLE||LA62_0==FLOAT||LA62_0==INT||LA62_0==LONG||LA62_0==BAG_TYPE_CAST||LA62_0==MAP_TYPE||LA62_0==TUPLE_TYPE_CAST) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:63: type_cast
                    	    {
                    	    if ( state.backtracking==0 ) {sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2645);
                    	    type_cast259=type_cast();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, type_cast259.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:380:7: ^( TUPLE_TYPE_CAST ( type_cast )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST260=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST260_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST260);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST260_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:380:51: ( type_cast )?
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==BIGDECIMAL||LA63_0==BIGINTEGER||LA63_0==BOOLEAN||LA63_0==BYTEARRAY||LA63_0==CHARARRAY||LA63_0==DATETIME||LA63_0==DOUBLE||LA63_0==FLOAT||LA63_0==INT||LA63_0==LONG||LA63_0==BAG_TYPE_CAST||LA63_0==MAP_TYPE||LA63_0==TUPLE_TYPE_CAST) ) {
                            alt63=1;
                        }
                        switch (alt63) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:380:51: type_cast
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_type_cast_in_tuple_type_cast2665);
                                type_cast261=type_cast();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, type_cast261.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {sb.append(")"); }

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
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:383:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstPrinter.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstPrinter.bag_type_cast_return retval = new AstPrinter.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST262=null;
        AstPrinter.tuple_type_cast_return tuple_type_cast263 =null;


        CommonTree BAG_TYPE_CAST262_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:384:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:384:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST262=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2685); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST262_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST262);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST262_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:384:47: ( tuple_type_cast )?
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==TUPLE_TYPE_CAST) ) {
                    alt65=1;
                }
                switch (alt65) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:384:47: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2689);
                        tuple_type_cast263=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast263.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) {sb.append("}"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:387:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstPrinter.var_expr_return var_expr() throws RecognitionException {
        AstPrinter.var_expr_return retval = new AstPrinter.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.projectable_expr_return projectable_expr264 =null;

        AstPrinter.dot_proj_return dot_proj265 =null;

        AstPrinter.pound_proj_return pound_proj266 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:388:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:388:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2707);
            projectable_expr264=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr264.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:388:24: ( dot_proj | pound_proj )*
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:388:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2711);
            	    dot_proj265=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj265.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:388:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2715);
            	    pound_proj266=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj266.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop66;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:391:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstPrinter.projectable_expr_return projectable_expr() throws RecognitionException {
        AstPrinter.projectable_expr_return retval = new AstPrinter.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_eval_return func_eval267 =null;

        AstPrinter.col_ref_return col_ref268 =null;

        AstPrinter.bin_expr_return bin_expr269 =null;

        AstPrinter.case_expr_return case_expr270 =null;

        AstPrinter.case_cond_return case_cond271 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt67=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2731);
                    func_eval267=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2735);
                    col_ref268=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref268.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2739);
                    bin_expr269=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr269.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2743);
                    case_expr270=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr270.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:392:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2747);
                    case_cond271=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond271.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:395:1: dot_proj : ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) ;
    public final AstPrinter.dot_proj_return dot_proj() throws RecognitionException {
        AstPrinter.dot_proj_return retval = new AstPrinter.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD272=null;
        AstPrinter.col_alias_or_index_return col_alias_or_index273 =null;

        AstPrinter.col_alias_or_index_return col_alias_or_index274 =null;


        CommonTree PERIOD272_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:396:5: ( ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:396:7: ^( PERIOD col_alias_or_index ( col_alias_or_index )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD272=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD272_tree = (CommonTree)adaptor.dupNode(PERIOD272);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD272_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(".("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2766);
            col_alias_or_index273=col_alias_or_index();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_alias_or_index273.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:396:57: ( col_alias_or_index )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:396:59: col_alias_or_index
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2772);
            	    col_alias_or_index274=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index274.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:399:1: col_alias_or_index : ( col_alias | col_index );
    public final AstPrinter.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstPrinter.col_alias_or_index_return retval = new AstPrinter.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_alias_return col_alias275 =null;

        AstPrinter.col_index_return col_index276 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:399:20: ( col_alias | col_index )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:399:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2788);
                    col_alias275=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias275.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:399:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2792);
                    col_index276=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index276.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:402:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.col_alias_return col_alias() throws RecognitionException {
        AstPrinter.col_alias_return retval = new AstPrinter.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP277=null;
        CommonTree CUBE278=null;
        CommonTree IDENTIFIER279=null;

        CommonTree GROUP277_tree=null;
        CommonTree CUBE278_tree=null;
        CommonTree IDENTIFIER279_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:403:5: ( GROUP | CUBE | IDENTIFIER )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:403:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP277=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias2805); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP277_tree = (CommonTree)adaptor.dupNode(GROUP277);


                    adaptor.addChild(root_0, GROUP277_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP277!=null?GROUP277.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:404:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE278=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias2815); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE278_tree = (CommonTree)adaptor.dupNode(CUBE278);


                    adaptor.addChild(root_0, CUBE278_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE278!=null?CUBE278.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:405:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER279=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias2825); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER279_tree = (CommonTree)adaptor.dupNode(IDENTIFIER279);


                    adaptor.addChild(root_0, IDENTIFIER279_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER279!=null?IDENTIFIER279.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:408:1: col_index : DOLLARVAR ;
    public final AstPrinter.col_index_return col_index() throws RecognitionException {
        AstPrinter.col_index_return retval = new AstPrinter.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR280=null;

        CommonTree DOLLARVAR280_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:409:5: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:409:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR280=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR280_tree = (CommonTree)adaptor.dupNode(DOLLARVAR280);


            adaptor.addChild(root_0, DOLLARVAR280_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR280!=null?DOLLARVAR280.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstPrinter.col_range_return col_range() throws RecognitionException {
        AstPrinter.col_range_return retval = new AstPrinter.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE281=null;
        CommonTree DOUBLE_PERIOD283=null;
        AstPrinter.col_ref_return col_ref282 =null;

        AstPrinter.col_ref_return col_ref284 =null;


        CommonTree COL_RANGE281_tree=null;
        CommonTree DOUBLE_PERIOD283_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE281=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2853); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE281_tree = (CommonTree)adaptor.dupNode(COL_RANGE281);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:26: ( col_ref )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2855);
                    col_ref282=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref282.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { sb.append(".."); }

            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD283=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD283_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD283);


            adaptor.addChild(root_1, DOUBLE_PERIOD283_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:70: ( col_ref )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:412:70: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2862);
                    col_ref284=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref284.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:415:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstPrinter.pound_proj_return pound_proj() throws RecognitionException {
        AstPrinter.pound_proj_return retval = new AstPrinter.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND285=null;
        CommonTree QUOTEDSTRING286=null;
        CommonTree NULL287=null;

        CommonTree POUND285_tree=null;
        CommonTree QUOTEDSTRING286_tree=null;
        CommonTree NULL287_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:416:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:416:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND285=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2879); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND285_tree = (CommonTree)adaptor.dupNode(POUND285);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND285_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((POUND285!=null?POUND285.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:417:9: ( QUOTEDSTRING | NULL )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:417:11: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING286=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj2893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING286_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING286);


                    adaptor.addChild(root_1, QUOTEDSTRING286_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING286!=null?QUOTEDSTRING286.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:417:61: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL287=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj2899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL287_tree = (CommonTree)adaptor.dupNode(NULL287);


                    adaptor.addChild(root_1, NULL287_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL287!=null?NULL287.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:420:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstPrinter.bin_expr_return bin_expr() throws RecognitionException {
        AstPrinter.bin_expr_return retval = new AstPrinter.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR288=null;
        AstPrinter.cond_return cond289 =null;

        AstPrinter.expr_return expr290 =null;

        AstPrinter.expr_return expr291 =null;


        CommonTree BIN_EXPR288_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:421:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:421:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR288=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR288_tree = (CommonTree)adaptor.dupNode(BIN_EXPR288);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR288_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2924);
            cond289=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond289.getTree());


            if ( state.backtracking==0 ) { sb.append(" ? "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2928);
            expr290=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr290.getTree());


            if ( state.backtracking==0 ) { sb.append(" : "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2932);
            expr291=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr291.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:424:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* ) ;
    public final AstPrinter.case_expr_return case_expr() throws RecognitionException {
        AstPrinter.case_expr_return retval = new AstPrinter.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR292=null;
        CommonTree CASE_EXPR_LHS293=null;
        CommonTree CASE_EXPR_RHS295=null;
        CommonTree CASE_EXPR_LHS297=null;
        CommonTree CASE_EXPR_RHS299=null;
        AstPrinter.expr_return expr294 =null;

        AstPrinter.expr_return expr296 =null;

        AstPrinter.expr_return expr298 =null;

        AstPrinter.expr_return expr300 =null;


        CommonTree CASE_EXPR292_tree=null;
        CommonTree CASE_EXPR_LHS293_tree=null;
        CommonTree CASE_EXPR_RHS295_tree=null;
        CommonTree CASE_EXPR_LHS297_tree=null;
        CommonTree CASE_EXPR_RHS299_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:425:5: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:425:7: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR292=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2951); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR292_tree = (CommonTree)adaptor.dupNode(CASE_EXPR292);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR292_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:426:10: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:426:12: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR_LHS293=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR_LHS293_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS293);


            root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS293_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_expr2970);
            expr294=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr294.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:426:36: ( ^( CASE_EXPR_RHS expr ) )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:426:38: ^( CASE_EXPR_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_RHS295=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2978); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_RHS295_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS295);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS295_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2982);
            	    expr296=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr296.getTree());


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


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:427:10: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==CASE_EXPR_LHS) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:427:12: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS297=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr3004); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS297_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS297);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS297_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr3008);
            	    expr298=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr298.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:427:57: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt75=0;
            	    loop75:
            	    do {
            	        int alt75=2;
            	        int LA75_0 = input.LA(1);

            	        if ( (LA75_0==CASE_EXPR_RHS) ) {
            	            alt75=1;
            	        }


            	        switch (alt75) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:427:59: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS299=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr3016); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS299_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS299);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS299_tree, root_2);
            	    	    }


            	    	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr3020);
            	    	    expr300=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr300.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


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


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:430:1: case_cond : ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) ;
    public final AstPrinter.case_cond_return case_cond() throws RecognitionException {
        AstPrinter.case_cond_return retval = new AstPrinter.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND301=null;
        CommonTree WHEN302=null;
        CommonTree THEN305=null;
        AstPrinter.cond_return cond303 =null;

        AstPrinter.cond_return cond304 =null;

        AstPrinter.expr_return expr306 =null;

        AstPrinter.expr_return expr307 =null;


        CommonTree CASE_COND301_tree=null;
        CommonTree WHEN302_tree=null;
        CommonTree THEN305_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:431:5: ( ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:431:7: ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND301=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3047); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND301_tree = (CommonTree)adaptor.dupNode(CASE_COND301);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND301_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN302=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN302_tree = (CommonTree)adaptor.dupNode(WHEN302);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN302_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_case_cond3063);
            cond303=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, cond303.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:432:22: ( cond )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==AND||LA77_0==IN||(LA77_0 >= NOT && LA77_0 <= NUM_OP_NE)||LA77_0==OR||(LA77_0 >= STR_OP_EQ && LA77_0 <= STR_OP_NE)||LA77_0==BOOL_COND||LA77_0==FUNC_EVAL) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:432:24: cond
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3069);
            	    cond304=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond304.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(", "); }

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
            THEN305=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3088); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN305_tree = (CommonTree)adaptor.dupNode(THEN305);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN305_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_cond3090);
            expr306=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr306.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:433:22: ( expr )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==BIGDECIMALNUMBER||LA78_0==BIGINTEGERNUMBER||LA78_0==CUBE||LA78_0==DIV||LA78_0==DOLLARVAR||LA78_0==DOUBLENUMBER||LA78_0==FALSE||LA78_0==FLOATNUMBER||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==INTEGER||LA78_0==LONGINTEGER||LA78_0==MINUS||LA78_0==NULL||LA78_0==PERCENT||LA78_0==PLUS||LA78_0==QUOTEDSTRING||LA78_0==STAR||LA78_0==TRUE||(LA78_0 >= BAG_VAL && LA78_0 <= BIN_EXPR)||(LA78_0 >= CASE_COND && LA78_0 <= CASE_EXPR)||LA78_0==CAST_EXPR||LA78_0==EXPR_IN_PAREN||LA78_0==FUNC_EVAL||(LA78_0 >= MAP_VAL && LA78_0 <= NEG)||LA78_0==TUPLE_VAL) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:433:24: expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3096);
            	    expr307=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr307.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:436:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstPrinter.limit_clause_return limit_clause() throws RecognitionException {
        AstPrinter.limit_clause_return retval = new AstPrinter.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT308=null;
        CommonTree INTEGER310=null;
        CommonTree LONGINTEGER311=null;
        AstPrinter.rel_return rel309 =null;

        AstPrinter.expr_return expr312 =null;


        CommonTree LIMIT308_tree=null;
        CommonTree INTEGER310_tree=null;
        CommonTree LONGINTEGER311_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:437:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:437:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT308=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT308_tree = (CommonTree)adaptor.dupNode(LIMIT308);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT308_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT308!=null?LIMIT308.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3124);
            rel309=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel309.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:9: ( INTEGER | LONGINTEGER | expr )
            int alt79=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA79_1 = input.LA(2);

                if ( (synpred143_AstPrinter()) ) {
                    alt79=1;
                }
                else if ( (true) ) {
                    alt79=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA79_2 = input.LA(2);

                if ( (synpred144_AstPrinter()) ) {
                    alt79=2;
                }
                else if ( (true) ) {
                    alt79=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

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
                alt79=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:11: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER310=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3136); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER310_tree = (CommonTree)adaptor.dupNode(INTEGER310);


                    adaptor.addChild(root_1, INTEGER310_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER310!=null?INTEGER310.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:63: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER311=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER311_tree = (CommonTree)adaptor.dupNode(LONGINTEGER311);


                    adaptor.addChild(root_1, LONGINTEGER311_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((LONGINTEGER311!=null?LONGINTEGER311.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:123: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3148);
                    expr312=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr312.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:441:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstPrinter.sample_clause_return sample_clause() throws RecognitionException {
        AstPrinter.sample_clause_return retval = new AstPrinter.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE313=null;
        CommonTree DOUBLENUMBER315=null;
        AstPrinter.rel_return rel314 =null;

        AstPrinter.expr_return expr316 =null;


        CommonTree SAMPLE313_tree=null;
        CommonTree DOUBLENUMBER315_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:7: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE313=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE313_tree = (CommonTree)adaptor.dupNode(SAMPLE313);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE313_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SAMPLE313!=null?SAMPLE313.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3171);
            rel314=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel314.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:62: ( DOUBLENUMBER | expr )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==DOUBLENUMBER) ) {
                int LA80_1 = input.LA(2);

                if ( (synpred145_AstPrinter()) ) {
                    alt80=1;
                }
                else if ( (true) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA80_0==BIGDECIMALNUMBER||LA80_0==BIGINTEGERNUMBER||LA80_0==CUBE||LA80_0==DIV||LA80_0==DOLLARVAR||LA80_0==FALSE||LA80_0==FLOATNUMBER||LA80_0==GROUP||LA80_0==IDENTIFIER||LA80_0==INTEGER||LA80_0==LONGINTEGER||LA80_0==MINUS||LA80_0==NULL||LA80_0==PERCENT||LA80_0==PLUS||LA80_0==QUOTEDSTRING||LA80_0==STAR||LA80_0==TRUE||(LA80_0 >= BAG_VAL && LA80_0 <= BIN_EXPR)||(LA80_0 >= CASE_COND && LA80_0 <= CASE_EXPR)||LA80_0==CAST_EXPR||LA80_0==EXPR_IN_PAREN||LA80_0==FUNC_EVAL||(LA80_0 >= MAP_VAL && LA80_0 <= NEG)||LA80_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:64: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER315=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3175); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER315_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER315);


                    adaptor.addChild(root_1, DOUBLENUMBER315_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DOUBLENUMBER315!=null?DOUBLENUMBER315.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:126: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3181);
                    expr316=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr316.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:445:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstPrinter.rank_clause_return rank_clause() throws RecognitionException {
        AstPrinter.rank_clause_return retval = new AstPrinter.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK317=null;
        AstPrinter.rel_return rel318 =null;

        AstPrinter.rank_by_statement_return rank_by_statement319 =null;


        CommonTree RANK317_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:446:5: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:446:7: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK317=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK317_tree = (CommonTree)adaptor.dupNode(RANK317);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK317_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((RANK317!=null?RANK317.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3204);
            rel318=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel318.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:446:58: ( rank_by_statement )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==BY) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:446:60: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3208);
                    rank_by_statement319=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement319.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:449:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstPrinter.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstPrinter.rank_by_statement_return retval = new AstPrinter.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY320=null;
        CommonTree DENSE322=null;
        AstPrinter.rank_by_clause_return rank_by_clause321 =null;


        CommonTree BY320_tree=null;
        CommonTree DENSE322_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:450:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:450:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY320=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY320_tree = (CommonTree)adaptor.dupNode(BY320);


            root_1 = (CommonTree)adaptor.becomeRoot(BY320_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY320!=null?BY320.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3229);
            rank_by_clause321=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause321.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:450:62: ( DENSE )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==DENSE) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:450:64: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE322=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE322_tree = (CommonTree)adaptor.dupNode(DENSE322);


                    adaptor.addChild(root_1, DENSE322_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DENSE322!=null?DENSE322.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:453:1: rank_by_clause : ( STAR ( ASC | DESC )? | rank_col ( rank_col )* );
    public final AstPrinter.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstPrinter.rank_by_clause_return retval = new AstPrinter.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR323=null;
        CommonTree ASC324=null;
        CommonTree DESC325=null;
        AstPrinter.rank_col_return rank_col326 =null;

        AstPrinter.rank_col_return rank_col327 =null;


        CommonTree STAR323_tree=null;
        CommonTree ASC324_tree=null;
        CommonTree DESC325_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:454:2: ( STAR ( ASC | DESC )? | rank_col ( rank_col )* )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==STAR) ) {
                alt85=1;
            }
            else if ( (LA85_0==CUBE||LA85_0==DOLLARVAR||LA85_0==GROUP||LA85_0==IDENTIFIER||LA85_0==COL_RANGE) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }
            switch (alt85) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:454:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR323=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR323_tree = (CommonTree)adaptor.dupNode(STAR323);


                    adaptor.addChild(root_0, STAR323_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR323!=null?STAR323.getText():null)); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:454:36: ( ASC | DESC )?
                    int alt83=3;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==DESC) ) {
                        alt83=2;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:454:38: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC324=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3256); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC324_tree = (CommonTree)adaptor.dupNode(ASC324);


                            adaptor.addChild(root_0, ASC324_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC324!=null?ASC324.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:454:82: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC325=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3262); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC325_tree = (CommonTree)adaptor.dupNode(DESC325);


                            adaptor.addChild(root_0, DESC325_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC325!=null?DESC325.getText():null)); }

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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:455:7: rank_col ( rank_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_col_in_rank_by_clause3275);
                    rank_col326=rank_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_col326.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:455:16: ( rank_col )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:455:18: rank_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3281);
                    	    rank_col327=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col327.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:458:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.rank_col_return rank_col() throws RecognitionException {
        AstPrinter.rank_col_return retval = new AstPrinter.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC330=null;
        CommonTree DESC331=null;
        AstPrinter.col_range_return col_range328 =null;

        AstPrinter.col_ref_return col_ref329 =null;


        CommonTree ASC330_tree=null;
        CommonTree DESC331_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:4: ( col_range | col_ref )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==COL_RANGE) ) {
                alt86=1;
            }
            else if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||LA86_0==GROUP||LA86_0==IDENTIFIER) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3296);
                    col_range328=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range328.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3300);
                    col_ref329=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref329.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:28: ( ASC | DESC )?
            int alt87=3;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==ASC) ) {
                alt87=1;
            }
            else if ( (LA87_0==DESC) ) {
                alt87=2;
            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:30: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC330=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC330_tree = (CommonTree)adaptor.dupNode(ASC330);


                    adaptor.addChild(root_0, ASC330_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC330!=null?ASC330.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:459:74: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC331=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC331_tree = (CommonTree)adaptor.dupNode(DESC331);


                    adaptor.addChild(root_0, DESC331_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC331!=null?DESC331.getText():null)); }

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
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:462:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstPrinter.order_clause_return order_clause() throws RecognitionException {
        AstPrinter.order_clause_return retval = new AstPrinter.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER332=null;
        AstPrinter.rel_return rel333 =null;

        AstPrinter.order_by_clause_return order_by_clause334 =null;

        AstPrinter.func_clause_return func_clause335 =null;


        CommonTree ORDER332_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:463:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:463:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER332=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3332); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER332_tree = (CommonTree)adaptor.dupNode(ORDER332);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER332_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER332!=null?ORDER332.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3336);
            rel333=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel333.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3348);
            order_by_clause334=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause334.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:465:9: ( func_clause )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==FUNC||LA88_0==FUNC_REF) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:465:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3362);
                    func_clause335=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause335.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:468:1: order_by_clause : ( STAR ( ASC | DESC )? | order_col ( order_col )* );
    public final AstPrinter.order_by_clause_return order_by_clause() throws RecognitionException {
        AstPrinter.order_by_clause_return retval = new AstPrinter.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR336=null;
        CommonTree ASC337=null;
        CommonTree DESC338=null;
        AstPrinter.order_col_return order_col339 =null;

        AstPrinter.order_col_return order_col340 =null;


        CommonTree STAR336_tree=null;
        CommonTree ASC337_tree=null;
        CommonTree DESC338_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:469:5: ( STAR ( ASC | DESC )? | order_col ( order_col )* )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:469:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR336=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR336_tree = (CommonTree)adaptor.dupNode(STAR336);


                    adaptor.addChild(root_0, STAR336_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR336!=null?STAR336.getText():null)); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:469:39: ( ASC | DESC )?
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
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:469:41: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC337=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3386); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC337_tree = (CommonTree)adaptor.dupNode(ASC337);


                            adaptor.addChild(root_0, ASC337_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC337!=null?ASC337.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:469:85: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC338=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3392); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC338_tree = (CommonTree)adaptor.dupNode(DESC338);


                            adaptor.addChild(root_0, DESC338_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC338!=null?DESC338.getText():null)); }

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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:470:7: order_col ( order_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_col_in_order_by_clause3405);
                    order_col339=order_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_col339.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:470:17: ( order_col )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:470:19: order_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause3411);
                    	    order_col340=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col340.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:473:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.order_col_return order_col() throws RecognitionException {
        AstPrinter.order_col_return retval = new AstPrinter.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC343=null;
        CommonTree DESC344=null;
        AstPrinter.col_range_return col_range341 =null;

        AstPrinter.col_ref_return col_ref342 =null;


        CommonTree ASC343_tree=null;
        CommonTree DESC344_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:7: ( col_range | col_ref )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==COL_RANGE) ) {
                alt92=1;
            }
            else if ( (LA92_0==CUBE||LA92_0==DOLLARVAR||LA92_0==GROUP||LA92_0==IDENTIFIER) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }
            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col3427);
                    col_range341=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range341.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col3431);
                    col_ref342=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref342.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:29: ( ASC | DESC )?
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:31: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC343=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3436); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC343_tree = (CommonTree)adaptor.dupNode(ASC343);


                    adaptor.addChild(root_0, ASC343_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC343!=null?ASC343.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:474:75: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC344=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC344_tree = (CommonTree)adaptor.dupNode(DESC344);


                    adaptor.addChild(root_0, DESC344_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC344!=null?DESC344.getText():null)); }

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
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:477:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstPrinter.distinct_clause_return distinct_clause() throws RecognitionException {
        AstPrinter.distinct_clause_return retval = new AstPrinter.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT345=null;
        AstPrinter.rel_return rel346 =null;

        AstPrinter.partition_clause_return partition_clause347 =null;


        CommonTree DISTINCT345_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:478:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:478:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT345=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT345_tree = (CommonTree)adaptor.dupNode(DISTINCT345);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT345_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT345!=null?DISTINCT345.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3466);
            rel346=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel346.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:478:66: ( partition_clause )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==PARTITION) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:478:66: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3468);
                    partition_clause347=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause347.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:481:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstPrinter.partition_clause_return partition_clause() throws RecognitionException {
        AstPrinter.partition_clause_return retval = new AstPrinter.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION348=null;
        AstPrinter.func_name_return func_name349 =null;


        CommonTree PARTITION348_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:482:5: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:482:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION348=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3486); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION348_tree = (CommonTree)adaptor.dupNode(PARTITION348);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION348_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARTITION348!=null?PARTITION348.getText():null)).append(" BY "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3490);
            func_name349=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name349.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:485:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstPrinter.cross_clause_return cross_clause() throws RecognitionException {
        AstPrinter.cross_clause_return retval = new AstPrinter.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS350=null;
        AstPrinter.rel_list_return rel_list351 =null;

        AstPrinter.partition_clause_return partition_clause352 =null;


        CommonTree CROSS350_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:486:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:486:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS350=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS350_tree = (CommonTree)adaptor.dupNode(CROSS350);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS350_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS350!=null?CROSS350.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3511);
            rel_list351=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list351.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:486:65: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:486:65: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3513);
                    partition_clause352=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause352.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:489:1: rel_list : rel ( rel )* ;
    public final AstPrinter.rel_list_return rel_list() throws RecognitionException {
        AstPrinter.rel_list_return retval = new AstPrinter.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel353 =null;

        AstPrinter.rel_return rel354 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:490:5: ( rel ( rel )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:490:7: rel ( rel )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rel_list3529);
            rel353=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel353.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:490:11: ( rel )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==ASSERT||LA96_0==COGROUP||(LA96_0 >= CROSS && LA96_0 <= CUBE)||LA96_0==DEFINE||LA96_0==DISTINCT||LA96_0==FILTER||LA96_0==FOREACH||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==JOIN||(LA96_0 >= LIMIT && LA96_0 <= LOAD)||LA96_0==MAPREDUCE||LA96_0==ORDER||LA96_0==RANK||LA96_0==SAMPLE||LA96_0==SPLIT||(LA96_0 >= STORE && LA96_0 <= STREAM)||LA96_0==UNION) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:490:13: rel
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3535);
            	    rel354=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel354.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop96;
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
    // $ANTLR end "rel_list"


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:493:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstPrinter.join_clause_return join_clause() throws RecognitionException {
        AstPrinter.join_clause_return retval = new AstPrinter.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN355=null;
        AstPrinter.join_sub_clause_return join_sub_clause356 =null;

        AstPrinter.join_type_return join_type357 =null;

        AstPrinter.partition_clause_return partition_clause358 =null;


        CommonTree JOIN355_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:494:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:494:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN355=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause3552); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN355_tree = (CommonTree)adaptor.dupNode(JOIN355);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN355_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((JOIN355!=null?JOIN355.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause3556);
            join_sub_clause356=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause356.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:494:70: ( join_type )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==QUOTEDSTRING) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:494:72: join_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause3562);
                    join_type357=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type357.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:495:5: ( partition_clause )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==PARTITION) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:495:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause3573);
                    partition_clause358=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause358.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:498:1: join_type : QUOTEDSTRING ;
    public final AstPrinter.join_type_return join_type() throws RecognitionException {
        AstPrinter.join_type_return retval = new AstPrinter.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING359=null;

        CommonTree QUOTEDSTRING359_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:498:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:498:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING359=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3587); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING359_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING359);


            adaptor.addChild(root_0, QUOTEDSTRING359_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING359!=null?QUOTEDSTRING359.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:501:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* );
    public final AstPrinter.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstPrinter.join_sub_clause_return retval = new AstPrinter.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT361=null;
        CommonTree RIGHT362=null;
        CommonTree FULL363=null;
        CommonTree OUTER364=null;
        AstPrinter.join_item_return join_item360 =null;

        AstPrinter.join_item_return join_item365 =null;

        AstPrinter.join_item_return join_item366 =null;

        AstPrinter.join_item_return join_item367 =null;


        CommonTree LEFT361_tree=null;
        CommonTree RIGHT362_tree=null;
        CommonTree FULL363_tree=null;
        CommonTree OUTER364_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==JOIN_ITEM) ) {
                int LA102_1 = input.LA(2);

                if ( (synpred171_AstPrinter()) ) {
                    alt102=1;
                }
                else if ( (true) ) {
                    alt102=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3602);
                    join_item360=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item360.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:17: ( LEFT | RIGHT | FULL )
                    int alt99=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt99=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt99=2;
                        }
                        break;
                    case FULL:
                        {
                        alt99=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 99, 0, input);

                        throw nvae;

                    }

                    switch (alt99) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:19: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT361=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause3606); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT361_tree = (CommonTree)adaptor.dupNode(LEFT361);


                            adaptor.addChild(root_0, LEFT361_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((LEFT361!=null?LEFT361.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:503:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT362=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause3625); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT362_tree = (CommonTree)adaptor.dupNode(RIGHT362);


                            adaptor.addChild(root_0, RIGHT362_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((RIGHT362!=null?RIGHT362.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:504:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL363=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause3644); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL363_tree = (CommonTree)adaptor.dupNode(FULL363);


                            adaptor.addChild(root_0, FULL363_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((FULL363!=null?FULL363.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:505:16: ( OUTER )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==OUTER) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:505:17: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER364=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3664); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER364_tree = (CommonTree)adaptor.dupNode(OUTER364);


                            adaptor.addChild(root_0, OUTER364_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((OUTER364!=null?OUTER364.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3673);
                    join_item365=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item365.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:506:7: join_item ( join_item )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3681);
                    join_item366=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item366.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:506:17: ( join_item )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==JOIN_ITEM) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:506:19: join_item
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause3687);
                    	    join_item367=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item367.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:509:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstPrinter.join_item_return join_item() throws RecognitionException {
        AstPrinter.join_item_return retval = new AstPrinter.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM368=null;
        AstPrinter.rel_return rel369 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause370 =null;


        CommonTree JOIN_ITEM368_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:510:5: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:510:7: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM368=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item3705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM368_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM368);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM368_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item3707);
            rel369=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel369.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item3709);
            join_group_by_clause370=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause370.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:513:1: join_group_by_clause : ^( BY join_group_by_expr ( join_group_by_expr )* ) ;
    public final AstPrinter.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstPrinter.join_group_by_clause_return retval = new AstPrinter.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY371=null;
        AstPrinter.join_group_by_expr_return join_group_by_expr372 =null;

        AstPrinter.join_group_by_expr_return join_group_by_expr373 =null;


        CommonTree BY371_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:514:5: ( ^( BY join_group_by_expr ( join_group_by_expr )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:514:7: ^( BY join_group_by_expr ( join_group_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY371=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause3726); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY371_tree = (CommonTree)adaptor.dupNode(BY371);


            root_1 = (CommonTree)adaptor.becomeRoot(BY371_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY371!=null?BY371.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3734);
            join_group_by_expr372=join_group_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_expr372.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:515:24: ( join_group_by_expr )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==BIGDECIMALNUMBER||LA103_0==BIGINTEGERNUMBER||LA103_0==CUBE||LA103_0==DIV||LA103_0==DOLLARVAR||LA103_0==DOUBLENUMBER||LA103_0==FALSE||LA103_0==FLOATNUMBER||LA103_0==GROUP||LA103_0==IDENTIFIER||LA103_0==INTEGER||LA103_0==LONGINTEGER||LA103_0==MINUS||LA103_0==NULL||LA103_0==PERCENT||LA103_0==PLUS||LA103_0==QUOTEDSTRING||LA103_0==STAR||LA103_0==TRUE||(LA103_0 >= BAG_VAL && LA103_0 <= BIN_EXPR)||(LA103_0 >= CASE_COND && LA103_0 <= CASE_EXPR)||(LA103_0 >= CAST_EXPR && LA103_0 <= EXPR_IN_PAREN)||LA103_0==FUNC_EVAL||(LA103_0 >= MAP_VAL && LA103_0 <= NEG)||LA103_0==TUPLE_VAL) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:515:26: join_group_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3740);
            	    join_group_by_expr373=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr373.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:518:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstPrinter.join_group_by_expr_return retval = new AstPrinter.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR376=null;
        AstPrinter.col_range_return col_range374 =null;

        AstPrinter.expr_return expr375 =null;


        CommonTree STAR376_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:519:5: ( col_range | expr | STAR )
            int alt104=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt104=1;
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
                alt104=2;
                }
                break;
            case STAR:
                {
                int LA104_3 = input.LA(2);

                if ( (LA104_3==DOWN) ) {
                    alt104=2;
                }
                else if ( (LA104_3==EOF||LA104_3==UP||LA104_3==BIGDECIMALNUMBER||LA104_3==BIGINTEGERNUMBER||LA104_3==CUBE||LA104_3==DIV||LA104_3==DOLLARVAR||LA104_3==DOUBLENUMBER||LA104_3==FALSE||LA104_3==FLOATNUMBER||LA104_3==GROUP||LA104_3==IDENTIFIER||LA104_3==INTEGER||LA104_3==LONGINTEGER||LA104_3==MINUS||LA104_3==NULL||LA104_3==PERCENT||LA104_3==PLUS||LA104_3==QUOTEDSTRING||LA104_3==STAR||LA104_3==TRUE||(LA104_3 >= BAG_VAL && LA104_3 <= BIN_EXPR)||(LA104_3 >= CASE_COND && LA104_3 <= CASE_EXPR)||(LA104_3 >= CAST_EXPR && LA104_3 <= EXPR_IN_PAREN)||LA104_3==FUNC_EVAL||(LA104_3 >= MAP_VAL && LA104_3 <= NEG)||LA104_3==TUPLE_VAL) ) {
                    alt104=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }

            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:519:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr3760);
                    col_range374=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range374.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:519:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr3764);
                    expr375=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr375.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:519:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR376=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr3768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR376_tree = (CommonTree)adaptor.dupNode(STAR376);


                    adaptor.addChild(root_0, STAR376_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR376!=null?STAR376.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:522:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstPrinter.union_clause_return union_clause() throws RecognitionException {
        AstPrinter.union_clause_return retval = new AstPrinter.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION377=null;
        CommonTree ONSCHEMA378=null;
        AstPrinter.rel_list_return rel_list379 =null;


        CommonTree UNION377_tree=null;
        CommonTree ONSCHEMA378_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:523:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:523:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION377=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause3785); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION377_tree = (CommonTree)adaptor.dupNode(UNION377);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION377_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((UNION377!=null?UNION377.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:523:56: ( ONSCHEMA )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==ONSCHEMA) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:523:57: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA378=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA378_tree = (CommonTree)adaptor.dupNode(ONSCHEMA378);


                    adaptor.addChild(root_1, ONSCHEMA378_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ONSCHEMA378!=null?ONSCHEMA378.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause3797);
            rel_list379=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list379.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:526:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstPrinter.foreach_clause_return foreach_clause() throws RecognitionException {
        AstPrinter.foreach_clause_return retval = new AstPrinter.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH380=null;
        AstPrinter.rel_return rel381 =null;

        AstPrinter.foreach_plan_return foreach_plan382 =null;


        CommonTree FOREACH380_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:527:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:527:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH380=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause3814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH380_tree = (CommonTree)adaptor.dupNode(FOREACH380);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH380_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH380!=null?FOREACH380.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause3818);
            rel381=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel381.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause3820);
            foreach_plan382=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan382.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:530:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstPrinter.foreach_plan_return foreach_plan() throws RecognitionException {
        AstPrinter.foreach_plan_return retval = new AstPrinter.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE383=null;
        CommonTree FOREACH_PLAN_COMPLEX385=null;
        AstPrinter.generate_clause_return generate_clause384 =null;

        AstPrinter.nested_blk_return nested_blk386 =null;


        CommonTree FOREACH_PLAN_SIMPLE383_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX385_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:531:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FOREACH_PLAN_SIMPLE) ) {
                alt106=1;
            }
            else if ( (LA106_0==FOREACH_PLAN_COMPLEX) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;

            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:531:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE383=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE383_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE383);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE383_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan3839);
                    generate_clause384=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause384.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:532:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX385=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX385_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX385);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX385_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan3853);
                    nested_blk386=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk386.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:535:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstPrinter.nested_blk_return nested_blk() throws RecognitionException {
        AstPrinter.nested_blk_return retval = new AstPrinter.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_command_return nested_command387 =null;

        AstPrinter.generate_clause_return generate_clause388 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:536:5: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:536:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( state.backtracking==0 ) { sb.append(" { "); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:536:29: ( nested_command )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( ((LA107_0 >= NESTED_CMD && LA107_0 <= NESTED_CMD_ASSI)) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:536:30: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk3871);
            	    nested_command387=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command387.getTree());


            	    if ( state.backtracking==0 ) { sb.append("; "); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk3878);
            generate_clause388=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause388.getTree());


            if ( state.backtracking==0 ) { sb.append("; } "); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:539:1: generate_clause : ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) ;
    public final AstPrinter.generate_clause_return generate_clause() throws RecognitionException {
        AstPrinter.generate_clause_return retval = new AstPrinter.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE389=null;
        AstPrinter.flatten_generated_item_return flatten_generated_item390 =null;

        AstPrinter.flatten_generated_item_return flatten_generated_item391 =null;


        CommonTree GENERATE389_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:540:5: ( ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:540:7: ^( GENERATE flatten_generated_item ( flatten_generated_item )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE389=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause3895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE389_tree = (CommonTree)adaptor.dupNode(GENERATE389);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE389_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((GENERATE389!=null?GENERATE389.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3907);
            flatten_generated_item390=flatten_generated_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, flatten_generated_item390.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:541:32: ( flatten_generated_item )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==BIGDECIMALNUMBER||LA108_0==BIGINTEGERNUMBER||LA108_0==CUBE||LA108_0==DIV||LA108_0==DOLLARVAR||LA108_0==DOUBLENUMBER||LA108_0==FALSE||LA108_0==FLATTEN||LA108_0==FLOATNUMBER||LA108_0==GROUP||LA108_0==IDENTIFIER||LA108_0==INTEGER||LA108_0==LONGINTEGER||LA108_0==MINUS||LA108_0==NULL||LA108_0==PERCENT||LA108_0==PLUS||LA108_0==QUOTEDSTRING||LA108_0==STAR||LA108_0==TRUE||(LA108_0 >= BAG_VAL && LA108_0 <= BIN_EXPR)||(LA108_0 >= CASE_COND && LA108_0 <= CASE_EXPR)||(LA108_0 >= CAST_EXPR && LA108_0 <= EXPR_IN_PAREN)||LA108_0==FUNC_EVAL||(LA108_0 >= MAP_VAL && LA108_0 <= NEG)||LA108_0==TUPLE_VAL) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:541:34: flatten_generated_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3913);
            	    flatten_generated_item391=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item391.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop108;
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
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:544:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstPrinter.nested_command_return nested_command() throws RecognitionException {
        AstPrinter.nested_command_return retval = new AstPrinter.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD392=null;
        CommonTree IDENTIFIER393=null;
        CommonTree NESTED_CMD_ASSI395=null;
        CommonTree IDENTIFIER396=null;
        AstPrinter.nested_op_return nested_op394 =null;

        AstPrinter.expr_return expr397 =null;


        CommonTree NESTED_CMD392_tree=null;
        CommonTree IDENTIFIER393_tree=null;
        CommonTree NESTED_CMD_ASSI395_tree=null;
        CommonTree IDENTIFIER396_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:545:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:545:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD392=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command3932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD392_tree = (CommonTree)adaptor.dupNode(NESTED_CMD392);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD392_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER393=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3934); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER393_tree = (CommonTree)adaptor.dupNode(IDENTIFIER393);


                    adaptor.addChild(root_1, IDENTIFIER393_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER393!=null?IDENTIFIER393.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command3938);
                    nested_op394=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op394.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:546:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI395=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI395_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI395);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI395_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER396=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER396_tree = (CommonTree)adaptor.dupNode(IDENTIFIER396);


                    adaptor.addChild(root_1, IDENTIFIER396_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER396!=null?IDENTIFIER396.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3956);
                    expr397=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr397.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:549:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstPrinter.nested_op_return nested_op() throws RecognitionException {
        AstPrinter.nested_op_return retval = new AstPrinter.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_proj_return nested_proj398 =null;

        AstPrinter.nested_filter_return nested_filter399 =null;

        AstPrinter.nested_sort_return nested_sort400 =null;

        AstPrinter.nested_distinct_return nested_distinct401 =null;

        AstPrinter.nested_limit_return nested_limit402 =null;

        AstPrinter.nested_cross_return nested_cross403 =null;

        AstPrinter.nested_foreach_return nested_foreach404 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:549:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:549:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3967);
                    nested_proj398=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj398.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:550:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3981);
                    nested_filter399=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter399.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:551:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3995);
                    nested_sort400=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort400.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:552:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4009);
                    nested_distinct401=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct401.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:553:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4023);
                    nested_limit402=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit402.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:554:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4037);
                    nested_cross403=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross403.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:555:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4051);
                    nested_foreach404=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach404.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:558:1: nested_proj : ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) ;
    public final AstPrinter.nested_proj_return nested_proj() throws RecognitionException {
        AstPrinter.nested_proj_return retval = new AstPrinter.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ405=null;
        AstPrinter.col_ref_return col_ref406 =null;

        AstPrinter.col_ref_return col_ref407 =null;

        AstPrinter.col_ref_return col_ref408 =null;


        CommonTree NESTED_PROJ405_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:559:5: ( ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:559:7: ^( NESTED_PROJ col_ref col_ref ( col_ref )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ405=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ405_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ405);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ405_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4068);
            col_ref406=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref406.getTree());


            if ( state.backtracking==0 ) { sb.append(".("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4072);
            col_ref407=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref407.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:559:59: ( col_ref )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:559:61: col_ref
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4078);
            	    col_ref408=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref408.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:562:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstPrinter.nested_filter_return nested_filter() throws RecognitionException {
        AstPrinter.nested_filter_return retval = new AstPrinter.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER409=null;
        AstPrinter.nested_op_input_return nested_op_input410 =null;

        AstPrinter.cond_return cond411 =null;


        CommonTree FILTER409_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:563:5: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:563:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER409=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4099); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER409_tree = (CommonTree)adaptor.dupNode(FILTER409);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER409_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER409!=null?FILTER409.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4103);
            nested_op_input410=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input410.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4107);
            cond411=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond411.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:566:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstPrinter.nested_sort_return nested_sort() throws RecognitionException {
        AstPrinter.nested_sort_return retval = new AstPrinter.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER412=null;
        AstPrinter.nested_op_input_return nested_op_input413 =null;

        AstPrinter.order_by_clause_return order_by_clause414 =null;

        AstPrinter.func_clause_return func_clause415 =null;


        CommonTree ORDER412_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:567:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:567:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER412=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER412_tree = (CommonTree)adaptor.dupNode(ORDER412);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER412_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER412!=null?ORDER412.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4128);
            nested_op_input413=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input413.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4140);
            order_by_clause414=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause414.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:568:48: ( func_clause )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==FUNC||LA112_0==FUNC_REF) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:568:50: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4146);
                    func_clause415=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause415.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:571:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstPrinter.nested_distinct_return nested_distinct() throws RecognitionException {
        AstPrinter.nested_distinct_return retval = new AstPrinter.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT416=null;
        AstPrinter.nested_op_input_return nested_op_input417 =null;


        CommonTree DISTINCT416_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:572:5: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:572:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT416=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4165); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT416_tree = (CommonTree)adaptor.dupNode(DISTINCT416);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT416_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT416!=null?DISTINCT416.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4170);
            nested_op_input417=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input417.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:575:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstPrinter.nested_limit_return nested_limit() throws RecognitionException {
        AstPrinter.nested_limit_return retval = new AstPrinter.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT418=null;
        CommonTree INTEGER420=null;
        AstPrinter.nested_op_input_return nested_op_input419 =null;

        AstPrinter.expr_return expr421 =null;


        CommonTree LIMIT418_tree=null;
        CommonTree INTEGER420_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT418=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4187); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT418_tree = (CommonTree)adaptor.dupNode(LIMIT418);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT418_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT418!=null?LIMIT418.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4192);
            nested_op_input419=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input419.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:73: ( INTEGER | expr )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==INTEGER) ) {
                int LA113_1 = input.LA(2);

                if ( (synpred189_AstPrinter()) ) {
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
            else if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||LA113_0==CAST_EXPR||LA113_0==EXPR_IN_PAREN||LA113_0==FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:75: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER420=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER420_tree = (CommonTree)adaptor.dupNode(INTEGER420);


                    adaptor.addChild(root_1, INTEGER420_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER420!=null?INTEGER420.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:127: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4202);
                    expr421=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr421.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:579:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstPrinter.nested_cross_return nested_cross() throws RecognitionException {
        AstPrinter.nested_cross_return retval = new AstPrinter.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS422=null;
        AstPrinter.nested_op_input_list_return nested_op_input_list423 =null;


        CommonTree CROSS422_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:580:5: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:580:7: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS422=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4221); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS422_tree = (CommonTree)adaptor.dupNode(CROSS422);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS422_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS422!=null?CROSS422.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4226);
            nested_op_input_list423=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list423.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:583:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstPrinter.nested_foreach_return nested_foreach() throws RecognitionException {
        AstPrinter.nested_foreach_return retval = new AstPrinter.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH424=null;
        AstPrinter.nested_op_input_return nested_op_input425 =null;

        AstPrinter.generate_clause_return generate_clause426 =null;


        CommonTree FOREACH424_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:584:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:584:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH424=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH424_tree = (CommonTree)adaptor.dupNode(FOREACH424);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH424_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH424!=null?FOREACH424.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4245);
            nested_op_input425=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input425.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4247);
            generate_clause426=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause426.getTree());


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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:587:1: nested_op_input : ( col_ref | nested_proj );
    public final AstPrinter.nested_op_input_return nested_op_input() throws RecognitionException {
        AstPrinter.nested_op_input_return retval = new AstPrinter.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_ref_return col_ref427 =null;

        AstPrinter.nested_proj_return nested_proj428 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:587:17: ( col_ref | nested_proj )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==CUBE||LA114_0==DOLLARVAR||LA114_0==GROUP||LA114_0==IDENTIFIER) ) {
                alt114=1;
            }
            else if ( (LA114_0==NESTED_PROJ) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }
            switch (alt114) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:587:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input4258);
                    col_ref427=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref427.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:587:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input4262);
                    nested_proj428=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj428.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:590:1: nested_op_input_list : nested_op_input ( nested_op_input )* ;
    public final AstPrinter.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstPrinter.nested_op_input_list_return retval = new AstPrinter.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_op_input_return nested_op_input429 =null;

        AstPrinter.nested_op_input_return nested_op_input430 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:591:5: ( nested_op_input ( nested_op_input )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:591:7: nested_op_input ( nested_op_input )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4275);
            nested_op_input429=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, nested_op_input429.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:591:23: ( nested_op_input )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER||LA115_0==NESTED_PROJ) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:591:25: nested_op_input
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4281);
            	    nested_op_input430=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input430.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop115;
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
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:594:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstPrinter.stream_clause_return stream_clause() throws RecognitionException {
        AstPrinter.stream_clause_return retval = new AstPrinter.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM431=null;
        CommonTree EXECCOMMAND433=null;
        CommonTree IDENTIFIER434=null;
        AstPrinter.rel_return rel432 =null;

        AstPrinter.as_clause_return as_clause435 =null;


        CommonTree STREAM431_tree=null;
        CommonTree EXECCOMMAND433_tree=null;
        CommonTree IDENTIFIER434_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:595:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:595:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM431=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause4298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM431_tree = (CommonTree)adaptor.dupNode(STREAM431);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM431_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STREAM431!=null?STREAM431.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause4302);
            rel432=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel432.getTree());


            if ( state.backtracking==0 ) { sb.append(" THROUGH "); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:596:9: ( EXECCOMMAND | IDENTIFIER )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==EXECCOMMAND) ) {
                alt116=1;
            }
            else if ( (LA116_0==IDENTIFIER) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }
            switch (alt116) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:596:11: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND433=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause4316); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND433_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND433);


                    adaptor.addChild(root_1, EXECCOMMAND433_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EXECCOMMAND433!=null?EXECCOMMAND433.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:597:11: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER434=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause4330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER434_tree = (CommonTree)adaptor.dupNode(IDENTIFIER434);


                    adaptor.addChild(root_1, IDENTIFIER434_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER434!=null?IDENTIFIER434.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:597:57: ( as_clause )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==AS) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:597:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause4336);
                    as_clause435=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause435.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:600:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstPrinter.mr_clause_return mr_clause() throws RecognitionException {
        AstPrinter.mr_clause_return retval = new AstPrinter.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE436=null;
        CommonTree QUOTEDSTRING437=null;
        CommonTree EXECCOMMAND441=null;
        AstPrinter.path_list_return path_list438 =null;

        AstPrinter.store_clause_return store_clause439 =null;

        AstPrinter.load_clause_return load_clause440 =null;


        CommonTree MAPREDUCE436_tree=null;
        CommonTree QUOTEDSTRING437_tree=null;
        CommonTree EXECCOMMAND441_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:601:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:601:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE436=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause4354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE436_tree = (CommonTree)adaptor.dupNode(MAPREDUCE436);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE436_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING437=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause4356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING437_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING437);


            adaptor.addChild(root_1, QUOTEDSTRING437_tree);
            }


            if ( state.backtracking==0 ) { sb.append((MAPREDUCE436!=null?MAPREDUCE436.getText():null)).append(" ").append((QUOTEDSTRING437!=null?QUOTEDSTRING437.getText():null)).append(" "); }

            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:602:9: ( path_list )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==QUOTEDSTRING) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:602:10: path_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause4371);
                    path_list438=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list438.getTree());


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause4378);
            store_clause439=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause439.getTree());


            if ( state.backtracking==0 ) { sb.append(" "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause4382);
            load_clause440=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause440.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:603:9: ( EXECCOMMAND )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==EXECCOMMAND) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:603:10: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND441=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause4393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND441_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND441);


                    adaptor.addChild(root_1, EXECCOMMAND441_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((EXECCOMMAND441!=null?EXECCOMMAND441.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:606:1: split_clause : ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) ;
    public final AstPrinter.split_clause_return split_clause() throws RecognitionException {
        AstPrinter.split_clause_return retval = new AstPrinter.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT442=null;
        AstPrinter.rel_return rel443 =null;

        AstPrinter.split_branch_return split_branch444 =null;

        AstPrinter.split_branch_return split_branch445 =null;

        AstPrinter.split_otherwise_return split_otherwise446 =null;


        CommonTree SPLIT442_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:607:5: ( ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:607:7: ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT442=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause4415); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT442_tree = (CommonTree)adaptor.dupNode(SPLIT442);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT442_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SPLIT442!=null?SPLIT442.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause4428);
            rel443=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel443.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_branch_in_split_clause4432);
            split_branch444=split_branch();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, split_branch444.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:608:51: ( split_branch )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==SPLIT_BRANCH) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:608:53: split_branch
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause4438);
            	    split_branch445=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch445.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:608:90: ( split_otherwise )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==OTHERWISE) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:608:92: split_otherwise
                    {
                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause4447);
                    split_otherwise446=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise446.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:611:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstPrinter.split_branch_return split_branch() throws RecognitionException {
        AstPrinter.split_branch_return retval = new AstPrinter.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH447=null;
        AstPrinter.alias_return alias448 =null;

        AstPrinter.cond_return cond449 =null;


        CommonTree SPLIT_BRANCH447_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:612:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:612:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH447=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch4467); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH447_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH447);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH447_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch4469);
            alias448=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias448.getTree());


            if ( state.backtracking==0 ) { sb.append(" IF "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch4473);
            cond449=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond449.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:615:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstPrinter.split_otherwise_return split_otherwise() throws RecognitionException {
        AstPrinter.split_otherwise_return retval = new AstPrinter.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE450=null;
        AstPrinter.alias_return alias451 =null;


        CommonTree OTHERWISE450_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:616:5: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:616:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE450=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise4490); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE450_tree = (CommonTree)adaptor.dupNode(OTHERWISE450);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE450_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise4492);
            alias451=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias451.getTree());


            if ( state.backtracking==0 ) { sb.append(" " + (OTHERWISE450!=null?OTHERWISE450.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:619:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstPrinter.col_ref_return col_ref() throws RecognitionException {
        AstPrinter.col_ref_return retval = new AstPrinter.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_col_ref_return alias_col_ref452 =null;

        AstPrinter.dollar_col_ref_return dollar_col_ref453 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:619:9: ( alias_col_ref | dollar_col_ref )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==CUBE||LA122_0==GROUP||LA122_0==IDENTIFIER) ) {
                alt122=1;
            }
            else if ( (LA122_0==DOLLARVAR) ) {
                alt122=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }
            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:619:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref4505);
                    alias_col_ref452=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref452.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:619:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref4509);
                    dollar_col_ref453=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref453.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:622:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstPrinter.alias_col_ref_return retval = new AstPrinter.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP454=null;
        CommonTree CUBE455=null;
        CommonTree IDENTIFIER456=null;

        CommonTree GROUP454_tree=null;
        CommonTree CUBE455_tree=null;
        CommonTree IDENTIFIER456_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:623:5: ( GROUP | CUBE | IDENTIFIER )
            int alt123=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt123=1;
                }
                break;
            case CUBE:
                {
                alt123=2;
                }
                break;
            case IDENTIFIER:
                {
                alt123=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }

            switch (alt123) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:623:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP454=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref4522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP454_tree = (CommonTree)adaptor.dupNode(GROUP454);


                    adaptor.addChild(root_0, GROUP454_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP454!=null?GROUP454.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:624:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE455=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref4532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE455_tree = (CommonTree)adaptor.dupNode(CUBE455);


                    adaptor.addChild(root_0, CUBE455_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE455!=null?CUBE455.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:625:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER456=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref4542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER456_tree = (CommonTree)adaptor.dupNode(IDENTIFIER456);


                    adaptor.addChild(root_0, IDENTIFIER456_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER456!=null?IDENTIFIER456.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:628:1: dollar_col_ref : DOLLARVAR ;
    public final AstPrinter.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstPrinter.dollar_col_ref_return retval = new AstPrinter.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR457=null;

        CommonTree DOLLARVAR457_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:629:5: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:629:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR457=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref4557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR457_tree = (CommonTree)adaptor.dupNode(DOLLARVAR457);


            adaptor.addChild(root_0, DOLLARVAR457_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR457!=null?DOLLARVAR457.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:632:1: const_expr : literal ;
    public final AstPrinter.const_expr_return const_expr() throws RecognitionException {
        AstPrinter.const_expr_return retval = new AstPrinter.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.literal_return literal458 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:632:12: ( literal )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:632:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr4568);
            literal458=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal458.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:1: literal : ( scalar | map | bag | tuple );
    public final AstPrinter.literal_return literal() throws RecognitionException {
        AstPrinter.literal_return retval = new AstPrinter.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scalar_return scalar459 =null;

        AstPrinter.map_return map460 =null;

        AstPrinter.bag_return bag461 =null;

        AstPrinter.tuple_return tuple462 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:9: ( scalar | map | bag | tuple )
            int alt124=4;
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
                alt124=1;
                }
                break;
            case MAP_VAL:
                {
                alt124=2;
                }
                break;
            case BAG_VAL:
                {
                alt124=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt124=4;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal4577);
                    scalar459=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar459.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal4581);
                    map460=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map460.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal4585);
                    bag461=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag461.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:635:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal4589);
                    tuple462=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple462.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:638:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstPrinter.scalar_return scalar() throws RecognitionException {
        AstPrinter.scalar_return retval = new AstPrinter.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING464=null;
        CommonTree NULL465=null;
        CommonTree TRUE466=null;
        CommonTree FALSE467=null;
        AstPrinter.num_scalar_return num_scalar463 =null;


        CommonTree QUOTEDSTRING464_tree=null;
        CommonTree NULL465_tree=null;
        CommonTree TRUE466_tree=null;
        CommonTree FALSE467_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:638:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt125=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt125=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt125=2;
                }
                break;
            case NULL:
                {
                alt125=3;
                }
                break;
            case TRUE:
                {
                alt125=4;
                }
                break;
            case FALSE:
                {
                alt125=5;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:638:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar4598);
                    num_scalar463=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar463.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:639:10: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING464=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar4609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING464_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING464);


                    adaptor.addChild(root_0, QUOTEDSTRING464_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING464!=null?QUOTEDSTRING464.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:640:10: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL465=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar4622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL465_tree = (CommonTree)adaptor.dupNode(NULL465);


                    adaptor.addChild(root_0, NULL465_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL465!=null?NULL465.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:641:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE466=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar4635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE466_tree = (CommonTree)adaptor.dupNode(TRUE466);


                    adaptor.addChild(root_0, TRUE466_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE466!=null?TRUE466.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:642:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE467=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar4648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE467_tree = (CommonTree)adaptor.dupNode(FALSE467);


                    adaptor.addChild(root_0, FALSE467_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE467!=null?FALSE467.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:645:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstPrinter.num_scalar_return num_scalar() throws RecognitionException {
        AstPrinter.num_scalar_return retval = new AstPrinter.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS468=null;
        CommonTree INTEGER469=null;
        CommonTree LONGINTEGER470=null;
        CommonTree FLOATNUMBER471=null;
        CommonTree DOUBLENUMBER472=null;
        CommonTree BIGINTEGERNUMBER473=null;
        CommonTree BIGDECIMALNUMBER474=null;

        CommonTree MINUS468_tree=null;
        CommonTree INTEGER469_tree=null;
        CommonTree LONGINTEGER470_tree=null;
        CommonTree FLOATNUMBER471_tree=null;
        CommonTree DOUBLENUMBER472_tree=null;
        CommonTree BIGINTEGERNUMBER473_tree=null;
        CommonTree BIGDECIMALNUMBER474_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:645:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:645:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:645:14: ( MINUS )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==MINUS) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:645:16: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS468=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar4661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS468_tree = (CommonTree)adaptor.dupNode(MINUS468);


                    adaptor.addChild(root_0, MINUS468_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append( "-" ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:646:14: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt127=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt127=1;
                }
                break;
            case LONGINTEGER:
                {
                alt127=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt127=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt127=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt127=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt127=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;

            }

            switch (alt127) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:646:16: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER469=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar4683); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER469_tree = (CommonTree)adaptor.dupNode(INTEGER469);


                    adaptor.addChild(root_0, INTEGER469_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTEGER469!=null?INTEGER469.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:647:16: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER470=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar4702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER470_tree = (CommonTree)adaptor.dupNode(LONGINTEGER470);


                    adaptor.addChild(root_0, LONGINTEGER470_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONGINTEGER470!=null?LONGINTEGER470.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:648:16: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER471=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar4721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER471_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER471);


                    adaptor.addChild(root_0, FLOATNUMBER471_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOATNUMBER471!=null?FLOATNUMBER471.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:649:16: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER472=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar4740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER472_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER472);


                    adaptor.addChild(root_0, DOUBLENUMBER472_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLENUMBER472!=null?DOUBLENUMBER472.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:650:16: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER473=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar4759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER473_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER473);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER473_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGERNUMBER473!=null?BIGINTEGERNUMBER473.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:651:16: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER474=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar4778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER474_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER474);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER474_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMALNUMBER474!=null?BIGDECIMALNUMBER474.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:655:1: map : ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) );
    public final AstPrinter.map_return map() throws RecognitionException {
        AstPrinter.map_return retval = new AstPrinter.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL475=null;
        CommonTree MAP_VAL478=null;
        AstPrinter.keyvalue_return keyvalue476 =null;

        AstPrinter.keyvalue_return keyvalue477 =null;


        CommonTree MAP_VAL475_tree=null;
        CommonTree MAP_VAL478_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:656:5: ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==MAP_VAL) ) {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==DOWN) ) {
                    int LA129_2 = input.LA(3);

                    if ( (LA129_2==KEY_VAL_PAIR) ) {
                        alt129=1;
                    }
                    else if ( (LA129_2==UP) ) {
                        alt129=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 129, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 129, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;

            }
            switch (alt129) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:656:7: ^( MAP_VAL keyvalue ( keyvalue )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL475=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL475_tree = (CommonTree)adaptor.dupNode(MAP_VAL475);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL475_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("["); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_keyvalue_in_map4814);
                    keyvalue476=keyvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, keyvalue476.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:656:47: ( keyvalue )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==KEY_VAL_PAIR) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:656:49: keyvalue
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyvalue_in_map4820);
                    	    keyvalue477=keyvalue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, keyvalue477.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop128;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("]"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:657:7: ^( MAP_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL478=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL478_tree = (CommonTree)adaptor.dupNode(MAP_VAL478);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL478_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("[]"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:660:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstPrinter.keyvalue_return keyvalue() throws RecognitionException {
        AstPrinter.keyvalue_return retval = new AstPrinter.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR479=null;
        AstPrinter.map_key_return map_key480 =null;

        AstPrinter.const_expr_return const_expr481 =null;


        CommonTree KEY_VAL_PAIR479_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:661:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:661:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR479=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue4855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR479_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR479);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR479_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue4857);
            map_key480=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key480.getTree());


            if ( state.backtracking==0 ) { sb.append("#"); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue4861);
            const_expr481=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr481.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:664:1: map_key : QUOTEDSTRING ;
    public final AstPrinter.map_key_return map_key() throws RecognitionException {
        AstPrinter.map_key_return retval = new AstPrinter.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING482=null;

        CommonTree QUOTEDSTRING482_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:664:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:664:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING482=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key4872); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING482_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING482);


            adaptor.addChild(root_0, QUOTEDSTRING482_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING482!=null?QUOTEDSTRING482.getText():null)); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:667:1: bag : ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) );
    public final AstPrinter.bag_return bag() throws RecognitionException {
        AstPrinter.bag_return retval = new AstPrinter.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL483=null;
        CommonTree BAG_VAL486=null;
        AstPrinter.tuple_return tuple484 =null;

        AstPrinter.tuple_return tuple485 =null;


        CommonTree BAG_VAL483_tree=null;
        CommonTree BAG_VAL486_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:668:5: ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==BAG_VAL) ) {
                int LA131_1 = input.LA(2);

                if ( (LA131_1==DOWN) ) {
                    int LA131_2 = input.LA(3);

                    if ( (LA131_2==TUPLE_VAL) ) {
                        alt131=1;
                    }
                    else if ( (LA131_2==UP) ) {
                        alt131=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;

            }
            switch (alt131) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:668:7: ^( BAG_VAL tuple ( tuple )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL483=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL483_tree = (CommonTree)adaptor.dupNode(BAG_VAL483);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL483_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{"); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_bag4893);
                    tuple484=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, tuple484.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:668:44: ( tuple )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( (LA130_0==TUPLE_VAL) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:668:46: tuple
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tuple_in_bag4899);
                    	    tuple485=tuple();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, tuple485.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop130;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("}"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:669:7: ^( BAG_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL486=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL486_tree = (CommonTree)adaptor.dupNode(BAG_VAL486);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL486_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{}"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:672:1: tuple : ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) );
    public final AstPrinter.tuple_return tuple() throws RecognitionException {
        AstPrinter.tuple_return retval = new AstPrinter.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL487=null;
        CommonTree TUPLE_VAL490=null;
        AstPrinter.literal_return literal488 =null;

        AstPrinter.literal_return literal489 =null;


        CommonTree TUPLE_VAL487_tree=null;
        CommonTree TUPLE_VAL490_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:673:5: ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==TUPLE_VAL) ) {
                int LA133_1 = input.LA(2);

                if ( (LA133_1==DOWN) ) {
                    int LA133_2 = input.LA(3);

                    if ( (LA133_2==BIGDECIMALNUMBER||LA133_2==BIGINTEGERNUMBER||LA133_2==DOUBLENUMBER||LA133_2==FALSE||LA133_2==FLOATNUMBER||LA133_2==INTEGER||LA133_2==LONGINTEGER||LA133_2==MINUS||LA133_2==NULL||LA133_2==QUOTEDSTRING||LA133_2==TRUE||LA133_2==BAG_VAL||LA133_2==MAP_VAL||LA133_2==TUPLE_VAL) ) {
                        alt133=1;
                    }
                    else if ( (LA133_2==UP) ) {
                        alt133=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 133, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 133, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }
            switch (alt133) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:673:7: ^( TUPLE_VAL literal ( literal )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL487=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4934); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL487_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL487);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL487_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_literal_in_tuple4938);
                    literal488=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, literal488.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:673:48: ( literal )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( (LA132_0==BIGDECIMALNUMBER||LA132_0==BIGINTEGERNUMBER||LA132_0==DOUBLENUMBER||LA132_0==FALSE||LA132_0==FLOATNUMBER||LA132_0==INTEGER||LA132_0==LONGINTEGER||LA132_0==MINUS||LA132_0==NULL||LA132_0==QUOTEDSTRING||LA132_0==TRUE||LA132_0==BAG_VAL||LA132_0==MAP_VAL||LA132_0==TUPLE_VAL) ) {
                            alt132=1;
                        }


                        switch (alt132) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:673:50: literal
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_literal_in_tuple4945);
                    	    literal489=literal();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, literal489.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop132;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:674:7: ^( TUPLE_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL490=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL490_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL490);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL490_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:678:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE | ASSERT );
    public final AstPrinter.eid_return eid() throws RecognitionException {
        AstPrinter.eid_return retval = new AstPrinter.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT492=null;
        CommonTree RETURNS493=null;
        CommonTree DEFINE494=null;
        CommonTree LOAD495=null;
        CommonTree FILTER496=null;
        CommonTree FOREACH497=null;
        CommonTree CUBE498=null;
        CommonTree ROLLUP499=null;
        CommonTree PIVOT500=null;
        CommonTree CHUNKSIZE501=null;
        CommonTree RATE502=null;
        CommonTree MATCHES503=null;
        CommonTree ORDER504=null;
        CommonTree RANK505=null;
        CommonTree DISTINCT506=null;
        CommonTree COGROUP507=null;
        CommonTree JOIN508=null;
        CommonTree CROSS509=null;
        CommonTree UNION510=null;
        CommonTree SPLIT511=null;
        CommonTree INTO512=null;
        CommonTree IF513=null;
        CommonTree ALL514=null;
        CommonTree AS515=null;
        CommonTree BY516=null;
        CommonTree USING517=null;
        CommonTree INNER518=null;
        CommonTree OUTER519=null;
        CommonTree PARALLEL520=null;
        CommonTree PARTITION521=null;
        CommonTree GROUP522=null;
        CommonTree AND523=null;
        CommonTree OR524=null;
        CommonTree NOT525=null;
        CommonTree GENERATE526=null;
        CommonTree FLATTEN527=null;
        CommonTree EVAL528=null;
        CommonTree ASC529=null;
        CommonTree DESC530=null;
        CommonTree BOOLEAN531=null;
        CommonTree INT532=null;
        CommonTree LONG533=null;
        CommonTree FLOAT534=null;
        CommonTree DOUBLE535=null;
        CommonTree BIGINTEGER536=null;
        CommonTree BIGDECIMAL537=null;
        CommonTree DATETIME538=null;
        CommonTree CHARARRAY539=null;
        CommonTree BYTEARRAY540=null;
        CommonTree BAG541=null;
        CommonTree TUPLE542=null;
        CommonTree MAP543=null;
        CommonTree IS544=null;
        CommonTree NULL545=null;
        CommonTree TRUE546=null;
        CommonTree FALSE547=null;
        CommonTree STREAM548=null;
        CommonTree THROUGH549=null;
        CommonTree STORE550=null;
        CommonTree MAPREDUCE551=null;
        CommonTree SHIP552=null;
        CommonTree CACHE553=null;
        CommonTree INPUT554=null;
        CommonTree OUTPUT555=null;
        CommonTree STDERROR556=null;
        CommonTree STDIN557=null;
        CommonTree STDOUT558=null;
        CommonTree LIMIT559=null;
        CommonTree SAMPLE560=null;
        CommonTree LEFT561=null;
        CommonTree RIGHT562=null;
        CommonTree FULL563=null;
        CommonTree IDENTIFIER564=null;
        CommonTree TOBAG565=null;
        CommonTree TOMAP566=null;
        CommonTree TOTUPLE567=null;
        CommonTree IN568=null;
        CommonTree CASE569=null;
        CommonTree ASSERT570=null;
        AstPrinter.rel_str_op_return rel_str_op491 =null;


        CommonTree IMPORT492_tree=null;
        CommonTree RETURNS493_tree=null;
        CommonTree DEFINE494_tree=null;
        CommonTree LOAD495_tree=null;
        CommonTree FILTER496_tree=null;
        CommonTree FOREACH497_tree=null;
        CommonTree CUBE498_tree=null;
        CommonTree ROLLUP499_tree=null;
        CommonTree PIVOT500_tree=null;
        CommonTree CHUNKSIZE501_tree=null;
        CommonTree RATE502_tree=null;
        CommonTree MATCHES503_tree=null;
        CommonTree ORDER504_tree=null;
        CommonTree RANK505_tree=null;
        CommonTree DISTINCT506_tree=null;
        CommonTree COGROUP507_tree=null;
        CommonTree JOIN508_tree=null;
        CommonTree CROSS509_tree=null;
        CommonTree UNION510_tree=null;
        CommonTree SPLIT511_tree=null;
        CommonTree INTO512_tree=null;
        CommonTree IF513_tree=null;
        CommonTree ALL514_tree=null;
        CommonTree AS515_tree=null;
        CommonTree BY516_tree=null;
        CommonTree USING517_tree=null;
        CommonTree INNER518_tree=null;
        CommonTree OUTER519_tree=null;
        CommonTree PARALLEL520_tree=null;
        CommonTree PARTITION521_tree=null;
        CommonTree GROUP522_tree=null;
        CommonTree AND523_tree=null;
        CommonTree OR524_tree=null;
        CommonTree NOT525_tree=null;
        CommonTree GENERATE526_tree=null;
        CommonTree FLATTEN527_tree=null;
        CommonTree EVAL528_tree=null;
        CommonTree ASC529_tree=null;
        CommonTree DESC530_tree=null;
        CommonTree BOOLEAN531_tree=null;
        CommonTree INT532_tree=null;
        CommonTree LONG533_tree=null;
        CommonTree FLOAT534_tree=null;
        CommonTree DOUBLE535_tree=null;
        CommonTree BIGINTEGER536_tree=null;
        CommonTree BIGDECIMAL537_tree=null;
        CommonTree DATETIME538_tree=null;
        CommonTree CHARARRAY539_tree=null;
        CommonTree BYTEARRAY540_tree=null;
        CommonTree BAG541_tree=null;
        CommonTree TUPLE542_tree=null;
        CommonTree MAP543_tree=null;
        CommonTree IS544_tree=null;
        CommonTree NULL545_tree=null;
        CommonTree TRUE546_tree=null;
        CommonTree FALSE547_tree=null;
        CommonTree STREAM548_tree=null;
        CommonTree THROUGH549_tree=null;
        CommonTree STORE550_tree=null;
        CommonTree MAPREDUCE551_tree=null;
        CommonTree SHIP552_tree=null;
        CommonTree CACHE553_tree=null;
        CommonTree INPUT554_tree=null;
        CommonTree OUTPUT555_tree=null;
        CommonTree STDERROR556_tree=null;
        CommonTree STDIN557_tree=null;
        CommonTree STDOUT558_tree=null;
        CommonTree LIMIT559_tree=null;
        CommonTree SAMPLE560_tree=null;
        CommonTree LEFT561_tree=null;
        CommonTree RIGHT562_tree=null;
        CommonTree FULL563_tree=null;
        CommonTree IDENTIFIER564_tree=null;
        CommonTree TOBAG565_tree=null;
        CommonTree TOMAP566_tree=null;
        CommonTree TOTUPLE567_tree=null;
        CommonTree IN568_tree=null;
        CommonTree CASE569_tree=null;
        CommonTree ASSERT570_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:678:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE | ASSERT )
            int alt134=80;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt134=1;
                }
                break;
            case IMPORT:
                {
                alt134=2;
                }
                break;
            case RETURNS:
                {
                alt134=3;
                }
                break;
            case DEFINE:
                {
                alt134=4;
                }
                break;
            case LOAD:
                {
                alt134=5;
                }
                break;
            case FILTER:
                {
                alt134=6;
                }
                break;
            case FOREACH:
                {
                alt134=7;
                }
                break;
            case CUBE:
                {
                alt134=8;
                }
                break;
            case ROLLUP:
                {
                alt134=9;
                }
                break;
            case PIVOT:
                {
                alt134=10;
                }
                break;
            case CHUNKSIZE:
                {
                alt134=11;
                }
                break;
            case RATE:
                {
                alt134=12;
                }
                break;
            case MATCHES:
                {
                alt134=13;
                }
                break;
            case ORDER:
                {
                alt134=14;
                }
                break;
            case RANK:
                {
                alt134=15;
                }
                break;
            case DISTINCT:
                {
                alt134=16;
                }
                break;
            case COGROUP:
                {
                alt134=17;
                }
                break;
            case JOIN:
                {
                alt134=18;
                }
                break;
            case CROSS:
                {
                alt134=19;
                }
                break;
            case UNION:
                {
                alt134=20;
                }
                break;
            case SPLIT:
                {
                alt134=21;
                }
                break;
            case INTO:
                {
                alt134=22;
                }
                break;
            case IF:
                {
                alt134=23;
                }
                break;
            case ALL:
                {
                alt134=24;
                }
                break;
            case AS:
                {
                alt134=25;
                }
                break;
            case BY:
                {
                alt134=26;
                }
                break;
            case USING:
                {
                alt134=27;
                }
                break;
            case INNER:
                {
                alt134=28;
                }
                break;
            case OUTER:
                {
                alt134=29;
                }
                break;
            case PARALLEL:
                {
                alt134=30;
                }
                break;
            case PARTITION:
                {
                alt134=31;
                }
                break;
            case GROUP:
                {
                alt134=32;
                }
                break;
            case AND:
                {
                alt134=33;
                }
                break;
            case OR:
                {
                alt134=34;
                }
                break;
            case NOT:
                {
                alt134=35;
                }
                break;
            case GENERATE:
                {
                alt134=36;
                }
                break;
            case FLATTEN:
                {
                alt134=37;
                }
                break;
            case EVAL:
                {
                alt134=38;
                }
                break;
            case ASC:
                {
                alt134=39;
                }
                break;
            case DESC:
                {
                alt134=40;
                }
                break;
            case BOOLEAN:
                {
                alt134=41;
                }
                break;
            case INT:
                {
                alt134=42;
                }
                break;
            case LONG:
                {
                alt134=43;
                }
                break;
            case FLOAT:
                {
                alt134=44;
                }
                break;
            case DOUBLE:
                {
                alt134=45;
                }
                break;
            case BIGINTEGER:
                {
                alt134=46;
                }
                break;
            case BIGDECIMAL:
                {
                alt134=47;
                }
                break;
            case DATETIME:
                {
                alt134=48;
                }
                break;
            case CHARARRAY:
                {
                alt134=49;
                }
                break;
            case BYTEARRAY:
                {
                alt134=50;
                }
                break;
            case BAG:
                {
                alt134=51;
                }
                break;
            case TUPLE:
                {
                alt134=52;
                }
                break;
            case MAP:
                {
                alt134=53;
                }
                break;
            case IS:
                {
                alt134=54;
                }
                break;
            case NULL:
                {
                alt134=55;
                }
                break;
            case TRUE:
                {
                alt134=56;
                }
                break;
            case FALSE:
                {
                alt134=57;
                }
                break;
            case STREAM:
                {
                alt134=58;
                }
                break;
            case THROUGH:
                {
                alt134=59;
                }
                break;
            case STORE:
                {
                alt134=60;
                }
                break;
            case MAPREDUCE:
                {
                alt134=61;
                }
                break;
            case SHIP:
                {
                alt134=62;
                }
                break;
            case CACHE:
                {
                alt134=63;
                }
                break;
            case INPUT:
                {
                alt134=64;
                }
                break;
            case OUTPUT:
                {
                alt134=65;
                }
                break;
            case STDERROR:
                {
                alt134=66;
                }
                break;
            case STDIN:
                {
                alt134=67;
                }
                break;
            case STDOUT:
                {
                alt134=68;
                }
                break;
            case LIMIT:
                {
                alt134=69;
                }
                break;
            case SAMPLE:
                {
                alt134=70;
                }
                break;
            case LEFT:
                {
                alt134=71;
                }
                break;
            case RIGHT:
                {
                alt134=72;
                }
                break;
            case FULL:
                {
                alt134=73;
                }
                break;
            case IDENTIFIER:
                {
                alt134=74;
                }
                break;
            case TOBAG:
                {
                alt134=75;
                }
                break;
            case TOMAP:
                {
                alt134=76;
                }
                break;
            case TOTUPLE:
                {
                alt134=77;
                }
                break;
            case IN:
                {
                alt134=78;
                }
                break;
            case CASE:
                {
                alt134=79;
                }
                break;
            case ASSERT:
                {
                alt134=80;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:678:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid4975);
                    rel_str_op491=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op491.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:679:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT492=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid4983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT492_tree = (CommonTree)adaptor.dupNode(IMPORT492);


                    adaptor.addChild(root_0, IMPORT492_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IMPORT492!=null?IMPORT492.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:680:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS493=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid4996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS493_tree = (CommonTree)adaptor.dupNode(RETURNS493);


                    adaptor.addChild(root_0, RETURNS493_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RETURNS493!=null?RETURNS493.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:681:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE494=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE494_tree = (CommonTree)adaptor.dupNode(DEFINE494);


                    adaptor.addChild(root_0, DEFINE494_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DEFINE494!=null?DEFINE494.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:682:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD495=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD495_tree = (CommonTree)adaptor.dupNode(LOAD495);


                    adaptor.addChild(root_0, LOAD495_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LOAD495!=null?LOAD495.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:683:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER496=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER496_tree = (CommonTree)adaptor.dupNode(FILTER496);


                    adaptor.addChild(root_0, FILTER496_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FILTER496!=null?FILTER496.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:684:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH497=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH497_tree = (CommonTree)adaptor.dupNode(FOREACH497);


                    adaptor.addChild(root_0, FOREACH497_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FOREACH497!=null?FOREACH497.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:685:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE498=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE498_tree = (CommonTree)adaptor.dupNode(CUBE498);


                    adaptor.addChild(root_0, CUBE498_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE498!=null?CUBE498.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:686:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP499=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5076); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP499_tree = (CommonTree)adaptor.dupNode(ROLLUP499);


                    adaptor.addChild(root_0, ROLLUP499_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP499!=null?ROLLUP499.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:687:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT500=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid5089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT500_tree = (CommonTree)adaptor.dupNode(PIVOT500);


                    adaptor.addChild(root_0, PIVOT500_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PIVOT500!=null?PIVOT500.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:688:7: CHUNKSIZE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHUNKSIZE501=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_eid5103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHUNKSIZE501_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE501);


                    adaptor.addChild(root_0, CHUNKSIZE501_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHUNKSIZE501!=null?CHUNKSIZE501.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:689:7: RATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RATE502=(CommonTree)match(input,RATE,FOLLOW_RATE_in_eid5113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RATE502_tree = (CommonTree)adaptor.dupNode(RATE502);


                    adaptor.addChild(root_0, RATE502_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RATE502!=null?RATE502.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:690:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES503=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES503_tree = (CommonTree)adaptor.dupNode(MATCHES503);


                    adaptor.addChild(root_0, MATCHES503_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MATCHES503!=null?MATCHES503.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:691:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER504=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER504_tree = (CommonTree)adaptor.dupNode(ORDER504);


                    adaptor.addChild(root_0, ORDER504_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ORDER504!=null?ORDER504.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:692:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK505=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid5154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK505_tree = (CommonTree)adaptor.dupNode(RANK505);


                    adaptor.addChild(root_0, RANK505_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RANK505!=null?RANK505.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:693:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT506=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT506_tree = (CommonTree)adaptor.dupNode(DISTINCT506);


                    adaptor.addChild(root_0, DISTINCT506_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DISTINCT506!=null?DISTINCT506.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:694:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP507=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP507_tree = (CommonTree)adaptor.dupNode(COGROUP507);


                    adaptor.addChild(root_0, COGROUP507_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP507!=null?COGROUP507.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:695:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN508=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN508_tree = (CommonTree)adaptor.dupNode(JOIN508);


                    adaptor.addChild(root_0, JOIN508_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((JOIN508!=null?JOIN508.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:696:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS509=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5207); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS509_tree = (CommonTree)adaptor.dupNode(CROSS509);


                    adaptor.addChild(root_0, CROSS509_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CROSS509!=null?CROSS509.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:697:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION510=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION510_tree = (CommonTree)adaptor.dupNode(UNION510);


                    adaptor.addChild(root_0, UNION510_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((UNION510!=null?UNION510.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:698:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT511=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid5235); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT511_tree = (CommonTree)adaptor.dupNode(SPLIT511);


                    adaptor.addChild(root_0, SPLIT511_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SPLIT511!=null?SPLIT511.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:699:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO512=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid5249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO512_tree = (CommonTree)adaptor.dupNode(INTO512);


                    adaptor.addChild(root_0, INTO512_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTO512!=null?INTO512.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:700:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF513=(CommonTree)match(input,IF,FOLLOW_IF_in_eid5264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF513_tree = (CommonTree)adaptor.dupNode(IF513);


                    adaptor.addChild(root_0, IF513_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IF513!=null?IF513.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:701:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL514=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid5281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL514_tree = (CommonTree)adaptor.dupNode(ALL514);


                    adaptor.addChild(root_0, ALL514_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ALL514!=null?ALL514.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:702:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS515=(CommonTree)match(input,AS,FOLLOW_AS_in_eid5297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS515_tree = (CommonTree)adaptor.dupNode(AS515);


                    adaptor.addChild(root_0, AS515_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AS515!=null?AS515.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:703:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY516=(CommonTree)match(input,BY,FOLLOW_BY_in_eid5314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY516_tree = (CommonTree)adaptor.dupNode(BY516);


                    adaptor.addChild(root_0, BY516_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BY516!=null?BY516.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:704:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING517=(CommonTree)match(input,USING,FOLLOW_USING_in_eid5331); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING517_tree = (CommonTree)adaptor.dupNode(USING517);


                    adaptor.addChild(root_0, USING517_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((USING517!=null?USING517.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:705:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER518=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid5345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER518_tree = (CommonTree)adaptor.dupNode(INNER518);


                    adaptor.addChild(root_0, INNER518_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INNER518!=null?INNER518.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:706:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER519=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid5359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER519_tree = (CommonTree)adaptor.dupNode(OUTER519);


                    adaptor.addChild(root_0, OUTER519_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTER519!=null?OUTER519.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:707:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL520=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid5373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL520_tree = (CommonTree)adaptor.dupNode(PARALLEL520);


                    adaptor.addChild(root_0, PARALLEL520_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARALLEL520!=null?PARALLEL520.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:708:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION521=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid5384); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION521_tree = (CommonTree)adaptor.dupNode(PARTITION521);


                    adaptor.addChild(root_0, PARTITION521_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARTITION521!=null?PARTITION521.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:709:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP522=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid5394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP522_tree = (CommonTree)adaptor.dupNode(GROUP522);


                    adaptor.addChild(root_0, GROUP522_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP522!=null?GROUP522.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:710:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND523=(CommonTree)match(input,AND,FOLLOW_AND_in_eid5408); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND523_tree = (CommonTree)adaptor.dupNode(AND523);


                    adaptor.addChild(root_0, AND523_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AND523!=null?AND523.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:711:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR524=(CommonTree)match(input,OR,FOLLOW_OR_in_eid5424); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR524_tree = (CommonTree)adaptor.dupNode(OR524);


                    adaptor.addChild(root_0, OR524_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OR524!=null?OR524.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:712:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT525=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid5441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT525_tree = (CommonTree)adaptor.dupNode(NOT525);


                    adaptor.addChild(root_0, NOT525_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NOT525!=null?NOT525.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:713:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE526=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid5457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE526_tree = (CommonTree)adaptor.dupNode(GENERATE526);


                    adaptor.addChild(root_0, GENERATE526_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GENERATE526!=null?GENERATE526.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:714:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN527=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid5468); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN527_tree = (CommonTree)adaptor.dupNode(FLATTEN527);


                    adaptor.addChild(root_0, FLATTEN527_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLATTEN527!=null?FLATTEN527.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:715:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL528=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid5480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL528_tree = (CommonTree)adaptor.dupNode(EVAL528);


                    adaptor.addChild(root_0, EVAL528_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EVAL528!=null?EVAL528.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:716:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC529=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid5495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC529_tree = (CommonTree)adaptor.dupNode(ASC529);


                    adaptor.addChild(root_0, ASC529_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASC529!=null?ASC529.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:717:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC530=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid5511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC530_tree = (CommonTree)adaptor.dupNode(DESC530);


                    adaptor.addChild(root_0, DESC530_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DESC530!=null?DESC530.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:718:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN531=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid5526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN531_tree = (CommonTree)adaptor.dupNode(BOOLEAN531);


                    adaptor.addChild(root_0, BOOLEAN531_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN531!=null?BOOLEAN531.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:719:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT532=(CommonTree)match(input,INT,FOLLOW_INT_in_eid5538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT532_tree = (CommonTree)adaptor.dupNode(INT532);


                    adaptor.addChild(root_0, INT532_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT532!=null?INT532.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:720:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG533=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid5554); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG533_tree = (CommonTree)adaptor.dupNode(LONG533);


                    adaptor.addChild(root_0, LONG533_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG533!=null?LONG533.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:721:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT534=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid5569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT534_tree = (CommonTree)adaptor.dupNode(FLOAT534);


                    adaptor.addChild(root_0, FLOAT534_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT534!=null?FLOAT534.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:722:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE535=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid5583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE535_tree = (CommonTree)adaptor.dupNode(DOUBLE535);


                    adaptor.addChild(root_0, DOUBLE535_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE535!=null?DOUBLE535.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:723:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER536=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid5596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER536_tree = (CommonTree)adaptor.dupNode(BIGINTEGER536);


                    adaptor.addChild(root_0, BIGINTEGER536_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER536!=null?BIGINTEGER536.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:724:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL537=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid5605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL537_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL537);


                    adaptor.addChild(root_0, BIGDECIMAL537_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL537!=null?BIGDECIMAL537.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:725:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME538=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid5614); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME538_tree = (CommonTree)adaptor.dupNode(DATETIME538);


                    adaptor.addChild(root_0, DATETIME538_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME538!=null?DATETIME538.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:726:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY539=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid5625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY539_tree = (CommonTree)adaptor.dupNode(CHARARRAY539);


                    adaptor.addChild(root_0, CHARARRAY539_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY539!=null?CHARARRAY539.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:727:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY540=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid5635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY540_tree = (CommonTree)adaptor.dupNode(BYTEARRAY540);


                    adaptor.addChild(root_0, BYTEARRAY540_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY540!=null?BYTEARRAY540.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:728:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG541=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid5645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG541_tree = (CommonTree)adaptor.dupNode(BAG541);


                    adaptor.addChild(root_0, BAG541_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BAG541!=null?BAG541.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:729:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE542=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid5661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE542_tree = (CommonTree)adaptor.dupNode(TUPLE542);


                    adaptor.addChild(root_0, TUPLE542_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TUPLE542!=null?TUPLE542.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:730:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP543=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid5675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP543_tree = (CommonTree)adaptor.dupNode(MAP543);


                    adaptor.addChild(root_0, MAP543_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAP543!=null?MAP543.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:731:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS544=(CommonTree)match(input,IS,FOLLOW_IS_in_eid5691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS544_tree = (CommonTree)adaptor.dupNode(IS544);


                    adaptor.addChild(root_0, IS544_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IS544!=null?IS544.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:732:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL545=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid5708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL545_tree = (CommonTree)adaptor.dupNode(NULL545);


                    adaptor.addChild(root_0, NULL545_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL545!=null?NULL545.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:733:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE546=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid5723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE546_tree = (CommonTree)adaptor.dupNode(TRUE546);


                    adaptor.addChild(root_0, TRUE546_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE546!=null?TRUE546.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:734:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE547=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid5738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE547_tree = (CommonTree)adaptor.dupNode(FALSE547);


                    adaptor.addChild(root_0, FALSE547_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE547!=null?FALSE547.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:735:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM548=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid5752); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM548_tree = (CommonTree)adaptor.dupNode(STREAM548);


                    adaptor.addChild(root_0, STREAM548_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STREAM548!=null?STREAM548.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:736:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH549=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid5765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH549_tree = (CommonTree)adaptor.dupNode(THROUGH549);


                    adaptor.addChild(root_0, THROUGH549_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((THROUGH549!=null?THROUGH549.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:737:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE550=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid5777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE550_tree = (CommonTree)adaptor.dupNode(STORE550);


                    adaptor.addChild(root_0, STORE550_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STORE550!=null?STORE550.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:738:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE551=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid5791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE551_tree = (CommonTree)adaptor.dupNode(MAPREDUCE551);


                    adaptor.addChild(root_0, MAPREDUCE551_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAPREDUCE551!=null?MAPREDUCE551.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:739:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP552=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid5801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP552_tree = (CommonTree)adaptor.dupNode(SHIP552);


                    adaptor.addChild(root_0, SHIP552_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SHIP552!=null?SHIP552.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:740:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE553=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid5816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE553_tree = (CommonTree)adaptor.dupNode(CACHE553);


                    adaptor.addChild(root_0, CACHE553_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CACHE553!=null?CACHE553.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:741:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT554=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid5830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT554_tree = (CommonTree)adaptor.dupNode(INPUT554);


                    adaptor.addChild(root_0, INPUT554_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INPUT554!=null?INPUT554.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:742:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT555=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid5844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT555_tree = (CommonTree)adaptor.dupNode(OUTPUT555);


                    adaptor.addChild(root_0, OUTPUT555_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTPUT555!=null?OUTPUT555.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:743:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR556=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid5857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR556_tree = (CommonTree)adaptor.dupNode(STDERROR556);


                    adaptor.addChild(root_0, STDERROR556_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDERROR556!=null?STDERROR556.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:744:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN557=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid5868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN557_tree = (CommonTree)adaptor.dupNode(STDIN557);


                    adaptor.addChild(root_0, STDIN557_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN557!=null?STDIN557.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:745:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT558=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid5882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT558_tree = (CommonTree)adaptor.dupNode(STDOUT558);


                    adaptor.addChild(root_0, STDOUT558_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT558!=null?STDOUT558.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:746:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT559=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid5895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT559_tree = (CommonTree)adaptor.dupNode(LIMIT559);


                    adaptor.addChild(root_0, LIMIT559_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LIMIT559!=null?LIMIT559.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:747:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE560=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid5909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE560_tree = (CommonTree)adaptor.dupNode(SAMPLE560);


                    adaptor.addChild(root_0, SAMPLE560_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SAMPLE560!=null?SAMPLE560.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:748:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT561=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid5922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT561_tree = (CommonTree)adaptor.dupNode(LEFT561);


                    adaptor.addChild(root_0, LEFT561_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LEFT561!=null?LEFT561.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:749:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT562=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid5937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT562_tree = (CommonTree)adaptor.dupNode(RIGHT562);


                    adaptor.addChild(root_0, RIGHT562_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RIGHT562!=null?RIGHT562.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:750:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL563=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid5951); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL563_tree = (CommonTree)adaptor.dupNode(FULL563);


                    adaptor.addChild(root_0, FULL563_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FULL563!=null?FULL563.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:751:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER564=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid5966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER564_tree = (CommonTree)adaptor.dupNode(IDENTIFIER564);


                    adaptor.addChild(root_0, IDENTIFIER564_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER564!=null?IDENTIFIER564.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:752:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG565=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid5976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG565_tree = (CommonTree)adaptor.dupNode(TOBAG565);


                    adaptor.addChild(root_0, TOBAG565_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOBAG565!=null?TOBAG565.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:753:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP566=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid5991); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP566_tree = (CommonTree)adaptor.dupNode(TOMAP566);


                    adaptor.addChild(root_0, TOMAP566_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOMAP566!=null?TOMAP566.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 77 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:754:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE567=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE567_tree = (CommonTree)adaptor.dupNode(TOTUPLE567);


                    adaptor.addChild(root_0, TOTUPLE567_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOTUPLE567!=null?TOTUPLE567.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 78 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:755:7: IN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IN568=(CommonTree)match(input,IN,FOLLOW_IN_in_eid6019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN568_tree = (CommonTree)adaptor.dupNode(IN568);


                    adaptor.addChild(root_0, IN568_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IN568!=null?IN568.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 79 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:756:7: CASE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CASE569=(CommonTree)match(input,CASE,FOLLOW_CASE_in_eid6037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CASE569_tree = (CommonTree)adaptor.dupNode(CASE569);


                    adaptor.addChild(root_0, CASE569_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CASE569!=null?CASE569.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 80 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:757:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT570=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid6053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT570_tree = (CommonTree)adaptor.dupNode(ASSERT570);


                    adaptor.addChild(root_0, ASSERT570_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASSERT570!=null?ASSERT570.getText():null)); }

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
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:761:1: rel_op returns [String result] : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstPrinter.rel_op_return rel_op() throws RecognitionException {
        AstPrinter.rel_op_return retval = new AstPrinter.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES577=null;
        AstPrinter.rel_op_eq_return rel_op_eq571 =null;

        AstPrinter.rel_op_ne_return rel_op_ne572 =null;

        AstPrinter.rel_op_gt_return rel_op_gt573 =null;

        AstPrinter.rel_op_gte_return rel_op_gte574 =null;

        AstPrinter.rel_op_lt_return rel_op_lt575 =null;

        AstPrinter.rel_op_lte_return rel_op_lte576 =null;


        CommonTree STR_OP_MATCHES577_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:762:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt135=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt135=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt135=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt135=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt135=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt135=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt135=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt135=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;

            }

            switch (alt135) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:762:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6076);
                    rel_op_eq571=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq571.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_eq571!=null?rel_op_eq571.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:763:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6090);
                    rel_op_ne572=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne572.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_ne572!=null?rel_op_ne572.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:764:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6104);
                    rel_op_gt573=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt573.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gt573!=null?rel_op_gt573.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:765:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6118);
                    rel_op_gte574=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte574.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gte574!=null?rel_op_gte574.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:766:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6131);
                    rel_op_lt575=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt575.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lt575!=null?rel_op_lt575.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:767:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6145);
                    rel_op_lte576=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte576.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lte576!=null?rel_op_lte576.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:768:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES577=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6158); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES577_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES577);


                    adaptor.addChild(root_0, STR_OP_MATCHES577_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_MATCHES577!=null?STR_OP_MATCHES577.getText():null); }

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
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:771:1: rel_op_eq returns [String result] : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstPrinter.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstPrinter.rel_op_eq_return retval = new AstPrinter.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ578=null;
        CommonTree NUM_OP_EQ579=null;

        CommonTree STR_OP_EQ578_tree=null;
        CommonTree NUM_OP_EQ579_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:772:5: ( STR_OP_EQ | NUM_OP_EQ )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==STR_OP_EQ) ) {
                alt136=1;
            }
            else if ( (LA136_0==NUM_OP_EQ) ) {
                alt136=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;

            }
            switch (alt136) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:772:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ578=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_op_eq6177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ578_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ578);


                    adaptor.addChild(root_0, STR_OP_EQ578_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_EQ578!=null?STR_OP_EQ578.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:773:7: NUM_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_EQ579=(CommonTree)match(input,NUM_OP_EQ,FOLLOW_NUM_OP_EQ_in_rel_op_eq6187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_EQ579_tree = (CommonTree)adaptor.dupNode(NUM_OP_EQ579);


                    adaptor.addChild(root_0, NUM_OP_EQ579_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_EQ579!=null?NUM_OP_EQ579.getText():null); }

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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:776:1: rel_op_ne returns [String result] : ( STR_OP_NE | NUM_OP_NE );
    public final AstPrinter.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstPrinter.rel_op_ne_return retval = new AstPrinter.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_NE580=null;
        CommonTree NUM_OP_NE581=null;

        CommonTree STR_OP_NE580_tree=null;
        CommonTree NUM_OP_NE581_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:777:5: ( STR_OP_NE | NUM_OP_NE )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==STR_OP_NE) ) {
                alt137=1;
            }
            else if ( (LA137_0==NUM_OP_NE) ) {
                alt137=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;

            }
            switch (alt137) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:777:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE580=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_op_ne6205); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE580_tree = (CommonTree)adaptor.dupNode(STR_OP_NE580);


                    adaptor.addChild(root_0, STR_OP_NE580_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_NE580!=null?STR_OP_NE580.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:778:7: NUM_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_NE581=(CommonTree)match(input,NUM_OP_NE,FOLLOW_NUM_OP_NE_in_rel_op_ne6215); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_NE581_tree = (CommonTree)adaptor.dupNode(NUM_OP_NE581);


                    adaptor.addChild(root_0, NUM_OP_NE581_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_NE581!=null?NUM_OP_NE581.getText():null); }

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
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:781:1: rel_op_gt returns [String result] : ( STR_OP_GT | NUM_OP_GT );
    public final AstPrinter.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstPrinter.rel_op_gt_return retval = new AstPrinter.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GT582=null;
        CommonTree NUM_OP_GT583=null;

        CommonTree STR_OP_GT582_tree=null;
        CommonTree NUM_OP_GT583_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:782:5: ( STR_OP_GT | NUM_OP_GT )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==STR_OP_GT) ) {
                alt138=1;
            }
            else if ( (LA138_0==NUM_OP_GT) ) {
                alt138=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;

            }
            switch (alt138) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:782:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT582=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_op_gt6233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT582_tree = (CommonTree)adaptor.dupNode(STR_OP_GT582);


                    adaptor.addChild(root_0, STR_OP_GT582_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GT582!=null?STR_OP_GT582.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:783:7: NUM_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GT583=(CommonTree)match(input,NUM_OP_GT,FOLLOW_NUM_OP_GT_in_rel_op_gt6243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GT583_tree = (CommonTree)adaptor.dupNode(NUM_OP_GT583);


                    adaptor.addChild(root_0, NUM_OP_GT583_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GT583!=null?NUM_OP_GT583.getText():null); }

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
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:786:1: rel_op_gte returns [String result] : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstPrinter.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstPrinter.rel_op_gte_return retval = new AstPrinter.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GTE584=null;
        CommonTree NUM_OP_GTE585=null;

        CommonTree STR_OP_GTE584_tree=null;
        CommonTree NUM_OP_GTE585_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:787:5: ( STR_OP_GTE | NUM_OP_GTE )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==STR_OP_GTE) ) {
                alt139=1;
            }
            else if ( (LA139_0==NUM_OP_GTE) ) {
                alt139=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;

            }
            switch (alt139) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:787:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE584=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_op_gte6261); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE584_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE584);


                    adaptor.addChild(root_0, STR_OP_GTE584_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GTE584!=null?STR_OP_GTE584.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:788:7: NUM_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GTE585=(CommonTree)match(input,NUM_OP_GTE,FOLLOW_NUM_OP_GTE_in_rel_op_gte6271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GTE585_tree = (CommonTree)adaptor.dupNode(NUM_OP_GTE585);


                    adaptor.addChild(root_0, NUM_OP_GTE585_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GTE585!=null?NUM_OP_GTE585.getText():null); }

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
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:791:1: rel_op_lt returns [String result] : ( STR_OP_LT | NUM_OP_LT );
    public final AstPrinter.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstPrinter.rel_op_lt_return retval = new AstPrinter.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LT586=null;
        CommonTree NUM_OP_LT587=null;

        CommonTree STR_OP_LT586_tree=null;
        CommonTree NUM_OP_LT587_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:792:5: ( STR_OP_LT | NUM_OP_LT )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==STR_OP_LT) ) {
                alt140=1;
            }
            else if ( (LA140_0==NUM_OP_LT) ) {
                alt140=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;

            }
            switch (alt140) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:792:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT586=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_op_lt6289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT586_tree = (CommonTree)adaptor.dupNode(STR_OP_LT586);


                    adaptor.addChild(root_0, STR_OP_LT586_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LT586!=null?STR_OP_LT586.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:793:7: NUM_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LT587=(CommonTree)match(input,NUM_OP_LT,FOLLOW_NUM_OP_LT_in_rel_op_lt6299); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LT587_tree = (CommonTree)adaptor.dupNode(NUM_OP_LT587);


                    adaptor.addChild(root_0, NUM_OP_LT587_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LT587!=null?NUM_OP_LT587.getText():null); }

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
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:796:1: rel_op_lte returns [String result] : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstPrinter.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstPrinter.rel_op_lte_return retval = new AstPrinter.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LTE588=null;
        CommonTree NUM_OP_LTE589=null;

        CommonTree STR_OP_LTE588_tree=null;
        CommonTree NUM_OP_LTE589_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:797:5: ( STR_OP_LTE | NUM_OP_LTE )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==STR_OP_LTE) ) {
                alt141=1;
            }
            else if ( (LA141_0==NUM_OP_LTE) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;

            }
            switch (alt141) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:797:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE588=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_op_lte6317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE588_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE588);


                    adaptor.addChild(root_0, STR_OP_LTE588_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LTE588!=null?STR_OP_LTE588.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:798:7: NUM_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LTE589=(CommonTree)match(input,NUM_OP_LTE,FOLLOW_NUM_OP_LTE_in_rel_op_lte6327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LTE589_tree = (CommonTree)adaptor.dupNode(NUM_OP_LTE589);


                    adaptor.addChild(root_0, NUM_OP_LTE589_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LTE589!=null?NUM_OP_LTE589.getText():null); }

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
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:801:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstPrinter.rel_str_op_return rel_str_op() throws RecognitionException {
        AstPrinter.rel_str_op_return retval = new AstPrinter.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ590=null;
        CommonTree STR_OP_NE591=null;
        CommonTree STR_OP_GT592=null;
        CommonTree STR_OP_LT593=null;
        CommonTree STR_OP_GTE594=null;
        CommonTree STR_OP_LTE595=null;
        CommonTree STR_OP_MATCHES596=null;

        CommonTree STR_OP_EQ590_tree=null;
        CommonTree STR_OP_NE591_tree=null;
        CommonTree STR_OP_GT592_tree=null;
        CommonTree STR_OP_LT593_tree=null;
        CommonTree STR_OP_GTE594_tree=null;
        CommonTree STR_OP_LTE595_tree=null;
        CommonTree STR_OP_MATCHES596_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:802:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt142=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt142=1;
                }
                break;
            case STR_OP_NE:
                {
                alt142=2;
                }
                break;
            case STR_OP_GT:
                {
                alt142=3;
                }
                break;
            case STR_OP_LT:
                {
                alt142=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt142=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt142=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt142=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;

            }

            switch (alt142) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:802:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ590=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ590_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ590);


                    adaptor.addChild(root_0, STR_OP_EQ590_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_EQ590!=null?STR_OP_EQ590.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:803:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE591=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE591_tree = (CommonTree)adaptor.dupNode(STR_OP_NE591);


                    adaptor.addChild(root_0, STR_OP_NE591_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_NE591!=null?STR_OP_NE591.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:804:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT592=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT592_tree = (CommonTree)adaptor.dupNode(STR_OP_GT592);


                    adaptor.addChild(root_0, STR_OP_GT592_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GT592!=null?STR_OP_GT592.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:805:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT593=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT593_tree = (CommonTree)adaptor.dupNode(STR_OP_LT593);


                    adaptor.addChild(root_0, STR_OP_LT593_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LT593!=null?STR_OP_LT593.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:806:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE594=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE594_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE594);


                    adaptor.addChild(root_0, STR_OP_GTE594_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GTE594!=null?STR_OP_GTE594.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:807:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE595=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE595_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE595);


                    adaptor.addChild(root_0, STR_OP_LTE595_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LTE595!=null?STR_OP_LTE595.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:808:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES596=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES596_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES596);


                    adaptor.addChild(root_0, STR_OP_MATCHES596_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_MATCHES596!=null?STR_OP_MATCHES596.getText():null)); }

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

    // $ANTLR start synpred50_AstPrinter
    public final void synpred50_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:7: ( field_def ( field_def )+ )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:7: field_def ( field_def )+
        {
        pushFollow(FOLLOW_field_def_in_synpred50_AstPrinter1182);
        field_def();

        state._fsp--;
        if (state.failed) return ;

        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:37: ( field_def )+
        int cnt147=0;
        loop147:
        do {
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==FIELD_DEF) ) {
                alt147=1;
            }


            switch (alt147) {
        	case 1 :
        	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:209:39: field_def
        	    {
        	    pushFollow(FOLLOW_field_def_in_synpred50_AstPrinter1188);
        	    field_def();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt147 >= 1 ) break loop147;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(147, input);
                    throw eee;
            }
            cnt147++;
        } while (true);


        }

    }
    // $ANTLR end synpred50_AstPrinter

    // $ANTLR start synpred109_AstPrinter
    public final void synpred109_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:362:7: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:362:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred109_AstPrinter2443); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred109_AstPrinter2445);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred109_AstPrinter2449);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred109_AstPrinter

    // $ANTLR start synpred113_AstPrinter
    public final void synpred113_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:366:7: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:366:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred113_AstPrinter2515); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred113_AstPrinter2519);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred113_AstPrinter2523);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred113_AstPrinter

    // $ANTLR start synpred114_AstPrinter
    public final void synpred114_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:367:7: ( const_expr )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:367:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred114_AstPrinter2533);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_AstPrinter

    // $ANTLR start synpred117_AstPrinter
    public final void synpred117_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:370:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:370:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred117_AstPrinter2567); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred117_AstPrinter2571);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred117_AstPrinter2575);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred117_AstPrinter

    // $ANTLR start synpred122_AstPrinter
    public final void synpred122_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:7: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
        {
        match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_synpred122_AstPrinter2635); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred122_AstPrinter2639);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:61: ( type_cast )*
        loop151:
        do {
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==BIGDECIMAL||LA151_0==BIGINTEGER||LA151_0==BOOLEAN||LA151_0==BYTEARRAY||LA151_0==CHARARRAY||LA151_0==DATETIME||LA151_0==DOUBLE||LA151_0==FLOAT||LA151_0==INT||LA151_0==LONG||LA151_0==BAG_TYPE_CAST||LA151_0==MAP_TYPE||LA151_0==TUPLE_TYPE_CAST) ) {
                alt151=1;
            }


            switch (alt151) {
        	case 1 :
        	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:379:63: type_cast
        	    {
        	    pushFollow(FOLLOW_type_cast_in_synpred122_AstPrinter2645);
        	    type_cast();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop151;
            }
        } while (true);


        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred122_AstPrinter

    // $ANTLR start synpred143_AstPrinter
    public final void synpred143_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:11: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:11: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred143_AstPrinter3136); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred143_AstPrinter

    // $ANTLR start synpred144_AstPrinter
    public final void synpred144_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:63: ( LONGINTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:438:63: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred144_AstPrinter3142); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred144_AstPrinter

    // $ANTLR start synpred145_AstPrinter
    public final void synpred145_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:64: ( DOUBLENUMBER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:442:64: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred145_AstPrinter3175); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred145_AstPrinter

    // $ANTLR start synpred171_AstPrinter
    public final void synpred171_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:502:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred171_AstPrinter3602);
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


        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:505:16: ( OUTER )?
        int alt155=2;
        int LA155_0 = input.LA(1);

        if ( (LA155_0==OUTER) ) {
            alt155=1;
        }
        switch (alt155) {
            case 1 :
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:505:17: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred171_AstPrinter3664); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred171_AstPrinter3673);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred171_AstPrinter

    // $ANTLR start synpred189_AstPrinter
    public final void synpred189_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:75: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstPrinter.g:576:75: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred189_AstPrinter4196); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred189_AstPrinter

    // Delegated rules

    public final boolean synpred189_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred189_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred144_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred144_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred145_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA58 dfa58 = new DFA58(this);
    static final String DFA58_eotS =
        "\u00b3\uffff";
    static final String DFA58_eofS =
        "\u00b3\uffff";
    static final String DFA58_minS =
        "\1\u00a2\1\2\1\4\126\3\2\4\2\uffff\126\3";
    static final String DFA58_maxS =
        "\1\u00a2\1\2\1\u00bf\126\u00bd\2\u00bf\2\uffff\126\u00bd";
    static final String DFA58_acceptS =
        "\133\uffff\1\1\1\2\126\uffff";
    static final String DFA58_specialS =
        "\u00b3\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\1",
            "\1\2",
            "\1\40\1\uffff\1\51\1\uffff\1\41\1\57\1\130\1\73\1\67\1\uffff"+
            "\1\66\1\uffff\1\61\1\42\1\72\1\107\1\127\1\71\1\23\1\31\2\uffff"+
            "\1\33\1\20\1\70\1\uffff\1\14\1\uffff\1\60\1\uffff\1\30\3\uffff"+
            "\1\65\6\uffff\1\101\1\uffff\1\16\1\55\1\64\2\uffff\1\17\1\121"+
            "\1\54\1\50\1\uffff\1\122\1\37\1\12\1\126\1\44\1\110\1\62\1\uffff"+
            "\1\36\1\uffff\1\76\1\32\1\117\4\uffff\1\115\1\15\1\63\1\uffff"+
            "\1\75\1\105\3\uffff\1\53\1\77\7\uffff\1\52\1\26\1\uffff\1\45"+
            "\1\111\1\46\1\47\2\uffff\1\22\4\uffff\1\27\1\24\1\uffff\1\13"+
            "\1\120\3\uffff\1\21\1\116\1\uffff\1\106\2\uffff\1\35\1\uffff"+
            "\1\112\1\113\1\114\1\104\1\102\1\3\1\5\1\7\1\6\1\10\1\11\1\4"+
            "\1\uffff\1\103\1\100\1\74\1\34\1\43\54\uffff\1\123\1\124\1\125"+
            "\3\uffff\1\56\1\25",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\172\1\uffff\1\u0083\1\uffff\1\173\1\u0089\1\u00b2\1\u0095"+
            "\1\u0091\1\uffff\1\u0090\1\uffff\1\u008b\1\174\1\u0094\1\u00a1"+
            "\1\u00b1\1\u0093\1\155\1\163\2\uffff\1\165\1\152\1\u0092\1\uffff"+
            "\1\146\1\uffff\1\u008a\1\uffff\1\162\3\uffff\1\u008f\6\uffff"+
            "\1\u009b\1\uffff\1\150\1\u0087\1\u008e\2\uffff\1\151\1\u00ab"+
            "\1\u0086\1\u0082\1\uffff\1\u00ac\1\171\1\144\1\u00b0\1\176\1"+
            "\u00a2\1\u008c\1\uffff\1\170\1\uffff\1\u0098\1\164\1\u00a9\4"+
            "\uffff\1\u00a7\1\147\1\u008d\1\uffff\1\u0097\1\u009f\3\uffff"+
            "\1\u0085\1\u0099\7\uffff\1\u0084\1\160\1\uffff\1\177\1\u00a3"+
            "\1\u0080\1\u0081\2\uffff\1\154\4\uffff\1\161\1\156\1\uffff\1"+
            "\145\1\u00aa\3\uffff\1\153\1\u00a8\1\uffff\1\u00a0\2\uffff\1"+
            "\167\1\uffff\1\u00a4\1\u00a5\1\u00a6\1\u009e\1\u009c\1\135\1"+
            "\137\1\141\1\140\1\142\1\143\1\136\1\uffff\1\u009d\1\u009a\1"+
            "\u0096\1\166\1\175\54\uffff\1\u00ad\1\u00ae\1\u00af\3\uffff"+
            "\1\u0088\1\157",
            "\1\172\1\uffff\1\u0083\1\uffff\1\173\1\u0089\1\u00b2\1\u0095"+
            "\1\u0091\1\uffff\1\u0090\1\uffff\1\u008b\1\174\1\u0094\1\u00a1"+
            "\1\u00b1\1\u0093\1\155\1\163\2\uffff\1\165\1\152\1\u0092\1\uffff"+
            "\1\146\1\uffff\1\u008a\1\uffff\1\162\3\uffff\1\u008f\6\uffff"+
            "\1\u009b\1\uffff\1\150\1\u0087\1\u008e\2\uffff\1\151\1\u00ab"+
            "\1\u0086\1\u0082\1\uffff\1\u00ac\1\171\1\144\1\u00b0\1\176\1"+
            "\u00a2\1\u008c\1\uffff\1\170\1\uffff\1\u0098\1\164\1\u00a9\4"+
            "\uffff\1\u00a7\1\147\1\u008d\1\uffff\1\u0097\1\u009f\3\uffff"+
            "\1\u0085\1\u0099\7\uffff\1\u0084\1\160\1\uffff\1\177\1\u00a3"+
            "\1\u0080\1\u0081\2\uffff\1\154\4\uffff\1\161\1\156\1\uffff\1"+
            "\145\1\u00aa\3\uffff\1\153\1\u00a8\1\uffff\1\u00a0\2\uffff\1"+
            "\167\1\uffff\1\u00a4\1\u00a5\1\u00a6\1\u009e\1\u009c\1\135\1"+
            "\137\1\141\1\140\1\142\1\143\1\136\1\uffff\1\u009d\1\u009a\1"+
            "\u0096\1\166\1\175\54\uffff\1\u00ad\1\u00ae\1\u00af\3\uffff"+
            "\1\u0088\1\157",
            "",
            "",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133",
            "\1\134\11\uffff\1\133\1\uffff\1\133\13\uffff\1\133\7\uffff"+
            "\1\133\1\132\1\133\1\uffff\1\133\5\uffff\1\133\5\uffff\1\133"+
            "\3\uffff\1\133\1\uffff\1\133\6\uffff\1\133\14\uffff\1\133\2"+
            "\uffff\1\133\3\uffff\1\133\16\uffff\1\133\1\131\1\uffff\1\133"+
            "\2\uffff\1\133\17\uffff\1\133\16\uffff\1\133\11\uffff\2\133"+
            "\2\uffff\2\133\2\uffff\3\133\5\uffff\1\133\12\uffff\2\133\16"+
            "\uffff\1\133"
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "351:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );";
        }
    }
 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0800000000000408L,0x0100100000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_statement_in_statement124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_statement201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_import_statement203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement220 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_scripting_udf_clause_in_register_statement224 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scripting_language_clause_in_scripting_udf_clause245 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_scripting_namespace_clause_in_scripting_udf_clause247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_scripting_language_clause257 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_scripting_language_clause259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_scripting_namespace_clause272 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_scripting_namespace_clause274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement297 = new BitSet(new long[]{0x009080044C800400L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_op_clause_in_general_statement312 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement314 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause331 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_chunksize_clause391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LONG_in_chunksize_clause393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RATE_in_rate_clause412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_rate_clause414 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause711 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause725 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause729 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd762 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd766 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd770 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd774 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd778 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list822 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list837 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause880 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause892 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause898 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd923 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd936 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd953 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd957 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause975 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause988 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause994 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause1015 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause1029 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause1034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause1061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause1065 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause1079 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause1083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1120 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1139 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x0800100000010000L});
    public static final BitSet FOLLOW_type_in_field_def1149 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1188 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_type_in_type1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1344 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1362 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1373 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1395 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1417 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1431 = new BitSet(new long[]{0x0000000000000008L,0x0000020000040000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1453 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1459 = new BitSet(new long[]{0xFEF3A0455CFF5F50L,0xFD2C6C27B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1465 = new BitSet(new long[]{0xFEF3A0455CFF5F50L,0xFD2C6C27B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_eid_in_func_name1471 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_func_first_arg_clause_in_func_args1483 = new BitSet(new long[]{0x0000000000000002L,0x0000020000040000L});
    public static final BitSet FOLLOW_func_next_arg_clause_in_func_args1486 = new BitSet(new long[]{0x0000000000000002L,0x0000020000040000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_first_arg_clause1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_first_arg_clause1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_next_arg_clause1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_next_arg_clause1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1609 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1649 = new BitSet(new long[]{0x0000000008000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1655 = new BitSet(new long[]{0x0000000008000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1687 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1710 = new BitSet(new long[]{0x028820A80800A002L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1716 = new BitSet(new long[]{0x028820A80800A002L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1783 = new BitSet(new long[]{0x029080044C800408L,0x6108060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_item_in_group_clause1789 = new BitSet(new long[]{0x029080044C800408L,0x6108060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_type_in_group_clause1804 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1846 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1850 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1866 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1872 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1928 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1950 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1954 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1958 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1962 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1993 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2012 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2016 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2020 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2026 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause2060 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause2064 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_assert_clause2068 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause2076 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2096 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2100 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_filter_clause2104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2127 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_cond2131 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2145 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2149 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_cond2153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2171 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2187 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_NOT_in_cond2192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond2212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2214 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond2218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2354 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2358 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2364 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2382 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_real_arg2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2427 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2445 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2449 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2463 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2481 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2485 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2499 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2503 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr2519 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2551 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2571 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2639 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2645 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2689 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2707 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2711 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2715 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2766 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2772 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2855 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2860 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2862 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2879 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj2893 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj2899 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2924 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2928 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2932 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2978 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2982 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr3004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3008 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr3016 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3020 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3047 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3063 = new BitSet(new long[]{0x1000000000000048L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_case_cond3069 = new BitSet(new long[]{0x1000000000000048L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_THEN_in_case_cond3088 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3090 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_case_cond3096 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3124 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3142 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3148 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3171 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3175 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3181 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3204 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3229 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3250 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3275 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3281 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3296 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3300 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3336 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3348 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3380 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3405 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3411 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_order_col3427 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col3431 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ASC_in_order_col3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3466 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3511 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3529 = new BitSet(new long[]{0x029080044C800402L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_rel_in_rel_list3535 = new BitSet(new long[]{0x029080044C800402L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_JOIN_in_join_clause3552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause3556 = new BitSet(new long[]{0x0000000000000008L,0x0000020400000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause3562 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause3573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3602 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause3606 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause3625 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause3644 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause3664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3681 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3687 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item3705 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item3707 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item3709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause3726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3734 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3740 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause3785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3790 = new BitSet(new long[]{0x029080044C800400L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_rel_list_in_union_clause3797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause3814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause3818 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause3820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan3839 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3851 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan3853 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk3871 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause3895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3907 = new BitSet(new long[]{0x028920A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3913 = new BitSet(new long[]{0x028920A80800A008L,0x0200024800112001L,0x200060041CCC0100L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command3932 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3934 = new BitSet(new long[]{0x0010800404000000L,0x0000000020000400L,0x0002000000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command3938 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3952 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_nested_command3956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4068 = new BitSet(new long[]{0x0280002008000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4072 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4078 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4099 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4103 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_nested_filter4107 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4128 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4140 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4146 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4170 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4192 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4226 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4245 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4275 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4281 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause4298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause4302 = new BitSet(new long[]{0x0200100000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause4316 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause4330 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause4336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause4354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause4356 = new BitSet(new long[]{0x0000000000000000L,0x2000020000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause4371 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause4378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause4382 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause4393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause4415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause4428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4432 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4438 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause4447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch4467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch4469 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000040020003FL});
    public static final BitSet FOLLOW_cond_in_split_branch4473 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise4490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise4492 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref4542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar4635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar4661 = new BitSet(new long[]{0x000800800000A000L,0x0000000000002001L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar4721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar4740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar4778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map4814 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_keyvalue_in_map4820 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4836 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue4855 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue4857 = new BitSet(new long[]{0x000820800000A000L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue4861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4889 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag4893 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_tuple_in_bag4899 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4934 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple4938 = new BitSet(new long[]{0x000820800000A008L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_literal_in_tuple4945 = new BitSet(new long[]{0x000820800000A008L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4961 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_str_op_in_eid4975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_eid5103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RATE_in_eid5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid5235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid5249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid5281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid5314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid5345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid5384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid5526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid5554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid5614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid5635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid5661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid5675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid5691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid5708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid5738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid5752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid5830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid5844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid5857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid5868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid5882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid5895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid5951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid5966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_eid6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_eid6037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_op_eq6177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_EQ_in_rel_op_eq6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_op_ne6205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_NE_in_rel_op_ne6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_op_gt6233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GT_in_rel_op_gt6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_op_gte6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GTE_in_rel_op_gte6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_op_lt6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LT_in_rel_op_lt6299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_op_lte6317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LTE_in_rel_op_lte6327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_def_in_synpred50_AstPrinter1182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_field_def_in_synpred50_AstPrinter1188 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_MINUS_in_synpred109_AstPrinter2443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstPrinter2445 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstPrinter2449 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred113_AstPrinter2515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred113_AstPrinter2519 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred113_AstPrinter2523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred114_AstPrinter2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred117_AstPrinter2567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred117_AstPrinter2571 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000600414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred117_AstPrinter2575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_synpred122_AstPrinter2635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred122_AstPrinter2639 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_type_cast_in_synpred122_AstPrinter2645 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_INTEGER_in_synpred143_AstPrinter3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred144_AstPrinter3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred145_AstPrinter3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstPrinter3602 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_synpred171_AstPrinter3604 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred171_AstPrinter3664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstPrinter3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred189_AstPrinter4196 = new BitSet(new long[]{0x0000000000000002L});

}