import java.util.LinkedList;
import java.util.Queue;

//Queue Interface In Java
//Being an interface the queue needs a concrete class for the declaration and 
//the most common classes are the PriorityQueue and LinkedList in Java. Note that neither of these implementations is thread-safe.
// PriorityBlockingQueue is one alternative implementation if the thread-safe implementation is needed.
public class ExampleQueue {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();

		// add elements to the queue
		queue.add("apple");
		queue.add("banana");
		queue.add("cherry");

		// print the queue
		System.out.println("Queue: " + queue);

		// remove the element at the front of the queue
		String front = queue.remove();
		System.out.println("Removed element: " + front);

		// print the updated queue
		System.out.println("Queue after removal: " + queue);

		// add another element to the queue
		queue.add("date");

		System.out.println("Queue after add: " + queue);

		// peek at the element at the front of the queue
		String peeked = queue.peek();
		System.out.println("Peeked element: " + peeked);

		// print the updated queue
		System.out.println("Queue after peek: " + queue);
	}
}
