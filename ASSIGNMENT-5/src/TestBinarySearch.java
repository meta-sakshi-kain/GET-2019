import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
public class TestBinarySearch {

@Test
public void testBinarySearch() {
	assertEquals(1,Search.applyBinarySearch(new int[]{5,10,15,20},5));
	assertEquals(6,Search.applyBinarySearch(new int[]{1,2,3,4,5,6,9},6));
	assertEquals(0,Search.applyBinarySearch(new int[]{1,4,5,6,9,56,78,44},66));	}

@AfterClass
public static void testArrayIsEmpty(){
	try {
		Search.dolinearSearch(new int[]{},55);
	} catch (AssertionError e) {
		System.out.println("Array is empty");
	}
}

}
