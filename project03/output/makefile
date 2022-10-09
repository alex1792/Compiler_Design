all:
	java -cp antlr-3.5.2-complete-no-st3.jar org.antlr.Tool myInterp.g
	javac -cp antlr-3.5.2-complete-no-st3.jar:. *.java

clean:
	rm myInterp.tokens 
	rm myInterpLexer.java
	rm myInterpParser.java
	rm *.class

test1:
	java -cp antlr-3.5.2-complete-no-st3.jar:. myInterp_test test.c 

test2:
	java -cp antlr-3.5.2-complete-no-st3.jar:. myInterp_test test2.c 

test3:
	java -cp antlr-3.5.2-complete-no-st3.jar:. myInterp_test test3.c