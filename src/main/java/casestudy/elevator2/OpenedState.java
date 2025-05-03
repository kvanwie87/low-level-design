package casestudy.elevator2;

public class OpenedState extends ElevatorState {

	public OpenedState(Elevator elevator) {
		super(elevator);
	}
	@Override
	public boolean isOpen() {
		return true;
	}
	@Override
	public void closeDoor() {
		//TODO
		elevator.setState(new ClosedState(elevator));
	}
}
