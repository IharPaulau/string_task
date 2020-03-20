package task2;

import task2.services.Delimiter;
import task2.services.impl.DelimiterImpl;
import task2.services.textreader.FileReader;

public class App {

    private static final String REGEX_BY_SENTENCE = "([^.!?]+[.!?])";
    private static final String REGEX_BY_SYMBOL = "А[^А]+";
    private static final String REGEX_BY_WORD = "(^|(\\bЗдесь\\b))[а-яА-Я\\W\\V]+?((?=\\bЗдесь\\b)|\\Z)";
    private static final String REGEX_BY_PARAGRAPH = "";
    private static String fileLocation = "d:/java study/123.txt";
    private static String charFormat = "Windows-1251";

    public static void main(String[] args) {

        FileReader fileReader = new FileReader(); // read text from file
        String text = fileReader.readFile(fileLocation, charFormat);

        Delimiter delimiter = new DelimiterImpl();
        delimiter.matchFinder(REGEX_BY_SENTENCE, text);  // the text is divided into sentences
        delimiter.matchFinder(REGEX_BY_SYMBOL, text);
        delimiter.matchFinder(REGEX_BY_WORD, text);
    }
}
