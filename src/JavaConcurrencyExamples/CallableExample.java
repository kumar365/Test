package JavaConcurrencyExamples;

import java.util.concurrent.Callable;

/**
 * The Callable interface differs from the Runnable interface in one aspect,
 * i.e., its call() method can return a result in the form of any object and can
 * throw both checked and unchecked exceptions. The call() method defines the
 * return type using generics. Callable is used in asynchronous programming to
 * fetch a result or handle any exceptions that may occur while executing the
 * program.
 */
public class CallableExample implements Callable {
	@Override
	public Object call() throws Exception {
		return String.valueOf(12);
	}
}