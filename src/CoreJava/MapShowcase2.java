package CoreJava;
import java.util.*;

public class MapShowcase2 {
	public static void main(String[] args) {
		List<String> inputs = Arrays.asList("rama", "krishna", "abhya", "shyam");

		// 1. HashMap: Fast but completely unordered
		Map<String, String> hash = new HashMap<>();

		// 2. LinkedHashMap: Remembers insertion sequence
		Map<String, String> linked = new LinkedHashMap<>();

		// 3. TreeMap: Forces strict natural sorting
		Map<String, String> tree = new TreeMap<>();

		for (String str : inputs) {
			hash.put(str, "Value");
			linked.put(str, "Value");
			tree.put(str, "Value");
		}

		System.out.println("HashMap (Unpredictable):   " + hash.keySet()); // Output varies based on bucket math
		System.out.println("LinkedHashMap (Inserted): " + linked.keySet()); // Always: [5, 1, 9, 3]
		System.out.println("TreeMap (Sorted):         " + tree.keySet()); // Always: [1, 3, 5, 9]
	}
}
