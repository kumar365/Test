
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayToArrayList {

	public static List<String> asList1(String[] str) {
		List<String> list = new ArrayList<String>(str.length);

		for (int i = 0; i < str.length; i++) {

			list.add(str[i]);
		}
		return list;

	}

	public static void main(String[] args) {

		String[] strArray1 = { "hi", "how", "are", "you" };
		String strArray2[] = { "hiiii", "howhow", "areare", "youyou" };

		List<String> list1 = asList1(strArray1);
		Iterator<String> itr = list1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		List<String> list2 = Arrays.asList(strArray2);
		list2.stream().forEach(System.out::println);

	}

}
