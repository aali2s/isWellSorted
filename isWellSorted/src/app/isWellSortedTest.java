package app;

import static org.junit.Assert.assertTrue;

import org.junit.*;



public class isWellSortedTest {
	SortedIF g;
	
	@Before
	public void setUp() {
		String[][] array = {{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
		g=new Graph(array);
	}
	

	@Test
	public void test1IsWellSorted() {
		String[] sequence = { "A" , "B", "C", "D" };
		assertTrue(g.isWellSorted(sequence));
	}
	
	@Test
	public void test2IsWellSorted() {
		String[] sequence = { "D" , "C", "B", "A" };
		assertTrue(g.isWellSorted(sequence));
	}
}
