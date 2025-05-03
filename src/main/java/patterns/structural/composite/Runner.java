package patterns.structural.composite;

public class Runner {
	public static void main(String[] args) {
		IntegerTerminal integer5 = new IntegerTerminal(5);
		IntegerTerminal integer3 = new IntegerTerminal(3);
		IntegerTerminal integer1 = new IntegerTerminal(1);
		IntegerTerminal integer2 = new IntegerTerminal(2);
		IntegerAdditionOperator add1 = new IntegerAdditionOperator(integer3, integer5); // 3 + 5
		IntegerSubstractionOperator sub1 = new IntegerSubstractionOperator(integer2, integer1); // 2 - 1
		IntegerSubstractionOperator sub2 = new IntegerSubstractionOperator(add1, sub1); // (3+5) - (2-1)
		
	}
	
	public static void evaluate(Expression expression) {
		System.out.println(expression.evaluate());
	}
	
	public static void evaluate(String mathExpression) {
		// parse into math expression
	}
}
