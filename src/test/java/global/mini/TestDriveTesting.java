package global.mini;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestDriveTesting {
    TestDrive testDrive = new TestDrive();

    @Test
    public void testDriveTesting() throws IOException {
        String result = testDrive.getFile("titus-small.txt");
        assertEquals(result,"Coal-black is better than another hue,In that it scorns to bear another hue;For all the " +
                "water in the oceanCan never turn the swan's black legs to white,Although she lave them hourly in the flood.");
    }
}
