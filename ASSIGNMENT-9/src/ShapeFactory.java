import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class ShapeFactory {
	
	    //Screen length 
		private static final int XMAX=100;
		//Screen height
		private static final int YMAX=100;
	//method to create a new shape
	public static Shape createShape(ShapeType shapeType, Point point, List<Integer> parameters){
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Shape shape = null;
		if(ShapeType.Rectangle.equals(shapeType)){			
			if(isValidRectangle(point, parameters))
				shape = new Rectangle(point, parameters, timestamp);//create object of rectangle 
			else
				throw new AssertionError("shape out of bound");
		}else if(ShapeType.Square.equals(shapeType)){
			if(isValidSquare(point, parameters))
				shape = new Square(point, parameters, timestamp); //create object of square 
			else
				throw new AssertionError("shape out of bound");
		}else if(ShapeType.Triangle.equals(shapeType)){
			if(isValidTriangle(point, parameters))
				shape = new Triangle(point, parameters, timestamp);//create object of triangle 
			else
				throw new AssertionError("shape out of bound");
		}else if(ShapeType.Circle.equals(shapeType)){
			if(isValidCircle(point, parameters))
				shape = new Circle(point, parameters, timestamp);//create object of circle
			else
				throw new AssertionError("shape out of bound");
		}	
		return shape;
	}
	
	//Check if a Rectangle to be made is valid or not
	public static boolean isValidRectangle(Point point, List<Integer> parameters){
		double x = point.getXCoordinate();
		double y = point.getYCoordinate();
		if(x >= 0 && y >= 0 && (x + parameters.get(0)) <= XMAX && (y + parameters.get(1)) <= YMAX)
			return true;
		return false;
	}
	
	//Check if a square to be made is valid or not
	public static boolean isValidSquare(Point point, List<Integer> parameters){
		double x = point.getXCoordinate();
		double y = point.getYCoordinate();
		if(x >= 0 && y >= 0 && (x + parameters.get(0)) <= XMAX && (y + parameters.get(0)) <= YMAX)
			return true;
		return false;
	}
	
	//Check if a circle to be made is valid or not
	public static boolean isValidCircle(Point point,List<Integer> parameters){
		int radius = parameters.get(0);
		double distance = Math.sqrt((Math.pow(point.getXCoordinate(),2)) + (Math.pow(point.getYCoordinate(),2)));
		double factor = distance + radius;
		//calculate center point of the triangle
		double xCenter = (factor * point.getXCoordinate())/distance;
		double yCenter = (factor * point.getYCoordinate())/distance;
		if((xCenter + radius) <= XMAX && (xCenter - radius) >= 0 && (yCenter + radius) <= YMAX && (yCenter - radius) >= 0)
			return true;
		return false;
	}
	
	//Check if a triangle to be made is valid or not
	public static boolean isValidTriangle(Point point, List<Integer> parameters){
		double x = point.getXCoordinate();
		double y = point.getYCoordinate();
		if(x >= 0 && y >= 0 && (x + parameters.get(0)) <= XMAX && (y + parameters.get(1)) <= YMAX)
		return true;
		return false;
		}
}