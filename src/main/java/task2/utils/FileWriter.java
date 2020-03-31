package task2.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import task2.models.Composite;
import task2.models.Element;
import task2.services.Component;


public class FileWriter {
    String string = "";
    File file = new File("result.txt");

    public void write(Component allText) {
        for (int i = 0; i < ((Composite) allText).getComponentList().size(); i++) {
            Component sentence = ((Composite) allText).getComponentList().get(i);
            List<Component> s = ((Composite) sentence).getComponentList();
            for (int j = 0; j < s.size(); j++) {
                string += ((Element) s.get(j)).getStr();
            }
        }

        try {
            FileUtils.writeStringToFile(file, string, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





