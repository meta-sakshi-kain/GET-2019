import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
//class that implements triangle methods
public class Triangle implements Shape{
	
	Point originPoint;
	int side1;
	int side2;
	int side3;
	Timestamp timestamp;
	
	//Triangle constructor
	public Triangle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.side1 = parameters.get(0);
		this.side2 = parameters.get(1);
		this.side3 = parameters.get(2);	
		this.timestamp = timestamp;
	}
	
	//Method to calculate area of triangle
	@Override
	public double getArea() {
		double s = getPerimeter()/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));			
	}
     
	//Method to calculate perimeter of triangle 
	@Override
	public double getPerimeter() {
		return  (side1 + side2 + side3);
	}

	//Method to return the origin point of triangle
	@Override
	public Point getOrigin() {
		return originPoint;
	}

	//Method to get list of parameters of the triangle
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(side1);
		parameters.add(side2);
		parameters.add(side3);
		return parameters;
	}
	
	//method to get the time at which triangle is created
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	//method to get the shapetype
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	//method  to check that the point is enclosed in triangle or not
	@Override
	public boolean isPointEnclosed(Point point) {
		return false;
	}	
}
