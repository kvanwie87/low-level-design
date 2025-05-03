package patterns.behavioral.state;

public class Runner {
	public static void main(String[] args) {
		// Ready, PaymentAuthorization, Selection, PaymentProcessing, Dispensing
		VendingMachine vendingMachine = new VendingMachine();
		
		vendingMachine.supplyPayment();
		vendingMachine.makeSelection();
	}
}
