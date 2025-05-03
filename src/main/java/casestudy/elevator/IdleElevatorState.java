package casestudy.elevator;

public class IdleElevatorState implements ElevatorState{
	private Elevator elevator;
	public IdleElevatorState(Elevator ele) {
		this.elevator = ele;
	}
	public void openDoor() {
		//TODO
	}

	public void closeDoor() {
		// TODO
	}

	public void stop() {
		//NOOP
	}

	public void select(Floor floor) {
		// TODO
		// Transition state
		elevator.setState(new MovingElevatorState(elevator));
	}

}
