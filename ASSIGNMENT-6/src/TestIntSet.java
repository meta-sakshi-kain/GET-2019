import static org.junit.Assert.*;
import org.junit.Test;

public class TestIntSet {

	@Test
	public void checkMemberExistInSet() {
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isMember(7));
		assertFalse(new IntSet(new int[] { 2, 3, 6, 8, 2, 5, 4, 5 }).isMember(7));
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 7 }).isMember(7));
		assertTrue(new IntSet(new int[] { 1, 2, 7, 4, 5, 6 }).isMember(7));
	}
	
	@Test
	public void cheakSetSize(){
		assertEquals(6, new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).size());
		assertEquals(5, new IntSet(new int[] { 1, 2, 3, 4, 5 }).size());
		assertEquals(4, new IntSet(new int[] { 1, 2, 3, 4 }).size());
		assertEquals(1, new IntSet(new int[] { 1 }).size());
	}
	
	@Test
	public void checkSubsetInSet(){
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 1, 2, 3, 4, 5 })));
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 2, 6, 3 })));
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 1, 2, 3, 4, 5,7 })));
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 2, 3, 8 }).isSubSet(new IntSet(new int[] { 2, 3, 8, 7})));
	}
	
	@Test
	public void checkUnionOfSets(){
		assertArrayEquals(
				new IntSet(new int[] { 1, 2, 3, 4 }).getArray(),
				IntSet.union(new IntSet(new int[] { 1, 2, 3 }),
				new IntSet(new int[] { 2, 4 })).getArray());
		assertArrayEquals(
				new IntSet(new int[] { 5, 8, 10, 15 }).getArray(),
				IntSet.union(new IntSet(new int[] { 5, 8, 10 }),
				new IntSet(new int[] { 8, 15 })).getArray());
		assertArrayEquals(
				new IntSet(new int[] { 2, 9, 21, 22, 56 }).getArray(),
				IntSet.union(new IntSet(new int[] { 2, 9, 21 }),
						new IntSet(new int[] { 21, 22, 56 })).getArray());
		assertArrayEquals(
				new IntSet(new int[] { 4, 7, 10, 15, 18, 30 }).getArray(),
				IntSet.union(new IntSet(new int[] { 4, 7, 10 }),
				new IntSet(new int[] { 15, 18, 30 })).getArray());
	}

}
