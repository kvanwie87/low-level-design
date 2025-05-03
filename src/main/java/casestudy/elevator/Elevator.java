package casestudy.elevator;

public class Elevator {
//	public int floorNum;
//	public boolean isDoorOpen;
//	public boolean isIdle;
//	public boolean isStopped;
	private Floor floor;
	public FloorDesignator designator;
	public ElevatorState state;
	
	public Elevator(Floor init) {
		floor = init;
		state = new IdleElevatorState(this);
		designator = new StandardFloorDesiginator(this);
	}
	
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	public void setState(ElevatorState state) {
		this.state = state;
	}
	
	public void openDoor() {
		state.openDoor();
	}
	
	public void closeDoor() {
		state.closeDoor();
	}
	
	public void stop() {
		state.stop();
	}
	
	public void select(Floor floor) {
		designator.select(floor);
		state.select(floor);
	}
	
	public void printState() {
		System.out.println(state);
		System.out.println("Curr:"+floor.label);
	}
	
	public void next() {
		designator.nextFloor();
	}
}
