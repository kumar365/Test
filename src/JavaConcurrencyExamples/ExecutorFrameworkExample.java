package JavaConcurrencyExamples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Java Executor Framework, introduced in Java 5 under the
 * java.util.concurrent package, is a high-level API designed to simplify
 * multi-threaded programming by separating task submission from thread
 * execution. Instead of manually creating, starting, and destroying Thread
 * objects, you submit tasks to a thread pool controlled by the framework.
 * 
 * Executors.newFixedThreadPool(int n) - Applications needing a predictable or
 * bounded number of threads.
 * 
 * Executors.newCachedThreadPool() - Short-lived, highly asynchronous tasks;
 * creates new threads as needed and cleans up idle ones.
 * 
 * Executors.newSingleThreadExecutor() - Executing tasks sequentially in a
 * single background thread.
 * 
 * Executors.newScheduledThreadPool(int n) - Periodic task execution or delayed
 * background jobs.
 */
public class ExecutorFrameworkExample {
	public static void main(String[] args) {
		// 1. Initialize a fixed pool containing 2 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// 2. Define a Callable task that returns a value
		Callable<Integer> multiTask = () -> {
			Thread.sleep(1000); // Simulate network latency or computation
			return 42 * 2;
		};

		// 3. Submit the task to the framework
		Future<Integer> futureResult = executor.submit(multiTask);

		System.out.println("Task has been successfully submitted. Moving on...");

		try {
			// 4. Extract the value (This blocks until the thread finishes)
			Integer finalValue = futureResult.get();
			System.out.println("Result received from thread pool: " + finalValue);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			// 5. Always explicitly shut down the service to release system resources
			executor.shutdown();
		}
	}
}
