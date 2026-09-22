package Java21Examples;
import java.util.ArrayList;
import java.util.List;
//4. Sequenced Collections (JEP 431)
// This introduces new interfaces (SequencedCollection, SequencedSet, SequencedMap) to provide a uniform way to access 
// the first and last elements of ordered collections, and to reverse the order.
public class Java21_SequencedCollectionExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Using SequencedCollection methods (implicitly available for List)
//        System.out.println("First element: " + list.getFirst());
//        System.out.println("Last element: " + list.getLast());
//
//        List<String> reversedList = list.reversed();
//        System.out.println("Reversed list: " + reversedList);
        
//        SequencedCollection<String> list = new ArrayList<>();
//        list.add("Middle");
//        list.addFirst("Start"); // ["Start", "Middle"]
//        list.addLast("End");    // ["Start", "Middle", "End"]
//
//        System.out.println(list.getFirst()); // Output: Start
//        System.out.println(list.reversed()); // Output: [End, Middle, Start]
        
//        SequencedSet<String> set = new LinkedHashSet<>();
//        set.add("A");
//        set.add("B");
//        set.addFirst("C"); // Moves "C" to the first position: [C, A, B]
        
//        SequencedMap<Integer, String> map = new LinkedHashMap<>();
//        map.put(2, "Two");
//        map.putFirst(1, "One"); // {1=One, 2=Two}
//        map.putLast(3, "Three"); // {1=One, 2=Two, 3=Three}
//
//        System.out.println(map.firstEntry()); // Output: 1=One
//        System.out.println(map.reversed());   // Output: {3=Three, 2=Two, 1=One}

    }
}