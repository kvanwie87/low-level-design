package patterns.structural.proxy.example;

public class DaoTransactionHandler implements DAO {
	private DAO dao;
	public DaoTransactionHandler(DAO dao) {
		this.dao = dao;
	}
	
	public String getThing() {
		// Start a transaction
		System.out.println("Start Transaction");
		String result = dao.getThing();
		System.out.println("End Transaction");
		// End transaction
		return result;
	}

}
