package casestudy.elevator2;

public class ElevatorControlPanel {
	private Elevator elevator;
	private MovementScheduler scheduler;
	public ElevatorControlPanel(Elevator elevator, MovementScheduler scheduler) {
		this.elevator = elevator;
		this.scheduler = scheduler;
	}
	public void openDoor() {
		System.out.println("OPEN DOOR PRESSED");
		elevator.openDoor();
	}
	public void closeDoor() {
		System.out.println("CLOSE DOOR PRESSED");
		elevator.closeDoor();
	}
	public void selectFloor(int floor) {
		System.out.println("SELECT FLOOR PRESSED FOR " + floor);
		scheduler.schedule(floor);
	}
	public void callFrom(int floor) {
		System.out.println("CALL ELEVATOR PRESSED FOR " + floor);
		scheduler.schedule(floor);
	}
}
