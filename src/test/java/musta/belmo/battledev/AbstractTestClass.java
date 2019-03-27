package musta.belmo.battledev;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public abstract class AbstractTestClass extends TestCaseFileUtils {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream sysOut = System.out;
    private final InputStream sysIn = System.in;


    protected abstract <T> Class<T> getClassToBeTested();

    protected abstract String getTestCasesFilesLocation();

    @Before
    public void beforeTest() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test() throws Exception {
        String testCasesLocation = getTestCasesFilesLocation();
        int nTests = countTestCases(testCasesLocation);

        for (int i = 1; i <= nTests; i++) {
            System.setIn(getInputStreamFromInputFile(testCasesLocation, i));
            Method main = getClassToBeTested().getMethod(MAIN_METHOD, String[].class);
            main.invoke(null, new Object[]{null});
            String result = outputStream.toString("UTF-8").trim();
            String expected = getOutputFileContent(testCasesLocation, i).trim();
            Assert.assertEquals(expected, result);
            outputStream.reset();
        }
    }

    @After
    public void afterTest() {
        System.setOut(sysOut);
        outputStream = new ByteArrayOutputStream();
        System.setIn(sysIn);
    }
}