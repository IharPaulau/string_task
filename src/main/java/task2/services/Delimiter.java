package task2.services;

public interface Delimiter {
    ComponentOfText sentenceMatcher(ComponentOfText allText);

    ComponentOfText wordMatcher(ComponentOfText sentence, String str);

    ComponentOfText parser(ComponentOfText sentence, String str, String regexp);
}
