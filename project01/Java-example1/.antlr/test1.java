// Generated from /home/alex/compiler_design/project01/Java-example1/test1.g by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class test1 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INCLUDE_DIRECTIVE=1, FUNCTION_SPECIFIER=2, INT_TYPE=3, CHAR_TYPE=4, VOID_TYPE=5, 
		INT=6, FLOAT_TYPE=7, DOUBLE_TYPE=8, LONG=9, MAIN=10, WHILE=11, FOR=12, 
		IF=13, ELSE=14, ELSE_IF=15, LEFT_BRACE=16, RIGHT_BRACE=17, LEFT_PAREN=18, 
		RIGHT_PAREN=19, LEFT_BRACKET=20, RIGHT_BRACKET=21, LESS=22, GREATER=23, 
		PLUS=24, MINUS=25, MULTIPLE=26, DEVIDE=27, MOD=28, AND=29, OR=30, AND_AND=31, 
		OR_OR=32, NOT=33, COLON=34, SEMI_COLON=35, COMMA=36, DOT=37, ASSIGN=38, 
		STAR_ASSIGN=39, PLUS_ASSIGN=40, RETURN=41, EQ_OP=42, LE_OP=43, GE_OP=44, 
		NE_OP=45, PP_OP=46, MM_OP=47, RSHIFT_OP=48, LSHIFT_OP=49, DEC_NUM=50, 
		ID=51, FLOAT_NUM=52, COMMENT1=53, COMMENT2=54, NEW_LINE=55, WS=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INCLUDE_DIRECTIVE", "FUNCTION_SPECIFIER", "INT_TYPE", "CHAR_TYPE", "VOID_TYPE", 
			"INT", "FLOAT_TYPE", "DOUBLE_TYPE", "LONG", "MAIN", "WHILE", "FOR", "IF", 
			"ELSE", "ELSE_IF", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LESS", "GREATER", "PLUS", "MINUS", 
			"MULTIPLE", "DEVIDE", "MOD", "AND", "OR", "AND_AND", "OR_OR", "NOT", 
			"COLON", "SEMI_COLON", "COMMA", "DOT", "ASSIGN", "STAR_ASSIGN", "PLUS_ASSIGN", 
			"RETURN", "EQ_OP", "LE_OP", "GE_OP", "NE_OP", "PP_OP", "MM_OP", "RSHIFT_OP", 
			"LSHIFT_OP", "DEC_NUM", "ID", "FLOAT_NUM", "FLOAT_NUM1", "FLOAT_NUM2", 
			"FLOAT_NUM3", "COMMENT1", "COMMENT2", "NEW_LINE", "LETTER", "DIGIT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'integer'", "'char'", "'void'", "'int'", "'float'", 
			"'double'", "'long'", "'main'", "'while'", "'for'", "'if'", "'else'", 
			null, "'{'", "'}'", "'('", "')'", "'['", "']'", "'<'", "'>'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'!'", "':'", 
			"';'", "','", "'.'", "'='", "'*='", "'+='", "'return'", "'=='", "'<='", 
			"'>='", "'!='", "'++'", "'--'", "'<<'", "'>>'", null, null, null, null, 
			null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INCLUDE_DIRECTIVE", "FUNCTION_SPECIFIER", "INT_TYPE", "CHAR_TYPE", 
			"VOID_TYPE", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", "LONG", "MAIN", "WHILE", 
			"FOR", "IF", "ELSE", "ELSE_IF", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", 
			"RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", "LESS", "GREATER", "PLUS", 
			"MINUS", "MULTIPLE", "DEVIDE", "MOD", "AND", "OR", "AND_AND", "OR_OR", 
			"NOT", "COLON", "SEMI_COLON", "COMMA", "DOT", "ASSIGN", "STAR_ASSIGN", 
			"PLUS_ASSIGN", "RETURN", "EQ_OP", "LE_OP", "GE_OP", "NE_OP", "PP_OP", 
			"MM_OP", "RSHIFT_OP", "LSHIFT_OP", "DEC_NUM", "ID", "FLOAT_NUM", "COMMENT1", 
			"COMMENT2", "NEW_LINE", "WS"
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


	public test1(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "test1.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u0190\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\5\2\u0080\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u008b"+
		"\n\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0093\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\u009d\n\3\3\3\5\3\u00a0\n\3\3\3\3\3\5\3\u00a4\n\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		"-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\7\63\u0144\n\63\f\63\16\63\u0147\13\63\5\63\u0149\n\63\3\64"+
		"\3\64\3\64\7\64\u014e\n\64\f\64\16\64\u0151\13\64\3\65\3\65\3\65\5\65"+
		"\u0156\n\65\3\66\6\66\u0159\n\66\r\66\16\66\u015a\3\66\3\66\7\66\u015f"+
		"\n\66\f\66\16\66\u0162\13\66\3\67\3\67\6\67\u0166\n\67\r\67\16\67\u0167"+
		"\38\68\u016b\n8\r8\168\u016c\39\39\39\39\79\u0173\n9\f9\169\u0176\139"+
		"\39\39\3:\3:\3:\3:\7:\u017e\n:\f:\16:\u0181\13:\3:\3:\3:\3;\3;\3<\3<\3"+
		"=\3=\3>\6>\u018d\n>\r>\16>\u018e\2\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\2m\2o\2q\67s8u9w\2y\2{:\3\2\4\5\2C\\aa"+
		"c|\5\2\13\13\17\17\"\"\2\u01a1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2{\3\2\2\2\3}\3\2\2\2\5\u009c"+
		"\3\2\2\2\7\u00a8\3\2\2\2\t\u00b0\3\2\2\2\13\u00b5\3\2\2\2\r\u00ba\3\2"+
		"\2\2\17\u00be\3\2\2\2\21\u00c4\3\2\2\2\23\u00cb\3\2\2\2\25\u00d0\3\2\2"+
		"\2\27\u00d5\3\2\2\2\31\u00db\3\2\2\2\33\u00df\3\2\2\2\35\u00e2\3\2\2\2"+
		"\37\u00e7\3\2\2\2!\u00eb\3\2\2\2#\u00ed\3\2\2\2%\u00ef\3\2\2\2\'\u00f1"+
		"\3\2\2\2)\u00f3\3\2\2\2+\u00f5\3\2\2\2-\u00f7\3\2\2\2/\u00f9\3\2\2\2\61"+
		"\u00fb\3\2\2\2\63\u00fd\3\2\2\2\65\u00ff\3\2\2\2\67\u0101\3\2\2\29\u0103"+
		"\3\2\2\2;\u0105\3\2\2\2=\u0107\3\2\2\2?\u0109\3\2\2\2A\u010c\3\2\2\2C"+
		"\u010f\3\2\2\2E\u0111\3\2\2\2G\u0113\3\2\2\2I\u0115\3\2\2\2K\u0117\3\2"+
		"\2\2M\u0119\3\2\2\2O\u011b\3\2\2\2Q\u011e\3\2\2\2S\u0121\3\2\2\2U\u0128"+
		"\3\2\2\2W\u012b\3\2\2\2Y\u012e\3\2\2\2[\u0131\3\2\2\2]\u0134\3\2\2\2_"+
		"\u0137\3\2\2\2a\u013a\3\2\2\2c\u013d\3\2\2\2e\u0148\3\2\2\2g\u014a\3\2"+
		"\2\2i\u0155\3\2\2\2k\u0158\3\2\2\2m\u0163\3\2\2\2o\u016a\3\2\2\2q\u016e"+
		"\3\2\2\2s\u0179\3\2\2\2u\u0185\3\2\2\2w\u0187\3\2\2\2y\u0189\3\2\2\2{"+
		"\u018c\3\2\2\2}\177\7%\2\2~\u0080\5{>\2\177~\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083\u0084"+
		"\7e\2\2\u0084\u0085\7n\2\2\u0085\u0086\7w\2\2\u0086\u0087\7f\2\2\u0087"+
		"\u0088\7g\2\2\u0088\u008a\3\2\2\2\u0089\u008b\5{>\2\u008a\u0089\3\2\2"+
		"\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7>\2\2\u008d\u008e"+
		"\5g\64\2\u008e\u008f\5K&\2\u008f\u0090\5g\64\2\u0090\u0092\7@\2\2\u0091"+
		"\u0093\5{>\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2"+
		"\2\u0094\u0095\5u;\2\u0095\4\3\2\2\2\u0096\u009d\5\r\7\2\u0097\u009d\5"+
		"\t\5\2\u0098\u009d\5\17\b\2\u0099\u009d\5\13\6\2\u009a\u009d\5\21\t\2"+
		"\u009b\u009d\5\23\n\2\u009c\u0096\3\2\2\2\u009c\u0097\3\2\2\2\u009c\u0098"+
		"\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u00a0\5{>\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2"+
		"\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\5\25\13\2\u00a2\u00a4\5{>\2\u00a3\u00a2"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\5%\23\2\u00a6"+
		"\u00a7\5\'\24\2\u00a7\6\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7p\2\2"+
		"\u00aa\u00ab\7v\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7i\2\2\u00ad\u00ae"+
		"\7g\2\2\u00ae\u00af\7t\2\2\u00af\b\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2"+
		"\7j\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7t\2\2\u00b4\n\3\2\2\2\u00b5\u00b6"+
		"\7x\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7f\2\2\u00b9"+
		"\f\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\16\3\2\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\u00c2\7c\2\2\u00c2\u00c3\7v\2\2\u00c3\20\3\2\2\2\u00c4\u00c5\7f\2\2\u00c5"+
		"\u00c6\7q\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7d\2\2\u00c8\u00c9\7n\2\2"+
		"\u00c9\u00ca\7g\2\2\u00ca\22\3\2\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7"+
		"q\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7i\2\2\u00cf\24\3\2\2\2\u00d0\u00d1"+
		"\7o\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\26\3\2\2\2\u00d5\u00d6\7y\2\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7k\2\2\u00d8"+
		"\u00d9\7n\2\2\u00d9\u00da\7g\2\2\u00da\30\3\2\2\2\u00db\u00dc\7h\2\2\u00dc"+
		"\u00dd\7q\2\2\u00dd\u00de\7t\2\2\u00de\32\3\2\2\2\u00df\u00e0\7k\2\2\u00e0"+
		"\u00e1\7h\2\2\u00e1\34\3\2\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7n\2\2\u00e4"+
		"\u00e5\7u\2\2\u00e5\u00e6\7g\2\2\u00e6\36\3\2\2\2\u00e7\u00e8\5\35\17"+
		"\2\u00e8\u00e9\7\"\2\2\u00e9\u00ea\5\33\16\2\u00ea \3\2\2\2\u00eb\u00ec"+
		"\7}\2\2\u00ec\"\3\2\2\2\u00ed\u00ee\7\177\2\2\u00ee$\3\2\2\2\u00ef\u00f0"+
		"\7*\2\2\u00f0&\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2(\3\2\2\2\u00f3\u00f4\7"+
		"]\2\2\u00f4*\3\2\2\2\u00f5\u00f6\7_\2\2\u00f6,\3\2\2\2\u00f7\u00f8\7>"+
		"\2\2\u00f8.\3\2\2\2\u00f9\u00fa\7@\2\2\u00fa\60\3\2\2\2\u00fb\u00fc\7"+
		"-\2\2\u00fc\62\3\2\2\2\u00fd\u00fe\7/\2\2\u00fe\64\3\2\2\2\u00ff\u0100"+
		"\7,\2\2\u0100\66\3\2\2\2\u0101\u0102\7\61\2\2\u01028\3\2\2\2\u0103\u0104"+
		"\7\'\2\2\u0104:\3\2\2\2\u0105\u0106\7(\2\2\u0106<\3\2\2\2\u0107\u0108"+
		"\7~\2\2\u0108>\3\2\2\2\u0109\u010a\7(\2\2\u010a\u010b\7(\2\2\u010b@\3"+
		"\2\2\2\u010c\u010d\7~\2\2\u010d\u010e\7~\2\2\u010eB\3\2\2\2\u010f\u0110"+
		"\7#\2\2\u0110D\3\2\2\2\u0111\u0112\7<\2\2\u0112F\3\2\2\2\u0113\u0114\7"+
		"=\2\2\u0114H\3\2\2\2\u0115\u0116\7.\2\2\u0116J\3\2\2\2\u0117\u0118\7\60"+
		"\2\2\u0118L\3\2\2\2\u0119\u011a\7?\2\2\u011aN\3\2\2\2\u011b\u011c\7,\2"+
		"\2\u011c\u011d\7?\2\2\u011dP\3\2\2\2\u011e\u011f\7-\2\2\u011f\u0120\7"+
		"?\2\2\u0120R\3\2\2\2\u0121\u0122\7t\2\2\u0122\u0123\7g\2\2\u0123\u0124"+
		"\7v\2\2\u0124\u0125\7w\2\2\u0125\u0126\7t\2\2\u0126\u0127\7p\2\2\u0127"+
		"T\3\2\2\2\u0128\u0129\7?\2\2\u0129\u012a\7?\2\2\u012aV\3\2\2\2\u012b\u012c"+
		"\7>\2\2\u012c\u012d\7?\2\2\u012dX\3\2\2\2\u012e\u012f\7@\2\2\u012f\u0130"+
		"\7?\2\2\u0130Z\3\2\2\2\u0131\u0132\7#\2\2\u0132\u0133\7?\2\2\u0133\\\3"+
		"\2\2\2\u0134\u0135\7-\2\2\u0135\u0136\7-\2\2\u0136^\3\2\2\2\u0137\u0138"+
		"\7/\2\2\u0138\u0139\7/\2\2\u0139`\3\2\2\2\u013a\u013b\7>\2\2\u013b\u013c"+
		"\7>\2\2\u013cb\3\2\2\2\u013d\u013e\7@\2\2\u013e\u013f\7@\2\2\u013fd\3"+
		"\2\2\2\u0140\u0149\7\62\2\2\u0141\u0145\4\63;\2\u0142\u0144\5y=\2\u0143"+
		"\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0140\3\2\2\2\u0148"+
		"\u0141\3\2\2\2\u0149f\3\2\2\2\u014a\u014f\5w<\2\u014b\u014e\5w<\2\u014c"+
		"\u014e\5y=\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2"+
		"\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150h\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0152\u0156\5k\66\2\u0153\u0156\5m\67\2\u0154\u0156\5o8\2\u0155"+
		"\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156j\3\2\2\2"+
		"\u0157\u0159\5y=\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u0160\7\60\2\2"+
		"\u015d\u015f\5y=\2\u015e\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0161l\3\2\2\2\u0162\u0160\3\2\2\2\u0163"+
		"\u0165\7\60\2\2\u0164\u0166\5y=\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168n\3\2\2\2\u0169\u016b"+
		"\5y=\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016dp\3\2\2\2\u016e\u016f\7\61\2\2\u016f\u0170\7\61\2"+
		"\2\u0170\u0174\3\2\2\2\u0171\u0173\13\2\2\2\u0172\u0171\3\2\2\2\u0173"+
		"\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2"+
		"\2\2\u0176\u0174\3\2\2\2\u0177\u0178\7\f\2\2\u0178r\3\2\2\2\u0179\u017a"+
		"\7\61\2\2\u017a\u017b\7,\2\2\u017b\u017f\3\2\2\2\u017c\u017e\13\2\2\2"+
		"\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7,\2\2\u0183"+
		"\u0184\7\61\2\2\u0184t\3\2\2\2\u0185\u0186\7\f\2\2\u0186v\3\2\2\2\u0187"+
		"\u0188\t\2\2\2\u0188x\3\2\2\2\u0189\u018a\4\62;\2\u018az\3\2\2\2\u018b"+
		"\u018d\t\3\2\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f|\3\2\2\2\25\2\177\u008a\u0092\u009c\u009f"+
		"\u00a3\u0145\u0148\u014d\u014f\u0155\u015a\u0160\u0167\u016c\u0174\u017f"+
		"\u018e\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}