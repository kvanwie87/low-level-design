package casestudy.elevator2;

public abstract class ElevatorState {
	protected Elevator elevator;
	public ElevatorState(Elevator elevator) {
		this.elevator = elevator;
	}
	public void moveToFloor(int floor) {
		//NOOP
	};
	public void openDoor() {
		//NOOP
	}
	public void closeDoor() {
		//NOOP
	}
	public boolean isOpen() {
		return false;
	};
}
