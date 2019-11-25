package musta.belmo.battledev;

import org.junit.*;
import org.junit.rules.ErrorCollector;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.hamcrest.core.IsEqual.equalTo;

public abstract class AbstractTestClass extends TestCaseFileUtils {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream sysOut = System.out;
    private final InputStream sysIn = System.in;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    protected abstract <T> Class<T> getClassToBeTested();

    protected abstract String getTestCasesFilesLocation();

    @Before
    public void beforeTest() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test() throws Exception {
        boolean isZip = useZipAsInputOutPutFiles();
        String testCasesLocation = getTestCasesFilesLocation();
        int nTests = countTestCases(testCasesLocation, isZip);

        for (int i = 1; i <= nTests; i++) {
            System.setIn(getInputStreamFromInputFile(testCasesLocation, i, isZip));
            Class<Object> classToBeTested = getClassToBeTested();
            Method main = classToBeTested.getMethod(MAIN_METHOD, String[].class);
            main.invoke(null, new Object[]{null});
            String result = outputStream.toString("UTF-8").trim();
            String expected = getOutputFileContent(testCasesLocation, i, isZip).trim();
            collector.checkThat(String.format("test %d didn't pass for the class [%s]", i, classToBeTested.getName()), result, equalTo(expected));
            outputStream.reset();
        }
    }

    @After
    public void afterTest() {
        System.setOut(sysOut);
        outputStream = new ByteArrayOutputStream();
        System.setIn(sysIn);
    }

    protected boolean useZipAsInputOutPutFiles() {
        return false;
    }
}