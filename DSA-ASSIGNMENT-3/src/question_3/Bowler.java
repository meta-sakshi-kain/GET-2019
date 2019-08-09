package question_3;
//class for setting properties for each bowler
public class Bowler {
	
	private String name;
	private int noOfballs;
	
	//constructor
	public Bowler(String name, int noOfballs) {
		this.name = name;
		this.noOfballs = noOfballs;
	}

	//get the name of bowler
	public String getName() {
		return name;
	}

	//set the name of bowler
	public void setName(String name) {
		this.name = name;
	}

	//set the ball for each bowler
	public void setNoOfballs(int noOfballs) {
		this.noOfballs = noOfballs;
	}

	//get the balls for bowler
	public int getNoOfballs() {
		return noOfballs;
	}
	
}
