package task2.utils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;


public class FileWriter {


    public void write(String string) {


    File file = new File("d:/java study/321.txt");
        try {
            FileUtils.writeStringToFile(file, string, Charset.forName("Windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
