package task2.services.impl;


import org.apache.log4j.Logger;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;
import task2.services.Parser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserImpl implements Parser {
    private static final Logger LOGGER = Logger.getLogger(ParserImpl.class);
    private static final String REGEX_BY_WHITESPACE = "\\ |\\s";
    private static final String REGEX_BY_SENTENCE = "(([а-яА-Яa-zA-Z0-9-,\"]+(\\.[а-яА-Яa-zA-Z0-9-,\"]+)+)|([а-яА-Яa-zA-Z0-9-,\"]+)[\\s]*)+(([а-яА-Яa-zA-Z0-9-,\"]+(\\.[а-яА-Яa-zA-Z0-9-,\"]+)+)|([а-яА-Яa-zA-Z0-9-,\"]+)[.!?][\\s]*)";
    private static final String REGEX_BY_PUNCTUATION = "[,?!:;]|[.](?![а-яА-Яa-zA-Z])";
    private static final String REGEX_BY_ANY_WORD_WITH_PUNCTUATION = "(((([а-яА-Яa-zA-Z0-9-,\"]+(\\.[а-яА-Яa-zA-Z0-9-,\"]+)+))|([а-яА-Яa-zA-Z0-9-,\"]+)))+[.?!:]*[\\s]*";
    private static final String REGEX_BY_ANY_WORD = "(((([а-яА-Яa-zA-Z0-9-\"]+(\\.[а-яА-Яa-zA-Z0-9-\"]+)+))|([а-яА-Яa-zA-Z0-9-\"]+)))";
    private static int sentenceCounter = 0;

    @Override
    public TextComponent sentenceMatcher(TextComponent allText, String text) {
        Matcher matcher = Pattern.compile(REGEX_BY_SENTENCE).matcher(text);
        while (matcher.find()) {
            TextComponent sentence = new CompositeTextFragments();
            wordMatcher(sentence, matcher.group());
            ((CompositeTextFragments) allText).add(sentence);

        }
        LOGGER.info(String.format("the text was parsed into" + "'%d'" + "sentences",
                ((CompositeTextFragments) allText).getOneLevelFragments().size()));
        return allText;
    }

    @Override
    public TextComponent wordMatcher(TextComponent sentence, String str) {
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
        LOGGER.info(String.format("'%d' sentence was parsed into" + "'%d'" + "elements", sentenceCounter+=1,
                ((CompositeTextFragments) sentence).getOneLevelFragments().size()));

        return sentence;
    }

    @Override
    public TextComponent parser(TextComponent sentence, String str, String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        while (matcher.find()) {
            TextComponent word = new MinTextFragment(matcher.group());
            ((CompositeTextFragments) sentence).add(word);
        }
        return sentence;
    }
}
