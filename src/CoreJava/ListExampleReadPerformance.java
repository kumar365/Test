package CoreJava;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExampleReadPerformance {
	public static void main(String[] args) {
		int elements = 100000;
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		// Populate both lists
		for (int i = 0; i < elements; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}

		// Measure ArrayList Random Access
		long startTime = System.nanoTime();
		int value1 = arrayList.get(elements / 2); // Accessing the middle element		
		long endTime = System.nanoTime();
		System.out.println("ArrayList 'get' value :: " + value1+ " time: " + (endTime - startTime) + " ns");
 
		// Measure LinkedList Random Access
		startTime = System.nanoTime();
		int value2 = linkedList.get(elements / 2); // Traverses from index 0 to 50,000		
		endTime = System.nanoTime();
		System.out.println("LinkedList 'get' value :: " + value2+ " time: " + (endTime - startTime) + " ns");
	}
}
