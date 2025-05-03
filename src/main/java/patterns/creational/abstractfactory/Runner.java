package patterns.creational.abstractfactory;

public class Runner {
	public static void main(String[] args) {
		WidgetFactory factory = new SharpWidgetFactory();
		
		
		
		Box box = factory.createBox();
		Button button = factory.createButton();
		Border border = factory.createBorder();
	}

}
