package task2;

import java.io.*;
import java.nio.charset.Charset;

public class FileReader {
    private FileInputStream fileInputStream = null;
    private InputStreamReader inputStreamReader = null;
    private int b = 0;
    String text = "";

    String readFile() {
        try {
            fileInputStream = new FileInputStream("d:/java study/123.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("Windows-1251"));
            while ((b = inputStreamReader.read()) != -1) {
                text = text + (char) b;
            }
        } catch (IOException e) {
            e.printStackTrace();

            try {
                fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return text;
    }
}
