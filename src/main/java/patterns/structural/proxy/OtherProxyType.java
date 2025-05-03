package patterns.structural.proxy;

public class OtherProxyType implements Display {
	private Display proxiedDisplay;
	public OtherProxyType(Display display) {
		this.proxiedDisplay = display;
	}
	@Override
	public void display() {
		System.out.println("OtherProxy action performed...");
		this.proxiedDisplay.display();
	}
}
