package task2.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.services.ComponentOfText;


public class FileWriter {
    String string = "";
    File file = new File("result.txt");

    public void write(ComponentOfText allText) {
        for (int i = 0; i < ((CompositeTextElements) allText).getSingleLevelComponent().size(); i++) {
            ComponentOfText sentence = ((CompositeTextElements) allText).getSingleLevelComponent().get(i);
            List<ComponentOfText> s = ((CompositeTextElements) sentence).getSingleLevelComponent();
            for (int j = 0; j < s.size(); j++) {
                string += ((MinTextElement) s.get(j)).getStr();
            }
        }

        try {
            FileUtils.writeStringToFile(file, string, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





