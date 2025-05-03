package patterns.behavioral.observer.eventsystem;

public class WeatherStation {
	private Subject<WeatherAlertEvent> weatherAlertSubject= new Subject<WeatherAlertEvent>() {

		@Override
		public void addListener(WeatherAlertEvent listener) {

		}

		@Override
		public void removeListener(WeatherAlertEvent listner) {

		}

		@Override
		public void broadcast(WeatherAlertEvent event) {

		}
	};
	
	private Subject<WeatherEvent> weatherSubject= new Subject<WeatherEvent>() {
		
		@Override
		public void removeListener(WeatherEvent listner) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void broadcast(WeatherEvent event) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addListener(WeatherEvent listener) {
			// TODO Auto-generated method stub
			
		}
	};
}
