package task2.models;


public class MinTextElement implements TextComponent {

    private String textElement;

    public MinTextElement(String str) {
        this.textElement = str;
    }

    public String getTextElement() {
        return this.textElement;
    }

    public void print() {
        System.out.print(getTextElement());

    }


}