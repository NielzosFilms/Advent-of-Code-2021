package helpers;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<String> getLines(String path) {
        try {
            File text_file = new File(path);
            BufferedReader bufReader = new BufferedReader(new FileReader(text_file));
            ArrayList<String> lines = new ArrayList<String>();

            String line = bufReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
