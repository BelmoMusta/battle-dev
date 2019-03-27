package musta.belmo.battledev;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Common {
    public static String readFromFile(int number, String srcfile) throws IOException, URISyntaxException {
        URL resourceAsStream = Common.class.getClassLoader().getResource(String.format("BATTLE-DEV/%d", number) +"/" +srcfile);
        File file = new File(resourceAsStream.toURI());
        return FileUtils.readFileToString(file, "UTF-8");
    }
}
