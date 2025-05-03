package patterns.behavioral.mediator;

public interface EventListener<T extends Event> {
	public void handleEvent(T event);
	public String getEventType();
}
