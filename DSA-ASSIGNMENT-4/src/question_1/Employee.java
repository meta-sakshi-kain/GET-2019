package question_1;
//class for employee with its properties
public class Employee   {
	
	private int empId;
	private String name;
	private String address;
	//constructor
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	//method to get empID
	public int getEmpId() {
		return empId;
	}
	//method to get name of employee
	public String getName() {
		return name;
	}
	//getter and setter
	public String toString() {
        return String.format("%d\t%s\t%s",empId, name, address);
    }
	
}
