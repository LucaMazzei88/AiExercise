package ai.enviroment;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import ai.environment.impl.EnvironmentCell;
import ai.environment.impl.VacuumCleanerEnvironment;
import ai.environment.impl.VacuumCleanerEnvironmentStatus;

@RunWith(BlockJUnit4ClassRunner.class)
public class VacuumCleanerEnvironmentTest {

	VacuumCleanerEnvironment sut;

	@Before
	public void setup() {
		sut = new VacuumCleanerEnvironment();
	}

	@Test
	public void oneCellClean() {

		EnvironmentCell cell = new EnvironmentCell(false);
		sut.addEnvironmentObject(cell);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(0));
	}

	@Test
	public void oneCellDirty() {

		EnvironmentCell cell = new EnvironmentCell(true);
		sut.addEnvironmentObject(cell);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(1));
	}

	@Test
	public void twoCellNordSudDirty() {

		EnvironmentCell nord = new EnvironmentCell(true);
		EnvironmentCell sud = new EnvironmentCell(true);
		nord.setSud(sud);
		sud.setNord(nord);
		sut.addEnvironmentObject(nord);
		sut.addEnvironmentObject(sud);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(2));
	}

	@Test
	public void twoCellEstOvestDirty() {

		EnvironmentCell est = new EnvironmentCell(true);
		EnvironmentCell ovest = new EnvironmentCell(true);
		est.setOvest(ovest);
		ovest.setEst(est);
		sut.addEnvironmentObject(ovest);
		sut.addEnvironmentObject(est);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(2));
	}

	@Test
	public void threeCellEstOvestSudDirty() {

		EnvironmentCell est = new EnvironmentCell(true);
		EnvironmentCell ovest = new EnvironmentCell(true);
		EnvironmentCell sud = new EnvironmentCell(true);
		est.setOvest(ovest);
		ovest.setEst(est);
		ovest.setSud(sud);
		sut.addEnvironmentObject(ovest);
		sut.addEnvironmentObject(est);
		sut.addEnvironmentObject(sud);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(3));
	}

	@Test
	public void wrongPosition() {

		EnvironmentCell est = new EnvironmentCell(true);
		EnvironmentCell ovest = new EnvironmentCell(true);
		EnvironmentCell sud = new EnvironmentCell(true);
		est.setOvest(ovest);
		ovest.setEst(est);
		ovest.setSud(sud);
		Assert.assertFalse(est.setSud(sud));
		sut.addEnvironmentObject(ovest);
		sut.addEnvironmentObject(est);
		sut.addEnvironmentObject(sud);

		assertEquals(sut.getStatus(), new VacuumCleanerEnvironmentStatus(3));
	}
}
