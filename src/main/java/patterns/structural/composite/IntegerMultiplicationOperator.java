package patterns.structural.composite;

public class IntegerMultiplicationOperator  extends OperatorExpression<Integer>{

	public IntegerMultiplicationOperator(Expression<Integer> left, Expression<Integer> right) {
		super(left, right);
	}

	@Override
	public Integer evaluate() {
		return left.evaluate() * right.evaluate();
	}

}
