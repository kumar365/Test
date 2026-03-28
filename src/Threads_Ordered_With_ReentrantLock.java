
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockPrinter {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition turnA = lock.newCondition();
    private final Condition turnB = lock.newCondition();
    private volatile boolean isTurnA = true;

    public void printA(int i) {
        lock.lock();
        try {
            while (!isTurnA) {
                turnA.await();
            }
            System.out.println("Thread A: " + i);
            isTurnA = false;
            turnB.signal(); // Signal Thread B
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printB(int i) {
        lock.lock();
        try {
            while (isTurnA) {
                turnB.await();
            }
            System.out.println("Thread B: " + i);
            isTurnA = true;
            turnA.signal(); // Signal Thread A
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class Threads_Ordered_With_ReentrantLock {
    public static void main(String[] args) {
        ReentrantLockPrinter printer = new ReentrantLockPrinter();

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
