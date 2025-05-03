package casestudy.inmemorysql.model;

import java.util.ArrayList;
import java.util.List;

import casestudy.inmemorysql.constraint.TableConstraint;


public class Table {
	private String name;
	private List<Column> columns = new ArrayList<Column>();
	private List<Row> rows = new ArrayList<Row>();
	private List<TableConstraint> constraints = new ArrayList<TableConstraint>();

	public Table() {
		
	}

	public void addColumn(Column col) {
		//TODO
	}
	public void addRow(Row row) {
		// Data validation - maybe happens with insert statement?
		// constraint satisfaction
		for(TableConstraint con : constraints) {
			if(!con.applyOnInsert(row)) {
				return;
			}
		}
		// add row to list
		rows.add(row);
	}
	public void addConstraint(TableConstraint con) {}
	public void removeColumn(Column col) {}
	public void removeRow(Row row) {}
	public void removeConstraint(TableConstraint con) {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public List<Column> getColumns(List<String> columnNames) {
		return columns; //TODO
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	public List<TableConstraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(List<TableConstraint> constraints) {
		this.constraints = constraints;
	}

	public Row findRow(Column col, String value) { // Can likely be replaced by Criteria input object
		for(Row row : rows) {
			if(value.equals(row.get(col))) {
				return row;
			}
		}
		return null;
	}
}
