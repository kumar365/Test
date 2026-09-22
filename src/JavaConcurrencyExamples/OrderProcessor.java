package JavaConcurrencyExamples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderProcessor {
	private final ExecutorService executorService;

	public OrderProcessor(int numberOfThreads) {
		this.executorService = Executors.newFixedThreadPool(numberOfThreads);
	}

	public void processOrder(Order order) {
		Future<Boolean> inventoryCheck = executorService.submit(() -> checkInventory(order));
		Future<Double> priceCalculation = executorService.submit(() -> calculatePrice(order));
		Future<Boolean> paymentProcessing = executorService.submit(() -> processPayment(order));
		try {
			boolean isInventoryAvailable = inventoryCheck.get();
			double finalPrice = priceCalculation.get();
			boolean isPaymentSuccessFull = paymentProcessing.get();
			if (isInventoryAvailable && isPaymentSuccessFull) {
				updateDatabase(order, finalPrice);
			} else {
				System.out.println("Order processing failed for Order: " + order.id());
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("An error occurred during process");
		}
	}

	private void updateDatabase(Order order, double finalPrice) {
		System.out.println("Modifying database to store the order details for order id: " + order.getId());
		// Order details are stored in the database
	}

	private Boolean checkInventory(Order order) {
		System.out.println("Checking availability of an inventory for order id: " + order.getId());

		// Assume inventory is available
		return true;
	}

	private Double calculatePrice(Order order) {
		System.out.println("Calculating price for an order id: " + order.getId());
		// return fix value
		return 100.00;
	}

	private Boolean processPayment(Order order) {
		System.out.println("Processing payment for order id: " + order.getId());

		// Assume payment is done;
		return true;
	}

	public void shutDown() {
		executorService.shutdown();
	}

	public static void main(String[] args) {
		OrderProcessor orderProcessor = new OrderProcessor(3);
		Order order1 = new Order(1, "Bike");
		Order order2 = new Order(2, "Car");
		orderProcessor.processOrder(order1);
		orderProcessor.processOrder(order2);
		orderProcessor.shutDown();
	}

	record Order(int id, String order) {
		public int getId() {
			return id;
		}
	}
}