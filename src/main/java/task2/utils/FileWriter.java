package task2.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;


public class FileWriter {


    public void write(Component allText) {

        for (int i = 0; i < ((Composite) allText).getComponentList().size(); i++) {
            Component sentence = ((Composite) allText).getComponentList().get(i);
            List<Component> s = ((Composite) sentence).getComponentList();
            for (int j = 0; j < s.size(); j++) {
                write(((Element) s.get(j)).getStr());
            }
        }
    }


    public void write(String str) {
        File file = new File("result.txt");
        try {
            FileUtils.writeStringToFile(file, str, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
