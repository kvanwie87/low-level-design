package patterns.behavioral.mediator;

public class WeatherStation {
	int tempF = 90;
	private EventMediator eventMediator;
	public final String id;
	public WeatherStation(EventMediator eventMediator, String id) {
		this.eventMediator = eventMediator;
		this.id = id;
	}
	
	public void setTemperature(int f) {
		tempF = f;
		if(tempF > 100) {
			eventMediator.notify(new HighTemperatureAlertEvent(id, tempF));
		} else if(tempF < 32) {
			eventMediator.notify(new FreezeAlertEvent(id, tempF));
		}
		
	}
}
