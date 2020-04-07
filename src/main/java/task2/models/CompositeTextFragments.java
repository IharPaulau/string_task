package task2.models;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextFragments implements TextComponent {
    private List<TextComponent> oneLevelFragments = new ArrayList();

    public CompositeTextFragments() {
    }

    public List<TextComponent> getOneLevelFragments() {
        return oneLevelFragments;
    }

    public void add(TextComponent componentOfText) {
        oneLevelFragments.add(componentOfText);
    }

    public void remove(TextComponent componentOfText) {
        oneLevelFragments.remove(componentOfText);
    }

    public void print() {
        for (TextComponent componentOfText : oneLevelFragments) {
            componentOfText.print();
        }
    }

}