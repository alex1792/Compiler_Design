lexer grammar mylexer;

options {
	language = Java;
}

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE: 'integer';
CHAR_TYPE: 'char';
VOID_TYPE: 'void';
INT: 'int';
FLOAT_TYPE: 'float';
DOUBLE_TYPE: 'double';
LONG: 'long';
STRUCT: 'struct';

MAIN: 'main';

SIZE_OF: 'sizeof';
MALLOC: 'malloc';
FREE: 'free';
SCANF: 'scanf';
PRINTF: 'printf';
STRCMP: 'strcmp';
STRCPY: 'strcpy';
STRSTR: 'strstr';

WHILE: 'while';
FOR: 'for';
IF: 'if';
ELSE: 'else';
ELSE_IF: (ELSE) ' ' (IF);
BREAK: 'break';
CONTINUE: 'continue';

LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
BACK_SLASH: '\\';

LESS: '<';
GREATER: '>';

PLUS: '+';
MINUS: '-';
MULTIPLE: '*';
DEVIDE: '/';
MOD: '%';

AND: '&';
OR: '|';
AND_AND: '&&';
OR_OR: '||';
NOT: '!';

COLON: ':';
SEMI_COLON: ';';
COMMA: ',';
DOT: '.';
QUOTATION: '"';

ASSIGN: '=';
STAR_ASSIGN: '*=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MOD_ASSIGN: '%=';

RETURN: 'return';

/*----------------------*/
/*  Compound Operators  */
/*----------------------*/

EQ_OP: '==';
LE_OP: '<=';
GE_OP: '>=';
NE_OP: '!=';
PP_OP: '++';
MM_OP: '--';
RSHIFT_OP: '<<';
LSHIFT_OP: '>>';

DEC_NUM: ('0' | ('1' ..'9') (DIGIT)*);

ID: (LETTER) (LETTER | DIGIT)*;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
fragment FLOAT_NUM1: (DIGIT)+ '.' (DIGIT)*;
fragment FLOAT_NUM2: '.' (DIGIT)+;
fragment FLOAT_NUM3: (DIGIT)+;

/* Comments */
COMMENT1: '//' (.)* '\n';
COMMENT2: '/*' (options {greedy = false;
		}: .
		)* '*/';

	fragment LETTER: 'a' ..'z' | 'A' ..'Z' | '_';
	fragment DIGIT: '0' ..'9';

	WS: (' ' | (BACK_SLASH ('r' | 't')) | '\t' | '\r')+;

	NEW_LINE: (BACK_SLASH 'n' | '\n');

	INCLUDE_DIRECTIVE:
		'#' WS? 'include' WS? '<' ID DOT ID '>' WS*;

	PRINTF_FUNCTION:
		PRINTF LEFT_PAREN QUOTATION (
			LETTER
			| DIGIT
			| WS
			| NEW_LINE
			| MOD
			| AND
			| COMMA
		)* QUOTATION (COMMA WS? ID)* RIGHT_PAREN SEMI_COLON;

	SCANF_FUNCTION:
		SCANF LEFT_PAREN QUOTATION (
			LETTER
			| DIGIT
			| WS
			| NEW_LINE
			| MOD
			| AND
			| COMMA
		)* QUOTATION (COMMA WS? AND? ID)* RIGHT_PAREN SEMI_COLON;

	MAIN_FUNCTION:
		(VOID_TYPE | INT) WS 'main' WS? LEFT_PAREN (
			DIGIT
			| LETTER
			| COMMA
			| WS
			| LEFT_BRACKET
			| RIGHT_BRACKET
		)* RIGHT_PAREN;

	FUNCTION_SPECIFIER:
		(
			VOID_TYPE
			| INT
			| DOUBLE_TYPE
			| FLOAT_TYPE
			| CHAR_TYPE
			| LONG
		) WS ID WS? LEFT_PAREN (
			DIGIT
			| COMMA
			| LETTER
			| LEFT_BRACKET
			| RIGHT_BRACKET
			| WS
		)* RIGHT_PAREN;

	ASSIGN_SPECIFIER:
		(INT | DOUBLE_TYPE | FLOAT_TYPE | CHAR_TYPE | LONG) WS? MULTIPLE? (
			DIGIT
			| ID
		) WS? (
			ASSIGN
			| STAR_ASSIGN
			| PLUS_ASSIGN
			| MINUS_ASSIGN
			| MOD_ASSIGN
		) WS? (ID | DIGIT | MALLOC_FUNCTION | SIZE_OF_FUNCTION) (
			WS? (
				PLUS
				| MINUS
				| MULTIPLE
				| DEVIDE
				| MOD
				| ID
				| DIGIT
			)
		)* WS? SEMI_COLON;

	MALLOC_FUNCTION:
		MALLOC WS? LEFT_PAREN (
			DIGIT
			| LETTER
			| WS
			| LEFT_PAREN
			| RIGHT_PAREN
		)* RIGHT_PAREN;

	SIZE_OF_FUNCTION:
		SIZE_OF LEFT_PAREN (
			DIGIT
			| LETTER
			| WS
			| LEFT_PAREN
			| RIGHT_PAREN
		)* RIGHT_PAREN;