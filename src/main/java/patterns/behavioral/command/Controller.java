package patterns.behavioral.command;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Controller {
	private Deque<Command> executedCommands = new LinkedList<Command>();
	private Stack<Command> undoneCommands = new Stack<Command>();
	private TV tv;
	
	public Controller(TV tv) {
		this.tv = tv;
	}
	public void undo() {
		if(executedCommands.isEmpty())
			return;
		Command command = executedCommands.pop();
		command.undo();
		undoneCommands.push(command);
	}
	public void redo() {
		if(undoneCommands.isEmpty())
			return;
		Command command = undoneCommands.pop();
		command.execute();
		executedCommands.push(command);
	}
	public void turnOn() {
		Command onCommand = new OnCommand(tv);
		onCommand.execute();
		executedCommands.push(onCommand);
	}
	public void turnOff() {
		Command offCommand = new OffCommand(tv);
		offCommand.execute();
		executedCommands.push(offCommand);
	}
	public void increaseVolume() {
		Command offCommand = new IncreaseVolumeCommand(tv);
		offCommand.execute();
		executedCommands.push(offCommand);
	}
	public void decreaseVolume() {
		Command offCommand = new DecreaseVolumeCommand(tv);
		offCommand.execute();
		executedCommands.push(offCommand);
	}
	public void setVolume(int volume) {
		Command offCommand = new SetVolumeCommand(tv, volume);
		offCommand.execute();
		executedCommands.push(offCommand);
	}
	public void increaseChannel() {

	}
	public void decreaseChannel() {

	}
	public void setChannel(int channel) {

	}
}
