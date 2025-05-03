package patterns.behavioral.memento;

public class Runner {
	public static void main(String[] args) {
		TextEditor editor = new TextEditor(new TextWindow());
		editor.write("Hello");
		editor.print();
		editor.save();
		editor.write(" World!");
		editor.write(" More Stuff!");
		editor.print();
		
		editor.undo();
		editor.print();
	}
}
