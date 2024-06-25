import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamplesStrings {
	public static class Notes {
		int tagId;
		String tagName;
		int age;

		public Notes(int tagId, String tagName, int age) {
			super();
			this.tagId = tagId;
			this.tagName = tagName;
			this.age = age;
		}

		public int getTagId() {
			return tagId;
		}

		public void setTagId(int tagId) {
			this.tagId = tagId;
		}

		public String getTagName() {
			return tagName;
		}

		public void setTagName(String tagName) {
			this.tagName = tagName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

	public static void main(String args[]) {
		firstNonRepeatedCharacter();
		firstRepeatedCharacter();
		concatStreams();
		toUppercase();
		mapWithDuplicatedKeys();
		wordCountInList();
		duplicateWordCountInList();
		charCountInString();
		sortByLength();
	}

	public static void firstNonRepeatedCharacter() {
		System.out.println("firstNonRepeatedCharacter:");
		String myString = "Java articles are Awesome";
		LinkedHashMap<Character, Long> map = myString.chars()
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
		Character result = map.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey())
				.findFirst().get();
		System.out.println(result);
	}

	public static void firstRepeatedCharacter() {
		System.out.println("firstRepeatedCharacter:");
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
		System.out.println("concatStreams:");
		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");
		Stream.concat(list1.stream(), list2.stream()).forEach(str -> System.out.print(str + " "));
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
		List<String> nameLst = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(nameLst);
	}

	public static void wordCountInList() {
		System.out.println("wordCountInList:");
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> namesCount = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
	}

	// only duplicate elements with its count from the String
	public static void duplicateWordCountInList() {
		System.out.println("duplicateWordCountInList:");
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
	}

	// program to print the count of each character in a String
	public static void charCountInString() {
		System.out.println("charCountInString:");
		String s = "string data to count each character";
		Map<String, Long> map = Arrays.stream(s.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
		Map<Object, Long> map1 = s.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map1);
	}

	// convert a List of objects into a Map by considering duplicated keys and
	// store them in sorted order
	public static void mapWithDuplicatedKeys() {
		System.out.println("mapWithDuplicatedKeys:");
		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));

		noteLst.add(new Notes(6, "note4", 66));// note4 is duplicate

		Map<String, Integer> notesRecords = noteLst.stream()
				.sorted(Comparator.comparingLong(Notes::getTagId).reversed())
				// sorting is based on TagId 55,44,33,22,11
				.collect(Collectors.toMap(Notes::getTagName, Notes::getTagId, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		// consider old value 44 for dupilcate key
		// it keeps order
		System.out.println("Notes : " + notesRecords);
	}

	public static void sortByLength() {
		// sort a List of Strings by their length using Stream API
		List<String> names = Arrays.asList("Kartik", "batra", "karan", "Rishi", "Jon");
		names.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);
		
	}
}