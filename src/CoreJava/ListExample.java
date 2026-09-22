package CoreJava;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		// --- ArrayList Usage ---
		List<String> arrayList = new ArrayList<>();
		arrayList.add("Java");
		arrayList.add("Python");
		System.out.println("ArrayList element at index 1: " + arrayList.get(1)); // Fast O(1)

		// --- LinkedList Usage ---
		// Using Deque interface reference to access sequential-specific methods
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("Apple");
		linkedList.add("Banana");

		// LinkedList exclusive operations (Deque methods)
		linkedList.addFirst("First Item"); // Fast O(1)
		linkedList.addLast("Last Item"); // Fast O(1)

		System.out.println("LinkedList head: " + linkedList.getFirst());
	}
}
