package task2;

import org.apache.commons.io.FileUtils;
import task2.models.Composite;
import task2.services.Component;
import task2.services.Delimiter;
import task2.services.impl.DelimiterImpl;
import task2.utils.FileReader;
import task2.utils.FileWriter;
import task2.utils.WordDeleter;

public class App {
    private static String fileLocation = "text.txt";
    private static String charFormat = "UTF-8";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Component allText = new Composite(fileReader.readFile(fileLocation, charFormat));
        Delimiter delimiter = new DelimiterImpl();
        delimiter.sentenceMatcher(allText);
        allText.print(); // reassembled text elements
        WordDeleter wordDeleter = new WordDeleter();
        wordDeleter.deleter(allText); // deleting word - "предложение"
        allText.print(); // reassembled text elements again
        FileWriter fileWriter = new FileWriter();
        fileWriter.write(allText);
    }
}
