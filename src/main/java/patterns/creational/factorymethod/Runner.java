package patterns.creational.factorymethod;

public class Runner {
	public static void main(String[] args) {
		ShapeFactory factory = new CircleFactory();
		Shape shape1 = factory.create();
		Shape shape2 = Factory.createShape("Circle");
	}
}
class Rectangle extends Shape {
	private int width;
	private int height;
	@Override
	public Shape clone() {
		// Copies over attributes of original and pass em into new object
		Rectangle copy = new Rectangle();
		copy.height = this.height;
		copy.width = this.width;
		return copy;
	}

}
class Circle extends Shape {

	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class Square extends Shape {

	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

interface ShapeFactory {
	public Shape create();
	public Shape clone(Shape shape);
}
class CircleFactory implements ShapeFactory {
	@Override
	public Circle create() {
		return new Circle();
	}

	@Override
	public Shape clone(Shape orig) {
		Circle copy = new Circle();
		//copy.radius = orig.radius;
		return copy;
	}	
}
class SquareFactory implements ShapeFactory {
	@Override
	public Square create() {
		return new Square();
	}

	@Override
	public Shape clone(Shape shape) {
		return null; // TODO
	}
}
