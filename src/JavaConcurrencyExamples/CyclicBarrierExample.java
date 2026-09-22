package JavaConcurrencyExamples;
import java.util.concurrent.CyclicBarrier;

/**
 * The CyclicBarrier class helps a group of threads reach a common barrier point
 * by making them wait for each other. Once all threads have reached the
 * barrier, they are all released to continue execution. Unlike CountDownLatch,
 * it can be reused. It’s primarily used for coordinating threads working in
 * parallel on different tasks and synchronizing at certain checkpoints.
 */
public class CyclicBarrierExample {
	public static void main(String[] args) {
		int totalThreads = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThreads, () -> {
			System.out.println("All threads reached the barrier. Starting the next phase ");
		});
		for (int i = 0; i < totalThreads; i++) {
			new Thread(new Worker(cyclicBarrier)).start();
		}
	}

	static class Worker implements Runnable {
		private final CyclicBarrier cyclicBarrier;

		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " has completed the task");
				cyclicBarrier.await();
			} catch (Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
			}
		}
	}
}