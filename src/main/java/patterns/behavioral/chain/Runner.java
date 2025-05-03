package patterns.behavioral.chain;

public class Runner {
	public static void main(String[] args) {
		Level1Support L1 = new Level1Support();
		Level2Support L2 = new Level2Support();
		Level3Support L3 = new Level3Support();
		L1.setNextHandler(L2);
		L2.setNextHandler(L3);
		System.out.println("REQUEST1:");
		doRequest("small", L1);
		System.out.println("REQUEST2:");
		doRequest("mediummedium", L1);
		System.out.println("REQUEST3:");
		doRequest("largelargelargelargelarge", L1);
	}
	public static void doRequest(String request, RequestHandler handler) {
		handler.handleRequest(request);
	}
}
