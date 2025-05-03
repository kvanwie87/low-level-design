package casestudy.inmemorysql;

import casestudy.inmemorysql.criteria.AndOperator;
import casestudy.inmemorysql.criteria.Criteria;
import casestudy.inmemorysql.criteria.EqualityCriteria;
import casestudy.inmemorysql.criteria.OrOperator;
import casestudy.inmemorysql.model.Database;
import casestudy.inmemorysql.model.Row;
import casestudy.inmemorysql.statement.SelectStatement;
import casestudy.inmemorysql.statement.SelectStatementBuilder;

import static casestudy.inmemorysql.criteria.TableConstraintFactory.*;
import static casestudy.inmemorysql.statement.SelectStatementBuilder.*;
import java.util.Arrays;

public class Runner {
	public static void main(String[] args) {
		// select, insert, delete, update
		// create
		
		// Select
		// columns you are selecting (List<String>)
		// the table you are selecting from (String)
		// criteria for filtering out which rows are selected
			// 'columnName' = "someValue', (=, !=, OR, AND)
			// name = jyo AND age = 37
		
		//new And(Equality("columnName","expectedValue"),Equality("columnName","expectedValue"))
		//Query query = new Query("tableName", new List<String>() {""...}, List<Criteria>) {new And(new Equals("",""), new NotEquals("",""))}
		//ResultSet result = query.execute()
		//df2 = df.select(col("name"), col("age")).where()
		//		df2.list
		
		
		// BooleanOperator = T/F result
		// True AND (True OR False)
		
		// Criteria(List<Criteria> ) Composite pattern?
		
		// Database
		// Tables
		Database db = new Database();
		
		


		
		
		

		//eq("","")
		//( = AND = ) OR ( = AND = )
		///or1.evaluate(new Row());
		EqualityCriteria eq1 = new EqualityCriteria("","");
		EqualityCriteria eq2 = new EqualityCriteria("","");
		Criteria and1 = new AndOperator(eq1, eq2);
		Criteria and2 = new AndOperator(eq1, eq2);
		Criteria or1 = new OrOperator(and1, and2);
		
		
		or(
				and(eq("",""), eq("","")) , 
				and(eq("",""), eq("", ""))
		);
		
		SelectStatement mySelect = new SelectStatement();
		mySelect.setColumnNames(Arrays.asList("","","",""));
		mySelect.setDatabase(db);
		mySelect.setTableName("tableName");
		mySelect.setCriteria(or1);
		
		SelectStatement mySelect2 = selectBuilder(db)
				.select("age","name","dob")
				.from("tableName")
				.where(
						and(eq("age","5"),eq("name","fred")))
				.build();
	}
}
