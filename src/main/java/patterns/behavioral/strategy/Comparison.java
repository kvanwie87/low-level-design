package patterns.behavioral.strategy;

import java.util.Comparator;

public class Comparison {
	public static void main(String[] args) {
		
	}
	public <T> void doSomething(Comparator<T> comparator, T x, T y) {
		if(comparator.compare(x, y) > 1) {
			System.out.println("X is greater than Y");
		} else {
			
		}
	}
}
