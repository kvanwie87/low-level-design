package patterns.structural.bridge;

public abstract class Animal {
	private Movement movement;
	private String type;
	public Animal(Movement movement, String type) {
		this.movement = movement;
		this.type = type;
	}
	public void move() {
		System.out.print(type);
		movement.move();
	}
}
