package patterns.behavioral.mediator;

public class Runner {
	public static void main(String[] args) {
		EventMediator eventMediator = new EventMediator();
		WeatherStation weatherStation1 = new WeatherStation(eventMediator, "WS1");
		WeatherStation weatherStation2 = new WeatherStation(eventMediator, "WS2");
		PhoneDisplay phoneDisplay1 = new PhoneDisplay("PD1",eventMediator);
		PhoneDisplay phoneDisplay2 = new PhoneDisplay("PD2",eventMediator);
		PhoneDisplay phoneDisplay3 = new PhoneDisplay("PD3",eventMediator, weatherStation1.id);
		weatherStation1.setTemperature(0);
		weatherStation2.setTemperature(105);
	}
}
