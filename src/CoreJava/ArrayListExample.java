package CoreJava;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	public static void main(String[] args) {
		// creation of ArrayList
		ArrayList<String> list = new ArrayList<String>();
		// adding elements to the ArrayList
		list.add("Nokia");
		list.add("Samsung");
		list.add("Sony");
		list.add("Celkon");
		list.add("HTC");
		System.out.println("List:" + list);

		// insert an element into ArrayList
		list.add(3, "Motorla");
		// displaying the elements
		System.out.println("List:" + list);

		// deleting the elements
		list.remove("HTC");
		System.out.println("List:" + list);

		list.remove(1);
		System.out.println("List:" + list);

		// displaying the size
		System.out.println("size:" + list.size());

		// displaying the elements using iterator
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
