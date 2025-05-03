package casestudy.inmemorysql.criteria;

public class TableConstraintFactory {
	public static AndOperator and(Criteria left, Criteria right) {
		return new AndOperator(left, right);
	}
	public static OrOperator or(Criteria left, Criteria right) {
		return new OrOperator(left, right);
	}
	public static EqualityCriteria eq(String col, String value) {
		return new EqualityCriteria(col, value);
	} 
}
