package question_3;
//class for employee 
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
    //get the slary of employee
	public int getSalary() {
		return salary;
	}
    //set data to set data of an employee
	public void setData(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
    //getter and setter
	public String toString(){
		return String.format("%s\t%d\t%d", name, age, salary);
	}
}
