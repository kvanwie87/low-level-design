package patterns.behavioral.observer;

public class Runner {
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObserver(new PhoneDisplay());
		weatherStation.addObserver(new PhoneDisplay());
		weatherStation.addObserver(new ComputerDisplay());
		weatherStation.setWeather("Raining");
	}
}
