package patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
	private List<TravelLeg> legs;
	public TravelPlan() {
		legs = new ArrayList<TravelLeg>();
	}
	public void addLeg(String source, String destination, TravelStrategy travelStrategy) {
		legs.add(new TravelLeg(source, destination, travelStrategy));
	}
	public void addFlight(String source, String destination) {
		addLeg(source, destination, new FlightTravelStrategy());
	}
	public void addDrive(String source, String destination) {
		addLeg(source, destination, new CarTravelStrategy());
	}
	public void addBoatRide(String source, String destination) {
		addLeg(source, destination, new BoatTravelStrategy());
	}
	public void performTrip() {
		for(TravelLeg leg : legs) {
			leg.performLeg();
		}
	}
}
