package patterns.behavioral.visitor;

public interface Shape {
	public void accept(Visitor visitor);
}
