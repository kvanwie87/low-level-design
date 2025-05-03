package casestudy.inmemorysql.statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import casestudy.inmemorysql.criteria.Criteria;
import casestudy.inmemorysql.model.Database;

public class SelectStatementBuilder {
	private Database database;
	private List<String> columnNames;
	private String tableName;
	private Criteria criteria;
	
	public static SelectStatementBuilder selectBuilder(Database database) {
		return new SelectStatementBuilder(database);
	}
	
	public SelectStatementBuilder(Database database) {
		this.database = database;
	}
	
	public SelectStatementBuilder select(String... columnNames) {
		this.columnNames = Arrays.asList(columnNames);
		return this;
	}
	public SelectStatementBuilder from(String tableName) {
		this.tableName = tableName;
		return this;
	}
	public SelectStatementBuilder where(Criteria criteria) {
		this.criteria = criteria;
		return this;
	}
	
	public SelectStatement build() {
		SelectStatement statement = new SelectStatement();
		statement.setDatabase(database);
		statement.setColumnNames(columnNames);
		statement.setCriteria(criteria);
		statement.setTableName(tableName);
		return statement;
	}
	
}
