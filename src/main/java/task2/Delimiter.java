package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    List<String> list;

    List<String> matchFinder(String regexByPoint, String text) {
        list = new ArrayList<>();
        Matcher matcher = Pattern.compile(regexByPoint).matcher(text);
        while (matcher.find()) {

            list.add(matcher.group());

        }
        System.out.println(list.size());
        System.out.println();
        System.out.println(list);
        return list;
    }
}
