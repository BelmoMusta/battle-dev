package musta.belmo.battledev;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCaseFileUtils implements Constantes {

    protected String getOutputFileContent(String location, int testCaseNumber) throws IOException {
        String outFile = String.format(OUTPUT_FILE_FORMAT, testCaseNumber);
        File file = new File(location, outFile);
        return FileUtils.readFileToString(file, "UTF-8");
    }

    protected InputStream getInputStreamFromInputFile(String location, int testCaseNumber) throws IOException {
        String inFile = String.format(INPUT_FILE_FORMAT, testCaseNumber);
        File file = new File(location, inFile);
        return new FileInputStream(file);
    }

    protected int countTestCases(String location) throws IOException {
        return (int) Files.list(Paths.get(new File(location).toURI())).count() / 2;
    }
}
