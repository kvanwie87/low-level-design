package patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Circle circle1 = new Circle(0,0,10);
		Rectangle rectangle1 = new Rectangle(0, 0, 5, 10);
		
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(circle1);
		shapes.add(rectangle1);
		
		ShapeDrawer drawer = new ShapeDrawer();
		for(Shape shape : shapes) {
			shape.accept(drawer);
		}
		
	}
	
	public static void printShapes(List<Shape> shapes) {
		PrintVisitor visitor = new PrintVisitor();
		for(Shape shape : shapes) {
			shape.accept(visitor);
		}
	}
}
