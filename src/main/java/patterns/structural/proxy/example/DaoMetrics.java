package patterns.structural.proxy.example;

public class DaoMetrics implements DAO {
	private DAO dao;
	public DaoMetrics(DAO dao) {
		this.dao = dao;
	}
	@Override
	public String getThing() {
		// Start a timer
		System.out.println("Start Metrics");
		String result = dao.getThing();
		System.out.println("End Metrics");
		// End timer
		// Record result
		return result;
	}

}
