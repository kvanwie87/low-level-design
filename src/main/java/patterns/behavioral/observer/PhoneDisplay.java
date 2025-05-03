package patterns.behavioral.observer;

public class PhoneDisplay implements Observer {

	@Override
	public void update(String message) {
		System.out.println("Phone: " + message);
	}

}
