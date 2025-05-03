package patterns.structural.facade;

public class FacadeOfSubsystem {
	private SubsystemComponent1 comp1;
	private SubsystemComponent2 comp2;
	private SubsystemComponent3 comp3;
	
	public FacadeOfSubsystem(SubsystemComponent1 comp1, SubsystemComponent2 comp2, SubsystemComponent3 comp3) {
		this.comp1 = comp1;
		this.comp2 = comp2;
		this.comp3 = comp3;
	}

	public void performLargeSubsystemTask() {
		comp1.subsystemTask();
		comp2.subsystemTask();
		comp3.subsystemTask();
	}
}
