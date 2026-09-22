package CoreJava;
import java.util.*;

public class HashsetExample {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(12);
		hs.add(23);
		hs.add(34);
		hs.add(45);
		hs.add(56);
		hs.add(67);
		System.out.println("set:" + hs);
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
