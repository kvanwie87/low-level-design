package patterns.structural.proxy;

public class ProxyDisplay implements Display {
	private Display proxiedDisplay;
	public ProxyDisplay(Display display) {
		this.proxiedDisplay = display;
	}
	@Override
	public void display() {
		System.out.println("Proxy action performed...");
		this.proxiedDisplay.display();
	}
	

}
