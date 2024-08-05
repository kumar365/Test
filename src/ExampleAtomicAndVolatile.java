
//import required packages
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

// Atomic variables are used when atomic operations on primitive data types are required, such as incrementing or decrementing a counter.
// Volatile variables are used when multiple threads need to access and modify a variable's value concurrently, 
// and immediate visibility of changes is required.

//creating a thread by extending a thread class
class myThread extends Thread {

	// declaring an atomic variable
	private AtomicInteger atomicInteger = new AtomicInteger();

	private AtomicLong atomicLong = new AtomicLong();

	private AtomicBoolean atomicBoolean = new AtomicBoolean();

	private AtomicReference<String> atomicReference = new AtomicReference<String>();

	private volatile int count = 0;

	public void run() {
		// calculating the count
		for (int i = 1; i <= 5; i++) {
			try {

				// putting thread on sleep
				Thread.sleep(i * 100);

				// calling incrementAndGet() method
				// on count variable
				atomicInteger.incrementAndGet();
				atomicLong.incrementAndGet();
				atomicBoolean.set(true);
				atomicReference.set("Kumar");
				count++;
			} catch (InterruptedException e) {

				// throwing exception
				System.out.println(e);
			}
		}
	}

	// returning the count value
	public AtomicInteger getAtomicInteger() {
		return atomicInteger;
	}

	// returning the count value
	public AtomicLong getAtomicLong() {
		return atomicLong;
	}

	// returning the count value
	public AtomicBoolean getAtomicBoolean() {
		return atomicBoolean;
	}

	// returning the count value
	public AtomicReference<String> getAtomicReference() {
		return atomicReference;
	}

	public int getCount() {
		return count;
	}
}

//driver class
public class ExampleAtomicAndVolatile {

	// main method
	public static void main(String[] args) throws InterruptedException {
		// creating an thread object
		myThread t = new myThread();

		Thread t1 = new Thread(t, "t1");

		// starting thread t1
		t1.start();

		Thread t2 = new Thread(t, "t2");

		// starting thread t2
		t2.start();

		// calling join method on thread t1
		t1.join();

		// calling join method on thread t1
		t2.join();

		// displaying the count
		System.out.println("getAtomicInteger=" + t.getAtomicInteger());
		System.out.println("getAtomicLong=" + t.getAtomicLong());
		System.out.println("getAtomicBoolean=" + t.getAtomicBoolean());
		System.out.println("getAtomicReference=" + t.getAtomicReference());

		System.out.println("count=" + t.getCount());// it gives different count for each run
	}
}
//Java provides atomic classes such as AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference. 
//Objects of these classes represent the atomic variable of int, long, boolean, and object reference respectively. 
//These classes contain the following methods.

//set(int value): Sets to the given value

//get(): Gets the current value

//lazySet(int value): Eventually sets to the given value

//compareAndSet(int expect, int update): Atomically sets the value to the given updated value if the current value == the expected value

//addAndGet(int delta): Atomically adds the given value to the current value

//decrementAndGet(): Atomically decrements by one the current value