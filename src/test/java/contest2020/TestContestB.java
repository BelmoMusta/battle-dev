
package contest2020;

import contest2020.b.IsoContestB;
import musta.belmo.battledev.AbstractTestClass;

public class TestContestB extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return IsoContestB.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File("BATTLE-DEV-2020/2").getAbsolutePath();
    }

    @Override
    public boolean useZipAsInputOutPutFiles() {
        return true;
    }
}