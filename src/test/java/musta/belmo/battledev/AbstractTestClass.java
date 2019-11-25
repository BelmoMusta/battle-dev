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

    private int totalTest;
    private int failedTests;

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
        totalTest = countTestCases(testCasesLocation, isZip);

        for (int i = 1; i <= totalTest; i++) {
            System.setIn(getInputStreamFromInputFile(testCasesLocation, i, isZip));
            Class<Object> classToBeTested = getClassToBeTested();
            Method main = classToBeTested.getMethod(MAIN_METHOD, String[].class);
            main.invoke(null, new Object[]{null});
            String result = outputStream.toString("UTF-8").trim();
            String expected = getOutputFileContent(testCasesLocation, i, isZip).trim();

            try {
                Assert.assertEquals(expected, result);
            } catch (Throwable b) {
                String reason = String.format("test %d didn't pass for the class [%s]", i, classToBeTested.getName());
                ComparisonFailure exception = new ComparisonFailure(reason, expected,result);
                collector.addError(exception);
                failedTests++;
            }
            outputStream.reset();
        }
    }

    @After
    public void afterTest() {
        System.setOut(sysOut);
        outputStream = new ByteArrayOutputStream();
        System.setIn(sysIn);
        System.out.println("total tests " + totalTest);
        System.out.println("passed tests " + (totalTest - failedTests));

        if (failedTests != 0) {
            System.err.println("faild tests " + failedTests);
        }
    }

    protected boolean useZipAsInputOutPutFiles() {
        return false;
    }
}