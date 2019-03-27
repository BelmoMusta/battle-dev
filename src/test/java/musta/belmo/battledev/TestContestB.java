
package musta.belmo.battledev;


import musta.belmo.battledev.b.Contest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestContestB implements TestConstants {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream sysOut = System.out;


    @Before
    public void beforeTest() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void afterTest() {
        System.setOut(sysOut);
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testE() throws Exception {
        int nTests = 6;
        for (int i = 1; i <= nTests; i++) {
            String inFile = String.format(INPUT_FILE, i);
            String outFile = String.format(OUTPUT_FILE, i);

            Contest.solution(inFile);
            String result = outputStream.toString("UTF-8").trim();
            String expected = Common.readFromFile(6, outFile).trim();
            Assert.assertEquals(expected, result);
            outputStream.reset();
        }
    }
}