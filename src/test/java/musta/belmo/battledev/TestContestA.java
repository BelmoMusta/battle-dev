
package musta.belmo.battledev;

public class TestContestA extends AbstractTestClass {

    @Override
    protected Class getClassToBeTested() {
        return musta.belmo.battledev.a.IsoContest.class;
    }

    @Override
    protected String getTestCasesFilesLocation() {
      return new java.io.File("BATTLE-DEV/1").getAbsolutePath();
    }

}