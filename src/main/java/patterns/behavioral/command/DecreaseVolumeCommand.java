package patterns.behavioral.command;

public class DecreaseVolumeCommand implements Command {
	private TV tv;
	public DecreaseVolumeCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.decreaseVolume();
	}

	@Override
	public void undo() {
		tv.increaseVolume();
	}

	@Override
	public void describe() {
		System.out.println("Decrease TV volume");
	}

}
