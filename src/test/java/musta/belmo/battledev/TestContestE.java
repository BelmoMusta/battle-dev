
package musta.belmo.battledev;

public class TestContestE extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return musta.belmo.battledev.e.IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File("BATTLE-DEV/5").getAbsolutePath();
    }

    @Override
    public boolean useZipAsInputOutPutFiles() {
        return true;
    }
}