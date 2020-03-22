package task2.services.impl;

import task2.models.Composite;
import task2.models.Word;
import task2.services.Component;
import task2.services.Delimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterImpl implements Delimiter {
    public DelimiterImpl() {
    }

    public Component matchFinder(Composite composite, String regex, String inputText) {
        Matcher matcher = Pattern.compile(regex).matcher(inputText);

        while(matcher.find()) {
            String outputText = matcher.group();
            composite.getComponentList().add(new Word(outputText));
        }

        return null;
    }
}
