package JavaConcurrencyExamples;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueSequentialOrderDemo {
    private static final int POISON_PILL = -1; 
    private static final int TOTAL_TASKS = 10;

    public static void main(String[] args) {
        // SynchronousQueue forces a direct, 1-to-1 rendezvous between threads
        BlockingQueue<Integer> buffer = new SynchronousQueue<>();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= TOTAL_TASKS; i++) {
                    System.out.println("Produced: " + i);
                    buffer.put(i); // Blocks until the consumer explicitly takes it
                    Thread.sleep(100); 
                }
                
                buffer.put(POISON_PILL);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int value = buffer.take(); // Waits for producer to put an item
                    
                    if (value == POISON_PILL) {
                        System.out.println("Consumer received Poison Pill. Shutting down.");
                        break; 
                    }
                    
                    System.out.println("Consumed: " + value);
                    System.out.println("-----------------"); // Visual separator
                    Thread.sleep(100); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
