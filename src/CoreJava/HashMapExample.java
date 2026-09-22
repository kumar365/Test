package CoreJava;
import java.util.*;

public class HashMapExample {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("amit", 90);
		hm.put("Salman", 80);
		hm.put("Khan", 70);
		hm.put("hari", 60);
		hm.put("amit", 50);
		hm.put("Ravi", 99);
		System.out.println(hm); // System.out.println("Elements:"+hm);
		hm.remove("hari");
		Set<String> s = hm.keySet();
		System.out.println("keys:" + s);
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			String str = (String) o;
			System.out.println(str + " " + hm.get(str));
		}
		Collection<Integer> c = hm.values();
		System.out.println("values:" + c);
	}
}
