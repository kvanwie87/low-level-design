package patterns.structural.proxy;

public class Runner {
	public static void main(String[] args) {
		Display realDisplay = new RealDisplay();
		Display proxyDisplay = new ProxyDisplay(realDisplay);
		Display otherDisplayProxt = new OtherProxyType(proxyDisplay);
		Display proxyDisplayAnotherLayer = new ProxyDisplay(otherDisplayProxt);
		Display proxy4 = new ProxyDisplay(proxyDisplayAnotherLayer);
		doDisplay(proxy4);
		
		//DAO = Metrics(ExceptionHandling((TransactionHandling(DAO)))
	}
	public static void doDisplay(Display display) {
		display.display();
	}
}
