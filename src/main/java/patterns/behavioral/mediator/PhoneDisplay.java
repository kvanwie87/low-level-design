package patterns.behavioral.mediator;

public class PhoneDisplay {
	private final String id;
	private EventListener<FreezeAlertEvent> freezeEventListener = new EventListener<FreezeAlertEvent>() {
		@Override
		public void handleEvent(FreezeAlertEvent event) {
			displayAlert(id+":Freeze detected with temperature of " + event.tempF + " at source " + event.source);
		}
		
		@Override
		public String getEventType() {
			return "FreezeAlertEvent";
		}
	};
	private EventListener<HighTemperatureAlertEvent> highTempEventListener = new EventListener<HighTemperatureAlertEvent>() {
		@Override
		public void handleEvent(HighTemperatureAlertEvent event) {
			displayAlert(id+":High Temp detected with temperature of " + event.tempF + " at source " + event.source);
		}
		
		@Override
		public String getEventType() {
			return "HighTemperatureAlertEvent";
		}
	};
	
	public PhoneDisplay(String id, EventMediator eventMediator) {
		this.id = id;
		eventMediator.registerListener(freezeEventListener);
		eventMediator.registerListener(highTempEventListener);
	}
	
	public PhoneDisplay(String id, EventMediator eventMediator, String target) {
		this.id = id;
		eventMediator.registerListener(freezeEventListener, target);
		eventMediator.registerListener(highTempEventListener, target);
	}
	
	public void displayAlert(String msg) {
		System.out.println(msg);
	}
}
