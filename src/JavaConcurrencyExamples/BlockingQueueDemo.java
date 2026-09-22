package JavaConcurrencyExamples;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        // Shared thread-safe buffer with a fixed capacity of 3
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            int value = 1;
            try {
                while (true) {
                    // put() automatically blocks if the queue is full
                    buffer.put(value);
                    System.out.println("Produced: " + value);
                    value++;
                    Thread.sleep(800); // Simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // take() automatically blocks if the queue is empty
                    int value = buffer.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1500); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads
        producer.start();
        consumer.start();
    }
}
