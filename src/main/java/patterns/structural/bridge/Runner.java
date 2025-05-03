package patterns.structural.bridge;

public class Runner {
	public static void main(String[] args) {
		// Consider Animals and Movement and their permutations 
		// What would happen if you tried to handle it via inheritance (WalkingHuman, FlyingDuck, SwimmingDuck, etc)
		moveAnimal(new Human(new Walking()));
		//moveAnimal(new Human(new Walking()));
	}
	
	public static void moveAnimal(Animal animal) {
		animal.move();
	}
	
	
	
	// Animal - move
	// Cat, Dog, Fish, Human, Bird, Duck
	//RunningDuck, SwimmingDuck, WalkingDuck, RunningHuman, SwimmingHuman, WalkingHuman
	
	// Animal        Movement
}
