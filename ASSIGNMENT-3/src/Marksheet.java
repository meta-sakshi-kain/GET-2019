import java.util.Scanner;
//class to do operations on grades of students
public class Marksheet {
    private static Scanner sc;
	public static void main(String args[]){
		boolean quit=false;
		System.out.println("Enter number of students");
sc = new Scanner(System.in);
int noOfStudents=sc.nextInt();
float grades[]=new float[noOfStudents];
for(int i=0;i<noOfStudents;i++) {
	System.out.println("Enter grades for student "+ (i+1)+"=");
	grades[i]=sc.nextFloat();
}
System.out.println("Choose from the following options:");
int choice=0;
do{
	System.out.println("1.Calculate average of grades.");
	System.out.println("2.Get the maximum of all grades.");
	System.out.println("3.Get the minimum of all grades.");
	System.out.println("4.Calculate percentage of passed students.");
	System.out.println("5.Exit.");

	try {
		choice=sc.nextInt();
	} catch (Exception e) {
		System.out.println("Invalid choice");
	}
	switch(choice) 
	{
	case 1:
		float avgGrade=averageGrades(grades,noOfStudents);
		System.out.printf("Average of grades is %.2f\n", avgGrade);
		break;
	case 2:
		System.out.printf("Maximum grades is %.2f\n",getMaxGrades(grades,noOfStudents));
		break;
	case 3:
		System.out.printf("Minimum grades is %.2f\n",getMinGrades(grades,noOfStudents));
		break;
	case 4:
		System.out.printf("Percentage of passed students is %.2f\n",getPercentageOfPassed(grades,noOfStudents));
		break;
	case 5:
		quit=true;
		break;
	default:
		System.out.println("Enter a valid choice");
		}
	}while(!quit);
}

/**
 * @param grades is the array of students grades
 * @param noOfStudents is the total number of students
 * @return average grade from all grades
 */
private static float averageGrades(float[] grades, int noOfStudents) {
	float totalGrades=(float) 0.0;
	for(int i=0;i<noOfStudents;i++) {
		totalGrades+=grades[i];
	}
	float avgGrade=totalGrades/noOfStudents;
	return avgGrade;
}

/**
 * @param grades is the array of students grades
 * @param noOfStudents is the total number of students
 * @return the maximum of all grades
 */
private static float getMaxGrades(float[] grades, int noOfStudents) {
	float maxgrade=grades[0];
	for(int i=1;i<noOfStudents;i++) {
		if(grades[i]>maxgrade)
			maxgrade=grades[i];
	}
	return maxgrade;
}

/**
 * @param grades is the array of students grades
 * @param noOfStudents is the total number of students
 * @return minimum of all grades
 */
private static float getMinGrades(float[] grades, int noOfStudents) {
	float mingrade=grades[0];
	for(int i=1;i<noOfStudents;i++) {
		if(grades[i]<mingrade)
			mingrade=grades[i];
	}
	return mingrade;
}

/**
 * @param grades is the array of students grades
 * @param noOfStudents is the total number of students
 * @return percentage of passed students
 */
	private static float getPercentageOfPassed(float[] grades, int noOfStudents) {
		float percentage;
		int passedStudents=0;float passingGrade=40.00f;
		for(int j=0;j<noOfStudents;j++) {
			if(grades[j]>=passingGrade) {
				passedStudents++;
			}
		}	
		percentage=(float)(passedStudents*100)/noOfStudents;
		return percentage;
	}

}

