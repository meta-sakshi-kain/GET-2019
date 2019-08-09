package question_1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//class to store parent and its child
public class Node {
	
	private Node parent;
	private String name;
	private Date date=new Date();
	//list of children
	List<Node> childList =new ArrayList<Node>();
	//get parent of child
	public Node getParent() {
		return parent;
	}
    //constructor
	public Node(Node parent, String name) {
		this.parent = parent;
		this.name = name;
	}
    //get name of node
	public String getName() {
		return name;
	}
    //get date of node creation
	public Date getDate() {
		return date;
	}
}
