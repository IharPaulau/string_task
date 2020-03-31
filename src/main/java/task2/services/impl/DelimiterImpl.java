package task2.services.impl;


import org.apache.log4j.Logger;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.services.ComponentOfText;
import task2.services.Delimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterImpl implements Delimiter {
    private static final Logger LOGGER = Logger.getLogger(DelimiterImpl.class);
    private static final String REGEX_BY_WHITESPACE = "\\ |\\s";
    private static final String REGEX_BY_SENTENCE = "(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[\\s]*)+(([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+)|([а-яА-Яa-zA-Z0-9-,]+)[.!?][\\s]*)";
    private static final String REGEX_BY_PUNCTUATION = "[,?!:;]|[.](?![а-яА-Яa-zA-Z])";
    private static final String REGEX_BY_ANY_WORD_WITH_PUNCTUATION = "(((([а-яА-Яa-zA-Z0-9-,]+(\\.[а-яА-Яa-zA-Z0-9-,]+)+))|([а-яА-Яa-zA-Z0-9-,]+)))+[.?!:]*[\\s]*";
    private static final String REGEX_BY_ANY_WORD = "(((([а-яА-Яa-zA-Z0-9-]+(\\.[а-яА-Яa-zA-Z0-9-]+)+))|([а-яА-Яa-zA-Z0-9-]+)))";
    private static int sentenceCounter = 0;

    @Override
    public ComponentOfText sentenceMatcher(ComponentOfText allText) {
        Matcher matcher = Pattern.compile(REGEX_BY_SENTENCE).matcher(((CompositeTextElements) allText).getText());
        while (matcher.find()) {
            ComponentOfText sentence = new CompositeTextElements();
            wordMatcher(sentence, matcher.group());
            ((CompositeTextElements) allText).add(sentence);

        }
        LOGGER.info(String.format("the text was parsed into" + "'%d'" + "sentences",
                ((CompositeTextElements) allText).getSingleLevelComponent().size()));
        return allText;
    }

    @Override
    public ComponentOfText wordMatcher(ComponentOfText sentence, String str) {
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
                ((CompositeTextElements) sentence).getSingleLevelComponent().size()));

        return sentence;
    }

    @Override
    public ComponentOfText parser(ComponentOfText sentence, String str, String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        while (matcher.find()) {
            ComponentOfText word = new MinTextElement(matcher.group());
            ((CompositeTextElements) sentence).add(word);
        }
        return sentence;
    }
}
