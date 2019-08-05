package question_3;
import static org.junit.Assert.*;

import org.junit.Test;

public class MultivariantPolynomialTest {

	//Test case when polynomial is valid 
	@Test
	public void findDegreeOfValidPolynomialTest() {
		NestedLinkedList list = new NestedLinkedList();
		list = MultivariantPolynomial.createMainList(list,"4x3yz+4x2y2z2+6xyz3");
		assertEquals(6,  MultivariantPolynomial.highestDegree(list));
	}

	//Test case when polynomial is invalid
	@Test(expected=AssertionError.class)
	public void invalidPolynomialTest() {
		NestedLinkedList list = new NestedLinkedList();
         MultivariantPolynomial.createMainList(list,"22x%22y2z+31x33yz33");
	}
}
