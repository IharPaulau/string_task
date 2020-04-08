package task2;

import task2.models.CompositeTextFragments;
import task2.models.TextComponent;
import task2.services.Parser;
import task2.services.WordDeleter;
import task2.services.impl.ParserImpl;
import task2.utils.FileReader;
import task2.utils.FileWriter;
import task2.services.impl.DeleterConsonantWords;

public class App {
    private static String fileLocation = "text.txt";
    private static String charFormat = "UTF-8";
    private static String text = FileReader.readFile(fileLocation, charFormat);
    private static TextComponent highLevelTextFragments = new CompositeTextFragments();
    private static Parser parser = new ParserImpl();
    private static WordDeleter wordDeleter = new DeleterConsonantWords();
    private static int wordLengthToDelete = 11;

    public static void main(String[] args) {
        parser.sentenceMatcher(highLevelTextFragments, text);
//        allText.print(); // reassembled text elements again in console
        wordDeleter.deleter(highLevelTextFragments, wordLengthToDelete); // delete a word starting with a consonant and eleven letters long
        FileWriter.write(highLevelTextFragments); // write to text file after processing
//        allText.print(); // reassembled text elements again in console
    }
}
