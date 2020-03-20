package task2.services.textreader;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;

public class FileReader {
    String text = "something went wrong";

    public String readFile(String fileLocation, String charFormat) {
        try {
            return FileUtils.readFileToString(new File(fileLocation), Charset.forName(charFormat));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
