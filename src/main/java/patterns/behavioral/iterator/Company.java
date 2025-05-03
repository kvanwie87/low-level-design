package patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<Employee> employees = new ArrayList<>();
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	public Iterator<Employee> getEmployees() {
		return new EmployeeIterator(employees);
	}
	//public Set<Employee> getEmployees() {
	//	return employees;
	//}

}
