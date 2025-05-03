package patterns.structural.proxy.example;

public class RealDAO implements DAO {

	@Override
	public String getThing() {
		// Retrieve info
		System.out.println("Retrieval data in DAO");
		return "HELLO";
	}

}
