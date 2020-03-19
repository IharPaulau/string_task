package task2;

public class App {

    private static String regexByPoint = "([^.!?]+[.!?])";
    private static String regexBySymbol = "А[^А]+";
    private static String regexByWord = "(^|(\\bЗдесь\\b))[а-яА-Я\\W\\V]+?((?=\\bЗдесь\\b)|\\Z)";

    public static void main(String[] args) {

        FileReader fileReader = new FileReader(); // read text from file
        String text = fileReader.readFile();

        Delimiter delimiterByPoint = new Delimiter();
        delimiterByPoint.matchFinder(regexByPoint, text);  // the text is divided into sentences
        delimiterByPoint.matchFinder(regexBySymbol, text);
        delimiterByPoint.matchFinder(regexByWord, text);


    }
}
