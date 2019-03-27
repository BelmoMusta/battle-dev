
package musta.belmo.battledev;

public class TestContestB extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return musta.belmo.battledev.b.IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
        return new java.io.File(getClass().getClassLoader().getResource("BATTLE-DEV").getFile()).getAbsolutePath();

    }
}