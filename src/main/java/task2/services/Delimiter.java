package task2.services;

import task2.models.TextComponent;

public interface Delimiter {
    TextComponent sentenceMatcher(TextComponent allText);

    TextComponent wordMatcher(TextComponent sentence, String str);

    TextComponent parser(TextComponent sentence, String str, String regexp);
}
