package casestudy.elevator;

public class MovingElevatorState implements ElevatorState {
	private Elevator elevator;

	public MovingElevatorState(Elevator elevator) {
		this.elevator = elevator;
	}

	public void openDoor() {
		//NOOP
	}

	public void closeDoor() {
		//NOOP
	}

	public void stop() {
		//TODO but maybe takes admin?
		// Likely would transition to idle state?
	}

	public void select(Floor floor) {
		// TODO
		
	}

}
