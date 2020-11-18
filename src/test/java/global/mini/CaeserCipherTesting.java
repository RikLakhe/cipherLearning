package global.mini;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CaeserCipherTesting {
    TestDrive testDrive = new TestDrive();
    @Test
    public void encryptionTesting() throws IOException {
        String test = testDrive.getFile("titus-small.txt");
        CaeserCipher caeserCipher = new CaeserCipher(5);
        String result = caeserCipher.encrypt(test);
        assertEquals(result,"Htfq-gqfhp nx gjyyjw ymfs fstymjw mzj,Ns ymfy ny xhtwsx yt gjfw fstymjw mzj;Ktw fqq ymj bfyjw ns ymj thjfsHfs sjajw yzws ymj xbfs'x gqfhp qjlx yt bmnyj,Fqymtzlm xmj qfaj ymjr mtzwqd ns ymj kqtti.");
    }

    @Test
    public void decryptionTesting() throws IOException {
        CaeserCipher caeserCipher = new CaeserCipher();
        Answer result = caeserCipher.decrypt("Htfq-gqfhp nx gjyyjw ymfs fstymjw mzj,Ns ymfy ny xhtwsx yt gjfw fstymjw " +
                "mzj;Ktw fqq ymj bfyjw ns ymj thjfsHfs sjajw yzws ymj xbfs'x gqfhp qjlx yt bmnyj,Fqymtzlm xmj qfaj ymjr mtzwqd ns ymj kqtti.");
        assertEquals(result.getKey(),5);
    }

    @Test
    public void encryptLetterTesting() throws IOException {
        CaeserCipher caeserCipher = new CaeserCipher(5);
        String result = caeserCipher.encryptLetter('A');
        assertEquals(result,"F");
    }

    @Test
    public void decryptLetterTesting() throws IOException {
        CaeserCipher caeserCipher = new CaeserCipher(5);
        String result = caeserCipher.decryptLetter('F');
        assertEquals(result,"A");
    }
}
