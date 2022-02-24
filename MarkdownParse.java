// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            
            System.out.println(currentIndex);

            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            int lastCloseBracket = markdown.lastIndexOf("]", openParen);
            int lastOpenBracket = markdown.lastIndexOf("]", lastCloseBracket);
            String link = markdown.substring(openParen + 1, closeParen);

            if (lastCloseBracket < lastOpenBracket) {
                return toReturn;
            }

            if (nextOpenBracket == -1 || lastCloseBracket == -1
                    || closeParen == -1 || openParen == -1) {
                return toReturn;
            }

            if (link.contains(" ")) {
                if (markdown.charAt(openParen + 1) != ' ' || 
                    markdown.charAt(closeParen - 1) != ' ') {
                    return toReturn;
                }
                else {
                    String[] split = link.split(" ");

                    if (markdown.charAt(openParen + 1) == ' ' && markdown.charAt(closeParen - 1) == ' ') {
                        link = split[split.length - 1];
                    }
                    if (markdown.charAt(openParen + 1) == ' ') {
                        link = split[split.length - 1];
                    }
                    else if (markdown.charAt(closeParen - 1) == ' ') {
                        link = split[0];
                    }
                }
            }

            if ( (lastCloseBracket == openParen - 1) && (nextOpenBracket == 0 
            || markdown.charAt(nextOpenBracket - 1) != '!')) {
                if (markdown.lastIndexOf("`", lastCloseBracket) != -1) {
                    if (nextOpenBracket == 0 || markdown.charAt(nextOpenBracket - 1) != '`') {
                        toReturn.add(link);
                    }
                }
                else {
                    toReturn.add(link);
                }
            }

            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}