all: myCompiler_test myCompiler.java

myCompiler.java: myCompiler.g
	java -cp ./antlr-3.5.2-complete-no-st3.jar org.antlr.Tool myCompiler.g

myCompiler_test: myCompiler_test.java myCompiler.java
	javac -cp ./antlr-3.5.2-complete-no-st3.jar *.java

test1:
	java -cp ./antlr-3.5.2-complete-no-st3.jar: myCompiler_test test1.c > 1.ll
	lli 1.ll

test2:
	java -cp ./antlr-3.5.2-complete-no-st3.jar: myCompiler_test test2.c > 2.ll
	lli 2.ll

test3:
	java -cp ./antlr-3.5.2-complete-no-st3.jar: myCompiler_test test3.c > 3.ll
	lli 3.ll

clean:
	rm -rf *.class myCompilerLexer.java myCompilerParser.java myCompiler.tokens *.ll