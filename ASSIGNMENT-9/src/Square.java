import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
//method to implement square methods 
public class Square implements Shape {
	
	Point originPoint;
	int side;
	Timestamp timestamp;
	//constructor
	public Square(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.side = parameters.get(0);
		this.timestamp = timestamp;
	}
	
	//get the area of square
	@Override
	public double getArea() {
		return (side * side);
	}
	
	//get the perimeter of square
	@Override
	public double getPerimeter() {
		return (4 * side);
	}
	
	//get the origin point of square
	@Override
	public Point getOrigin() {
		return originPoint;
	}
	
	//get the list of parameters
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(side);
		return parameters;
	}
	
	//get the timestamp of square created
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	//get the shape type
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
	
	//check if point is enclosed in circle or not
	@Override
	public boolean isPointEnclosed(Point point) {
		double xPoint=point.getXCoordinate();
		double yPoint=point.getYCoordinate();
		double xOrigin = originPoint.getXCoordinate();
		double yOrigin = originPoint.getYCoordinate();
		if(xPoint >= xOrigin && xPoint <= (xOrigin + side) && yPoint >= yOrigin && yPoint <= (yOrigin + side))
			return true;
		return false;
	}
}
