package patterns.behavioral.strategy;

public class FlightTravelStrategy implements TravelStrategy {

	@Override
	public void travel(String source, String destination) {
		System.out.println("Traveling from "+source+" to " +destination+ " via flight...");
	}

}
