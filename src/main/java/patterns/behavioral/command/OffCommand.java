package patterns.behavioral.command;

public class OffCommand implements Command {
	private TV tv;
	public OffCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOff();
	}

	@Override
	public void undo() {
		tv.turnOn();
	}

	@Override
	public void describe() {
		System.out.println("Turn TV off");
	}

}
