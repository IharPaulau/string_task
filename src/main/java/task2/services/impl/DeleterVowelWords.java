package task2.services.impl;

import org.apache.log4j.Logger;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;
import task2.services.WordDeleter;

import java.util.List;
import java.util.regex.Pattern;


public class DeleterVowelWords implements WordDeleter {
    private static final Logger LOGGER = Logger.getLogger(DeleterVowelWords.class);
    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{%d}";

    public TextComponent deleter(TextComponent allText, int length) {
        if(length <= 0){
            LOGGER.info("wrong length value - the word length for deletion cannot be less than or equal to zero");
            return allText;
        }
        String regex = String.format(ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT, length-1);
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