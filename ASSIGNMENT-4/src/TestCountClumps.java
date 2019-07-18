import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCountClumps {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
				{ new int[]{1, 2, 2, 3, 4, 4},2 }, { new int[]{1, 1, 2, 1, 1},2 }, {new int[]{1, 1, 1, 1, 1},1 }, { new int[] {1},0}});
	}

	private int[] fInput;
	private int fExpected;

	public TestCountClumps(int[] input, int expected)
	{
		this.fInput = input;
		this.fExpected = expected;
	}

	@Test
	public void testCorrectResults() {
		assertEquals(fExpected, ArrOperation.countClumps(fInput));
	}

	@AfterClass
	public static void testArrayIsEmpty(){
		try {
			ArrOperation.countClumps(new int[]{});
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
}