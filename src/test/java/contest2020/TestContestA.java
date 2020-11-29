
package contest2020;

import contest2020.a.IsoContest;
import musta.belmo.battledev.AbstractTestClass;

public class TestContestA extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File("BATTLE-DEV-2020/1").getAbsolutePath();
    }

    @Override
    public boolean useZipAsInputOutPutFiles() {
        return true;
    }
}