package JavaConcurrencyExamples;

import java.util.concurrent.CompletableFuture;
/** 
 *  CompletableFuture, introduced in Java 8, implements the Future and CompletionStage interfaces.
 *  It provides a flexible non-blocking composition API for asynchronous programming.
 *  Key Methods of CompletableFuture:
 *  ---------------------------------
 *  supplyAsync(Supplier<U> supplier): Runs a task asynchronously that produces a result, typically used for background computations.
 *  runAsync(Runnable runnable): Executes a task asynchronously without returning any result, useful for operations that perform actions rather than calculations.
 *  completedFuture(T value): Creates a CompletableFuture that is already terminated with a given result.
 *  thenApply(): Used to apply a function to the result of the future once it’s available, transforming the output.
 *  thenAccept(): It takes the result of the future once it’s available, but doesn’t return any value.
 *  thenCompose(): Allows chaining of tasks where the upcoming task is dependent on the outcome of the preceding one and returns another CompletableFuture.
 *  thenCombine(): Combines two independent CompletableFuture tasks and merges their results.
 *  allOf(): Waits for multiple CompletableFuture instances to complete before proceeding.
 *  complete(): This lets you manually set a value to complete a future task, even if the actual task hasn’t been finished.
 *  
 *  CompletableFuture also Provides Methods for Error Handling, Such as:
 *  ----------------------------------------------------------------------
 *  exceptionally(): Catches any exceptions during the asynchronous operation and allows you to return an alternate result as a fallback.
 *  handle(): Processes both the successful result and any exception that may have occurred, giving you full control to handle both outcomes in one place.
 *  whenComplete(): Runs a specific action after the task finishes, regardless of whether it completed successfully or encountered an error.
 */
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Integer> supplyFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Executing async task");
			return 1;
		});
		CompletableFuture<Integer> transformedFuture = supplyFuture.thenApply(result -> {
			System.out.println("Transformed result: " + result);
			return result;
		});
		transformedFuture.thenAccept(result -> {
			System.out.println("Final result after transformation: " + result);
		});
		CompletableFuture<Integer> exceptionalFuture = CompletableFuture.supplyAsync(() -> {
			if (Math.random() > 0.5) {
				throw new RuntimeException("Something went wrong!");
			}
			return 5;
		}).exceptionally(ex -> {
			System.out.println("Handled exception: " + ex.getMessage());
			return -1;
		});
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
		CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1, future2);
		allFuture.thenRun(() -> {
			System.out.println("Both futures are completed");
		});

		supplyFuture.get();
		transformedFuture.get();
		exceptionalFuture.get();
		allFuture.get();
	}
}