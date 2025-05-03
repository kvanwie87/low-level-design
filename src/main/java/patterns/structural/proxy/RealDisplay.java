package patterns.structural.proxy;

public class RealDisplay implements Display {

	@Override
	public void display() {
		System.out.println("RealDisplay: Displaying");
	}

}
