package question_1;
//class for binary tree implementation
public class Node{
	private DataEntry entry;
	private Node lChild, rChild;
	//constructor
	public Node(DataEntry dataEntry){
		this.entry = dataEntry;
		this.lChild = null;
		this.rChild = null;
	}	
	//set the entry in dictionary
	public void setEntry(DataEntry entry) {
		this.entry = entry;
	}
	//set the left child
	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}
	//set the right child
	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}
	//get the entry from dictionary
    public DataEntry getEntry() {
		return entry;
	}
    //get left child
    public Node getlChild() {
		return lChild;
	}
    //get right child
    public Node getrChild() {
		return rChild;
	}

}

