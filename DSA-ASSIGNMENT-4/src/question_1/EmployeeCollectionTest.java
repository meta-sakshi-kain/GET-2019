package question_1;
import static org.junit.Assert.*;
import java.util.Collections;
import org.junit.Test;

//test class to check results of operations on employee
public class EmployeeCollectionTest {

	//test case to sort by name
	@Test
	public void SortByNametest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10,"Vrinda", "ABC");
		collection.addEmployee(3,"VINI", "ds");
		collection.addEmployee(4,"Sakshi", "SD");
		collection.addEmployee(4,"sachin", "SDC");
		collection.addEmployee(5,"sachin", "SDSC");
		collection.addEmployee(2,"mini", "qwe");
		//sorting list 
		Collections.sort(collection.emp ,new SortByName());
		assertEquals("mini",collection.emp.get(0).getName());
	}
	//test case to sort by ID
	@Test
	public void SortByIdtest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10,"Vrinda", "ABC");
		collection.addEmployee(3,"aVrinda", "ds");
		collection.addEmployee(4,"Sakshi", "SD");
		collection.addEmployee(4,"sachin", "SDC");
		collection.addEmployee(5,"sachin", "SDSC");
		collection.addEmployee(2,"mini", "qwe");
		Collections.sort(collection.emp ,new  SortById());
		assertEquals(2,collection.emp.get(0).getEmpId());
	}
}

