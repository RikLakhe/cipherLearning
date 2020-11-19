package global.mini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VigenereBreaker {
    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private ArrayList<String> sliceStrings;

    public VigenereBreaker() {
    }

    private String sliceString(String message, int whichSlice,int totalSlice){
        StringBuilder sb= new StringBuilder();
        for(int i =whichSlice; i<message.length();i+=totalSlice){
            sb.append(message.charAt(i));
        }
//        System.out.println("slice====>"+sb.toString());
        return sb.toString();
    }

    public String tryKeyLength(String encrypted, int kLength , char mostCommon){
        StringBuilder sb = new StringBuilder();
        CaeserBreaker caeserBreaker = new CaeserBreaker(mostCommon);
//        sliceStrings = new ArrayList<>();
        for(int i= 0;i<kLength;i++){
//            sliceStrings.add(sliceString(encrypted,i,kLength));
            sb.append(alphaString.charAt(caeserBreaker.getKey(sliceString(encrypted,i,kLength))));
        }
        return sb.toString();
    }

    public String breakVigenere(String encryptMessage){
        String keyWord = tryKeyLength(encryptMessage,5,'e');

        VigenereCipher vigenereCipher = new VigenereCipher(keyWord);
        System.out.println(encryptMessage);
        System.out.println(vigenereCipher.decrypt(encryptMessage));
        return keyWord;
    }

    public String breakVigenere(String encryptMessage, int kLength , char mostCommon){
        String keyWord = tryKeyLength(encryptMessage,kLength,mostCommon);

        VigenereCipher vigenereCipher = new VigenereCipher(keyWord);
//        System.out.println(encryptMessage);
//        System.out.println(vigenereCipher.decrypt(encryptMessage));
        return keyWord;
    }

    public String breakVigenereGetMessage(String encryptMessage, int kLength , char mostCommon){
        String keyWord = tryKeyLength(encryptMessage,kLength,mostCommon);
        VigenereCipher vigenereCipher = new VigenereCipher(keyWord);
        return vigenereCipher.decrypt(encryptMessage);
    }

    public HashSet<String> readDictionary(String wordsInString) {
        return new HashSet<>(Arrays.asList(wordsInString.split(" ")));
    }

    private int countWords(String message,HashSet<String> hashSetWords){
        String[] messageWords = message.split("\\W+");
        int count = 0;
        for(String word: messageWords){
            if(hashSetWords.contains(word.toLowerCase())){
                count++;
            }
        }

        return count;
    }

    public String breakForLanguage(String encrypted,HashSet<String> hashSetWords){
        int max = 0;
        int answerLength = 0;
        char commonChar = mostCommonCharIn(hashSetWords);
        for(int i=1;i<=100;i++){
            String result = breakVigenereGetMessage(encrypted,i,commonChar);
            int counter = countWords(result,hashSetWords);
//            System.out.println("count i=>"+i+"max at=>"+counter);
            if(counter > max){
                max = counter;
                answerLength=i;
            }
        }

        String decryptMessage = breakVigenereGetMessage(encrypted,answerLength,commonChar);
        String decryptKey = breakVigenere(encrypted,answerLength,commonChar);
        System.out.println("here i=>"+answerLength+"max at=>"+max);
        System.out.println("Message =>"+decryptMessage);
        System.out.println("Key =>"+decryptKey);

        return decryptKey;
    }

    public char mostCommonCharIn(HashSet<String> hashSetDictionary){
        int count = 0;
        int maxCount = 0;
        char maxCharacter = 0;
        for(String character : alphaString.split("")){
            count = 0;
            for(String word : hashSetDictionary){
                if(word.toLowerCase().contains(character.toLowerCase())){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount = count;
                maxCharacter = character.charAt(0);
            }
        }
        return maxCharacter;
    }

    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        for(String languagesKey: languages.keySet()){
            String result = breakForLanguage(encrypted, languages.get(languagesKey));
            System.out.println("language="+languagesKey);
            System.out.println("message="+result);
        }
    }
}
