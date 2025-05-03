package patterns.structural.facade;

public class Runner {
	// Facade Method Design Pattern provides a unified interface to a set of interfaces in a subsystem. 
	// Facade defines a high-level interface that makes the subsystem easier to use.
	
	public static void main(String[] args) {
		SubsystemComponent1 component1 = new SubsystemComponent1();
		SubsystemComponent2 component2 = new SubsystemComponent2();
		SubsystemComponent3 component3 = new SubsystemComponent3();
		FacadeOfSubsystem facadeOfSubsystem = new FacadeOfSubsystem(component1, component2, component3);
		
		performLargerTask(component1, component2, component3);
		performLargerTask(facadeOfSubsystem);
	}
	
	public static void performLargerTask(SubsystemComponent1 component1, SubsystemComponent2 component2, SubsystemComponent3 component3) {
		component1.subsystemTask();
		component2.subsystemTask();
		component3.subsystemTask();
	}
	
	public static void performLargerTask(FacadeOfSubsystem facade) {
		facade.performLargeSubsystemTask();
	}
}
