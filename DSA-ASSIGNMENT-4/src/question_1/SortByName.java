package question_1;

import java.util.Comparator;
public class SortByName implements Comparator<Employee> {
	//overriding compare method
	@Override
	public int compare(Employee e1, Employee e2) {
		//compare name of employee e1 and e2 
		return e1.getName().compareToIgnoreCase(e2.getName());
	}
}
