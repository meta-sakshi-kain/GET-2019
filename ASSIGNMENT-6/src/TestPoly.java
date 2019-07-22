import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPoly {
	
	@Test
	public void testEvaluate() {
		assertEquals(8, new Poly(new int[] { 2, 4 }).evaluate(2), 0.0001);
		assertEquals(2, new Poly(new int[] { 2, 4 }).evaluate(-1), 0.0001);
		assertEquals(7, new Poly(new int[] { 1, 4, 2 }).evaluate(1), 0.0001);
	}

	@Test
	public void testDegree() {
		assertEquals(1, new Poly(new int[] { 2, 4 }).degree());
		assertEquals(3, new Poly(new int[] { 2, 4, 7, 8 }).degree());
	}

	@Test
	public void testAddPoly() {
		assertArrayEquals(new Poly(new int[] { 4, 8, 4 }).getArray(),
				  Poly.addPoly(new Poly(new int[] { 4, 2, 1 }),
			          new Poly(new int[] { 6, 3 })).getArray());
	}

	@Test
	public void testMultiplyPoly() {
		assertArrayEquals(new Poly(new int[] { 1, 4, 7, 6 }).getArray(),
				           Poly.multiplyPoly(new Poly(new int[] { 1, 2, 3 }),
				           new Poly(new int[] { 1, 2 })).getArray());
		assertArrayEquals(new Poly(new int[] { 3, 8, 5, 2 }).getArray(),
				           Poly.multiplyPoly(new Poly(new int[] { 1, 2 }),
					   new Poly(new int[] { 3, 2, 1 })).getArray());
	}

}