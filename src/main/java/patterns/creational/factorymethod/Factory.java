package patterns.creational.factorymethod;

public class Factory {
	public static Shape createShape(String type) {
		if(type.equals("Circle")) {
			return new Circle();
		}
		return null;
	}
	public static Circle createCircle() {
		return new Circle();
	}
}
