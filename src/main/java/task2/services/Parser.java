package task2.services;

import task2.models.TextComponent;

public interface Parser {
    TextComponent sentenceMatcher(TextComponent allText, String text);

    TextComponent wordMatcher(TextComponent sentence, String str);

    TextComponent parser(TextComponent sentence, String str, String regexp);
}
