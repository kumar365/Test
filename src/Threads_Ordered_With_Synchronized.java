
class TurnBasedPrinter {
    private volatile boolean isTurnA = true;
    private final Object lock = new Object();

    public void printA(int i) {
        synchronized (lock) {
            while (!isTurnA) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread A: " + i);
            isTurnA = false;
            lock.notify(); // Wake up the other thread
        }
    }

    public void printB(int i) {
        synchronized (lock) {
            while (isTurnA) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread B: " + i);
            isTurnA = true;
            lock.notify(); // Wake up the other thread
        }
    }
}

public class Threads_Ordered_With_Synchronized {
    public static void main(String[] args) {
        TurnBasedPrinter printer = new TurnBasedPrinter();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printA(i);
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printB(i);
            }
        });

        threadA.start();
        threadB.start();
    }
}
