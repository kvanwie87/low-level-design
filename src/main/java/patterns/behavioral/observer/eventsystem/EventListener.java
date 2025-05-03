package patterns.behavioral.observer.eventsystem;

public interface EventListener<T extends Event> {
	public void update(T event);
}
