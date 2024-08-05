
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ExampleSortFruit {

	public static void main(String[] args) {
		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineappale;
		fruits[1] = apple;
		fruits[2] = orange;
		fruits[3] = banana;

		// sort elements of fruits using Comparable interface and overriding
		// compareTo(Fruit fruit)
		Arrays.sort(fruits);
		System.out.println("Sort elements of fruits using Comparable interface and overriding compareTo(Fruit fruit)");
		int i = 0;
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp.getFruitName() + ", Quantity : " + temp.getQuantity());
		}

		System.out.println();
		int j = 0;
		// sort elements of fruits using Comparator interface and overriding
		// compare(Fruit fruit1, Fruit fruit2)
		System.out.println(
				"Sort elements of fruits using Comparator interface and overriding compare(Fruit fruit1, Fruit fruit2)");
		Arrays.sort(fruits, Fruit.fruitNameComparator);
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++j + " : " + temp.getFruitName() + ", Quantity : " + temp.getQuantity());
		}
		Arrays.asList(fruits).sort(Comparator.comparing(Fruit::getFruitName));
		Collections.sort(Arrays.asList(fruits), Comparator.comparing(Fruit::getFruitName));

	}

}
