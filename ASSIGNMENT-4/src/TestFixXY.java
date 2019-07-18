
import static org.junit.Assert.*;
import org.junit.Test;


public class TestFixXY {
	@Test
	public void testCorrectResults() {
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9},ArrOperation.fixXY(new int[]{5, 4, 9, 4, 9, 5},4,5));
		assertArrayEquals(new int[]{1, 4, 5, 1},ArrOperation.fixXY(new int[]{1, 4, 1, 5},4,5));
		assertArrayEquals(new int[]{1, 4, 5, 1, 1, 4, 5},ArrOperation.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1},4,5));
	}

	@Test
	public void testArrayIsEmpty(){
		try {
			ArrOperation.fixXY(new int[]{},0,0);
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
	@Test
	public void testUnequalXandY(){
		try {
			ArrOperation.fixXY(new int[]{5, 4, 9, 4, 9},4,5);
		} catch (AssertionError e) {
			System.out.println("unequal numbers of X and Y in input array");
		}
	}
	@Test
	public void testAdjacentX(){
		try {
			ArrOperation.fixXY(new int[]{5, 4, 4, 9, 5},4,5);
		} catch (AssertionError e) {
			System.out.println("two adjacent X values in array");
		}
	}
	@Test
	public void testXAtLastIndex(){
		try {
			ArrOperation.fixXY(new int[]{5, 4, 5, 9, 4},4,5);
		} catch (AssertionError e) {
			System.out.println("X occurs at the last index in array "+e);
		}
	}

}
