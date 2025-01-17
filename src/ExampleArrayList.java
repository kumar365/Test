import java.util.ArrayList;
import java.util.Iterator;

public class ExampleArrayList {
	public static void main(String[] args) {
		// creation of ArrayList
		ArrayList<String> al = new ArrayList<String>();
		// adding elements to the ArrayList
		al.add("Nokia");
		al.add("Samsung");
		al.add("Sony");
		al.add("Celkon");
		al.add("HTC");
		System.out.println("List:" + al);
		// index starts from 0
		// insert an element into ArrayList at index 3
		al.add(3, "Motorla");
		// displaying the elements
		System.out.println("List after insert element at index 3:" + al);

		// deleting the elements
		al.remove("HTC");
		System.out.println("List after removed HTC:" + al);

		al.remove(1); // index starts from 0 and 1 index element removed
		System.out.println("List after delete element from index 1:" + al);
		// displaying the size
		System.out.println("size:" + al.size());
		// displaying the elements using iterator
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
