package casestudy.elevator;

import java.util.PriorityQueue;

public class StandardFloorDesiginator implements FloorDesignator {
	private PriorityQueue<Floor> upQueue;
	private PriorityQueue<Floor> downQueue;
	private Direction direction;
	private Elevator elevator;
	// floorPriorityQueue
	public StandardFloorDesiginator(Elevator elevator) {
		this.elevator = elevator;
		this.direction = Direction.IDLE;
		upQueue = new PriorityQueue<Floor>((fl1, fl2) -> {return fl1.number - fl2.number;});
		downQueue = new PriorityQueue<Floor>((fl1, fl2) -> {return fl2.number - fl1.number;});
	}
	public void select(Floor selection) {
		Floor current = elevator.getFloor();
		if(current.number > selection.number) {
			downQueue.add(selection);
			if(direction == Direction.IDLE) {
				direction = Direction.DOWN;
			}
		} else {
			upQueue.add(selection);
			if(direction == Direction.IDLE) {
				direction = Direction.UP;
			}
		}
	}

	public void nextFloor() {
		if(direction == Direction.IDLE) {
			return;
		}
		else if(direction == Direction.DOWN) {
			goDown();
		} else if(direction == Direction.UP) {
			goUp();
		}
	}

	private void goUp() {
		Floor target = upQueue.peek();
		Floor current = elevator.getFloor();
		Floor up = current.next;
		if(up == target) {
			upQueue.remove();
		}
		elevator.setFloor(up);
		
		if(upQueue.isEmpty()) {
			if(!downQueue.isEmpty()) {
				direction = Direction.DOWN;
			} else {
				direction = Direction.IDLE;
				elevator.setState(new IdleElevatorState(elevator));
			}
		}
	}
	private void goDown() {
		Floor target = downQueue.peek();
		Floor current = elevator.getFloor();
		Floor down = current.prev;
		if(down == target) {
			downQueue.remove();
		}
		elevator.setFloor(down);
		
		if(downQueue.isEmpty()) {
			if(!upQueue.isEmpty()) {
				direction = Direction.UP;
			} else {
				direction = Direction.IDLE;
				elevator.setState(new IdleElevatorState(elevator));
			}
		}
	}

	private enum Direction {
		UP, DOWN, IDLE
	}
}
