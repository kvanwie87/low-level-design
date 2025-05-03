package patterns.structural.composite;

public class IntegerSubstractionOperator extends OperatorExpression<Integer>{

	public IntegerSubstractionOperator(Expression<Integer> left, Expression<Integer> right) {
		super(left, right);
	}

	@Override
	public Integer evaluate() {
		return left.evaluate() - right.evaluate();
	}

}
