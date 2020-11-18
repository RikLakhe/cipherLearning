package global.mini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDrive {
    public String getFile(String fileName) throws IOException {
        File file = new File("src/main/resources/"+fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder ss = new StringBuilder();

            while ((line = br.readLine()) != null) {
                ss.append(line);
            }
            return  ss.toString();
        }
    }
}
