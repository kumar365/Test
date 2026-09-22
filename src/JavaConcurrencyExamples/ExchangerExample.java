package JavaConcurrencyExamples;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * An exchanger is a concurrency construct that facilitates data exchange
 * between two concurrent tasks. It lets you define a synchronization point
 * where two threads arrive and swap the data structure, enabling communication
 * between them at a specific time during their execution.
 */
public class ExchangerExample {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		Thread thread1 = new Thread(() -> {
			try {
				// Thread 1 is exchanging data
				String data = "Hello from thread 1";
				System.out.println("Thread 1 is exchanging data: " + data);
				// Thread 1 received response
				String response = exchanger.exchange(data, 2, TimeUnit.SECONDS);
				System.out.println("Thread 1 received response: " + response);
			} catch (InterruptedException | TimeoutException e) {
				System.out.println("Exchange timed out or interrupted");
			}
		});
		Thread thread2 = new Thread(() -> {
			try {
				// Thread 2 is exchanging data
				String data = "Hello from thread 2";
				System.out.println("Thread 2 is exchanging data: " + data);
				// For timeout
				Thread.sleep(3000);

				// Thread 2 received response
				String response = exchanger.exchange(data);
				System.out.println("Thread 2 received response: " + response);
			} catch (InterruptedException e) {
				System.out.println("An error occurred: " + e.getMessage());
			}
		});
		thread1.start();
		thread2.start();
	}
}