package patterns.structural.bridge;

public class Swim implements Movement {

	@Override
	public void move() {
		System.out.println(" is swimming");
	}

}
