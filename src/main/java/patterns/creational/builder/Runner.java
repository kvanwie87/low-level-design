package patterns.creational.builder;

public class Runner {
	public static void main(String[] args) {
		CarBuilder carBuilder = new CarBuilder();
		Car car = carBuilder
				.withColor("red")
				.withSoundSystem("")
				.build();
	}
}
class Car {
	public String color;
	public String sound;
	public Car() {
		//bunch of default values
	}
	public Car(String color) {
		//default all but color
	}
}
class CarBuilder {
	private String color = "green";
	private String soundSystemType = "5.1 Surround Sound";
	public CarBuilder withColor(String color) {
		this.color = color;
		return this;
	}
	public CarBuilder withSoundSystem(String type) {
		//Set sound system stuff here to hold for the build method
		return this;
	}
	public Car build() {
		//Assemble car based on held values
		Car car = new Car();
		car.color = this.color;
		car.sound = this.soundSystemType;
		return car;
	}
}
