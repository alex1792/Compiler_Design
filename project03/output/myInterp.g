grammar myInterp;

options {
	language = Java;
}

@header {
    import java.util.HashMap;
}

@members {
    boolean TRACEON = true;
	HashMap memory = new HashMap();
	// String s = "";
}

program:
	VOID MAIN '(' ')' '{' declarations statements '}'
	| INT MAIN '(' ')' '{' declarations statements return_statememt '}';

declarations:
	type Identifier (',' Identifier)* ';' declarations
	|;

type: INT | FLOAT | CHAR | DOUBLE;

statements: statement statements |;

arith_expression
	returns[int value]:
	a = multExpr {if (TRACEON) $value = $a.value;} (
		(
			'+' b = multExpr {if (TRACEON)$value = $value + $b.value;}
			| '-' c = multExpr {if (TRACEON)$value = $value - $c.value;}
		)*
		| ADD
		| MINUS
	)
	|;

multExpr
	returns[int value]:
	a = signExpr {if (TRACEON) $value = $a.value;} (
		'*' b = signExpr {if (TRACEON) $value = $value * $b.value;}
		| '/' c = signExpr {if (TRACEON) $value = $value / $c.value;}
	)*;

signExpr
	returns[int value]:
	a = primaryExpr {if (TRACEON) $value = $a.value;}
	| '-' b = primaryExpr {if (TRACEON) $value = -$b.value;};

logic_expression:
	a = primaryExpr logic_operator b = primaryExpr {
		TRACEON = true;
		if ($logic_operator.value == 1)
{if ($a.value >= $b.value) TRACEON = false;}
else if($logic_operator.value == 2)
{if ($a.value <= $b.value) TRACEON = false;}
else if($logic_operator.value == 3)
{if ($a.value > $b.value) TRACEON = false;}
else if($logic_operator.value == 4)
{if ($a.value < $b.value) TRACEON = false;}
	else if($logic_operator.value == 5)
{if ($a.value == $b.value) TRACEON = false;}
}
	|;

logic_operator
	returns[int value]: (
		LESS {$value = 1;}
		| GREATER {$value = 2;}
		| LE_EQ {$value = 3;}
		| GR_EQ {$value = 4;}
		| NOT_EQ {$value = 5;}
	);

primaryExpr
	returns[int value]:
	Integer_constant {$value = Integer.parseInt($Integer_constant.text);}
	| Identifier {Integer v = (Integer)memory.get($Identifier.text);
        if ( v!=null ) $value = v.intValue();
        else System.err.println("undefined variable "+$Identifier.text);}
	| '(' arith_expression ')' {$value = $arith_expression.value;};

assignment_statement:
	Identifier '=' arith_expression {if (TRACEON) System.out.println($arith_expression.value);} ';'
		{if (TRACEON) memory.put($Identifier.text, new Integer($arith_expression.value));
		};

function_statememt:
	PRINTF '(' printf_argument_expression ')' ';'
	| SCANF '(' argument_expression ')' ';'
	| MALLOC '(' (Integer_constant* | (SIZEOF '(' type ')')) ')';

argument_expression:
	string_constant (',' ( Identifier | WS | '&')*)*;

printf_argument_expression
	@init {ArrayList<Integer> buffer = new ArrayList<Integer>();}:
	str = string_constant (
		',' (
			Identifier {
			Integer v1 = (Integer)memory.get($Identifier.text);
		buffer.add(v1.intValue());}
			| WS
		)*
	)* {String s = new String($str.text);
		s = s.substring(1, s.length() - 1);
		s = s.replace("\\n", "\n");
		for(int i = 0; i < buffer.size(); i++)
		{
			s = s.replace("\%d", (buffer.get(i)).toString());
		}
		System.out.println(s);};

string_constant: '\"' (.)* '\"';

io_data_type: PerC | PerD | PerF | PerS;

statement:
	assignment_statement
	| IF '(' logic_expression {System.out.println(TRACEON);} ')' if_then_statements
	| WHILE '(' logic_expression ')' if_then_statements
	| FOR '(' assignment_statement logic_expression ';' arith_expression ')' if_then_statements
	| function_statememt;

if_then_statements:
	statement
	| '{' statements '}' else_statements
	| loop_control_statement else_statements;

else_statements:
	ELSE {TRACEON = !TRACEON; System.out.println(TRACEON);} if_then_statements
	// | ELSE '{' statements '}' {if (TRACEON) System.out.println("else_statements: ELSE {
	// statements }"); }
	|;

loop_control_statement: BREAK ';' | CONTINUE ';';

return_statememt: RETURN arith_expression ';';

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

// I/O data type
PerD: '%d';
PerC: '%c';
PerS: '%s';
PerF: '%f';
