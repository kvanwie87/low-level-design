package patterns.behavioral.chain;

public class Level1Support implements RequestHandler {
	private RequestHandler nextRequestHandler;
	@Override
	public void handleRequest(String request) {
		if(request != null && request.length() < 10)
			System.out.println("Request handled by L1 Support");
		else {
			System.out.println("L1 can't handle escalating Request...");
			nextRequestHandler.handleRequest(request);
		}
			
	}

	@Override
	public void setNextHandler(RequestHandler requestHandler) {
		this.nextRequestHandler = requestHandler;
	}

}
