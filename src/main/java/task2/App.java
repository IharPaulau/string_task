package task2;


import task2.models.Composite;
import task2.services.Component;
import task2.utils.Delimiter;
import task2.utils.FileReader;

public class App {

    private static String fileLocation = "d:/java study/123.txt";
    private static String fileLocation2 = "text.txt";
    private static String charFormat = "UTF-8";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Component allText = new Composite(fileReader.readFile(fileLocation2, charFormat));
        Delimiter delimiter = new Delimiter();
        delimiter.sentenceMatcher(allText);

        allText.print();

//        FileWriter f = new FileWriter();
//        f.write(allText.wtite());

//        WordDeleter wordDeleter = new WordDeleter();
//        wordDeleter.deleter(allText);
    }
}
