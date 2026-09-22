package JavaConcurrencyExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * The ThreadFactory interface provides a way to customize how new threads are
 * created, especially when working with thread pools and executors. Instead of
 * relying on the default thread creation process, ThreadFactory allows
 * developers to define specific behaviors or configurations for threads, such
 * as naming conventions, priorities, or daemon status. The newThread() method
 * creates and returns a new thread.
 * 
 * When using an ExecutorService, you can supply a custom ThreadFactory to
 * control how threads are generated in the pool.
 */

public class ThreadFactoryExample implements ThreadFactory {
	private final String prefix;
	private int counter = 0;

	public ThreadFactoryExample(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(prefix + "-" + counter++);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(false);
		return thread;
	}

	public static void main(String[] args) {
        ThreadFactoryExample threadFactory = new  
               ThreadFactoryExample("Test");
        ExecutorService executorService = Executors.newFixedThreadPool(2, 
                 threadFactory);
        for(int i = 0; i < 5; i++){
            int taskId = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task "+ taskId);
            });
        }
        executorService.shutdown();
    }
}