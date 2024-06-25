import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

	public static void main(String[] args) {

		// Creating an object of custom class MyTask
		MyTaskCallable task = new MyTaskCallable("Sample task");
		// Creating object of ExecutorService class and Future object Class
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<String> result = executorService.submit(task);

		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error occured while executing the submitted task");
			e.printStackTrace();
		}
		// Cleaning resource and shutting down by using shutdown() method
		executorService.shutdown();
	}
}