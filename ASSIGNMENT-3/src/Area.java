import java.util.Scanner;
// class to calculate area of various shapes
public class Area{
	private static Scanner sc;
	public static void main(String args[]){
		boolean quit=false;
		System.out.println("Get the area of:");
int choice=0;
do{
	System.out.println("1.Triangle.");
	System.out.println("2.Rectangle.");
	System.out.println("3.Square.");
	System.out.println("4.Circle.");
	System.out.println("5.Exit.");
	sc = new Scanner(System.in);
	try {
		choice=sc.nextInt();
	} catch (Exception e) {
		System.out.println("Enter a valid choice");
	}
	switch(choice)
	{
	case 1:
		System.out.println("Enter width and height of triangle");
		double triangleWidth=sc.nextDouble();
		double triangleHeight=sc.nextDouble();
		System.out.println(areaOfTriangle(triangleWidth,triangleHeight));
		break;
	case 2:
		System.out.println("Enter width and height of rectangle");
		double rectangleWidth=sc.nextDouble();
		double rectangleHeight=sc.nextDouble();
		System.out.println(areaOfRectangle(rectangleWidth,rectangleHeight));
		break;
	case 3:
		System.out.println("Enter side of square");
		double side=sc.nextDouble();
		System.out.println(areaOfSquare(side));
		break;
	case 4:
		System.out.println("Enter radius of the circle");
			double radius=sc.nextDouble();
			System.out.println(areaOfCircle(radius));
			break;
		case 5:
			quit=true;
			break;
		}
	}while(quit);
}
/**
 * @param width is width of Triangle
 * @param height is height of Triangle
 * @return area of triangle
 */
private static double areaOfTriangle(double width, double height) {

	double constt=0.50d;
	double area=constt*width*height;
	return area;
}
/**
 * @param width is width of Rectangle
 * @param height is width of Rectangle
 * @return area of Rectangle
 */
private static double areaOfRectangle(double width, double height) {
	double area=width*height;
	return area;
}
/**
 * @param side is length of side of a square
 * @return area of square
 */
private static double areaOfSquare(double side) {
	double area=side;
	return area;
}
/**
 * @param radius is radius of circle
 * @return area of circle
 */
	private static double areaOfCircle(double radius) {
		double pi=3.14d;
		double area=pi*(radius*radius);
		return area;
	}

}



