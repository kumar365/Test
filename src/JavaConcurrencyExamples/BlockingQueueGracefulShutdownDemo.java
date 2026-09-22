package JavaConcurrencyExamples;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueGracefulShutdownDemo {
    // The Poison Pill: A unique token signaling the consumer to stop
    private static final int POISON_PILL = -1; 
    private static final int TOTAL_TASKS = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= TOTAL_TASKS; i++) {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(200); 
                }
                
                // End of production: Send the shutdown signal
                buffer.put(POISON_PILL);
                System.out.println("Producer finished. Sent Poison Pill.");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int value = buffer.take();
                    
                    // Check for the shutdown signal
                    if (value == POISON_PILL) {
                        System.out.println("Consumer received Poison Pill. Shutting down.");
                        break; 
                    }
                    
                    System.out.println("Consumed: " + value);
                    Thread.sleep(400); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
