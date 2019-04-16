package app;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class isWellSortedTest {
	SortedIF g;
	
	@Before
	public void setUp() {
		String[][] array = { { "5", "0" }, { "4", "0" }, { "5", "2" }, { "4", "1" }, { "3", "1" }, { "2", "3" }};
		//String[][] array = { { "A", "C" }, { "C", "D" }, { "B", "C" }};
		//String[][] array = { { "A", "B" }, { "B", "C" }};
		g=new Graph(array);
	}     
	

	@Test
	public void testIsWellSorted() {
		String[] sequence = { "5", "4", "0", "3", "1" };
		//String[] sequence = { "B","C","B","A" };
		//String[] sequence = { "C","A" };
		assertTrue(g.isWellSorted(sequence));
	}
}
