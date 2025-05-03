package casestudy.elevator;

public interface ElevatorState {
	public void openDoor();
	public void closeDoor();
	public void stop();
	public void select(Floor floor);
}
