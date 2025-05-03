package casestudy.inmemorysql.criteria;

import casestudy.inmemorysql.model.Row;

public interface Criteria {
	public boolean evaluate(Row row);
}
