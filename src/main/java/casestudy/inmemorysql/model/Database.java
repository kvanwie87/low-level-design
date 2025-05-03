package casestudy.inmemorysql.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	private Map<String, Table> tables;
	public Database() {
		tables = new HashMap<String, Table>();
	}
	public Table getTable(String name) {
		return tables.get(name);
	}
}
