
import java.util.concurrent.Semaphore;

class SemaphorePrinter {
    private final Semaphore semA = new Semaphore(1);
    private final Semaphore semB = new Semaphore(0);

    public void printA(int i) {
        try {
            semA.acquire();
            System.out.println("Thread A: " + i);
            semB.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printB(int i) {
        try {
            semB.acquire();
            System.out.println("Thread B: " + i);
            semA.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Threads_Ordered_With_Semaphore {
    public static void main(String[] args) {
        SemaphorePrinter printer = new SemaphorePrinter();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printA(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printB(i);
            }
        }).start();
    }
}
