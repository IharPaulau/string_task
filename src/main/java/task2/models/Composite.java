package task2.models;

import task2.services.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private String text;
    private List<Component> componentList = new ArrayList();

    public Composite() {
    }

    public Composite(String text) {
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public List<Component> getComponentList() {

        return this.componentList;
    }

    public void add(Component component) {

        this.componentList.add(component);
    }

    public void remove(Component component) {

        this.componentList.remove(component);
    }

    public void print() {
        for (Component component : componentList) {
            component.print();
        }
    }

    @Override
    public String wtite() {
        for (Component component : componentList) {
            component.wtite();
        }
    return null;
    }
}