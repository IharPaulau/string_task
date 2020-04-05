package task2.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;

public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class);
    public String readFile(String fileLocation, String charFormat) {
        try {
            LOGGER.info("text was read from file");
            return FileUtils.readFileToString(new File(fileLocation), Charset.forName(charFormat));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // When something went wrong
    }
}
