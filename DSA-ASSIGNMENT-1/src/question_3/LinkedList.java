package question_3;
public class LinkedList{
	// Head Pointer
	Node head;
	static class Node {
		int data;
		Node next;

		/*
		 * Constructor to equate node value
		 * @param d -- data in Integer
		 */
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
