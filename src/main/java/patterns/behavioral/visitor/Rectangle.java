package patterns.behavioral.visitor;

public class Rectangle implements Shape{
	private float length;
	private float height;
	private float centerX;
	private float centerY;
	public Rectangle(float length, float height, float centerX, float centerY) {
		this.length = length;
		this.height = height;
		this.centerX = centerX;
		this.centerY = centerY;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getCenterX() {
		return centerX;
	}
	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}
	public float getCenterY() {
		return centerY;
	}
	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
