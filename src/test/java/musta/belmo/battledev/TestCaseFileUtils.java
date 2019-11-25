package musta.belmo.battledev;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TestCaseFileUtils implements Constantes {

    protected String getOutputFileContent(String location, int testCaseNumber, boolean isZip) throws IOException {
        final String outputStirngFromFile;
        if (isZip) {
            final InputStream inputFileFromZip = getInputFileFromZip(location, OUTPUT_FILE_FORMAT, testCaseNumber);
            outputStirngFromFile = IOUtils.toString(inputFileFromZip, "UTF-8");
        } else {
            String outFile = String.format(OUTPUT_FILE_FORMAT, testCaseNumber);
            File file = new File(location, outFile);
            outputStirngFromFile = FileUtils.readFileToString(file, "UTF-8");
        }
        return outputStirngFromFile;
    }

    protected InputStream getInputStreamFromInputFile(String location, int testCaseNumber, boolean isZip) throws IOException {
        final InputStream fileInputStream;
        if (isZip) {
            fileInputStream = getInputFileFromZip(location, INPUT_FILE_FORMAT, testCaseNumber);

        } else {
            String inFile = String.format(INPUT_FILE_FORMAT, testCaseNumber);
            File file = new File(location, inFile);
            fileInputStream = new FileInputStream(file);
        }
        return fileInputStream;
    }

    protected int countTestCases(String location, boolean isZip) throws IOException {
        final int count;
        if (isZip) {
            count = countZipEntries(location) / 2;
        } else {
            count = (int) Files.list(Paths.get(new File(location).toURI())).count() / 2;
        }
        return count;
    }


    private InputStream getInputFileFromZip(String location, String pattern, int testCaseNumber) throws IOException {

        final ZipFile zipFile = getSingleZipFileInDirectory(location);
        final Enumeration<? extends ZipEntry> entries = zipFile.entries();
        InputStream stream = null;
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().endsWith(String.format(pattern, testCaseNumber))) {
                stream = zipFile.getInputStream(entry);
                break;
            }
        }
        return stream;
    }

    private ZipFile getSingleZipFileInDirectory(String location) throws IOException {
        File directory = new File(location);
        return new ZipFile(directory.listFiles()[0]);
    }

    private int countZipEntries(String location) throws IOException {
        final ZipFile zipFile = getSingleZipFileInDirectory(location);
        return zipFile.size();
    }
}
