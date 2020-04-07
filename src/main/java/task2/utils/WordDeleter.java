package task2.utils;

import org.apache.log4j.Logger;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;

import java.util.List;
import java.util.regex.Pattern;


public class WordDeleter {
    private static final Logger LOGGER = Logger.getLogger(WordDeleter.class);
//    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{10}";

    public TextComponent deleter(TextComponent allText, String regex) {
        for (int i = 0; i < ((CompositeTextFragments)allText).getOneLevelFragments().size(); i++) {
            TextComponent sentence = ((CompositeTextFragments)allText).getOneLevelFragments().get(i);
            List<TextComponent> elements = ((CompositeTextFragments) sentence).getOneLevelFragments();
            for (int indexElement = 0; indexElement < elements.size(); indexElement++) {
                if (Pattern.matches(regex, ((MinTextFragment) elements.get(indexElement)).getTextElement())) {
                    elements.remove(indexElement);
                }
            }
        }
        LOGGER.info("all words in parsed text starting with a consonant and eleven letters long was deleted");
        return allText;
    }
}