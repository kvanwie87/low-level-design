package casestudy.inmemorysql.statement;

import java.util.ArrayList;
import java.util.List;

import casestudy.inmemorysql.criteria.Criteria;
import casestudy.inmemorysql.model.Column;
import casestudy.inmemorysql.model.Database;
import casestudy.inmemorysql.model.Row;
import casestudy.inmemorysql.model.Table;

public class SelectStatement {
	private Database database;
	private List<String> columnNames;
	private String tableName;
	private Criteria criteria;
	
	public SelectStatement() {
		
	}
	
	public List<Row> execute() {
		Table table = database.getTable(tableName);
		List<Column> columns = table.getColumns(columnNames);
		List<Row> rows = table.getRows();// All rows
		List<Row> resultsUnfiltered = new ArrayList<Row>(); // All rows that match criteria
		for(Row row : rows) {
			if(criteria.evaluate(row)) {
				resultsUnfiltered.add(row);
			}
		}
		List<Row> resultsFiltered = new ArrayList<Row>(); // All rows that match criteria and have only the wanted columns
		for(Row row : resultsUnfiltered) {
			resultsFiltered.add(row.select(columns));
		}
		return resultsFiltered;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	
}
