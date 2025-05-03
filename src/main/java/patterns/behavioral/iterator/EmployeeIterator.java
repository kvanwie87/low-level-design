package patterns.behavioral.iterator;

import java.util.List;

public class EmployeeIterator implements Iterator<Employee> {
	private List<Employee> employees;
	private int curIdx = 0;
	
	public EmployeeIterator(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public boolean hasNext() {
		return curIdx < employees.size();
	}

	@Override
	public Employee next() {
		return employees.get(curIdx++);
	}

}
