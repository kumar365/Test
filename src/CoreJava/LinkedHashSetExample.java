package CoreJava;
import java.util.*;

public class LinkedHashSetExample {
	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
		lhs.add(12);
		lhs.add(23);
		lhs.add(34);
		lhs.add(45);
		lhs.add(56);
		lhs.add(67);
		System.out.println("Set:" + lhs);
		Iterator<Integer> it = lhs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}
}
