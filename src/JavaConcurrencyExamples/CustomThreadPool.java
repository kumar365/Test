package JavaConcurrencyExamples;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
	private final BlockingQueue<Runnable> taskQueue;
	private final WorkerThread[] workers;
	private volatile boolean isShutdown = false;

	public CustomThreadPool(int numThreads) {
		taskQueue = new LinkedBlockingQueue<>();
		workers = new WorkerThread[numThreads];

		for (int i = 0; i < numThreads; i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}

	public void execute(Runnable task) {
		if (this.isShutdown)
			throw new IllegalStateException("ThreadPool has been terminated.");
		taskQueue.offer(task);
	}

	public void shutdown() {
		this.isShutdown = true;
		for (WorkerThread worker : workers) {
			worker.interrupt(); // Break out of blocked queue states safely
		}
	}

	private class WorkerThread extends Thread {
		@Override
		public void run() {
			while (!isShutdown || !taskQueue.isEmpty()) {
				try {
					Runnable task = taskQueue.take(); // Thread blocks until task appears
					task.run();
				} catch (InterruptedException e) {
					// Context cleanup on shutdown signal
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	// --- TEST MAIN METHOD ---
	public static void main(String[] args) {
		System.out.println("[Main] Initialising CustomThreadPool with 3 worker threads...");
		CustomThreadPool pool = new CustomThreadPool(3);

		// Submit 10 dummy tasks to the pool
		for (int i = 1; i <= 10; i++) {
			final int taskId = i;
			pool.execute(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("[Task " + taskId + "] started by " + threadName);
				try {
					// Simulate task workload
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("[Task " + taskId + "] was interrupted during execution.");
				}
				System.out.println("[Task " + taskId + "] completed by " + threadName);
			});
		}

		// Allow tasks to run for a few seconds before shutting down
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("\n[Main] Initiating thread pool shutdown...");
		pool.shutdown();
		System.out.println("[Main] Shutdown command sent.");

		// Verify rejected execution post-shutdown
		try {
			System.out.println("[Main] Attempting to submit a task post-shutdown...");
			pool.execute(() -> System.out.println("This should not run."));
		} catch (IllegalStateException e) {
			System.out.println("[Main] Success! Caught expected exception: " + e.getMessage());
		}
	}
}
