package patterns.behavioral.command;

public class SetVolumeCommand implements Command {
	private TV tv;
	private int target;
	private int prev;
	public SetVolumeCommand(TV tv, int target) {
		this.tv = tv;
		this.target = target;
		this.prev = tv.getVolume();
	}
	@Override
	public void execute() {
		tv.setVolume(target);
	}

	@Override
	public void undo() {
		tv.setVolume(prev);
	}

	@Override
	public void describe() {
		System.out.println("Set TV volume to " + target);
	}

}
