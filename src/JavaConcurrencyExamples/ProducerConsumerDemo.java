package JavaConcurrencyExamples;
import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int CAPACITY;

    public SharedBuffer(int capacity) {
        this.CAPACITY = capacity;
    }

    // Called by the producer thread
    public synchronized void produce(int value) throws InterruptedException {
        // Wait if the buffer is full
        while (buffer.size() == CAPACITY) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait(); 
        }

        buffer.add(value);
        System.out.println("Produced: " + value);

        // Notify the consumer thread that an item is available
        notify(); 
    }

    // Called by the consumer thread
    public synchronized int consume() throws InterruptedException {
        // Wait if the buffer is empty (Ensures consumer only consumes after production)
        while (buffer.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait(); 
        }

        int value = buffer.poll();
        System.out.println("Consumed: " + value);

        // Notify the producer thread that space is available
        notify(); 

        return value;
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        // Shared buffer with a maximum capacity of 3 items
        SharedBuffer sharedBuffer = new SharedBuffer(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            int value = 1;
            try {
                while (true) {
                    sharedBuffer.produce(value++);
                    Thread.sleep(800); // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    sharedBuffer.consume();
                    Thread.sleep(1500); // Simulate time taken to consume
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        producer.start();
        consumer.start();
    }
}
