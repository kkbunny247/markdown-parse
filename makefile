test: MarkdownParse.class MarkdownParseTest.class

MarkdownParse.class: MarkdownParse.java 
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
    javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParse.java MarkdownParseTest.java
	
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

