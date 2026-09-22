package CoreJava;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapComparison {
	public static void main(String[] args) {
		// --- HashMap: Unordered ---
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(3, "Three");
		hashMap.put(1, "One");
		hashMap.put(2, "Two");
		hashMap.put(4, "Four");
		System.out.println("HashMap Order: " + hashMap); // Output order is unpredictable

		// --- TreeMap: Sorted & Advanced Navigation ---
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(4, "Four");
		treeMap.put(3, "Three");
		treeMap.put(1, "One");
		treeMap.put(2, "Two");
		System.out.println("TreeMap Order: " + treeMap); // Guaranteed: {1=One, 2=Two, 3=Three}

		// TreeMap-exclusive navigation operations
		System.out.println("Lowest Key: " + treeMap.firstKey()); // 1
		System.out.println("Keys less than 3: " + treeMap.headMap(3)); // {1=One, 2=Two}
	}
}
