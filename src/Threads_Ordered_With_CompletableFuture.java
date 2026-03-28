
import java.util.concurrent.CompletableFuture;

public class Threads_Ordered_With_CompletableFuture{
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.completedFuture(null);

        for (int i = 0; i < 5; i++) {
            final int count = i;
            future = future.thenRunAsync(() -> {
                System.out.println("Thread A: " + count);
            }).thenRunAsync(() -> {
                System.out.println("Thread B: " + count);
            });
        }
        
        // Wait for all tasks to complete
        future.join();
    }
}
