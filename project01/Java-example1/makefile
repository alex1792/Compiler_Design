all:
	java -jar antlr-3.5.2-complete-no-st3.jar mylexer.g
	javac -cp antlr-3.5.2-complete-no-st3.jar:. *.java

clean:
	rm mylexer.tokens
	rm mylexer.java
	rm *.class
	rm *.out

do1:
	java -cp antlr-3.5.2-complete-no-st3.jar:. testLexer sample.c > 1.out

do2:
	java -cp ../../antlr-3.5.2-complete-no-st3.jar:. testLexer sample2.c > 2.out

do3:
	java -cp ../../antlr-3.5.2-complete-no-st3.jar:. testLexer sample3.c > 3.out
