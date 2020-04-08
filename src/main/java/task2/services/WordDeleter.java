package task2.services;

import task2.models.TextComponent;

public interface WordDeleter {
    TextComponent deleter(TextComponent allText, int length);
}
