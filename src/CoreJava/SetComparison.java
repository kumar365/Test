package CoreJava;
import java.util.*;

public class SetComparison {
    public static void main(String[] args) {
        List<String> rawData = Arrays.asList("Banana", "Apple", "Cherry", "Apple");

        // 1. HashSet: Arbitrary order, filters duplicates
        Set<String> hash = new HashSet<>(rawData);
        System.out.println("HashSet:       " + hash); 
        // Example Output: [Apple, Cherry, Banana]

        // 2. LinkedHashSet: Preserves the exact order elements arrived
        Set<String> linkedHash = new LinkedHashSet<>(rawData);
        System.out.println("LinkedHashSet: " + linkedHash); 
        // Always Output:  [Banana, Apple, Cherry]

        // 3. TreeSet: Alphabetical sorting applied automatically
        Set<String> tree = new TreeSet<>(rawData);
        System.out.println("TreeSet:       " + tree); 
        // Always Output:  [Apple, Banana, Cherry]
    }
}
