import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    // Unsafe: multiple threads will overwrite each other's increments
    private static int unsafeCounter = 0;

    // Safe: multi-threaded operations are performed atomically
    private static final AtomicInteger safeCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 10;
        int incrementsPerThread = 5000;
        Thread[] threads = new Thread[numberOfThreads];

        // Create 10 threads, each incrementing both counters 5,000 times
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    unsafeCounter++;                 // Non-atomic operation
                    safeCounter.incrementAndGet();   // Atomic operation
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish execution
        for (Thread thread : threads) {
            thread.join();
        }

        // Print final results
        System.out.println("Expected final count: " + (numberOfThreads * incrementsPerThread));
        System.out.println("Regular 'int' final count: " + unsafeCounter);
        System.out.println("AtomicInteger final count : " + safeCounter.get());
    }
}
