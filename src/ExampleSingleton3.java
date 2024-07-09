
//Java Code to create singleton class With Lazy initialization
public class ExampleSingleton3 {

	// private instance, so that it can be accessed by only by getInstance() method
	private static ExampleSingleton3 instance;

	// private constructor
	private ExampleSingleton3() {

	}

	// public method to return instance of class
	public static ExampleSingleton3 getInstance() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new ExampleSingleton3();
		}
		return instance;
	}
}