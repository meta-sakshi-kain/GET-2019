package question_3;
//class to store students details
public class Student {

	private String name;//name of student
	private String[] preference = new String[5];//five preferences given by student
	
	//set name of a student
	public void setName(String name) {
		this.name = name;
	}
	
    //setting preferences 
	public void setPreference(String[] preference) {
		this.preference = preference;
	}
    
	//get the name of student
	public String getName() {
		return name;
	}
	
	//get preferences of student
	public String[] getPreference() {
		return preference;
	}	
}
