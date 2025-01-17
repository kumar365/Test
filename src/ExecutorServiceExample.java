import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();

		ExecutorService executorService2 = Executors.newFixedThreadPool(10);

		ExecutorService executorService3 = Executors.newScheduledThreadPool(10);


		executorService1.execute(new Runnable() {
			public void run() {
				System.out.println("executorService1 Asynchronous task");
			}
		}); 
		executorService2.execute(new Runnable() {
			public void run() {
				System.out.println("executorService2 Asynchronous task");
			}
		});
		executorService3.execute(new Runnable() {
			public void run() {
				System.out.println("executorService3 Asynchronous task");
			}
		});

		executorService1.shutdown();
		executorService2.shutdown();
		executorService3.shutdown();
	}
}
