package question_3;
public class NestedLinkedList {
	NestedList head;

	public static class NestedList {
		String poly;
		// Main List
		NestedList next_main;
		// Sub List
		LinkedList.Node next_sub;

		public NestedList() {
			next_main = null;
			next_sub = null;
		}
	}
}
