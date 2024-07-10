import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ExampleQueue3 {
	public static void main(String[] args) {
		// Creating empty priority blocking queue
		Queue<Integer> pbq = new PriorityBlockingQueue<Integer>();

		// Adding items to the pbq using add()
		pbq.add(10);
		pbq.add(20);
		pbq.add(15);

		System.out.println("pbq :: " + pbq);

		// Printing the top element of the PriorityBlockingQueue
		System.out.println("peek element :: " + pbq.peek());

		System.out.println("After peek on pbq :: " + pbq);

		// Printing the top element and removing it from the PriorityBlockingQueue
		System.out.println("poll element :: " + pbq.poll());

		System.out.println("After poll on pbq :: " + pbq);

		// Printing the top element again
		System.out.println("peek element :: " + pbq.peek());
	}
}
