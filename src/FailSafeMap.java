
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeMap {

	// The Java Collection supports two types of iterators; Fail Fast and Fail Safe.
	// These iterators are very useful in exception handling. The Fail fast iterator
	// aborts the operation as soon it exposes failures and stops the entire
	// operation. Comparatively, Fail Safe iterator doesn't abort the operation in
	// case of a failure.

	// Fail Fast Ex : ArrayList, HashMap
	// Fail Safe Ex : CopyOnWriteArrayList, ConcurrentHashMap

	public static void main(String[] args) {
		Map<Integer, String> map1 = new ConcurrentHashMap<Integer, String>();
		map1.put(1, "jai");
		map1.put(2, "jai");
		map1.put(3, "jai");
		map1.put(4, "jai");
		map1.put(5, "jai");
		Iterator<?> itr = map1.entrySet().iterator();
		while (itr.hasNext()) {

			map1.put(6, "jai");

			System.out.println(itr.next());
		}
	}

}
