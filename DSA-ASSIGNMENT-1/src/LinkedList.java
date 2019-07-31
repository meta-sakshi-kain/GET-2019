public class LinkedList {
Node head;
/**
 * @param list
 * @param data
 * @return Linked list with all the data inserted
 */
public LinkedList insert(LinkedList list, int data) {
	// object of type Node
	Node node = new Node(data);
	// if list is empty
	if (list.head == null)
		list.head = node;
	else {
		// finding last node
		Node last = list.head;
		while (last.next != null)
			last = last.next;
		// inserting node in the last
		last.next = node;
	}
	return list;
}

/**
 * @param list to be rotated
 * @param L starting index
 * @param R ending index
 * @param N number of rotation
 */
public static LinkedList rotate(LinkedList list, int L, int R, int N) {
	if(L < R){
		//if rotation gives same list
		if(N == (R-L+1) || N == 0){
			return list;
		}
		if(N < R-L+1 ){
			//get previous of starting node
			Node start = list.head;
			for (int i = 1; i < L-1; i++){
				start = start.next;
			}

			//get ending node
			Node end = list.head;
			for (int i = 1; i < R; i++){
				end = end.next;
			}

			//getting after of ending node
			Node temp = end.next;
			//changing next of ending node to starting node
			end.next = start.next;

			//getting new ending node
			Node temp2 = list.head;
			for (int i = 1; i < R-N; i++){
				temp2 = temp2.next;
			}

			//changing next of (previous of starting node)
			start.next = temp2.next;
			temp2.next = temp;
		}
		// if N > R-L+1
		else {
			//again call the method with updated N
			rotate(list, L, R, (N-(R-L+1)));
		}
		return list;
	}

	else {
		throw new AssertionError("L should be less than R");
	}
}

/**
 * @param list to be printed
 */
public void printList(LinkedList list) {
	Node currNode = list.head;
	// Traverse through the LinkedList
	while (currNode != null) {
		// Print the data at current node
		System.out.print(currNode.data + " ");
		// Go to next node
		currNode = currNode.next;
	}
}
}
