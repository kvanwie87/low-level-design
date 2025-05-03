package casestudy.inmemorysql.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Row {
	private Map<Column, String> values;
	public Row(Map<Column, String> values) {
		this.values = values;
	}
	public String get(Column col) {
		return values.get(col);
	}
	public String get(String columnName) {
		return null;
	}
	public Row select(List<Column> columns) {
		Map<Column, String> filteredValues = new HashMap<Column, String>();
		for(Column col : columns) {
			filteredValues.put(col, values.get(col));
		}
		return new Row(filteredValues);
	}
}
