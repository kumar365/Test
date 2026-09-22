package CoreJava;
import java.util.*;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		tm.put("shyam", 65);
		tm.put("amit", 68);
		tm.put("Khan", 89);
		tm.put("hari", 66);
		System.out.println(tm);
		tm.remove("Khan");
		System.out.println(tm);
		Set<String> s = tm.keySet();
		System.out.println("keys:" + s);
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			String str = (String) o;
			System.out.println(str + "  " + tm.get(str));
		}
		Collection<Integer> c = tm.values();
		System.out.println("Values:" + c);
	}
}
