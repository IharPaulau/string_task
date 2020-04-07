package task2.services.impl;


import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;
import task2.services.Parser;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserImplTest {
    private TextComponent test_allText;
    private Parser test_parser;
    private String test_text = "первое предложение.\n" +
            "второе предложение длинное очень очень очень\n" +
            "очень очень и разделено на две строки.\n" +
            "третье содержит english words.\n" +
            "четвертое содержит ссылку www.leningrad.ru.\n" +
            "пятоеВодноСлово.";

    @Before
    public void init() {
        test_allText = new CompositeTextFragments();
        test_parser = new ParserImpl();
    }

    @Test
    public void shouldBeExpectedNumberOfSentence_whenTextParsedIntoSentence() {
        test_parser.sentenceMatcher(test_allText, test_text);
        assertTrue(((CompositeTextFragments) test_allText).getOneLevelFragments().size() == 5);
    }

    @Test
    public void shouldBeHaveExpectedFirstSentenceAndSentenceWithURL_whenTextParsedIntoSentence() {
        test_parser.sentenceMatcher(test_allText, test_text);
        assertEquals("первое предложение.\n",
                combineElementsInSentence(((CompositeTextFragments) test_allText).getOneLevelFragments().get(0)));
        assertEquals("четвертое содержит ссылку www.leningrad.ru.\n",
                combineElementsInSentence(((CompositeTextFragments) test_allText).getOneLevelFragments().get(3)));
    }

    private String combineElementsInSentence(TextComponent componentOfText) {
        StringBuilder stringBuilder = new StringBuilder();
        List<TextComponent> elements = ((CompositeTextFragments) componentOfText).getOneLevelFragments();
        for (int i = 0; i < elements.size(); i++) {
            stringBuilder.append(((MinTextFragment) elements.get(i)).getTextElement());
        }
        return stringBuilder.toString();
    }


}