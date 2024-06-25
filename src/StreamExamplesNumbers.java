import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamplesNumbers {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		getDate();
		printArray(list);
		evenNumberInList(list);
		oddNumberInList(list);
		numberStartingWithOneInList(list);
		duplicateElementsInList();
		findFirstElement();
		findTheTotalNumberOfElements();
		findMaxElement();
		sortValuesInList();
		sortDescending();
		cubeOnList();
		sortArrayTOStream();
		concatStreamsOfInteger();
		primeNumbersInList();
		sumOffIntigersOfList();
		findSecondLargestNumberInArray();
		findSecondLargestNumberInList();
		findSecondSmallestNumberInArray();
		findSecondSmallestNumberInList();
		findingSumOfLargestTwoNumbersInList();
		findingSumOfSmallestTwoNumbersInList();
		findFirstAndLastElementInArrayList();
		calculateStatisticsOfList();
	}

	public static void getDate() {
		// Used LocalDate API to get the date
		System.out.println("Current Local Date: " + java.time.LocalDate.now());

		// Used LocalTime API to get the time
		System.out.println("Current Local Time: " + java.time.LocalTime.now());

		// Used LocalDateTime API to get both date and time
		System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
	}

	public static void printArray(List<Integer> list) {
		System.out.println("Main list using toString():" + list.toString());
		System.out.println("Main list using Arrays class:" + Arrays.toString(list.toArray()));
	}

	public static void evenNumberInList(List<Integer> list) {
		System.out.println("EvenNumberInList:");
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}

	public static void oddNumberInList(List<Integer> list) {
		System.out.println("OddNumberInList:");
		list.stream().filter(n -> n % 2 == 1).forEach(System.out::println);
	}

	public static void numberStartingWithOneInList(List<Integer> list) {
		System.out.println("NumberStartingWithOne:");
		list.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(System.out::println);
	}

	public static void duplicateElementsInList() {
		System.out.println("DuplicateElementsInList:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<Integer>();
		list.stream().filter(n -> !set.add(n)).forEach(System.out::println);
	}

	public static void findFirstElement() {
		System.out.println("FindFirstElement:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		list.stream().findFirst().ifPresent(System.out::println);
		System.out.println("FirstElement:" + list.get(0));
	}

	public static void findTheTotalNumberOfElements() {
		System.out.println("findTheTotalNumberOfElements:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println("Using count::" + list.stream().count());
		System.out.println("Using size::" + list.size());
	}

	public static void findMaxElement() {
		System.out.println("findMaxElement:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		int max = list.stream().max(Integer::compare).get();
		System.out.println("Using max::" + max);
		Collections.sort(list);
		System.out.println("Using sort::" + list.get(list.size() - 1));
	}

	public static void sortValuesInList() {
		System.out.println("sortValuesInList:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		list.stream().sorted().forEach(System.out::println);
		Collections.sort(list);
		System.out.println("Using sort::" + list.toString());
	}

	public static void sortDescending() {
		System.out.println("sortDescending:");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

	public static boolean containsDuplicate(int[] nums) {
		System.out.println("containsDuplicate:");
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(list);
		if (set.size() == list.size()) {
			return false;
		}
		return true;
	}

	// Method to perform cube on list and filter numbers greater than 50
	public static void cubeOnList() {
		System.out.println("cubeOnList:");
		List<Integer> list = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		list.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);
	}

	// program to sort an array and then convert the sorted array into Stream
	public static void sortArrayTOStream() {
		System.out.println("sortArrayTOStream:");
		int arr[] = { 99, 55, 203, 99, 4, 91 };
		Arrays.parallelSort(arr);// Sorted the Array using parallelSort()
		Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

		// or
		Arrays.stream(arr).sorted().forEach(n -> System.out.print(n + " "));

	}

	// find the Maximum element in an array
	public static int findMaxElement(int[] arr) {
		System.out.println("findMaxElement:");
		return Arrays.stream(arr).max().getAsInt();
	}

	public static void concatStreamsOfInteger() {
		System.out.println("concatStreamsOfInteger:");
		List<Integer> list1 = Arrays.asList(1, 2, 4);
		List<Integer> list2 = Arrays.asList(1, 2, 3);

		// Concatenated the list1 and list2 by converting them into Stream
		Stream.concat(list1.stream(), list2.stream()).sorted().forEach(str -> System.out.print(str + " "));

		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(4);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		l1.addAll(l2);
		Collections.sort(l1);
		System.out.println("L1 : " + l1);
	}

	public static void primeNumbersInList() {
		System.out.println("primeNumbersInList:");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 20);
		// Prime number
		System.out.println(numbers.stream().filter(StreamExamplesNumbers::isPrime).collect(Collectors.toList()));
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrimeWithStreamAnyMatch(int number) {
		System.out.println("isPrimeWithStreamAnyMatch:");
		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}

	public static boolean isPrimeWithStreamNoneMatch(int number) {
		System.out.println("isPrimeWithStreamNoneMatch:");
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public void generatePrimeNumberListByStream() {
		System.out.println("generatePrimeNumberListByStream:");
		List<Integer> primeNumbers = IntStream.range(2, 30)
				.filter(number -> IntStream.range(2, number).noneMatch(divider -> number % divider == 0)).boxed()
				.collect(Collectors.toList());
		System.out.println("Main list using toString():" + primeNumbers.toString());
	}

	public static void sumOffIntigersOfList() {
		System.out.println("sumOffIntigersOfList:");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum1 = list.stream().reduce(0, Integer::sum);
		System.out.println("sum1::" + sum1);
		Integer sum2 = list.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("sum2::" + sum2);
		Integer sum3 = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("sum3::" + sum3);
	}

	public static void findSecondLargestNumberInArray() {
		System.out.println("findSecondLargestNumberInArray:");
		// random numbers
		int[] numArray = { 5, 9, 11, 2, 8, 21, 1 };

		// print to console
		System.out.println("Numbers in an Arrays : " + Arrays.toString(numArray));

		// sort in descending-order and get 2nd largest element
		int secondLargestNumber = Arrays.stream(numArray).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1)
				.findFirst().get();

		// print sum to console
		System.out.println("\nSecond largest number in an Arrays is - " + secondLargestNumber);

	}

	public static void findSecondLargestNumberInList() {
		System.out.println("findSecondLargestNumberInList:");
		// random numbers
		List<Integer> list = Arrays.asList(5, 9, 5, 2, 8, 9, 1);

		// print to console
		System.out.println("Numbers in an List : " + list.toString());

		// sort in descending-order and get 2nd largest element
		int secondLargestNumber = list.stream().distinct().sorted(Comparator.reverseOrder()).limit(2).skip(1)
				.findFirst().get();

		// print sum to console
		System.out.println("\nSecond largest number in List is - " + secondLargestNumber);

	}

	public static void findSecondSmallestNumberInArray() {
		System.out.println("findSecondSmallestNumberInArray:");
		// random numbers
		int[] numArray = { 5, 9, 11, 2, 8, 21, 1 };

		// print to console
		System.out.println("Numbers in an Arrays : " + Arrays.toString(numArray));

		// sort in descending-order and get 2nd largest element
		int secondSmallestNumber = Arrays.stream(numArray).boxed().sorted(Comparator.naturalOrder()).limit(2).skip(1)
				.findFirst().get();

		// print sum to console
		System.out.println("\nSecond smallest number in an Arrays is - " + secondSmallestNumber);

	}

	public static void findSecondSmallestNumberInList() {
		System.out.println("findSecondSmallestNumberInList:");
		// random numbers
		List<Integer> list = Arrays.asList(5, 9, 5, 2, 8, 9, 1);

		// print to console
		System.out.println("Numbers in an List : " + list.toString());

		// sort in descending-order and get 2nd largest element
		int secondLargestNumber = list.stream().distinct().sorted(Comparator.naturalOrder()).limit(2).skip(1)
				.findFirst().get();

		// print sum to console
		System.out.println("\nSecond smallest number in List is - " + secondLargestNumber);

	}

	public static void findingSumOfLargestTwoNumbersInList() {
		System.out.println("findingSumOfLargestTwoNumbersInList:");

		// random numbers
		List<Integer> list = Arrays.asList(5, 9, 11, 2, 8, 21, 1);

		// print to console
		System.out.println("Numbers in an List : " + list.toString());

		// find sum of largest 2 numbers using Stream.limit(); method
		int sum = list.stream().sorted(Comparator.reverseOrder()).limit(2).reduce(0, Integer::sum);

		// print sum to console
		System.out.println("The sum of 2 largest numbers in an List is - " + sum);
	}

	public static void findingSumOfSmallestTwoNumbersInList() {
		System.out.println("findingSumOfSmallestTwoNumbersInList:");
		// random numbers
		List<Integer> list = Arrays.asList(5, 9, 11, 2, 8, 21, 1);

		// print to console
		System.out.println("Numbers in an List : " + list.toString());

		// find sum of largest 2 numbers using Stream.limit(); method
		int sum = list.stream().sorted(Comparator.naturalOrder()).limit(2).reduce(0, Integer::sum);

		// print sum to console
		System.out.println("The sum of 2 smallest numbers in an List is - " + sum);
	}

	private static void findFirstAndLastElementInArrayList() {
		System.out.println("findFirstAndLastElementInArrayList:");
		// random numbers
		List<Integer> list = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
		// print to console
		System.out.println("Numbers in an List : " + list.toString());
		int first = list.stream().findFirst().get();

		// find Last element in Arrays
		int last = list.stream().reduce((one, two) -> two).get();

		// print to console
		System.out.println("First element in the list using stream = " + first);
		System.out.println("Last element in the list using stream= " + last);

		// print to console
		System.out.println("First element in the list using get = " + list.get(0));
		System.out.println("Last element in the list using get = " + list.get(list.size() - 1));
	}

	private static void calculateStatisticsOfList() {
		System.out.println("calculateStatisticsOfList:");
		// list
		List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

		// print numbers to console
		System.out.println("Elements in list :-" + list.toString());

		// IntSummaryStatistics using Java 8 Stream API
		IntSummaryStatistics statistics = list.stream().mapToInt(num -> num).summaryStatistics();

		// 1. sum - print sum to the console
		System.out.println("\n1. Sum is = " + statistics.getSum());

		// 2. average - print average to the console
		System.out.println("\n2. Average is = " + statistics.getAverage());

		// 3. min - print minimum to the console
		System.out.println("\n3. Minimum is = " + statistics.getMin());

		// 4. max - print maximum to the console
		System.out.println("\n4. Maximum is = " + statistics.getMax());

		// 5. count - print count to the console
		System.out.println("\n5. Count is = " + statistics.getCount());

		// On arrays
		int[] array = new int[] { 2, 3, 5, 7, 11, 13, 17 };
		// calculate sum using Java 8 Stream API
		int sum = Arrays.stream(array).sum();

		// print sum to the console
		System.out.println("Sum is = " + sum);

		// calculate average using Java 8 Stream API
		double average = Arrays.stream(array).average().orElse(Double.NaN);

		// print sum to the console
		System.out.println("Average is = " + average);

	}
}