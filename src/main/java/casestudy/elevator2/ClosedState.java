package casestudy.elevator2;

public class ClosedState extends ElevatorState {

	public ClosedState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void moveToFloor(int floor) {
		// TODO
	}

	@Override
	public void openDoor() {
		elevator.setState(new OpenedState(elevator));
	}
}
