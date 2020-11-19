package global.mini;

public class CaeserBreaker {
    private String commonWord;
    private int commonWordIndex = -1;
    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedString;

    public CaeserBreaker() {
        this.commonWord = "e";
        this.commonWordIndex = alphaString.indexOf("E");
    }

    public CaeserBreaker(char commonWord) {
        this.commonWord = Character.toString(commonWord);
        this.commonWordIndex = alphaString.indexOf(Character.toString(commonWord).toUpperCase());
    }

    public CaeserBreaker(String commonWord) {
        this.commonWord = commonWord;
        this.commonWordIndex = alphaString.indexOf(commonWord.toUpperCase());
    }

    private String getCipherString(char singleSting) {
        int alphaStringIndex = alphaString.indexOf(singleSting);
        try {
            return Character.toString(shiftedString.charAt(alphaStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    public int getKey(String message) {
        Answer answer = decrypt(message);
        return answer.getKey();
    }

    public String getDecryptMessage(String message) {
        Answer answer = decrypt(message);
        return answer.getAnswer();
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
        int dKey = maxIndex - (this.commonWordIndex);
        if (maxIndex < (this.commonWordIndex)) {
            dKey = 26 - ((this.commonWordIndex) - maxIndex);
        }
        return new Answer(encrypt(inputString, 26 - dKey), 26 - dKey);
    }

    private String encrypt(String inputString, int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
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
