package patterns.creational.singleton;

public class SingletonExample {
	public static void main(String[] args) throws InterruptedException {
		doSomething();
		doSomething();
	}
	public static void doSomething() {
		MySingleton.getInstance().increment();
		System.out.println(MySingleton.getInstance().getCount());
		MySingleton.getInstance().increment();
		System.out.println(MySingleton.getInstance().getCount());
	}
}
