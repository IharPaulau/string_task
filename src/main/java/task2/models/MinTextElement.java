package task2.models;


import org.apache.log4j.Logger;
import task2.services.ComponentOfText;
import task2.services.impl.DelimiterImpl;

public class MinTextElement implements ComponentOfText {

    private String str;

    public MinTextElement(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    public void print() {
        System.out.print(getStr());

    }


}