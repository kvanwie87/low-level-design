package patterns.creational.singleton;

public class MySingleton {
	private MySingleton() {
		
	}
	private int count = 0;
	private static MySingleton INSTANCE;
	
	public int getCount() {
		return count;
	}
	
	public void increment() {
		count++;
	}
	
	// Could synchronize it or some other form of locking to make thread safe
	public static MySingleton getInstance() {
		if(INSTANCE == null)
			INSTANCE = MySingletonFactory.create();
		return INSTANCE;
	}
	
	static class MySingletonFactory {
		public static MySingleton create() {
			return new MySingleton();
		}
	}
}

