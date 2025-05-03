package patterns.behavioral.memento;

import java.util.Stack;

public class TextEditor {
	private TextWindow textWindow;
	private Stack<TextWindowState> checkpoints = new Stack<TextWindowState>();
	
	public TextEditor(TextWindow textWindow) {
		this.textWindow = textWindow;
	}
	
	public void write(String text) {
		textWindow.addText(text);
	}
	
	public void save() {
		checkpoints.push(textWindow.save());
	}
	
	public void undo() {
		if(checkpoints.isEmpty())
			return;
		textWindow.restore(checkpoints.pop());
	}
	
	public void print() {
		System.out.println(textWindow.getText());
	}
}
