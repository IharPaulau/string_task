package task2;

import task2.models.Composite;
import task2.models.Word;
import task2.services.Delimiter;
import task2.services.impl.DelimiterImpl;
import task2.utils.FileReader;

public class App {
    private static final String REGEX_BY_SENTENCE = "([^.!?]+[.!?])";
    private static final String REGEX_BY_GIVEN_SYMBOL = "А[^А]+";
    private static final String REGEX_BY_GIVEN_WORD = "(^|(\\bЗдесь\\b))[а-яА-Я\\W\\V]+?((?=\\bЗдесь\\b)|\\Z)";
    private static final String REGEX_BY_ANY_SYMBOL = "[^(\\s)*(\\s)*]";
    private static final String REGEX_BY_ANY_WORD = "[^(\\s)]*(\\s)*";
    private static final String REGEX_BY_PARAGRAPH = "";
    private static String fileLocation = "d:/java study/123.txt";
    private static String charFormat = "Windows-1251";

    public App() {
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String text = fileReader.readFile(fileLocation, charFormat);
        Delimiter delimiter = new DelimiterImpl();
        Composite composite = new Composite();
        delimiter.matchFinder(composite, "[^(\\s)]*(\\s)*", text);
        composite.print();
    }
}
