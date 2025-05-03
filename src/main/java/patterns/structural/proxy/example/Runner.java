package patterns.structural.proxy.example;

public class Runner {
	public static void main(String[] args) {
		DAO dao = new RealDAO();
		DaoTransactionHandler dao2 = new DaoTransactionHandler(dao);
		DAO dao3 = new DaoMetrics(dao2);
		
		doStuff(dao2);
	}
	
	
	
	
	public static void doStuff(DAO dao) {
		dao.getThing();
	}
}
