package task2.models;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextElements implements TextComponent {
    private String text;
    private List<TextComponent> singleLevelComponent = new ArrayList();

    public CompositeTextElements() {
    }

    public CompositeTextElements(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public List<TextComponent> getSingleLevelComponent() {
        return singleLevelComponent;
    }

    public void add(TextComponent componentOfText) {
        singleLevelComponent.add(componentOfText);
    }

    public void remove(TextComponent componentOfText) {
        singleLevelComponent.remove(componentOfText);
    }

    public void print() {
        for (TextComponent componentOfText : singleLevelComponent) {
            componentOfText.print();
        }
    }

   }