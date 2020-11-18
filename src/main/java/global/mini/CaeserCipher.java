package global.mini;

public class CaeserCipher {
    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedString;

    public CaeserCipher() {
    }

    public CaeserCipher(int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
    }

    public String encryptLetter(char singleLetter){
        if (Character.isUpperCase(singleLetter)) {
            return getCipherString(Character.toUpperCase(singleLetter));
        } else {
            return getCipherString(Character.toUpperCase(singleLetter)).toLowerCase();
        }
    }

    public String decryptLetter(char singleLetter){
        if(Character.isUpperCase(singleLetter)){
            return getFirstAlphaString(singleLetter);
        }else{
            return getFirstAlphaString(Character.toUpperCase(singleLetter)).toLowerCase();
        }
    }

    private String getCipherString(char singleSting) {
        int alphaStringIndex = alphaString.indexOf(singleSting);
        try {
            return Character.toString(shiftedString.charAt(alphaStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    private String getFirstAlphaString(char singleString) {
        int shiftStringIndex = shiftedString.indexOf(singleString);
        try {
            return Character.toString(alphaString.charAt(shiftStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleString);
        }
    }

    private void shiftAlphaBySingleIndex(int shiftIndex) {
        this.shiftedString = alphaString.substring(shiftIndex) + alphaString.substring(0, shiftIndex);
    }

    private int[] countLetters(String inputString) {
        int[] letterCount = new int[26];
        for (int k = 0; k < inputString.length(); k++) {
            int alphaStringIndex = alphaString.indexOf(inputString.toUpperCase().charAt(k));
            if (alphaStringIndex != -1) {
                letterCount[alphaStringIndex] += 1;
            }
        }
        return letterCount;
    }

    private int findMaxIndex(int[] letterArray) {
        int maxIndex = 0;
        int maxCount = 0;
        for (int k = 0; k < letterArray.length; k++) {
            if (letterArray[k] > maxCount) {
                maxCount = letterArray[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public Answer decrypt(String inputString) {
        int[] freq = countLetters(inputString);
        int maxIndex = findMaxIndex(freq);
        int dKey = maxIndex - 4;
        if (maxIndex < 4) {
            dKey = 26 - (4 - maxIndex);
        }
        return new Answer(encrypt(inputString, 26 - dKey), 26 - dKey);
    }

    private String encrypt(String inputString, int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
        return encrypt(inputString);
    }

    public String encrypt(String inputString) {
        StringBuilder encryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            char inputCharacter = inputString.charAt(k);
            if (Character.isUpperCase(inputCharacter)) {
                encryptedString.append(getCipherString(Character.toUpperCase(inputCharacter)));
            } else {
                encryptedString.append(getCipherString(Character.toUpperCase(inputCharacter)).toLowerCase());
            }
        }
        return encryptedString.toString();
    }
}
