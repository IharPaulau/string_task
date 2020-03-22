package task2.models;


import task2.services.Component;

public class Word implements Component {
    private String str;

    public Word() {
    }

    public Word(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void print() {
    }
}