package task2.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import task2.models.CompositeTextFragments;
import task2.models.MinTextFragment;
import task2.models.TextComponent;


public class FileWriter {
    private static final Logger LOGGER = Logger.getLogger(FileWriter.class);
    private StringBuilder stringBuilder = new StringBuilder();
    private File file = new File("result.txt");

    public void write(TextComponent allText) {
        for (int i = 0; i < ((CompositeTextFragments) allText).getOneLevelFragments().size(); i++) {
            TextComponent sentence = ((CompositeTextFragments) allText).getOneLevelFragments().get(i);
            List<TextComponent> elements = ((CompositeTextFragments) sentence).getOneLevelFragments();
            for (TextComponent element : elements) {
                stringBuilder.append(((MinTextFragment) element ).getTextElement());
            }
        }

        try {
            FileUtils.writeStringToFile(file, stringBuilder.toString(), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("the text was written to a '%s' file",
                file.getName()));
    }
}





