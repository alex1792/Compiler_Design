// $ANTLR 3.5.2 myparser.g 2022-05-12 17:37:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myparserLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int ADD=4;
	public static final int AND=5;
	public static final int AND_AND=6;
	public static final int BREAK=7;
	public static final int BSLASH=8;
	public static final int CHAR=9;
	public static final int COMMENT=10;
	public static final int CONTINUE=11;
	public static final int DOUBLE=12;
	public static final int ELSE=13;
	public static final int EQ=14;
	public static final int FLOAT=15;
	public static final int FOR=16;
	public static final int Floating_point_constant=17;
	public static final int GREATER=18;
	public static final int GR_EQ=19;
	public static final int IF=20;
	public static final int INT=21;
	public static final int Identifier=22;
	public static final int Integer_constant=23;
	public static final int LEFT_BRACE=24;
	public static final int LEFT_BRACKET=25;
	public static final int LEFT_PAREN=26;
	public static final int LESS=27;
	public static final int LE_EQ=28;
	public static final int MAIN=29;
	public static final int MALLOC=30;
	public static final int MINUS=31;
	public static final int NOT=32;
	public static final int NOT_EQ=33;
	public static final int OR=34;
	public static final int OR_OR=35;
	public static final int PRINTF=36;
	public static final int RETURN=37;
	public static final int RIGHT_BRACE=38;
	public static final int RIGHT_BRACKET=39;
	public static final int RIGHT_PAREN=40;
	public static final int SCANF=41;
	public static final int SIZEOF=42;
	public static final int SLASH=43;
	public static final int VOID=44;
	public static final int WHILE=45;
	public static final int WS=46;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myparserLexer() {} 
	public myparserLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myparserLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myparser.g"; }

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:7:7: ( '\"' )
			// myparser.g:7:9: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:8:7: ( '%' )
			// myparser.g:8:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:9:7: ( '*' )
			// myparser.g:9:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:10:7: ( '+' )
			// myparser.g:10:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:11:7: ( ',' )
			// myparser.g:11:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:12:7: ( '-' )
			// myparser.g:12:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:13:7: ( ';' )
			// myparser.g:13:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:14:7: ( '=' )
			// myparser.g:14:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:107:6: ( 'float' )
			// myparser.g:107:8: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:108:4: ( 'int' )
			// myparser.g:108:6: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:109:5: ( 'char' )
			// myparser.g:109:7: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:110:7: ( 'double' )
			// myparser.g:110:9: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:111:5: ( 'main' )
			// myparser.g:111:7: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:112:5: ( 'void' )
			// myparser.g:112:7: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:113:3: ( 'if' )
			// myparser.g:113:5: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:114:5: ( 'else' )
			// myparser.g:114:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:115:4: ( 'for' )
			// myparser.g:115:6: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:116:6: ( 'while' )
			// myparser.g:116:8: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:117:7: ( 'return' )
			// myparser.g:117:9: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:118:6: ( 'break' )
			// myparser.g:118:8: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:119:9: ( 'continue' )
			// myparser.g:119:11: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "PRINTF"
	public final void mPRINTF() throws RecognitionException {
		try {
			int _type = PRINTF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:122:7: ( 'printf' )
			// myparser.g:122:9: 'printf'
			{
			match("printf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTF"

	// $ANTLR start "SCANF"
	public final void mSCANF() throws RecognitionException {
		try {
			int _type = SCANF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:123:6: ( 'scanf' )
			// myparser.g:123:8: 'scanf'
			{
			match("scanf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCANF"

	// $ANTLR start "MALLOC"
	public final void mMALLOC() throws RecognitionException {
		try {
			int _type = MALLOC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:124:7: ( 'malloc' )
			// myparser.g:124:9: 'malloc'
			{
			match("malloc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MALLOC"

	// $ANTLR start "SIZEOF"
	public final void mSIZEOF() throws RecognitionException {
		try {
			int _type = SIZEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:125:7: ( 'sizeof' )
			// myparser.g:125:9: 'sizeof'
			{
			match("sizeof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIZEOF"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:127:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myparser.g:127:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myparser.g:127:43: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Identifier"

	// $ANTLR start "Integer_constant"
	public final void mInteger_constant() throws RecognitionException {
		try {
			int _type = Integer_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:133:17: ( ( '0' .. '9' )+ )
			// myparser.g:133:19: ( '0' .. '9' )+
			{
			// myparser.g:133:19: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer_constant"

	// $ANTLR start "Floating_point_constant"
	public final void mFloating_point_constant() throws RecognitionException {
		try {
			int _type = Floating_point_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:134:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myparser.g:134:26: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myparser.g:134:26: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			match('.'); 
			// myparser.g:134:41: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Floating_point_constant"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:136:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myparser.g:136:5: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:137:8: ( '/*' ( . )* '*/' )
			// myparser.g:137:10: '/*' ( . )* '*/'
			{
			match("/*"); 

			// myparser.g:137:15: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// myparser.g:137:15: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:140:5: ( '<' )
			// myparser.g:140:7: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS"

	// $ANTLR start "GREATER"
	public final void mGREATER() throws RecognitionException {
		try {
			int _type = GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:141:8: ( '>' )
			// myparser.g:141:10: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER"

	// $ANTLR start "LE_EQ"
	public final void mLE_EQ() throws RecognitionException {
		try {
			int _type = LE_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:142:6: ( '<=' )
			// myparser.g:142:8: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_EQ"

	// $ANTLR start "GR_EQ"
	public final void mGR_EQ() throws RecognitionException {
		try {
			int _type = GR_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:143:6: ( '>=' )
			// myparser.g:143:8: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GR_EQ"

	// $ANTLR start "NOT_EQ"
	public final void mNOT_EQ() throws RecognitionException {
		try {
			int _type = NOT_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:144:7: ( '!=' )
			// myparser.g:144:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_EQ"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:145:3: ( '==' )
			// myparser.g:145:5: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:147:4: ( '!' )
			// myparser.g:147:6: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:148:4: ( '&' )
			// myparser.g:148:6: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:149:3: ( '|' )
			// myparser.g:149:5: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND_AND"
	public final void mAND_AND() throws RecognitionException {
		try {
			int _type = AND_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:150:8: ( '&&' )
			// myparser.g:150:10: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND_AND"

	// $ANTLR start "OR_OR"
	public final void mOR_OR() throws RecognitionException {
		try {
			int _type = OR_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:151:6: ( '||' )
			// myparser.g:151:8: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR_OR"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:154:4: ( '++' )
			// myparser.g:154:6: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:155:6: ( '--' )
			// myparser.g:155:8: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "BSLASH"
	public final void mBSLASH() throws RecognitionException {
		try {
			int _type = BSLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:158:7: ( '\\\\' )
			// myparser.g:158:9: '\\\\'
			{
			match('\\'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BSLASH"

	// $ANTLR start "SLASH"
	public final void mSLASH() throws RecognitionException {
		try {
			int _type = SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:159:6: ( '/' )
			// myparser.g:159:8: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLASH"

	// $ANTLR start "LEFT_BRACE"
	public final void mLEFT_BRACE() throws RecognitionException {
		try {
			int _type = LEFT_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:160:11: ( '{' )
			// myparser.g:160:13: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_BRACE"

	// $ANTLR start "RIGHT_BRACE"
	public final void mRIGHT_BRACE() throws RecognitionException {
		try {
			int _type = RIGHT_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:161:12: ( '}' )
			// myparser.g:161:14: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_BRACE"

	// $ANTLR start "LEFT_PAREN"
	public final void mLEFT_PAREN() throws RecognitionException {
		try {
			int _type = LEFT_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:162:11: ( '(' )
			// myparser.g:162:13: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_PAREN"

	// $ANTLR start "RIGHT_PAREN"
	public final void mRIGHT_PAREN() throws RecognitionException {
		try {
			int _type = RIGHT_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:163:12: ( ')' )
			// myparser.g:163:14: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_PAREN"

	// $ANTLR start "LEFT_BRACKET"
	public final void mLEFT_BRACKET() throws RecognitionException {
		try {
			int _type = LEFT_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:164:13: ( '[' )
			// myparser.g:164:15: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_BRACKET"

	// $ANTLR start "RIGHT_BRACKET"
	public final void mRIGHT_BRACKET() throws RecognitionException {
		try {
			int _type = RIGHT_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:165:14: ( ']' )
			// myparser.g:165:16: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_BRACKET"

	@Override
	public void mTokens() throws RecognitionException {
		// myparser.g:1:8: ( T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | FLOAT | INT | CHAR | DOUBLE | MAIN | VOID | IF | ELSE | FOR | WHILE | RETURN | BREAK | CONTINUE | PRINTF | SCANF | MALLOC | SIZEOF | Identifier | Integer_constant | Floating_point_constant | WS | COMMENT | LESS | GREATER | LE_EQ | GR_EQ | NOT_EQ | EQ | NOT | AND | OR | AND_AND | OR_OR | ADD | MINUS | BSLASH | SLASH | LEFT_BRACE | RIGHT_BRACE | LEFT_PAREN | RIGHT_PAREN | LEFT_BRACKET | RIGHT_BRACKET )
		int alt6=51;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// myparser.g:1:10: T__47
				{
				mT__47(); 

				}
				break;
			case 2 :
				// myparser.g:1:16: T__48
				{
				mT__48(); 

				}
				break;
			case 3 :
				// myparser.g:1:22: T__49
				{
				mT__49(); 

				}
				break;
			case 4 :
				// myparser.g:1:28: T__50
				{
				mT__50(); 

				}
				break;
			case 5 :
				// myparser.g:1:34: T__51
				{
				mT__51(); 

				}
				break;
			case 6 :
				// myparser.g:1:40: T__52
				{
				mT__52(); 

				}
				break;
			case 7 :
				// myparser.g:1:46: T__53
				{
				mT__53(); 

				}
				break;
			case 8 :
				// myparser.g:1:52: T__54
				{
				mT__54(); 

				}
				break;
			case 9 :
				// myparser.g:1:58: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 10 :
				// myparser.g:1:64: INT
				{
				mINT(); 

				}
				break;
			case 11 :
				// myparser.g:1:68: CHAR
				{
				mCHAR(); 

				}
				break;
			case 12 :
				// myparser.g:1:73: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 13 :
				// myparser.g:1:80: MAIN
				{
				mMAIN(); 

				}
				break;
			case 14 :
				// myparser.g:1:85: VOID
				{
				mVOID(); 

				}
				break;
			case 15 :
				// myparser.g:1:90: IF
				{
				mIF(); 

				}
				break;
			case 16 :
				// myparser.g:1:93: ELSE
				{
				mELSE(); 

				}
				break;
			case 17 :
				// myparser.g:1:98: FOR
				{
				mFOR(); 

				}
				break;
			case 18 :
				// myparser.g:1:102: WHILE
				{
				mWHILE(); 

				}
				break;
			case 19 :
				// myparser.g:1:108: RETURN
				{
				mRETURN(); 

				}
				break;
			case 20 :
				// myparser.g:1:115: BREAK
				{
				mBREAK(); 

				}
				break;
			case 21 :
				// myparser.g:1:121: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 22 :
				// myparser.g:1:130: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 23 :
				// myparser.g:1:137: SCANF
				{
				mSCANF(); 

				}
				break;
			case 24 :
				// myparser.g:1:143: MALLOC
				{
				mMALLOC(); 

				}
				break;
			case 25 :
				// myparser.g:1:150: SIZEOF
				{
				mSIZEOF(); 

				}
				break;
			case 26 :
				// myparser.g:1:157: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 27 :
				// myparser.g:1:168: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 28 :
				// myparser.g:1:185: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 29 :
				// myparser.g:1:209: WS
				{
				mWS(); 

				}
				break;
			case 30 :
				// myparser.g:1:212: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 31 :
				// myparser.g:1:220: LESS
				{
				mLESS(); 

				}
				break;
			case 32 :
				// myparser.g:1:225: GREATER
				{
				mGREATER(); 

				}
				break;
			case 33 :
				// myparser.g:1:233: LE_EQ
				{
				mLE_EQ(); 

				}
				break;
			case 34 :
				// myparser.g:1:239: GR_EQ
				{
				mGR_EQ(); 

				}
				break;
			case 35 :
				// myparser.g:1:245: NOT_EQ
				{
				mNOT_EQ(); 

				}
				break;
			case 36 :
				// myparser.g:1:252: EQ
				{
				mEQ(); 

				}
				break;
			case 37 :
				// myparser.g:1:255: NOT
				{
				mNOT(); 

				}
				break;
			case 38 :
				// myparser.g:1:259: AND
				{
				mAND(); 

				}
				break;
			case 39 :
				// myparser.g:1:263: OR
				{
				mOR(); 

				}
				break;
			case 40 :
				// myparser.g:1:266: AND_AND
				{
				mAND_AND(); 

				}
				break;
			case 41 :
				// myparser.g:1:274: OR_OR
				{
				mOR_OR(); 

				}
				break;
			case 42 :
				// myparser.g:1:280: ADD
				{
				mADD(); 

				}
				break;
			case 43 :
				// myparser.g:1:284: MINUS
				{
				mMINUS(); 

				}
				break;
			case 44 :
				// myparser.g:1:290: BSLASH
				{
				mBSLASH(); 

				}
				break;
			case 45 :
				// myparser.g:1:297: SLASH
				{
				mSLASH(); 

				}
				break;
			case 46 :
				// myparser.g:1:303: LEFT_BRACE
				{
				mLEFT_BRACE(); 

				}
				break;
			case 47 :
				// myparser.g:1:314: RIGHT_BRACE
				{
				mRIGHT_BRACE(); 

				}
				break;
			case 48 :
				// myparser.g:1:326: LEFT_PAREN
				{
				mLEFT_PAREN(); 

				}
				break;
			case 49 :
				// myparser.g:1:337: RIGHT_PAREN
				{
				mRIGHT_PAREN(); 

				}
				break;
			case 50 :
				// myparser.g:1:349: LEFT_BRACKET
				{
				mLEFT_BRACKET(); 

				}
				break;
			case 51 :
				// myparser.g:1:362: RIGHT_BRACKET
				{
				mRIGHT_BRACKET(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\4\uffff\1\46\1\uffff\1\50\1\uffff\1\52\14\25\1\uffff\1\73\1\uffff\1\76"+
		"\1\100\1\102\1\104\1\106\1\110\15\uffff\3\25\1\114\14\25\16\uffff\1\25"+
		"\1\133\1\134\1\uffff\16\25\2\uffff\1\153\2\25\1\156\1\25\1\160\1\161\6"+
		"\25\1\170\1\uffff\2\25\1\uffff\1\25\2\uffff\1\174\1\25\1\176\1\25\1\u0080"+
		"\1\25\1\uffff\1\25\1\u0083\1\u0084\1\uffff\1\u0085\1\uffff\1\u0086\1\uffff"+
		"\1\u0087\1\25\5\uffff\1\u0089\1\uffff";
	static final String DFA6_eofS =
		"\u008a\uffff";
	static final String DFA6_minS =
		"\1\11\3\uffff\1\53\1\uffff\1\55\1\uffff\1\75\1\154\1\146\1\150\1\157\1"+
		"\141\1\157\1\154\1\150\1\145\2\162\1\143\1\uffff\1\56\1\uffff\1\52\3\75"+
		"\1\46\1\174\15\uffff\1\157\1\162\1\164\1\60\1\141\1\156\1\165\2\151\1"+
		"\163\1\151\1\164\1\145\1\151\1\141\1\172\16\uffff\1\141\2\60\1\uffff\1"+
		"\162\1\164\1\142\1\156\1\154\1\144\1\145\1\154\1\165\1\141\2\156\1\145"+
		"\1\164\2\uffff\1\60\1\151\1\154\1\60\1\157\2\60\1\145\1\162\1\153\1\164"+
		"\1\146\1\157\1\60\1\uffff\1\156\1\145\1\uffff\1\143\2\uffff\1\60\1\156"+
		"\1\60\1\146\1\60\1\146\1\uffff\1\165\2\60\1\uffff\1\60\1\uffff\1\60\1"+
		"\uffff\1\60\1\145\5\uffff\1\60\1\uffff";
	static final String DFA6_maxS =
		"\1\175\3\uffff\1\53\1\uffff\1\55\1\uffff\1\75\1\157\1\156\2\157\1\141"+
		"\1\157\1\154\1\150\1\145\2\162\1\151\1\uffff\1\71\1\uffff\1\52\3\75\1"+
		"\46\1\174\15\uffff\1\157\1\162\1\164\1\172\1\141\1\156\1\165\1\154\1\151"+
		"\1\163\1\151\1\164\1\145\1\151\1\141\1\172\16\uffff\1\141\2\172\1\uffff"+
		"\1\162\1\164\1\142\1\156\1\154\1\144\1\145\1\154\1\165\1\141\2\156\1\145"+
		"\1\164\2\uffff\1\172\1\151\1\154\1\172\1\157\2\172\1\145\1\162\1\153\1"+
		"\164\1\146\1\157\1\172\1\uffff\1\156\1\145\1\uffff\1\143\2\uffff\1\172"+
		"\1\156\1\172\1\146\1\172\1\146\1\uffff\1\165\2\172\1\uffff\1\172\1\uffff"+
		"\1\172\1\uffff\1\172\1\145\5\uffff\1\172\1\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\uffff\1\7\15\uffff\1\32\1\uffff\1\35"+
		"\6\uffff\1\54\1\56\1\57\1\60\1\61\1\62\1\63\1\52\1\4\1\53\1\6\1\44\1\10"+
		"\20\uffff\1\33\1\34\1\36\1\55\1\41\1\37\1\42\1\40\1\43\1\45\1\50\1\46"+
		"\1\51\1\47\3\uffff\1\17\16\uffff\1\21\1\12\16\uffff\1\13\2\uffff\1\15"+
		"\1\uffff\1\16\1\20\6\uffff\1\11\3\uffff\1\22\1\uffff\1\24\1\uffff\1\27"+
		"\2\uffff\1\14\1\30\1\23\1\26\1\31\1\uffff\1\25";
	static final String DFA6_specialS =
		"\u008a\uffff}>";
	static final String[] DFA6_transitionS = {
			"\2\27\2\uffff\1\27\22\uffff\1\27\1\33\1\1\2\uffff\1\2\1\34\1\uffff\1"+
			"\41\1\42\1\3\1\4\1\5\1\6\1\uffff\1\30\12\26\1\uffff\1\7\1\31\1\10\1\32"+
			"\2\uffff\32\25\1\43\1\36\1\44\1\uffff\1\25\1\uffff\1\25\1\22\1\13\1\14"+
			"\1\17\1\11\2\25\1\12\3\25\1\15\2\25\1\23\1\25\1\21\1\24\2\25\1\16\1\20"+
			"\3\25\1\37\1\35\1\40",
			"",
			"",
			"",
			"\1\45",
			"",
			"\1\47",
			"",
			"\1\51",
			"\1\53\2\uffff\1\54",
			"\1\56\7\uffff\1\55",
			"\1\57\6\uffff\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71\5\uffff\1\72",
			"",
			"\1\74\1\uffff\12\26",
			"",
			"\1\75",
			"\1\77",
			"\1\101",
			"\1\103",
			"\1\105",
			"\1\107",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\111",
			"\1\112",
			"\1\113",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120\2\uffff\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\132",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\154",
			"\1\155",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\157",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\171",
			"\1\172",
			"",
			"\1\173",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\175",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\177",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0081",
			"",
			"\1\u0082",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0088",
			"",
			"",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | FLOAT | INT | CHAR | DOUBLE | MAIN | VOID | IF | ELSE | FOR | WHILE | RETURN | BREAK | CONTINUE | PRINTF | SCANF | MALLOC | SIZEOF | Identifier | Integer_constant | Floating_point_constant | WS | COMMENT | LESS | GREATER | LE_EQ | GR_EQ | NOT_EQ | EQ | NOT | AND | OR | AND_AND | OR_OR | ADD | MINUS | BSLASH | SLASH | LEFT_BRACE | RIGHT_BRACE | LEFT_PAREN | RIGHT_PAREN | LEFT_BRACKET | RIGHT_BRACKET );";
		}
	}

}
