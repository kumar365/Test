
// Java code to create singleton class by  Eager Initialization
public class ExampleSingleton1 {

	// private instance initialized when loading the class
	private static final ExampleSingleton1 instance = new ExampleSingleton1();

	// private constructor
	private ExampleSingleton1() {

	}

	// public static method to get instance
	public static ExampleSingleton1 getInstance() {
		return instance;
	}
}