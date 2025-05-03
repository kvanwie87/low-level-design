package patterns.structural.composite;

public class IntegerAdditionOperator extends OperatorExpression<Integer>{

	public IntegerAdditionOperator(Expression<Integer> left, Expression<Integer> right) {
		super(left, right);
	}

	@Override
	public Integer evaluate() {
		return left.evaluate() + right.evaluate();
	}

}
