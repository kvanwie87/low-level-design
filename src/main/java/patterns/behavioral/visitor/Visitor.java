package patterns.behavioral.visitor;

public interface Visitor {
	public void visit(Circle circle);
	public void visit(Rectangle rectangle);
}
