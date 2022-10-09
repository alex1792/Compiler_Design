// Generated from /home/alex/compiler_design/project02/example/output/myparser.g by ANTLR 4.8

    // import packages here.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myparserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, FLOAT=9, 
		INT=10, CHAR=11, DOUBLE=12, MAIN=13, VOID=14, IF=15, ELSE=16, FOR=17, 
		WHILE=18, RETURN=19, BREAK=20, CONTINUE=21, PRINTF=22, SCANF=23, MALLOC=24, 
		SIZEOF=25, Identifier=26, Integer_constant=27, Floating_point_constant=28, 
		WS=29, COMMENT=30, LESS=31, GREATER=32, LE_EQ=33, GR_EQ=34, NOT_EQ=35, 
		EQ=36, NOT=37, AND=38, OR=39, AND_AND=40, OR_OR=41, ADD=42, MINUS=43, 
		BSLASH=44, SLASH=45, LEFT_BRACE=46, RIGHT_BRACE=47, LEFT_PAREN=48, RIGHT_PAREN=49, 
		LEFT_BRACKET=50, RIGHT_BRACKET=51;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_type = 2, RULE_statements = 3, 
		RULE_arith_expression = 4, RULE_multExpr = 5, RULE_signExpr = 6, RULE_logic_expression = 7, 
		RULE_logic_operator = 8, RULE_primaryExpr = 9, RULE_assignment_statement = 10, 
		RULE_function_statememt = 11, RULE_argument_expression = 12, RULE_statement = 13, 
		RULE_if_then_statements = 14, RULE_else_statements = 15, RULE_loop_control_statement = 16, 
		RULE_return_statememt = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "type", "statements", "arith_expression", 
			"multExpr", "signExpr", "logic_expression", "logic_operator", "primaryExpr", 
			"assignment_statement", "function_statememt", "argument_expression", 
			"statement", "if_then_statements", "else_statements", "loop_control_statement", 
			"return_statememt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'+'", "'-'", "'*'", "'='", "'\"'", "'%'", "','", "'float'", 
			"'int'", "'char'", "'double'", "'main'", "'void'", "'if'", "'else'", 
			"'for'", "'while'", "'return'", "'break'", "'continue'", "'printf'", 
			"'scanf'", "'malloc'", "'sizeof'", null, null, null, null, null, "'<'", 
			"'>'", "'<='", "'>='", "'!='", "'=='", "'!'", "'&'", "'|'", "'&&'", "'||'", 
			"'++'", "'--'", "'\\'", "'/'", "'{'", "'}'", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FLOAT", "INT", 
			"CHAR", "DOUBLE", "MAIN", "VOID", "IF", "ELSE", "FOR", "WHILE", "RETURN", 
			"BREAK", "CONTINUE", "PRINTF", "SCANF", "MALLOC", "SIZEOF", "Identifier", 
			"Integer_constant", "Floating_point_constant", "WS", "COMMENT", "LESS", 
			"GREATER", "LE_EQ", "GR_EQ", "NOT_EQ", "EQ", "NOT", "AND", "OR", "AND_AND", 
			"OR_OR", "ADD", "MINUS", "BSLASH", "SLASH", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET"
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
	public String getGrammarFileName() { return "myparser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    boolean TRACEON = true;

	public myparserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(myparserParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(myparserParser.MAIN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(myparserParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(myparserParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(myparserParser.LEFT_BRACE, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(myparserParser.RIGHT_BRACE, 0); }
		public TerminalNode INT() { return getToken(myparserParser.INT, 0); }
		public Return_statememtContext return_statememt() {
			return getRuleContext(Return_statememtContext.class,0);
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
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(VOID);
				setState(37);
				match(MAIN);
				setState(38);
				match(LEFT_PAREN);
				setState(39);
				match(RIGHT_PAREN);
				setState(40);
				match(LEFT_BRACE);
				setState(41);
				declarations();
				setState(42);
				statements();
				setState(43);
				match(RIGHT_BRACE);
				if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");
						
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(INT);
				setState(47);
				match(MAIN);
				setState(48);
				match(LEFT_PAREN);
				setState(49);
				match(RIGHT_PAREN);
				setState(50);
				match(LEFT_BRACE);
				setState(51);
				declarations();
				setState(52);
				statements();
				setState(53);
				return_statememt();
				setState(54);
				match(RIGHT_BRACE);
				if (TRACEON) System.out.println("INT MAIN () {declarations statements return_statement}");
					
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

	public static class DeclarationsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myparserParser.Identifier, 0); }
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
			case CHAR:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				type();
				setState(60);
				match(Identifier);
				setState(61);
				match(T__0);
				setState(62);
				declarations();
				 if (TRACEON) System.out.println("declarations: type Identifier : declarations"); 
						
				}
				break;
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case PRINTF:
			case SCANF:
			case MALLOC:
			case Identifier:
			case RIGHT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				 if (TRACEON) System.out.println("declarations: ");
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
		public TerminalNode INT() { return getToken(myparserParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(myparserParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(myparserParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(myparserParser.DOUBLE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(INT);
				 if (TRACEON) System.out.println("type: INT"); 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(FLOAT);
				if (TRACEON) System.out.println("type: FLOAT"); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(CHAR);
				if (TRACEON) System.out.println("type:CHAR"); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(DOUBLE);
				if (TRACEON) System.out.println("type: DOUBLE"); 
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case FOR:
			case WHILE:
			case PRINTF:
			case SCANF:
			case MALLOC:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				statement();
				setState(79);
				statements();
				}
				break;
			case RETURN:
			case RIGHT_BRACE:
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

	public static class Arith_expressionContext extends ParserRuleContext {
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(myparserParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(myparserParser.MINUS, 0); }
		public Arith_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression; }
	}

	public final Arith_expressionContext arith_expression() throws RecognitionException {
		Arith_expressionContext _localctx = new Arith_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arith_expression);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case Identifier:
			case Integer_constant:
			case Floating_point_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				multExpr();
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case RIGHT_PAREN:
					{
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1 || _la==T__2) {
						{
						setState(89);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__1:
							{
							setState(85);
							match(T__1);
							setState(86);
							multExpr();
							}
							break;
						case T__2:
							{
							setState(87);
							match(T__2);
							setState(88);
							multExpr();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(93);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ADD:
					{
					setState(94);
					match(ADD);
					}
					break;
				case MINUS:
					{
					setState(95);
					match(MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__0:
			case RIGHT_PAREN:
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

	public static class MultExprContext extends ParserRuleContext {
		public List<SignExprContext> signExpr() {
			return getRuleContexts(SignExprContext.class);
		}
		public SignExprContext signExpr(int i) {
			return getRuleContext(SignExprContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(myparserParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(myparserParser.SLASH, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			signExpr();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==SLASH) {
				{
				setState(106);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(102);
					match(T__3);
					setState(103);
					signExpr();
					}
					break;
				case SLASH:
					{
					setState(104);
					match(SLASH);
					setState(105);
					signExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(110);
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
		enterRule(_localctx, 12, RULE_signExpr);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer_constant:
			case Floating_point_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				primaryExpr();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(T__2);
				setState(113);
				primaryExpr();
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

	public static class Logic_expressionContext extends ParserRuleContext {
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public Logic_operatorContext logic_operator() {
			return getRuleContext(Logic_operatorContext.class,0);
		}
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logic_expression);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer_constant:
			case Floating_point_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				primaryExpr();
				setState(117);
				logic_operator();
				setState(118);
				primaryExpr();
				}
				break;
			case T__0:
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

	public static class Logic_operatorContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(myparserParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(myparserParser.GREATER, 0); }
		public TerminalNode LE_EQ() { return getToken(myparserParser.LE_EQ, 0); }
		public TerminalNode GR_EQ() { return getToken(myparserParser.GR_EQ, 0); }
		public TerminalNode NOT() { return getToken(myparserParser.NOT, 0); }
		public TerminalNode NOT_EQ() { return getToken(myparserParser.NOT_EQ, 0); }
		public Logic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_operator; }
	}

	public final Logic_operatorContext logic_operator() throws RecognitionException {
		Logic_operatorContext _localctx = new Logic_operatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LE_EQ) | (1L << GR_EQ) | (1L << NOT_EQ) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class PrimaryExprContext extends ParserRuleContext {
		public TerminalNode Integer_constant() { return getToken(myparserParser.Integer_constant, 0); }
		public TerminalNode Floating_point_constant() { return getToken(myparserParser.Floating_point_constant, 0); }
		public TerminalNode Identifier() { return getToken(myparserParser.Identifier, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(myparserParser.LEFT_PAREN, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(myparserParser.RIGHT_PAREN, 0); }
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primaryExpr);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(Integer_constant);
				}
				break;
			case Floating_point_constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(Floating_point_constant);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(Identifier);
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(LEFT_PAREN);
				setState(129);
				arith_expression();
				setState(130);
				match(RIGHT_PAREN);
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

	public static class Assignment_statementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(myparserParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(Identifier);
			setState(135);
			match(T__4);
			setState(136);
			arith_expression();
			setState(137);
			match(T__0);
			if (TRACEON) System.out.println("assignment_statememt: Idnetifier = arith_expression ;");
					
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

	public static class Function_statememtContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(myparserParser.PRINTF, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(myparserParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(myparserParser.LEFT_PAREN, i);
		}
		public Argument_expressionContext argument_expression() {
			return getRuleContext(Argument_expressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(myparserParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(myparserParser.RIGHT_PAREN, i);
		}
		public TerminalNode SCANF() { return getToken(myparserParser.SCANF, 0); }
		public TerminalNode MALLOC() { return getToken(myparserParser.MALLOC, 0); }
		public TerminalNode SIZEOF() { return getToken(myparserParser.SIZEOF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Integer_constant() { return getTokens(myparserParser.Integer_constant); }
		public TerminalNode Integer_constant(int i) {
			return getToken(myparserParser.Integer_constant, i);
		}
		public Function_statememtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_statememt; }
	}

	public final Function_statememtContext function_statememt() throws RecognitionException {
		Function_statememtContext _localctx = new Function_statememtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function_statememt);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTF:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(PRINTF);
				setState(141);
				match(LEFT_PAREN);
				setState(142);
				argument_expression();
				setState(143);
				match(RIGHT_PAREN);
				setState(144);
				match(T__0);
				if (TRACEON) System.out.println("function_statement: PRINTF ( argument_expression );");
						
				}
				break;
			case SCANF:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(SCANF);
				setState(148);
				match(LEFT_PAREN);
				setState(149);
				argument_expression();
				setState(150);
				match(RIGHT_PAREN);
				setState(151);
				match(T__0);
				}
				break;
			case MALLOC:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(MALLOC);
				setState(154);
				match(LEFT_PAREN);
				setState(166);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Integer_constant:
				case RIGHT_PAREN:
					{
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Integer_constant) {
						{
						{
						setState(155);
						match(Integer_constant);
						}
						}
						setState(160);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case SIZEOF:
					{
					{
					setState(161);
					match(SIZEOF);
					setState(162);
					match(LEFT_PAREN);
					setState(163);
					type();
					setState(164);
					match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(168);
				match(RIGHT_PAREN);
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

	public static class Argument_expressionContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(myparserParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myparserParser.Identifier, i);
		}
		public List<TerminalNode> WS() { return getTokens(myparserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(myparserParser.WS, i);
		}
		public List<TerminalNode> BSLASH() { return getTokens(myparserParser.BSLASH); }
		public TerminalNode BSLASH(int i) {
			return getToken(myparserParser.BSLASH, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(myparserParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(myparserParser.SLASH, i);
		}
		public List<TerminalNode> AND() { return getTokens(myparserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(myparserParser.AND, i);
		}
		public List<TerminalNode> LEFT_BRACKET() { return getTokens(myparserParser.LEFT_BRACKET); }
		public TerminalNode LEFT_BRACKET(int i) {
			return getToken(myparserParser.LEFT_BRACKET, i);
		}
		public List<TerminalNode> RIGHT_BRACKET() { return getTokens(myparserParser.RIGHT_BRACKET); }
		public TerminalNode RIGHT_BRACKET(int i) {
			return getToken(myparserParser.RIGHT_BRACKET, i);
		}
		public Argument_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_expression; }
	}

	public final Argument_expressionContext argument_expression() throws RecognitionException {
		Argument_expressionContext _localctx = new Argument_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argument_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__5);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << Identifier) | (1L << WS) | (1L << AND) | (1L << BSLASH) | (1L << SLASH) | (1L << LEFT_BRACKET) | (1L << RIGHT_BRACKET))) != 0)) {
				{
				{
				setState(172);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << Identifier) | (1L << WS) | (1L << AND) | (1L << BSLASH) | (1L << SLASH) | (1L << LEFT_BRACKET) | (1L << RIGHT_BRACKET))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(T__5);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(179);
				match(T__7);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << Identifier) | (1L << WS))) != 0)) {
					{
					{
					setState(180);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << Identifier) | (1L << WS))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(190);
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

	public static class StatementContext extends ParserRuleContext {
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public TerminalNode IF() { return getToken(myparserParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(myparserParser.LEFT_PAREN, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(myparserParser.RIGHT_PAREN, 0); }
		public If_then_statementsContext if_then_statements() {
			return getRuleContext(If_then_statementsContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(myparserParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(myparserParser.FOR, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Function_statememtContext function_statememt() {
			return getRuleContext(Function_statememtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				assignment_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(IF);
				if (TRACEON) System.out.println("statement: IF ( arith_esxpression ) if_then_statement");
						
				setState(194);
				match(LEFT_PAREN);
				setState(195);
				arith_expression();
				setState(196);
				match(RIGHT_PAREN);
				setState(197);
				if_then_statements();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(WHILE);
				if (TRACEON) System.out.println("statement: WHILE ( arith_esxpression ) if_then_statement");
						
				setState(201);
				match(LEFT_PAREN);
				setState(202);
				arith_expression();
				setState(203);
				match(RIGHT_PAREN);
				setState(204);
				if_then_statements();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				match(FOR);
				if (TRACEON) System.out.println("statement: FOR ( statement logic_expression; arith_expression ) if_then_statement");
						
				setState(208);
				match(LEFT_PAREN);
				setState(209);
				assignment_statement();
				setState(210);
				logic_expression();
				setState(211);
				match(T__0);
				setState(212);
				arith_expression();
				setState(213);
				match(RIGHT_PAREN);
				setState(214);
				if_then_statements();
				}
				break;
			case PRINTF:
			case SCANF:
			case MALLOC:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				function_statememt();
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

	public static class If_then_statementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(myparserParser.LEFT_BRACE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(myparserParser.RIGHT_BRACE, 0); }
		public Else_statementsContext else_statements() {
			return getRuleContext(Else_statementsContext.class,0);
		}
		public Loop_control_statementContext loop_control_statement() {
			return getRuleContext(Loop_control_statementContext.class,0);
		}
		public If_then_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_statements; }
	}

	public final If_then_statementsContext if_then_statements() throws RecognitionException {
		If_then_statementsContext _localctx = new If_then_statementsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if_then_statements);
		try {
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case FOR:
			case WHILE:
			case PRINTF:
			case SCANF:
			case MALLOC:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				statement();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(LEFT_BRACE);
				setState(221);
				statements();
				setState(222);
				match(RIGHT_BRACE);
				setState(223);
				else_statements();
				}
				break;
			case BREAK:
			case CONTINUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				loop_control_statement();
				setState(226);
				else_statements();
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

	public static class Else_statementsContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(myparserParser.ELSE, 0); }
		public If_then_statementsContext if_then_statements() {
			return getRuleContext(If_then_statementsContext.class,0);
		}
		public Else_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statements; }
	}

	public final Else_statementsContext else_statements() throws RecognitionException {
		Else_statementsContext _localctx = new Else_statementsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_else_statements);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(ELSE);
				setState(231);
				if_then_statements();
				if (TRACEON) System.out.println("else_statements: ELSE statement");
						
				}
				break;
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case PRINTF:
			case SCANF:
			case MALLOC:
			case Identifier:
			case RIGHT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				if (TRACEON) System.out.println("else_statements: ");
						
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

	public static class Loop_control_statementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(myparserParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(myparserParser.CONTINUE, 0); }
		public Loop_control_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_control_statement; }
	}

	public final Loop_control_statementContext loop_control_statement() throws RecognitionException {
		Loop_control_statementContext _localctx = new Loop_control_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loop_control_statement);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(BREAK);
				setState(238);
				match(T__0);
				if (TRACEON) System.out.println("loop_control_statement: BREAK;");
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(CONTINUE);
				setState(241);
				match(T__0);
				if (TRACEON) System.out.println("loop_control_statement: CONTINUE;");
							
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

	public static class Return_statememtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(myparserParser.RETURN, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Return_statememtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statememt; }
	}

	public final Return_statememtContext return_statememt() throws RecognitionException {
		Return_statememtContext _localctx = new Return_statememtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_statememt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(RETURN);
			setState(246);
			arith_expression();
			setState(247);
			match(T__0);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u00fc\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3E\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3\5\3\5\5\5U\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6\5\6c\n\6\3\6\5\6f\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\b\3\b\3\b\5\bu\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0087\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009f\n\r\f\r\16\r\u00a2\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00a9\n\r\3\r\5\r\u00ac\n\r\3\16\3\16\7\16\u00b0"+
		"\n\16\f\16\16\16\u00b3\13\16\3\16\3\16\3\16\7\16\u00b8\n\16\f\16\16\16"+
		"\u00bb\13\16\7\16\u00bd\n\16\f\16\16\16\u00c0\13\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dc\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e7\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00ee\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f6\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2"+
		"\5\4\2!%\'\'\b\2\t\t\34\34\37\37((./\64\65\5\2\t\t\34\34\37\37\2\u010a"+
		"\2;\3\2\2\2\4D\3\2\2\2\6N\3\2\2\2\bT\3\2\2\2\ne\3\2\2\2\fg\3\2\2\2\16"+
		"t\3\2\2\2\20{\3\2\2\2\22}\3\2\2\2\24\u0086\3\2\2\2\26\u0088\3\2\2\2\30"+
		"\u00ab\3\2\2\2\32\u00ad\3\2\2\2\34\u00db\3\2\2\2\36\u00e6\3\2\2\2 \u00ed"+
		"\3\2\2\2\"\u00f5\3\2\2\2$\u00f7\3\2\2\2&\'\7\20\2\2\'(\7\17\2\2()\7\62"+
		"\2\2)*\7\63\2\2*+\7\60\2\2+,\5\4\3\2,-\5\b\5\2-.\7\61\2\2./\b\2\1\2/<"+
		"\3\2\2\2\60\61\7\f\2\2\61\62\7\17\2\2\62\63\7\62\2\2\63\64\7\63\2\2\64"+
		"\65\7\60\2\2\65\66\5\4\3\2\66\67\5\b\5\2\678\5$\23\289\7\61\2\29:\b\2"+
		"\1\2:<\3\2\2\2;&\3\2\2\2;\60\3\2\2\2<\3\3\2\2\2=>\5\6\4\2>?\7\34\2\2?"+
		"@\7\3\2\2@A\5\4\3\2AB\b\3\1\2BE\3\2\2\2CE\b\3\1\2D=\3\2\2\2DC\3\2\2\2"+
		"E\5\3\2\2\2FG\7\f\2\2GO\b\4\1\2HI\7\13\2\2IO\b\4\1\2JK\7\r\2\2KO\b\4\1"+
		"\2LM\7\16\2\2MO\b\4\1\2NF\3\2\2\2NH\3\2\2\2NJ\3\2\2\2NL\3\2\2\2O\7\3\2"+
		"\2\2PQ\5\34\17\2QR\5\b\5\2RU\3\2\2\2SU\3\2\2\2TP\3\2\2\2TS\3\2\2\2U\t"+
		"\3\2\2\2Vb\5\f\7\2WX\7\4\2\2X\\\5\f\7\2YZ\7\5\2\2Z\\\5\f\7\2[W\3\2\2\2"+
		"[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^c\3\2\2\2_]\3\2\2\2`c\7,\2\2"+
		"ac\7-\2\2b]\3\2\2\2b`\3\2\2\2ba\3\2\2\2cf\3\2\2\2df\3\2\2\2eV\3\2\2\2"+
		"ed\3\2\2\2f\13\3\2\2\2gn\5\16\b\2hi\7\6\2\2im\5\16\b\2jk\7/\2\2km\5\16"+
		"\b\2lh\3\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pn\3"+
		"\2\2\2qu\5\24\13\2rs\7\5\2\2su\5\24\13\2tq\3\2\2\2tr\3\2\2\2u\17\3\2\2"+
		"\2vw\5\24\13\2wx\5\22\n\2xy\5\24\13\2y|\3\2\2\2z|\3\2\2\2{v\3\2\2\2{z"+
		"\3\2\2\2|\21\3\2\2\2}~\t\2\2\2~\23\3\2\2\2\177\u0087\7\35\2\2\u0080\u0087"+
		"\7\36\2\2\u0081\u0087\7\34\2\2\u0082\u0083\7\62\2\2\u0083\u0084\5\n\6"+
		"\2\u0084\u0085\7\63\2\2\u0085\u0087\3\2\2\2\u0086\177\3\2\2\2\u0086\u0080"+
		"\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0082\3\2\2\2\u0087\25\3\2\2\2\u0088"+
		"\u0089\7\34\2\2\u0089\u008a\7\7\2\2\u008a\u008b\5\n\6\2\u008b\u008c\7"+
		"\3\2\2\u008c\u008d\b\f\1\2\u008d\27\3\2\2\2\u008e\u008f\7\30\2\2\u008f"+
		"\u0090\7\62\2\2\u0090\u0091\5\32\16\2\u0091\u0092\7\63\2\2\u0092\u0093"+
		"\7\3\2\2\u0093\u0094\b\r\1\2\u0094\u00ac\3\2\2\2\u0095\u0096\7\31\2\2"+
		"\u0096\u0097\7\62\2\2\u0097\u0098\5\32\16\2\u0098\u0099\7\63\2\2\u0099"+
		"\u009a\7\3\2\2\u009a\u00ac\3\2\2\2\u009b\u009c\7\32\2\2\u009c\u00a8\7"+
		"\62\2\2\u009d\u009f\7\35\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a9\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a3\u00a4\7\33\2\2\u00a4\u00a5\7\62\2\2\u00a5\u00a6\5\6\4\2\u00a6"+
		"\u00a7\7\63\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a3\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\7\63\2\2\u00ab\u008e\3\2\2\2\u00ab"+
		"\u0095\3\2\2\2\u00ab\u009b\3\2\2\2\u00ac\31\3\2\2\2\u00ad\u00b1\7\b\2"+
		"\2\u00ae\u00b0\t\3\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00be\7\b\2\2\u00b5\u00b9\7\n\2\2\u00b6\u00b8\t\4\2\2\u00b7\u00b6\3\2"+
		"\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\33\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00dc\5\26\f\2\u00c2\u00c3\7\21\2\2\u00c3\u00c4\b\17\1"+
		"\2\u00c4\u00c5\7\62\2\2\u00c5\u00c6\5\n\6\2\u00c6\u00c7\7\63\2\2\u00c7"+
		"\u00c8\5\36\20\2\u00c8\u00dc\3\2\2\2\u00c9\u00ca\7\24\2\2\u00ca\u00cb"+
		"\b\17\1\2\u00cb\u00cc\7\62\2\2\u00cc\u00cd\5\n\6\2\u00cd\u00ce\7\63\2"+
		"\2\u00ce\u00cf\5\36\20\2\u00cf\u00dc\3\2\2\2\u00d0\u00d1\7\23\2\2\u00d1"+
		"\u00d2\b\17\1\2\u00d2\u00d3\7\62\2\2\u00d3\u00d4\5\26\f\2\u00d4\u00d5"+
		"\5\20\t\2\u00d5\u00d6\7\3\2\2\u00d6\u00d7\5\n\6\2\u00d7\u00d8\7\63\2\2"+
		"\u00d8\u00d9\5\36\20\2\u00d9\u00dc\3\2\2\2\u00da\u00dc\5\30\r\2\u00db"+
		"\u00c1\3\2\2\2\u00db\u00c2\3\2\2\2\u00db\u00c9\3\2\2\2\u00db\u00d0\3\2"+
		"\2\2\u00db\u00da\3\2\2\2\u00dc\35\3\2\2\2\u00dd\u00e7\5\34\17\2\u00de"+
		"\u00df\7\60\2\2\u00df\u00e0\5\b\5\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2\5"+
		" \21\2\u00e2\u00e7\3\2\2\2\u00e3\u00e4\5\"\22\2\u00e4\u00e5\5 \21\2\u00e5"+
		"\u00e7\3\2\2\2\u00e6\u00dd\3\2\2\2\u00e6\u00de\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e7\37\3\2\2\2\u00e8\u00e9\7\22\2\2\u00e9\u00ea\5\36\20\2\u00ea"+
		"\u00eb\b\21\1\2\u00eb\u00ee\3\2\2\2\u00ec\u00ee\b\21\1\2\u00ed\u00e8\3"+
		"\2\2\2\u00ed\u00ec\3\2\2\2\u00ee!\3\2\2\2\u00ef\u00f0\7\26\2\2\u00f0\u00f1"+
		"\7\3\2\2\u00f1\u00f6\b\22\1\2\u00f2\u00f3\7\27\2\2\u00f3\u00f4\7\3\2\2"+
		"\u00f4\u00f6\b\22\1\2\u00f5\u00ef\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f6#\3"+
		"\2\2\2\u00f7\u00f8\7\25\2\2\u00f8\u00f9\5\n\6\2\u00f9\u00fa\7\3\2\2\u00fa"+
		"%\3\2\2\2\31;DNT[]belnt{\u0086\u00a0\u00a8\u00ab\u00b1\u00b9\u00be\u00db"+
		"\u00e6\u00ed\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}