package task2.services.impl;


import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;
import task2.services.Delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterImpl implements Delimiter {
    private static final String REGEX_BY_WHITESPACE = "\\ |\\s";
    private static final String REGEX_BY_SENTENCE = "(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[\\s]*)+(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[.!?][\\s]*)";
    private static final String REGEX_BY_PUNCTUATION = "[,?!:;]|[.](?![а-яА-Яa-zA-Z])";
    private static final String REGEX_BY_ANY_WORD_WITH_PUNCTUATION = "(((([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+))|([а-яА-Яa-zA-Z0-9-,]+)))+[.?!:]*[\\s]*";
    private static final String REGEX_BY_ANY_WORD = "(((([а-яА-Яa-zA-Z0-9-]+(\\.[а-яА-Яa-zA-Z0-9-]+)+))|([а-яА-Яa-zA-Z0-9-]+)))";

    @Override
    public Component sentenceMatcher(Component allText) {
        Matcher matcher = Pattern.compile(REGEX_BY_SENTENCE).matcher(((Composite) allText).getText());
        while (matcher.find()) {
            Component sentence = new Composite();
            wordMatcher(sentence, matcher.group());
            ((Composite) allText).add(sentence);
        }
        return allText;
    }
    @Override
    public Component wordMatcher(Component sentence, String str) {
        Matcher matcher = Pattern.compile(REGEX_BY_ANY_WORD_WITH_PUNCTUATION).matcher(str);
        while (matcher.find()) {
            String temporarilyStr = matcher.group();
            Matcher matcher2 = Pattern.compile(REGEX_BY_PUNCTUATION).matcher(temporarilyStr);
            Matcher spaceMatcher = Pattern.compile(REGEX_BY_WHITESPACE).matcher(temporarilyStr);
            if (matcher2.find()) {
                parser(sentence, temporarilyStr, REGEX_BY_ANY_WORD);
                parser(sentence, temporarilyStr, REGEX_BY_PUNCTUATION);
                if (spaceMatcher.find()) parser(sentence, temporarilyStr, REGEX_BY_WHITESPACE);
            } else if (spaceMatcher.find()) {
                parser(sentence, temporarilyStr, REGEX_BY_ANY_WORD);
                parser(sentence, temporarilyStr, REGEX_BY_WHITESPACE);
            } else parser(sentence, temporarilyStr, REGEX_BY_ANY_WORD);
        }
        return sentence;
    }

    @Override
    public Component parser(Component sentence, String str, String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        while (matcher.find()) {
            Component word = new Element(matcher.group());
            ((Composite) sentence).add(word);
        }
        return sentence;
    }
}
