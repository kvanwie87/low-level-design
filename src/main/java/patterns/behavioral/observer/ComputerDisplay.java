package patterns.behavioral.observer;

public class ComputerDisplay implements Observer {

	@Override
	public void update(String message) {
		System.out.println("Computer:"+message);
	}

}
