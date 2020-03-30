package task2.utils;

import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;
import java.util.List;
import java.util.regex.Pattern;


public class WordDeleter {
    private static final String ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY\\s][a-zA-Zа-яА-Я]{10}";

    public Component deleter(Component allText) {
        for (int i = 0; i < ((Composite)allText).getComponentList().size(); i++) {
            Component sentence = ((Composite)allText).getComponentList().get(i);
            List<Component> s = ((Composite) sentence).getComponentList();
            for (int j = 0; j < s.size(); j++) {
                if (Pattern.matches(ANY_ELEVEN_LETTER_WORD_STARTING_WITH_CONSONANT, ((Element) s.get(j)).getStr())) {
                    s.remove(j);
                }
            }
        }
        return allText;
    }
}