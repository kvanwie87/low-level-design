package patterns.behavioral.mediator;

public class FreezeAlertEvent extends Event {
	public int tempF = 0;
	public FreezeAlertEvent(String source, int tempF) {
		this.type = "FreezeAlertEvent";
		this.source = source;
		this.tempF = tempF;
	}
}
