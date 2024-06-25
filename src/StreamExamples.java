import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		long count = Stream.of(1, 2, 3, 4, 5).filter(i -> i < 4).count();
		System.out.println("Count of numbers < 4 : " + count);

		long countFull = Stream.of(1, 2, 3, 4, 5).count();
		System.out.println("Count of numbers : " + countFull);

		Stream<Integer> distinctIntegers = Stream.of(1, 1, 2, 3, 3, 4, 5).distinct();
		distinctIntegers.forEach(System.out::print);
		System.out.println();

		double avg = Stream.of(1, 2, 3, 4, 5).mapToInt(x -> x).summaryStatistics().getAverage();
		System.out.println("Average of numbers : " + avg);

		// print ten random numbers using forEach
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);

		// IntSummaryStatistics examples
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 6, 5);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Average of numbers in List : " + stats.getAverage());
		System.out.println("Count of numbers in List : " + stats.getCount());
		System.out.println("Heighest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of numbers in List : " + stats.getSum());

		List<String> names = Arrays.asList("abc", "xyz", "def", "klm");
		sortUsingJava8(names);
		names.stream().forEach(System.out::println);
		String data = "kumar";
		String encoded = Base64.getEncoder().encodeToString(data.getBytes());
		System.out.println("encoded : " + encoded);

		String decoded = new String(Base64.getDecoder().decode(encoded));
		System.out.println("decoded : " + decoded);

		Supplier<String> supplier = () -> "Hello Learners";
		System.out.println(supplier.get());

		Consumer<String> consumerString = s -> System.out.println(s);
		consumerString.accept("Hello World");

		// implement a Runnable interface in Java 8 using a lambda expression
		Runnable runnable = () -> {
			System.out.println("inside run method implementation using lambda expression");
		};
		new Thread(runnable).start();

		// sum integers in a List using reduce() operator.
		List<Integer> numberList = Arrays.asList(5, 3, 7, 10);
		int sum = numberList.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum); // prints 25
		names.stream().filter(Objects::nonNull) // here it s filtering only not null values
				.map(String::toUpperCase).forEach(System.out::println);
		names.stream().filter(Objects::isNull) // here it s filtering only null values
				.map(String::toUpperCase).forEach(System.out::println);
		Stream.of(1, 1, 3, 2, 4, 3).peek(System.out::print).limit(3).distinct().forEach(System.out::print);

	}

	private static void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}
