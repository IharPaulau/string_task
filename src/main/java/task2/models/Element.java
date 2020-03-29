package task2.models;


import task2.services.Component;

public class Element implements Component {
    private String str;

    public Element(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    public void print() {
        System.out.print(getStr());
    }


}