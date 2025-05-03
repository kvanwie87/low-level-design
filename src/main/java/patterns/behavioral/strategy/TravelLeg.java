package patterns.behavioral.strategy;

public class TravelLeg {
	private TravelStrategy strat;
	private String source;
	private String destination;
	
	public TravelLeg(String source, String destination, TravelStrategy strat) {
		this.strat = strat;
		this.source = source;
		this.destination = destination;
	}

	public void performLeg() {
		strat.travel(source, destination);
	}
}
