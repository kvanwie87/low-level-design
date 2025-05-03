package patterns.creational.abstractfactory;

public abstract class WidgetFactory {
	public abstract Box createBox();
	public abstract Border createBorder();
	public abstract Button createButton();
}
