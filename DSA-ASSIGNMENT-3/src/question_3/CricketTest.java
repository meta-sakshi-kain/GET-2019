package question_3;

import org.junit.Test;

public class CricketTest {

	//test case when valid input given
	@Test
	public void orderOfBowlerTestWithValidInput() {
		Cricket match1 = new Cricket(4, 5, new int[]{4,6,5,2});
		String[] strategy1 = match1.strategyOfBowling();
		for(int i=0;i<5;i++){
			System.out.println(strategy1[i]);
		}
		System.out.println();
		Cricket match2 = new Cricket(5, 8, new int[]{4,9,5,2,5});
		String[] strategy2 = match2.strategyOfBowling();
		for(int i=0;i<8;i++){
			System.out.println(strategy2[i]);
		}
	}
}
