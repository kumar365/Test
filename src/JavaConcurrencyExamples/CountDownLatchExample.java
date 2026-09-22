package JavaConcurrencyExamples;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch is a powerful synchronization tool in concurrent programming
 * that enables one or more threads to pause execution until a specified number
 * of events, carried out by other threads, are completed. It keeps track of a
 * countdown and releases the waiting threads as soon as the count becomes zero.
 */
public class CountDownLatchExample {
	public static void main(String[] args) {
		int totalThreads = 3;
		CountDownLatch latch = new CountDownLatch(totalThreads);
		for (int i = 0; i < totalThreads; i++) {
			new Thread(new Worker(latch)).start();
		}
		try {
			latch.await();
			System.out.println("All threads have finished their tasks");
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted : " + e.getMessage());
		}
	}

	static class Worker implements Runnable {
		private final CountDownLatch latch;

		public Worker(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " has finished its task.");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				latch.countDown();
			}
		}
	}
}