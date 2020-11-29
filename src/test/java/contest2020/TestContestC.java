
package contest2020;

import contest2020.c.IsoContest;
import musta.belmo.battledev.AbstractTestClass;

public class TestContestC extends AbstractTestClass {
	
	@Override
	protected Class getClassToBeTested() {
		return IsoContest.class;
	}
	
	@Override
	protected String getTestCasesFilesLocation() {
		return new java.io.File("BATTLE-DEV-2020/3").getAbsolutePath();
	}
	
	@Override
	public boolean useZipAsInputOutPutFiles() {
		return true;
	}
}