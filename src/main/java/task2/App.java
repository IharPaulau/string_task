package task2;

import task2.models.CompositeTextFragments;
import task2.models.TextComponent;
import task2.services.Parser;
import task2.services.impl.ParserImpl;
import task2.utils.FileReader;
import task2.utils.FileWriter;
import task2.utils.WordDeleter;

public class App {
    private static String fileLocation = "text.txt";
    private static String charFormat = "UTF-8";
    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{10}";
    private static FileReader fileReader = new FileReader();
    private static String text = fileReader.readFile(fileLocation, charFormat);
    private static TextComponent allText = new CompositeTextFragments();
    private static Parser parser = new ParserImpl();
    private static WordDeleter wordDeleter = new WordDeleter();
    private static FileWriter fileWriter = new FileWriter();

    public static void main(String[] args) {
        parser.sentenceMatcher(allText, text);
//        allText.print(); // reassembled text elements again in console
        wordDeleter.deleter(allText, ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT); // delete a word starting with a consonant and eleven letters long
        fileWriter.write(allText); // write to text file after processing
//        allText.print(); // reassembled text elements again in console
    }
}
