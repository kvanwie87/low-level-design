package patterns.structural.bridge;

public class Human extends Animal {
	public Human(Movement movement) {
		super(movement, "Human");
	}
	// move() { do some walking stuff }
}
