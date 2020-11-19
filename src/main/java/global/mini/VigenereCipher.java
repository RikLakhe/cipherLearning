package global.mini;

import java.util.ArrayList;

public class VigenereCipher {
    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private ArrayList<Integer> keys;
    private ArrayList<CaeserCipher> caeserCipherArray;
    private String keyWord;

    public VigenereCipher(int[] keys) {
        this.keys = new ArrayList<>();
        this.caeserCipherArray = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char letter;
        for(int key: keys){
            this.keys.add(key);
            this.caeserCipherArray.add(new CaeserCipher(key));
            letter = alphaString.charAt(key);
            sb.append(letter);
        }
        this.keyWord = sb.toString();
    }

    public VigenereCipher(String keyWord) {
        this.keys = new ArrayList<>();
        this.caeserCipherArray = new ArrayList<>();
        this.keyWord = keyWord;
        int index;
        for(int i = 0; i<keyWord.length();i++){
            index = alphaString.indexOf(keyWord.toUpperCase().charAt(i));
            this.caeserCipherArray.add(new CaeserCipher(index));
            keys.add(index);
        }
    }

    public String encrypt(String message){
        StringBuilder sb = new StringBuilder();
        outerloop:
        for(int i=0;i<message.length();i+= keys.size()){
            for(int j=0;j<keys.size();j++){
                if(i+j>=message.length()){
                    break outerloop;
                }
                sb.append(caeserCipherArray.get(j).encryptLetter(message.charAt(i+j)));
            }
        }
        return sb.toString();
    }

    public String decrypt(String encryptMessage){
        StringBuilder sb = new StringBuilder();
        outerloop:
        for(int i=0;i<encryptMessage.length();i+= keys.size()){
            for(int j=0;j<keys.size();j++){
                if(i+j>=encryptMessage.length()){
                    break outerloop;
                }
                sb.append(caeserCipherArray.get(j).decryptLetter(encryptMessage.charAt(i+j)));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return keyWord;
    }

    public ArrayList<Integer> getKeys() {
        return keys;
    }
}
