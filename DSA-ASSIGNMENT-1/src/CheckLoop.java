public class CheckLoop {
/**
 * @param list to be checked
 * @return true if loop exist else false
 */
public static boolean detectLoop(LinkedList list) { 
	if(list.head!=null){
	//first node
	Node first = list.head;
	//second node
	Node second = list.head; 
	//traversing the whole list
	while (first != null && second != null && second.next != null) { 
		//taking one step for first node
		first = first.next; 
		//taking two steps for first node
		second = second.next.next; 
		//condition for loop
		if (first == second) { 
			System.out.println("Found loop"); 
			return true; 
		} 
	}
	//if loop not found
	return false; 
} 
else 
	throw new AssertionError();
}
}
