package question_3;

import question_3.LinkedList.Node;
import question_3.NestedLinkedList.NestedList;

public class MultivariantPolynomial {
	/**
	 * This Method counts the numbers appearing after a certain index in a string
	 * @param index Input index
	 * @param str Input String
	 * @return Count of Numbers
	 */
	public static int countAfter(int index, String str) {
		int count = 0;
		for (int i = index + 1; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				break;
			else if (str.charAt(i) >= '1' && str.charAt(i) <= '9')
				count++;
		}
		return count;
	}

	/**
	 * This method creates a linked List by separating operators and segregating the string into nodes
	 *  @param list List of Polynomial
	 * @param polynomial Polynomial String
	 * @return Segregated List
	 */
	public static NestedLinkedList createMainList(NestedLinkedList list,String polynomial) {
		String temp = "";
		for (int i = 0; i < polynomial.length(); i++) {
			// If the character is + and - , also the end of the string
			if (polynomial.charAt(i) == '+' || polynomial.charAt(i) == '-'|| i == polynomial.length() - 1) {
				// Make new node
				NestedList newNode = new NestedList();
				// Enter the string up till now
				newNode.poly = temp;
				// Enter the last character because the loop will stop
				if (i == polynomial.length() - 1)
					newNode.poly += polynomial.charAt(i);
				temp = "";
				// Add to the Linked List
				if (list.head == null)
					list.head = newNode;
				else {
					NestedList headNode = list.head;
					while (headNode.next_main != null) {
						headNode = headNode.next_main;
					}
					headNode.next_main = newNode;
				}
			}
			// Adding to the empty string till the operator arrives
			else {
				temp = temp + polynomial.charAt(i);
			}
		}

		return createSubList(list);
	}

	/**
	 * This method creates a Nested Linked List with degrees of all the variables
	 *  @param list List of Polynomial functions
	 * @return List with Nested List Attached
	 */
	public static NestedLinkedList createSubList(NestedLinkedList list) {
		NestedList headNode = list.head;
		int temp = 0, deg = 0;

		if (headNode == null)
			throw new AssertionError("List is Empty");
		while (headNode != null) {
			// Counting the constant term
			int index = countAfter(-1, headNode.poly);
			// Creating a Sub-NestedLinkedList of "Node" type
			LinkedList subList = new LinkedList();
			for (int i = index; i < headNode.poly.length();) {
				int sum = 0;
				// If the current character is an alphabet
				if (headNode.poly.charAt(i) >= 'a'&& headNode.poly.charAt(i) <= 'z') {
					// If 'i' has not reached last and the i+1 element is an
					// alphabet or it has reached last and i is an alphabet
					if (i != headNode.poly.length() - 1&& (headNode.poly.charAt(i + 1) >= 'a' && headNode.poly.charAt(i + 1) <= 'z')
							|| i == headNode.poly.length() - 1) {
						deg = 1;
						sum += deg;
						i++;
					} else {
						// Calculating the degree
						deg = countAfter(i, headNode.poly);

						temp = deg;
						int j = i + 1;
						while (deg > 0) {
							sum += (headNode.poly.charAt(j) - 48)* (Math.pow(10, deg - 1));
							j++;
							deg--;
						}
						i += ++temp;
					}
				}
				else
					throw new AssertionError("Invalid Polynomial");
				Node newNode = new Node(sum);

				// Creating the sublist
				if (subList.head == null)
					subList.head = newNode;
				else {
					Node tempNode = subList.head;
					while (tempNode.next != null) {
						tempNode = tempNode.next;
					}
					tempNode.next = newNode;
				}
				headNode.next_sub = subList.head;
			}
			headNode = headNode.next_main;
		}
		return list;
	}

	/**
	 * This method calculates the highest degree
	 * @param list (With Sublist)
	 * @return Highest Degree
	 */
	public static int highestDegree(NestedLinkedList list) {
		NestedList headNode = list.head;
		int max = 0;
		// Traversing main list
		while (headNode != null) {
			Node temp = headNode.next_sub;
			int sum = 0;
			// Traversing the SubList
			while (temp != null) {
				sum = sum + temp.data;
				temp = temp.next;
			}
			if (sum > max)
				max = sum;
			headNode = headNode.next_main;
		}
		return max;
	}
}
