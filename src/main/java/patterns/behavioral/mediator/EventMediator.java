package patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventMediator {
	private Map<EventKey, List<EventListener>> listeners = new HashMap<EventKey, List<EventListener>>();
	
	public void notify(Event event) {
		List<EventListener> eventTypeListeners = listeners.get(new EventKey("any", event.type));
		if(eventTypeListeners != null)
			for(EventListener listener : eventTypeListeners) {
				listener.handleEvent(event);
			}
		List<EventListener> sourceAndEventTypeListeners = listeners.get(new EventKey(event.source, event.type));
		if(sourceAndEventTypeListeners != null)
			for(EventListener listener : sourceAndEventTypeListeners) {
				listener.handleEvent(event);
			}
	}
	
	public void registerListener(EventListener listener) {
		EventKey key = new EventKey("any", listener.getEventType());
		List<EventListener> specificEventListeners = listeners.get(key);
		if(specificEventListeners == null) {
			specificEventListeners = new ArrayList<EventListener>();
			listeners.put(key, specificEventListeners);
		}
		specificEventListeners.add(listener);
	}
	
	public void registerListener(EventListener listener, String source) {
		EventKey key = new EventKey(source, listener.getEventType());
		List<EventListener> specificEventListeners = listeners.get(key);
		if(specificEventListeners == null) {
			specificEventListeners = new ArrayList<EventListener>();
			listeners.put(key, specificEventListeners);
		}
		specificEventListeners.add(listener);
	}
	
	private class EventKey {
		public String source;
		public String eventType;
		public EventKey(String source, String eventType) {
			this.source = source;
			this.eventType = eventType;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
			result = prime * result + ((source == null) ? 0 : source.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EventKey other = (EventKey) obj;
			if (eventType == null) {
				if (other.eventType != null)
					return false;
			} else if (!eventType.equals(other.eventType))
				return false;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			return true;
		}	
	}

}
