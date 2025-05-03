package patterns.behavioral.state;

public interface VendingMachineState {
	public void annouce();

	public void receivePayment();

	public void receiveSelection();
	
	public void transition();
}
