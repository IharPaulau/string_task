package task2.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;

public class FileReader {

    public String readFile(String fileLocation, String charFormat) {
        try {
            return FileUtils.readFileToString(new File(fileLocation), Charset.forName(charFormat));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "something went wrong";
    }
}
