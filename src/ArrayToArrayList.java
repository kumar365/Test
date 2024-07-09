
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayToArrayList {

	public static void main(String[] args) {

		String[] strArray1 = { "hi", "how", "are", "you" };
		String strArray2[] = { "helo", "who", "am", "i" };

		List<String> list1 = getListFromArray(strArray1);
		Iterator<String> itr = list1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		
		List<String> list2 = Arrays.asList(strArray2);
		list2.stream().forEach(System.out::println);

	}

	public static List<String> getListFromArray(String[] strArray) {
		List<String> list = new ArrayList<String>(strArray.length);

		for (int i = 0; i < strArray.length; i++) {

			list.add(strArray[i]);
		}
		return list;

	}

}
