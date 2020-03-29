package task2;


import task2.models.Composite;
import task2.services.Component;
import task2.services.DelimiterImpl;
import task2.utils.FileReader;

public class App {
    private static String fileLocation = "text.txt";
    private static String charFormat = "UTF-8";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Component allText = new Composite(fileReader.readFile(fileLocation, charFormat));
        DelimiterImpl delimiter = new DelimiterImpl();
        delimiter.sentenceMatcher(allText);
        allText.print();

    }
}
