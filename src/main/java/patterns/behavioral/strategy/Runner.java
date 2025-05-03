package patterns.behavioral.strategy;

public class Runner {
	public static void main(String[] args) {
		TravelPlan plan = new TravelPlan();
		plan.addLeg("A", "B", new FlightTravelStrategy());
		plan.addDrive("B", "C");
		plan.addFlight("C", "D");
		plan.addBoatRide("D", "E");
		plan.performTrip();
	}
}
