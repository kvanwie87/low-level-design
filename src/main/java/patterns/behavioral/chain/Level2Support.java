package patterns.behavioral.chain;

public class Level2Support implements RequestHandler {
	private RequestHandler nextRequestHandler;
	@Override
	public void handleRequest(String request) {
		if(request != null && request.length() < 20)
			System.out.println("Request handled by L2 Support");
		else {
			System.out.println("L2 can't handle escalating Request...");
			nextRequestHandler.handleRequest(request);
		}
			
	}

	@Override
	public void setNextHandler(RequestHandler requestHandler) {
		this.nextRequestHandler = requestHandler;
	}

}
