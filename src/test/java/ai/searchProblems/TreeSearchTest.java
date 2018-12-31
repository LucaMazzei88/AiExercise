package ai.searchProblems;

import static ai.searchProblems.City.ARAD;
import static ai.searchProblems.City.BUCAREST;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TreeSearchTest {

	TreeSearch sut;

	@Before
	public void setup() {
		sut = new TreeSearch(new RomaniaMap());
	}

	@Test
	public void test() {

		assertEquals("the shortest route from Arad to Bucarest, pag. 85",
				BUCAREST,
				sut.search(new Itinerary(ARAD, BUCAREST)));

	}

}
