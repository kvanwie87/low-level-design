package casestudy.elevator;

import java.beans.DesignMode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Runner {
	public static void main(String[] args) {
		Floor ground = new Floor("GROUND", 0);
		Floor _1 = new Floor("1", 1);
		Floor _2 = new Floor("2", 2);
		Floor _3 = new Floor("3", 3);
		Floor _4 = new Floor("4", 4);
		Floor _5 = new Floor("5", 5);
		Floor _6 = new Floor("6", 6);
		Floor _7 = new Floor("7", 7);
		Floor _8 = new Floor("8", 8);
		Floor _9 = new Floor("9", 9);
		
		ground.prev = null;
		ground.next = _1;
		_1.prev = ground;
		_1.next = _2;
		_2.prev = _1;
		_2.next = _3;
		_3.prev = _2;
		_3.next = _4;
		_4.prev = _3;
		_4.next = _5;
		_5.prev = _4;
		_5.next = _6;
		_6.prev = _5;
		_6.next = _7;
		_7.prev = _6;
		_7.next = _8;
		_8.prev = _7;
		_8.next = _9;
		_9.prev = _8;
		_9.next = null;

		Elevator ele = new Elevator(_3);
		ele.printState();
		ele.next();
		ele.printState();
		ele.select(_5);
		ele.printState();
		ele.next();
		ele.printState();
		ele.next();
		ele.next();
		//ele.select(_1);
		ele.next();
		ele.next();
		ele.printState();
		//By default, the priority queue in Java is min Priority queue with natural ordering. 
		//To make it max, we have to use a custom comparator so that head of the queue returns the greatest element in the queue.
//		Comparator<Floor> floorComparator = (fl1, fl2) -> {return fl2.number - fl1.number;};
//		System.out.println(floorComparator.compare(_9, _7));
//		PriorityQueue<Floor> upQueue = new PriorityQueue<Floor>(floorComparator);
//		upQueue.add(_4);
//		System.out.println("PEEK:" + upQueue.peek().number);
//		upQueue.add(_9);
//		System.out.println("PEEK:" + upQueue.peek().number);
//		upQueue.add(_2);
//		System.out.println("PEEK:" + upQueue.peek().number);
	}

	
	
}
