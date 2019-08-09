package question_3;
//class to create a node of employee
public class Node {

	public Employee employee;
	public Node next;

	public Node(Employee employee) {
		this.employee = employee;
		this.next = null;
	}
}
