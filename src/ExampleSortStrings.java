
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExampleSortStrings {

	public static void main(String[] args) {

		List<String> fruits = new ArrayList<String>();
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		Collections.sort(fruits);

		System.out.println("sort list using Collections.sort(list)");

		int i = 0;
		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
		System.out.println();

		String[] arr = { "apple", "ball", "dog", "cat" };
		int j = 0;
		System.out.println("sort array using Arrays.sort(array)");
		Arrays.sort(arr);
		for (String temp : arr) {
			System.out.println("fruits " + ++j + " : " + temp);
		}

	}

}
