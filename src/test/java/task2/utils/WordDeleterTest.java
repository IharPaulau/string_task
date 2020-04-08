package task2.utils;

import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;
import task2.services.Parser;
import task2.services.impl.ParserImpl;
import task2.services.impl.DeleterConsonantWords;
import java.util.List;
import static org.junit.Assert.*;

public class WordDeleterTest {
    private TextComponent test_highLevelTextFragments;
    private Parser test_parser;
    private DeleterConsonantWords wordDeleter;
    private String test_text = "первое предложение. второе предложение.";

    @Before
    public void init() {
        test_highLevelTextFragments = new CompositeTextFragments();
        test_parser = new ParserImpl();
        wordDeleter = new DeleterConsonantWords();
    }

    @Test
    public void shouldBeHaveNoAnyWordStartingWithConsonantAndElevenLettersLong_afterRemovingSuchWords() {
        wordDeleter.deleter(test_parser.sentenceMatcher(test_highLevelTextFragments, test_text), 11);
        textPicker();

        assertEquals("первое . второе .", textPicker().toString());
    }

    @Test
    public void shouldBeHaveNoAnyWordStartingWithConsonantAndSixLettersLong_afterRemovingSuchWords() {
        wordDeleter.deleter(test_parser.sentenceMatcher(test_highLevelTextFragments, test_text), 6);
        textPicker();

        assertEquals(" предложение.  предложение.", textPicker().toString());
    }

    private StringBuilder textPicker(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ((CompositeTextFragments) test_highLevelTextFragments).getOneLevelFragments().size(); i++) {
            TextComponent sentence = ((CompositeTextFragments) test_highLevelTextFragments).getOneLevelFragments().get(i);
            List<TextComponent> elements = ((CompositeTextFragments) sentence).getOneLevelFragments();
            for (TextComponent element : elements) {
                stringBuilder.append(((MinTextFragment) element).getTextElement());
            }
        }
        return stringBuilder;
    }
}