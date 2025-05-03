package patterns.behavioral.visitor;

import java.awt.Point;

public class Circle implements Shape {
	private float centerX;
	private float centerY;
	private float radius;

	public Circle(float centerX, float centerY, float radius) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
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
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
