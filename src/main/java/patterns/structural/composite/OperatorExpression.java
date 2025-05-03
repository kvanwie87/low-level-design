package patterns.structural.composite;

public abstract class OperatorExpression<T> implements Expression<T>{
	protected Expression<T> right;
	protected Expression<T> left;
	public OperatorExpression(Expression<T> left, Expression<T> right) {
		this.right = right;
		this.left = left;
	}
	public abstract T evaluate();

}
