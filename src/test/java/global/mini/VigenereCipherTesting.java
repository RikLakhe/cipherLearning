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

    @Test
    public void decrypt2Testing() throws IOException {
        VigenereCipher vigenereCipher = new VigenereCipher("flute");
        String message = testDrive.getFile("athens_keyflute.txt");
        String result = vigenereCipher.decrypt(message);
//        assertEquals(message, result);
    }
}
