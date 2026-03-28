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
    }
}