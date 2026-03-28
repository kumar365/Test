import java.util.concurrent.Executors;

// 1) Virtual Threads (JEP 444)/java 21 feature
//	   Virtual Threads are lightweight threads managed by the JVM, not tied to OS threads, 
// 		significantly improving scalability for high-concurrency applications.
public class Java21_VirtualThreadExample {
	public static void main(String[] args) throws InterruptedException {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			for (int i = 0; i < 5; i++) {
				final int taskId = i;
				executor.submit(() -> {
					System.out.println("Running task " + taskId + " in a virtual thread.");
					try {
						Thread.sleep(100); // Simulate some work
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				});
			}
		}
		Thread.sleep(500); // Allow time for tasks to complete
	}
}