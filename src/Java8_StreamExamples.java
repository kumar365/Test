import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_StreamExamples {

	public static void main(String[] args) {
		// count() method to count number of items in list after applying condition
		// number < 4
		long count = Stream.of(1, 2, 3, 4, 5).filter(i -> i < 4).count();
		System.out.println("Count of numbers < 4 : " + count);

		// count() method to count number of items in list
		long countFull = Stream.of(1, 2, 3, 4, 5).count();
		System.out.println("Count of numbers : " + countFull);

		// distinct() method to get distinct/unique numbers in list
		Stream<Integer> distinctIntegers = Stream.of(1, 1, 2, 3, 3, 4, 5).distinct();
		distinctIntegers.forEach(System.out::print);
		System.out.println();

		double avg = Stream.of(1, 2, 3, 4, 5).mapToInt(x -> x).summaryStatistics().getAverage();
		System.out.println("Average of numbers : " + avg);

		// print ten random numbers using forEach
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		System.out.println();

		// IntSummaryStatistics examples
		System.out.println("IntSummaryStatistics examples::");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 6, 5);
		IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Average of numbers in List : " + intSummaryStatistics.getAverage());
		System.out.println("Count of numbers in List : " + intSummaryStatistics.getCount());
		System.out.println("Heighest number in List : " + intSummaryStatistics.getMax());
		System.out.println("Lowest number in List : " + intSummaryStatistics.getMin());
		System.out.println("Sum of numbers in List : " + intSummaryStatistics.getSum());
		System.out.println();

		// DoubleSummaryStatistics examples
		System.out.println("DoubleSummaryStatistics examples::");
		List<Double> numbersNew = Arrays.asList(3.2, 2.5, 2.6, 3.9, 7.0, 3.0, 6.0, 5.0);
		DoubleSummaryStatistics doubleSummaryStatistics = numbersNew.stream().mapToDouble(x -> x).summaryStatistics();
		System.out.println("Average of numbers in List : " + doubleSummaryStatistics.getAverage());
		System.out.println("Count of numbers in List : " + doubleSummaryStatistics.getCount());
		System.out.println("Heighest number in List : " + doubleSummaryStatistics.getMax());
		System.out.println("Lowest number in List : " + doubleSummaryStatistics.getMin());
		System.out.println("Sum of numbers in List : " + doubleSummaryStatistics.getSum());
		System.out.println();

		// LongSummaryStatistics examples
		System.out.println("LongSummaryStatistics examples::");
		List<Long> numbers2 = Arrays.asList(12345678910L, 1234567891L, 123456789L, 12345678918L);
		LongSummaryStatistics longSummaryStatistics = numbers2.stream().mapToLong(x -> x).summaryStatistics();
		System.out.println("Average of numbers in List : " + longSummaryStatistics.getAverage());
		System.out.println("Colnt of nu12345678910Lrs in List : " + longSummaryStatistics.getCount());
		System.out.println("Heighest number in List : " + longSummaryStatistics.getMax());
		System.out.println("Lowest number in List : " + longSummaryStatistics.getMin());
		System.out.println("Sum of numbers in List : " + longSummaryStatistics.getSum());
		System.out.println();

		// FloatSummaryStatistics s= new FloatSummaryStatistics();

		List<String> names = Arrays.asList("abc", "xyz", "def", "klm", null, null);
		names.stream().forEach(System.out::println);

		System.out.println("printing only not null values");
		// here it s filtering only not null values
		// names.stream().filter(Objects::nonNull).map(String::toUpperCase).forEach(System.out::println);
		names.stream().filter(i -> i != null).map(String::toUpperCase).forEach(System.out::println);

		System.out.println("printing only  null values");
		// here it s filtering only null values
		names.stream().filter(Objects::isNull).forEach(System.out::println);
		// names.stream().filter(i -> i == null).forEach(System.out::println);

		System.out.println("Sorted list");
		List<String> names1 = Arrays.asList("abc", "xyz", "def", "klm");
		// Collections.sort(names1, (s1, s2) -> s1.compareTo(s2));
		// names1.sort((s1, s2) -> s1.compareTo(s2));
		names1 = names1.stream().sorted().collect(Collectors.toList());
		names1.stream().forEach(System.out::println);

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
		System.out.println("sum integers in a List using reduce():: " + sum); // prints 25 (0+5, 5+3, 8+7, 15+10)

		// Multiplication of integers in a List using reduce() operator.
		int multiplayResult = numberList.stream().reduce(1, (a, b) -> a * b); // 1*5 , 5*3, 15 * 7, 105* 10
		System.out.println("multiplay integers in a List using reduce():: " + multiplayResult); // prints 1050

		System.out.println("print list using streams::");
		Stream.of(1, 1, 3, 2, 4, 3).forEach(System.out::print);
		System.out.println();

		System.out.println("use distinct on streams::");
		Stream.of(1, 1, 3, 2, 4, 3).distinct().forEach(System.out::print);
		System.out.println();

		System.out.println("use Collectors.toSet() on streams::");
		Set<Integer> set = Stream.of(1, 1, 3, 2, 4, 3).collect(Collectors.toSet());
		System.out.println("set:: " + set);

		System.out.println("use limit on streams::");
		Stream.of(1, 1, 3, 2, 4, 3).limit(3).forEach(System.out::print);
		System.out.println();

		System.out.println("use limit and dixtinct on streams::");
		Stream.of(1, 1, 3, 2, 4, 3).limit(3).distinct().forEach(System.out::print);
		System.out.println();

		System.out.println("peek to log stream process::");
		List<?> list = Stream.of(1, 1, 3, 2, 4, 3).limit(3).distinct().peek(System.out::print)
				.collect(Collectors.toList());
		System.out.println();
		System.out.println(list);

		System.out.println("use limit ,skip and dixtinct on streams::");
		Stream.of(1, 1, 3, 2, 4, 3).distinct().limit(3).skip(1).forEach(System.out::println);
		System.out.println();

		List<Number> listnew = Arrays.asList(1, 1, 2, 2, 4, 5, 6);
		System.out.println("Printing repeated characters in list::" + listnew);
		listnew.stream().filter(i -> Collections.frequency(listnew, i) > 1).distinct().collect(Collectors.toList())
				.forEach(System.out::println);

	}

}
