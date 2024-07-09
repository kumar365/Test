
//Java code to explain double check locking
public class ExampleSingleton5 {

	// private instance, so that it can be accessed by only by getInstance() method
	private static ExampleSingleton5 instance;

	// private constructor
	private ExampleSingleton5() {

	}

	// public static method to get instance
	public static ExampleSingleton5 getInstance() {
		if (instance == null) {
			// synchronized block to remove overhead
			synchronized (ExampleSingleton5.class) {
				if (instance == null) {
					// if instance is null, initialize
					instance = new ExampleSingleton5();
				}

			}
		}
		return instance;
	}
}