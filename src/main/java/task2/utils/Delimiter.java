package task2.utils;


import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String REGEX_BY_SENTENCE = "([^.?!]|^[^!.?])+([!.?]|$)";
    private static final String REGEX_BY_GIVEN_SYMBOL = "А[^А]+";
    private static final String REGEX_BY_GIVEN_WORD = "(^|(\\bЗдесь\\b))[а-яА-Я\\W\\V]+?((?=\\bЗдесь\\b)|\\Z)";
    private static final String REGEX_BY_ANY_SYMBOL = "[^(\\s)*(\\s)*]";
    private static final String REGEX_BY_ANY_WORD_WITH_PUNCTUATION = "[^(\\s)]*(\\s)*";
    private static final String REGEX_BY_ANY_WORD = "([^\\s\\.\\,\\!\\?]+)";
    private static final String REGEX_BY_PUNCTUATION = "[,.?!:;]";
    private static final String REGEX_BY_WHITESPACE = "\\ |\\n";


    public Component sentenceMatcher(Component allText) {
        Matcher matcher = Pattern.compile(REGEX_BY_SENTENCE).matcher(((Composite)allText).getText());

        while (matcher.find()) {
            Component sentence = new Composite();
            wordMatcher(sentence, matcher.group());
            ((Composite)allText).add(sentence);
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
                parseWord(temporarilyStr, sentence);
                parsePunctuaction(temporarilyStr,sentence);
                if (spaceMatcher.find()) parseWhiteSpace(temporarilyStr,sentence);

            } else if (spaceMatcher.find()) {
                parseWord(temporarilyStr,sentence);
                parseWhiteSpace(temporarilyStr, sentence);
            } else parseWord(temporarilyStr, sentence);
        }
        return sentence;
    }

    public Component parseWord(String s, Component sentence) {
        Matcher matcher = Pattern.compile(REGEX_BY_ANY_WORD).matcher(s);
        if (matcher.find()) {
            Component word = new Element(matcher.group());
            ((Composite)sentence).add(word);
        }
        return sentence;
    }
    public Component parsePunctuaction(String s, Component sentence) {
        Matcher matcher = Pattern.compile(REGEX_BY_PUNCTUATION).matcher(s);
        if (matcher.find()) {
            Component punctuation = new Element(matcher.group());
            ((Composite)sentence).add(punctuation);
        }
        return sentence;
    }

    private Component parseWhiteSpace(String s, Component sentence) {
        Matcher matcher = Pattern.compile(REGEX_BY_WHITESPACE).matcher(s);
        if (matcher.find()) {
            Component space = new Element(matcher.group());
            ((Composite)sentence).add(space);
        }
        return sentence;
    }
}