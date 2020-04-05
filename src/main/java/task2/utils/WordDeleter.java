package task2.utils;

import org.apache.log4j.Logger;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.models.TextComponent;

import java.util.List;
import java.util.regex.Pattern;


public class WordDeleter {
    private static final Logger LOGGER = Logger.getLogger(WordDeleter.class);
    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{10}";

    public TextComponent deleter(TextComponent allText) {
        for (int i = 0; i < ((CompositeTextElements)allText).getSingleLevelComponent().size(); i++) {
            TextComponent sentence = ((CompositeTextElements)allText).getSingleLevelComponent().get(i);
            List<TextComponent> elements = ((CompositeTextElements) sentence).getSingleLevelComponent();
            for (int indexElement = 0; indexElement < elements.size(); indexElement++) {
                if (Pattern.matches(ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT, ((MinTextElement) elements.get(indexElement)).getTextElement())) {
                    elements.remove(indexElement);
                }
            }
        }
        LOGGER.info("all words in parsed text starting with a consonant and eleven letters long was deleted");
        return allText;
    }
}