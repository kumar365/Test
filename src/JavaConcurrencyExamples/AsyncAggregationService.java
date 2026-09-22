package JavaConcurrencyExamples;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncAggregationService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        // 1. Trigger tasks concurrently in a completely non-blocking fashion
        CompletableFuture<String> userInfoTask = CompletableFuture.supplyAsync(() -> fetchUserData());
        CompletableFuture<String> orderHistoryTask = CompletableFuture.supplyAsync(() -> fetchOrderHistory());
        CompletableFuture<String> loyaltyPointsTask = CompletableFuture.supplyAsync(() -> fetchLoyaltyPoints());

        // 2. Create a composite future that triggers when all downstream services complete
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(userInfoTask, orderHistoryTask, loyaltyPointsTask);

        // 3. Aggregate data natively once everything completes
        CompletableFuture<String> combinedReport = allTasks.thenApply(v -> {
            String user = userInfoTask.join(); // join() retrieves values without checked exceptions
            String orders = orderHistoryTask.join();
            String loyalty = loyaltyPointsTask.join();
            return String.format("Report: [User: %s | Orders: %s | Loyalty: %s]", user, orders, loyalty);
        });

        // Block here just to print the final output for this presentation console
        System.out.println(combinedReport.get());
        System.out.println("Total Execution Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static String fetchUserData() { sleep(300); return "Amit Sharma"; }
    private static String fetchOrderHistory() { sleep(400); return "5 Completed Orders"; }
    private static String fetchLoyaltyPoints() { sleep(250); return "1250 Points"; }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
