
//Java code for Bill Pugh Singleton Implementation
public class ExampleSingleton6 {

	// private constructor
	private ExampleSingleton6() {

	}

	// Inner class to provide instance of class
	private static class BillPughSingleton {
		private static final ExampleSingleton6 INSTANCE = new ExampleSingleton6();
	}

	public static ExampleSingleton6 getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}
//When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class.
//Inner class is created only when getInstance() method is called.
//So it may seem like eager initialization but it is lazy initialization. 
//This is the most widely used approach as it doesn’t use synchronization.