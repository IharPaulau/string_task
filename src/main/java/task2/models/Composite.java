package task2.models;

import task2.services.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Composite implements Component {
    private List<Component> componentList = new ArrayList();

    public Composite() {
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
        Iterator var1 = this.componentList.iterator();

        while(var1.hasNext()) {
            Component component = (Component)var1.next();
            System.out.print(((Word)component).getStr());
        }

    }
}
