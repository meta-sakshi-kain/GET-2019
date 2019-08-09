package question_3;

public class Cricket {

	// bowlers in match
	Bowler[] bowlers;
	int noOfbowlers, totalBalls;
	MaxHeap heap;

	public Cricket(int noOfbowlers, int totalBalls, int[] quotaOfBowler) {
		this.noOfbowlers = noOfbowlers;
		this.totalBalls = totalBalls;
		bowlers = new Bowler[noOfbowlers];
		String bowlerName = "bowler";
		int sumOfBalls = 0;
		for (int i = 0; i < noOfbowlers; i++) {
			bowlers[i] = new Bowler(bowlerName + (i + 1), quotaOfBowler[i]);
			// sum of balls of all bowlers
			sumOfBalls += quotaOfBowler[i];
		}
		// check total balls for virat kohli is valid or not
		if (sumOfBalls >= totalBalls) {
			// create a max heap of bawlers
			heap = new MaxHeap(noOfbowlers);
			for (int i = 0; i < noOfbowlers; i++)
				// insert bowler in heap
				heap.insert(bowlers[i]);
		} else
			throw new AssertionError("invalid input");
	}

	/**
	 * @return order of bowler for which virat kohli scores minimum run
	 */
	public String[] strategyOfBowling() {
		// create an array for order of bowler
		String[] orderOfBowler = new String[totalBalls];
		for (int i = 0; i < totalBalls; i++) {
			// get bowler which has max balls
			Bowler bowler = heap.extractMax();
			orderOfBowler[i] = bowler.getName();
			// decrease one ball of that bowler
			bowler.setNoOfballs((bowler.getNoOfballs() - 1));
			// again insert bowler in heap
			heap.insert(bowler);
		}
		return orderOfBowler;
	}
}
