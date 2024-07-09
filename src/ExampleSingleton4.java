
//Java program to create Thread Safe Singleton class using synchronized method
public class ExampleSingleton4 {

	// private instance, so that it can be accessed by only by getInstance() method
	private static ExampleSingleton4 instance;

	// private constructor
	private ExampleSingleton4() {

	}

	// synchronized method to control simultaneous access
	synchronized public static ExampleSingleton4 getInstance() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new ExampleSingleton4();
		}
		return instance;
	}
}
