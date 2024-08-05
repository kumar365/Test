
//Convert Vector to ArrayList in Java
import java.util.Vector;
import java.util.ArrayList;

public class ExampleArrayListVsVector {

	public static void main(String[] args) {

		// Create a Vector that contain strings
		Vector<String> v = new Vector<String>();

		// add values in vector
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("e");

		// Display the Vector
		System.out.println(" Vector : " + v);

		ArrayList<String> arrayList = new ArrayList<String>();

		// Convert Vector to ArrayList
		for (int i = 0; i < v.size(); i++) {
			arrayList.add(v.get(i));
		}
		// Display ArrayList
		System.out.println("\n ArrayList : " + arrayList);
	}
}
