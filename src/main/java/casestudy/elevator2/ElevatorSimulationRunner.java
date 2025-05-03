package casestudy.elevator2;

import java.util.Scanner;

public class ElevatorSimulationRunner {
	static class Stepper extends Thread {
		private boolean shouldContinue = true;
		public void run() {
			long prev = System.currentTimeMillis();
			while(shouldContinue) {
				try {
					long curr = System.currentTimeMillis();
					long delta = curr - prev;
					prev = curr;
					Thread.sleep(3000);
					System.out.println("Timestepping elevator with delta: " + delta);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void stopThread() {
			shouldContinue = false;
		}
	}
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		MovementScheduler scheduler = new BasicMovementScheduler();
		ElevatorControlPanel controlPanel = new ElevatorControlPanel(elevator, scheduler);



		// Commands 
		// Open, Close, S1-9, C1-9, Exit
		Stepper elevatorTimestep = new Stepper();

		elevatorTimestep.start();
		Scanner scanner = new Scanner(System.in);
		boolean shouldContinue = true;
		while(shouldContinue) {
			System.out.print("ENTER NEXT COMMAND: ");
			String command = scanner.nextLine();
			if(command.equalsIgnoreCase("OPEN")) {
				controlPanel.openDoor();
			} else if(command.equalsIgnoreCase("CLOSE")) {
				controlPanel.closeDoor();
			} else if(command.matches("S(\\d)+")) {
				controlPanel.selectFloor(Integer.parseInt(command.substring(1)));
			} else if(command.matches("C(\\d)+")) {
				controlPanel.callFrom(Integer.parseInt(command.substring(1)));
			} else if(command.equalsIgnoreCase("EXIT")) {
				shouldContinue = false;
			} else {
				System.out.println("Unrecognized command");
			}
		}

		elevatorTimestep.stopThread();
	}
}
