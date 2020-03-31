package task2;

import task2.models.CompositeTextElements;
import task2.services.ComponentOfText;
import task2.services.Delimiter;
import task2.services.impl.DelimiterImpl;
import task2.utils.FileReader;
import task2.utils.FileWriter;
import task2.utils.WordDeleter;

public class App {
    private static String fileLocation = "text.txt";
    private static String charFormat = "UTF-8";
    private static FileReader fileReader = new FileReader();
    private static ComponentOfText allText = new CompositeTextElements(fileReader.readFile(fileLocation, charFormat));
    private static Delimiter delimiter = new DelimiterImpl();
    private static WordDeleter wordDeleter = new WordDeleter();
    private static FileWriter fileWriter = new FileWriter();

    public static void main(String[] args) {
        delimiter.sentenceMatcher(allText);
//        allText.print(); // reassembled text elements again
        wordDeleter.deleter(allText); // delete a word starting with a consonant and eleven letters long
        fileWriter.write(allText); // write to text file after processing
//                allText.print(); // reassembled text elements again
    }
}
