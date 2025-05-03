package casestudy.inmemorysql.constraint;

import casestudy.inmemorysql.model.Column;
import casestudy.inmemorysql.model.Row;
import casestudy.inmemorysql.model.Table;

public class PrimaryKeyConstraint implements TableConstraint {
	private Column primaryKey;
	private Table table;
	public boolean applyOnInsert(Row candidate) {
		// what is the key column?
		// does the table have an entry for the key column already?
		String candidateValue = candidate.get(primaryKey);
		Row row = table.findRow(primaryKey, candidateValue);
		return row == null;
	}
	public boolean applyOnUpdate(Row candidate) {
		String candidateValue = candidate.get(primaryKey);
		Row row = table.findRow(primaryKey, candidateValue);
		return row == null;
	}
	@Override
	public boolean applyOnRead(Row candidate) {
		return true;
	}
	@Override
	public boolean applyOnDelete(Row candidate) {
		return true;
	}
}
