import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void getLinks2() throws IOException {
        Path fileName = Path.of("test2-file.md");
	    String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of("link.com"));
    } 

    @Test
    public void getLinks3() throws IOException {
        Path fileName = Path.of("test3-file.md");
	    String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of());
    } 

    // @Test
    // public void getLinks4() throws IOException {
    //     Path fileName = Path.of("test4-file.md");
	//     String contents = Files.readString(fileName);

    //     assertEquals(MarkdownParse.getLinks(contents), List.of());
    // } 
}

// JUNIT copypaste

// javac -cp ".;C:\JUNIT\junit-4.13.2.jar;C:\JUNIT\hamcrest-core-1.3.jar" ___________.java

// java -cp ".;C:\JUNIT\junit-4.13.2.jar;C:\JUNIT\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ______________