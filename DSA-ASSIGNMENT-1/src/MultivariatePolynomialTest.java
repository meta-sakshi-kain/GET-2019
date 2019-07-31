import static org.junit.Assert.*;
import org.junit.Test;
// Class to test multivariate polynomial
public class MultivariatePolynomialTest {

	//Find degree when polynomial is valid
	@Test
	public void findDegreeOfValidPolynomialTest() {
		MultivariatePolynomial poly = new MultivariatePolynomial("22x22y2z+31x33yz33");
		assertEquals(67, poly.findDegree());		
	}
	
	//Find degree when polynomial is not valid
	@Test(expected = AssertionError.class)
	public void invalidPolynomialTest() {
		MultivariatePolynomial poly = new MultivariatePolynomial("22x%22y2z+31x33yz33");
	}
}
