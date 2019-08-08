package question_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
//class to add employee
public class EmployeeCollection {
	
	//collection of employee made using a set
	 ArrayList<Employee> emp=new ArrayList<Employee>();
	Set<Integer> empID=new HashSet<Integer>();
	/**
	 * method adds employee to set
	 * @param empId of employee
	 * @param name of employee
	 * @param address of employee
	 */
	//method to add employee 
	public void addEmployee(int empId, String name, String address){
		
		Employee employee = new Employee(empId, name, address);
		//if id is unique add employee to set
		if(empID.add(empId)){
			emp.add(employee);
		}
	}
}
