package casestudy.elevator2;

public class Elevator {
	private ElevatorState state = new ClosedState(this);
	public void moveToFloor(int floor) {
		state.moveToFloor(floor);
	}
	public void openDoor() {
		state.openDoor();
	}
	public void closeDoor() {
		state.closeDoor();
	}
	public void setState(ElevatorState state) {
		this.state = state;
	}
	
	public boolean isOpen() {
		return state.isOpen();
	}
	
	
	
	
	
	
	
	
	
	
	private double movementSpeed = 0.25;
	private double doorSpeed = 0.5;
	public void printState() {
		
	}
	public void timeStep() {
		
	}
}
