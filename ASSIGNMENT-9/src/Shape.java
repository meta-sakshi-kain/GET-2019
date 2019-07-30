import java.sql.Timestamp;
import java.util.List;

//interface to implement the given functions in different shapes
public interface Shape {
	
	public double getArea();//get area of shape
	
	public double getPerimeter();//get perimeter of shape
	
	public Point getOrigin();//get origin points of shape
	
	public List<Integer> getParameters();//get parameters list of shape
	
	public Timestamp getTimestamp();//get the timestamp of the shape created
	
	public ShapeType getShapeType();//get the shapetype
	
	public boolean isPointEnclosed(Point point);//check if point is enclosed in shape
}