package global.mini;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class VigenereBreakerTesting {
    TestDrive testDrive = new TestDrive();

//    @Test
//    public void sliceStringTesting() {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String result = vigenereBreaker.sliceString("abcdefghijklm", 0, 3);
//        assertEquals(result, "adgjm");
//    }
//
//    @Test
//    public void sliceString2Testing() {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String result = vigenereBreaker.sliceString("abcdefghijklm", 1, 3);
//        assertEquals(result, "behk");
//    }
//
//    @Test
//    public void sliceString3Testing() {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String result = vigenereBreaker.sliceString("abcdefghijklm", 2, 3);
//        assertEquals(result, "cfil");
//    }
//
//    @Test
//    public void sliceString4Testing() {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String result = vigenereBreaker.sliceString("abcdefghijklm", 0, 4);
//        assertEquals(result, "aeim");
//    }

    @Test
    public void tryKeyLengthTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encryptMessage = testDrive.getFile("athens_keyflute.txt");
        String result = vigenereBreaker.tryKeyLength(encryptMessage,5,'e');
        assertEquals(result, "FLUTE");
    }

    @Test
    public void breakVigenereTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encryptMessage = testDrive.getFile("athens_keyflute.txt");
        String result = vigenereBreaker.breakVigenere(encryptMessage);
        assertEquals(result, "FLUTE");
    }

    @Test
    public void breakForLanguageTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encryptMessage = testDrive.getFile("athens_keyflute.txt");
        String englishWords = testDrive.getFile("englishWords.txt");
        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(englishWords);
        String result = vigenereBreaker.breakForLanguage(encryptMessage,hashSetWords);
        assertEquals(result, "FLUTE");
    }

//    @Test
//    public void q21Testing() throws IOException {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String encryptMessage = testDrive.getFile("secretmessage2.txt");
//        String englishWords = testDrive.getFile("English");
//        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(englishWords);
//        String result = vigenereBreaker.breakForLanguage(encryptMessage,hashSetWords);
//        assertEquals(result, "FLUTE");
//    }

//    Take little time to go through whole file
//    @Test
//    public void mostCommonCharInEnglishTesting() throws IOException {
//        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        String englishWords = testDrive.getFile("English");
//        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(englishWords);
//        char result = vigenereBreaker.mostCommonCharIn(hashSetWords);
//        assertEquals(result, 'E');
//    }

    @Test
    public void mostCommonCharInGermanyTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String germanWords = testDrive.getFile("German");
        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(germanWords);
        char result = vigenereBreaker.mostCommonCharIn(hashSetWords);
        assertEquals(result, 'E');
    }

    @Test
    public void mostCommonCharInDanishTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String danishWords = testDrive.getFile("Danish");
        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(danishWords);
        char result = vigenereBreaker.mostCommonCharIn(hashSetWords);
        assertEquals(result, 'E');
    }

    @Test
    public void mostCommonCharInDutchTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String dutchWords = testDrive.getFile("Dutch");
        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(dutchWords);
        char result = vigenereBreaker.mostCommonCharIn(hashSetWords);
        assertEquals(result, 'E');
    }

    @Test
    public void mostCommonCharInPortugueseTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String portugueseWords = testDrive.getFile("Portuguese");
        HashSet<String> hashSetWords = vigenereBreaker.readDictionary(portugueseWords);
        char result = vigenereBreaker.mostCommonCharIn(hashSetWords);
        assertEquals(result, 'A');
    }

    @Test
    public void breakForAllLangsTesting() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encrypt = testDrive.getFile("athens_keyflute.txt");
        HashMap<String, HashSet<String>> languages = testDrive.getLanguageFile();
        vigenereBreaker.breakForAllLangs(encrypt,languages);
    }

    @Test
    public void q1Testing() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encrypt = testDrive.getFile("secretmessage3.txt");
        HashMap<String, HashSet<String>> languages = testDrive.getLanguageFile();
        vigenereBreaker.breakForAllLangs(encrypt,languages);
    }

    @Test
    public void q3Testing() throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        String encrypt = testDrive.getFile("secretmessage4.txt");
        HashMap<String, HashSet<String>> languages = testDrive.getLanguageFile();
        vigenereBreaker.breakForAllLangs(encrypt,languages);
    }
}
