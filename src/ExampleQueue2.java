import java.util.PriorityQueue;
import java.util.Queue;
//A PriorityQueue is used when the objects are supposed to be processed based on the priority. 
//It is known that a Queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue are needed 
//to be processed according to the priority, that’s when the PriorityQueue comes into play.

//The PriorityQueue is based on the priority heap. 
//The elements of the priority queue are ordered according to the natural ordering, 
//or by a Comparator provided at queue construction time, depending on which constructor is used.  
public class ExampleQueue2 {
	public static void main(String[] args) {
		Queue<String> pq = new PriorityQueue<>();

		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");

		System.out.println("Initial Queue " + pq);

		pq.remove("Geeks");

		System.out.println("After Remove " + pq);

		System.out.println("Poll Method " + pq.poll());

		System.out.println("Final Queue " + pq);
	}
}
