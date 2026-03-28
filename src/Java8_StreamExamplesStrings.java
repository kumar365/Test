import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_StreamExamplesStrings {

	public static void main(String args[]) {

		firstNonRepeatedCharacter();
		firstRepeatedCharacter();
		concatStreams();
		toUppercase();
		wordCountInList();
		duplicateWordCountInList();
		charCountInString();
		sortByLength();

	}

	public static void firstNonRepeatedCharacter() {
		System.out.println("First Non Repeated Character:");
		String string = "Java articles are Awesome";
		LinkedHashMap<Character, Long> map = string.chars()
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
		Character result = map.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey())
				.findFirst().get();
		System.out.println(result);
	}

	public static void firstRepeatedCharacter() {
		System.out.println("First Repeated Character:");
		String myString = "Java articles are Awesome";
		LinkedHashMap<Character, Long> map = myString.chars()
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
		Character result = map.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey())
				.findFirst().get();
		System.out.println(result);
	}

	public static void concatStreams() {
		System.out.println("Concat lists using Streams:");
		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");
		Stream.concat(list1.stream(), list2.stream()).forEach(str -> System.out.print(str + " "));
		System.out.println();
		List<String> concatList = Stream.of(list1, list2).flatMap(List::stream).collect(Collectors.toList());
		System.out.println("concatList:: " + concatList);
		System.out.println();
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("Java");
		l1.add("8");
		ArrayList<String> l2 = new ArrayList<String>();
		l2.add("explained");
		l2.add("through");
		l2.add("programs");
		l1.addAll(l2);
		System.out.println("concat strings using list:: " + l1.toString());
	}

	// map to convert object into Uppercase
	public static void toUppercase() {
		System.out.println("toUppercase:");
		List<String> names = Arrays.asList("explained", "through", "programs");
		List<String> nameList = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(nameList);
		List<String> nameList1 = names.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(nameList1);
	}

	public static void wordCountInList() {
		System.out.println("word Count In List:");
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> namesCount = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
	}

	// only duplicate elements with its count from the String
	public static void duplicateWordCountInList() {
		System.out.println("duplicate Word Count In List:");
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
	}

	// program to print the count of each character in a String
	public static void charCountInString() {
		System.out.println("charCountInString");
		System.out.println("each character Count In String:");
		String string = "string data to count each character";
		Map<String, Long> map = Arrays.stream(string.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		System.out.println("Word count in string");
		System.out.println(map);
		Map<Object, Long> map1 = string.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("char count in string");
		System.out.println(map1);
	}

	public static void sortByLength() {
		// sort a List of Strings by their length using Stream API
		List<String> names = Arrays.asList("Kartik", "batra", "karan", "Rishi", "Jon");
		names.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);

	}
}