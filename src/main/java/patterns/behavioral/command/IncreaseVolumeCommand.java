package patterns.behavioral.command;

public class IncreaseVolumeCommand implements Command {
	private TV tv;
	public IncreaseVolumeCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.increaseVolume();
	}

	@Override
	public void undo() {
		tv.decreaseVolume();
	}

	@Override
	public void describe() {
		System.out.println("Increase TV volume");
	}

}
