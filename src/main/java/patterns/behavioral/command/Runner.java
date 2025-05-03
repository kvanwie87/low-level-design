package patterns.behavioral.command;

public class Runner {
	public static void main(String[] args) {
		TV tv = new TV();
//		List<Commands> commands;
//		OnCommand onCommand = new OnCommand(tv);
//		onCommand.execute();
//		onCommand.undo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Controller controller = new Controller(tv);
		tv.describe();
		controller.turnOn();
		tv.describe();
		controller.setVolume(25);
		tv.describe();
		controller.setVolume(50);
		tv.describe();
		controller.increaseVolume();
		tv.describe(); // 51
		controller.undo();
		tv.describe(); // 50
		controller.undo();
		tv.describe(); // 25
		controller.undo();
		tv.describe(); // 0
		controller.redo();
		tv.describe(); // 25
	}
}
