import static org.junit.Assert.*;

import org.junit.Test;

public class TestHCFandLCM {

@Test
public void testHCF() {
	assertEquals(1,MathematicalOperations.hcf(2,5));
	assertEquals(5,MathematicalOperations.hcf(10,5));
	assertEquals(5,MathematicalOperations.hcf(5,55));
	assertEquals(45,MathematicalOperations.hcf(0,45));
}

@Test
public void testLCM(){
	assertEquals(10, MathematicalOperations.lcm(2, 5));
	assertEquals(0, MathematicalOperations.lcm(0, 5));
	assertEquals(0, MathematicalOperations.lcm(10, 0));

}

@Test
public void testZerohcf(){
	try {
		MathematicalOperations.hcf(0,0);
	} catch (AssertionError e) {
		System.out.println(e);
	}
}
	

}
