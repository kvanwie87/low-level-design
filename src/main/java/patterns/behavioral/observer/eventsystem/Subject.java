package patterns.behavioral.observer.eventsystem;

public interface Subject<T extends Event> {
	public void addListener(T listener);
	public void removeListener(T listner);
	public void broadcast(T event);
}
