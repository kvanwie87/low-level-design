package patterns.behavioral.iterator;

import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Company company = new Company();
		Iterator<Employee> itr = company.getEmployees();
		while(itr.hasNext()) {
			Employee curr = itr.next();
			// Do stuff
		}
		//List<Employee> list = company.getEmployees();
		//for(Employee emp : list) {
			// Do stuff
		//}
		
	}
}
