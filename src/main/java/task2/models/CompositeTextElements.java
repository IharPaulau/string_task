package task2.models;

import task2.services.ComponentOfText;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextElements implements ComponentOfText {
    private String text;
    private List<ComponentOfText> singleLevelComponent = new ArrayList();

    public CompositeTextElements() {

    }

    public CompositeTextElements(String text) {
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public List<ComponentOfText> getSingleLevelComponent() {

        return this.singleLevelComponent;
    }

    public void add(ComponentOfText componentOfText) {

        this.singleLevelComponent.add(componentOfText);
    }

    public void remove(ComponentOfText componentOfText) {

        this.singleLevelComponent.remove(componentOfText);
    }

    public void print() {
        for (ComponentOfText componentOfText : singleLevelComponent) {
            componentOfText.print();
        }
    }

   }