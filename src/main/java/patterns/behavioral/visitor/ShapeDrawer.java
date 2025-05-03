package patterns.behavioral.visitor;

public class ShapeDrawer implements Visitor {
	@Override
	public void visit(Circle circle) {
		System.out.println("Drawing a circle");
	}

	@Override
	public void visit(Rectangle rectangle) {
		System.out.println("Drawing a rectangle");
	}
}
