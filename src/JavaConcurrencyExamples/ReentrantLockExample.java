package JavaConcurrencyExamples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock is the most popular implementation of the Lock interface. Here,
 * the term “reentrant” signifies that a thread can acquire and release the same
 * lock multiple times. When a thread first acquires a ReentrantLock, a hold
 * count is automatically set to one. The hold count increments every time the
 * same thread re-enters the lock. The lock is released only when the hold count
 * reaches zero.
 */

public class ReentrantLockExample {
	private static final Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Task());
		Thread thread2 = new Thread(new Task());
		thread1.start();
		thread2.start();
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + " has acquired a lock");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " released the lock");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				lock.unlock();
			}
		}
	}
}