package task2.services.impl;


import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.models.TextComponent;
import task2.services.Delimiter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelimiterImplTest {
    private TextComponent test_allText;
    private Delimiter test_delimiter;

    @Before
    public void init() {
        test_allText = new CompositeTextElements("первое предложение.\n" +
                "второе предложение длинное очень очень очень\n" +
                "очень очень и разделено на две строки.\n" +
                "третье содержит english words.\n" +
                "четвертое содержит ссылку www.leningrad.ru.\n" +
                "пятоеВодноСлово.");
        test_delimiter = new DelimiterImpl();

    }

    @Test
    public void shouldBeExpectedNumberOfSentence_whenTextParsedIntoSentence() {
        test_delimiter.sentenceMatcher(test_allText);
        assertTrue(((CompositeTextElements) test_allText).getSingleLevelComponent().size() == 5);
    }

    @Test
    public void shouldBeHaveExpectedFirstSentenceAndSentenceWithURL_whenTextParsedIntoSentence() {
        test_delimiter.sentenceMatcher(test_allText);
        assertEquals("первое предложение.\n",
                combineElementsInSentence(((CompositeTextElements) test_allText).getSingleLevelComponent().get(0)));
        assertEquals("четвертое содержит ссылку www.leningrad.ru.\n",
                combineElementsInSentence(((CompositeTextElements) test_allText).getSingleLevelComponent().get(3)));
    }

    public String combineElementsInSentence(TextComponent componentOfText) {
        StringBuilder stringBuilder = new StringBuilder();
        List<TextComponent> elements = ((CompositeTextElements) componentOfText).getSingleLevelComponent();
        for (int i = 0; i < elements.size(); i++) {
            stringBuilder.append(((MinTextElement) elements.get(i)).getTextElement());
        }
        return stringBuilder.toString();
    }


}