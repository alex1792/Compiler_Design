grammar myCompiler;

options {
	language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
}

@members {
    boolean TRACEON = false;

    // Type information.
    public enum Type{
       ERR, BOOL, INT, FLOAT, CHAR, CONST_INT, CONST_FLOAT;
    }

    //   logic operator
    public enum RelationOP_type
    {
       GT, LT, GE, LE, EQ, NE;
    }

    // This structure is used to record the information of a variable or a constant.
    class tVar {
	   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
	   int   iValue;   // value of constant integer. Ex: 123.
	   float fValue;   // value of constant floating point. Ex: 2.314.
	};

    class Info {
       Type theType;  // type information.
       tVar theVar;
	   
	   Info() {
          theType = Type.ERR;
		  theVar = new tVar();
	   }
    };

	
    // ============================================
    // Create a symbol table.
	// ArrayList is easy to extend to add more info. into symbol table.
	//
	// The structure of symbol table:
	// <variable ID, [Type, [varIndex or iValue, or fValue]]>
	//    - type: the variable type   (please check "enum Type")
	//    - varIndex: the variable's index, ex: t1, t2, ...
	//    - iValue: value of integer constant.
	//    - fValue: value of floating-point constant.
    // ============================================

    HashMap<String, Info> symtab = new HashMap<String, Info>();

    // labelCount is used to represent temporary label.
    // The first index is 0.
    int labelCount = 0;
	
    // varCount is used to represent temporary variables.
    // The first index is 0.
    int varCount = 0;

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();

    //   Record conditional expression
    int condCount = 0;

    //   Record printf
    int printfCount = 2;


    /*
     * Output prologue.
     */
    void prologue()
    {
       TextCode.add("; === prologue ====");
       TextCode.add("declare dso_local i32 @printf(i8*, ...)\n");
	   TextCode.add("define dso_local i32 @main()");
	   TextCode.add("{");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("\n; === epilogue ===");
	   TextCode.add("ret i32 0");
       TextCode.add("}");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getTextCode()
    {
       return TextCode;
    }
}

program:
	VOID MAIN '(' ')' {
           /* Output function prologue */
           prologue();
        } '{' declarations statements '}' {
	   if (TRACEON)
	      System.out.println("VOID MAIN () {declarations statements}");

           /* output function epilogue */	  
           epilogue();
        };

declarations:
	type Identifier ';' declarations {
            if (TRACEON)
               System.out.println("declarations: type Identifier : declarations");

            //  if the ID already exist in the symble table -> re-declaired
            if (symtab.containsKey($Identifier.text)) {
               System.out.println("Type Error: " +  $Identifier.getLine() + ": Redeclared identifier.");
               System.exit(0);
            }
                 
            /* Add ID and its info into the symbol table. */
	         Info the_entry = new Info();
		      the_entry.theType = $type.attr_type;
		      the_entry.theVar.varIndex = varCount;
		      varCount ++;
		      symtab.put($Identifier.text, the_entry);

            // generate instruction.
            //  INT->i32、FLOAT、CHAR->i8
            if ($type.attr_type == Type.INT) { 
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
            }
            else if($type.attr_type == Type.FLOAT){
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float");
            }
            else if($type.attr_type == Type.CHAR){
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i8");
            }
   }
	| {
           if (TRACEON)
              System.out.println("declarations: ");
      };

type
	returns[Type attr_type]:
	INT { if (TRACEON) System.out.println("type: INT"); $attr_type=Type.INT; }
	| CHAR { if (TRACEON) System.out.println("type: CHAR"); $attr_type=Type.CHAR; }
	| FLOAT {if (TRACEON) System.out.println("type: FLOAT"); $attr_type=Type.FLOAT; };

statements: statement statements |;

statement:
	assign_stmt ';'
	| if_stmt
	| func_no_return_stmt ';'
	| for_stmt
	| printf_stmt;

printf_stmt:
	PRINTF '(' STRING_LITERAL (',' a = argument)? ')' ';' {
            String newStr = $STRING_LITERAL.text;
            int len = newStr.length();
            int matched = 0;
            int pos = newStr.indexOf("\\n", 0);

            // pos = starting position, matched = numbers of matched characters
            while(pos != -1){
                matched++;
                pos = newStr.indexOf("\\n", pos + 1);
            }

            // plus 1 for EOF, minus 2 for ""
            len = len - matched - 2 + 1;

            newStr = newStr.replace("\\n", "\\0A");
            newStr = newStr.substring(0, newStr.length() - 1) + "\\00" + "\"";
            
            // get argument list
            String arg_list = "";
            if($a.text != null){
                for(int i = 0; i < $a.rec.size(); i++){
                    Type theType = $a.rec.get(i).theType;
                    switch(theType){
                        case INT:
                            arg_list = arg_list.concat(", i32 \%t" + $a.rec.get(i).theVar.varIndex);
                            break;

                        case FLOAT:
                            arg_list = arg_list.concat(", double \%t" + $a.rec.get(i).theVar.varIndex);
                            break;
                    }
                }
            }

            TextCode.add(printfCount, "@.str." + (printfCount - 2) + " = private unnamed_addr constant [" +
                        len + " x i8] c" + newStr + ", align 1");
            TextCode.add("\t\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" +
                        len + " x i8], [" + (len) + " x i8]* @.str." + (printfCount - 2) + ", i64 0, i64 0)" + 
                        arg_list + ")");
            printfCount++;
            varCount++;
            
            if (TRACEON) { 
                System.out.println("PRINT '(\"' STRING_LITERAL '\")'"); 
            }
        };

for_stmt
	@init {String assign = newLabel();}:
	FOR '(' assign_stmt ';' {
      String loop = newLabel();
	   TextCode.add("\tbr label \%" + loop);
      TextCode.add("\n" + loop + ":");
   } a = cond_expression ';' {
	   TextCode.add("\tbr i1 \%cond" + condCount + ", label \%" + $a.ctrue + ", label \%" + $a.cfalse);
      TextCode.add("\n" + assign + ":");
      condCount++;
   } assign_stmt {
      TextCode.add("\tbr label \%" + loop);
	   TextCode.add( "\n" + $a.ctrue + ":" );
   } ')' block_stmt {
      // a is the return value of conditional expression
	   TextCode.add("\tbr label \%" + assign);
      TextCode.add("\n" + $a.cfalse + ":");
   };

if_stmt:
	if_then_stmt if_else_stmt {
            TextCode.add( "\tbr label \%" + $if_then_stmt.ifend );
            TextCode.add( "\n" + $if_then_stmt.ifend + ":" );
         };

if_then_stmt
	returns[String ifend]:
	IF '(' cond_expression {
	   TextCode.add("\tbr i1 \%cond" + condCount + ", label \%" + $cond_expression.ctrue + ", label \%" + $cond_expression.cfalse);
      TextCode.add("\n" + $cond_expression.ctrue + ":");
      condCount++;
   } ')' block_stmt {
      if(TRACEON) System.out.println("IF ( cond_expression ) block_stmt");
      
      ifend = newLabel();
      TextCode.add("\tbr label \%" + ifend);
      TextCode.add("\n" + $cond_expression.cfalse + ":");
   };

if_else_stmt:
	ELSE block_stmt {if(TRACEON) System.out.println("if_else_stmt: ELSE block_stmt");}
	|;

block_stmt:
	'{' statements '}' {if(TRACEON) System.out.println("block_stmt: '{' statements '}'");};

assign_stmt:
	Identifier '=' arith_expression {
                Info theRHS = $arith_expression.theInfo;
				Info theLHS = symtab.get($Identifier.text); 
		   
                if ((theLHS.theType == Type.INT) &&
                    (theRHS.theType == Type.INT)) {		   
                   // issue store insruction.
                   // Ex: store i32 \%tx, i32* \%ty
                   TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex);
				} else if ((theLHS.theType == Type.INT) &&
				    (theRHS.theType == Type.CONST_INT)) {
                   // issue store insruction.
                   // Ex: store i32 value, i32* \%ty
                   TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex);				
				} else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
                  TextCode.add("\tstore float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex);
	         } else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
                  double tmp = theRHS.theVar.fValue;
                  // System.out.println(tmp);
                  long ans = Double.doubleToLongBits(tmp);
	               TextCode.add( "\tstore float 0x" + Long.toHexString(ans) + ", float* \%t" + theLHS.theVar.varIndex + ", align 4" );
	         } else if( ( theLHS.theType != theRHS.theType )  &&  ( theLHS.theType != Type.ERR ) && ( theRHS.theType != Type.ERR ) ){
                    System.out.println( "Error: " + $Identifier.getLine() + ": Type mismatch for the = operation in an expression." );
                    System.exit(0);
            }
			 };

func_no_return_stmt: Identifier '(' argument ')';

argument
	returns[ List<Info> rec ]
	@init { $rec = new ArrayList<Info>(); }:
	a = arg {
            $rec.add( $a.theInfo );
            if( $a.theInfo.theType == Type.FLOAT ){
                TextCode.add( "\t\%t" + varCount + " = fpext float \%t" + $a.theInfo.theVar.varIndex + " to double" );
                $a.theInfo.theVar.varIndex = varCount;
                varCount++;
            }
        } (
		',' b = arg {
            $rec.add( $b.theInfo );
            if( $b.theInfo.theType == Type.FLOAT ){
                TextCode.add( "\t\%t" + varCount + " = fpext float \%t" + $b.theInfo.theVar.varIndex + " to double" );
                $b.theInfo.theVar.varIndex = varCount;
                varCount++;
            }
        }
	)*;

arg
	returns[ Info theInfo ]:
	a = arith_expression {
	         // return the info of arithmatic expression
            $theInfo = $a.theInfo;
        }
	| STRING_LITERAL;

cond_expression
	returns[String ctrue, String cfalse]:
	a = arith_expression (relationOP b = arith_expression)* {
		// for each data type, there are four conditions
      // 1. var logic var        EX: a > b
      // 2. var logic const      EX: a > 5
      // 3. const logic const    EX: 5 > 3
      // 4. const logic var      EX: 5 > a
      // where logic represent: > < >= <= == != 
      // GT、LT、GE、LE、EQ、NE
      // icmp parameters: sgt、slt、sge、sle、eq、ne
      // fcmp parameters: ogt、olt、oge、ole、oeq、one
      
      //  Greater Than GT >
      if($relationOP.r_type == RelationOP_type.GT)
      {
         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sgt i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp ogt float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }
      // Less Than < LT
      else if ($relationOP.r_type == RelationOP_type.LT)
      {
	         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp slt i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp olt float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp olt float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }
      // Greater or Equal than >= GE
      else if($relationOP.r_type == RelationOP_type.GE)
      {
	         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sge i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp oge float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp oge float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }
      // Less or Equal than <= LE
	   else if($relationOP.r_type == RelationOP_type.LE)
      {
	         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp sle i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp ole float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp ole float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }
      // Equal == EQ
	   else if($relationOP.r_type == RelationOP_type.EQ)
      {
	         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp eq i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp oeq float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }
      // Not Equal != NE
	   else if($relationOP.r_type == RelationOP_type.NE)
      {
	         // 1. var > var
         if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT))
         { 
            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex );
         }
	      // 2. var > const
         else if( ( $a.theInfo.theType == Type.INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue );
         }
	      // 3. const > const
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.CONST_INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 " + $b.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue );
         }
	      // 4. const > var 
         else if( ( $a.theInfo.theType == Type.CONST_INT ) && ( $b.theInfo.theType == Type.INT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = icmp ne i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // float
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            TextCode.add( "\t\%cond" + condCount + " = fcmp one float \%t" + $a.theInfo.theVar.varIndex +  ", \%t" + $b.theInfo.theVar.varIndex );
         }
         else if( ( $a.theInfo.theType == Type.FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
            double val2 = $b.theInfo.theVar.fValue;
            long ans2 = Double.doubleToLongBits( val2 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp one float \%t" + $a.theInfo.theVar.varIndex +  ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.CONST_FLOAT ) )
         {
                    double val1 = $a.theInfo.theVar.fValue;
                    long ans1 = Double.doubleToLongBits( val1 );
                    double val2 = $b.theInfo.theVar.fValue;
                    long ans2 = Double.doubleToLongBits( val2 );
                    TextCode.add( "\t\%cond" + condCount + " = fcmp one float 0x" + Long.toHexString( ans1 ) + 
                                                ", 0x" + Long.toHexString( ans2 ) );
         }
         else if( ( $a.theInfo.theType == Type.CONST_FLOAT ) && ( $b.theInfo.theType == Type.FLOAT ) )
         {
            double val1 = $a.theInfo.theVar.fValue;
            long ans1 = Double.doubleToLongBits( val1 );
            TextCode.add( "\t\%cond" + condCount + " = fcmp one float 0x" + Long.toHexString( ans1 ) + 
                                                ", \%t" + $b.theInfo.theVar.varIndex );
         }
         // different data type
         else if( ( $a.theInfo.theType != $b.theInfo.theType )  &&  ( $a.theInfo.theType != Type.ERR ) && ( $b.theInfo.theType != Type.ERR ) )
         {
                    System.out.println( "Error: " + $a.start.getLine() + ": Type mismatch for the > operation in an expression." );
                    $a.theInfo.theType = Type.ERR;                                                          
                    System.exit(0);
         }
      }

      $ctrue = newLabel();
      $cfalse = newLabel();
   };

relationOP
	returns[RelationOP_type r_type]:
	GT {$r_type = RelationOP_type.GT;}
	| LT {$r_type = RelationOP_type.LT;}
	| GE {$r_type = RelationOP_type.GE;}
	| LE {$r_type = RelationOP_type.LE;}
	| EQ {$r_type = RelationOP_type.EQ;}
	| NE {$r_type = RelationOP_type.NE;};

arith_expression
	returns[Info theInfo]
	@init {$theInfo = new Info();}:
	a = multExpr { $theInfo=$a.theInfo; } (
		'+' b = multExpr {
                     // We need to do type checking first.
                     // ...
					  
                     // code generation.	
                     //  INT				   
                     if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     } 
                     else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = add nsw i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
	                  else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = add nsw i32 " + $theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // FLOAT
	                  else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT))
                     {
                        TextCode.add("\t\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     } 
                     else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fadd float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        TextCode.add("\t\%t" + varCount + " = fadd float 0x" + Long.toHexString(ans1) + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // different data type
                     else if(($a.theInfo.theType != $b.theInfo.theType)  &&  ($a.theInfo.theType != Type.ERR) && ($b.theInfo.theType != Type.ERR))
                     {
                        // System.out.println($a.theInfo.theType + " " +$b.theInfo.theType);
                        System.out.println("Error: " + $a.start.getLine() + ": Type mismatch for the + operation in an expression.");
                        $a.theInfo.theType = Type.ERR;
                        System.exit(0);
                     }
                    }
		| '-' c = multExpr {
	                  // We need to do type checking first.
                     // ...
					  
                     // code generation.	
                     //  INT				   
                     if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = sub i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     } 
                     else if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.CONST_INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = sub i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = sub i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
	                  else if(($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.CONST_INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = sub i32 " + $theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // FLOAT
	                  else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.FLOAT))
                     {
                        TextCode.add("\t\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     } 
                     else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fsub float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        TextCode.add("\t\%t" + varCount + " = fsub float 0x" + Long.toHexString(ans1) + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // different data type
                     else if(($a.theInfo.theType != $c.theInfo.theType)  &&  ($a.theInfo.theType != Type.ERR) && ($c.theInfo.theType != Type.ERR))
                     {
                        // System.out.println($a.theInfo.theType + " " +$b.theInfo.theType);
                        System.out.println("Error: " + $a.start.getLine() + ": Type mismatch for the + operation in an expression.");
                        $a.theInfo.theType = Type.ERR;
                        System.exit(0);
                     }
      }
	)*;

multExpr
	returns[Info theInfo]
	@init {$theInfo = new Info();}:
	a = signExpr { $theInfo=$a.theInfo; } (
		'*' b = signExpr {
                     // similar to arith_expression, but change add and fadd with mul and fmul
	                  // We need to do type checking first.
                     // ...
					  
                     // code generation.	
                     //  INT				   
                     if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     } 
                     else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = mul nsw i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
	                  else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = mul nsw i32 " + $theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // FLOAT
	                  else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT))
                     {
                        TextCode.add("\t\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     } 
                     else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fmul float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        TextCode.add("\t\%t" + varCount + " = fmul float 0x" + Long.toHexString(ans1) + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // different data type
                     else if(($a.theInfo.theType != $b.theInfo.theType)  &&  ($a.theInfo.theType != Type.ERR) && ($b.theInfo.theType != Type.ERR))
                     {
                        // System.out.println($a.theInfo.theType + " " +$b.theInfo.theType);
                        System.out.println("Error: " + $a.start.getLine() + ": Type mismatch for the + operation in an expression.");
                        $a.theInfo.theType = Type.ERR;
                        System.exit(0);
                     }
      }
		| '/' c = signExpr {
                     // similar to arith_expression, but change add and fadd with sdiv and fdiv
	                  // We need to do type checking first.
                     // ...
					  
                     // code generation.	
                     //  INT				   
                     if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     } 
                     else if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.CONST_INT)) 
                     {
                        TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
					         // Update arith_expression's theInfo.
					         $theInfo.theType = Type.INT;
					         $theInfo.theVar.varIndex = varCount;
					         varCount ++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = sdiv i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
	                  else if(($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.CONST_INT))
                     {
	                     TextCode.add("\t\%t" + varCount + " = sdiv i32 " + $theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
            
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.INT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // FLOAT
	                  else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.FLOAT))
                     {
                        TextCode.add("\t\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     } 
                     else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        double val2 = $b.theInfo.theVar.fValue;
                        long ans2 = Double.doubleToLongBits(val2);
                        TextCode.add("\t\%t" + varCount + " = fdiv float 0x" + Long.toHexString(ans1) + ", 0x" + Long.toHexString(ans2));
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.FLOAT))
                     {
                        double val1 = $a.theInfo.theVar.fValue;
                        long ans1 = Double.doubleToLongBits(val1);
                        TextCode.add("\t\%t" + varCount + " = fdiv float 0x" + Long.toHexString(ans1) + ", \%t" + $b.theInfo.theVar.varIndex);
                     
                        // Update arith_expression's theInfo.
                        $theInfo.theType = Type.FLOAT;
                        $theInfo.theVar.varIndex = varCount;
                        varCount++;
                     }
                     // different data type
                     else if(($a.theInfo.theType != $c.theInfo.theType)  &&  ($a.theInfo.theType != Type.ERR) && ($c.theInfo.theType != Type.ERR))
                     {
                        // System.out.println($a.theInfo.theType + " " +$b.theInfo.theType);
                        System.out.println("Error: " + $a.start.getLine() + ": Type mismatch for the + operation in an expression.");
                        $a.theInfo.theType = Type.ERR;
                        System.exit(0);
                     }
      }
	)*;

signExpr
	returns[Info theInfo]
	@init {$theInfo = new Info();}:
	a = primaryExpr { $theInfo=$a.theInfo; }
	| '-' b = primaryExpr {
      $theInfo = $b.theInfo;
      if($theInfo.theType == Type.INT || $theInfo.theType == Type.CONST_INT)
      {
         $theInfo.theVar.iValue *= -1;
         if(TRACEON) System.out.println("signExpr :" + $theInfo.theVar.iValue);
      }
      else if($theInfo.theType == Type.FLOAT || $theInfo.theType == Type.CONST_FLOAT)
      {
         $theInfo.theVar.fValue *= 1;
         if(TRACEON) System.out.println("signExpr :" + $theInfo.theVar.fValue);
      }
   };

primaryExpr
	returns[Info theInfo]
	@init {$theInfo = new Info();}:
	Integer_constant {
      $theInfo.theType = Type.CONST_INT;
		$theInfo.theVar.iValue = Integer.parseInt($Integer_constant.text);
   }
	| Floating_point_constant {
      $theInfo.theType = Type.CONST_FLOAT;
	   $theInfo.theVar.fValue = Float.parseFloat($Floating_point_constant.text);
   }
	| Identifier {
               // get type information from symtab.
               Type the_type = symtab.get($Identifier.text).theType;
				   $theInfo.theType = the_type;

               // get variable index from symtab.
               int vIndex = symtab.get($Identifier.text).theVar.varIndex;
				
               switch (the_type) {
               case INT: 
                  // get a new temporary variable and
						// load the variable into the temporary variable.
                         
						// Ex: \%tx = load i32, i32* \%ty.
						TextCode.add("\%t" + varCount + "=load i32, i32* \%t" + vIndex);
				         
						// Now, Identifier's value is at the temporary variable \%t[varCount].
						// Therefore, update it.
						$theInfo.theVar.varIndex = varCount;
						varCount ++;
                  break;
               case FLOAT:
	               // get a new temporary variable and
						// load the variable into the temporary variable.
                         
						// Ex: \%tx = load i32, i32* \%ty.
						TextCode.add("\%t" + varCount + "=load float, float* \%t" + vIndex);
				         
						// Now, Identifier's value is at the temporary variable \%t[varCount].
						// Therefore, update it.
						$theInfo.theVar.varIndex = varCount;
						varCount ++;
                  break;
               case CHAR:
	               // get a new temporary variable and
						// load the variable into the temporary variable.
                         
						// Ex: \%tx = load i32, i32* \%ty.
						TextCode.add("\%t" + varCount + "=load i8, i8* \%t" + vIndex);
				         
						// Now, Identifier's value is at the temporary variable \%t[varCount].
						// Therefore, update it.
						$theInfo.theVar.varIndex = varCount;
						varCount ++;
                  break;
			
                }
              }
	| '&' Identifier
	| '(' arith_expression ')' {$theInfo = $arith_expression.theInfo;};

/* description of the tokens */
FLOAT: 'float';
INT: 'int';
CHAR: 'char';

MAIN: 'main';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';

//  logic operator
GT: '>';
GE: '>=';
LT: '<';
LE: '<=';
EQ: '==';
NE: '!=';

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

STRING_LITERAL: '"' ( EscapeSequence | ~('\\' | '"'))* '"';

WS: ( ' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;};
COMMENT: '/*' .* '*/' {$channel=HIDDEN;};

fragment EscapeSequence:
	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
