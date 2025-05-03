package patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		ThingFactory thingFactory = new ThingFactory();
		//System.out.println("Before....");
		//printMemoryStats();
		
		List<Thing> things = new ArrayList<Thing>();
		for(int i = 0; i < 50000; i++) {
			things.add(thingFactory.createThingViaFlyweight("1", "2", "3"));
		}
		//System.out.println("After....");
		//printMemoryStats();
	}
	
	public static void printMemoryStats() {
		System.out.println("Free Memory \t Total Memory \t Max Memory");
	    System.out.println(Runtime.getRuntime().freeMemory() + 
	      " \t " + Runtime.getRuntime().totalMemory() + 
	      " \t " + Runtime.getRuntime().maxMemory());
	    System.out.println("Used: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
	}
}
