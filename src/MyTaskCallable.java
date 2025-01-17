import java.util.concurrent.Callable;

//MyTaskCallable implements FunctionalInterface Callable
class MyTaskCallable implements Callable<String> {

	// Member variable of this class
	private String message;

	// Constructor of this class
	public MyTaskCallable(String message) {
		// This keyword refers to current instance itself
		this.message = message;
	}

	// Override Method of this Class
	@Override
	public String call() throws Exception {
		return "Hi " + message + "!";
	}
}