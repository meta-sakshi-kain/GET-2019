import static org.junit.Assert.*;
import org.junit.Test;
//class to test the rotateList and detect loop function
public class LinkedListTest {
   //object of linked list class
	LinkedList list = new LinkedList();

	//test case when list is rotated when conditions are satisfied
	@Test
	public void rotateSublistWithSatisfiedCondition() {
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		list.printList(LinkedList.rotate(list, 2, 5, 2)); 
	}

	//test case when conditions for rotation not met
	@Test(expected = AssertionError.class)
	public void rotateSublistWithoutSatisfiedCondition(){
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		LinkedList.rotate(list, 5,2,3);
	}

	//test case to check if a loop exists in linked list
	@Test
	public void checkLoopTestWhenLoopIsPresent() {
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		assertFalse(CheckLoop.detectLoop(list));
		list.head.next.next.next= list.head.next;
		assertTrue(CheckLoop.detectLoop(list));
	}
	//test case when list is empty
	@Test(expected = AssertionError.class)
	public void checkLoopTestWhenLoopNotPresent() {
		CheckLoop.detectLoop(list);
	}
}
