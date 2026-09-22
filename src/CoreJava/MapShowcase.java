package CoreJava;
import java.util.*;

public class MapShowcase {
    public static void main(String[] args) {
        List<Integer> inputs = Arrays.asList(5, 1, 9, 3);

        // 1. HashMap: Fast but completely unordered
        Map<Integer, String> hash = new HashMap<>();
        
        // 2. LinkedHashMap: Remembers insertion sequence
        Map<Integer, String> linked = new LinkedHashMap<>();
        
        // 3. TreeMap: Forces strict natural sorting
        Map<Integer, String> tree = new TreeMap<>();

        for (int num : inputs) {
            hash.put(num, "Value");
            linked.put(num, "Value");
            tree.put(num, "Value");
        }

        System.out.println("HashMap (Unpredictable):   " + hash.keySet());   // Output varies based on bucket math
        System.out.println("LinkedHashMap (Inserted): " + linked.keySet()); // Always: [5, 1, 9, 3]
        System.out.println("TreeMap (Sorted):         " + tree.keySet());   // Always: [1, 3, 5, 9]
    }
}
