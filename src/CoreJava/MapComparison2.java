package CoreJava;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapComparison2 {
	public static void main(String[] args) {
		// --- HashMap: Unordered ---
		// String keys will show an unpredictable output order compared to insertion
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("banana", "Fruit");
		hashMap.put("apple", "Fruit");		
		hashMap.put("cherry", "Fruit");
		System.out.println("hashMap Order: " +hashMap);  // Output order is unpredictable

		// --- TreeMap: Sorted & Advanced Navigation ---
		TreeMap<String, String> treeMap = new TreeMap<>();
		treeMap.put("banana", "Fruit");
		treeMap.put("apple", "Fruit");		
		treeMap.put("cherry", "Fruit");
		System.out.println("TreeMap Order: " + treeMap); // Guaranteed: {1=One, 2=Two, 3=Three}

		// TreeMap-exclusive navigation operations
		System.out.println("Lowest Key: " + treeMap.firstKey()); // 1
		System.out.println("Keys less than cherry: " + treeMap.headMap("cherry")); // {1=One, 2=Two}
	}
}
