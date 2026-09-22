package JavaConcurrencyExamples;

import java.util.concurrent.Semaphore;

/**
 * Semaphore is a concurrency construct that restricts concurrent access to a
 * resource by multiple threads with the help of permits. Threads need to
 * acquire or release these permits to enter or exit a critical section of
 * concurrent programs. The permit count determines the number of threads
 * accessing the resource simultaneously.
 */
public class SemaphoreExample {

	private static final Semaphore semaphore = new Semaphore(3);

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Worker(i)).start();
		}
	}

	static class Worker implements Runnable {
		private final int id;

		public Worker(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				System.out.println("Worker " + id + " is waiting for a permit");
				semaphore.acquire();
				System.out.println("Worker " + id + " has acquired a permit");
				Thread.sleep(2000);
				System.out.println("Worker " + id + " has released a permit");
				semaphore.release();
			} catch (InterruptedException e) {
				System.out.println("Worker " + id + " was interrupted: " + e.getMessage());
			}
		}
	}
}
