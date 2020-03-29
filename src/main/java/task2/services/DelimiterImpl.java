package task2.services;


import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterImpl {
    private static final String REGEX_BY_WHITESPACE = "\\ |\\s";
    private static final String REGEX_BY_SENTENCE = "(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[\\s]*)+(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[.!?][\\s]*)";
    private static final String REGEX_BY_PUNCTUATION = "[,?!:;]|[.](?![а-яА-Яa-zA-Z])";
    private static final String REGEX_BY_ANY_WORD_WITH_PUNCTUATION = "(((([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+))|([а-яА-Яa-zA-Z0-9-,]+)))+[.?!:]*[\\s]*";
    private static final String REGEX_BY_ANY_WORD = "(((([а-яА-Яa-zA-Z0-9-]+(\\.[а-яА-Яa-zA-Z0-9-]+)+))|([а-яА-Яa-zA-Z0-9-]+)))";

    public Component sentenceMatcher(Component allText) {
        Matcher matcher = Pattern.compile(REGEX_BY_SENTENCE).matcher(((Composite) allText).getText());
        while (matcher.find()) {
            Component sentence = new Composite();
            wordMatcher(sentence, matcher.group());
            ((Composite) allText).add(sentence);
        }
        return allText;
    }

    public Component wordMatcher(Component sentence, String str) {
        Matcher matcher = Pattern.compile(REGEX_BY_ANY_WORD_WITH_PUNCTUATION).matcher(str);
        while (matcher.find()) {
            String temporarilyStr = matcher.group();
            Matcher matcher2 = Pattern.compile(REGEX_BY_PUNCTUATION).matcher(temporarilyStr);
            Matcher spaceMatcher = Pattern.compile(REGEX_BY_WHITESPACE).matcher(temporarilyStr);
            if (matcher2.find()) {
                parserWord(sentence, temporarilyStr);
                parserPunctuation(sentence, temporarilyStr);
                if (spaceMatcher.find()) parserSpace(sentence, temporarilyStr);
            } else if (spaceMatcher.find()) {
                parserWord(sentence, temporarilyStr);
                parserSpace(sentence, temporarilyStr);
            } else parserWord(sentence, temporarilyStr);
        }
        return sentence;
    }


    public Component parserWord(Component sentence, String str) {
        Matcher matcher = Pattern.compile(REGEX_BY_ANY_WORD).matcher(str);
        while (matcher.find()) {
            Component word = new Element(matcher.group());
            ((Composite) sentence).add(word);
        }
        return sentence;
    }

    public Component parserSpace(Component sentence, String str) {
        Matcher matcher = Pattern.compile(REGEX_BY_WHITESPACE).matcher(str);
        while (matcher.find()) {
            Component word = new Element(matcher.group());
            ((Composite) sentence).add(word);
        }
        return sentence;
    }

    public Component parserPunctuation(Component sentence, String str) {
        Matcher matcher = Pattern.compile(REGEX_BY_PUNCTUATION).matcher(str);
        while (matcher.find()) {
            Component word = new Element(matcher.group());
            ((Composite) sentence).add(word);
        }
        return sentence;
    }
}
