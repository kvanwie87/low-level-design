package casestudy.inmemorysql.criteria;

import casestudy.inmemorysql.model.Row;

public class OrOperator implements Criteria {
	private Criteria left;
	private Criteria right;
	public OrOperator(Criteria left, Criteria right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public boolean evaluate(Row row) {
		return left.evaluate(row) || right.evaluate(row);
	}

}
