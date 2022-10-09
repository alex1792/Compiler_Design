// Generated from /home/alex/compiler_design/project01/Java-example1/mylexer.g by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mylexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_TYPE=1, CHAR_TYPE=2, VOID_TYPE=3, INT=4, FLOAT_TYPE=5, DOUBLE_TYPE=6, 
		LONG=7, STRUCT=8, MAIN=9, SIZE_OF=10, MALLOC=11, FREE=12, SCANF=13, PRINTF=14, 
		STRCMP=15, STRCPY=16, STRSTR=17, WHILE=18, FOR=19, IF=20, ELSE=21, ELSE_IF=22, 
		BREAK=23, CONTINUE=24, LEFT_BRACE=25, RIGHT_BRACE=26, LEFT_PAREN=27, RIGHT_PAREN=28, 
		LEFT_BRACKET=29, RIGHT_BRACKET=30, BACK_SLASH=31, LESS=32, GREATER=33, 
		PLUS=34, MINUS=35, MULTIPLE=36, DEVIDE=37, MOD=38, AND=39, OR=40, AND_AND=41, 
		OR_OR=42, NOT=43, COLON=44, SEMI_COLON=45, COMMA=46, DOT=47, QUOTATION=48, 
		ASSIGN=49, STAR_ASSIGN=50, PLUS_ASSIGN=51, MINUS_ASSIGN=52, MOD_ASSIGN=53, 
		RETURN=54, EQ_OP=55, LE_OP=56, GE_OP=57, NE_OP=58, PP_OP=59, MM_OP=60, 
		RSHIFT_OP=61, LSHIFT_OP=62, DEC_NUM=63, ID=64, FLOAT_NUM=65, COMMENT1=66, 
		COMMENT2=67, WS=68, NEW_LINE=69, INCLUDE_DIRECTIVE=70, PRINTF_FUNCTION=71, 
		SCANF_FUNCTION=72, MAIN_FUNCTION=73, FUNCTION_SPECIFIER=74, ASSIGN_SPECIFIER=75, 
		MALLOC_FUNCTION=76, SIZE_OF_FUNCTION=77;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_TYPE", "CHAR_TYPE", "VOID_TYPE", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", 
			"LONG", "STRUCT", "MAIN", "SIZE_OF", "MALLOC", "FREE", "SCANF", "PRINTF", 
			"STRCMP", "STRCPY", "STRSTR", "WHILE", "FOR", "IF", "ELSE", "ELSE_IF", 
			"BREAK", "CONTINUE", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "BACK_SLASH", "LESS", "GREATER", "PLUS", 
			"MINUS", "MULTIPLE", "DEVIDE", "MOD", "AND", "OR", "AND_AND", "OR_OR", 
			"NOT", "COLON", "SEMI_COLON", "COMMA", "DOT", "QUOTATION", "ASSIGN", 
			"STAR_ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "MOD_ASSIGN", "RETURN", 
			"EQ_OP", "LE_OP", "GE_OP", "NE_OP", "PP_OP", "MM_OP", "RSHIFT_OP", "LSHIFT_OP", 
			"DEC_NUM", "ID", "FLOAT_NUM", "FLOAT_NUM1", "FLOAT_NUM2", "FLOAT_NUM3", 
			"COMMENT1", "COMMENT2", "LETTER", "DIGIT", "WS", "NEW_LINE", "INCLUDE_DIRECTIVE", 
			"PRINTF_FUNCTION", "SCANF_FUNCTION", "MAIN_FUNCTION", "FUNCTION_SPECIFIER", 
			"ASSIGN_SPECIFIER", "MALLOC_FUNCTION", "SIZE_OF_FUNCTION"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'integer'", "'char'", "'void'", "'int'", "'float'", "'double'", 
			"'long'", "'struct'", "'main'", "'sizeof'", "'malloc'", "'free'", "'scanf'", 
			"'printf'", "'strcmp'", "'strcpy'", "'strstr'", "'while'", "'for'", "'if'", 
			"'else'", null, "'break'", "'continue'", "'{'", "'}'", "'('", "')'", 
			"'['", "']'", "'\\'", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'&'", "'|'", "'&&'", "'||'", "'!'", "':'", "';'", "','", "'.'", "'\"'", 
			"'='", "'*='", "'+='", "'-='", "'%='", "'return'", "'=='", "'<='", "'>='", 
			"'!='", "'++'", "'--'", "'<<'", "'>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_TYPE", "CHAR_TYPE", "VOID_TYPE", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", 
			"LONG", "STRUCT", "MAIN", "SIZE_OF", "MALLOC", "FREE", "SCANF", "PRINTF", 
			"STRCMP", "STRCPY", "STRSTR", "WHILE", "FOR", "IF", "ELSE", "ELSE_IF", 
			"BREAK", "CONTINUE", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "BACK_SLASH", "LESS", "GREATER", "PLUS", 
			"MINUS", "MULTIPLE", "DEVIDE", "MOD", "AND", "OR", "AND_AND", "OR_OR", 
			"NOT", "COLON", "SEMI_COLON", "COMMA", "DOT", "QUOTATION", "ASSIGN", 
			"STAR_ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "MOD_ASSIGN", "RETURN", 
			"EQ_OP", "LE_OP", "GE_OP", "NE_OP", "PP_OP", "MM_OP", "RSHIFT_OP", "LSHIFT_OP", 
			"DEC_NUM", "ID", "FLOAT_NUM", "COMMENT1", "COMMENT2", "WS", "NEW_LINE", 
			"INCLUDE_DIRECTIVE", "PRINTF_FUNCTION", "SCANF_FUNCTION", "MAIN_FUNCTION", 
			"FUNCTION_SPECIFIER", "ASSIGN_SPECIFIER", "MALLOC_FUNCTION", "SIZE_OF_FUNCTION"
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


	public mylexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mylexer.g"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2O\u02d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3"+
		"=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@\7@\u0198\n@\f@\16@\u019b\13@\5@\u019d"+
		"\n@\3A\3A\3A\7A\u01a2\nA\fA\16A\u01a5\13A\3B\3B\3B\5B\u01aa\nB\3C\6C\u01ad"+
		"\nC\rC\16C\u01ae\3C\3C\7C\u01b3\nC\fC\16C\u01b6\13C\3D\3D\6D\u01ba\nD"+
		"\rD\16D\u01bb\3E\6E\u01bf\nE\rE\16E\u01c0\3F\3F\3F\3F\7F\u01c7\nF\fF\16"+
		"F\u01ca\13F\3F\3F\3G\3G\3G\3G\7G\u01d2\nG\fG\16G\u01d5\13G\3G\3G\3G\3"+
		"H\3H\3I\3I\3J\3J\3J\3J\3J\6J\u01e3\nJ\rJ\16J\u01e4\3K\3K\3K\3K\5K\u01eb"+
		"\nK\3L\3L\5L\u01ef\nL\3L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u01fa\nL\3L\3L\3L"+
		"\3L\3L\3L\7L\u0202\nL\fL\16L\u0205\13L\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\7"+
		"M\u0211\nM\fM\16M\u0214\13M\3M\3M\3M\5M\u0219\nM\3M\3M\7M\u021d\nM\fM"+
		"\16M\u0220\13M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\7N\u022f\nN\fN\16"+
		"N\u0232\13N\3N\3N\3N\5N\u0237\nN\3N\5N\u023a\nN\3N\3N\7N\u023e\nN\fN\16"+
		"N\u0241\13N\3N\3N\3N\3O\3O\5O\u0248\nO\3O\3O\3O\3O\3O\3O\3O\5O\u0251\n"+
		"O\3O\3O\3O\3O\3O\3O\3O\7O\u025a\nO\fO\16O\u025d\13O\3O\3O\3P\3P\3P\3P"+
		"\3P\3P\5P\u0267\nP\3P\3P\3P\5P\u026c\nP\3P\3P\3P\3P\3P\3P\3P\7P\u0275"+
		"\nP\fP\16P\u0278\13P\3P\3P\3Q\3Q\3Q\3Q\3Q\5Q\u0281\nQ\3Q\5Q\u0284\nQ\3"+
		"Q\5Q\u0287\nQ\3Q\3Q\5Q\u028b\nQ\3Q\5Q\u028e\nQ\3Q\3Q\3Q\3Q\3Q\5Q\u0295"+
		"\nQ\3Q\5Q\u0298\nQ\3Q\3Q\3Q\3Q\5Q\u029e\nQ\3Q\5Q\u02a1\nQ\3Q\3Q\3Q\3Q"+
		"\3Q\3Q\3Q\5Q\u02aa\nQ\7Q\u02ac\nQ\fQ\16Q\u02af\13Q\3Q\5Q\u02b2\nQ\3Q\3"+
		"Q\3R\3R\5R\u02b8\nR\3R\3R\3R\3R\3R\3R\7R\u02c0\nR\fR\16R\u02c3\13R\3R"+
		"\3R\3S\3S\3S\3S\3S\3S\3S\7S\u02ce\nS\fS\16S\u02d1\13S\3S\3S\2\2T\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";u<w=y>{?}@\177A\u0081B\u0083C\u0085\2\u0087\2\u0089\2\u008bD\u008dE\u008f"+
		"\2\u0091\2\u0093F\u0095G\u0097H\u0099I\u009bJ\u009dK\u009fL\u00a1M\u00a3"+
		"N\u00a5O\3\2\5\5\2C\\aac|\4\2ttvv\4\2\13\13\17\17\2\u032c\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}"+
		"\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u008b\3\2\2\2"+
		"\2\u008d\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\3\u00a7\3\2\2\2\5\u00af\3\2\2\2\7\u00b4"+
		"\3\2\2\2\t\u00b9\3\2\2\2\13\u00bd\3\2\2\2\r\u00c3\3\2\2\2\17\u00ca\3\2"+
		"\2\2\21\u00cf\3\2\2\2\23\u00d6\3\2\2\2\25\u00db\3\2\2\2\27\u00e2\3\2\2"+
		"\2\31\u00e9\3\2\2\2\33\u00ee\3\2\2\2\35\u00f4\3\2\2\2\37\u00fb\3\2\2\2"+
		"!\u0102\3\2\2\2#\u0109\3\2\2\2%\u0110\3\2\2\2\'\u0116\3\2\2\2)\u011a\3"+
		"\2\2\2+\u011d\3\2\2\2-\u0122\3\2\2\2/\u0126\3\2\2\2\61\u012c\3\2\2\2\63"+
		"\u0135\3\2\2\2\65\u0137\3\2\2\2\67\u0139\3\2\2\29\u013b\3\2\2\2;\u013d"+
		"\3\2\2\2=\u013f\3\2\2\2?\u0141\3\2\2\2A\u0143\3\2\2\2C\u0145\3\2\2\2E"+
		"\u0147\3\2\2\2G\u0149\3\2\2\2I\u014b\3\2\2\2K\u014d\3\2\2\2M\u014f\3\2"+
		"\2\2O\u0151\3\2\2\2Q\u0153\3\2\2\2S\u0155\3\2\2\2U\u0158\3\2\2\2W\u015b"+
		"\3\2\2\2Y\u015d\3\2\2\2[\u015f\3\2\2\2]\u0161\3\2\2\2_\u0163\3\2\2\2a"+
		"\u0165\3\2\2\2c\u0167\3\2\2\2e\u0169\3\2\2\2g\u016c\3\2\2\2i\u016f\3\2"+
		"\2\2k\u0172\3\2\2\2m\u0175\3\2\2\2o\u017c\3\2\2\2q\u017f\3\2\2\2s\u0182"+
		"\3\2\2\2u\u0185\3\2\2\2w\u0188\3\2\2\2y\u018b\3\2\2\2{\u018e\3\2\2\2}"+
		"\u0191\3\2\2\2\177\u019c\3\2\2\2\u0081\u019e\3\2\2\2\u0083\u01a9\3\2\2"+
		"\2\u0085\u01ac\3\2\2\2\u0087\u01b7\3\2\2\2\u0089\u01be\3\2\2\2\u008b\u01c2"+
		"\3\2\2\2\u008d\u01cd\3\2\2\2\u008f\u01d9\3\2\2\2\u0091\u01db\3\2\2\2\u0093"+
		"\u01e2\3\2\2\2\u0095\u01ea\3\2\2\2\u0097\u01ec\3\2\2\2\u0099\u0206\3\2"+
		"\2\2\u009b\u0224\3\2\2\2\u009d\u0247\3\2\2\2\u009f\u0266\3\2\2\2\u00a1"+
		"\u0280\3\2\2\2\u00a3\u02b5\3\2\2\2\u00a5\u02c6\3\2\2\2\u00a7\u00a8\7k"+
		"\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7i\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7t\2\2\u00ae\4\3\2\2\2\u00af\u00b0"+
		"\7e\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\6\3\2\2\2\u00b4\u00b5\7x\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7k\2\2\u00b7"+
		"\u00b8\7f\2\2\u00b8\b\3\2\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7p\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bc\n\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7n\2\2\u00bf"+
		"\u00c0\7q\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7v\2\2\u00c2\f\3\2\2\2\u00c3"+
		"\u00c4\7f\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7d\2\2"+
		"\u00c7\u00c8\7n\2\2\u00c8\u00c9\7g\2\2\u00c9\16\3\2\2\2\u00ca\u00cb\7"+
		"n\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7i\2\2\u00ce\20"+
		"\3\2\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7t\2\2\u00d2"+
		"\u00d3\7w\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7v\2\2\u00d5\22\3\2\2\2\u00d6"+
		"\u00d7\7o\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7p\2\2"+
		"\u00da\24\3\2\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7"+
		"|\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7h\2\2\u00e1\26"+
		"\3\2\2\2\u00e2\u00e3\7o\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7n\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7e\2\2\u00e8\30\3\2\2\2\u00e9"+
		"\u00ea\7h\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7g\2\2"+
		"\u00ed\32\3\2\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7"+
		"c\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7h\2\2\u00f3\34\3\2\2\2\u00f4\u00f5"+
		"\7r\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7p\2\2\u00f8"+
		"\u00f9\7v\2\2\u00f9\u00fa\7h\2\2\u00fa\36\3\2\2\2\u00fb\u00fc\7u\2\2\u00fc"+
		"\u00fd\7v\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7o\2\2"+
		"\u0100\u0101\7r\2\2\u0101 \3\2\2\2\u0102\u0103\7u\2\2\u0103\u0104\7v\2"+
		"\2\u0104\u0105\7t\2\2\u0105\u0106\7e\2\2\u0106\u0107\7r\2\2\u0107\u0108"+
		"\7{\2\2\u0108\"\3\2\2\2\u0109\u010a\7u\2\2\u010a\u010b\7v\2\2\u010b\u010c"+
		"\7t\2\2\u010c\u010d\7u\2\2\u010d\u010e\7v\2\2\u010e\u010f\7t\2\2\u010f"+
		"$\3\2\2\2\u0110\u0111\7y\2\2\u0111\u0112\7j\2\2\u0112\u0113\7k\2\2\u0113"+
		"\u0114\7n\2\2\u0114\u0115\7g\2\2\u0115&\3\2\2\2\u0116\u0117\7h\2\2\u0117"+
		"\u0118\7q\2\2\u0118\u0119\7t\2\2\u0119(\3\2\2\2\u011a\u011b\7k\2\2\u011b"+
		"\u011c\7h\2\2\u011c*\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7n\2\2\u011f"+
		"\u0120\7u\2\2\u0120\u0121\7g\2\2\u0121,\3\2\2\2\u0122\u0123\5+\26\2\u0123"+
		"\u0124\7\"\2\2\u0124\u0125\5)\25\2\u0125.\3\2\2\2\u0126\u0127\7d\2\2\u0127"+
		"\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u012a\7c\2\2\u012a\u012b\7m\2\2"+
		"\u012b\60\3\2\2\2\u012c\u012d\7e\2\2\u012d\u012e\7q\2\2\u012e\u012f\7"+
		"p\2\2\u012f\u0130\7v\2\2\u0130\u0131\7k\2\2\u0131\u0132\7p\2\2\u0132\u0133"+
		"\7w\2\2\u0133\u0134\7g\2\2\u0134\62\3\2\2\2\u0135\u0136\7}\2\2\u0136\64"+
		"\3\2\2\2\u0137\u0138\7\177\2\2\u0138\66\3\2\2\2\u0139\u013a\7*\2\2\u013a"+
		"8\3\2\2\2\u013b\u013c\7+\2\2\u013c:\3\2\2\2\u013d\u013e\7]\2\2\u013e<"+
		"\3\2\2\2\u013f\u0140\7_\2\2\u0140>\3\2\2\2\u0141\u0142\7^\2\2\u0142@\3"+
		"\2\2\2\u0143\u0144\7>\2\2\u0144B\3\2\2\2\u0145\u0146\7@\2\2\u0146D\3\2"+
		"\2\2\u0147\u0148\7-\2\2\u0148F\3\2\2\2\u0149\u014a\7/\2\2\u014aH\3\2\2"+
		"\2\u014b\u014c\7,\2\2\u014cJ\3\2\2\2\u014d\u014e\7\61\2\2\u014eL\3\2\2"+
		"\2\u014f\u0150\7\'\2\2\u0150N\3\2\2\2\u0151\u0152\7(\2\2\u0152P\3\2\2"+
		"\2\u0153\u0154\7~\2\2\u0154R\3\2\2\2\u0155\u0156\7(\2\2\u0156\u0157\7"+
		"(\2\2\u0157T\3\2\2\2\u0158\u0159\7~\2\2\u0159\u015a\7~\2\2\u015aV\3\2"+
		"\2\2\u015b\u015c\7#\2\2\u015cX\3\2\2\2\u015d\u015e\7<\2\2\u015eZ\3\2\2"+
		"\2\u015f\u0160\7=\2\2\u0160\\\3\2\2\2\u0161\u0162\7.\2\2\u0162^\3\2\2"+
		"\2\u0163\u0164\7\60\2\2\u0164`\3\2\2\2\u0165\u0166\7$\2\2\u0166b\3\2\2"+
		"\2\u0167\u0168\7?\2\2\u0168d\3\2\2\2\u0169\u016a\7,\2\2\u016a\u016b\7"+
		"?\2\2\u016bf\3\2\2\2\u016c\u016d\7-\2\2\u016d\u016e\7?\2\2\u016eh\3\2"+
		"\2\2\u016f\u0170\7/\2\2\u0170\u0171\7?\2\2\u0171j\3\2\2\2\u0172\u0173"+
		"\7\'\2\2\u0173\u0174\7?\2\2\u0174l\3\2\2\2\u0175\u0176\7t\2\2\u0176\u0177"+
		"\7g\2\2\u0177\u0178\7v\2\2\u0178\u0179\7w\2\2\u0179\u017a\7t\2\2\u017a"+
		"\u017b\7p\2\2\u017bn\3\2\2\2\u017c\u017d\7?\2\2\u017d\u017e\7?\2\2\u017e"+
		"p\3\2\2\2\u017f\u0180\7>\2\2\u0180\u0181\7?\2\2\u0181r\3\2\2\2\u0182\u0183"+
		"\7@\2\2\u0183\u0184\7?\2\2\u0184t\3\2\2\2\u0185\u0186\7#\2\2\u0186\u0187"+
		"\7?\2\2\u0187v\3\2\2\2\u0188\u0189\7-\2\2\u0189\u018a\7-\2\2\u018ax\3"+
		"\2\2\2\u018b\u018c\7/\2\2\u018c\u018d\7/\2\2\u018dz\3\2\2\2\u018e\u018f"+
		"\7>\2\2\u018f\u0190\7>\2\2\u0190|\3\2\2\2\u0191\u0192\7@\2\2\u0192\u0193"+
		"\7@\2\2\u0193~\3\2\2\2\u0194\u019d\7\62\2\2\u0195\u0199\4\63;\2\u0196"+
		"\u0198\5\u0091I\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019c"+
		"\u0194\3\2\2\2\u019c\u0195\3\2\2\2\u019d\u0080\3\2\2\2\u019e\u01a3\5\u008f"+
		"H\2\u019f\u01a2\5\u008fH\2\u01a0\u01a2\5\u0091I\2\u01a1\u019f\3\2\2\2"+
		"\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4"+
		"\3\2\2\2\u01a4\u0082\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01aa\5\u0085C"+
		"\2\u01a7\u01aa\5\u0087D\2\u01a8\u01aa\5\u0089E\2\u01a9\u01a6\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01a8\3\2\2\2\u01aa\u0084\3\2\2\2\u01ab\u01ad\5\u0091"+
		"I\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b4\7\60\2\2\u01b1\u01b3\5"+
		"\u0091I\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2"+
		"\u01b4\u01b5\3\2\2\2\u01b5\u0086\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b9"+
		"\7\60\2\2\u01b8\u01ba\5\u0091I\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2\2"+
		"\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u0088\3\2\2\2\u01bd\u01bf"+
		"\5\u0091I\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2"+
		"\2\u01c0\u01c1\3\2\2\2\u01c1\u008a\3\2\2\2\u01c2\u01c3\7\61\2\2\u01c3"+
		"\u01c4\7\61\2\2\u01c4\u01c8\3\2\2\2\u01c5\u01c7\13\2\2\2\u01c6\u01c5\3"+
		"\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01cb\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\7\f\2\2\u01cc\u008c\3\2"+
		"\2\2\u01cd\u01ce\7\61\2\2\u01ce\u01cf\7,\2\2\u01cf\u01d3\3\2\2\2\u01d0"+
		"\u01d2\13\2\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3"+
		"\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6"+
		"\u01d7\7,\2\2\u01d7\u01d8\7\61\2\2\u01d8\u008e\3\2\2\2\u01d9\u01da\t\2"+
		"\2\2\u01da\u0090\3\2\2\2\u01db\u01dc\4\62;\2\u01dc\u0092\3\2\2\2\u01dd"+
		"\u01e3\7\"\2\2\u01de\u01df\5? \2\u01df\u01e0\t\3\2\2\u01e0\u01e3\3\2\2"+
		"\2\u01e1\u01e3\t\4\2\2\u01e2\u01dd\3\2\2\2\u01e2\u01de\3\2\2\2\u01e2\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u0094\3\2\2\2\u01e6\u01e7\5? \2\u01e7\u01e8\7p\2\2\u01e8\u01eb\3\2\2"+
		"\2\u01e9\u01eb\7\f\2\2\u01ea\u01e6\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb\u0096"+
		"\3\2\2\2\u01ec\u01ee\7%\2\2\u01ed\u01ef\5\u0093J\2\u01ee\u01ed\3\2\2\2"+
		"\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\7k\2\2\u01f1\u01f2"+
		"\7p\2\2\u01f2\u01f3\7e\2\2\u01f3\u01f4\7n\2\2\u01f4\u01f5\7w\2\2\u01f5"+
		"\u01f6\7f\2\2\u01f6\u01f7\7g\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01fa\5\u0093"+
		"J\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01fc\7>\2\2\u01fc\u01fd\5\u0081A\2\u01fd\u01fe\5_\60\2\u01fe\u01ff\5"+
		"\u0081A\2\u01ff\u0203\7@\2\2\u0200\u0202\5\u0093J\2\u0201\u0200\3\2\2"+
		"\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0098"+
		"\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0207\5\35\17\2\u0207\u0208\5\67\34"+
		"\2\u0208\u0212\5a\61\2\u0209\u0211\5\u008fH\2\u020a\u0211\5\u0091I\2\u020b"+
		"\u0211\5\u0093J\2\u020c\u0211\5\u0095K\2\u020d\u0211\5M\'\2\u020e\u0211"+
		"\5O(\2\u020f\u0211\5]/\2\u0210\u0209\3\2\2\2\u0210\u020a\3\2\2\2\u0210"+
		"\u020b\3\2\2\2\u0210\u020c\3\2\2\2\u0210\u020d\3\2\2\2\u0210\u020e\3\2"+
		"\2\2\u0210\u020f\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0215\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u021e\5a"+
		"\61\2\u0216\u0218\5]/\2\u0217\u0219\5\u0093J\2\u0218\u0217\3\2\2\2\u0218"+
		"\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\5\u0081A\2\u021b\u021d"+
		"\3\2\2\2\u021c\u0216\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u021c\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u021e\3\2\2\2\u0221\u0222\59"+
		"\35\2\u0222\u0223\5[.\2\u0223\u009a\3\2\2\2\u0224\u0225\5\33\16\2\u0225"+
		"\u0226\5\67\34\2\u0226\u0230\5a\61\2\u0227\u022f\5\u008fH\2\u0228\u022f"+
		"\5\u0091I\2\u0229\u022f\5\u0093J\2\u022a\u022f\5\u0095K\2\u022b\u022f"+
		"\5M\'\2\u022c\u022f\5O(\2\u022d\u022f\5]/\2\u022e\u0227\3\2\2\2\u022e"+
		"\u0228\3\2\2\2\u022e\u0229\3\2\2\2\u022e\u022a\3\2\2\2\u022e\u022b\3\2"+
		"\2\2\u022e\u022c\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0232\3\2\2\2\u0230"+
		"\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232\u0230\3\2"+
		"\2\2\u0233\u023f\5a\61\2\u0234\u0236\5]/\2\u0235\u0237\5\u0093J\2\u0236"+
		"\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0239\3\2\2\2\u0238\u023a\5O"+
		"(\2\u0239\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b"+
		"\u023c\5\u0081A\2\u023c\u023e\3\2\2\2\u023d\u0234\3\2\2\2\u023e\u0241"+
		"\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241"+
		"\u023f\3\2\2\2\u0242\u0243\59\35\2\u0243\u0244\5[.\2\u0244\u009c\3\2\2"+
		"\2\u0245\u0248\5\7\4\2\u0246\u0248\5\t\5\2\u0247\u0245\3\2\2\2\u0247\u0246"+
		"\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\5\u0093J\2\u024a\u024b\7o\2\2"+
		"\u024b\u024c\7c\2\2\u024c\u024d\7k\2\2\u024d\u024e\7p\2\2\u024e\u0250"+
		"\3\2\2\2\u024f\u0251\5\u0093J\2\u0250\u024f\3\2\2\2\u0250\u0251\3\2\2"+
		"\2\u0251\u0252\3\2\2\2\u0252\u025b\5\67\34\2\u0253\u025a\5\u0091I\2\u0254"+
		"\u025a\5\u008fH\2\u0255\u025a\5]/\2\u0256\u025a\5\u0093J\2\u0257\u025a"+
		"\5;\36\2\u0258\u025a\5=\37\2\u0259\u0253\3\2\2\2\u0259\u0254\3\2\2\2\u0259"+
		"\u0255\3\2\2\2\u0259\u0256\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u0258\3\2"+
		"\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025e\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u025f\59\35\2\u025f\u009e\3\2"+
		"\2\2\u0260\u0267\5\7\4\2\u0261\u0267\5\t\5\2\u0262\u0267\5\r\7\2\u0263"+
		"\u0267\5\13\6\2\u0264\u0267\5\5\3\2\u0265\u0267\5\17\b\2\u0266\u0260\3"+
		"\2\2\2\u0266\u0261\3\2\2\2\u0266\u0262\3\2\2\2\u0266\u0263\3\2\2\2\u0266"+
		"\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u0269\5\u0093"+
		"J\2\u0269\u026b\5\u0081A\2\u026a\u026c\5\u0093J\2\u026b\u026a\3\2\2\2"+
		"\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u0276\5\67\34\2\u026e\u0275"+
		"\5\u0091I\2\u026f\u0275\5]/\2\u0270\u0275\5\u008fH\2\u0271\u0275\5;\36"+
		"\2\u0272\u0275\5=\37\2\u0273\u0275\5\u0093J\2\u0274\u026e\3\2\2\2\u0274"+
		"\u026f\3\2\2\2\u0274\u0270\3\2\2\2\u0274\u0271\3\2\2\2\u0274\u0272\3\2"+
		"\2\2\u0274\u0273\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276"+
		"\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a\59"+
		"\35\2\u027a\u00a0\3\2\2\2\u027b\u0281\5\t\5\2\u027c\u0281\5\r\7\2\u027d"+
		"\u0281\5\13\6\2\u027e\u0281\5\5\3\2\u027f\u0281\5\17\b\2\u0280\u027b\3"+
		"\2\2\2\u0280\u027c\3\2\2\2\u0280\u027d\3\2\2\2\u0280\u027e\3\2\2\2\u0280"+
		"\u027f\3\2\2\2\u0281\u0283\3\2\2\2\u0282\u0284\5\u0093J\2\u0283\u0282"+
		"\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2\2\2\u0285\u0287\5I%\2\u0286"+
		"\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u028b\5\u0091"+
		"I\2\u0289\u028b\5\u0081A\2\u028a\u0288\3\2\2\2\u028a\u0289\3\2\2\2\u028b"+
		"\u028d\3\2\2\2\u028c\u028e\5\u0093J\2\u028d\u028c\3\2\2\2\u028d\u028e"+
		"\3\2\2\2\u028e\u0294\3\2\2\2\u028f\u0295\5c\62\2\u0290\u0295\5e\63\2\u0291"+
		"\u0295\5g\64\2\u0292\u0295\5i\65\2\u0293\u0295\5k\66\2\u0294\u028f\3\2"+
		"\2\2\u0294\u0290\3\2\2\2\u0294\u0291\3\2\2\2\u0294\u0292\3\2\2\2\u0294"+
		"\u0293\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u0298\5\u0093J\2\u0297\u0296"+
		"\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029d\3\2\2\2\u0299\u029e\5\u0081A"+
		"\2\u029a\u029e\5\u0091I\2\u029b\u029e\5\u00a3R\2\u029c\u029e\5\u00a5S"+
		"\2\u029d\u0299\3\2\2\2\u029d\u029a\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029c"+
		"\3\2\2\2\u029e\u02ad\3\2\2\2\u029f\u02a1\5\u0093J\2\u02a0\u029f\3\2\2"+
		"\2\u02a0\u02a1\3\2\2\2\u02a1\u02a9\3\2\2\2\u02a2\u02aa\5E#\2\u02a3\u02aa"+
		"\5G$\2\u02a4\u02aa\5I%\2\u02a5\u02aa\5K&\2\u02a6\u02aa\5M\'\2\u02a7\u02aa"+
		"\5\u0081A\2\u02a8\u02aa\5\u0091I\2\u02a9\u02a2\3\2\2\2\u02a9\u02a3\3\2"+
		"\2\2\u02a9\u02a4\3\2\2\2\u02a9\u02a5\3\2\2\2\u02a9\u02a6\3\2\2\2\u02a9"+
		"\u02a7\3\2\2\2\u02a9\u02a8\3\2\2\2\u02aa\u02ac\3\2\2\2\u02ab\u02a0\3\2"+
		"\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02b1\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02b2\5\u0093J\2\u02b1\u02b0"+
		"\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\5[.\2\u02b4"+
		"\u00a2\3\2\2\2\u02b5\u02b7\5\27\f\2\u02b6\u02b8\5\u0093J\2\u02b7\u02b6"+
		"\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02c1\5\67\34\2"+
		"\u02ba\u02c0\5\u0091I\2\u02bb\u02c0\5\u008fH\2\u02bc\u02c0\5\u0093J\2"+
		"\u02bd\u02c0\5\67\34\2\u02be\u02c0\59\35\2\u02bf\u02ba\3\2\2\2\u02bf\u02bb"+
		"\3\2\2\2\u02bf\u02bc\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02be\3\2\2\2\u02c0"+
		"\u02c3\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c4\3\2"+
		"\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02c5\59\35\2\u02c5\u00a4\3\2\2\2\u02c6"+
		"\u02c7\5\25\13\2\u02c7\u02cf\5\67\34\2\u02c8\u02ce\5\u0091I\2\u02c9\u02ce"+
		"\5\u008fH\2\u02ca\u02ce\5\u0093J\2\u02cb\u02ce\5\67\34\2\u02cc\u02ce\5"+
		"9\35\2\u02cd\u02c8\3\2\2\2\u02cd\u02c9\3\2\2\2\u02cd\u02ca\3\2\2\2\u02cd"+
		"\u02cb\3\2\2\2\u02cd\u02cc\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2"+
		"\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2"+
		"\u02d3\59\35\2\u02d3\u00a6\3\2\2\2\66\2\u0199\u019c\u01a1\u01a3\u01a9"+
		"\u01ae\u01b4\u01bb\u01c0\u01c8\u01d3\u01e2\u01e4\u01ea\u01ee\u01f9\u0203"+
		"\u0210\u0212\u0218\u021e\u022e\u0230\u0236\u0239\u023f\u0247\u0250\u0259"+
		"\u025b\u0266\u026b\u0274\u0276\u0280\u0283\u0286\u028a\u028d\u0294\u0297"+
		"\u029d\u02a0\u02a9\u02ad\u02b1\u02b7\u02bf\u02c1\u02cd\u02cf\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}