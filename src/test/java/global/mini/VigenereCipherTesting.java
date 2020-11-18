package global.mini;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VigenereCipherTesting {
    TestDrive testDrive = new TestDrive();

    @Test
    public void initializeWithKeyArrayTesting() {
        VigenereCipher vigenereCipher = new VigenereCipher(new int[]{17, 14, 12, 4});
        String result = vigenereCipher.toString();
        assertEquals(result, "ROME");
    }

    @Test
    public void initializeWithKeyWordTesting() {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        ArrayList<Integer> result = vigenereCipher.getKeys();
        assertEquals(result.size(), 4);
    }

    @Test
    public void sliceStringTesting() {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String result = vigenereCipher.sliceString("abcdefghijklm", 0, 3);
        assertEquals(result, "adgjm");
    }

    @Test
    public void sliceString2Testing() {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String result = vigenereCipher.sliceString("abcdefghijklm", 1, 3);
        assertEquals(result, "behk");
    }

    @Test
    public void sliceString3Testing() {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String result = vigenereCipher.sliceString("abcdefghijklm", 2, 3);
        assertEquals(result, "cfil");
    }

    @Test
    public void sliceString4Testing() {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String result = vigenereCipher.sliceString("abcdefghijklm", 0, 4);
        assertEquals(result, "aeim");
    }

    @Test
    public void encryptTesting() throws IOException {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String message = testDrive.getFile("titus-small.txt");
        String result = vigenereCipher.encrypt(message);
        assertEquals(result, "Tcmp-pxety mj nikhqv htee mrfhtii tyv,Ur htek ux gosibe kc fvod rbaxysd yiq;Wcd rzx kvq nofii ur hti coirbOee zimsd kidr hti giee'e szmgb xixg xf ilzhq,Rzflfisl gti zmzv flva lfidpp ur hti txsfr.");
    }

    @Test
    public void decryptTesting() throws IOException {
        VigenereCipher vigenereCipher = new VigenereCipher("rome");
        String message = testDrive.getFile("titus-small.txt");
        String result = vigenereCipher.decrypt("Tcmp-pxety mj nikhqv htee mrfhtii tyv,Ur htek ux gosibe kc fvod rbaxysd yiq;Wcd rzx kvq nofii ur hti coirbOee zimsd kidr hti giee'e szmgb xixg xf ilzhq,Rzflfisl gti zmzv flva lfidpp ur hti txsfr.");
        assertEquals(message, result);
    }
}
