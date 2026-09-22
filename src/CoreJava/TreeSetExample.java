package CoreJava;
import java.util.*;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(12);
		ts.add(23);
		ts.add(34);
		ts.add(45);
		ts.add(56);
		ts.add(67);
		System.out.println("set:" + ts);
		Iterator<Integer> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}
}
