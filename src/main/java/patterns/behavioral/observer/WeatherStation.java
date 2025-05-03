package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private String weather;
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void setWeather(String weather) {
		this.weather = weather;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for(Observer ob : observers) {
			ob.update(weather);
		}
	}

}
