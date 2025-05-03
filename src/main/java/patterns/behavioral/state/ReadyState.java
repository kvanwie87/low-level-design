package patterns.behavioral.state;

public class ReadyState implements VendingMachineState {
	public ReadyState() {
		annouce();
	}
	@Override
	public void annouce() {
		System.out.println("In Ready State...");
	}
	@Override
	public void receivePayment() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void receiveSelection() {
		System.out.println("Please provide payment first...");
	}
	@Override
	public void transition() {
		//logic to determine next state
		// Authorized
		// Ready
		// Out of stock
		// vendingMachine.setState(new AuthorizedState())
		// return new AuthorizedState();
	}

}
