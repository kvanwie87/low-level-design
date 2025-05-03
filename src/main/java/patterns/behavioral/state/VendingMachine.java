package patterns.behavioral.state;

public class VendingMachine {
	private VendingMachineState state;
	public VendingMachine() {
		state = new ReadyState();
	}
	public void setState(VendingMachineState state) {
		this.state = state;
	}
	public void currentState() {
		state.annouce();
	}
	public void supplyPayment() {
		System.out.println("Machine received payment input...");
		state.receivePayment();
	}
	
	public void makeSelection( ) {
		System.out.println("Machine received selection input...");
		state.receiveSelection();
	}
	
	
}
