package casestudy.logger;

public class ConsoleDisplayer implements Displayer {
	public void display(String message) {
		System.out.println(message);
	}
}
