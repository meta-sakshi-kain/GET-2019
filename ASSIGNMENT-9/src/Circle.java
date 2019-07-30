import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
//class that implements shape methods for circle
public class Circle implements Shape {
	
	Point originPoint;
	int radius;
	final double pi=3.14;
	Timestamp timestamp;
	//constructor
	public Circle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.radius = parameters.get(0);
		this.timestamp = timestamp;
	}
	
	//get the area of circle
	@Override
	public double getArea() {
		return (pi * radius * radius);
	}
	
	//get the perimeter of circle
	@Override
	public double getPerimeter() {
		return (2 * pi * radius);
	}
	
	//get the origin point of circle
	@Override
	public Point getOrigin() {
		return originPoint;
	}
     
	//get the parameters for circle
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(radius);
		return parameters;
	}
    
	//get timestamp when circle is created 
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	//get the shapetype
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Circle;
	}
	
	//check if a point is enclosed in circle
	@Override
	public boolean isPointEnclosed(Point point) {
		double xPoint=point.getXCoordinate();
		double yPoint=point.getYCoordinate();
		double distance = Math.sqrt((Math.pow(originPoint.getXCoordinate(),2)) + (Math.pow(originPoint.getYCoordinate(),2)));
		double factor = distance + radius;
		double xCenter = (factor * originPoint.getXCoordinate())/distance;
		double yCenter = (factor * originPoint.getYCoordinate())/distance;
		if(xPoint >= (xCenter - radius) && xPoint <= (xCenter + radius))
			if(yPoint >= (yCenter - radius) && yPoint <= (yCenter + radius))
				return true;
		return false;
		
	}
}