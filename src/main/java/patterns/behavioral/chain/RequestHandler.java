package patterns.behavioral.chain;

public interface RequestHandler {
	public void handleRequest(String request);
	public void setNextHandler(RequestHandler requestHandler);
}
