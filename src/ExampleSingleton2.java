// Make a constructor private.
// Write a static method that has the return type object of this singleton class. 
// Here, the concept of Lazy initialization is used to write this static method.

//Java code to create singleton class Using Static block
public class ExampleSingleton2 {

	// private instance
	private static ExampleSingleton2 instance;

	// private constructor
	private ExampleSingleton2() {

	}

	static {
		// static block to initialize instance
		instance = new ExampleSingleton2();
	}

	// public static method to get instance
	public static ExampleSingleton2 getInstance() {
		return instance;
	}
}