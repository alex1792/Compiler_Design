grammar Expr;

/* This will be the entry point of our parser. */
eval: statement;

/* Addition and subtraction have the lowest precedence. */
additionExp: multiplyExp ( '+' multiplyExp | '-' multiplyExp)*;

/* Multiplication and division have a higher precedence. */
multiplyExp: atomExp ( '*' atomExp | '/' atomExp)*;

/* An expression atom is the smallest part of an expression: a number. Or when we encounter
 parenthesis, we're making a recursive call back to the rule 'additionExp'. As you can see, an
 'atomExp' has the highest precedence.
 */
atomExp: Number | IDENTIFIER | '(' additionExp ')';

// statement 
statement expression_statement
| selection_statement
| iteration_statement;

expression_statement: ';' | expression ';';

selection_statement:
	'if' '(' expression ')' statement ('else' statement)?
	| 'switch' '(' expression ')' statement;

iteration_statement:
	'while' '(' expression ')' statement
	| 'for' '(' expression_statement expression_statement expression? ')' statement;

// expression 
expression:
	expression LOGIC_VALUE expression
	| IDENTIFIER (additionExp)*
	| IDENTIFIER '=' expression;

unary_operator: '&' | '*' | '+' | '-' | '~' | '!';

/* A number: can be an integer value, or a decimal value */
Number: ('0' ..'9')+ ('.' ('0' ..'9')+)?;

/* We're going to ignore all white space characters */
WS: (' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;};

LETTER: '$' | 'A' ..'Z' | 'a' ..'z' | '_';

IDENTIFIER: LETTER (LETTER | '0' ..'0')*;

LOGIC_VALUE: '==' | '!=' | '>' | '<' | '>=' | '<=';