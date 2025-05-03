package patterns.behavioral.mediator;

public class HighTemperatureAlertEvent extends Event {
	public int tempF = 0;
	public HighTemperatureAlertEvent(String source, int tempF) {
		this.type = "HighTemperatureAlertEvent";
		this.source = source;
		this.tempF = tempF;
	}
}
