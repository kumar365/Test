package JavaConcurrencyExamples;

import java.util.concurrent.Phaser;

/**
 * Phaser is quite advanced synchronization mechanism than CyclicBarrier and
 * CountDownLatch. It is designed to handle scenarios where threads need to
 * coordinate and synchronize their execution across multiple phases or stages.
 * Unlike other synchronization aids, the Phaser is highly flexible and allows
 * for more dynamic thread coordination, supporting not only a fixed number of
 * threads but also enabling threads to join or leave the phase during
 * execution.
 */
public class PhaserExample {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		for (int i = 0; i < 3; i++) {
			new Thread(new Task(phaser)).start();
		}
	}

	static class Task implements Runnable {
		private final Phaser phaser;

		public Task(Phaser phaser) {
			this.phaser = phaser;
		}

		@Override
		public void run() {
			// Wait for other threads at phase1
			phaser.arriveAndAwaitAdvance();
			// Wait for other threads at phase2
			phaser.arriveAndAwaitAdvance();
			// Wait for other threads at phase3
			phaser.arriveAndAwaitAdvance();
			System.out.println("complted");
		}
	}
}