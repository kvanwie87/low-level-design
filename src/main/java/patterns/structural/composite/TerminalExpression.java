package patterns.structural.composite;

public abstract class TerminalExpression<T> implements Expression<T>{
	private T value;
	public TerminalExpression(T value) {
		this.value = value;
	}
	public T evaluate() {
		return value;
	}

}
