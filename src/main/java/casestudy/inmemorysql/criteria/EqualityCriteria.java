package casestudy.inmemorysql.criteria;

import casestudy.inmemorysql.model.Row;

public class EqualityCriteria implements Criteria{
	private String columnName;
	private String value;
	public EqualityCriteria(String col, String value) {
		this.columnName = col;
		this.value = value;
	}
	@Override
	public boolean evaluate(Row row) {
		return value.equals(row.get(columnName));
	}

}
