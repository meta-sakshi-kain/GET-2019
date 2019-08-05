package question_2;
//Employee class with its properties
public class Employee {
	
	private String name;
	private int age;
	private int salary;
	//constructor
	public Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	//get name of employee
	public String getName() {
		return name;
	}
	//get the age of employee
	public int getAge() {
		return age;
	}
	//get the salary of employee
	public int getSalary() {
		return salary;
	}
	
}
