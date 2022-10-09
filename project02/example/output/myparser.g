grammar myparser;

options {
	language = Java;
}

@header {
    // import packages here.
}

@members {
    boolean TRACEON = true;
}

program:
	VOID MAIN '(' ')' '{' declarations statements '}' {if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");
		}
	| INT MAIN '(' ')' '{' declarations statements return_statememt '}' {if (TRACEON) System.out.println("INT MAIN () {declarations statements return_statement}");
	};

declarations:
	type Identifier ';' declarations { if (TRACEON) System.out.println("declarations: type Identifier : declarations"); 
		}
	| { if (TRACEON) System.out.println("declarations: ");};

type:
	INT { if (TRACEON) System.out.println("type: INT"); }
	| FLOAT {if (TRACEON) System.out.println("type: FLOAT"); }
	| CHAR {if (TRACEON) System.out.println("type:CHAR"); }
	| DOUBLE {if (TRACEON) System.out.println("type: DOUBLE"); };

statements: statement statements |;

arith_expression:
	multExpr (( '+' multExpr | '-' multExpr)* | ADD | MINUS)
	|;

multExpr: signExpr ( '*' signExpr | '/' signExpr)*;

signExpr: primaryExpr | '-' primaryExpr;

logic_expression: primaryExpr logic_operator primaryExpr |;

logic_operator: (LESS | GREATER | LE_EQ | GR_EQ | NOT | NOT_EQ);

primaryExpr:
	Integer_constant
	| Floating_point_constant
	| Identifier
	| '(' arith_expression ')';

assignment_statement:
	Identifier '=' arith_expression ';' {if (TRACEON) System.out.println("assignment_statememt: Idnetifier = arith_expression ;");
		};

function_statememt:
	PRINTF '(' argument_expression ')' ';' {if (TRACEON) System.out.println("function_statement: PRINTF ( argument_expression );");
		}
	| SCANF '(' argument_expression ')' ';'
	| MALLOC '(' (Integer_constant* | (SIZEOF '(' type ')')) ')';

argument_expression:
	'"' (
		Identifier
		| WS
		| '%'
		| BSLASH
		| SLASH
		| AND
		| LEFT_BRACKET
		| RIGHT_BRACKET
	)* '"' (',' (Identifier | WS | '%')*)*;

statement:
	assignment_statement
	| IF {if (TRACEON) System.out.println("statement: IF ( arith_esxpression ) if_then_statement");
		} '(' arith_expression ')' if_then_statements
	| WHILE {if (TRACEON) System.out.println("statement: WHILE ( arith_esxpression ) if_then_statement");
		} '(' arith_expression ')' if_then_statements
	| FOR {if (TRACEON) System.out.println("statement: FOR ( statement logic_expression; arith_expression ) if_then_statement");
		} '(' assignment_statement logic_expression ';' arith_expression ')' if_then_statements
	| function_statememt;

if_then_statements:
	statement
	| '{' statements '}' else_statements
	| loop_control_statement else_statements;

else_statements:
	ELSE if_then_statements {if (TRACEON) System.out.println("else_statements: ELSE statement");
		}
	// | ELSE '{' statements '}' {if (TRACEON) System.out.println("else_statements: ELSE {
	// statements }"); }
	| {if (TRACEON) System.out.println("else_statements: ");
		};

loop_control_statement:
	BREAK ';' {if (TRACEON) System.out.println("loop_control_statement: BREAK;");}
	| CONTINUE ';' {if (TRACEON) System.out.println("loop_control_statement: CONTINUE;");
			};

return_statememt: RETURN arith_expression ';';

// logic_operator: LESS | GREATER LE_EQ | GR_EQ | NOT_EQ | EQ;

/* description of the tokens */
FLOAT: 'float';
INT: 'int';
CHAR: 'char';
DOUBLE: 'double';
MAIN: 'main';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
RETURN: 'return';
BREAK: 'break';
CONTINUE: 'continue';

//  function
PRINTF: 'printf';
SCANF: 'scanf';
MALLOC: 'malloc';
SIZEOF: 'sizeof';

Identifier: ('a' ..'z' | 'A' ..'Z' | '_') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;
Integer_constant: '0' ..'9'+;
Floating_point_constant: '0' ..'9'+ '.' '0' ..'9'+;

WS: ( ' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;};
COMMENT: '/*' .* '*/' {$channel=HIDDEN;};

//  logic operator
LESS: '<';
GREATER: '>';
LE_EQ: '<=';
GR_EQ: '>=';
NOT_EQ: '!=';
EQ: '==';

NOT: '!';
AND: '&';
OR: '|';
AND_AND: '&&';
OR_OR: '||';

// arith operator
ADD: '++';
MINUS: '--';

//  special character
BSLASH: '\\';
SLASH: '/';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
