package task2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String text = "AasdasdasdasdBasA \n adsasdasdCasdasdasda";
        String rex = "^.+?$";

        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            System.out.println((matcher.group()));
        }
    }
}
