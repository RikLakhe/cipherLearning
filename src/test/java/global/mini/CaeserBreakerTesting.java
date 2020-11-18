package global.mini;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CaeserBreakerTesting {
    TestDrive testDrive = new TestDrive();

    @Test
    public void getKeyTesting() {
        CaeserBreaker caeserBreaker = new CaeserBreaker();
        int result = caeserBreaker.getKey("Htfq-gqfhp nx gjyyjw ymfs fstymjw mzj,Ns ymfy ny xhtwsx yt gjfw fstymjw " +
                "mzj;Ktw fqq ymj bfyjw ns ymj thjfsHfs sjajw yzws ymj xbfs'x gqfhp qjlx yt bmnyj,Fqymtzlm xmj qfaj " +
                "ymjr mtzwqd ns ymj kqtti.");
        assertEquals(result, 5);
    }

    @Test
    public void getDecryptTesting() {
        CaeserBreaker caeserBreaker = new CaeserBreaker();
        String result = caeserBreaker.getDecryptMessage("Htfq-gqfhp nx gjyyjw ymfs fstymjw mzj,Ns ymfy ny xhtwsx yt " +
                "gjfw fstymjw mzj;" +
                "Ktw fqq ymj bfyjw ns ymj thjfsHfs sjajw yzws ymj xbfs'x gqfhp qjlx yt bmnyj,Fqymtzlm xmj qfaj ymjr " +
                "mtzwqd ns ymj kqtti.");
        assertEquals(result, "Coal-black is better than another hue,In that it scorns to bear another hue;For all the" +
                " water in the oceanCan never turn the swan's black legs to white,Although she lave them hourly in " +
                "the flood.");
    }

    @Test
    public void oslusiadas_key17Testing() throws IOException {
        CaeserBreaker caeserBreaker = new CaeserBreaker("a");
        String input = testDrive.getFile("oslusiadas_key17.txt");
        int result = caeserBreaker.getKey(input);
        assertEquals(result,17);
    }
}
