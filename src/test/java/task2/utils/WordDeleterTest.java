package task2.utils;

import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;
import task2.services.Parser;
import task2.services.impl.ParserImpl;

import java.util.List;

import static org.junit.Assert.*;

public class WordDeleterTest {
    private TextComponent test_allText;
    private Parser test_parser;
    private WordDeleter wordDeleter;
    private String test_text = "первое предложение. " +
            "второе предложение.";
    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{10}";

    @Before
    public void init() {
        test_allText = new CompositeTextFragments();
        test_parser = new ParserImpl();
        wordDeleter = new WordDeleter();
    }

    @Test
    public void shouldBeHaveNoAnyWordStartingWithConsonantAndElevenLettersLong_afterRemovingSuchWords() {
        wordDeleter.deleter(test_parser.sentenceMatcher(test_allText, test_text), ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT);
        String stringAfterProcessing = "";
        for (int i = 0; i < ((CompositeTextFragments) test_allText).getOneLevelFragments().size(); i++) {
            TextComponent sentence = ((CompositeTextFragments) test_allText).getOneLevelFragments().get(i);
            List<TextComponent> elements = ((CompositeTextFragments) sentence).getOneLevelFragments();
            for (int j = 0; j < elements.size(); j++) {
                stringAfterProcessing += ((MinTextFragment) elements.get(j)).getTextElement();
            }
        }
        assertTrue(stringAfterProcessing.equals("первое . второе ."));
    }
}