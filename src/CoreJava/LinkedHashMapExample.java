package CoreJava;
import java.util.*;

public class LinkedHashMapExample {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		lhm.put("Ravi", 11);
		lhm.put("Salman", 22);
		lhm.put("hari", 33);
		System.out.println(lhm);
		Set<String> set = lhm.keySet();
		System.out.println("key:" + set);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			String str = (String) o;
			System.out.println(str + "  " + lhm.get(str));
		}
		Collection<Integer> c = lhm.values();
		System.out.println("Values:" + c);
	}
}
