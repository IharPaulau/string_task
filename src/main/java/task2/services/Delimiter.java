package task2.services;

public interface Delimiter {
    Component sentenceMatcher(Component allText);

    Component wordMatcher(Component sentence, String str);

    Component parser(Component sentence, String str, String regexp);

}
