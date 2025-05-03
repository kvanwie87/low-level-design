package patterns.behavioral.chain;

public class Level3Support implements RequestHandler {
	@Override
	public void handleRequest(String request) {
		System.out.println("Request handled by L3 Support");
	}

	@Override
	public void setNextHandler(RequestHandler requestHandler) {
		// Noop
	}
}
