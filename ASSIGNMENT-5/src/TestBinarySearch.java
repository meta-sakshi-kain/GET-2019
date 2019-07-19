import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
public class TestBinarySearch {
//@Test
//public void testBinarySearch1() {
//int array[]={12,32,34,56,78,96};
//int numSearch=56;
//int expected=3;
//int actual=Search.applyBinarySearch(array,numSearch);
//assertEquals("Expected Results do not match Actual Results",expected,actual);
//}
//
//@Test
//public void testBinarySearch2() {
//int array[]={12,32,34,56,78,96};
//int numSearch=32;
//int expected=1;
//int actual=Search.applyBinarySearch(array,numSearch);
//assertEquals("Expected Results do not match Actual Results",expected,actual);
//}
//
//@Test
//public void testBinarySearch() {
//int array[]={12,32,34,56,78,96};
//int numSearch=8;
//int expected=-1;
//int actual=Search.applyBinarySearch(array,numSearch);
//assertEquals("Expected Results do not match Actual Results",expected,actual);
//}
//
//@Test(expected=AssertionError.class)
//public void testBinarySearch4() {
//int array[]={};
//int numSearch=8;
//int actual=Search.applyBinarySearch(array,numSearch);
//}
//}


	@Test
	public void testLinearSearch() {
		assertEquals(1,Search.applyBinarySearch(new int[]{5,10,15,20},5));
		assertEquals(6,Search.applyBinarySearch(new int[]{1,2,3,4,5,6,9},6));
		assertEquals(-1,Search.applyBinarySearch(new int[]{1,4,5,6,9,56,78,44},66));
	}
	@AfterClass
	public static void testArrayIsEmpty(){
		try {
			Search.dolinearSearch(new int[]{},55);
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
	
}