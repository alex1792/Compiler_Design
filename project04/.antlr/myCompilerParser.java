// Generated from /home/alex/compiler_design/project04/myCompiler.g by ANTLR 4.9.2

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myCompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, FLOAT=13, INT=14, CHAR=15, MAIN=16, VOID=17, 
		IF=18, ELSE=19, FOR=20, GT=21, GE=22, LT=23, LE=24, EQ=25, NE=26, PRINTF=27, 
		SCANF=28, MALLOC=29, SIZEOF=30, Identifier=31, Integer_constant=32, Floating_point_constant=33, 
		STRING_LITERAL=34, WS=35, COMMENT=36;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_type = 2, RULE_statements = 3, 
		RULE_statement = 4, RULE_printf_stmt = 5, RULE_for_stmt = 6, RULE_if_stmt = 7, 
		RULE_if_then_stmt = 8, RULE_if_else_stmt = 9, RULE_block_stmt = 10, RULE_assign_stmt = 11, 
		RULE_func_no_return_stmt = 12, RULE_argument = 13, RULE_arg = 14, RULE_cond_expression = 15, 
		RULE_relationOP = 16, RULE_arith_expression = 17, RULE_multExpr = 18, 
		RULE_signExpr = 19, RULE_primaryExpr = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "type", "statements", "statement", "printf_stmt", 
			"for_stmt", "if_stmt", "if_then_stmt", "if_else_stmt", "block_stmt", 
			"assign_stmt", "func_no_return_stmt", "argument", "arg", "cond_expression", 
			"relationOP", "arith_expression", "multExpr", "signExpr", "primaryExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "';'", "','", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'&'", "'float'", "'int'", "'char'", "'main'", "'void'", 
			"'if'", "'else'", "'for'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
			"'printf'", "'scanf'", "'malloc'", "'sizeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "FLOAT", "INT", "CHAR", "MAIN", "VOID", "IF", "ELSE", "FOR", "GT", 
			"GE", "LT", "LE", "EQ", "NE", "PRINTF", "SCANF", "MALLOC", "SIZEOF", 
			"Identifier", "Integer_constant", "Floating_point_constant", "STRING_LITERAL", 
			"WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "myCompiler.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    boolean TRACEON = false;

	    // Type information.
	    public enum Type{
	       ERR, BOOL, INT, FLOAT, CHAR, CONST_INT, CONST_FLOAT;
	    }

	    //   logic operator
	    public enum RelationOP_type
	    {
	       GT, LT, GE, LE, EQ, NE;
	    }

	    // This structure is used to record the information of a variable or a constant.
	    class tVar {
		   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
		   int   iValue;   // value of constant integer. Ex: 123.
		   float fValue;   // value of constant floating point. Ex: 2.314.
		};

	    class Info {
	       Type theType;  // type information.
	       tVar theVar;
		   
		   Info() {
	          theType = Type.ERR;
			  theVar = new tVar();
		   }
	    };

		
	    // ============================================
	    // Create a symbol table.
		// ArrayList is easy to extend to add more info. into symbol table.
		//
		// The structure of symbol table:
		// <variable ID, [Type, [varIndex or iValue, or fValue]]>
		//    - type: the variable type   (please check "enum Type")
		//    - varIndex: the variable's index, ex: t1, t2, ...
		//    - iValue: value of integer constant.
		//    - fValue: value of floating-point constant.
	    // ============================================

	    HashMap<String, Info> symtab = new HashMap<String, Info>();

	    // labelCount is used to represent temporary label.
	    // The first index is 0.
	    int labelCount = 0;
		
	    // varCount is used to represent temporary variables.
	    // The first index is 0.
	    int varCount = 0;

	    // Record all assembly instructions.
	    List<String> TextCode = new ArrayList<String>();

	    //   Record conditional expression
	    int condCount = 0;

	    //   Record printf
	    int printfCount = 2;


	    /*
	     * Output prologue.
	     */
	    void prologue()
	    {
	       TextCode.add("; === prologue ====");
	       TextCode.add("declare dso_local i32 @printf(i8*, ...)\n");
		   TextCode.add("define dso_local i32 @main()");
		   TextCode.add("{");
	    }
	    
		
	    /*
	     * Output epilogue.
	     */
	    void epilogue()
	    {
	       /* handle epilogue */
	       TextCode.add("\n; === epilogue ===");
		   TextCode.add("ret i32 0");
	       TextCode.add("}");
	    }
	    
	    
	    /* Generate a new label */
	    String newLabel()
	    {
	       labelCount ++;
	       return (new String("L")) + Integer.toString(labelCount);
	    } 
	    
	    
	    public List<String> getTextCode()
	    {
	       return TextCode;
	    }

	public myCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(myCompilerParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(myCompilerParser.MAIN, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(VOID);
			setState(43);
			match(MAIN);
			setState(44);
			match(T__0);
			setState(45);
			match(T__1);

			           /* Output function prologue */
			           prologue();
			        
			setState(47);
			match(T__2);
			setState(48);
			declarations();
			setState(49);
			statements();
			setState(50);
			match(T__3);

				   if (TRACEON)
				      System.out.println("VOID MAIN () {declarations statements}");

			           /* output function epilogue */	  
			           epilogue();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				type();
				setState(54);
				match(Identifier);
				setState(55);
				match(T__4);
				setState(56);
				declarations();

				            if (TRACEON)
				               System.out.println("declarations: type Identifier : declarations");

				            //  if the ID already exist in the symble table -> re-declaired
				            if (symtab.containsKey((((DeclarationsContext)_localctx).Identifier!=null?((DeclarationsContext)_localctx).Identifier.getText():null))) {
				               System.out.println("Type Error: " +  ((DeclarationsContext)_localctx).Identifier.getLine() + ": Redeclared identifier.");
				               System.exit(0);
				            }
				                 
				            /* Add ID and its info into the symbol table. */
					         Info the_entry = new Info();
						      the_entry.theType = ((DeclarationsContext)_localctx).type.attr_type;
						      the_entry.theVar.varIndex = varCount;
						      varCount ++;
						      symtab.put((((DeclarationsContext)_localctx).Identifier!=null?((DeclarationsContext)_localctx).Identifier.getText():null), the_entry);

				            // generate instruction.
				            //  INT->i32、FLOAT、CHAR->i8
				            if (((DeclarationsContext)_localctx).type.attr_type == Type.INT) { 
				               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
				            }
				            else if(((DeclarationsContext)_localctx).type.attr_type == Type.FLOAT){
				               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float");
				            }
				            else if(((DeclarationsContext)_localctx).type.attr_type == Type.CHAR){
				               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i8");
				            }
				   
				}
				break;
			case T__3:
			case IF:
			case FOR:
			case PRINTF:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{

				           if (TRACEON)
				              System.out.println("declarations: ");
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type attr_type;
		public TerminalNode INT() { return getToken(myCompilerParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(myCompilerParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(myCompilerParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(INT);
				 if (TRACEON) System.out.println("type: INT"); ((TypeContext)_localctx).attr_type = Type.INT; 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(CHAR);
				 if (TRACEON) System.out.println("type: CHAR"); ((TypeContext)_localctx).attr_type = Type.CHAR; 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(FLOAT);
				if (TRACEON) System.out.println("type: FLOAT"); ((TypeContext)_localctx).attr_type = Type.FLOAT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statements);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case FOR:
			case PRINTF:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				statement();
				setState(71);
				statements();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Func_no_return_stmtContext func_no_return_stmt() {
			return getRuleContext(Func_no_return_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Printf_stmtContext printf_stmt() {
			return getRuleContext(Printf_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				assign_stmt();
				setState(77);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				func_no_return_stmt();
				setState(81);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				for_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				printf_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Printf_stmtContext extends ParserRuleContext {
		public ArgumentContext a;
		public TerminalNode PRINTF() { return getToken(myCompilerParser.PRINTF, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(myCompilerParser.STRING_LITERAL, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public Printf_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printf_stmt; }
	}

	public final Printf_stmtContext printf_stmt() throws RecognitionException {
		Printf_stmtContext _localctx = new Printf_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printf_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PRINTF);
			setState(88);
			match(T__0);
			setState(89);
			match(STRING_LITERAL);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(90);
				match(T__5);
				setState(91);
				((Printf_stmtContext)_localctx).a = argument();
				}
			}

			setState(94);
			match(T__1);
			setState(95);
			match(T__4);

			            String newStr = (((Printf_stmtContext)_localctx).STRING_LITERAL!=null?((Printf_stmtContext)_localctx).STRING_LITERAL.getText():null);
			            int len = newStr.length();
			            int matched = 0;
			            int pos = newStr.indexOf("\\n", 0);

			            // pos = starting position, matched = numbers of matched characters
			            while(pos != -1){
			                matched++;
			                pos = newStr.indexOf("\\n", pos + 1);
			            }

			            // plus 1 for EOF, minus 2 for ""
			            len = len - matched - 2 + 1;

			            newStr = newStr.replace("\\n", "\\0A");
			            newStr = newStr.substring(0, newStr.length() - 1) + "\\00" + "\"";
			            
			            // get argument list
			            String arg_list = "";
			            if((((Printf_stmtContext)_localctx).a!=null?_input.getText(((Printf_stmtContext)_localctx).a.start,((Printf_stmtContext)_localctx).a.stop):null) != null){
			                for(int i = 0; i < ((Printf_stmtContext)_localctx).a.rec.size(); i++){
			                    Type theType = ((Printf_stmtContext)_localctx).a.rec.get(i).theType;
			                    switch(theType){
			                        case INT:
			                            arg_list = arg_list.concat(", i32 \%t" + ((Printf_stmtContext)_localctx).a.rec.get(i).theVar.varIndex);
			                            break;

			                        case FLOAT:
			                            arg_list = arg_list.concat(", double \%t" + ((Printf_stmtContext)_localctx).a.rec.get(i).theVar.varIndex);
			                            break;
			                    }
			                }
			            }

			            TextCode.add(printfCount, "@.str." + (printfCount - 2) + " = private unnamed_addr constant [" +
			                        len + " x i8] c" + newStr + ", align 1");
			            TextCode.add("\t\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" +
			                        len + " x i8], [" + (len) + " x i8]* @.str." + (printfCount - 2) + ", i64 0, i64 0)" + 
			                        arg_list + ")");
			            printfCount++;
			            varCount++;
			            
			            if (TRACEON) { 
			                System.out.println("PRINT '(\"' STRING_LITERAL '\")'"); 
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public Cond_expressionContext a;
		public TerminalNode FOR() { return getToken(myCompilerParser.FOR, 0); }
		public List<Assign_stmtContext> assign_stmt() {
			return getRuleContexts(Assign_stmtContext.class);
		}
		public Assign_stmtContext assign_stmt(int i) {
			return getRuleContext(Assign_stmtContext.class,i);
		}
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public Cond_expressionContext cond_expression() {
			return getRuleContext(Cond_expressionContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_for_stmt);
		String assign = newLabel();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(FOR);
			setState(99);
			match(T__0);
			setState(100);
			assign_stmt();
			setState(101);
			match(T__4);

			      String loop = newLabel();
				   TextCode.add("\tbr label \%" + loop);
			      TextCode.add("\n" + loop + ":");
			   
			setState(103);
			((For_stmtContext)_localctx).a = cond_expression();
			setState(104);
			match(T__4);

				   TextCode.add("\tbr i1 \%cond" + condCount + ", label \%" + ((For_stmtContext)_localctx).a.ctrue + ", label \%" + ((For_stmtContext)_localctx).a.cfalse);
			      TextCode.add("\n" + assign + ":");
			      condCount++;
			   
			setState(106);
			assign_stmt();

			      TextCode.add("\tbr label \%" + loop);
				   TextCode.add( "\n" + ((For_stmtContext)_localctx).a.ctrue + ":" );
			   
			setState(108);
			match(T__1);
			setState(109);
			block_stmt();

			      // a is the return value of conditional expression
				   TextCode.add("\tbr label \%" + assign);
			      TextCode.add("\n" + ((For_stmtContext)_localctx).a.cfalse + ":");
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public If_then_stmtContext if_then_stmt() {
			return getRuleContext(If_then_stmtContext.class,0);
		}
		public If_else_stmtContext if_else_stmt() {
			return getRuleContext(If_else_stmtContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			if_then_stmt();
			setState(113);
			if_else_stmt();

			            TextCode.add( "\tbr label \%" + ((If_stmtContext)_localctx).if_then_stmt.ifend );
			            TextCode.add( "\n" + ((If_stmtContext)_localctx).if_then_stmt.ifend + ":" );
			         
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_then_stmtContext extends ParserRuleContext {
		public String ifend;
		public TerminalNode IF() { return getToken(myCompilerParser.IF, 0); }
		public Cond_expressionContext cond_expression() {
			return getRuleContext(Cond_expressionContext.class,0);
		}
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public If_then_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_stmt; }
	}

	public final If_then_stmtContext if_then_stmt() throws RecognitionException {
		If_then_stmtContext _localctx = new If_then_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_then_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(IF);
			setState(117);
			match(T__0);
			setState(118);
			cond_expression();

				   TextCode.add("\tbr i1 \%cond" + condCount + ", label \%" + ((If_then_stmtContext)_localctx).cond_expression.ctrue + ", label \%" + ((If_then_stmtContext)_localctx).cond_expression.cfalse);
			      TextCode.add("\n" + ((If_then_stmtContext)_localctx).cond_expression.ctrue + ":");
			      condCount++;
			   
			setState(120);
			match(T__1);
			setState(121);
			block_stmt();

			      if(TRACEON) System.out.println("IF ( cond_expression ) block_stmt");
			      
			      ifend = newLabel();
			      TextCode.add("\tbr label \%" + ifend);
			      TextCode.add("\n" + ((If_then_stmtContext)_localctx).cond_expression.cfalse + ":");
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_else_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(myCompilerParser.ELSE, 0); }
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public If_else_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else_stmt; }
	}

	public final If_else_stmtContext if_else_stmt() throws RecognitionException {
		If_else_stmtContext _localctx = new If_else_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_else_stmt);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(ELSE);
				setState(125);
				block_stmt();
				if(TRACEON) System.out.println("if_else_stmt: ELSE block_stmt");
				}
				break;
			case T__3:
			case IF:
			case FOR:
			case PRINTF:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_stmtContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Block_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stmt; }
	}

	public final Block_stmtContext block_stmt() throws RecognitionException {
		Block_stmtContext _localctx = new Block_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__2);
			setState(132);
			statements();
			setState(133);
			match(T__3);
			if(TRACEON) System.out.println("block_stmt: '{' statements '}'");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(Identifier);
			setState(137);
			match(T__6);
			setState(138);
			arith_expression();

			                Info theRHS = ((Assign_stmtContext)_localctx).arith_expression.theInfo;
							Info theLHS = symtab.get((((Assign_stmtContext)_localctx).Identifier!=null?((Assign_stmtContext)_localctx).Identifier.getText():null)); 
					   
			                if ((theLHS.theType == Type.INT) &&
			                    (theRHS.theType == Type.INT)) {		   
			                   // issue store insruction.
			                   // Ex: store i32 \%tx, i32* \%ty
			                   TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex);
							} else if ((theLHS.theType == Type.INT) &&
							    (theRHS.theType == Type.CONST_INT)) {
			                   // issue store insruction.
			                   // Ex: store i32 value, i32* \%ty
			                   TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex);				
							} else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
			                  TextCode.add("\tstore float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex);
				         } else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
			                  double tmp = theRHS.theVar.fValue;
			                  // System.out.println(tmp);
			                  long ans = Double.doubleToLongBits(tmp);
				               TextCode.add( "\tstore float 0x" + Long.toHexString(ans) + ", float* \%t" + theLHS.theVar.varIndex + ", align 4" );
				         } else if( ( theLHS.theType != theRHS.theType )  &&  ( theLHS.theType != Type.ERR ) && ( theRHS.theType != Type.ERR ) ){
			                    System.out.println( "Error: " + ((Assign_stmtContext)_localctx).Identifier.getLine() + ": Type mismatch for the = operation in an expression." );
			                    System.exit(0);
			            }
						 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_no_return_stmtContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public Func_no_return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_no_return_stmt; }
	}

	public final Func_no_return_stmtContext func_no_return_stmt() throws RecognitionException {
		Func_no_return_stmtContext _localctx = new Func_no_return_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_func_no_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(Identifier);
			setState(142);
			match(T__0);
			setState(143);
			argument();
			setState(144);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public List<Info> rec;
		public ArgContext a;
		public ArgContext b;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argument);
		 ((ArgumentContext)_localctx).rec =  new ArrayList<Info>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((ArgumentContext)_localctx).a = arg();

			            _localctx.rec.add( ((ArgumentContext)_localctx).a.theInfo );
			            if( ((ArgumentContext)_localctx).a.theInfo.theType == Type.FLOAT ){
			                TextCode.add( "\t\%t" + varCount + " = fpext float \%t" + ((ArgumentContext)_localctx).a.theInfo.theVar.varIndex + " to double" );
			                ((ArgumentContext)_localctx).a.theInfo.theVar.varIndex = varCount;
			                varCount++;
			            }
			        
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(148);
				match(T__5);
				setState(149);
				((ArgumentContext)_localctx).b = arg();

				            _localctx.rec.add( ((ArgumentContext)_localctx).b.theInfo );
				            if( ((ArgumentContext)_localctx).b.theInfo.theType == Type.FLOAT ){
				                TextCode.add( "\t\%t" + varCount + " = fpext float \%t" + ((ArgumentContext)_localctx).b.theInfo.theVar.varIndex + " to double" );
				                ((ArgumentContext)_localctx).b.theInfo.theVar.varIndex = varCount;
				                varCount++;
				            }
				        
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public Info theInfo;
		public Arith_expressionContext a;
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(myCompilerParser.STRING_LITERAL, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arg);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__8:
			case T__11:
			case Identifier:
			case Integer_constant:
			case Floating_point_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((ArgContext)_localctx).a = arith_expression();

					         // return the info of arithmatic expression
				            ((ArgContext)_localctx).theInfo =  ((ArgContext)_localctx).a.theInfo;
				        
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_expressionContext extends ParserRuleContext {
		public String ctrue;
		public String cfalse;
		public Arith_expressionContext a;
		public Arith_expressionContext b;
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public List<RelationOPContext> relationOP() {
			return getRuleContexts(RelationOPContext.class);
		}
		public RelationOPContext relationOP(int i) {
			return getRuleContext(RelationOPContext.class,i);
		}
		public Cond_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_expression; }
	}

	public final Cond_expressionContext cond_expression() throws RecognitionException {
		Cond_expressionContext _localctx = new Cond_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cond_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((Cond_expressionContext)_localctx).a = arith_expression();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NE))) != 0)) {
				{
				{
				setState(164);
				relationOP();
				setState(165);
				((Cond_expressionContext)_localctx).b = arith_expression();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					// for each data type, there are four conditions
			      // 1. var logic var        EX: a > b
			      // 2. var logic const      EX: a > 5
			      // 3. const logic const    EX: 5 > 3
			      // 4. const logic var      EX: 5 > a
			      // where logic represent: > < >= <= == != 
			      // GT、LT、GE、LE、EQ、NE
			      // icmp parameters: sgt、slt、sge、sle、eq、ne
			      // fcmp parameters: ogt、olt、oge、ole、oeq、one
			      
			      //  Greater Than GT >
			      if(((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.GT)
			      {
			         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }
			      // Less Than < LT
			      else if (((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.LT)
			      {
				         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp olt float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }
			      // Greater or Equal than >= GE
			      else if(((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.GE)
			      {
				         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp oge float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }
			      // Less or Equal than <= LE
				   else if(((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.LE)
			      {
				         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp ole float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }
			      // Equal == EQ
				   else if(((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.EQ)
			      {
				         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }
			      // Not Equal != NE
				   else if(((Cond_expressionContext)_localctx).relationOP.r_type == RelationOP_type.NE)
			      {
				         // 1. var > var
			         if((((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT))
			         { 
			            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
				      // 2. var > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 3. const > const
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue + ", " + ((Cond_expressionContext)_localctx).b.theInfo.theVar.iValue );
			         }
				      // 4. const > var 
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.INT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 " + ((Cond_expressionContext)_localctx).a.theInfo.theVar.iValue + ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // float
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            TextCode.add( "\t\%cond" + condCount + " = fcmp one float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			            double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			            long ans2 = Double.doubleToLongBits( val2 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp one float \%t" + ((Cond_expressionContext)_localctx).a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT ) )
			         {
			                    double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			                    long ans1 = Double.doubleToLongBits( val1 );
			                    double val2 = ((Cond_expressionContext)_localctx).b.theInfo.theVar.fValue;
			                    long ans2 = Double.doubleToLongBits( val2 );
			                    TextCode.add( "\t\%cond" + condCount + " = fcmp one float 0x" + Long.toHexString( ans1 ) + 
			                                                ", 0x" + Long.toHexString( ans2 ) );
			         }
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT ) )
			         {
			            double val1 = ((Cond_expressionContext)_localctx).a.theInfo.theVar.fValue;
			            long ans1 = Double.doubleToLongBits( val1 );
			            TextCode.add( "\t\%cond" + condCount + " = fcmp one float 0x" + Long.toHexString( ans1 ) + 
			                                                ", \%t" + ((Cond_expressionContext)_localctx).b.theInfo.theVar.varIndex );
			         }
			         // different data type
			         else if( ( ((Cond_expressionContext)_localctx).a.theInfo.theType != ((Cond_expressionContext)_localctx).b.theInfo.theType )  &&  ( ((Cond_expressionContext)_localctx).a.theInfo.theType != Type.ERR ) && ( ((Cond_expressionContext)_localctx).b.theInfo.theType != Type.ERR ) )
			         {
			                    System.out.println( "Error: " + (((Cond_expressionContext)_localctx).a!=null?(((Cond_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the > operation in an expression." );
			                    ((Cond_expressionContext)_localctx).a.theInfo.theType = Type.ERR;                                                          
			                    System.exit(0);
			         }
			      }

			      ((Cond_expressionContext)_localctx).ctrue =  newLabel();
			      ((Cond_expressionContext)_localctx).cfalse =  newLabel();
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationOPContext extends ParserRuleContext {
		public RelationOP_type r_type;
		public TerminalNode GT() { return getToken(myCompilerParser.GT, 0); }
		public TerminalNode LT() { return getToken(myCompilerParser.LT, 0); }
		public TerminalNode GE() { return getToken(myCompilerParser.GE, 0); }
		public TerminalNode LE() { return getToken(myCompilerParser.LE, 0); }
		public TerminalNode EQ() { return getToken(myCompilerParser.EQ, 0); }
		public TerminalNode NE() { return getToken(myCompilerParser.NE, 0); }
		public RelationOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationOP; }
	}

	public final RelationOPContext relationOP() throws RecognitionException {
		RelationOPContext _localctx = new RelationOPContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_relationOP);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GT:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(GT);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.GT;
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(LT);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.LT;
				}
				break;
			case GE:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(GE);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.GE;
				}
				break;
			case LE:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(LE);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.LE;
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(EQ);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.EQ;
				}
				break;
			case NE:
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(NE);
				((RelationOPContext)_localctx).r_type =  RelationOP_type.NE;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_expressionContext extends ParserRuleContext {
		public Info theInfo;
		public MultExprContext a;
		public MultExprContext b;
		public MultExprContext c;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public Arith_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression; }
	}

	public final Arith_expressionContext arith_expression() throws RecognitionException {
		Arith_expressionContext _localctx = new Arith_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arith_expression);
		((Arith_expressionContext)_localctx).theInfo =  new Info();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((Arith_expressionContext)_localctx).a = multExpr();
			 ((Arith_expressionContext)_localctx).theInfo = ((Arith_expressionContext)_localctx).a.theInfo; 
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				setState(198);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(190);
					match(T__7);
					setState(191);
					((Arith_expressionContext)_localctx).b = multExpr();

					                     // We need to do type checking first.
					                     // ...
										  
					                     // code generation.	
					                     //  INT				   
					                     if ((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     } 
					                     else if ((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + _localctx.theInfo.theVar.varIndex + ", " + ((Arith_expressionContext)_localctx).b.theInfo.theVar.iValue);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = add nsw i32 " + _localctx.theInfo.theVar.iValue + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
						                  else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.CONST_INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = add nsw i32 " + _localctx.theInfo.theVar.iValue + ", " + ((Arith_expressionContext)_localctx).b.theInfo.theVar.iValue);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // FLOAT
						                  else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT))
					                     {
					                        TextCode.add("\t\%t" + varCount + " = fadd float \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     } 
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val2 = ((Arith_expressionContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fadd float \%t" + _localctx.theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val1 = ((Arith_expressionContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        double val2 = ((Arith_expressionContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fadd float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((Arith_expressionContext)_localctx).b.theInfo.theType == Type.FLOAT))
					                     {
					                        double val1 = ((Arith_expressionContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        TextCode.add("\t\%t" + varCount + " = fadd float 0x" + Long.toHexString(ans1) + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // different data type
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType != ((Arith_expressionContext)_localctx).b.theInfo.theType)  &&  (((Arith_expressionContext)_localctx).a.theInfo.theType != Type.ERR) && (((Arith_expressionContext)_localctx).b.theInfo.theType != Type.ERR))
					                     {
					                        // System.out.println(((Arith_expressionContext)_localctx).a.theInfo.theType + " " +((Arith_expressionContext)_localctx).b.theInfo.theType);
					                        System.out.println("Error: " + (((Arith_expressionContext)_localctx).a!=null?(((Arith_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the + operation in an expression.");
					                        ((Arith_expressionContext)_localctx).a.theInfo.theType = Type.ERR;
					                        System.exit(0);
					                     }
					                    
					}
					break;
				case T__8:
					{
					setState(194);
					match(T__8);
					setState(195);
					((Arith_expressionContext)_localctx).c = multExpr();

						                  // We need to do type checking first.
					                     // ...
										  
					                     // code generation.	
					                     //  INT				   
					                     if ((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = sub i32 \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     } 
					                     else if ((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.INT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.CONST_INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = sub i32 \%t" + _localctx.theInfo.theVar.varIndex + ", " + ((Arith_expressionContext)_localctx).b.theInfo.theVar.iValue);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = sub i32 " + _localctx.theInfo.theVar.iValue + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
						                  else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.CONST_INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = sub i32 " + _localctx.theInfo.theVar.iValue + ", " + ((Arith_expressionContext)_localctx).b.theInfo.theVar.iValue);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // FLOAT
						                  else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.FLOAT))
					                     {
					                        TextCode.add("\t\%t" + varCount + " = fsub float \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     } 
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val2 = ((Arith_expressionContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fsub float \%t" + _localctx.theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val1 = ((Arith_expressionContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        double val2 = ((Arith_expressionContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fsub float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((Arith_expressionContext)_localctx).c.theInfo.theType == Type.FLOAT))
					                     {
					                        double val1 = ((Arith_expressionContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        TextCode.add("\t\%t" + varCount + " = fsub float 0x" + Long.toHexString(ans1) + ", \%t" + ((Arith_expressionContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // different data type
					                     else if((((Arith_expressionContext)_localctx).a.theInfo.theType != ((Arith_expressionContext)_localctx).c.theInfo.theType)  &&  (((Arith_expressionContext)_localctx).a.theInfo.theType != Type.ERR) && (((Arith_expressionContext)_localctx).c.theInfo.theType != Type.ERR))
					                     {
					                        // System.out.println(((Arith_expressionContext)_localctx).a.theInfo.theType + " " +((Arith_expressionContext)_localctx).b.theInfo.theType);
					                        System.out.println("Error: " + (((Arith_expressionContext)_localctx).a!=null?(((Arith_expressionContext)_localctx).a.start):null).getLine() + ": Type mismatch for the + operation in an expression.");
					                        ((Arith_expressionContext)_localctx).a.theInfo.theType = Type.ERR;
					                        System.exit(0);
					                     }
					      
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExprContext extends ParserRuleContext {
		public Info theInfo;
		public SignExprContext a;
		public SignExprContext b;
		public SignExprContext c;
		public List<SignExprContext> signExpr() {
			return getRuleContexts(SignExprContext.class);
		}
		public SignExprContext signExpr(int i) {
			return getRuleContext(SignExprContext.class,i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multExpr);
		((MultExprContext)_localctx).theInfo =  new Info();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			((MultExprContext)_localctx).a = signExpr();
			 ((MultExprContext)_localctx).theInfo = ((MultExprContext)_localctx).a.theInfo; 
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				setState(213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(205);
					match(T__9);
					setState(206);
					((MultExprContext)_localctx).b = signExpr();

					                     // similar to arith_expression, but change add and fadd with mul and fmul
						                  // We need to do type checking first.
					                     // ...
										  
					                     // code generation.	
					                     //  INT				   
					                     if ((((MultExprContext)_localctx).a.theInfo.theType == Type.INT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     } 
					                     else if ((((MultExprContext)_localctx).a.theInfo.theType == Type.INT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.CONST_INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + _localctx.theInfo.theVar.varIndex + ", " + ((MultExprContext)_localctx).b.theInfo.theVar.iValue);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = mul nsw i32 " + _localctx.theInfo.theVar.iValue + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
						                  else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.CONST_INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = mul nsw i32 " + _localctx.theInfo.theVar.iValue + ", " + ((MultExprContext)_localctx).b.theInfo.theVar.iValue);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // FLOAT
						                  else if((((MultExprContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.FLOAT))
					                     {
					                        TextCode.add("\t\%t" + varCount + " = fmul float \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     } 
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val2 = ((MultExprContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fmul float \%t" + _localctx.theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val1 = ((MultExprContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        double val2 = ((MultExprContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fmul float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((MultExprContext)_localctx).b.theInfo.theType == Type.FLOAT))
					                     {
					                        double val1 = ((MultExprContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        TextCode.add("\t\%t" + varCount + " = fmul float 0x" + Long.toHexString(ans1) + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // different data type
					                     else if((((MultExprContext)_localctx).a.theInfo.theType != ((MultExprContext)_localctx).b.theInfo.theType)  &&  (((MultExprContext)_localctx).a.theInfo.theType != Type.ERR) && (((MultExprContext)_localctx).b.theInfo.theType != Type.ERR))
					                     {
					                        // System.out.println(((MultExprContext)_localctx).a.theInfo.theType + " " +((MultExprContext)_localctx).b.theInfo.theType);
					                        System.out.println("Error: " + (((MultExprContext)_localctx).a!=null?(((MultExprContext)_localctx).a.start):null).getLine() + ": Type mismatch for the + operation in an expression.");
					                        ((MultExprContext)_localctx).a.theInfo.theType = Type.ERR;
					                        System.exit(0);
					                     }
					      
					}
					break;
				case T__10:
					{
					setState(209);
					match(T__10);
					setState(210);
					((MultExprContext)_localctx).c = signExpr();

					                     // similar to arith_expression, but change add and fadd with sdiv and fdiv
						                  // We need to do type checking first.
					                     // ...
										  
					                     // code generation.	
					                     //  INT				   
					                     if ((((MultExprContext)_localctx).a.theInfo.theType == Type.INT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     } 
					                     else if ((((MultExprContext)_localctx).a.theInfo.theType == Type.INT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.CONST_INT)) 
					                     {
					                        TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + _localctx.theInfo.theVar.varIndex + ", " + ((MultExprContext)_localctx).b.theInfo.theVar.iValue);
										   
										         // Update arith_expression's theInfo.
										         _localctx.theInfo.theType = Type.INT;
										         _localctx.theInfo.theVar.varIndex = varCount;
										         varCount ++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = sdiv i32 " + _localctx.theInfo.theVar.iValue + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
						                  else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_INT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.CONST_INT))
					                     {
						                     TextCode.add("\t\%t" + varCount + " = sdiv i32 " + _localctx.theInfo.theVar.iValue + ", " + ((MultExprContext)_localctx).b.theInfo.theVar.iValue);
					            
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.INT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // FLOAT
						                  else if((((MultExprContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.FLOAT))
					                     {
					                        TextCode.add("\t\%t" + varCount + " = fdiv float \%t" + _localctx.theInfo.theVar.varIndex + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     } 
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.FLOAT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val2 = ((MultExprContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fdiv float \%t" + _localctx.theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.CONST_FLOAT))
					                     {
					                        double val1 = ((MultExprContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        double val2 = ((MultExprContext)_localctx).b.theInfo.theVar.fValue;
					                        long ans2 = Double.doubleToLongBits(val2);
					                        TextCode.add("\t\%t" + varCount + " = fdiv float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     else if((((MultExprContext)_localctx).a.theInfo.theType == Type.CONST_FLOAT) && (((MultExprContext)_localctx).c.theInfo.theType == Type.FLOAT))
					                     {
					                        double val1 = ((MultExprContext)_localctx).a.theInfo.theVar.fValue;
					                        long ans1 = Double.doubleToLongBits(val1);
					                        TextCode.add("\t\%t" + varCount + " = fdiv float 0x" + Long.toHexString(ans1) + ", \%t" + ((MultExprContext)_localctx).b.theInfo.theVar.varIndex);
					                     
					                        // Update arith_expression's theInfo.
					                        _localctx.theInfo.theType = Type.FLOAT;
					                        _localctx.theInfo.theVar.varIndex = varCount;
					                        varCount++;
					                     }
					                     // different data type
					                     else if((((MultExprContext)_localctx).a.theInfo.theType != ((MultExprContext)_localctx).c.theInfo.theType)  &&  (((MultExprContext)_localctx).a.theInfo.theType != Type.ERR) && (((MultExprContext)_localctx).c.theInfo.theType != Type.ERR))
					                     {
					                        // System.out.println(((MultExprContext)_localctx).a.theInfo.theType + " " +((MultExprContext)_localctx).b.theInfo.theType);
					                        System.out.println("Error: " + (((MultExprContext)_localctx).a!=null?(((MultExprContext)_localctx).a.start):null).getLine() + ": Type mismatch for the + operation in an expression.");
					                        ((MultExprContext)_localctx).a.theInfo.theType = Type.ERR;
					                        System.exit(0);
					                     }
					      
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignExprContext extends ParserRuleContext {
		public Info theInfo;
		public PrimaryExprContext a;
		public PrimaryExprContext b;
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public SignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signExpr; }
	}

	public final SignExprContext signExpr() throws RecognitionException {
		SignExprContext _localctx = new SignExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_signExpr);
		((SignExprContext)_localctx).theInfo =  new Info();
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case Identifier:
			case Integer_constant:
			case Floating_point_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				((SignExprContext)_localctx).a = primaryExpr();
				 ((SignExprContext)_localctx).theInfo = ((SignExprContext)_localctx).a.theInfo; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(T__8);
				setState(222);
				((SignExprContext)_localctx).b = primaryExpr();

				      ((SignExprContext)_localctx).theInfo =  ((SignExprContext)_localctx).b.theInfo;
				      if(_localctx.theInfo.theType == Type.INT || _localctx.theInfo.theType == Type.CONST_INT)
				      {
				         _localctx.theInfo.theVar.iValue *= -1;
				         if(TRACEON) System.out.println("signExpr :" + _localctx.theInfo.theVar.iValue);
				      }
				      else if(_localctx.theInfo.theType == Type.FLOAT || _localctx.theInfo.theType == Type.CONST_FLOAT)
				      {
				         _localctx.theInfo.theVar.fValue *= 1;
				         if(TRACEON) System.out.println("signExpr :" + _localctx.theInfo.theVar.fValue);
				      }
				   
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public Info theInfo;
		public TerminalNode Integer_constant() { return getToken(myCompilerParser.Integer_constant, 0); }
		public TerminalNode Floating_point_constant() { return getToken(myCompilerParser.Floating_point_constant, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExpr);
		((PrimaryExprContext)_localctx).theInfo =  new Info();
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(Integer_constant);

				      _localctx.theInfo.theType = Type.CONST_INT;
						_localctx.theInfo.theVar.iValue = Integer.parseInt((((PrimaryExprContext)_localctx).Integer_constant!=null?((PrimaryExprContext)_localctx).Integer_constant.getText():null));
				   
				}
				break;
			case Floating_point_constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(Floating_point_constant);

				      _localctx.theInfo.theType = Type.CONST_FLOAT;
					   _localctx.theInfo.theVar.fValue = Float.parseFloat((((PrimaryExprContext)_localctx).Floating_point_constant!=null?((PrimaryExprContext)_localctx).Floating_point_constant.getText():null));
				   
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				match(Identifier);

				               // get type information from symtab.
				               Type the_type = symtab.get((((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null)).theType;
								   _localctx.theInfo.theType = the_type;

				               // get variable index from symtab.
				               int vIndex = symtab.get((((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null)).theVar.varIndex;
								
				               switch (the_type) {
				               case INT: 
				                  // get a new temporary variable and
										// load the variable into the temporary variable.
				                         
										// Ex: \%tx = load i32, i32* \%ty.
										TextCode.add("\%t" + varCount + "=load i32, i32* \%t" + vIndex);
								         
										// Now, Identifier's value is at the temporary variable \%t[varCount].
										// Therefore, update it.
										_localctx.theInfo.theVar.varIndex = varCount;
										varCount ++;
				                  break;
				               case FLOAT:
					               // get a new temporary variable and
										// load the variable into the temporary variable.
				                         
										// Ex: \%tx = load i32, i32* \%ty.
										TextCode.add("\%t" + varCount + "=load float, float* \%t" + vIndex);
								         
										// Now, Identifier's value is at the temporary variable \%t[varCount].
										// Therefore, update it.
										_localctx.theInfo.theVar.varIndex = varCount;
										varCount ++;
				                  break;
				               case CHAR:
					               // get a new temporary variable and
										// load the variable into the temporary variable.
				                         
										// Ex: \%tx = load i32, i32* \%ty.
										TextCode.add("\%t" + varCount + "=load i8, i8* \%t" + vIndex);
								         
										// Now, Identifier's value is at the temporary variable \%t[varCount].
										// Therefore, update it.
										_localctx.theInfo.theVar.varIndex = varCount;
										varCount ++;
				                  break;
							
				                }
				              
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(T__11);
				setState(234);
				match(Identifier);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				match(T__0);
				setState(236);
				arith_expression();
				setState(237);
				match(T__1);
				((PrimaryExprContext)_localctx).theInfo =  ((PrimaryExprContext)_localctx).arith_expression.theInfo;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u0084\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u009b\n\17\f\17\16\17\u009e\13\17\3\20\3\20"+
		"\3\20\3\20\5\20\u00a4\n\20\3\21\3\21\3\21\3\21\7\21\u00aa\n\21\f\21\16"+
		"\21\u00ad\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00bd\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00c9\n\23\f\23\16\23\u00cc\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d8\n\24\f\24\16\24\u00db\13\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e4\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f3\n\26\3\26\2\2"+
		"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\2\2\u00fa\2,\3\2\2"+
		"\2\4>\3\2\2\2\6F\3\2\2\2\bL\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16d\3\2\2\2"+
		"\20r\3\2\2\2\22v\3\2\2\2\24\u0083\3\2\2\2\26\u0085\3\2\2\2\30\u008a\3"+
		"\2\2\2\32\u008f\3\2\2\2\34\u0094\3\2\2\2\36\u00a3\3\2\2\2 \u00a5\3\2\2"+
		"\2\"\u00bc\3\2\2\2$\u00be\3\2\2\2&\u00cd\3\2\2\2(\u00e3\3\2\2\2*\u00f2"+
		"\3\2\2\2,-\7\23\2\2-.\7\22\2\2./\7\3\2\2/\60\7\4\2\2\60\61\b\2\1\2\61"+
		"\62\7\5\2\2\62\63\5\4\3\2\63\64\5\b\5\2\64\65\7\6\2\2\65\66\b\2\1\2\66"+
		"\3\3\2\2\2\678\5\6\4\289\7!\2\29:\7\7\2\2:;\5\4\3\2;<\b\3\1\2<?\3\2\2"+
		"\2=?\b\3\1\2>\67\3\2\2\2>=\3\2\2\2?\5\3\2\2\2@A\7\20\2\2AG\b\4\1\2BC\7"+
		"\21\2\2CG\b\4\1\2DE\7\17\2\2EG\b\4\1\2F@\3\2\2\2FB\3\2\2\2FD\3\2\2\2G"+
		"\7\3\2\2\2HI\5\n\6\2IJ\5\b\5\2JM\3\2\2\2KM\3\2\2\2LH\3\2\2\2LK\3\2\2\2"+
		"M\t\3\2\2\2NO\5\30\r\2OP\7\7\2\2PX\3\2\2\2QX\5\20\t\2RS\5\32\16\2ST\7"+
		"\7\2\2TX\3\2\2\2UX\5\16\b\2VX\5\f\7\2WN\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WU"+
		"\3\2\2\2WV\3\2\2\2X\13\3\2\2\2YZ\7\35\2\2Z[\7\3\2\2[^\7$\2\2\\]\7\b\2"+
		"\2]_\5\34\17\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\4\2\2ab\7\7\2\2bc\b"+
		"\7\1\2c\r\3\2\2\2de\7\26\2\2ef\7\3\2\2fg\5\30\r\2gh\7\7\2\2hi\b\b\1\2"+
		"ij\5 \21\2jk\7\7\2\2kl\b\b\1\2lm\5\30\r\2mn\b\b\1\2no\7\4\2\2op\5\26\f"+
		"\2pq\b\b\1\2q\17\3\2\2\2rs\5\22\n\2st\5\24\13\2tu\b\t\1\2u\21\3\2\2\2"+
		"vw\7\24\2\2wx\7\3\2\2xy\5 \21\2yz\b\n\1\2z{\7\4\2\2{|\5\26\f\2|}\b\n\1"+
		"\2}\23\3\2\2\2~\177\7\25\2\2\177\u0080\5\26\f\2\u0080\u0081\b\13\1\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0084\3\2\2\2\u0083~\3\2\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\25\3\2\2\2\u0085\u0086\7\5\2\2\u0086\u0087\5\b\5\2\u0087\u0088"+
		"\7\6\2\2\u0088\u0089\b\f\1\2\u0089\27\3\2\2\2\u008a\u008b\7!\2\2\u008b"+
		"\u008c\7\t\2\2\u008c\u008d\5$\23\2\u008d\u008e\b\r\1\2\u008e\31\3\2\2"+
		"\2\u008f\u0090\7!\2\2\u0090\u0091\7\3\2\2\u0091\u0092\5\34\17\2\u0092"+
		"\u0093\7\4\2\2\u0093\33\3\2\2\2\u0094\u0095\5\36\20\2\u0095\u009c\b\17"+
		"\1\2\u0096\u0097\7\b\2\2\u0097\u0098\5\36\20\2\u0098\u0099\b\17\1\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0096\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\35\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0"+
		"\5$\23\2\u00a0\u00a1\b\20\1\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\7$\2\2\u00a3"+
		"\u009f\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\37\3\2\2\2\u00a5\u00ab\5$\23"+
		"\2\u00a6\u00a7\5\"\22\2\u00a7\u00a8\5$\23\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\b\21\1\2\u00af"+
		"!\3\2\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00bd\b\22\1\2\u00b2\u00b3\7\31\2"+
		"\2\u00b3\u00bd\b\22\1\2\u00b4\u00b5\7\30\2\2\u00b5\u00bd\b\22\1\2\u00b6"+
		"\u00b7\7\32\2\2\u00b7\u00bd\b\22\1\2\u00b8\u00b9\7\33\2\2\u00b9\u00bd"+
		"\b\22\1\2\u00ba\u00bb\7\34\2\2\u00bb\u00bd\b\22\1\2\u00bc\u00b0\3\2\2"+
		"\2\u00bc\u00b2\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bc\u00b8"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd#\3\2\2\2\u00be\u00bf\5&\24\2\u00bf"+
		"\u00ca\b\23\1\2\u00c0\u00c1\7\n\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3\b"+
		"\23\1\2\u00c3\u00c9\3\2\2\2\u00c4\u00c5\7\13\2\2\u00c5\u00c6\5&\24\2\u00c6"+
		"\u00c7\b\23\1\2\u00c7\u00c9\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c4\3"+
		"\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"%\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\5(\25\2\u00ce\u00d9\b\24\1\2"+
		"\u00cf\u00d0\7\f\2\2\u00d0\u00d1\5(\25\2\u00d1\u00d2\b\24\1\2\u00d2\u00d8"+
		"\3\2\2\2\u00d3\u00d4\7\r\2\2\u00d4\u00d5\5(\25\2\u00d5\u00d6\b\24\1\2"+
		"\u00d6\u00d8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\u00db"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\'\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\5*\26\2\u00dd\u00de\b\25\1\2\u00de\u00e4\3"+
		"\2\2\2\u00df\u00e0\7\13\2\2\u00e0\u00e1\5*\26\2\u00e1\u00e2\b\25\1\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4)\3\2\2\2"+
		"\u00e5\u00e6\7\"\2\2\u00e6\u00f3\b\26\1\2\u00e7\u00e8\7#\2\2\u00e8\u00f3"+
		"\b\26\1\2\u00e9\u00ea\7!\2\2\u00ea\u00f3\b\26\1\2\u00eb\u00ec\7\16\2\2"+
		"\u00ec\u00f3\7!\2\2\u00ed\u00ee\7\3\2\2\u00ee\u00ef\5$\23\2\u00ef\u00f0"+
		"\7\4\2\2\u00f0\u00f1\b\26\1\2\u00f1\u00f3\3\2\2\2\u00f2\u00e5\3\2\2\2"+
		"\u00f2\u00e7\3\2\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00eb\3\2\2\2\u00f2\u00ed"+
		"\3\2\2\2\u00f3+\3\2\2\2\22>FLW^\u0083\u009c\u00a3\u00ab\u00bc\u00c8\u00ca"+
		"\u00d7\u00d9\u00e3\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}