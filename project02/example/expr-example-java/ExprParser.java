// $ANTLR 3.5.2 Expr.g 2022-04-15 23:58:10

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "LETTER", "LOGIC_VALUE", 
		"Number", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'/'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Expr.g"; }



	// $ANTLR start "eval"
	// Expr.g:4:1: eval : additionExp ;
	public final void eval() throws RecognitionException {
		try {
			// Expr.g:4:5: ( additionExp )
			// Expr.g:4:7: additionExp
			{
			pushFollow(FOLLOW_additionExp_in_eval11);
			additionExp();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "eval"



	// $ANTLR start "additionExp"
	// Expr.g:7:1: additionExp : multiplyExp ( '+' multiplyExp | '-' multiplyExp )* ;
	public final void additionExp() throws RecognitionException {
		try {
			// Expr.g:7:12: ( multiplyExp ( '+' multiplyExp | '-' multiplyExp )* )
			// Expr.g:7:14: multiplyExp ( '+' multiplyExp | '-' multiplyExp )*
			{
			pushFollow(FOLLOW_multiplyExp_in_additionExp20);
			multiplyExp();
			state._fsp--;

			// Expr.g:7:26: ( '+' multiplyExp | '-' multiplyExp )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==12) ) {
					alt1=1;
				}
				else if ( (LA1_0==13) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// Expr.g:7:28: '+' multiplyExp
					{
					match(input,12,FOLLOW_12_in_additionExp24); 
					pushFollow(FOLLOW_multiplyExp_in_additionExp26);
					multiplyExp();
					state._fsp--;

					}
					break;
				case 2 :
					// Expr.g:7:46: '-' multiplyExp
					{
					match(input,13,FOLLOW_13_in_additionExp30); 
					pushFollow(FOLLOW_multiplyExp_in_additionExp32);
					multiplyExp();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "additionExp"



	// $ANTLR start "multiplyExp"
	// Expr.g:10:1: multiplyExp : atomExp ( '*' atomExp | '/' atomExp )* ;
	public final void multiplyExp() throws RecognitionException {
		try {
			// Expr.g:10:12: ( atomExp ( '*' atomExp | '/' atomExp )* )
			// Expr.g:10:14: atomExp ( '*' atomExp | '/' atomExp )*
			{
			pushFollow(FOLLOW_atomExp_in_multiplyExp43);
			atomExp();
			state._fsp--;

			// Expr.g:10:22: ( '*' atomExp | '/' atomExp )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==11) ) {
					alt2=1;
				}
				else if ( (LA2_0==14) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// Expr.g:10:24: '*' atomExp
					{
					match(input,11,FOLLOW_11_in_multiplyExp47); 
					pushFollow(FOLLOW_atomExp_in_multiplyExp49);
					atomExp();
					state._fsp--;

					}
					break;
				case 2 :
					// Expr.g:10:38: '/' atomExp
					{
					match(input,14,FOLLOW_14_in_multiplyExp53); 
					pushFollow(FOLLOW_atomExp_in_multiplyExp55);
					atomExp();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "multiplyExp"



	// $ANTLR start "atomExp"
	// Expr.g:16:1: atomExp : ( Number | IDENTIFIER | '(' additionExp ')' );
	public final void atomExp() throws RecognitionException {
		try {
			// Expr.g:16:8: ( Number | IDENTIFIER | '(' additionExp ')' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case Number:
				{
				alt3=1;
				}
				break;
			case IDENTIFIER:
				{
				alt3=2;
				}
				break;
			case 9:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// Expr.g:16:10: Number
					{
					match(input,Number,FOLLOW_Number_in_atomExp66); 
					}
					break;
				case 2 :
					// Expr.g:16:19: IDENTIFIER
					{
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atomExp70); 
					}
					break;
				case 3 :
					// Expr.g:16:32: '(' additionExp ')'
					{
					match(input,9,FOLLOW_9_in_atomExp74); 
					pushFollow(FOLLOW_additionExp_in_atomExp76);
					additionExp();
					state._fsp--;

					match(input,10,FOLLOW_10_in_atomExp78); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atomExp"

	// Delegated rules



	public static final BitSet FOLLOW_additionExp_in_eval11 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiplyExp_in_additionExp20 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_12_in_additionExp24 = new BitSet(new long[]{0x0000000000000290L});
	public static final BitSet FOLLOW_multiplyExp_in_additionExp26 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_13_in_additionExp30 = new BitSet(new long[]{0x0000000000000290L});
	public static final BitSet FOLLOW_multiplyExp_in_additionExp32 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_atomExp_in_multiplyExp43 = new BitSet(new long[]{0x0000000000004802L});
	public static final BitSet FOLLOW_11_in_multiplyExp47 = new BitSet(new long[]{0x0000000000000290L});
	public static final BitSet FOLLOW_atomExp_in_multiplyExp49 = new BitSet(new long[]{0x0000000000004802L});
	public static final BitSet FOLLOW_14_in_multiplyExp53 = new BitSet(new long[]{0x0000000000000290L});
	public static final BitSet FOLLOW_atomExp_in_multiplyExp55 = new BitSet(new long[]{0x0000000000004802L});
	public static final BitSet FOLLOW_Number_in_atomExp66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_atomExp70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_atomExp74 = new BitSet(new long[]{0x0000000000000290L});
	public static final BitSet FOLLOW_additionExp_in_atomExp76 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_atomExp78 = new BitSet(new long[]{0x0000000000000002L});
}
