// $ANTLR 3.4 /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g 2014-12-22 11:35:35

package org.apache.pig.parser;

import org.apache.pig.data.DataType;
import org.apache.pig.impl.util.NumValCarrier;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
public class AstValidator extends TreeParser {
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


    public AstValidator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstValidator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstValidator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g"; }



    private static Log log = LogFactory.getLog( AstValidator.class );

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

    private void validateSchemaAliasName(Set<String> fieldNames, CommonTree node, String name)
    throws DuplicatedSchemaAliasException {
        if( fieldNames.contains( name ) ) {
            throw new DuplicatedSchemaAliasException( input,
                new SourceLocation( (PigParserNode)node ), name );
        } else {
            fieldNames.add( name );
        }
    }

    private void validateAliasRef(Set<String> aliases, CommonTree node, String alias)
    throws UndefinedAliasException {
        if( !aliases.contains( alias ) ) {
            throw new UndefinedAliasException( input, new SourceLocation( (PigParserNode)node ), alias );
        }
    }

    private void checkDuplication(int count, CommonTree node) throws ParserValidationException {
        if( count > 1 ) {
            throw new ParserValidationException( input, new SourceLocation( (PigParserNode)node ),
                "Duplicated command option" );
        }
    }

    private String lastRel = null;

    private String getLastRel(CommonTree node) throws UndefinedAliasException {
        if (lastRel != null) {
            return lastRel;
        }
        throw new UndefinedAliasException( input, new SourceLocation((PigParserNode)node), "@");
    }

    private Set<String> aliases = new HashSet<String>() {
        @Override
        public boolean add(String e) {
            lastRel = e;
            return super.add(e);
        }
    };



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:113:1: query : ^( QUERY ( statement )* ) ;
    public final AstValidator.query_return query() throws RecognitionException {
        AstValidator.query_return retval = new AstValidator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstValidator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:113:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:113:9: ^( QUERY ( statement )* )
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
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:113:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:113:18: statement
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:116:1: statement : ( general_statement | split_statement | realias_statement | register_statement | assert_statement );
    public final AstValidator.statement_return statement() throws RecognitionException {
        AstValidator.statement_return retval = new AstValidator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.general_statement_return general_statement3 =null;

        AstValidator.split_statement_return split_statement4 =null;

        AstValidator.realias_statement_return realias_statement5 =null;

        AstValidator.register_statement_return register_statement6 =null;

        AstValidator.assert_statement_return assert_statement7 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:116:11: ( general_statement | split_statement | realias_statement | register_statement | assert_statement )
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:116:13: general_statement
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:117:13: split_statement
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:118:13: realias_statement
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:119:13: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement136);
                    register_statement6=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:120:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement150);
                    assert_statement7=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement7.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:123:1: split_statement : split_clause ;
    public final AstValidator.split_statement_return split_statement() throws RecognitionException {
        AstValidator.split_statement_return retval = new AstValidator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:123:17: ( split_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:123:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement159);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:126:1: realias_statement : realias_clause ;
    public final AstValidator.realias_statement_return realias_statement() throws RecognitionException {
        AstValidator.realias_statement_return retval = new AstValidator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:126:19: ( realias_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:126:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement168);
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


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:129:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final AstValidator.register_statement_return register_statement() throws RecognitionException {
        AstValidator.register_statement_return retval = new AstValidator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER10=null;
        CommonTree QUOTEDSTRING11=null;
        CommonTree USING12=null;
        CommonTree IDENTIFIER13=null;
        CommonTree AS14=null;
        CommonTree IDENTIFIER15=null;

        CommonTree REGISTER10_tree=null;
        CommonTree QUOTEDSTRING11_tree=null;
        CommonTree USING12_tree=null;
        CommonTree IDENTIFIER13_tree=null;
        CommonTree AS14_tree=null;
        CommonTree IDENTIFIER15_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:129:20: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:129:22: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER10=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER10_tree = (CommonTree)adaptor.dupNode(REGISTER10);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING11=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING11_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING11);


            adaptor.addChild(root_1, QUOTEDSTRING11_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:129:47: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:129:48: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING12=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING12_tree = (CommonTree)adaptor.dupNode(USING12);


                    adaptor.addChild(root_1, USING12_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER13=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER13_tree = (CommonTree)adaptor.dupNode(IDENTIFIER13);


                    adaptor.addChild(root_1, IDENTIFIER13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS14=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS14_tree = (CommonTree)adaptor.dupNode(AS14);


                    adaptor.addChild(root_1, AS14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER15=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER15_tree = (CommonTree)adaptor.dupNode(IDENTIFIER15);


                    adaptor.addChild(root_1, IDENTIFIER15_tree);
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
    // $ANTLR end "register_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:132:1: assert_statement : assert_clause ;
    public final AstValidator.assert_statement_return assert_statement() throws RecognitionException {
        AstValidator.assert_statement_return retval = new AstValidator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.assert_clause_return assert_clause16 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:132:18: ( assert_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:132:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement203);
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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstValidator.general_statement_return general_statement() throws RecognitionException {
        AstValidator.general_statement_return retval = new AstValidator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        AstValidator.alias_return alias18 =null;

        AstValidator.op_clause_return op_clause19 =null;

        AstValidator.parallel_clause_return parallel_clause20 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:19: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:21: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:34: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:36: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement218);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { aliases.add( (alias18!=null?alias18.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement225);
            op_clause19=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause19.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:87: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:135:87: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement227);
                    parallel_clause20=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause20.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:138:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstValidator.realias_clause_return realias_clause() throws RecognitionException {
        AstValidator.realias_clause_return retval = new AstValidator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS21=null;
        CommonTree IDENTIFIER23=null;
        AstValidator.alias_return alias22 =null;


        CommonTree REALIAS21_tree=null;
        CommonTree IDENTIFIER23_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:138:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:138:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS21=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS21_tree = (CommonTree)adaptor.dupNode(REALIAS21);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS21_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause242);
            alias22=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias22.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER23=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER23_tree = (CommonTree)adaptor.dupNode(IDENTIFIER23);


            adaptor.addChild(root_1, IDENTIFIER23_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias22!=null?alias22.name:null) );
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:144:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstValidator.parallel_clause_return parallel_clause() throws RecognitionException {
        AstValidator.parallel_clause_return retval = new AstValidator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL24=null;
        CommonTree INTEGER25=null;

        CommonTree PARALLEL24_tree=null;
        CommonTree INTEGER25_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:144:17: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:144:19: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL24=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL24_tree = (CommonTree)adaptor.dupNode(PARALLEL24);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL24_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER25=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER25_tree = (CommonTree)adaptor.dupNode(INTEGER25);


            adaptor.addChild(root_1, INTEGER25_tree);
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
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:147:1: alias returns [String name, CommonTree node] : IDENTIFIER ;
    public final AstValidator.alias_return alias() throws RecognitionException {
        AstValidator.alias_return retval = new AstValidator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER26=null;

        CommonTree IDENTIFIER26_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:148:2: ( IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:148:4: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER26=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER26_tree = (CommonTree)adaptor.dupNode(IDENTIFIER26);


            adaptor.addChild(root_0, IDENTIFIER26_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = (IDENTIFIER26!=null?IDENTIFIER26.getText():null);
                   retval.node = IDENTIFIER26;
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


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:155:1: previous_rel returns [String name, CommonTree node] : ARROBA ;
    public final AstValidator.previous_rel_return previous_rel() throws RecognitionException {
        AstValidator.previous_rel_return retval = new AstValidator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA27=null;

        CommonTree ARROBA27_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:156:2: ( ARROBA )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:156:4: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA27=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA27_tree = (CommonTree)adaptor.dupNode(ARROBA27);


            adaptor.addChild(root_0, ARROBA27_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = getLastRel(ARROBA27);
                   retval.node = ARROBA27;
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
    // $ANTLR end "previous_rel"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:163:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AstValidator.op_clause_return op_clause() throws RecognitionException {
        AstValidator.op_clause_return retval = new AstValidator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.define_clause_return define_clause28 =null;

        AstValidator.load_clause_return load_clause29 =null;

        AstValidator.group_clause_return group_clause30 =null;

        AstValidator.store_clause_return store_clause31 =null;

        AstValidator.filter_clause_return filter_clause32 =null;

        AstValidator.distinct_clause_return distinct_clause33 =null;

        AstValidator.limit_clause_return limit_clause34 =null;

        AstValidator.sample_clause_return sample_clause35 =null;

        AstValidator.order_clause_return order_clause36 =null;

        AstValidator.rank_clause_return rank_clause37 =null;

        AstValidator.cross_clause_return cross_clause38 =null;

        AstValidator.join_clause_return join_clause39 =null;

        AstValidator.union_clause_return union_clause40 =null;

        AstValidator.stream_clause_return stream_clause41 =null;

        AstValidator.mr_clause_return mr_clause42 =null;

        AstValidator.split_clause_return split_clause43 =null;

        AstValidator.foreach_clause_return foreach_clause44 =null;

        AstValidator.cube_clause_return cube_clause45 =null;

        AstValidator.assert_clause_return assert_clause46 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:163:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:163:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause310);
                    define_clause28=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:164:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause324);
                    load_clause29=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:165:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause338);
                    group_clause30=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:166:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause352);
                    store_clause31=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:167:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause366);
                    filter_clause32=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:168:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause33=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:169:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause394);
                    limit_clause34=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:170:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause408);
                    sample_clause35=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:171:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause422);
                    order_clause36=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:172:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause436);
                    rank_clause37=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:173:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause450);
                    cross_clause38=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:174:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause464);
                    join_clause39=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:175:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause478);
                    union_clause40=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause40.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:176:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause492);
                    stream_clause41=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:177:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause506);
                    mr_clause42=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause42.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:178:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause520);
                    split_clause43=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause43.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:179:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause534);
                    foreach_clause44=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause44.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:180:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause548);
                    cube_clause45=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause45.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:181:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause562);
                    assert_clause46=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause46.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:1: define_clause : ^( DEFINE alias ( cmd | func_clause ) ) ;
    public final AstValidator.define_clause_return define_clause() throws RecognitionException {
        AstValidator.define_clause_return retval = new AstValidator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE47=null;
        AstValidator.alias_return alias48 =null;

        AstValidator.cmd_return cmd49 =null;

        AstValidator.func_clause_return func_clause50 =null;


        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:15: ( ^( DEFINE alias ( cmd | func_clause ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:17: ^( DEFINE alias ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause573); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_define_clause575);
            alias48=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias48.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:33: ( cmd | func_clause )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:35: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause579);
                    cmd49=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd49.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:184:41: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause583);
                    func_clause50=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause50.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:187:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstValidator.cmd_return cmd() throws RecognitionException {
        AstValidator.cmd_return retval = new AstValidator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND51=null;
        AstValidator.ship_clause_return ship_clause52 =null;

        AstValidator.cache_clause_return cache_clause53 =null;

        AstValidator.input_clause_return input_clause54 =null;

        AstValidator.output_clause_return output_clause55 =null;

        AstValidator.error_clause_return error_clause56 =null;


        CommonTree EXECCOMMAND51_tree=null;


            int ship = 0;
            int cache = 0;
            int in = 0;
            int out = 0;
            int error = 0;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:195:2: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:195:4: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND51=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd604); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND51_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND51);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND51_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:195:19: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:195:21: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd608);
                	    ship_clause52=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause52.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++ship, (ship_clause52!=null?((CommonTree)ship_clause52.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:196:21: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd632);
                	    cache_clause53=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause53.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++cache, (cache_clause53!=null?((CommonTree)cache_clause53.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:197:21: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd656);
                	    input_clause54=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause54.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++in, (input_clause54!=null?((CommonTree)input_clause54.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:198:21: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd680);
                	    output_clause55=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause55.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++out, (output_clause55!=null?((CommonTree)output_clause55.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:199:21: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd704);
                	    error_clause56=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause56.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++error, (error_clause56!=null?((CommonTree)error_clause56.start):null) ); }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:204:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstValidator.ship_clause_return ship_clause() throws RecognitionException {
        AstValidator.ship_clause_return retval = new AstValidator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP57=null;
        AstValidator.path_list_return path_list58 =null;


        CommonTree SHIP57_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:204:13: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:204:15: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP57=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP57_tree = (CommonTree)adaptor.dupNode(SHIP57);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP57_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:204:23: ( path_list )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:204:23: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause745);
                        path_list58=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list58.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:207:1: path_list : ( QUOTEDSTRING )+ ;
    public final AstValidator.path_list_return path_list() throws RecognitionException {
        AstValidator.path_list_return retval = new AstValidator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING59=null;

        CommonTree QUOTEDSTRING59_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:207:11: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:207:13: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING59=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list757); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING59_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING59);


            	    adaptor.addChild(root_0, QUOTEDSTRING59_tree);
            	    }


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:210:1: cache_clause : ^( CACHE path_list ) ;
    public final AstValidator.cache_clause_return cache_clause() throws RecognitionException {
        AstValidator.cache_clause_return retval = new AstValidator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE60=null;
        AstValidator.path_list_return path_list61 =null;


        CommonTree CACHE60_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:210:14: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:210:16: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE60=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE60_tree = (CommonTree)adaptor.dupNode(CACHE60);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE60_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause771);
            path_list61=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list61.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:213:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AstValidator.input_clause_return input_clause() throws RecognitionException {
        AstValidator.input_clause_return retval = new AstValidator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT62=null;
        AstValidator.stream_cmd_return stream_cmd63 =null;


        CommonTree INPUT62_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:213:14: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:213:16: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT62=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT62_tree = (CommonTree)adaptor.dupNode(INPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:213:25: ( stream_cmd )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:213:25: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause786);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:216:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstValidator.stream_cmd_return stream_cmd() throws RecognitionException {
        AstValidator.stream_cmd_return retval = new AstValidator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN64=null;
        CommonTree STDOUT66=null;
        CommonTree QUOTEDSTRING68=null;
        AstValidator.func_clause_return func_clause65 =null;

        AstValidator.func_clause_return func_clause67 =null;

        AstValidator.func_clause_return func_clause69 =null;


        CommonTree STDIN64_tree=null;
        CommonTree STDOUT66_tree=null;
        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:216:12: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:216:14: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN64=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN64_tree = (CommonTree)adaptor.dupNode(STDIN64);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN64_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:216:23: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:216:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd802);
                                func_clause65=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause65.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:217:14: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT66=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT66_tree = (CommonTree)adaptor.dupNode(STDOUT66);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT66_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:217:24: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:217:24: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd824);
                                func_clause67=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause67.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:218:14: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING68_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:218:30: ( func_clause )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:218:30: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd846);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:221:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AstValidator.output_clause_return output_clause() throws RecognitionException {
        AstValidator.output_clause_return retval = new AstValidator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT70=null;
        AstValidator.stream_cmd_return stream_cmd71 =null;


        CommonTree OUTPUT70_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:221:15: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:221:17: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT70=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT70_tree = (CommonTree)adaptor.dupNode(OUTPUT70);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT70_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:221:27: ( stream_cmd )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:221:27: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause862);
            	    stream_cmd71=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd71.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstValidator.error_clause_return error_clause() throws RecognitionException {
        AstValidator.error_clause_return retval = new AstValidator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR72=null;
        CommonTree QUOTEDSTRING73=null;
        CommonTree INTEGER74=null;

        CommonTree STDERROR72_tree=null;
        CommonTree QUOTEDSTRING73_tree=null;
        CommonTree INTEGER74_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:14: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:16: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR72=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause876); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR72_tree = (CommonTree)adaptor.dupNode(STDERROR72);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR72_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:29: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:31: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING73=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause881); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING73_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING73);


                        adaptor.addChild(root_1, QUOTEDSTRING73_tree);
                        }


                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:44: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:224:44: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER74=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause883); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER74_tree = (CommonTree)adaptor.dupNode(INTEGER74);


                                adaptor.addChild(root_1, INTEGER74_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstValidator.load_clause_return load_clause() throws RecognitionException {
        AstValidator.load_clause_return retval = new AstValidator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD75=null;
        AstValidator.filename_return filename76 =null;

        AstValidator.func_clause_return func_clause77 =null;

        AstValidator.as_clause_return as_clause78 =null;


        CommonTree LOAD75_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:13: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:15: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD75=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD75_tree = (CommonTree)adaptor.dupNode(LOAD75);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD75_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause902);
            filename76=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename76.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:32: ( func_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:32: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause904);
                    func_clause77=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:45: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:227:45: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause907);
                    as_clause78=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause78.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:230:1: filename : QUOTEDSTRING ;
    public final AstValidator.filename_return filename() throws RecognitionException {
        AstValidator.filename_return retval = new AstValidator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING79=null;

        CommonTree QUOTEDSTRING79_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:230:10: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:230:12: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING79=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING79_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING79);


            adaptor.addChild(root_0, QUOTEDSTRING79_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:233:1: as_clause : ^( AS field_def_list ) ;
    public final AstValidator.as_clause_return as_clause() throws RecognitionException {
        AstValidator.as_clause_return retval = new AstValidator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS80=null;
        AstValidator.field_def_list_return field_def_list81 =null;


        CommonTree AS80_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:233:10: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:233:12: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS80=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause929); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS80_tree = (CommonTree)adaptor.dupNode(AS80);


            root_1 = (CommonTree)adaptor.becomeRoot(AS80_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause931);
            field_def_list81=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list81.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:236:1: field_def[Set<String> fieldNames, NumValCarrier nvc] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AstValidator.field_def_return field_def(Set<String> fieldNames, NumValCarrier nvc) throws RecognitionException, DuplicatedSchemaAliasException {
        AstValidator.field_def_return retval = new AstValidator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF82=null;
        CommonTree IDENTIFIER83=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85=null;
        AstValidator.type_return type84 =null;

        AstValidator.type_return type86 =null;


        CommonTree FIELD_DEF82_tree=null;
        CommonTree IDENTIFIER83_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:237:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:237:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF82=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF82_tree = (CommonTree)adaptor.dupNode(FIELD_DEF82);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF82_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER83=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER83_tree = (CommonTree)adaptor.dupNode(IDENTIFIER83);


                    adaptor.addChild(root_1, IDENTIFIER83_tree);
                    }


                    if ( state.backtracking==0 ) { validateSchemaAliasName( fieldNames, IDENTIFIER83, (IDENTIFIER83!=null?IDENTIFIER83.getText():null) ); }

                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:237:102: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:237:102: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def956);
                            type84=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type84.getTree());


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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:238:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER85=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER85_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER85);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def968);
                    type86=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type86.getTree());


                    if ( state.backtracking==0 ) { validateSchemaAliasName ( fieldNames, FIELD_DEF_WITHOUT_IDENTIFIER85, nvc.makeNameFromDataType ( (type86!=null?type86.typev:0) ) ); }

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


    protected static class field_def_list_scope {
        Set<String> fieldNames;
        NumValCarrier nvc;
    }
    protected Stack field_def_list_stack = new Stack();


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:241:1: field_def_list : ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ ;
    public final AstValidator.field_def_list_return field_def_list() throws RecognitionException, DuplicatedSchemaAliasException {
        field_def_list_stack.push(new field_def_list_scope());
        AstValidator.field_def_list_return retval = new AstValidator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.field_def_return field_def87 =null;




            ((field_def_list_scope)field_def_list_stack.peek()).fieldNames = new HashSet<String>();
            ((field_def_list_scope)field_def_list_stack.peek()).nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:250:2: ( ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:250:6: field_def[$field_def_list::fieldNames, $field_def_list::nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list996);
            	    field_def87=field_def(((field_def_list_scope)field_def_list_stack.peek()).fieldNames, ((field_def_list_scope)field_def_list_stack.peek()).nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def87.getTree());


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
            field_def_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:253:1: type returns [byte typev] : ( simple_type | tuple_type | bag_type | map_type );
    public final AstValidator.type_return type() throws RecognitionException {
        AstValidator.type_return retval = new AstValidator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type88 =null;

        AstValidator.tuple_type_return tuple_type89 =null;

        AstValidator.bag_type_return bag_type90 =null;

        AstValidator.map_type_return map_type91 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:254:3: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:254:5: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1015);
                    simple_type88=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type88.getTree());


                    if ( state.backtracking==0 ) { retval.typev = (simple_type88!=null?simple_type88.typev:0); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:255:5: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1023);
                    tuple_type89=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type89.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.TUPLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:256:5: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1031);
                    bag_type90=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type90.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.BAG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:257:5: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1039);
                    map_type91=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type91.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.MAP; }

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
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:260:1: simple_type returns [byte typev] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstValidator.simple_type_return simple_type() throws RecognitionException {
        AstValidator.simple_type_return retval = new AstValidator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN92=null;
        CommonTree INT93=null;
        CommonTree LONG94=null;
        CommonTree FLOAT95=null;
        CommonTree DOUBLE96=null;
        CommonTree BIGINTEGER97=null;
        CommonTree BIGDECIMAL98=null;
        CommonTree DATETIME99=null;
        CommonTree CHARARRAY100=null;
        CommonTree BYTEARRAY101=null;

        CommonTree BOOLEAN92_tree=null;
        CommonTree INT93_tree=null;
        CommonTree LONG94_tree=null;
        CommonTree FLOAT95_tree=null;
        CommonTree DOUBLE96_tree=null;
        CommonTree BIGINTEGER97_tree=null;
        CommonTree BIGDECIMAL98_tree=null;
        CommonTree DATETIME99_tree=null;
        CommonTree CHARARRAY100_tree=null;
        CommonTree BYTEARRAY101_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:261:3: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:261:5: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN92=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN92_tree = (CommonTree)adaptor.dupNode(BOOLEAN92);


                    adaptor.addChild(root_0, BOOLEAN92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:262:5: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT93=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1064); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT93_tree = (CommonTree)adaptor.dupNode(INT93);


                    adaptor.addChild(root_0, INT93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:263:5: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG94=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG94_tree = (CommonTree)adaptor.dupNode(LONG94);


                    adaptor.addChild(root_0, LONG94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:264:5: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT95=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT95_tree = (CommonTree)adaptor.dupNode(FLOAT95);


                    adaptor.addChild(root_0, FLOAT95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:265:5: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE96=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE96_tree = (CommonTree)adaptor.dupNode(DOUBLE96);


                    adaptor.addChild(root_0, DOUBLE96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:266:5: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER97=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1096); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER97_tree = (CommonTree)adaptor.dupNode(BIGINTEGER97);


                    adaptor.addChild(root_0, BIGINTEGER97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:267:5: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL98=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL98_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL98);


                    adaptor.addChild(root_0, BIGDECIMAL98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:268:5: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME99=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME99_tree = (CommonTree)adaptor.dupNode(DATETIME99);


                    adaptor.addChild(root_0, DATETIME99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:269:5: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY100=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY100_tree = (CommonTree)adaptor.dupNode(CHARARRAY100);


                    adaptor.addChild(root_0, CHARARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:270:5: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY101=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY101_tree = (CommonTree)adaptor.dupNode(BYTEARRAY101);


                    adaptor.addChild(root_0, BYTEARRAY101_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BYTEARRAY; }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:273:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstValidator.tuple_type_return tuple_type() throws RecognitionException {
        AstValidator.tuple_type_return retval = new AstValidator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE102=null;
        AstValidator.field_def_list_return field_def_list103 =null;


        CommonTree TUPLE_TYPE102_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:273:12: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:273:14: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE102=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE102_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE102);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE102_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:273:28: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:273:28: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1143);
                        field_def_list103=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list103.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AstValidator.bag_type_return bag_type() throws RecognitionException {
        AstValidator.bag_type_return retval = new AstValidator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE104=null;
        CommonTree IDENTIFIER105=null;
        AstValidator.tuple_type_return tuple_type106 =null;


        CommonTree BAG_TYPE104_tree=null;
        CommonTree IDENTIFIER105_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:10: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:12: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE104=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE104_tree = (CommonTree)adaptor.dupNode(BAG_TYPE104);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE104_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:24: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:24: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER105=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1159); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER105_tree = (CommonTree)adaptor.dupNode(IDENTIFIER105);


                        adaptor.addChild(root_1, IDENTIFIER105_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:36: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:276:36: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1162);
                        tuple_type106=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type106.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:279:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstValidator.map_type_return map_type() throws RecognitionException {
        AstValidator.map_type_return retval = new AstValidator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE107=null;
        AstValidator.type_return type108 =null;


        CommonTree MAP_TYPE107_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:279:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:279:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE107=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE107_tree = (CommonTree)adaptor.dupNode(MAP_TYPE107);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE107_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:279:24: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:279:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1178);
                        type108=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type108.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:282:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstValidator.func_clause_return func_clause() throws RecognitionException {
        AstValidator.func_clause_return retval = new AstValidator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF109=null;
        CommonTree FUNC111=null;
        AstValidator.func_name_return func_name110 =null;

        AstValidator.func_name_return func_name112 =null;

        AstValidator.func_args_return func_args113 =null;


        CommonTree FUNC_REF109_tree=null;
        CommonTree FUNC111_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:282:13: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:282:15: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF109=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF109_tree = (CommonTree)adaptor.dupNode(FUNC_REF109);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF109_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1194);
                    func_name110=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name110.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:283:15: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC111=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC111_tree = (CommonTree)adaptor.dupNode(FUNC111);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC111_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1216);
                    func_name112=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name112.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:283:33: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:283:33: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1218);
                            func_args113=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args113.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:286:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstValidator.func_name_return func_name() throws RecognitionException {
        AstValidator.func_name_return retval = new AstValidator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set115=null;
        AstValidator.eid_return eid114 =null;

        AstValidator.eid_return eid116 =null;


        CommonTree set115_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:286:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:286:13: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1230);
            eid114=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid114.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:286:17: ( ( PERIOD | DOLLAR ) eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:286:19: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set115=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set115_tree = (CommonTree)adaptor.dupNode(set115);


            	        adaptor.addChild(root_0, set115_tree);
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
            	    pushFollow(FOLLOW_eid_in_func_name1244);
            	    eid116=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid116.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
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


    public static class func_args_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args_string"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:289:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstValidator.func_args_string_return func_args_string() throws RecognitionException {
        AstValidator.func_args_string_return retval = new AstValidator.func_args_string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set117=null;

        CommonTree set117_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:289:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set117=(CommonTree)input.LT(1);

            if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set117_tree = (CommonTree)adaptor.dupNode(set117);


                adaptor.addChild(root_0, set117_tree);
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
    // $ANTLR end "func_args_string"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:292:1: func_args : ( func_args_string )+ ;
    public final AstValidator.func_args_return func_args() throws RecognitionException {
        AstValidator.func_args_return retval = new AstValidator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_args_string_return func_args_string118 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:292:11: ( ( func_args_string )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==MULTILINE_QUOTEDSTRING||LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:292:13: func_args_string
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_args_string_in_func_args1269);
            	    func_args_string118=func_args_string();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_args_string118.getTree());


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
    // $ANTLR end "func_args"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:295:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstValidator.cube_clause_return cube_clause() throws RecognitionException {
        AstValidator.cube_clause_return retval = new AstValidator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE119=null;
        AstValidator.cube_item_return cube_item120 =null;


        CommonTree CUBE119_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:296:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:296:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE119=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE119_tree = (CommonTree)adaptor.dupNode(CUBE119);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1284);
            cube_item120=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item120.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:299:1: h2irg_clause : ( pivot_clause | autopivot_clause );
    public final AstValidator.h2irg_clause_return h2irg_clause() throws RecognitionException {
        AstValidator.h2irg_clause_return retval = new AstValidator.h2irg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.pivot_clause_return pivot_clause121 =null;

        AstValidator.autopivot_clause_return autopivot_clause122 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:300:5: ( pivot_clause | autopivot_clause )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==PIVOT) ) {
                alt34=1;
            }
            else if ( (LA34_0==CHUNKSIZE) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:300:7: pivot_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_pivot_clause_in_h2irg_clause1299);
                    pivot_clause121=pivot_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, pivot_clause121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:300:22: autopivot_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_autopivot_clause_in_h2irg_clause1303);
                    autopivot_clause122=autopivot_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, autopivot_clause122.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:303:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AstValidator.pivot_clause_return pivot_clause() throws RecognitionException {
        AstValidator.pivot_clause_return retval = new AstValidator.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT123=null;
        CommonTree INTEGER124=null;

        CommonTree PIVOT123_tree=null;
        CommonTree INTEGER124_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:304:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:304:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT123=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT123_tree = (CommonTree)adaptor.dupNode(PIVOT123);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT123_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER124=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER124_tree = (CommonTree)adaptor.dupNode(INTEGER124);


            adaptor.addChild(root_1, INTEGER124_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:307:1: autopivot_clause : chunksize_clause rate_clause ;
    public final AstValidator.autopivot_clause_return autopivot_clause() throws RecognitionException {
        AstValidator.autopivot_clause_return retval = new AstValidator.autopivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.chunksize_clause_return chunksize_clause125 =null;

        AstValidator.rate_clause_return rate_clause126 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:308:5: ( chunksize_clause rate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:308:7: chunksize_clause rate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_chunksize_clause_in_autopivot_clause1336);
            chunksize_clause125=chunksize_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, chunksize_clause125.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rate_clause_in_autopivot_clause1338);
            rate_clause126=rate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rate_clause126.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:311:1: chunksize_clause : ^( CHUNKSIZE INTEGER ) ;
    public final AstValidator.chunksize_clause_return chunksize_clause() throws RecognitionException {
        AstValidator.chunksize_clause_return retval = new AstValidator.chunksize_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CHUNKSIZE127=null;
        CommonTree INTEGER128=null;

        CommonTree CHUNKSIZE127_tree=null;
        CommonTree INTEGER128_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:312:5: ( ^( CHUNKSIZE INTEGER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:312:7: ^( CHUNKSIZE INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CHUNKSIZE127=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_chunksize_clause1353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CHUNKSIZE127_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE127);


            root_1 = (CommonTree)adaptor.becomeRoot(CHUNKSIZE127_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER128=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_chunksize_clause1355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER128_tree = (CommonTree)adaptor.dupNode(INTEGER128);


            adaptor.addChild(root_1, INTEGER128_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:315:1: rate_clause : ^( RATE DOUBLENUMBER ) ;
    public final AstValidator.rate_clause_return rate_clause() throws RecognitionException {
        AstValidator.rate_clause_return retval = new AstValidator.rate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RATE129=null;
        CommonTree DOUBLENUMBER130=null;

        CommonTree RATE129_tree=null;
        CommonTree DOUBLENUMBER130_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:316:5: ( ^( RATE DOUBLENUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:316:7: ^( RATE DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RATE129=(CommonTree)match(input,RATE,FOLLOW_RATE_in_rate_clause1372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RATE129_tree = (CommonTree)adaptor.dupNode(RATE129);


            root_1 = (CommonTree)adaptor.becomeRoot(RATE129_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            DOUBLENUMBER130=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_rate_clause1374); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLENUMBER130_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER130);


            adaptor.addChild(root_1, DOUBLENUMBER130_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:319:1: cube_item : rel ( cube_by_clause ) ;
    public final AstValidator.cube_item_return cube_item() throws RecognitionException {
        AstValidator.cube_item_return retval = new AstValidator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel131 =null;

        AstValidator.cube_by_clause_return cube_by_clause132 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:320:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:320:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1386);
            rel131=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel131.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:320:8: ( cube_by_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:320:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1390);
            cube_by_clause132=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause132.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:323:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstValidator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstValidator.cube_by_clause_return retval = new AstValidator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY133=null;
        AstValidator.cube_or_rollup_return cube_or_rollup134 =null;


        CommonTree BY133_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:324:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:324:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY133=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY133_tree = (CommonTree)adaptor.dupNode(BY133);


            root_1 = (CommonTree)adaptor.becomeRoot(BY133_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1406);
            cube_or_rollup134=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup134.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:327:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AstValidator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstValidator.cube_or_rollup_return retval = new AstValidator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_rollup_list_return cube_rollup_list135 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:328:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:328:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:328:4: ( cube_rollup_list )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:328:4: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1418);
            	    cube_rollup_list135=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list135.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:331:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) );
    public final AstValidator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstValidator.cube_rollup_list_return retval = new AstValidator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE136=null;
        CommonTree ROLLUP138=null;
        AstValidator.cube_by_expr_list_return cube_by_expr_list137 =null;

        AstValidator.cube_by_expr_list_return cube_by_expr_list139 =null;

        AstValidator.pivot_clause_return pivot_clause140 =null;

        AstValidator.chunksize_clause_return chunksize_clause141 =null;

        AstValidator.rate_clause_return rate_clause142 =null;


        CommonTree CUBE136_tree=null;
        CommonTree ROLLUP138_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:2: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? ) )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:4: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE136=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1431); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE136_tree = (CommonTree)adaptor.dupNode(CUBE136);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE136_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1433);
                    cube_by_expr_list137=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list137.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:34: ^( ROLLUP cube_by_expr_list ( pivot_clause | ( chunksize_clause rate_clause ) )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP138=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP138_tree = (CommonTree)adaptor.dupNode(ROLLUP138);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP138_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1443);
                    cube_by_expr_list139=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list139.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:62: ( pivot_clause | ( chunksize_clause rate_clause ) )?
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
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:64: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1447);
                            pivot_clause140=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause140.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:79: ( chunksize_clause rate_clause )
                            {
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:79: ( chunksize_clause rate_clause )
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:332:81: chunksize_clause rate_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_chunksize_clause_in_cube_rollup_list1453);
                            chunksize_clause141=chunksize_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, chunksize_clause141.getTree());


                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_rate_clause_in_cube_rollup_list1455);
                            rate_clause142=rate_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, rate_clause142.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:335:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AstValidator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstValidator.cube_by_expr_list_return retval = new AstValidator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_by_expr_return cube_by_expr143 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:336:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:336:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:336:4: ( cube_by_expr )+
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
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:336:4: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1472);
            	    cube_by_expr143=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr143.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:339:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstValidator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstValidator.cube_by_expr_return retval = new AstValidator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR146=null;
        AstValidator.col_range_return col_range144 =null;

        AstValidator.expr_return expr145 =null;


        CommonTree STAR146_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:340:2: ( col_range | expr | STAR )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:340:4: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1483);
                    col_range144=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range144.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:340:16: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1487);
                    expr145=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr145.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:340:23: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR146=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1491); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR146_tree = (CommonTree)adaptor.dupNode(STAR146);


                    adaptor.addChild(root_0, STAR146_tree);
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
        int arity;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:343:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AstValidator.group_clause_return group_clause() throws RecognitionException {
        group_clause_stack.push(new group_clause_scope());
        AstValidator.group_clause_return retval = new AstValidator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set147=null;
        AstValidator.group_item_return group_item148 =null;

        AstValidator.group_type_return group_type149 =null;

        AstValidator.partition_clause_return partition_clause150 =null;


        CommonTree set147_tree=null;


            ((group_clause_scope)group_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:2: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:4: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set147=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set147_tree = (CommonTree)adaptor.dupNode(set147);


                root_1 = (CommonTree)adaptor.becomeRoot(set147_tree, root_1);
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
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:27: ( group_item )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==ARROBA||LA40_0==ASSERT||LA40_0==COGROUP||(LA40_0 >= CROSS && LA40_0 <= CUBE)||LA40_0==DEFINE||LA40_0==DISTINCT||LA40_0==FILTER||LA40_0==FOREACH||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==JOIN||(LA40_0 >= LIMIT && LA40_0 <= LOAD)||LA40_0==MAPREDUCE||LA40_0==ORDER||LA40_0==RANK||LA40_0==SAMPLE||LA40_0==SPLIT||(LA40_0 >= STORE && LA40_0 <= STREAM)||LA40_0==UNION) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:27: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1522);
            	    group_item148=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item148.getTree());


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


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:39: ( group_type )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==QUOTEDSTRING) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:39: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1525);
                    group_type149=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type149.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:51: ( partition_clause )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==PARTITION) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:350:51: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1528);
                    partition_clause150=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause150.getTree());


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
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:353:1: group_type : QUOTEDSTRING ;
    public final AstValidator.group_type_return group_type() throws RecognitionException {
        AstValidator.group_type_return retval = new AstValidator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING151=null;

        CommonTree QUOTEDSTRING151_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:353:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:353:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING151=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING151_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING151);


            adaptor.addChild(root_0, QUOTEDSTRING151_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:356:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstValidator.group_item_return group_item() throws RecognitionException {
        AstValidator.group_item_return retval = new AstValidator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL154=null;
        CommonTree ANY155=null;
        CommonTree set156=null;
        AstValidator.rel_return rel152 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause153 =null;


        CommonTree ALL154_tree=null;
        CommonTree ANY155_tree=null;
        CommonTree set156_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1550);
            rel152=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel152.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:8: ( join_group_by_clause | ALL | ANY )
            int alt43=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt43=1;
                }
                break;
            case ALL:
                {
                alt43=2;
                }
                break;
            case ANY:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1554);
                    join_group_by_clause153=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause153.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:33: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL154=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL154_tree = (CommonTree)adaptor.dupNode(ALL154);


                    adaptor.addChild(root_0, ALL154_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:39: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY155=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY155_tree = (CommonTree)adaptor.dupNode(ANY155);


                    adaptor.addChild(root_0, ANY155_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:357:45: ( INNER | OUTER )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==INNER||LA44_0==OUTER) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set156=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set156_tree = (CommonTree)adaptor.dupNode(set156);


                        adaptor.addChild(root_0, set156_tree);
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
                   if( ((group_clause_scope)group_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((group_clause_scope)group_clause_stack.peek()).arity = (join_group_by_clause153!=null?join_group_by_clause153.exprCount:0);
                   } else if( (join_group_by_clause153!=null?join_group_by_clause153.exprCount:0) != ((group_clause_scope)group_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the group by columns do not match." );
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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:369:1: rel : ( alias | previous_rel | op_clause ( parallel_clause )? );
    public final AstValidator.rel_return rel() throws RecognitionException {
        AstValidator.rel_return retval = new AstValidator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_return alias157 =null;

        AstValidator.previous_rel_return previous_rel158 =null;

        AstValidator.op_clause_return op_clause159 =null;

        AstValidator.parallel_clause_return parallel_clause160 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:369:5: ( alias | previous_rel | op_clause ( parallel_clause )? )
            int alt46=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt46=1;
                }
                break;
            case ARROBA:
                {
                alt46=2;
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
            case SPLIT:
            case STORE:
            case STREAM:
            case UNION:
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:369:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1589);
                    alias157=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias157.getTree());


                    if ( state.backtracking==0 ) {  validateAliasRef( aliases, (alias157!=null?alias157.node:null), (alias157!=null?alias157.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:370:7: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1599);
                    previous_rel158=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel158.getTree());


                    if ( state.backtracking==0 ) { validateAliasRef( aliases, (previous_rel158!=null?previous_rel158.node:null), (previous_rel158!=null?previous_rel158.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:371:7: op_clause ( parallel_clause )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1609);
                    op_clause159=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause159.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:371:17: ( parallel_clause )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==PARALLEL) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:371:17: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1611);
                            parallel_clause160=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause160.getTree());


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
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstValidator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstValidator.flatten_generated_item_return retval = new AstValidator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR164=null;
        AstValidator.flatten_clause_return flatten_clause161 =null;

        AstValidator.col_range_return col_range162 =null;

        AstValidator.expr_return expr163 =null;

        AstValidator.field_def_list_return field_def_list165 =null;


        CommonTree STAR164_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:24: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:26: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:26: ( flatten_clause | col_range | expr | STAR )
            int alt47=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt47=1;
                }
                break;
            case COL_RANGE:
                {
                alt47=2;
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
                alt47=3;
                }
                break;
            case STAR:
                {
                int LA47_4 = input.LA(2);

                if ( (LA47_4==DOWN) ) {
                    alt47=3;
                }
                else if ( (LA47_4==EOF||LA47_4==UP||LA47_4==BIGDECIMALNUMBER||LA47_4==BIGINTEGERNUMBER||LA47_4==CUBE||LA47_4==DIV||LA47_4==DOLLARVAR||LA47_4==DOUBLENUMBER||LA47_4==FALSE||LA47_4==FLATTEN||LA47_4==FLOATNUMBER||LA47_4==GROUP||LA47_4==IDENTIFIER||LA47_4==INTEGER||LA47_4==LONGINTEGER||LA47_4==MINUS||LA47_4==NULL||LA47_4==PERCENT||LA47_4==PLUS||LA47_4==QUOTEDSTRING||LA47_4==STAR||LA47_4==TRUE||(LA47_4 >= BAG_VAL && LA47_4 <= BIN_EXPR)||(LA47_4 >= CASE_COND && LA47_4 <= CASE_EXPR)||(LA47_4 >= CAST_EXPR && LA47_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA47_4==FUNC_EVAL||LA47_4==INVOKER_FUNC_EVAL||(LA47_4 >= MAP_VAL && LA47_4 <= NEG)||LA47_4==TUPLE_VAL) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 4, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:28: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1623);
                    flatten_clause161=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause161.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:45: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1627);
                    col_range162=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range162.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:57: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1631);
                    expr163=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr163.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:64: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR164=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR164_tree = (CommonTree)adaptor.dupNode(STAR164);


                    adaptor.addChild(root_0, STAR164_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:71: ( field_def_list )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0 >= FIELD_DEF && LA48_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:374:71: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1639);
                    field_def_list165=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list165.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:377:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstValidator.flatten_clause_return flatten_clause() throws RecognitionException {
        AstValidator.flatten_clause_return retval = new AstValidator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN166=null;
        AstValidator.expr_return expr167 =null;


        CommonTree FLATTEN166_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:377:16: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:377:18: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN166=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1651); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN166_tree = (CommonTree)adaptor.dupNode(FLATTEN166);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN166_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1653);
            expr167=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr167.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:380:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstValidator.store_clause_return store_clause() throws RecognitionException {
        AstValidator.store_clause_return retval = new AstValidator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE168=null;
        AstValidator.rel_return rel169 =null;

        AstValidator.filename_return filename170 =null;

        AstValidator.func_clause_return func_clause171 =null;


        CommonTree STORE168_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:380:14: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:380:16: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE168=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE168_tree = (CommonTree)adaptor.dupNode(STORE168);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE168_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1668);
            rel169=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel169.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1670);
            filename170=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename170.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:380:38: ( func_clause )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FUNC||LA49_0==FUNC_REF) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:380:38: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1672);
                    func_clause171=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause171.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:383:1: assert_clause : ^( ASSERT rel cond ( comment )? ) ;
    public final AstValidator.assert_clause_return assert_clause() throws RecognitionException {
        AstValidator.assert_clause_return retval = new AstValidator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT172=null;
        AstValidator.rel_return rel173 =null;

        AstValidator.cond_return cond174 =null;

        AstValidator.comment_return comment175 =null;


        CommonTree ASSERT172_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:383:15: ( ^( ASSERT rel cond ( comment )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:383:17: ^( ASSERT rel cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT172=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1686); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT172_tree = (CommonTree)adaptor.dupNode(ASSERT172);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT172_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause1688);
            rel173=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel173.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1690);
            cond174=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond174.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:383:36: ( comment )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==QUOTEDSTRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:383:36: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1692);
                    comment175=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment175.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:386:1: comment : QUOTEDSTRING ;
    public final AstValidator.comment_return comment() throws RecognitionException {
        AstValidator.comment_return retval = new AstValidator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING176=null;

        CommonTree QUOTEDSTRING176_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:386:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:386:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING176=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING176_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING176);


            adaptor.addChild(root_0, QUOTEDSTRING176_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:389:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstValidator.filter_clause_return filter_clause() throws RecognitionException {
        AstValidator.filter_clause_return retval = new AstValidator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER177=null;
        AstValidator.rel_return rel178 =null;

        AstValidator.cond_return cond179 =null;


        CommonTree FILTER177_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:389:15: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:389:17: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER177=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER177_tree = (CommonTree)adaptor.dupNode(FILTER177);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER177_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1718);
            rel178=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel178.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1720);
            cond179=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond179.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:392:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstValidator.cond_return cond() throws RecognitionException {
        AstValidator.cond_return retval = new AstValidator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR180=null;
        CommonTree AND183=null;
        CommonTree NOT186=null;
        CommonTree NULL188=null;
        CommonTree NOT190=null;
        CommonTree BOOL_COND196=null;
        AstValidator.cond_return cond181 =null;

        AstValidator.cond_return cond182 =null;

        AstValidator.cond_return cond184 =null;

        AstValidator.cond_return cond185 =null;

        AstValidator.cond_return cond187 =null;

        AstValidator.expr_return expr189 =null;

        AstValidator.rel_op_return rel_op191 =null;

        AstValidator.expr_return expr192 =null;

        AstValidator.expr_return expr193 =null;

        AstValidator.in_eval_return in_eval194 =null;

        AstValidator.func_eval_return func_eval195 =null;

        AstValidator.expr_return expr197 =null;


        CommonTree OR180_tree=null;
        CommonTree AND183_tree=null;
        CommonTree NOT186_tree=null;
        CommonTree NULL188_tree=null;
        CommonTree NOT190_tree=null;
        CommonTree BOOL_COND196_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:392:6: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt52=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt52=1;
                }
                break;
            case AND:
                {
                alt52=2;
                }
                break;
            case NOT:
                {
                alt52=3;
                }
                break;
            case NULL:
                {
                alt52=4;
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
                alt52=5;
                }
                break;
            case IN:
                {
                alt52=6;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt52=7;
                }
                break;
            case BOOL_COND:
                {
                alt52=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:392:8: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR180=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR180_tree = (CommonTree)adaptor.dupNode(OR180);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR180_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1735);
                    cond181=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond181.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1737);
                    cond182=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond182.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:393:8: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND183=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND183_tree = (CommonTree)adaptor.dupNode(AND183);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND183_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1752);
                    cond184=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond184.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1754);
                    cond185=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond185.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:394:8: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT186=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT186_tree = (CommonTree)adaptor.dupNode(NOT186);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1769);
                    cond187=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond187.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:395:8: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL188=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL188_tree = (CommonTree)adaptor.dupNode(NULL188);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL188_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1784);
                    expr189=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr189.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:395:21: ( NOT )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==NOT) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:395:21: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT190=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1786); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT190_tree = (CommonTree)adaptor.dupNode(NOT190);


                            adaptor.addChild(root_1, NOT190_tree);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:396:8: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1800);
                    rel_op191=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op191.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1802);
                    expr192=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr192.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1804);
                    expr193=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr193.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:397:8: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1815);
                    in_eval194=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval194.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:398:8: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1824);
                    func_eval195=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval195.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:399:8: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND196=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND196_tree = (CommonTree)adaptor.dupNode(BOOL_COND196);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND196_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1837);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:402:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AstValidator.in_eval_return in_eval() throws RecognitionException {
        AstValidator.in_eval_return retval = new AstValidator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN198=null;
        CommonTree IN_LHS199=null;
        CommonTree IN_RHS201=null;
        AstValidator.expr_return expr200 =null;

        AstValidator.expr_return expr202 =null;


        CommonTree IN198_tree=null;
        CommonTree IN_LHS199_tree=null;
        CommonTree IN_RHS201_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:402:8: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:402:10: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN198=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN198_tree = (CommonTree)adaptor.dupNode(IN198);


            root_1 = (CommonTree)adaptor.becomeRoot(IN198_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:402:16: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==IN_LHS) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:402:18: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS199=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1855); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS199_tree = (CommonTree)adaptor.dupNode(IN_LHS199);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS199_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1857);
            	    expr200=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr200.getTree());


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
            	    IN_RHS201=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1863); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS201_tree = (CommonTree)adaptor.dupNode(IN_RHS201);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS201_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1865);
            	    expr202=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr202.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:1: func_eval : ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) );
    public final AstValidator.func_eval_return func_eval() throws RecognitionException {
        AstValidator.func_eval_return retval = new AstValidator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL203=null;
        CommonTree INVOKER_FUNC_EVAL206=null;
        CommonTree IDENTIFIER208=null;
        AstValidator.func_name_return func_name204 =null;

        AstValidator.real_arg_return real_arg205 =null;

        AstValidator.func_name_return func_name207 =null;

        AstValidator.real_arg_return real_arg209 =null;


        CommonTree FUNC_EVAL203_tree=null;
        CommonTree INVOKER_FUNC_EVAL206_tree=null;
        CommonTree IDENTIFIER208_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:10: ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FUNC_EVAL) ) {
                alt56=1;
            }
            else if ( (LA56_0==INVOKER_FUNC_EVAL) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:12: ^( FUNC_EVAL func_name ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL203=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL203_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL203);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1884);
                    func_name204=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name204.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:35: ( real_arg )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==BIGDECIMALNUMBER||LA54_0==BIGINTEGERNUMBER||LA54_0==CUBE||LA54_0==DIV||LA54_0==DOLLARVAR||LA54_0==DOUBLENUMBER||LA54_0==FALSE||LA54_0==FLOATNUMBER||LA54_0==GROUP||LA54_0==IDENTIFIER||LA54_0==INTEGER||LA54_0==LONGINTEGER||LA54_0==MINUS||LA54_0==NULL||LA54_0==PERCENT||LA54_0==PLUS||LA54_0==QUOTEDSTRING||LA54_0==STAR||LA54_0==TRUE||(LA54_0 >= BAG_VAL && LA54_0 <= BIN_EXPR)||(LA54_0 >= CASE_COND && LA54_0 <= CASE_EXPR)||(LA54_0 >= CAST_EXPR && LA54_0 <= EXPR_IN_PAREN)||LA54_0==FUNC_EVAL||LA54_0==INVOKER_FUNC_EVAL||(LA54_0 >= MAP_VAL && LA54_0 <= NEG)||LA54_0==TUPLE_VAL) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:35: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1886);
                    	    real_arg205=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg205.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:49: ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL206=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL206_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL206);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL206_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1897);
                    func_name207=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name207.getTree());


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER208=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval1899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER208_tree = (CommonTree)adaptor.dupNode(IDENTIFIER208);


                    adaptor.addChild(root_1, IDENTIFIER208_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:91: ( real_arg )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==BIGDECIMALNUMBER||LA55_0==BIGINTEGERNUMBER||LA55_0==CUBE||LA55_0==DIV||LA55_0==DOLLARVAR||LA55_0==DOUBLENUMBER||LA55_0==FALSE||LA55_0==FLOATNUMBER||LA55_0==GROUP||LA55_0==IDENTIFIER||LA55_0==INTEGER||LA55_0==LONGINTEGER||LA55_0==MINUS||LA55_0==NULL||LA55_0==PERCENT||LA55_0==PLUS||LA55_0==QUOTEDSTRING||LA55_0==STAR||LA55_0==TRUE||(LA55_0 >= BAG_VAL && LA55_0 <= BIN_EXPR)||(LA55_0 >= CASE_COND && LA55_0 <= CASE_EXPR)||(LA55_0 >= CAST_EXPR && LA55_0 <= EXPR_IN_PAREN)||LA55_0==FUNC_EVAL||LA55_0==INVOKER_FUNC_EVAL||(LA55_0 >= MAP_VAL && LA55_0 <= NEG)||LA55_0==TUPLE_VAL) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:405:91: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1901);
                    	    real_arg209=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg209.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:408:1: real_arg : ( expr | STAR | col_range );
    public final AstValidator.real_arg_return real_arg() throws RecognitionException {
        AstValidator.real_arg_return retval = new AstValidator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR211=null;
        AstValidator.expr_return expr210 =null;

        AstValidator.col_range_return col_range212 =null;


        CommonTree STAR211_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:408:10: ( expr | STAR | col_range )
            int alt57=3;
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
                alt57=1;
                }
                break;
            case STAR:
                {
                int LA57_2 = input.LA(2);

                if ( (LA57_2==DOWN) ) {
                    alt57=1;
                }
                else if ( (LA57_2==EOF||LA57_2==UP||LA57_2==BIGDECIMALNUMBER||LA57_2==BIGINTEGERNUMBER||LA57_2==CUBE||LA57_2==DIV||LA57_2==DOLLARVAR||LA57_2==DOUBLENUMBER||LA57_2==FALSE||LA57_2==FLOATNUMBER||LA57_2==GROUP||LA57_2==IDENTIFIER||LA57_2==INTEGER||LA57_2==LONGINTEGER||LA57_2==MINUS||LA57_2==NULL||LA57_2==PERCENT||LA57_2==PLUS||LA57_2==QUOTEDSTRING||LA57_2==STAR||LA57_2==TRUE||(LA57_2 >= BAG_VAL && LA57_2 <= BIN_EXPR)||(LA57_2 >= CASE_COND && LA57_2 <= CASE_EXPR)||(LA57_2 >= CAST_EXPR && LA57_2 <= EXPR_IN_PAREN)||LA57_2==FUNC_EVAL||LA57_2==INVOKER_FUNC_EVAL||(LA57_2 >= MAP_VAL && LA57_2 <= NEG)||LA57_2==TUPLE_VAL) ) {
                    alt57=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:408:12: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1913);
                    expr210=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr210.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:408:19: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR211=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1917); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR211_tree = (CommonTree)adaptor.dupNode(STAR211);


                    adaptor.addChild(root_0, STAR211_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:408:26: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1921);
                    col_range212=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range212.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:411:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstValidator.expr_return expr() throws RecognitionException {
        AstValidator.expr_return retval = new AstValidator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS213=null;
        CommonTree MINUS216=null;
        CommonTree STAR219=null;
        CommonTree DIV222=null;
        CommonTree PERCENT225=null;
        CommonTree CAST_EXPR228=null;
        CommonTree NEG233=null;
        CommonTree CAST_EXPR235=null;
        CommonTree EXPR_IN_PAREN238=null;
        AstValidator.expr_return expr214 =null;

        AstValidator.expr_return expr215 =null;

        AstValidator.expr_return expr217 =null;

        AstValidator.expr_return expr218 =null;

        AstValidator.expr_return expr220 =null;

        AstValidator.expr_return expr221 =null;

        AstValidator.expr_return expr223 =null;

        AstValidator.expr_return expr224 =null;

        AstValidator.expr_return expr226 =null;

        AstValidator.expr_return expr227 =null;

        AstValidator.type_return type229 =null;

        AstValidator.expr_return expr230 =null;

        AstValidator.const_expr_return const_expr231 =null;

        AstValidator.var_expr_return var_expr232 =null;

        AstValidator.expr_return expr234 =null;

        AstValidator.type_cast_return type_cast236 =null;

        AstValidator.expr_return expr237 =null;

        AstValidator.expr_return expr239 =null;


        CommonTree PLUS213_tree=null;
        CommonTree MINUS216_tree=null;
        CommonTree STAR219_tree=null;
        CommonTree DIV222_tree=null;
        CommonTree PERCENT225_tree=null;
        CommonTree CAST_EXPR228_tree=null;
        CommonTree NEG233_tree=null;
        CommonTree CAST_EXPR235_tree=null;
        CommonTree EXPR_IN_PAREN238_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:411:6: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt58=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt58=1;
                }
                break;
            case MINUS:
                {
                int LA58_2 = input.LA(2);

                if ( (synpred111_AstValidator()) ) {
                    alt58=2;
                }
                else if ( (synpred116_AstValidator()) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt58=3;
                }
                break;
            case DIV:
                {
                alt58=4;
                }
                break;
            case PERCENT:
                {
                alt58=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA58_6 = input.LA(2);

                if ( (synpred115_AstValidator()) ) {
                    alt58=6;
                }
                else if ( (synpred119_AstValidator()) ) {
                    alt58=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 6, input);

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
                alt58=7;
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
                alt58=8;
                }
                break;
            case NEG:
                {
                alt58=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt58=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:411:8: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS213=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS213_tree = (CommonTree)adaptor.dupNode(PLUS213);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS213_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1934);
                    expr214=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr214.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1936);
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
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:412:8: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS216=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1949); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS216_tree = (CommonTree)adaptor.dupNode(MINUS216);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS216_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1951);
                    expr217=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr217.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1953);
                    expr218=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr218.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:413:8: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR219=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR219_tree = (CommonTree)adaptor.dupNode(STAR219);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR219_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1968);
                    expr220=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr220.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1970);
                    expr221=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr221.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:414:8: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV222=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV222_tree = (CommonTree)adaptor.dupNode(DIV222);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV222_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1985);
                    expr223=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr223.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1987);
                    expr224=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr224.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:415:8: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT225=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT225_tree = (CommonTree)adaptor.dupNode(PERCENT225);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT225_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2002);
                    expr226=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr226.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2004);
                    expr227=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr227.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:416:8: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR228=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR228_tree = (CommonTree)adaptor.dupNode(CAST_EXPR228);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR228_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr2019);
                    type229=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type229.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2021);
                    expr230=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr230.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:417:8: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2032);
                    const_expr231=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr231.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:418:8: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2041);
                    var_expr232=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr232.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:419:8: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG233=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG233_tree = (CommonTree)adaptor.dupNode(NEG233);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG233_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2054);
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
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:420:8: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR235=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR235_tree = (CommonTree)adaptor.dupNode(CAST_EXPR235);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR235_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2069);
                    type_cast236=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast236.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2071);
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
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:421:8: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN238=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2084); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN238_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN238);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN238_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2086);
                    expr239=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr239.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstValidator.type_cast_return type_cast() throws RecognitionException {
        AstValidator.type_cast_return retval = new AstValidator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type240 =null;

        AstValidator.map_type_return map_type241 =null;

        AstValidator.tuple_type_cast_return tuple_type_cast242 =null;

        AstValidator.bag_type_cast_return bag_type_cast243 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:11: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt59=4;
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
                alt59=1;
                }
                break;
            case MAP_TYPE:
                {
                alt59=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt59=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt59=4;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:13: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2097);
                    simple_type240=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type240.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:27: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2101);
                    map_type241=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type241.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:38: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2105);
                    tuple_type_cast242=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast242.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:424:56: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2109);
                    bag_type_cast243=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast243.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:427:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AstValidator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstValidator.tuple_type_cast_return retval = new AstValidator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST244=null;
        AstValidator.type_cast_return type_cast245 =null;


        CommonTree TUPLE_TYPE_CAST244_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:427:17: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:427:19: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST244=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST244_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST244);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST244_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:427:38: ( type_cast )*
                loop60:
                do {
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==BIGDECIMAL||LA60_0==BIGINTEGER||LA60_0==BOOLEAN||LA60_0==BYTEARRAY||LA60_0==CHARARRAY||LA60_0==DATETIME||LA60_0==DOUBLE||LA60_0==FLOAT||LA60_0==INT||LA60_0==LONG||LA60_0==BAG_TYPE_CAST||LA60_0==MAP_TYPE||LA60_0==TUPLE_TYPE_CAST) ) {
                        alt60=1;
                    }


                    switch (alt60) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:427:38: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2122);
                	    type_cast245=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast245.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop60;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:430:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstValidator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstValidator.bag_type_cast_return retval = new AstValidator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST246=null;
        AstValidator.tuple_type_cast_return tuple_type_cast247 =null;


        CommonTree BAG_TYPE_CAST246_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:430:15: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:430:17: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST246=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2136); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST246_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST246);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST246_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:430:34: ( tuple_type_cast )?
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==TUPLE_TYPE_CAST) ) {
                    alt61=1;
                }
                switch (alt61) {
                    case 1 :
                        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:430:34: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2138);
                        tuple_type_cast247=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast247.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstValidator.var_expr_return var_expr() throws RecognitionException {
        AstValidator.var_expr_return retval = new AstValidator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.projectable_expr_return projectable_expr248 =null;

        AstValidator.dot_proj_return dot_proj249 =null;

        AstValidator.pound_proj_return pound_proj250 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:10: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:12: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2150);
            projectable_expr248=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr248.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:29: ( dot_proj | pound_proj )*
            loop62:
            do {
                int alt62=3;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==PERIOD) ) {
                    alt62=1;
                }
                else if ( (LA62_0==POUND) ) {
                    alt62=2;
                }


                switch (alt62) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:31: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2154);
            	    dot_proj249=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj249.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:433:42: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2158);
            	    pound_proj250=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj250.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop62;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstValidator.projectable_expr_return projectable_expr() throws RecognitionException {
        AstValidator.projectable_expr_return retval = new AstValidator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_eval_return func_eval251 =null;

        AstValidator.col_ref_return col_ref252 =null;

        AstValidator.bin_expr_return bin_expr253 =null;

        AstValidator.case_expr_return case_expr254 =null;

        AstValidator.case_cond_return case_cond255 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:17: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt63=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt63=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt63=2;
                }
                break;
            case BIN_EXPR:
                {
                alt63=3;
                }
                break;
            case CASE_EXPR:
                {
                alt63=4;
                }
                break;
            case CASE_COND:
                {
                alt63=5;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:19: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2169);
                    func_eval251=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval251.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:31: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2173);
                    col_ref252=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref252.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:41: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2177);
                    bin_expr253=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr253.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:52: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2181);
                    case_expr254=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr254.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:436:64: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2185);
                    case_cond255=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond255.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:439:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AstValidator.dot_proj_return dot_proj() throws RecognitionException {
        AstValidator.dot_proj_return retval = new AstValidator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD256=null;
        AstValidator.col_alias_or_index_return col_alias_or_index257 =null;


        CommonTree PERIOD256_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:439:10: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:439:12: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD256=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD256_tree = (CommonTree)adaptor.dupNode(PERIOD256);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD256_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:439:22: ( col_alias_or_index )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==CUBE||LA64_0==DOLLARVAR||LA64_0==GROUP||LA64_0==IDENTIFIER) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:439:22: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2198);
            	    col_alias_or_index257=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index257.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:442:1: col_alias_or_index : ( col_alias | col_index );
    public final AstValidator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstValidator.col_alias_or_index_return retval = new AstValidator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_alias_return col_alias258 =null;

        AstValidator.col_index_return col_index259 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:442:20: ( col_alias | col_index )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CUBE||LA65_0==GROUP||LA65_0==IDENTIFIER) ) {
                alt65=1;
            }
            else if ( (LA65_0==DOLLARVAR) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:442:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2210);
                    col_alias258=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias258.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:442:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2214);
                    col_index259=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index259.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:445:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.col_alias_return col_alias() throws RecognitionException {
        AstValidator.col_alias_return retval = new AstValidator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set260=null;

        CommonTree set260_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:445:11: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set260=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set260_tree = (CommonTree)adaptor.dupNode(set260);


                adaptor.addChild(root_0, set260_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:448:1: col_index : DOLLARVAR ;
    public final AstValidator.col_index_return col_index() throws RecognitionException {
        AstValidator.col_index_return retval = new AstValidator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR261=null;

        CommonTree DOLLARVAR261_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:448:11: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:448:13: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR261=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR261_tree = (CommonTree)adaptor.dupNode(DOLLARVAR261);


            adaptor.addChild(root_0, DOLLARVAR261_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstValidator.col_range_return col_range() throws RecognitionException {
        AstValidator.col_range_return retval = new AstValidator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE262=null;
        CommonTree DOUBLE_PERIOD264=null;
        AstValidator.col_ref_return col_ref263 =null;

        AstValidator.col_ref_return col_ref265 =null;


        CommonTree COL_RANGE262_tree=null;
        CommonTree DOUBLE_PERIOD264_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE262=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE262_tree = (CommonTree)adaptor.dupNode(COL_RANGE262);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE262_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:26: ( col_ref )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==CUBE||LA66_0==DOLLARVAR||LA66_0==GROUP||LA66_0==IDENTIFIER) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2253);
                    col_ref263=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref263.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD264=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD264_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD264);


            adaptor.addChild(root_1, DOUBLE_PERIOD264_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:49: ( col_ref )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==CUBE||LA67_0==DOLLARVAR||LA67_0==GROUP||LA67_0==IDENTIFIER) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:451:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2258);
                    col_ref265=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref265.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:455:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstValidator.pound_proj_return pound_proj() throws RecognitionException {
        AstValidator.pound_proj_return retval = new AstValidator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND266=null;
        CommonTree set267=null;

        CommonTree POUND266_tree=null;
        CommonTree set267_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:455:12: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:455:14: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND266=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND266_tree = (CommonTree)adaptor.dupNode(POUND266);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND266_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set267=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set267_tree = (CommonTree)adaptor.dupNode(set267);


                adaptor.addChild(root_1, set267_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:458:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstValidator.bin_expr_return bin_expr() throws RecognitionException {
        AstValidator.bin_expr_return retval = new AstValidator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR268=null;
        AstValidator.cond_return cond269 =null;

        AstValidator.expr_return expr270 =null;

        AstValidator.expr_return expr271 =null;


        CommonTree BIN_EXPR268_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:458:10: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:458:12: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR268=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR268_tree = (CommonTree)adaptor.dupNode(BIN_EXPR268);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR268_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2297);
            cond269=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond269.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2299);
            expr270=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr270.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2301);
            expr271=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr271.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AstValidator.case_expr_return case_expr() throws RecognitionException {
        AstValidator.case_expr_return retval = new AstValidator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR272=null;
        CommonTree CASE_EXPR_LHS273=null;
        CommonTree CASE_EXPR_RHS275=null;
        AstValidator.expr_return expr274 =null;

        AstValidator.expr_return expr276 =null;


        CommonTree CASE_EXPR272_tree=null;
        CommonTree CASE_EXPR_LHS273_tree=null;
        CommonTree CASE_EXPR_RHS275_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:10: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:12: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR272=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR272_tree = (CommonTree)adaptor.dupNode(CASE_EXPR272);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR272_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:25: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==CASE_EXPR_LHS) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:27: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS273=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2319); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS273_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS273);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS273_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2321);
            	    expr274=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr274.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:51: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt68=0;
            	    loop68:
            	    do {
            	        int alt68=2;
            	        int LA68_0 = input.LA(1);

            	        if ( (LA68_0==CASE_EXPR_RHS) ) {
            	            alt68=1;
            	        }


            	        switch (alt68) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:461:53: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS275=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2329); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS275_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS275);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS275_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2331);
            	    	    expr276=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr276.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


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


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AstValidator.case_cond_return case_cond() throws RecognitionException {
        AstValidator.case_cond_return retval = new AstValidator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND277=null;
        CommonTree WHEN278=null;
        CommonTree THEN280=null;
        AstValidator.cond_return cond279 =null;

        AstValidator.expr_return expr281 =null;


        CommonTree CASE_COND277_tree=null;
        CommonTree WHEN278_tree=null;
        CommonTree THEN280_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:10: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:12: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND277=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND277_tree = (CommonTree)adaptor.dupNode(CASE_COND277);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN278=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN278_tree = (CommonTree)adaptor.dupNode(WHEN278);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN278_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:33: ( cond )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==AND||LA70_0==IN||(LA70_0 >= NOT && LA70_0 <= NUM_OP_NE)||LA70_0==OR||(LA70_0 >= STR_OP_EQ && LA70_0 <= STR_OP_NE)||LA70_0==BOOL_COND||LA70_0==FUNC_EVAL||LA70_0==INVOKER_FUNC_EVAL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:33: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2356);
            	    cond279=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond279.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
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
            THEN280=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2363); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN280_tree = (CommonTree)adaptor.dupNode(THEN280);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN280_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:49: ( expr )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==BIGDECIMALNUMBER||LA71_0==BIGINTEGERNUMBER||LA71_0==CUBE||LA71_0==DIV||LA71_0==DOLLARVAR||LA71_0==DOUBLENUMBER||LA71_0==FALSE||LA71_0==FLOATNUMBER||LA71_0==GROUP||LA71_0==IDENTIFIER||LA71_0==INTEGER||LA71_0==LONGINTEGER||LA71_0==MINUS||LA71_0==NULL||LA71_0==PERCENT||LA71_0==PLUS||LA71_0==QUOTEDSTRING||LA71_0==STAR||LA71_0==TRUE||(LA71_0 >= BAG_VAL && LA71_0 <= BIN_EXPR)||(LA71_0 >= CASE_COND && LA71_0 <= CASE_EXPR)||LA71_0==CAST_EXPR||LA71_0==EXPR_IN_PAREN||LA71_0==FUNC_EVAL||LA71_0==INVOKER_FUNC_EVAL||(LA71_0 >= MAP_VAL && LA71_0 <= NEG)||LA71_0==TUPLE_VAL) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:464:49: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2365);
            	    expr281=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr281.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstValidator.limit_clause_return limit_clause() throws RecognitionException {
        AstValidator.limit_clause_return retval = new AstValidator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT282=null;
        CommonTree INTEGER284=null;
        CommonTree LONGINTEGER285=null;
        AstValidator.rel_return rel283 =null;

        AstValidator.expr_return expr286 =null;


        CommonTree LIMIT282_tree=null;
        CommonTree INTEGER284_tree=null;
        CommonTree LONGINTEGER285_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:14: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:16: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT282=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2381); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT282_tree = (CommonTree)adaptor.dupNode(LIMIT282);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT282_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2383);
            rel283=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel283.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:29: ( INTEGER | LONGINTEGER | expr )
            int alt72=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA72_1 = input.LA(2);

                if ( (synpred142_AstValidator()) ) {
                    alt72=1;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA72_2 = input.LA(2);

                if ( (synpred143_AstValidator()) ) {
                    alt72=2;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 2, input);

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
                alt72=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER284=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2387); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER284_tree = (CommonTree)adaptor.dupNode(INTEGER284);


                    adaptor.addChild(root_1, INTEGER284_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:41: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER285=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER285_tree = (CommonTree)adaptor.dupNode(LONGINTEGER285);


                    adaptor.addChild(root_1, LONGINTEGER285_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:55: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2395);
                    expr286=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr286.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstValidator.sample_clause_return sample_clause() throws RecognitionException {
        AstValidator.sample_clause_return retval = new AstValidator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE287=null;
        CommonTree DOUBLENUMBER289=null;
        AstValidator.rel_return rel288 =null;

        AstValidator.expr_return expr290 =null;


        CommonTree SAMPLE287_tree=null;
        CommonTree DOUBLENUMBER289_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:15: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:17: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE287=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2410); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE287_tree = (CommonTree)adaptor.dupNode(SAMPLE287);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE287_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2412);
            rel288=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel288.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:31: ( DOUBLENUMBER | expr )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==DOUBLENUMBER) ) {
                int LA73_1 = input.LA(2);

                if ( (synpred144_AstValidator()) ) {
                    alt73=1;
                }
                else if ( (true) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA73_0==BIGDECIMALNUMBER||LA73_0==BIGINTEGERNUMBER||LA73_0==CUBE||LA73_0==DIV||LA73_0==DOLLARVAR||LA73_0==FALSE||LA73_0==FLOATNUMBER||LA73_0==GROUP||LA73_0==IDENTIFIER||LA73_0==INTEGER||LA73_0==LONGINTEGER||LA73_0==MINUS||LA73_0==NULL||LA73_0==PERCENT||LA73_0==PLUS||LA73_0==QUOTEDSTRING||LA73_0==STAR||LA73_0==TRUE||(LA73_0 >= BAG_VAL && LA73_0 <= BIN_EXPR)||(LA73_0 >= CASE_COND && LA73_0 <= CASE_EXPR)||LA73_0==CAST_EXPR||LA73_0==EXPR_IN_PAREN||LA73_0==FUNC_EVAL||LA73_0==INVOKER_FUNC_EVAL||(LA73_0 >= MAP_VAL && LA73_0 <= NEG)||LA73_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:33: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER289=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2416); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER289_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER289);


                    adaptor.addChild(root_1, DOUBLENUMBER289_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:48: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2420);
                    expr290=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr290.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:473:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstValidator.rank_clause_return rank_clause() throws RecognitionException {
        AstValidator.rank_clause_return retval = new AstValidator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK291=null;
        AstValidator.rel_return rel292 =null;

        AstValidator.rank_by_statement_return rank_by_statement293 =null;


        CommonTree RANK291_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:473:13: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:473:15: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK291=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2435); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK291_tree = (CommonTree)adaptor.dupNode(RANK291);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK291_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2437);
            rel292=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel292.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:473:27: ( rank_by_statement )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==BY) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:473:29: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2441);
                    rank_by_statement293=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement293.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:476:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstValidator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstValidator.rank_by_statement_return retval = new AstValidator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY294=null;
        CommonTree DENSE296=null;
        AstValidator.rank_by_clause_return rank_by_clause295 =null;


        CommonTree BY294_tree=null;
        CommonTree DENSE296_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:476:19: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:476:21: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY294=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2457); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY294_tree = (CommonTree)adaptor.dupNode(BY294);


            root_1 = (CommonTree)adaptor.becomeRoot(BY294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2459);
            rank_by_clause295=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause295.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:476:42: ( DENSE )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==DENSE) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:476:44: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE296=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE296_tree = (CommonTree)adaptor.dupNode(DENSE296);


                    adaptor.addChild(root_1, DENSE296_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:479:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AstValidator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstValidator.rank_by_clause_return retval = new AstValidator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR297=null;
        CommonTree set298=null;
        AstValidator.rank_col_return rank_col299 =null;


        CommonTree STAR297_tree=null;
        CommonTree set298_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:479:16: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==STAR) ) {
                alt78=1;
            }
            else if ( (LA78_0==CUBE||LA78_0==DOLLARVAR||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==COL_RANGE) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }
            switch (alt78) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:479:18: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR297=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR297_tree = (CommonTree)adaptor.dupNode(STAR297);


                    adaptor.addChild(root_0, STAR297_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:479:23: ( ASC | DESC )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==ASC||LA76_0==DESC) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set298=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set298_tree = (CommonTree)adaptor.dupNode(set298);


                                adaptor.addChild(root_0, set298_tree);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:480:18: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:480:18: ( rank_col )+
                    int cnt77=0;
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==CUBE||LA77_0==DOLLARVAR||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==COL_RANGE) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:480:18: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2507);
                    	    rank_col299=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col299.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:483:1: rank_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.rank_col_return rank_col() throws RecognitionException {
        AstValidator.rank_col_return retval = new AstValidator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set301=null;
        CommonTree set303=null;
        AstValidator.col_range_return col_range300 =null;

        AstValidator.col_ref_return col_ref302 =null;


        CommonTree set301_tree=null;
        CommonTree set303_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:483:10: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:483:12: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2517);
                    col_range300=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range300.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:483:22: ( ASC | DESC )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==ASC||LA79_0==DESC) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set301=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set301_tree = (CommonTree)adaptor.dupNode(set301);


                                adaptor.addChild(root_0, set301_tree);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:484:12: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2539);
                    col_ref302=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref302.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:484:20: ( ASC | DESC )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==ASC||LA80_0==DESC) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set303=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set303_tree = (CommonTree)adaptor.dupNode(set303);


                                adaptor.addChild(root_0, set303_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:487:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstValidator.order_clause_return order_clause() throws RecognitionException {
        AstValidator.order_clause_return retval = new AstValidator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER304=null;
        AstValidator.rel_return rel305 =null;

        AstValidator.order_by_clause_return order_by_clause306 =null;

        AstValidator.func_clause_return func_clause307 =null;


        CommonTree ORDER304_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:487:14: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:487:16: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER304=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2561); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER304_tree = (CommonTree)adaptor.dupNode(ORDER304);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER304_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2563);
            rel305=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel305.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2565);
            order_by_clause306=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause306.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:487:45: ( func_clause )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==FUNC||LA82_0==FUNC_REF) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:487:45: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2567);
                    func_clause307=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause307.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:490:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AstValidator.order_by_clause_return order_by_clause() throws RecognitionException {
        AstValidator.order_by_clause_return retval = new AstValidator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR308=null;
        CommonTree set309=null;
        AstValidator.order_col_return order_col310 =null;


        CommonTree STAR308_tree=null;
        CommonTree set309_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:490:17: ( STAR ( ASC | DESC )? | ( order_col )+ )
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:490:19: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR308=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR308_tree = (CommonTree)adaptor.dupNode(STAR308);


                    adaptor.addChild(root_0, STAR308_tree);
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:490:24: ( ASC | DESC )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC||LA83_0==DESC) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set309=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set309_tree = (CommonTree)adaptor.dupNode(set309);


                                adaptor.addChild(root_0, set309_tree);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:491:19: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:491:19: ( order_col )+
                    int cnt84=0;
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:491:19: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2610);
                    	    order_col310=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col310.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt84 >= 1 ) break loop84;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(84, input);
                                throw eee;
                        }
                        cnt84++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:494:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.order_col_return order_col() throws RecognitionException {
        AstValidator.order_col_return retval = new AstValidator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set312=null;
        CommonTree set314=null;
        AstValidator.col_range_return col_range311 =null;

        AstValidator.col_ref_return col_ref313 =null;


        CommonTree set312_tree=null;
        CommonTree set314_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:494:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==COL_RANGE) ) {
                alt88=1;
            }
            else if ( (LA88_0==CUBE||LA88_0==DOLLARVAR||LA88_0==GROUP||LA88_0==IDENTIFIER) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:494:13: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2620);
                    col_range311=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range311.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:494:23: ( ASC | DESC )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==ASC||LA86_0==DESC) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set312=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set312_tree = (CommonTree)adaptor.dupNode(set312);


                                adaptor.addChild(root_0, set312_tree);
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:495:13: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2643);
                    col_ref313=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref313.getTree());


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:495:21: ( ASC | DESC )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==ASC||LA87_0==DESC) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set314=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set314_tree = (CommonTree)adaptor.dupNode(set314);


                                adaptor.addChild(root_0, set314_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:498:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstValidator.distinct_clause_return distinct_clause() throws RecognitionException {
        AstValidator.distinct_clause_return retval = new AstValidator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT315=null;
        AstValidator.rel_return rel316 =null;

        AstValidator.partition_clause_return partition_clause317 =null;


        CommonTree DISTINCT315_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:498:17: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:498:19: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT315=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT315_tree = (CommonTree)adaptor.dupNode(DISTINCT315);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT315_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2667);
            rel316=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel316.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:498:35: ( partition_clause )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==PARTITION) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:498:35: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2669);
                    partition_clause317=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause317.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:501:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstValidator.partition_clause_return partition_clause() throws RecognitionException {
        AstValidator.partition_clause_return retval = new AstValidator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION318=null;
        AstValidator.func_name_return func_name319 =null;


        CommonTree PARTITION318_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:501:18: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:501:20: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION318=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION318_tree = (CommonTree)adaptor.dupNode(PARTITION318);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION318_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2685);
            func_name319=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name319.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:504:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstValidator.cross_clause_return cross_clause() throws RecognitionException {
        AstValidator.cross_clause_return retval = new AstValidator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS320=null;
        AstValidator.rel_list_return rel_list321 =null;

        AstValidator.partition_clause_return partition_clause322 =null;


        CommonTree CROSS320_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:504:14: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:504:16: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS320=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS320_tree = (CommonTree)adaptor.dupNode(CROSS320);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS320_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2700);
            rel_list321=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list321.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:504:34: ( partition_clause )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==PARTITION) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:504:34: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2702);
                    partition_clause322=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause322.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:507:1: rel_list : ( rel )+ ;
    public final AstValidator.rel_list_return rel_list() throws RecognitionException {
        AstValidator.rel_list_return retval = new AstValidator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel323 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:507:10: ( ( rel )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:507:12: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:507:12: ( rel )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==ARROBA||LA91_0==ASSERT||LA91_0==COGROUP||(LA91_0 >= CROSS && LA91_0 <= CUBE)||LA91_0==DEFINE||LA91_0==DISTINCT||LA91_0==FILTER||LA91_0==FOREACH||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==JOIN||(LA91_0 >= LIMIT && LA91_0 <= LOAD)||LA91_0==MAPREDUCE||LA91_0==ORDER||LA91_0==RANK||LA91_0==SAMPLE||LA91_0==SPLIT||(LA91_0 >= STORE && LA91_0 <= STREAM)||LA91_0==UNION) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:507:12: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2714);
            	    rel323=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel323.getTree());


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


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
        int arity;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:510:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstValidator.join_clause_return join_clause() throws RecognitionException {
        join_clause_stack.push(new join_clause_scope());
        AstValidator.join_clause_return retval = new AstValidator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN324=null;
        AstValidator.join_sub_clause_return join_sub_clause325 =null;

        AstValidator.join_type_return join_type326 =null;

        AstValidator.partition_clause_return partition_clause327 =null;


        CommonTree JOIN324_tree=null;


            ((join_clause_scope)join_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN324=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2736); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN324_tree = (CommonTree)adaptor.dupNode(JOIN324);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN324_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2738);
            join_sub_clause325=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause325.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:28: ( join_type )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==QUOTEDSTRING) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2740);
                    join_type326=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type326.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:39: ( partition_clause )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==PARTITION) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:517:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2743);
                    partition_clause327=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause327.getTree());


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
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:520:1: join_type : QUOTEDSTRING ;
    public final AstValidator.join_type_return join_type() throws RecognitionException {
        AstValidator.join_type_return retval = new AstValidator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING328=null;

        CommonTree QUOTEDSTRING328_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:520:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:520:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING328=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2755); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING328_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING328);


            adaptor.addChild(root_0, QUOTEDSTRING328_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:523:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AstValidator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstValidator.join_sub_clause_return retval = new AstValidator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set330=null;
        CommonTree OUTER331=null;
        AstValidator.join_item_return join_item329 =null;

        AstValidator.join_item_return join_item332 =null;

        AstValidator.join_item_return join_item333 =null;


        CommonTree set330_tree=null;
        CommonTree OUTER331_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==JOIN_ITEM) ) {
                int LA96_1 = input.LA(2);

                if ( (synpred174_AstValidator()) ) {
                    alt96=1;
                }
                else if ( (true) ) {
                    alt96=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }
            switch (alt96) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2765);
                    join_item329=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item329.getTree());


                    _last = (CommonTree)input.LT(1);
                    set330=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set330_tree = (CommonTree)adaptor.dupNode(set330);


                        adaptor.addChild(root_0, set330_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:38: ( OUTER )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==OUTER) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:38: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER331=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2781); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER331_tree = (CommonTree)adaptor.dupNode(OUTER331);


                            adaptor.addChild(root_0, OUTER331_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2784);
                    join_item332=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item332.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:525:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:525:4: ( join_item )+
                    int cnt95=0;
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==JOIN_ITEM) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:525:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2789);
                    	    join_item333=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item333.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt95 >= 1 ) break loop95;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(95, input);
                                throw eee;
                        }
                        cnt95++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:528:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstValidator.join_item_return join_item() throws RecognitionException {
        AstValidator.join_item_return retval = new AstValidator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM334=null;
        AstValidator.rel_return rel335 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause336 =null;


        CommonTree JOIN_ITEM334_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:529:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:529:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM334=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM334_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM334);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM334_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2804);
            rel335=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel335.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2806);
            join_group_by_clause336=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause336.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if( ((join_clause_scope)join_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((join_clause_scope)join_clause_stack.peek()).arity = (join_group_by_clause336!=null?join_group_by_clause336.exprCount:0);
                   } else if( (join_group_by_clause336!=null?join_group_by_clause336.exprCount:0) != ((join_clause_scope)join_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the join columns do not match." );
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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public int exprCount;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:541:1: join_group_by_clause returns [int exprCount] : ^( BY ( join_group_by_expr )+ ) ;
    public final AstValidator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstValidator.join_group_by_clause_return retval = new AstValidator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY337=null;
        AstValidator.join_group_by_expr_return join_group_by_expr338 =null;


        CommonTree BY337_tree=null;


            retval.exprCount = 0;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:545:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:545:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY337=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2833); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY337_tree = (CommonTree)adaptor.dupNode(BY337);


            root_1 = (CommonTree)adaptor.becomeRoot(BY337_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:545:10: ( join_group_by_expr )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==BIGDECIMALNUMBER||LA97_0==BIGINTEGERNUMBER||LA97_0==CUBE||LA97_0==DIV||LA97_0==DOLLARVAR||LA97_0==DOUBLENUMBER||LA97_0==FALSE||LA97_0==FLOATNUMBER||LA97_0==GROUP||LA97_0==IDENTIFIER||LA97_0==INTEGER||LA97_0==LONGINTEGER||LA97_0==MINUS||LA97_0==NULL||LA97_0==PERCENT||LA97_0==PLUS||LA97_0==QUOTEDSTRING||LA97_0==STAR||LA97_0==TRUE||(LA97_0 >= BAG_VAL && LA97_0 <= BIN_EXPR)||(LA97_0 >= CASE_COND && LA97_0 <= CASE_EXPR)||(LA97_0 >= CAST_EXPR && LA97_0 <= EXPR_IN_PAREN)||LA97_0==FUNC_EVAL||LA97_0==INVOKER_FUNC_EVAL||(LA97_0 >= MAP_VAL && LA97_0 <= NEG)||LA97_0==TUPLE_VAL) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:545:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2837);
            	    join_group_by_expr338=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr338.getTree());


            	    if ( state.backtracking==0 ) { retval.exprCount++; }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:548:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstValidator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstValidator.join_group_by_expr_return retval = new AstValidator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR341=null;
        AstValidator.col_range_return col_range339 =null;

        AstValidator.expr_return expr340 =null;


        CommonTree STAR341_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:548:20: ( col_range | expr | STAR )
            int alt98=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt98=1;
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
                alt98=2;
                }
                break;
            case STAR:
                {
                int LA98_3 = input.LA(2);

                if ( (LA98_3==DOWN) ) {
                    alt98=2;
                }
                else if ( (LA98_3==EOF||LA98_3==UP||LA98_3==BIGDECIMALNUMBER||LA98_3==BIGINTEGERNUMBER||LA98_3==CUBE||LA98_3==DIV||LA98_3==DOLLARVAR||LA98_3==DOUBLENUMBER||LA98_3==FALSE||LA98_3==FLOATNUMBER||LA98_3==GROUP||LA98_3==IDENTIFIER||LA98_3==INTEGER||LA98_3==LONGINTEGER||LA98_3==MINUS||LA98_3==NULL||LA98_3==PERCENT||LA98_3==PLUS||LA98_3==QUOTEDSTRING||LA98_3==STAR||LA98_3==TRUE||(LA98_3 >= BAG_VAL && LA98_3 <= BIN_EXPR)||(LA98_3 >= CASE_COND && LA98_3 <= CASE_EXPR)||(LA98_3 >= CAST_EXPR && LA98_3 <= EXPR_IN_PAREN)||LA98_3==FUNC_EVAL||LA98_3==INVOKER_FUNC_EVAL||(LA98_3 >= MAP_VAL && LA98_3 <= NEG)||LA98_3==TUPLE_VAL) ) {
                    alt98=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 3, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:548:22: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2853);
                    col_range339=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range339.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:548:35: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2858);
                    expr340=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr340.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:548:42: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR341=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2862); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR341_tree = (CommonTree)adaptor.dupNode(STAR341);


                    adaptor.addChild(root_0, STAR341_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:551:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstValidator.union_clause_return union_clause() throws RecognitionException {
        AstValidator.union_clause_return retval = new AstValidator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION342=null;
        CommonTree ONSCHEMA343=null;
        AstValidator.rel_list_return rel_list344 =null;


        CommonTree UNION342_tree=null;
        CommonTree ONSCHEMA343_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:551:14: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:551:16: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION342=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION342_tree = (CommonTree)adaptor.dupNode(UNION342);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION342_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:551:25: ( ONSCHEMA )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==ONSCHEMA) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:551:25: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA343=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA343_tree = (CommonTree)adaptor.dupNode(ONSCHEMA343);


                    adaptor.addChild(root_1, ONSCHEMA343_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2878);
            rel_list344=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list344.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:554:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstValidator.foreach_clause_return foreach_clause() throws RecognitionException {
        AstValidator.foreach_clause_return retval = new AstValidator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH345=null;
        AstValidator.rel_return rel346 =null;

        AstValidator.foreach_plan_return foreach_plan347 =null;


        CommonTree FOREACH345_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:554:16: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:554:18: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH345=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH345_tree = (CommonTree)adaptor.dupNode(FOREACH345);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH345_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2893);
            rel346=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel346.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2895);
            foreach_plan347=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan347.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:557:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstValidator.foreach_plan_return foreach_plan() throws RecognitionException {
        AstValidator.foreach_plan_return retval = new AstValidator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE348=null;
        CommonTree FOREACH_PLAN_COMPLEX350=null;
        AstValidator.generate_clause_return generate_clause349 =null;

        AstValidator.nested_blk_return nested_blk351 =null;


        CommonTree FOREACH_PLAN_SIMPLE348_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX350_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:557:14: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FOREACH_PLAN_SIMPLE) ) {
                alt100=1;
            }
            else if ( (LA100_0==FOREACH_PLAN_COMPLEX) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:557:16: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE348=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE348_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE348);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE348_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2910);
                    generate_clause349=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause349.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:558:16: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX350=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2931); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX350_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX350);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX350_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2933);
                    nested_blk351=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk351.getTree());


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


    protected static class nested_blk_scope {
        Set<String> ids;
    }
    protected Stack nested_blk_stack = new Stack();


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:561:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstValidator.nested_blk_return nested_blk() throws RecognitionException {
        nested_blk_stack.push(new nested_blk_scope());
        AstValidator.nested_blk_return retval = new AstValidator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_command_return nested_command352 =null;

        AstValidator.generate_clause_return generate_clause353 =null;



         ((nested_blk_scope)nested_blk_stack.peek()).ids = new HashSet<String>(); 
        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:564:2: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:564:4: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:564:4: ( nested_command )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( ((LA101_0 >= NESTED_CMD && LA101_0 <= NESTED_CMD_ASSI)) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:564:4: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2953);
            	    nested_command352=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command352.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2956);
            generate_clause353=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause353.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_blk_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:567:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AstValidator.generate_clause_return generate_clause() throws RecognitionException {
        AstValidator.generate_clause_return retval = new AstValidator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE354=null;
        AstValidator.flatten_generated_item_return flatten_generated_item355 =null;


        CommonTree GENERATE354_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:567:17: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:567:19: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE354=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2967); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE354_tree = (CommonTree)adaptor.dupNode(GENERATE354);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE354_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:567:31: ( flatten_generated_item )+
            int cnt102=0;
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==BIGDECIMALNUMBER||LA102_0==BIGINTEGERNUMBER||LA102_0==CUBE||LA102_0==DIV||LA102_0==DOLLARVAR||LA102_0==DOUBLENUMBER||LA102_0==FALSE||LA102_0==FLATTEN||LA102_0==FLOATNUMBER||LA102_0==GROUP||LA102_0==IDENTIFIER||LA102_0==INTEGER||LA102_0==LONGINTEGER||LA102_0==MINUS||LA102_0==NULL||LA102_0==PERCENT||LA102_0==PLUS||LA102_0==QUOTEDSTRING||LA102_0==STAR||LA102_0==TRUE||(LA102_0 >= BAG_VAL && LA102_0 <= BIN_EXPR)||(LA102_0 >= CASE_COND && LA102_0 <= CASE_EXPR)||(LA102_0 >= CAST_EXPR && LA102_0 <= EXPR_IN_PAREN)||LA102_0==FUNC_EVAL||LA102_0==INVOKER_FUNC_EVAL||(LA102_0 >= MAP_VAL && LA102_0 <= NEG)||LA102_0==TUPLE_VAL) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:567:31: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2969);
            	    flatten_generated_item355=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item355.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:570:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstValidator.nested_command_return nested_command() throws RecognitionException {
        AstValidator.nested_command_return retval = new AstValidator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD356=null;
        CommonTree IDENTIFIER357=null;
        CommonTree NESTED_CMD_ASSI359=null;
        CommonTree IDENTIFIER360=null;
        AstValidator.nested_op_return nested_op358 =null;

        AstValidator.expr_return expr361 =null;


        CommonTree NESTED_CMD356_tree=null;
        CommonTree IDENTIFIER357_tree=null;
        CommonTree NESTED_CMD_ASSI359_tree=null;
        CommonTree IDENTIFIER360_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:571:2: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==NESTED_CMD) ) {
                alt103=1;
            }
            else if ( (LA103_0==NESTED_CMD_ASSI) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:571:4: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD356=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD356_tree = (CommonTree)adaptor.dupNode(NESTED_CMD356);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD356_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER357=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2986); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER357_tree = (CommonTree)adaptor.dupNode(IDENTIFIER357);


                    adaptor.addChild(root_1, IDENTIFIER357_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2988);
                    nested_op358=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op358.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER357!=null?IDENTIFIER357.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:575:4: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI359=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI359_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI359);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI359_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER360=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER360_tree = (CommonTree)adaptor.dupNode(IDENTIFIER360);


                    adaptor.addChild(root_1, IDENTIFIER360_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3006);
                    expr361=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr361.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER360!=null?IDENTIFIER360.getText():null) );
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:581:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstValidator.nested_op_return nested_op() throws RecognitionException {
        AstValidator.nested_op_return retval = new AstValidator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_proj_return nested_proj362 =null;

        AstValidator.nested_filter_return nested_filter363 =null;

        AstValidator.nested_sort_return nested_sort364 =null;

        AstValidator.nested_distinct_return nested_distinct365 =null;

        AstValidator.nested_limit_return nested_limit366 =null;

        AstValidator.nested_cross_return nested_cross367 =null;

        AstValidator.nested_foreach_return nested_foreach368 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:581:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt104=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt104=1;
                }
                break;
            case FILTER:
                {
                alt104=2;
                }
                break;
            case ORDER:
                {
                alt104=3;
                }
                break;
            case DISTINCT:
                {
                alt104=4;
                }
                break;
            case LIMIT:
                {
                alt104=5;
                }
                break;
            case CROSS:
                {
                alt104=6;
                }
                break;
            case FOREACH:
                {
                alt104=7;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:581:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3022);
                    nested_proj362=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj362.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:582:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3036);
                    nested_filter363=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter363.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:583:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3050);
                    nested_sort364=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort364.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:584:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op3064);
                    nested_distinct365=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct365.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:585:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op3078);
                    nested_limit366=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit366.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:586:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3092);
                    nested_cross367=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross367.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:587:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3106);
                    nested_foreach368=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach368.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:590:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AstValidator.nested_proj_return nested_proj() throws RecognitionException {
        AstValidator.nested_proj_return retval = new AstValidator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ369=null;
        AstValidator.col_ref_return col_ref370 =null;

        AstValidator.col_ref_return col_ref371 =null;


        CommonTree NESTED_PROJ369_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:590:13: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:590:15: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ369=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3117); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ369_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ369);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ369_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3119);
            col_ref370=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref370.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:590:38: ( col_ref )+
            int cnt105=0;
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==CUBE||LA105_0==DOLLARVAR||LA105_0==GROUP||LA105_0==IDENTIFIER) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:590:38: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3121);
            	    col_ref371=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref371.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt105 >= 1 ) break loop105;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(105, input);
                        throw eee;
                }
                cnt105++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:593:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstValidator.nested_filter_return nested_filter() throws RecognitionException {
        AstValidator.nested_filter_return retval = new AstValidator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER372=null;
        AstValidator.nested_op_input_return nested_op_input373 =null;

        AstValidator.cond_return cond374 =null;


        CommonTree FILTER372_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:594:2: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:594:4: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER372=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3136); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER372_tree = (CommonTree)adaptor.dupNode(FILTER372);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER372_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3138);
            nested_op_input373=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input373.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3140);
            cond374=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond374.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:597:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstValidator.nested_sort_return nested_sort() throws RecognitionException {
        AstValidator.nested_sort_return retval = new AstValidator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER375=null;
        AstValidator.nested_op_input_return nested_op_input376 =null;

        AstValidator.order_by_clause_return order_by_clause377 =null;

        AstValidator.func_clause_return func_clause378 =null;


        CommonTree ORDER375_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:597:13: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:597:15: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER375=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3153); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER375_tree = (CommonTree)adaptor.dupNode(ORDER375);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER375_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3155);
            nested_op_input376=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input376.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3158);
            order_by_clause377=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause377.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:597:57: ( func_clause )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FUNC||LA106_0==FUNC_REF) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:597:57: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3160);
                    func_clause378=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause378.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:600:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstValidator.nested_distinct_return nested_distinct() throws RecognitionException {
        AstValidator.nested_distinct_return retval = new AstValidator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT379=null;
        AstValidator.nested_op_input_return nested_op_input380 =null;


        CommonTree DISTINCT379_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:600:17: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:600:19: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT379=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT379_tree = (CommonTree)adaptor.dupNode(DISTINCT379);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT379_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3176);
            nested_op_input380=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input380.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstValidator.nested_limit_return nested_limit() throws RecognitionException {
        AstValidator.nested_limit_return retval = new AstValidator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT381=null;
        CommonTree INTEGER383=null;
        AstValidator.nested_op_input_return nested_op_input382 =null;

        AstValidator.expr_return expr384 =null;


        CommonTree LIMIT381_tree=null;
        CommonTree INTEGER383_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:14: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:16: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT381=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3189); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT381_tree = (CommonTree)adaptor.dupNode(LIMIT381);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT381_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3191);
            nested_op_input382=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input382.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:41: ( INTEGER | expr )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==INTEGER) ) {
                int LA107_1 = input.LA(2);

                if ( (synpred192_AstValidator()) ) {
                    alt107=1;
                }
                else if ( (true) ) {
                    alt107=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA107_0==BIGDECIMALNUMBER||LA107_0==BIGINTEGERNUMBER||LA107_0==CUBE||LA107_0==DIV||LA107_0==DOLLARVAR||LA107_0==DOUBLENUMBER||LA107_0==FALSE||LA107_0==FLOATNUMBER||LA107_0==GROUP||LA107_0==IDENTIFIER||LA107_0==LONGINTEGER||LA107_0==MINUS||LA107_0==NULL||LA107_0==PERCENT||LA107_0==PLUS||LA107_0==QUOTEDSTRING||LA107_0==STAR||LA107_0==TRUE||(LA107_0 >= BAG_VAL && LA107_0 <= BIN_EXPR)||(LA107_0 >= CASE_COND && LA107_0 <= CASE_EXPR)||LA107_0==CAST_EXPR||LA107_0==EXPR_IN_PAREN||LA107_0==FUNC_EVAL||LA107_0==INVOKER_FUNC_EVAL||(LA107_0 >= MAP_VAL && LA107_0 <= NEG)||LA107_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:43: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER383=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3195); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER383_tree = (CommonTree)adaptor.dupNode(INTEGER383);


                    adaptor.addChild(root_1, INTEGER383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:53: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3199);
                    expr384=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr384.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:606:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstValidator.nested_cross_return nested_cross() throws RecognitionException {
        AstValidator.nested_cross_return retval = new AstValidator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS385=null;
        AstValidator.nested_op_input_list_return nested_op_input_list386 =null;


        CommonTree CROSS385_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:606:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:606:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS385=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS385_tree = (CommonTree)adaptor.dupNode(CROSS385);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS385_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3216);
            nested_op_input_list386=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list386.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:609:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstValidator.nested_foreach_return nested_foreach() throws RecognitionException {
        AstValidator.nested_foreach_return retval = new AstValidator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH387=null;
        AstValidator.nested_op_input_return nested_op_input388 =null;

        AstValidator.generate_clause_return generate_clause389 =null;


        CommonTree FOREACH387_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:609:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:609:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH387=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH387_tree = (CommonTree)adaptor.dupNode(FOREACH387);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH387_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3231);
            nested_op_input388=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input388.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3233);
            generate_clause389=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause389.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:612:1: nested_op_input : ( col_ref | nested_proj );
    public final AstValidator.nested_op_input_return nested_op_input() throws RecognitionException {
        AstValidator.nested_op_input_return retval = new AstValidator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_ref_return col_ref390 =null;

        AstValidator.nested_proj_return nested_proj391 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:612:17: ( col_ref | nested_proj )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==CUBE||LA108_0==DOLLARVAR||LA108_0==GROUP||LA108_0==IDENTIFIER) ) {
                alt108=1;
            }
            else if ( (LA108_0==NESTED_PROJ) ) {
                alt108=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:612:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3244);
                    col_ref390=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref390.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:612:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3248);
                    nested_proj391=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj391.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:615:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AstValidator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstValidator.nested_op_input_list_return retval = new AstValidator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_op_input_return nested_op_input392 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:615:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:615:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:615:24: ( nested_op_input )+
            int cnt109=0;
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==CUBE||LA109_0==DOLLARVAR||LA109_0==GROUP||LA109_0==IDENTIFIER||LA109_0==NESTED_PROJ) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:615:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3257);
            	    nested_op_input392=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input392.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt109 >= 1 ) break loop109;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(109, input);
                        throw eee;
                }
                cnt109++;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:618:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstValidator.stream_clause_return stream_clause() throws RecognitionException {
        AstValidator.stream_clause_return retval = new AstValidator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM393=null;
        CommonTree set395=null;
        AstValidator.rel_return rel394 =null;

        AstValidator.as_clause_return as_clause396 =null;


        CommonTree STREAM393_tree=null;
        CommonTree set395_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:618:15: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:618:17: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM393=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM393_tree = (CommonTree)adaptor.dupNode(STREAM393);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM393_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3271);
            rel394=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel394.getTree());


            _last = (CommonTree)input.LT(1);
            set395=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set395_tree = (CommonTree)adaptor.dupNode(set395);


                adaptor.addChild(root_1, set395_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:618:60: ( as_clause )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==AS) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:618:60: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3283);
                    as_clause396=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause396.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstValidator.mr_clause_return mr_clause() throws RecognitionException {
        AstValidator.mr_clause_return retval = new AstValidator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE397=null;
        CommonTree QUOTEDSTRING398=null;
        CommonTree EXECCOMMAND402=null;
        AstValidator.path_list_return path_list399 =null;

        AstValidator.store_clause_return store_clause400 =null;

        AstValidator.load_clause_return load_clause401 =null;


        CommonTree MAPREDUCE397_tree=null;
        CommonTree QUOTEDSTRING398_tree=null;
        CommonTree EXECCOMMAND402_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:11: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:13: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE397=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3297); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE397_tree = (CommonTree)adaptor.dupNode(MAPREDUCE397);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE397_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING398=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING398_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING398);


            adaptor.addChild(root_1, QUOTEDSTRING398_tree);
            }


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:39: ( path_list )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==QUOTEDSTRING) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:39: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3301);
                    path_list399=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list399.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3304);
            store_clause400=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause400.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3306);
            load_clause401=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause401.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:75: ( EXECCOMMAND )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==EXECCOMMAND) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:621:75: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND402=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND402_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND402);


                    adaptor.addChild(root_1, EXECCOMMAND402_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AstValidator.split_clause_return split_clause() throws RecognitionException {
        AstValidator.split_clause_return retval = new AstValidator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT403=null;
        AstValidator.rel_return rel404 =null;

        AstValidator.split_branch_return split_branch405 =null;

        AstValidator.split_otherwise_return split_otherwise406 =null;


        CommonTree SPLIT403_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:14: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:16: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT403=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3322); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT403_tree = (CommonTree)adaptor.dupNode(SPLIT403);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT403_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3324);
            rel404=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel404.getTree());


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:29: ( split_branch )+
            int cnt113=0;
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==SPLIT_BRANCH) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:29: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3326);
            	    split_branch405=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch405.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt113 >= 1 ) break loop113;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(113, input);
                        throw eee;
                }
                cnt113++;
            } while (true);


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:43: ( split_otherwise )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==OTHERWISE) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:624:43: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3329);
                    split_otherwise406=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise406.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:627:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstValidator.split_branch_return split_branch() throws RecognitionException {
        AstValidator.split_branch_return retval = new AstValidator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH407=null;
        AstValidator.alias_return alias408 =null;

        AstValidator.cond_return cond409 =null;


        CommonTree SPLIT_BRANCH407_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:628:2: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:628:4: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH407=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3344); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH407_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH407);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH407_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3346);
            alias408=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias408.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3348);
            cond409=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond409.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias408!=null?alias408.name:null) );
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:634:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstValidator.split_otherwise_return split_otherwise() throws RecognitionException {
        AstValidator.split_otherwise_return retval = new AstValidator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE410=null;
        AstValidator.alias_return alias411 =null;


        CommonTree OTHERWISE410_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:634:17: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:634:19: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE410=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3366); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE410_tree = (CommonTree)adaptor.dupNode(OTHERWISE410);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE410_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3368);
            alias411=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias411.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias411!=null?alias411.name:null) );
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:640:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstValidator.col_ref_return col_ref() throws RecognitionException {
        AstValidator.col_ref_return retval = new AstValidator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_col_ref_return alias_col_ref412 =null;

        AstValidator.dollar_col_ref_return dollar_col_ref413 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:640:9: ( alias_col_ref | dollar_col_ref )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==CUBE||LA115_0==GROUP||LA115_0==IDENTIFIER) ) {
                alt115=1;
            }
            else if ( (LA115_0==DOLLARVAR) ) {
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:640:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3384);
                    alias_col_ref412=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref412.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:640:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3388);
                    dollar_col_ref413=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref413.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:643:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstValidator.alias_col_ref_return retval = new AstValidator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set414=null;

        CommonTree set414_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:643:15: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set414=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set414_tree = (CommonTree)adaptor.dupNode(set414);


                adaptor.addChild(root_0, set414_tree);
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:646:1: dollar_col_ref : DOLLARVAR ;
    public final AstValidator.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstValidator.dollar_col_ref_return retval = new AstValidator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR415=null;

        CommonTree DOLLARVAR415_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:646:16: ( DOLLARVAR )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:646:18: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR415=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR415_tree = (CommonTree)adaptor.dupNode(DOLLARVAR415);


            adaptor.addChild(root_0, DOLLARVAR415_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:649:1: const_expr : literal ;
    public final AstValidator.const_expr_return const_expr() throws RecognitionException {
        AstValidator.const_expr_return retval = new AstValidator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.literal_return literal416 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:649:12: ( literal )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:649:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3423);
            literal416=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal416.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:1: literal : ( scalar | map | bag | tuple );
    public final AstValidator.literal_return literal() throws RecognitionException {
        AstValidator.literal_return retval = new AstValidator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.scalar_return scalar417 =null;

        AstValidator.map_return map418 =null;

        AstValidator.bag_return bag419 =null;

        AstValidator.tuple_return tuple420 =null;



        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:9: ( scalar | map | bag | tuple )
            int alt116=4;
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
                alt116=1;
                }
                break;
            case MAP_VAL:
                {
                alt116=2;
                }
                break;
            case BAG_VAL:
                {
                alt116=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt116=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3432);
                    scalar417=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar417.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3436);
                    map418=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map418.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3440);
                    bag419=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag419.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:652:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3444);
                    tuple420=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple420.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstValidator.scalar_return scalar() throws RecognitionException {
        AstValidator.scalar_return retval = new AstValidator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING422=null;
        CommonTree NULL423=null;
        CommonTree TRUE424=null;
        CommonTree FALSE425=null;
        AstValidator.num_scalar_return num_scalar421 =null;


        CommonTree QUOTEDSTRING422_tree=null;
        CommonTree NULL423_tree=null;
        CommonTree TRUE424_tree=null;
        CommonTree FALSE425_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt117=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt117=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt117=2;
                }
                break;
            case NULL:
                {
                alt117=3;
                }
                break;
            case TRUE:
                {
                alt117=4;
                }
                break;
            case FALSE:
                {
                alt117=5;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3453);
                    num_scalar421=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar421.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING422=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING422_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING422);


                    adaptor.addChild(root_0, QUOTEDSTRING422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL423=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3461); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL423_tree = (CommonTree)adaptor.dupNode(NULL423);


                    adaptor.addChild(root_0, NULL423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE424=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE424_tree = (CommonTree)adaptor.dupNode(TRUE424);


                    adaptor.addChild(root_0, TRUE424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:655:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE425=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE425_tree = (CommonTree)adaptor.dupNode(FALSE425);


                    adaptor.addChild(root_0, FALSE425_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:658:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstValidator.num_scalar_return num_scalar() throws RecognitionException {
        AstValidator.num_scalar_return retval = new AstValidator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS426=null;
        CommonTree set427=null;

        CommonTree MINUS426_tree=null;
        CommonTree set427_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:658:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:658:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:658:14: ( MINUS )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==MINUS) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:658:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS426=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS426_tree = (CommonTree)adaptor.dupNode(MINUS426);


                    adaptor.addChild(root_0, MINUS426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set427=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set427_tree = (CommonTree)adaptor.dupNode(set427);


                adaptor.addChild(root_0, set427_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:661:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AstValidator.map_return map() throws RecognitionException {
        AstValidator.map_return retval = new AstValidator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL428=null;
        AstValidator.keyvalue_return keyvalue429 =null;


        CommonTree MAP_VAL428_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:661:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:661:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL428=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3516); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL428_tree = (CommonTree)adaptor.dupNode(MAP_VAL428);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL428_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:661:18: ( keyvalue )*
                loop119:
                do {
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==KEY_VAL_PAIR) ) {
                        alt119=1;
                    }


                    switch (alt119) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:661:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3518);
                	    keyvalue429=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue429.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop119;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:664:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstValidator.keyvalue_return keyvalue() throws RecognitionException {
        AstValidator.keyvalue_return retval = new AstValidator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR430=null;
        AstValidator.map_key_return map_key431 =null;

        AstValidator.const_expr_return const_expr432 =null;


        CommonTree KEY_VAL_PAIR430_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:664:10: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:664:12: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR430=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3532); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR430_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR430);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR430_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3534);
            map_key431=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key431.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3536);
            const_expr432=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr432.getTree());


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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:667:1: map_key : QUOTEDSTRING ;
    public final AstValidator.map_key_return map_key() throws RecognitionException {
        AstValidator.map_key_return retval = new AstValidator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING433=null;

        CommonTree QUOTEDSTRING433_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:667:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:667:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING433=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING433_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING433);


            adaptor.addChild(root_0, QUOTEDSTRING433_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:670:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AstValidator.bag_return bag() throws RecognitionException {
        AstValidator.bag_return retval = new AstValidator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL434=null;
        AstValidator.tuple_return tuple435 =null;


        CommonTree BAG_VAL434_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:670:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:670:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL434=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3558); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL434_tree = (CommonTree)adaptor.dupNode(BAG_VAL434);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL434_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:670:18: ( tuple )*
                loop120:
                do {
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==TUPLE_VAL) ) {
                        alt120=1;
                    }


                    switch (alt120) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:670:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3560);
                	    tuple435=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple435.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop120;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:673:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AstValidator.tuple_return tuple() throws RecognitionException {
        AstValidator.tuple_return retval = new AstValidator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL436=null;
        AstValidator.literal_return literal437 =null;


        CommonTree TUPLE_VAL436_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:673:7: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:673:9: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL436=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL436_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL436);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL436_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:673:22: ( literal )*
                loop121:
                do {
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==BIGDECIMALNUMBER||LA121_0==BIGINTEGERNUMBER||LA121_0==DOUBLENUMBER||LA121_0==FALSE||LA121_0==FLOATNUMBER||LA121_0==INTEGER||LA121_0==LONGINTEGER||LA121_0==MINUS||LA121_0==NULL||LA121_0==QUOTEDSTRING||LA121_0==TRUE||LA121_0==BAG_VAL||LA121_0==MAP_VAL||LA121_0==TUPLE_VAL) ) {
                        alt121=1;
                    }


                    switch (alt121) {
                	case 1 :
                	    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:673:22: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3576);
                	    literal437=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal437.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop121;
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:677:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AstValidator.eid_return eid() throws RecognitionException {
        AstValidator.eid_return retval = new AstValidator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT439=null;
        CommonTree RETURNS440=null;
        CommonTree DEFINE441=null;
        CommonTree LOAD442=null;
        CommonTree FILTER443=null;
        CommonTree FOREACH444=null;
        CommonTree CUBE445=null;
        CommonTree ROLLUP446=null;
        CommonTree PIVOT447=null;
        CommonTree CHUNKSIZE448=null;
        CommonTree RATE449=null;
        CommonTree MATCHES450=null;
        CommonTree ORDER451=null;
        CommonTree RANK452=null;
        CommonTree DISTINCT453=null;
        CommonTree COGROUP454=null;
        CommonTree JOIN455=null;
        CommonTree CROSS456=null;
        CommonTree UNION457=null;
        CommonTree SPLIT458=null;
        CommonTree INTO459=null;
        CommonTree IF460=null;
        CommonTree ALL461=null;
        CommonTree AS462=null;
        CommonTree BY463=null;
        CommonTree USING464=null;
        CommonTree INNER465=null;
        CommonTree OUTER466=null;
        CommonTree PARALLEL467=null;
        CommonTree PARTITION468=null;
        CommonTree GROUP469=null;
        CommonTree AND470=null;
        CommonTree OR471=null;
        CommonTree NOT472=null;
        CommonTree GENERATE473=null;
        CommonTree FLATTEN474=null;
        CommonTree EVAL475=null;
        CommonTree ASC476=null;
        CommonTree DESC477=null;
        CommonTree BOOLEAN478=null;
        CommonTree INT479=null;
        CommonTree LONG480=null;
        CommonTree FLOAT481=null;
        CommonTree DOUBLE482=null;
        CommonTree BIGINTEGER483=null;
        CommonTree BIGDECIMAL484=null;
        CommonTree DATETIME485=null;
        CommonTree CHARARRAY486=null;
        CommonTree BYTEARRAY487=null;
        CommonTree BAG488=null;
        CommonTree TUPLE489=null;
        CommonTree MAP490=null;
        CommonTree IS491=null;
        CommonTree NULL492=null;
        CommonTree TRUE493=null;
        CommonTree FALSE494=null;
        CommonTree STREAM495=null;
        CommonTree THROUGH496=null;
        CommonTree STORE497=null;
        CommonTree MAPREDUCE498=null;
        CommonTree SHIP499=null;
        CommonTree CACHE500=null;
        CommonTree INPUT501=null;
        CommonTree OUTPUT502=null;
        CommonTree STDERROR503=null;
        CommonTree STDIN504=null;
        CommonTree STDOUT505=null;
        CommonTree LIMIT506=null;
        CommonTree SAMPLE507=null;
        CommonTree LEFT508=null;
        CommonTree RIGHT509=null;
        CommonTree FULL510=null;
        CommonTree IDENTIFIER511=null;
        CommonTree TOBAG512=null;
        CommonTree TOMAP513=null;
        CommonTree TOTUPLE514=null;
        CommonTree ASSERT515=null;
        AstValidator.rel_str_op_return rel_str_op438 =null;


        CommonTree IMPORT439_tree=null;
        CommonTree RETURNS440_tree=null;
        CommonTree DEFINE441_tree=null;
        CommonTree LOAD442_tree=null;
        CommonTree FILTER443_tree=null;
        CommonTree FOREACH444_tree=null;
        CommonTree CUBE445_tree=null;
        CommonTree ROLLUP446_tree=null;
        CommonTree PIVOT447_tree=null;
        CommonTree CHUNKSIZE448_tree=null;
        CommonTree RATE449_tree=null;
        CommonTree MATCHES450_tree=null;
        CommonTree ORDER451_tree=null;
        CommonTree RANK452_tree=null;
        CommonTree DISTINCT453_tree=null;
        CommonTree COGROUP454_tree=null;
        CommonTree JOIN455_tree=null;
        CommonTree CROSS456_tree=null;
        CommonTree UNION457_tree=null;
        CommonTree SPLIT458_tree=null;
        CommonTree INTO459_tree=null;
        CommonTree IF460_tree=null;
        CommonTree ALL461_tree=null;
        CommonTree AS462_tree=null;
        CommonTree BY463_tree=null;
        CommonTree USING464_tree=null;
        CommonTree INNER465_tree=null;
        CommonTree OUTER466_tree=null;
        CommonTree PARALLEL467_tree=null;
        CommonTree PARTITION468_tree=null;
        CommonTree GROUP469_tree=null;
        CommonTree AND470_tree=null;
        CommonTree OR471_tree=null;
        CommonTree NOT472_tree=null;
        CommonTree GENERATE473_tree=null;
        CommonTree FLATTEN474_tree=null;
        CommonTree EVAL475_tree=null;
        CommonTree ASC476_tree=null;
        CommonTree DESC477_tree=null;
        CommonTree BOOLEAN478_tree=null;
        CommonTree INT479_tree=null;
        CommonTree LONG480_tree=null;
        CommonTree FLOAT481_tree=null;
        CommonTree DOUBLE482_tree=null;
        CommonTree BIGINTEGER483_tree=null;
        CommonTree BIGDECIMAL484_tree=null;
        CommonTree DATETIME485_tree=null;
        CommonTree CHARARRAY486_tree=null;
        CommonTree BYTEARRAY487_tree=null;
        CommonTree BAG488_tree=null;
        CommonTree TUPLE489_tree=null;
        CommonTree MAP490_tree=null;
        CommonTree IS491_tree=null;
        CommonTree NULL492_tree=null;
        CommonTree TRUE493_tree=null;
        CommonTree FALSE494_tree=null;
        CommonTree STREAM495_tree=null;
        CommonTree THROUGH496_tree=null;
        CommonTree STORE497_tree=null;
        CommonTree MAPREDUCE498_tree=null;
        CommonTree SHIP499_tree=null;
        CommonTree CACHE500_tree=null;
        CommonTree INPUT501_tree=null;
        CommonTree OUTPUT502_tree=null;
        CommonTree STDERROR503_tree=null;
        CommonTree STDIN504_tree=null;
        CommonTree STDOUT505_tree=null;
        CommonTree LIMIT506_tree=null;
        CommonTree SAMPLE507_tree=null;
        CommonTree LEFT508_tree=null;
        CommonTree RIGHT509_tree=null;
        CommonTree FULL510_tree=null;
        CommonTree IDENTIFIER511_tree=null;
        CommonTree TOBAG512_tree=null;
        CommonTree TOMAP513_tree=null;
        CommonTree TOTUPLE514_tree=null;
        CommonTree ASSERT515_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:677:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | CHUNKSIZE | RATE | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt122=78;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt122=1;
                }
                break;
            case IMPORT:
                {
                alt122=2;
                }
                break;
            case RETURNS:
                {
                alt122=3;
                }
                break;
            case DEFINE:
                {
                alt122=4;
                }
                break;
            case LOAD:
                {
                alt122=5;
                }
                break;
            case FILTER:
                {
                alt122=6;
                }
                break;
            case FOREACH:
                {
                alt122=7;
                }
                break;
            case CUBE:
                {
                alt122=8;
                }
                break;
            case ROLLUP:
                {
                alt122=9;
                }
                break;
            case PIVOT:
                {
                alt122=10;
                }
                break;
            case CHUNKSIZE:
                {
                alt122=11;
                }
                break;
            case RATE:
                {
                alt122=12;
                }
                break;
            case MATCHES:
                {
                alt122=13;
                }
                break;
            case ORDER:
                {
                alt122=14;
                }
                break;
            case RANK:
                {
                alt122=15;
                }
                break;
            case DISTINCT:
                {
                alt122=16;
                }
                break;
            case COGROUP:
                {
                alt122=17;
                }
                break;
            case JOIN:
                {
                alt122=18;
                }
                break;
            case CROSS:
                {
                alt122=19;
                }
                break;
            case UNION:
                {
                alt122=20;
                }
                break;
            case SPLIT:
                {
                alt122=21;
                }
                break;
            case INTO:
                {
                alt122=22;
                }
                break;
            case IF:
                {
                alt122=23;
                }
                break;
            case ALL:
                {
                alt122=24;
                }
                break;
            case AS:
                {
                alt122=25;
                }
                break;
            case BY:
                {
                alt122=26;
                }
                break;
            case USING:
                {
                alt122=27;
                }
                break;
            case INNER:
                {
                alt122=28;
                }
                break;
            case OUTER:
                {
                alt122=29;
                }
                break;
            case PARALLEL:
                {
                alt122=30;
                }
                break;
            case PARTITION:
                {
                alt122=31;
                }
                break;
            case GROUP:
                {
                alt122=32;
                }
                break;
            case AND:
                {
                alt122=33;
                }
                break;
            case OR:
                {
                alt122=34;
                }
                break;
            case NOT:
                {
                alt122=35;
                }
                break;
            case GENERATE:
                {
                alt122=36;
                }
                break;
            case FLATTEN:
                {
                alt122=37;
                }
                break;
            case EVAL:
                {
                alt122=38;
                }
                break;
            case ASC:
                {
                alt122=39;
                }
                break;
            case DESC:
                {
                alt122=40;
                }
                break;
            case BOOLEAN:
                {
                alt122=41;
                }
                break;
            case INT:
                {
                alt122=42;
                }
                break;
            case LONG:
                {
                alt122=43;
                }
                break;
            case FLOAT:
                {
                alt122=44;
                }
                break;
            case DOUBLE:
                {
                alt122=45;
                }
                break;
            case BIGINTEGER:
                {
                alt122=46;
                }
                break;
            case BIGDECIMAL:
                {
                alt122=47;
                }
                break;
            case DATETIME:
                {
                alt122=48;
                }
                break;
            case CHARARRAY:
                {
                alt122=49;
                }
                break;
            case BYTEARRAY:
                {
                alt122=50;
                }
                break;
            case BAG:
                {
                alt122=51;
                }
                break;
            case TUPLE:
                {
                alt122=52;
                }
                break;
            case MAP:
                {
                alt122=53;
                }
                break;
            case IS:
                {
                alt122=54;
                }
                break;
            case NULL:
                {
                alt122=55;
                }
                break;
            case TRUE:
                {
                alt122=56;
                }
                break;
            case FALSE:
                {
                alt122=57;
                }
                break;
            case STREAM:
                {
                alt122=58;
                }
                break;
            case THROUGH:
                {
                alt122=59;
                }
                break;
            case STORE:
                {
                alt122=60;
                }
                break;
            case MAPREDUCE:
                {
                alt122=61;
                }
                break;
            case SHIP:
                {
                alt122=62;
                }
                break;
            case CACHE:
                {
                alt122=63;
                }
                break;
            case INPUT:
                {
                alt122=64;
                }
                break;
            case OUTPUT:
                {
                alt122=65;
                }
                break;
            case STDERROR:
                {
                alt122=66;
                }
                break;
            case STDIN:
                {
                alt122=67;
                }
                break;
            case STDOUT:
                {
                alt122=68;
                }
                break;
            case LIMIT:
                {
                alt122=69;
                }
                break;
            case SAMPLE:
                {
                alt122=70;
                }
                break;
            case LEFT:
                {
                alt122=71;
                }
                break;
            case RIGHT:
                {
                alt122=72;
                }
                break;
            case FULL:
                {
                alt122=73;
                }
                break;
            case IDENTIFIER:
                {
                alt122=74;
                }
                break;
            case TOBAG:
                {
                alt122=75;
                }
                break;
            case TOMAP:
                {
                alt122=76;
                }
                break;
            case TOTUPLE:
                {
                alt122=77;
                }
                break;
            case ASSERT:
                {
                alt122=78;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }

            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:677:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3589);
                    rel_str_op438=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op438.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:678:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT439=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3597); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT439_tree = (CommonTree)adaptor.dupNode(IMPORT439);


                    adaptor.addChild(root_0, IMPORT439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:679:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS440=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS440_tree = (CommonTree)adaptor.dupNode(RETURNS440);


                    adaptor.addChild(root_0, RETURNS440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:680:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE441=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE441_tree = (CommonTree)adaptor.dupNode(DEFINE441);


                    adaptor.addChild(root_0, DEFINE441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:681:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD442=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD442_tree = (CommonTree)adaptor.dupNode(LOAD442);


                    adaptor.addChild(root_0, LOAD442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:682:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER443=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER443_tree = (CommonTree)adaptor.dupNode(FILTER443);


                    adaptor.addChild(root_0, FILTER443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:683:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH444=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH444_tree = (CommonTree)adaptor.dupNode(FOREACH444);


                    adaptor.addChild(root_0, FOREACH444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:684:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE445=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE445_tree = (CommonTree)adaptor.dupNode(CUBE445);


                    adaptor.addChild(root_0, CUBE445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:685:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP446=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3653); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP446_tree = (CommonTree)adaptor.dupNode(ROLLUP446);


                    adaptor.addChild(root_0, ROLLUP446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:686:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT447=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid3661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT447_tree = (CommonTree)adaptor.dupNode(PIVOT447);


                    adaptor.addChild(root_0, PIVOT447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:687:7: CHUNKSIZE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHUNKSIZE448=(CommonTree)match(input,CHUNKSIZE,FOLLOW_CHUNKSIZE_in_eid3669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHUNKSIZE448_tree = (CommonTree)adaptor.dupNode(CHUNKSIZE448);


                    adaptor.addChild(root_0, CHUNKSIZE448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:688:7: RATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RATE449=(CommonTree)match(input,RATE,FOLLOW_RATE_in_eid3677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RATE449_tree = (CommonTree)adaptor.dupNode(RATE449);


                    adaptor.addChild(root_0, RATE449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:689:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES450=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES450_tree = (CommonTree)adaptor.dupNode(MATCHES450);


                    adaptor.addChild(root_0, MATCHES450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:690:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER451=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER451_tree = (CommonTree)adaptor.dupNode(ORDER451);


                    adaptor.addChild(root_0, ORDER451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:691:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK452=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK452_tree = (CommonTree)adaptor.dupNode(RANK452);


                    adaptor.addChild(root_0, RANK452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:692:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT453=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT453_tree = (CommonTree)adaptor.dupNode(DISTINCT453);


                    adaptor.addChild(root_0, DISTINCT453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:693:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP454=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP454_tree = (CommonTree)adaptor.dupNode(COGROUP454);


                    adaptor.addChild(root_0, COGROUP454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:694:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN455=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN455_tree = (CommonTree)adaptor.dupNode(JOIN455);


                    adaptor.addChild(root_0, JOIN455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:695:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS456=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS456_tree = (CommonTree)adaptor.dupNode(CROSS456);


                    adaptor.addChild(root_0, CROSS456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:696:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION457=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION457_tree = (CommonTree)adaptor.dupNode(UNION457);


                    adaptor.addChild(root_0, UNION457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:697:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT458=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT458_tree = (CommonTree)adaptor.dupNode(SPLIT458);


                    adaptor.addChild(root_0, SPLIT458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:698:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO459=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO459_tree = (CommonTree)adaptor.dupNode(INTO459);


                    adaptor.addChild(root_0, INTO459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:699:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF460=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF460_tree = (CommonTree)adaptor.dupNode(IF460);


                    adaptor.addChild(root_0, IF460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:700:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL461=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL461_tree = (CommonTree)adaptor.dupNode(ALL461);


                    adaptor.addChild(root_0, ALL461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:701:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS462=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS462_tree = (CommonTree)adaptor.dupNode(AS462);


                    adaptor.addChild(root_0, AS462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:702:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY463=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY463_tree = (CommonTree)adaptor.dupNode(BY463);


                    adaptor.addChild(root_0, BY463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:703:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING464=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING464_tree = (CommonTree)adaptor.dupNode(USING464);


                    adaptor.addChild(root_0, USING464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:704:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER465=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3805); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER465_tree = (CommonTree)adaptor.dupNode(INNER465);


                    adaptor.addChild(root_0, INNER465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:705:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER466=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER466_tree = (CommonTree)adaptor.dupNode(OUTER466);


                    adaptor.addChild(root_0, OUTER466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:706:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL467=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3821); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL467_tree = (CommonTree)adaptor.dupNode(PARALLEL467);


                    adaptor.addChild(root_0, PARALLEL467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:707:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION468=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3829); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION468_tree = (CommonTree)adaptor.dupNode(PARTITION468);


                    adaptor.addChild(root_0, PARTITION468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:708:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP469=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP469_tree = (CommonTree)adaptor.dupNode(GROUP469);


                    adaptor.addChild(root_0, GROUP469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:709:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND470=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3845); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND470_tree = (CommonTree)adaptor.dupNode(AND470);


                    adaptor.addChild(root_0, AND470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:710:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR471=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3853); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR471_tree = (CommonTree)adaptor.dupNode(OR471);


                    adaptor.addChild(root_0, OR471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:711:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT472=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3861); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT472_tree = (CommonTree)adaptor.dupNode(NOT472);


                    adaptor.addChild(root_0, NOT472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:712:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE473=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE473_tree = (CommonTree)adaptor.dupNode(GENERATE473);


                    adaptor.addChild(root_0, GENERATE473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:713:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN474=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3877); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN474_tree = (CommonTree)adaptor.dupNode(FLATTEN474);


                    adaptor.addChild(root_0, FLATTEN474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:714:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL475=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3885); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL475_tree = (CommonTree)adaptor.dupNode(EVAL475);


                    adaptor.addChild(root_0, EVAL475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:715:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC476=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC476_tree = (CommonTree)adaptor.dupNode(ASC476);


                    adaptor.addChild(root_0, ASC476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:716:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC477=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3901); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC477_tree = (CommonTree)adaptor.dupNode(DESC477);


                    adaptor.addChild(root_0, DESC477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:717:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN478=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN478_tree = (CommonTree)adaptor.dupNode(BOOLEAN478);


                    adaptor.addChild(root_0, BOOLEAN478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:718:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT479=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3917); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT479_tree = (CommonTree)adaptor.dupNode(INT479);


                    adaptor.addChild(root_0, INT479_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:719:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG480=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG480_tree = (CommonTree)adaptor.dupNode(LONG480);


                    adaptor.addChild(root_0, LONG480_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:720:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT481=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3933); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT481_tree = (CommonTree)adaptor.dupNode(FLOAT481);


                    adaptor.addChild(root_0, FLOAT481_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:721:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE482=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3941); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE482_tree = (CommonTree)adaptor.dupNode(DOUBLE482);


                    adaptor.addChild(root_0, DOUBLE482_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:722:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER483=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3949); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER483_tree = (CommonTree)adaptor.dupNode(BIGINTEGER483);


                    adaptor.addChild(root_0, BIGINTEGER483_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:723:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL484=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3957); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL484_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL484);


                    adaptor.addChild(root_0, BIGDECIMAL484_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:724:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME485=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME485_tree = (CommonTree)adaptor.dupNode(DATETIME485);


                    adaptor.addChild(root_0, DATETIME485_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:725:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY486=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3973); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY486_tree = (CommonTree)adaptor.dupNode(CHARARRAY486);


                    adaptor.addChild(root_0, CHARARRAY486_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:726:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY487=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3981); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY487_tree = (CommonTree)adaptor.dupNode(BYTEARRAY487);


                    adaptor.addChild(root_0, BYTEARRAY487_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:727:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG488=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG488_tree = (CommonTree)adaptor.dupNode(BAG488);


                    adaptor.addChild(root_0, BAG488_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:728:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE489=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3997); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE489_tree = (CommonTree)adaptor.dupNode(TUPLE489);


                    adaptor.addChild(root_0, TUPLE489_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:729:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP490=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid4005); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP490_tree = (CommonTree)adaptor.dupNode(MAP490);


                    adaptor.addChild(root_0, MAP490_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:730:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS491=(CommonTree)match(input,IS,FOLLOW_IS_in_eid4013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS491_tree = (CommonTree)adaptor.dupNode(IS491);


                    adaptor.addChild(root_0, IS491_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:731:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL492=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid4021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL492_tree = (CommonTree)adaptor.dupNode(NULL492);


                    adaptor.addChild(root_0, NULL492_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:732:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE493=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid4029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE493_tree = (CommonTree)adaptor.dupNode(TRUE493);


                    adaptor.addChild(root_0, TRUE493_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:733:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE494=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid4037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE494_tree = (CommonTree)adaptor.dupNode(FALSE494);


                    adaptor.addChild(root_0, FALSE494_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:734:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM495=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid4045); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM495_tree = (CommonTree)adaptor.dupNode(STREAM495);


                    adaptor.addChild(root_0, STREAM495_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:735:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH496=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid4053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH496_tree = (CommonTree)adaptor.dupNode(THROUGH496);


                    adaptor.addChild(root_0, THROUGH496_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:736:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE497=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid4061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE497_tree = (CommonTree)adaptor.dupNode(STORE497);


                    adaptor.addChild(root_0, STORE497_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:737:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE498=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid4069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE498_tree = (CommonTree)adaptor.dupNode(MAPREDUCE498);


                    adaptor.addChild(root_0, MAPREDUCE498_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:738:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP499=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid4077); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP499_tree = (CommonTree)adaptor.dupNode(SHIP499);


                    adaptor.addChild(root_0, SHIP499_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:739:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE500=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid4085); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE500_tree = (CommonTree)adaptor.dupNode(CACHE500);


                    adaptor.addChild(root_0, CACHE500_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:740:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT501=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid4093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT501_tree = (CommonTree)adaptor.dupNode(INPUT501);


                    adaptor.addChild(root_0, INPUT501_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:741:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT502=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid4101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT502_tree = (CommonTree)adaptor.dupNode(OUTPUT502);


                    adaptor.addChild(root_0, OUTPUT502_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:742:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR503=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid4109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR503_tree = (CommonTree)adaptor.dupNode(STDERROR503);


                    adaptor.addChild(root_0, STDERROR503_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:743:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN504=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid4117); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN504_tree = (CommonTree)adaptor.dupNode(STDIN504);


                    adaptor.addChild(root_0, STDIN504_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:744:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT505=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid4125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT505_tree = (CommonTree)adaptor.dupNode(STDOUT505);


                    adaptor.addChild(root_0, STDOUT505_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:745:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT506=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT506_tree = (CommonTree)adaptor.dupNode(LIMIT506);


                    adaptor.addChild(root_0, LIMIT506_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:746:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE507=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE507_tree = (CommonTree)adaptor.dupNode(SAMPLE507);


                    adaptor.addChild(root_0, SAMPLE507_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:747:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT508=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4149); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT508_tree = (CommonTree)adaptor.dupNode(LEFT508);


                    adaptor.addChild(root_0, LEFT508_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:748:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT509=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT509_tree = (CommonTree)adaptor.dupNode(RIGHT509);


                    adaptor.addChild(root_0, RIGHT509_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:749:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL510=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4165); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL510_tree = (CommonTree)adaptor.dupNode(FULL510);


                    adaptor.addChild(root_0, FULL510_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:750:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER511=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4173); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER511_tree = (CommonTree)adaptor.dupNode(IDENTIFIER511);


                    adaptor.addChild(root_0, IDENTIFIER511_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:751:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG512=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG512_tree = (CommonTree)adaptor.dupNode(TOBAG512);


                    adaptor.addChild(root_0, TOBAG512_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:752:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP513=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP513_tree = (CommonTree)adaptor.dupNode(TOMAP513);


                    adaptor.addChild(root_0, TOMAP513_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 77 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:753:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE514=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE514_tree = (CommonTree)adaptor.dupNode(TOTUPLE514);


                    adaptor.addChild(root_0, TOTUPLE514_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 78 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:754:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT515=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4205); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT515_tree = (CommonTree)adaptor.dupNode(ASSERT515);


                    adaptor.addChild(root_0, ASSERT515_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:758:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstValidator.rel_op_return rel_op() throws RecognitionException {
        AstValidator.rel_op_return retval = new AstValidator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES522=null;
        AstValidator.rel_op_eq_return rel_op_eq516 =null;

        AstValidator.rel_op_ne_return rel_op_ne517 =null;

        AstValidator.rel_op_gt_return rel_op_gt518 =null;

        AstValidator.rel_op_gte_return rel_op_gte519 =null;

        AstValidator.rel_op_lt_return rel_op_lt520 =null;

        AstValidator.rel_op_lte_return rel_op_lte521 =null;


        CommonTree STR_OP_MATCHES522_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:758:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt123=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt123=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt123=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt123=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt123=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt123=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt123=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt123=7;
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
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:758:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4215);
                    rel_op_eq516=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq516.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:759:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4226);
                    rel_op_ne517=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne517.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:760:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4237);
                    rel_op_gt518=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt518.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:761:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4248);
                    rel_op_gte519=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte519.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:762:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4259);
                    rel_op_lt520=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt520.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:763:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4270);
                    rel_op_lte521=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte521.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:764:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES522=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES522_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES522);


                    adaptor.addChild(root_0, STR_OP_MATCHES522_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:767:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstValidator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstValidator.rel_op_eq_return retval = new AstValidator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set523=null;

        CommonTree set523_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:767:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set523=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set523_tree = (CommonTree)adaptor.dupNode(set523);


                adaptor.addChild(root_0, set523_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:770:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AstValidator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstValidator.rel_op_ne_return retval = new AstValidator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set524=null;

        CommonTree set524_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:770:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set524=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set524_tree = (CommonTree)adaptor.dupNode(set524);


                adaptor.addChild(root_0, set524_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:773:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AstValidator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstValidator.rel_op_gt_return retval = new AstValidator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set525=null;

        CommonTree set525_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:773:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set525=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set525_tree = (CommonTree)adaptor.dupNode(set525);


                adaptor.addChild(root_0, set525_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:776:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstValidator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstValidator.rel_op_gte_return retval = new AstValidator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set526=null;

        CommonTree set526_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:776:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set526=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set526_tree = (CommonTree)adaptor.dupNode(set526);


                adaptor.addChild(root_0, set526_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:779:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AstValidator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstValidator.rel_op_lt_return retval = new AstValidator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set527=null;

        CommonTree set527_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:779:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set527=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set527_tree = (CommonTree)adaptor.dupNode(set527);


                adaptor.addChild(root_0, set527_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:782:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstValidator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstValidator.rel_op_lte_return retval = new AstValidator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set528=null;

        CommonTree set528_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:782:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set528=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set528_tree = (CommonTree)adaptor.dupNode(set528);


                adaptor.addChild(root_0, set528_tree);
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
    // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:785:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstValidator.rel_str_op_return rel_str_op() throws RecognitionException {
        AstValidator.rel_str_op_return retval = new AstValidator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set529=null;

        CommonTree set529_tree=null;

        try {
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:785:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set529=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set529_tree = (CommonTree)adaptor.dupNode(set529);


                adaptor.addChild(root_0, set529_tree);
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

    // $ANTLR start synpred111_AstValidator
    public final void synpred111_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:412:8: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:412:8: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred111_AstValidator1949); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred111_AstValidator1951);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred111_AstValidator1953);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred111_AstValidator

    // $ANTLR start synpred115_AstValidator
    public final void synpred115_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:416:8: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:416:8: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred115_AstValidator2017); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred115_AstValidator2019);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred115_AstValidator2021);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred115_AstValidator

    // $ANTLR start synpred116_AstValidator
    public final void synpred116_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:417:8: ( const_expr )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:417:8: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred116_AstValidator2032);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred116_AstValidator

    // $ANTLR start synpred119_AstValidator
    public final void synpred119_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:420:8: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:420:8: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred119_AstValidator2067); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred119_AstValidator2069);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred119_AstValidator2071);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred119_AstValidator

    // $ANTLR start synpred142_AstValidator
    public final void synpred142_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:31: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred142_AstValidator2387); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred142_AstValidator

    // $ANTLR start synpred143_AstValidator
    public final void synpred143_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:41: ( LONGINTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:467:41: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred143_AstValidator2391); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred143_AstValidator

    // $ANTLR start synpred144_AstValidator
    public final void synpred144_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:33: ( DOUBLENUMBER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:470:33: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred144_AstValidator2416); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred144_AstValidator

    // $ANTLR start synpred174_AstValidator
    public final void synpred174_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred174_AstValidator2765);
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


        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:38: ( OUTER )?
        int alt135=2;
        int LA135_0 = input.LA(1);

        if ( (LA135_0==OUTER) ) {
            alt135=1;
        }
        switch (alt135) {
            case 1 :
                // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:524:38: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred174_AstValidator2781); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred174_AstValidator2784);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred174_AstValidator

    // $ANTLR start synpred192_AstValidator
    public final void synpred192_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:43: ( INTEGER )
        // /home/hoang/DATA/WORKSPACE/trunk0408/src/org/apache/pig/parser/AstValidator.g:603:43: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred192_AstValidator3195); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred192_AstValidator

    // Delegated rules

    public final boolean synpred142_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred142_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred174_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred174_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred144_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred144_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred192_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred192_AstValidator_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0100100000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement181 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_USING_in_register_statement184 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement186 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement188 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement218 = new BitSet(new long[]{0x009080044C800400L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_op_clause_in_general_statement225 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause242 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause263 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause575 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd604 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd608 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd632 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd656 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd680 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd704 = new BitSet(new long[]{0x4000000000080008L,0x0420000100000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list757 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause786 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd846 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause862 = new BitSet(new long[]{0x0000000000000008L,0x1800020000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause881 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause902 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause904 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def952 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x0800100000010000L});
    public static final BitSet FOLLOW_type_in_field_def956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_simple_type_in_type1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1159 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1216 = new BitSet(new long[]{0x0000000000000008L,0x0000020000040000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1230 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_set_in_func_name1234 = new BitSet(new long[]{0xEEF3A0455CEF5F50L,0xFD2C6C27B018DC3AL,0xC700000000000FBFL});
    public static final BitSet FOLLOW_eid_in_func_name1244 = new BitSet(new long[]{0x0000001000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_func_args_string_in_func_args1269 = new BitSet(new long[]{0x0000000000000002L,0x0000020000040000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_pivot_clause_in_h2irg_clause1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_autopivot_clause_in_h2irg_clause1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1319 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_chunksize_clause_in_autopivot_clause1336 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rate_clause_in_autopivot_clause1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_chunksize_clause1353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_chunksize_clause1355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RATE_in_rate_clause1372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_rate_clause1374 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1386 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1404 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1418 = new BitSet(new long[]{0x0000000008000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1443 = new BitSet(new long[]{0x0000000000400008L,0x0000002000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_chunksize_clause_in_cube_rollup_list1453 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rate_clause_in_cube_rollup_list1455 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1472 = new BitSet(new long[]{0x028820A80800A002L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1522 = new BitSet(new long[]{0x029080044C800488L,0x6108060420008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_group_type_in_group_clause1525 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1550 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1554 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1558 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1562 = new BitSet(new long[]{0x2000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_alias_in_rel1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1609 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1623 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1627 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1631 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1635 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1668 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1670 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause1688 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_assert_clause1690 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1718 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_filter_clause1720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1735 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_cond1737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1752 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_cond1754 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1784 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_NOT_in_cond1786 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1802 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_cond1804 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1835 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1837 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1855 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1863 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1884 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1886 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1897 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval1899 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1901 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_expr_in_real_arg1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1932 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1934 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1951 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1953 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1968 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1983 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1985 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr1987 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2000 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2002 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2004 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2017 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr2019 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2054 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2067 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2069 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_expr2071 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2086 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2122 = new BitSet(new long[]{0x8002004010255008L,0x0000000000001000L,0x1000100000020000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2150 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2154 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2158 = new BitSet(new long[]{0x0000000000000002L,0x0000009000000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2198 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2253 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2256 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2274 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2297 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2299 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_bin_expr2301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2319 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2356 = new BitSet(new long[]{0x1000000000000048L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_THEN_in_case_cond2363 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2365 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2383 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2395 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2410 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2412 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2416 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2420 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2437 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2441 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2459 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2463 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2477 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2507 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2517 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2539 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2563 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2565 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2579 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2610 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2620 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2643 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2667 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2700 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2702 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2714 = new BitSet(new long[]{0x029080044C800482L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2738 = new BitSet(new long[]{0x0000000000000008L,0x0000020400000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2740 = new BitSet(new long[]{0x0000000000000008L,0x0000000400000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2765 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2789 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2804 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2806 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2833 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2837 = new BitSet(new long[]{0x028820A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2873 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2875 = new BitSet(new long[]{0x029080044C800480L,0x6108040020008C10L,0x0000000000000400L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2891 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2910 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2931 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2933 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2953 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2967 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2969 = new BitSet(new long[]{0x028920A80800A008L,0x0200024800112001L,0x200060141CCC0100L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2984 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2986 = new BitSet(new long[]{0x0010800404000000L,0x0000000020000400L,0x0002000000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2988 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3004 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_nested_command3006 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3119 = new BitSet(new long[]{0x0280002008000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3121 = new BitSet(new long[]{0x0280002008000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3138 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_nested_filter3140 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3153 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3155 = new BitSet(new long[]{0x0280002008000000L,0x0200000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3158 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000A00000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3174 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3176 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3191 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3195 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3231 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3257 = new BitSet(new long[]{0x0280002008000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3271 = new BitSet(new long[]{0x0200100000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3273 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3299 = new BitSet(new long[]{0x0000000000000000L,0x2000020000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3301 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3306 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3308 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3326 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3344 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3346 = new BitSet(new long[]{0x1000000000000040L,0x8000000017F80000L,0x000000140020003FL});
    public static final BitSet FOLLOW_cond_in_split_branch3348 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3478 = new BitSet(new long[]{0x000800800000A000L,0x0000000000002001L});
    public static final BitSet FOLLOW_set_in_num_scalar3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3516 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3518 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3534 = new BitSet(new long[]{0x000820800000A000L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3536 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3560 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3576 = new BitSet(new long[]{0x000820800000A008L,0x0000020000112001L,0x2000200000040100L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHUNKSIZE_in_eid3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RATE_in_eid3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid4045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid4061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid4101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred111_AstValidator1949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred111_AstValidator1951 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred111_AstValidator1953 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred115_AstValidator2017 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred115_AstValidator2019 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred115_AstValidator2021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred116_AstValidator2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred119_AstValidator2067 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred119_AstValidator2069 = new BitSet(new long[]{0x028820A80800A000L,0x0200024800112001L,0x2000601414CC0100L});
    public static final BitSet FOLLOW_expr_in_synpred119_AstValidator2071 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred142_AstValidator2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred143_AstValidator2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred144_AstValidator2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred174_AstValidator2765 = new BitSet(new long[]{0x0020000000000000L,0x0000400000000020L});
    public static final BitSet FOLLOW_set_in_synpred174_AstValidator2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred174_AstValidator2781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred174_AstValidator2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred192_AstValidator3195 = new BitSet(new long[]{0x0000000000000002L});

}