package question_2;

import static org.junit.Assert.*;

import org.junit.Test;
//test class for employee class
public class EmployeeLinkedListTest {

	//test class to check the sorted list on the basis of salary
	@Test
	public void LinkedListSortingTest() {
		EmployeeLinkedList list = new EmployeeLinkedList();
	    list.insertEmployee(new Employee("Sakshi Kain",22 , 22000));
	    list.insertEmployee(new Employee("Diksha Kain", 24, 20000));
	    list.insertEmployee(new Employee("Raksha Kardam", 18, 55000));
	    InsertionSort sort = new InsertionSort();
	    String[] expected=new String[]{"Raksha Kardam","Sakshi Kain","Diksha Kain"};
	    list= sort.sort(list,list.size);
	    String[] result=list.result();
	    assertArrayEquals(expected,result);
	}
}
