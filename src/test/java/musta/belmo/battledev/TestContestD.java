
package musta.belmo.battledev;

public class TestContestD extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return musta.belmo.battledev.d.IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File("BATTLE-DEV/4").getAbsolutePath();
    }

    @Override
    public boolean useZipAsInputOutPutFiles() {
        return true;
    }
}