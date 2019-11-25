
package musta.belmo.battledev;

public class TestContestC extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return musta.belmo.battledev.c.IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File("BATTLE-DEV/3").getAbsolutePath();
    }

    @Override
    public boolean useZipAsInputOutPutFiles() {
        return true;
    }
}