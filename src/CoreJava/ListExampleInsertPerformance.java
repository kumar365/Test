package CoreJava;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExampleInsertPerformance {
    public static void main(String[] args) {
        int operations = 100000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Measure ArrayList Insertion at Head
        long startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            arrayList.add(0, i); // Forces shifting of all existing elements
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList head insertion time: " + (endTime - startTime) / 1000000 + " ms");

        // Measure LinkedList Insertion at Head
        startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            linkedList.add(0, i); // Only updates pointers of the head node
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList head insertion time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
