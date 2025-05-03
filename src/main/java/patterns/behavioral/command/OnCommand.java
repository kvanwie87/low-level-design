package patterns.behavioral.command;

public class OnCommand implements Command {
	private TV tv;
	public OnCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOn();
	}

	@Override
	public void undo() {
		tv.turnOff();
	}

	@Override
	public void describe() {
		System.out.println("Turn TV on");
	}

}
