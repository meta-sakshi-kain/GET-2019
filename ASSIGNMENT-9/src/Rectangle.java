import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {
	
	Point originPoint;
	int breadth;
	int length;
	Timestamp timestamp;
    //constructor
	public Rectangle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.breadth = parameters.get(0);
		this.length = parameters.get(1);
		this.timestamp = timestamp;
	}

	//get the area of rectangle
	@Override
	public double getArea() {
		return (breadth * length);
	}
    
	//get the perimeter of rectangle
	@Override
	public double getPerimeter() {
		return (2 * breadth * length);
	}
     
	//get the origin point of rectangle
	@Override
	public Point getOrigin() {
		return originPoint;
	}
	
	//get the parameter list of rectangle
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(breadth);
		parameters.add(length);
		return parameters;
	}
	
	//get the timestamp at which rectangle is created
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	//get shapetype
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Rectangle;
	}

	//check if a point is enclosed in rectangle
	@Override
	public boolean isPointEnclosed(Point point) {
		double xPodouble=point.getXCoordinate();
		double yPodouble=point.getYCoordinate();
		double xOrigin = originPoint.getXCoordinate();
		double yOrigin = originPoint.getYCoordinate();
		if(xPodouble >= xOrigin && xPodouble <= (xOrigin + breadth) && yPodouble >= yOrigin && yPodouble <= (yOrigin + length))
			return true;
		return false;
	}
}