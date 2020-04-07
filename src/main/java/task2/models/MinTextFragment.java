package task2.models;


public class MinTextFragment implements TextComponent {

    private String textElement;

    public MinTextFragment(String str) {
        this.textElement = str;
    }

    public String getTextElement() {
        return this.textElement;
    }

    public void print() {
        System.out.print(getTextElement());

    }


}