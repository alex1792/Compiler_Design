// Generated from /home/alex/compiler_design/project03/output/myparser.g by ANTLR 4.8

    import java.util.HashMap;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, FLOAT=8, INT=9, 
		CHAR=10, DOUBLE=11, MAIN=12, VOID=13, IF=14, ELSE=15, FOR=16, WHILE=17, 
		RETURN=18, BREAK=19, CONTINUE=20, PRINTF=21, SCANF=22, MALLOC=23, SIZEOF=24, 
		Identifier=25, Integer_constant=26, Floating_point_constant=27, WS=28, 
		COMMENT=29, LESS=30, GREATER=31, LE_EQ=32, GR_EQ=33, NOT_EQ=34, EQ=35, 
		NOT=36, AND=37, OR=38, AND_AND=39, OR_OR=40, ADD=41, MINUS=42, BSLASH=43, 
		SLASH=44, LEFT_BRACE=45, RIGHT_BRACE=46, LEFT_PAREN=47, RIGHT_PAREN=48, 
		LEFT_BRACKET=49, RIGHT_BRACKET=50, PerD=51, PerC=52, PerS=53, PerF=54;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_type = 2, RULE_statements = 3, 
		RULE_arith_expression = 4, RULE_multExpr = 5, RULE_signExpr = 6, RULE_logic_expression = 7, 
		RULE_logic_operator = 8, RULE_primaryExpr = 9, RULE_assignment_statement = 10, 
		RULE_function_statememt = 11, RULE_argument_expression = 12, RULE_printf_argument_expression = 13, 
		RULE_string_constant = 14, RULE_io_data_type = 15, RULE_statement = 16, 
		RULE_if_then_statements = 17, RULE_else_statements = 18, RULE_loop_control_statement = 19, 
		RULE_return_statememt = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "type", "statements", "arith_expression", 
			"multExpr", "signExpr", "logic_expression", "logic_operator", "primaryExpr", 
			"assignment_statement", "function_statememt", "argument_expression", 
			"printf_argument_expression", "string_constant", "io_data_type", "statement", 
			"if_then_statements", "else_statements", "loop_control_statement", "return_statememt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'+'", "'-'", "'*'", "'='", "'"'", "'float'", "'int'", 
			"'char'", "'double'", "'main'", "'void'", "'if'", "'else'", "'for'", 
			"'while'", "'return'", "'break'", "'continue'", "'printf'", "'scanf'", 
			"'malloc'", "'sizeof'", null, null, null, null, null, "'<'", "'>'", "'<='", 
			"'>='", "'!='", "'=='", "'!'", "'&'", "'|'", "'&&'", "'||'", "'++'", 
			"'--'", "'\\'", "'/'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'%d'", 
			"'%c'", "'%s'", "'%f'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "FLOAT", "INT", "CHAR", 
			"DOUBLE", "MAIN", "VOID", "IF", "ELSE", "FOR", "WHILE", "RETURN", "BREAK", 
			"CONTINUE", "PRINTF", "SCANF", "MALLOC", "SIZEOF", "Identifier", "Integer_constant", 
			"Floating_point_constant", "WS", "COMMENT", "LESS", "GREATER", "LE_EQ", 
			"GR_EQ", "NOT_EQ", "EQ", "NOT", "AND", "OR", "AND_AND", "OR_OR", "ADD", 
			"MINUS", "BSLASH", "SLASH", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", 
			"RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", "PerD", "PerC", "PerS", 
			"PerF"
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
		HashMap memory = new HashMap();
		// String s = "";

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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(VOID);
				setState(43);
				match(MAIN);
				setState(44);
				match(LEFT_PAREN);
				setState(45);
				match(RIGHT_PAREN);
				setState(46);
				match(LEFT_BRACE);
				setState(47);
				declarations();
				setState(48);
				statements();
				setState(49);
				match(RIGHT_BRACE);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(INT);
				setState(52);
				match(MAIN);
				setState(53);
				match(LEFT_PAREN);
				setState(54);
				match(RIGHT_PAREN);
				setState(55);
				match(LEFT_BRACE);
				setState(56);
				declarations();
				setState(57);
				statements();
				setState(58);
				return_statememt();
				setState(59);
				match(RIGHT_BRACE);
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
		public List<TerminalNode> Identifier() { return getTokens(myparserParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myparserParser.Identifier, i);
		}
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
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
			case CHAR:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				type();
				setState(64);
				match(Identifier);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(65);
					match(T__0);
					setState(66);
					match(Identifier);
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(T__1);
				setState(73);
				declarations();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE))) != 0)) ) {
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
			setState(84);
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
				setState(80);
				statement();
				setState(81);
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
		public int value;
		public MultExprContext a;
		public MultExprContext b;
		public MultExprContext c;
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
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case Identifier:
			case Integer_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				((Arith_expressionContext)_localctx).a = multExpr();
				if (TRACEON) ((Arith_expressionContext)_localctx).value =  ((Arith_expressionContext)_localctx).a.value;
				setState(103);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__2:
				case T__3:
				case RIGHT_PAREN:
					{
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2 || _la==T__3) {
						{
						setState(96);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__2:
							{
							setState(88);
							match(T__2);
							setState(89);
							((Arith_expressionContext)_localctx).b = multExpr();
							if (TRACEON)((Arith_expressionContext)_localctx).value =  _localctx.value + ((Arith_expressionContext)_localctx).b.value;
							}
							break;
						case T__3:
							{
							setState(92);
							match(T__3);
							setState(93);
							((Arith_expressionContext)_localctx).c = multExpr();
							if (TRACEON)((Arith_expressionContext)_localctx).value =  _localctx.value - ((Arith_expressionContext)_localctx).c.value;
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(100);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ADD:
					{
					setState(101);
					match(ADD);
					}
					break;
				case MINUS:
					{
					setState(102);
					match(MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__1:
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
		public int value;
		public SignExprContext a;
		public SignExprContext b;
		public SignExprContext c;
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
			setState(108);
			((MultExprContext)_localctx).a = signExpr();
			if (TRACEON) ((MultExprContext)_localctx).value =  ((MultExprContext)_localctx).a.value;
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==SLASH) {
				{
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(110);
					match(T__4);
					setState(111);
					((MultExprContext)_localctx).b = signExpr();
					if (TRACEON) ((MultExprContext)_localctx).value =  _localctx.value * ((MultExprContext)_localctx).b.value;
					}
					break;
				case SLASH:
					{
					setState(114);
					match(SLASH);
					setState(115);
					((MultExprContext)_localctx).c = signExpr();
					if (TRACEON) ((MultExprContext)_localctx).value =  _localctx.value / ((MultExprContext)_localctx).c.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(122);
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
		public int value;
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
		enterRule(_localctx, 12, RULE_signExpr);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((SignExprContext)_localctx).a = primaryExpr();
				if (TRACEON) ((SignExprContext)_localctx).value =  ((SignExprContext)_localctx).a.value;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__3);
				setState(127);
				((SignExprContext)_localctx).b = primaryExpr();
				if (TRACEON) ((SignExprContext)_localctx).value =  -((SignExprContext)_localctx).b.value;
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
		public PrimaryExprContext a;
		public PrimaryExprContext b;
		public Logic_operatorContext logic_operator() {
			return getRuleContext(Logic_operatorContext.class,0);
		}
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
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
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer_constant:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				((Logic_expressionContext)_localctx).a = primaryExpr();
				setState(133);
				logic_operator();
				setState(134);
				((Logic_expressionContext)_localctx).b = primaryExpr();

						TRACEON = true;
						if (((Logic_expressionContext)_localctx).logic_operator.value == 1)
				{if (((Logic_expressionContext)_localctx).a.value >= ((Logic_expressionContext)_localctx).b.value) TRACEON = false;}
				else if(((Logic_expressionContext)_localctx).logic_operator.value == 2)
				{if (((Logic_expressionContext)_localctx).a.value <= ((Logic_expressionContext)_localctx).b.value) TRACEON = false;}
				else if(((Logic_expressionContext)_localctx).logic_operator.value == 3)
				{if (((Logic_expressionContext)_localctx).a.value > ((Logic_expressionContext)_localctx).b.value) TRACEON = false;}
				else if(((Logic_expressionContext)_localctx).logic_operator.value == 4)
				{if (((Logic_expressionContext)_localctx).a.value < ((Logic_expressionContext)_localctx).b.value) TRACEON = false;}
					else if(((Logic_expressionContext)_localctx).logic_operator.value == 5)
				{if (((Logic_expressionContext)_localctx).a.value == ((Logic_expressionContext)_localctx).b.value) TRACEON = false;}

				}
				break;
			case T__1:
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

	public static class Logic_operatorContext extends ParserRuleContext {
		public int value;
		public TerminalNode LESS() { return getToken(myparserParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(myparserParser.GREATER, 0); }
		public TerminalNode LE_EQ() { return getToken(myparserParser.LE_EQ, 0); }
		public TerminalNode GR_EQ() { return getToken(myparserParser.GR_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(myparserParser.NOT_EQ, 0); }
		public Logic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_operator; }
	}

	public final Logic_operatorContext logic_operator() throws RecognitionException {
		Logic_operatorContext _localctx = new Logic_operatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logic_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LESS:
				{
				setState(140);
				match(LESS);
				((Logic_operatorContext)_localctx).value =  1;
				}
				break;
			case GREATER:
				{
				setState(142);
				match(GREATER);
				((Logic_operatorContext)_localctx).value =  2;
				}
				break;
			case LE_EQ:
				{
				setState(144);
				match(LE_EQ);
				((Logic_operatorContext)_localctx).value =  3;
				}
				break;
			case GR_EQ:
				{
				setState(146);
				match(GR_EQ);
				((Logic_operatorContext)_localctx).value =  4;
				}
				break;
			case NOT_EQ:
				{
				setState(148);
				match(NOT_EQ);
				((Logic_operatorContext)_localctx).value =  5;
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public int value;
		public TerminalNode Integer_constant() { return getToken(myparserParser.Integer_constant, 0); }
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
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(Integer_constant);
				((PrimaryExprContext)_localctx).value =  Integer.parseInt((((PrimaryExprContext)_localctx).Integer_constant!=null?((PrimaryExprContext)_localctx).Integer_constant.getText():null));
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(Identifier);
				Integer v = (Integer)memory.get((((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null));
				        if ( v!=null ) ((PrimaryExprContext)_localctx).value =  v.intValue();
				        else System.err.println("undefined variable "+(((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null));
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				match(LEFT_PAREN);
				setState(157);
				arith_expression();
				setState(158);
				match(RIGHT_PAREN);
				((PrimaryExprContext)_localctx).value =  ((PrimaryExprContext)_localctx).arith_expression.value;
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
			setState(163);
			match(Identifier);
			setState(164);
			match(T__5);
			setState(165);
			arith_expression();
			if (TRACEON) System.out.println(((Assignment_statementContext)_localctx).arith_expression.value);
			setState(167);
			match(T__1);
			if (TRACEON) memory.put((((Assignment_statementContext)_localctx).Identifier!=null?((Assignment_statementContext)_localctx).Identifier.getText():null), new Integer(((Assignment_statementContext)_localctx).arith_expression.value));
					
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
		public Printf_argument_expressionContext printf_argument_expression() {
			return getRuleContext(Printf_argument_expressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(myparserParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(myparserParser.RIGHT_PAREN, i);
		}
		public TerminalNode SCANF() { return getToken(myparserParser.SCANF, 0); }
		public Argument_expressionContext argument_expression() {
			return getRuleContext(Argument_expressionContext.class,0);
		}
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
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTF:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(PRINTF);
				setState(171);
				match(LEFT_PAREN);
				setState(172);
				printf_argument_expression();
				setState(173);
				match(RIGHT_PAREN);
				setState(174);
				match(T__1);
				}
				break;
			case SCANF:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(SCANF);
				setState(177);
				match(LEFT_PAREN);
				setState(178);
				argument_expression();
				setState(179);
				match(RIGHT_PAREN);
				setState(180);
				match(T__1);
				}
				break;
			case MALLOC:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(MALLOC);
				setState(183);
				match(LEFT_PAREN);
				setState(195);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Integer_constant:
				case RIGHT_PAREN:
					{
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Integer_constant) {
						{
						{
						setState(184);
						match(Integer_constant);
						}
						}
						setState(189);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case SIZEOF:
					{
					{
					setState(190);
					match(SIZEOF);
					setState(191);
					match(LEFT_PAREN);
					setState(192);
					type();
					setState(193);
					match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(197);
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
		public String_constantContext string_constant() {
			return getRuleContext(String_constantContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myparserParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myparserParser.Identifier, i);
		}
		public List<TerminalNode> WS() { return getTokens(myparserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(myparserParser.WS, i);
		}
		public List<TerminalNode> AND() { return getTokens(myparserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(myparserParser.AND, i);
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
			setState(200);
			string_constant();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(201);
				match(T__0);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << WS) | (1L << AND))) != 0)) {
					{
					{
					setState(202);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << WS) | (1L << AND))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(212);
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

	public static class Printf_argument_expressionContext extends ParserRuleContext {
		public String_constantContext str;
		public String_constantContext string_constant() {
			return getRuleContext(String_constantContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myparserParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myparserParser.Identifier, i);
		}
		public List<TerminalNode> WS() { return getTokens(myparserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(myparserParser.WS, i);
		}
		public Printf_argument_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printf_argument_expression; }
	}

	public final Printf_argument_expressionContext printf_argument_expression() throws RecognitionException {
		Printf_argument_expressionContext _localctx = new Printf_argument_expressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_printf_argument_expression);
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((Printf_argument_expressionContext)_localctx).str = string_constant();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(214);
				match(T__0);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier || _la==WS) {
					{
					setState(218);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Identifier:
						{
						setState(215);
						match(Identifier);

									Integer v1 = (Integer)memory.get((((Printf_argument_expressionContext)_localctx).Identifier!=null?((Printf_argument_expressionContext)_localctx).Identifier.getText():null));
								buffer.add(v1.intValue());
						}
						break;
					case WS:
						{
						setState(217);
						match(WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			String s = new String((((Printf_argument_expressionContext)_localctx).str!=null?_input.getText(((Printf_argument_expressionContext)_localctx).str.start,((Printf_argument_expressionContext)_localctx).str.stop):null));
					s = s.substring(1, s.length() - 1);
					s = s.replace("\\n", "\n");
					for(int i = 0; i < buffer.size(); i++)
					{
						s = s.replace("\%d", (buffer.get(i)).toString());
					}
					System.out.println(s);
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

	public static class String_constantContext extends ParserRuleContext {
		public String_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_constant; }
	}

	public final String_constantContext string_constant() throws RecognitionException {
		String_constantContext _localctx = new String_constantContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_string_constant);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__6);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					matchWildcard();
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(237);
			match(T__6);
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

	public static class Io_data_typeContext extends ParserRuleContext {
		public TerminalNode PerC() { return getToken(myparserParser.PerC, 0); }
		public TerminalNode PerD() { return getToken(myparserParser.PerD, 0); }
		public TerminalNode PerF() { return getToken(myparserParser.PerF, 0); }
		public TerminalNode PerS() { return getToken(myparserParser.PerS, 0); }
		public Io_data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io_data_type; }
	}

	public final Io_data_typeContext io_data_type() throws RecognitionException {
		Io_data_typeContext _localctx = new Io_data_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_io_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PerD) | (1L << PerC) | (1L << PerS) | (1L << PerF))) != 0)) ) {
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

	public static class StatementContext extends ParserRuleContext {
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public TerminalNode IF() { return getToken(myparserParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(myparserParser.LEFT_PAREN, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(myparserParser.RIGHT_PAREN, 0); }
		public If_then_statementsContext if_then_statements() {
			return getRuleContext(If_then_statementsContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(myparserParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(myparserParser.FOR, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
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
		enterRule(_localctx, 32, RULE_statement);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				assignment_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(IF);
				setState(243);
				match(LEFT_PAREN);
				setState(244);
				logic_expression();
				System.out.println(TRACEON);
				setState(246);
				match(RIGHT_PAREN);
				setState(247);
				if_then_statements();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(WHILE);
				setState(250);
				match(LEFT_PAREN);
				setState(251);
				logic_expression();
				setState(252);
				match(RIGHT_PAREN);
				setState(253);
				if_then_statements();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				match(FOR);
				setState(256);
				match(LEFT_PAREN);
				setState(257);
				assignment_statement();
				setState(258);
				logic_expression();
				setState(259);
				match(T__1);
				setState(260);
				arith_expression();
				setState(261);
				match(RIGHT_PAREN);
				setState(262);
				if_then_statements();
				}
				break;
			case PRINTF:
			case SCANF:
			case MALLOC:
				enterOuterAlt(_localctx, 5);
				{
				setState(264);
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
		enterRule(_localctx, 34, RULE_if_then_statements);
		try {
			setState(276);
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
				setState(267);
				statement();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(LEFT_BRACE);
				setState(269);
				statements();
				setState(270);
				match(RIGHT_BRACE);
				setState(271);
				else_statements();
				}
				break;
			case BREAK:
			case CONTINUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				loop_control_statement();
				setState(274);
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
		enterRule(_localctx, 36, RULE_else_statements);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(ELSE);
				TRACEON = !TRACEON; System.out.println(TRACEON);
				setState(280);
				if_then_statements();
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
		enterRule(_localctx, 38, RULE_loop_control_statement);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(BREAK);
				setState(285);
				match(T__1);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(CONTINUE);
				setState(287);
				match(T__1);
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
		enterRule(_localctx, 40, RULE_return_statememt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(RETURN);
			setState(291);
			arith_expression();
			setState(292);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u0129\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2@\n\2\3\3\3\3\3\3\3"+
		"\3\7\3F\n\3\f\3\16\3I\13\3\3\3\3\3\3\3\3\3\5\3O\n\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\5\5W\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6c\n\6\f\6\16"+
		"\6f\13\6\3\6\3\6\5\6j\n\6\3\6\5\6m\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7y\n\7\f\7\16\7|\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0085"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008d\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0099\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00a4\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bc\n\r\f\r\16\r\u00bf\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00c6\n\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16\7\16"+
		"\u00ce\n\16\f\16\16\16\u00d1\13\16\7\16\u00d3\n\16\f\16\16\16\u00d6\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\7\17\u00dd\n\17\f\17\16\17\u00e0\13\17\7"+
		"\17\u00e2\n\17\f\17\16\17\u00e5\13\17\3\17\3\17\3\20\3\20\7\20\u00eb\n"+
		"\20\f\20\16\20\u00ee\13\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u010c\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0117\n\23\3\24\3\24\3\24\3\24\5\24\u011d\n\24\3"+
		"\25\3\25\3\25\3\25\5\25\u0123\n\25\3\26\3\26\3\26\3\26\3\26\2\2\27\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\5\3\2\n\r\5\2\33\33\36\36"+
		"\'\'\3\2\658\2\u0138\2?\3\2\2\2\4N\3\2\2\2\6P\3\2\2\2\bV\3\2\2\2\nl\3"+
		"\2\2\2\fn\3\2\2\2\16\u0084\3\2\2\2\20\u008c\3\2\2\2\22\u0098\3\2\2\2\24"+
		"\u00a3\3\2\2\2\26\u00a5\3\2\2\2\30\u00c8\3\2\2\2\32\u00ca\3\2\2\2\34\u00d7"+
		"\3\2\2\2\36\u00e8\3\2\2\2 \u00f1\3\2\2\2\"\u010b\3\2\2\2$\u0116\3\2\2"+
		"\2&\u011c\3\2\2\2(\u0122\3\2\2\2*\u0124\3\2\2\2,-\7\17\2\2-.\7\16\2\2"+
		"./\7\61\2\2/\60\7\62\2\2\60\61\7/\2\2\61\62\5\4\3\2\62\63\5\b\5\2\63\64"+
		"\7\60\2\2\64@\3\2\2\2\65\66\7\13\2\2\66\67\7\16\2\2\678\7\61\2\289\7\62"+
		"\2\29:\7/\2\2:;\5\4\3\2;<\5\b\5\2<=\5*\26\2=>\7\60\2\2>@\3\2\2\2?,\3\2"+
		"\2\2?\65\3\2\2\2@\3\3\2\2\2AB\5\6\4\2BG\7\33\2\2CD\7\3\2\2DF\7\33\2\2"+
		"EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\4\2\2"+
		"KL\5\4\3\2LO\3\2\2\2MO\3\2\2\2NA\3\2\2\2NM\3\2\2\2O\5\3\2\2\2PQ\t\2\2"+
		"\2Q\7\3\2\2\2RS\5\"\22\2ST\5\b\5\2TW\3\2\2\2UW\3\2\2\2VR\3\2\2\2VU\3\2"+
		"\2\2W\t\3\2\2\2XY\5\f\7\2Yi\b\6\1\2Z[\7\5\2\2[\\\5\f\7\2\\]\b\6\1\2]c"+
		"\3\2\2\2^_\7\6\2\2_`\5\f\7\2`a\b\6\1\2ac\3\2\2\2bZ\3\2\2\2b^\3\2\2\2c"+
		"f\3\2\2\2db\3\2\2\2de\3\2\2\2ej\3\2\2\2fd\3\2\2\2gj\7+\2\2hj\7,\2\2id"+
		"\3\2\2\2ig\3\2\2\2ih\3\2\2\2jm\3\2\2\2km\3\2\2\2lX\3\2\2\2lk\3\2\2\2m"+
		"\13\3\2\2\2no\5\16\b\2oz\b\7\1\2pq\7\7\2\2qr\5\16\b\2rs\b\7\1\2sy\3\2"+
		"\2\2tu\7.\2\2uv\5\16\b\2vw\b\7\1\2wy\3\2\2\2xp\3\2\2\2xt\3\2\2\2y|\3\2"+
		"\2\2zx\3\2\2\2z{\3\2\2\2{\r\3\2\2\2|z\3\2\2\2}~\5\24\13\2~\177\b\b\1\2"+
		"\177\u0085\3\2\2\2\u0080\u0081\7\6\2\2\u0081\u0082\5\24\13\2\u0082\u0083"+
		"\b\b\1\2\u0083\u0085\3\2\2\2\u0084}\3\2\2\2\u0084\u0080\3\2\2\2\u0085"+
		"\17\3\2\2\2\u0086\u0087\5\24\13\2\u0087\u0088\5\22\n\2\u0088\u0089\5\24"+
		"\13\2\u0089\u008a\b\t\1\2\u008a\u008d\3\2\2\2\u008b\u008d\3\2\2\2\u008c"+
		"\u0086\3\2\2\2\u008c\u008b\3\2\2\2\u008d\21\3\2\2\2\u008e\u008f\7 \2\2"+
		"\u008f\u0099\b\n\1\2\u0090\u0091\7!\2\2\u0091\u0099\b\n\1\2\u0092\u0093"+
		"\7\"\2\2\u0093\u0099\b\n\1\2\u0094\u0095\7#\2\2\u0095\u0099\b\n\1\2\u0096"+
		"\u0097\7$\2\2\u0097\u0099\b\n\1\2\u0098\u008e\3\2\2\2\u0098\u0090\3\2"+
		"\2\2\u0098\u0092\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\23\3\2\2\2\u009a\u009b\7\34\2\2\u009b\u00a4\b\13\1\2\u009c\u009d\7\33"+
		"\2\2\u009d\u00a4\b\13\1\2\u009e\u009f\7\61\2\2\u009f\u00a0\5\n\6\2\u00a0"+
		"\u00a1\7\62\2\2\u00a1\u00a2\b\13\1\2\u00a2\u00a4\3\2\2\2\u00a3\u009a\3"+
		"\2\2\2\u00a3\u009c\3\2\2\2\u00a3\u009e\3\2\2\2\u00a4\25\3\2\2\2\u00a5"+
		"\u00a6\7\33\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\5\n\6\2\u00a8\u00a9\b"+
		"\f\1\2\u00a9\u00aa\7\4\2\2\u00aa\u00ab\b\f\1\2\u00ab\27\3\2\2\2\u00ac"+
		"\u00ad\7\27\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\5\34\17\2\u00af\u00b0"+
		"\7\62\2\2\u00b0\u00b1\7\4\2\2\u00b1\u00c9\3\2\2\2\u00b2\u00b3\7\30\2\2"+
		"\u00b3\u00b4\7\61\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6\7\62\2\2\u00b6"+
		"\u00b7\7\4\2\2\u00b7\u00c9\3\2\2\2\u00b8\u00b9\7\31\2\2\u00b9\u00c5\7"+
		"\61\2\2\u00ba\u00bc\7\34\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c6\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\5\6\4\2\u00c3"+
		"\u00c4\7\62\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00c0\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\7\62\2\2\u00c8\u00ac\3\2\2\2\u00c8"+
		"\u00b2\3\2\2\2\u00c8\u00b8\3\2\2\2\u00c9\31\3\2\2\2\u00ca\u00d4\5\36\20"+
		"\2\u00cb\u00cf\7\3\2\2\u00cc\u00ce\t\3\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00cb\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\33\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00e3"+
		"\5\36\20\2\u00d8\u00de\7\3\2\2\u00d9\u00da\7\33\2\2\u00da\u00dd\b\17\1"+
		"\2\u00db\u00dd\7\36\2\2\u00dc\u00d9\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e7\b\17\1\2\u00e7\35\3\2\2\2\u00e8\u00ec\7\t\2\2\u00e9\u00eb"+
		"\13\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0"+
		"\7\t\2\2\u00f0\37\3\2\2\2\u00f1\u00f2\t\4\2\2\u00f2!\3\2\2\2\u00f3\u010c"+
		"\5\26\f\2\u00f4\u00f5\7\20\2\2\u00f5\u00f6\7\61\2\2\u00f6\u00f7\5\20\t"+
		"\2\u00f7\u00f8\b\22\1\2\u00f8\u00f9\7\62\2\2\u00f9\u00fa\5$\23\2\u00fa"+
		"\u010c\3\2\2\2\u00fb\u00fc\7\23\2\2\u00fc\u00fd\7\61\2\2\u00fd\u00fe\5"+
		"\20\t\2\u00fe\u00ff\7\62\2\2\u00ff\u0100\5$\23\2\u0100\u010c\3\2\2\2\u0101"+
		"\u0102\7\22\2\2\u0102\u0103\7\61\2\2\u0103\u0104\5\26\f\2\u0104\u0105"+
		"\5\20\t\2\u0105\u0106\7\4\2\2\u0106\u0107\5\n\6\2\u0107\u0108\7\62\2\2"+
		"\u0108\u0109\5$\23\2\u0109\u010c\3\2\2\2\u010a\u010c\5\30\r\2\u010b\u00f3"+
		"\3\2\2\2\u010b\u00f4\3\2\2\2\u010b\u00fb\3\2\2\2\u010b\u0101\3\2\2\2\u010b"+
		"\u010a\3\2\2\2\u010c#\3\2\2\2\u010d\u0117\5\"\22\2\u010e\u010f\7/\2\2"+
		"\u010f\u0110\5\b\5\2\u0110\u0111\7\60\2\2\u0111\u0112\5&\24\2\u0112\u0117"+
		"\3\2\2\2\u0113\u0114\5(\25\2\u0114\u0115\5&\24\2\u0115\u0117\3\2\2\2\u0116"+
		"\u010d\3\2\2\2\u0116\u010e\3\2\2\2\u0116\u0113\3\2\2\2\u0117%\3\2\2\2"+
		"\u0118\u0119\7\21\2\2\u0119\u011a\b\24\1\2\u011a\u011d\5$\23\2\u011b\u011d"+
		"\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u011b\3\2\2\2\u011d\'\3\2\2\2\u011e"+
		"\u011f\7\25\2\2\u011f\u0123\7\4\2\2\u0120\u0121\7\26\2\2\u0121\u0123\7"+
		"\4\2\2\u0122\u011e\3\2\2\2\u0122\u0120\3\2\2\2\u0123)\3\2\2\2\u0124\u0125"+
		"\7\24\2\2\u0125\u0126\5\n\6\2\u0126\u0127\7\4\2\2\u0127+\3\2\2\2\35?G"+
		"NVbdilxz\u0084\u008c\u0098\u00a3\u00bd\u00c5\u00c8\u00cf\u00d4\u00dc\u00de"+
		"\u00e3\u00ec\u010b\u0116\u011c\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}