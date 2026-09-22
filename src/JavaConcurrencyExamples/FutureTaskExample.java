package JavaConcurrencyExamples;

import java.util.concurrent.*;

/**
 * Future: In Java concurrency, the Future interface represents the result of an
 * asynchronous operation. It is commonly used with ExecutorService to manage
 * and retrieve the outcome of tasks that run in a separate thread. We read
 * above that ExecutorService returns a Future object on submitting a Callable
 * task. This object acts like a placeholder for the result, allowing the main
 * thread to continue executing other code while the task executes in the
 * background. Future interface provides methods to check the task’s status,
 * retrieve the result, and handle exceptions that occur during execution. After
 * completion of the task, the result can be retrieved using the get() method.
 */
public class FutureTaskExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Callable<String> task = () -> {
			Thread.sleep(2000);
			return "Task Completed";
		};
		Future<String> future = executorService.submit(task);
		try {
			// Result from the task
			future.get();
			future.get(2, TimeUnit.SECONDS);
		} catch (ExecutionException | InterruptedException | TimeoutException e) {
			throw new RuntimeException(e);
		} finally {
			executorService.shutdown();
		}
	}
}