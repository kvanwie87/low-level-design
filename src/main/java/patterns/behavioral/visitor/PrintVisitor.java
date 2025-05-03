package patterns.behavioral.visitor;

public class PrintVisitor implements Visitor {
	@Override
	public void visit(Circle circle) {
		System.out.println("Printing circle at " + circle.getCenterX() + ", " + circle.getCenterY() + " with radius " + circle.getRadius());
	}

	@Override
	public void visit(Rectangle rectangle) {
		System.out.println("Printing rectangle at " + rectangle.getCenterX() + ", " + rectangle.getCenterY() + " with heigth " + rectangle.getHeight() + " with length " + rectangle.getLength());
		
	}

}
