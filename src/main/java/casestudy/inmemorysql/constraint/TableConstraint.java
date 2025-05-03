package casestudy.inmemorysql.constraint;

import casestudy.inmemorysql.model.Row;

public interface TableConstraint {
	public boolean applyOnRead(Row candidate);
	public boolean applyOnInsert(Row candidate);
	public boolean applyOnUpdate(Row candidate);
	public boolean applyOnDelete(Row candidate);
}
