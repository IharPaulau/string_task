package task2.utils;

import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.models.TextComponent;
import task2.services.Delimiter;
import task2.services.impl.DelimiterImpl;

import java.util.List;

import static org.junit.Assert.*;

public class WordDeleterTest {
    private TextComponent test_allText;
    private Delimiter test_delimiter;
    private WordDeleter wordDeleter;

    @Before
    public void init() {
        test_allText = new CompositeTextElements("первое предложение. " +
                "второе предложение.");
        test_delimiter = new DelimiterImpl();
        wordDeleter = new WordDeleter();
    }

    @Test
    public void shouldBeHaveNoAnyWordStartingWithConsonantAndElevenLettersLong_afterRemovingSuchWords() {
        wordDeleter.deleter(test_delimiter.sentenceMatcher(test_allText));
        String stringAfterProcessing = "";
        for (int i = 0; i < ((CompositeTextElements) test_allText).getSingleLevelComponent().size(); i++) {
            TextComponent sentence = ((CompositeTextElements) test_allText).getSingleLevelComponent().get(i);
            List<TextComponent> s = ((CompositeTextElements) sentence).getSingleLevelComponent();
            for (int j = 0; j < s.size(); j++) {
                stringAfterProcessing += ((MinTextElement) s.get(j)).getTextElement();
            }
        }
        assertTrue(stringAfterProcessing.equals("первое . второе ."));
    }
}