// $ANTLR 3.5.2 Expr.g 2022-04-15 23:58:10

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int IDENTIFIER=4;
	public static final int LETTER=5;
	public static final int LOGIC_VALUE=6;
	public static final int Number=7;
	public static final int WS=8;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExprLexer() {} 
	public ExprLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Expr.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:2:6: ( '(' )
			// Expr.g:2:8: '('
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:3:7: ( ')' )
			// Expr.g:3:9: ')'
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:4:7: ( '*' )
			// Expr.g:4:9: '*'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:5:7: ( '+' )
			// Expr.g:5:9: '+'
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:6:7: ( '-' )
			// Expr.g:6:9: '-'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:7:7: ( '/' )
			// Expr.g:7:9: '/'
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
	// $ANTLR end "T__14"

	// $ANTLR start "Number"
	public final void mNumber() throws RecognitionException {
		try {
			int _type = Number;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:34:7: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// Expr.g:34:9: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// Expr.g:34:9: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Expr.g:
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// Expr.g:34:22: ( '.' ( '0' .. '9' )+ )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='.') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// Expr.g:34:23: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// Expr.g:34:27: ( '0' .. '9' )+
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
							// Expr.g:
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
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Number"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:37:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// Expr.g:37:5: ( ' ' | '\\t' | '\\r' | '\\n' )
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

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			int _type = LETTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:39:7: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
			// Expr.g:
			{
			if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:41:11: ( LETTER ( LETTER | '0' .. '0' )* )
			// Expr.g:41:13: LETTER ( LETTER | '0' .. '0' )*
			{
			mLETTER(); 

			// Expr.g:41:20: ( LETTER | '0' .. '0' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='$'||LA4_0=='0'||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// Expr.g:
					{
					if ( input.LA(1)=='$'||input.LA(1)=='0'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop4;
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
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "LOGIC_VALUE"
	public final void mLOGIC_VALUE() throws RecognitionException {
		try {
			int _type = LOGIC_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expr.g:43:12: ( '==' | '!=' | '>' | '<' | '>=' | '<=' )
			int alt5=6;
			switch ( input.LA(1) ) {
			case '=':
				{
				alt5=1;
				}
				break;
			case '!':
				{
				alt5=2;
				}
				break;
			case '>':
				{
				int LA5_3 = input.LA(2);
				if ( (LA5_3=='=') ) {
					alt5=5;
				}

				else {
					alt5=3;
				}

				}
				break;
			case '<':
				{
				int LA5_4 = input.LA(2);
				if ( (LA5_4=='=') ) {
					alt5=6;
				}

				else {
					alt5=4;
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// Expr.g:43:14: '=='
					{
					match("=="); 

					}
					break;
				case 2 :
					// Expr.g:43:21: '!='
					{
					match("!="); 

					}
					break;
				case 3 :
					// Expr.g:43:28: '>'
					{
					match('>'); 
					}
					break;
				case 4 :
					// Expr.g:43:34: '<'
					{
					match('<'); 
					}
					break;
				case 5 :
					// Expr.g:43:40: '>='
					{
					match(">="); 

					}
					break;
				case 6 :
					// Expr.g:43:47: '<='
					{
					match("<="); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOGIC_VALUE"

	@Override
	public void mTokens() throws RecognitionException {
		// Expr.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | Number | WS | LETTER | IDENTIFIER | LOGIC_VALUE )
		int alt6=11;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt6=1;
			}
			break;
		case ')':
			{
			alt6=2;
			}
			break;
		case '*':
			{
			alt6=3;
			}
			break;
		case '+':
			{
			alt6=4;
			}
			break;
		case '-':
			{
			alt6=5;
			}
			break;
		case '/':
			{
			alt6=6;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=7;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt6=8;
			}
			break;
		case '$':
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case '_':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			int LA6_9 = input.LA(2);
			if ( (LA6_9=='$'||LA6_9=='0'||(LA6_9 >= 'A' && LA6_9 <= 'Z')||LA6_9=='_'||(LA6_9 >= 'a' && LA6_9 <= 'z')) ) {
				alt6=10;
			}

			else {
				alt6=9;
			}

			}
			break;
		case '!':
		case '<':
		case '=':
		case '>':
			{
			alt6=11;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// Expr.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// Expr.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// Expr.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// Expr.g:1:27: T__12
				{
				mT__12(); 

				}
				break;
			case 5 :
				// Expr.g:1:33: T__13
				{
				mT__13(); 

				}
				break;
			case 6 :
				// Expr.g:1:39: T__14
				{
				mT__14(); 

				}
				break;
			case 7 :
				// Expr.g:1:45: Number
				{
				mNumber(); 

				}
				break;
			case 8 :
				// Expr.g:1:52: WS
				{
				mWS(); 

				}
				break;
			case 9 :
				// Expr.g:1:55: LETTER
				{
				mLETTER(); 

				}
				break;
			case 10 :
				// Expr.g:1:62: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 11 :
				// Expr.g:1:73: LOGIC_VALUE
				{
				mLOGIC_VALUE(); 

				}
				break;

		}
	}



}
