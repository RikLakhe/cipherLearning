package global.mini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TestDrive {
    public String getFile(String fileName) throws IOException {
        File file = new File("src/main/resources/"+fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder ss = new StringBuilder();

            while ((line = br.readLine()) != null) {
//                if(line.startsWith("  ")){
//                    ss.append(line.substring(2)+" ");
//                }else{
                    ss.append(line+" ");
//                }
            }
            return  ss.toString();
        }
    }

    private HashSet<String> readDictionary(String wordsInString) {
        return new HashSet<>(Arrays.asList(wordsInString.split(" ")));
    }

    public HashMap<String, HashSet<String>> getLanguageFile() throws IOException {
        String[] languageFileNames = {"English","Danish","Dutch","French","German","Italian","Portuguese","Spanish"};
        HashMap<String, HashSet<String>> hashSetHashMap = new HashMap<>();
        for(String fileName: languageFileNames){
            File file = new File("src/main/resources/"+fileName);

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder ss = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    ss.append(line+" ");
                }

                hashSetHashMap.put(fileName,readDictionary(ss.toString()));
            }

        }

        return hashSetHashMap;
    }
}
