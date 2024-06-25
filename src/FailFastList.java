
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastList {

	// The Java Collection supports two types of iterators; Fail Fast and Fail Safe.
	// These iterators are very useful in exception handling. The Fail fast iterator
	// aborts the operation as soon it exposes failures and stops the entire
	// operation. Comparatively, Fail Safe iterator doesn't abort the operation in
	// case of a failure.

	// Fail Fast Ex :   ArrayList,          HashMap
	// Fail Safe Ex : CopyOnWriteArrayList, ConcurrentHashMap

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		Iterator<Integer> itr = list1.iterator();
		while (itr.hasNext()) {
			list1.add(6);
			System.out.println(itr.next());
		}

	}

}
