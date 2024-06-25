import java.util.stream.*;
import java.util.*;
import java.util.function.Function;

public class TestResults {
	public static class Student {
		private String name;
		private int score;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public String getName() {
			return name;
		}
	}

	public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
		List<String> list = students.filter(n -> n.getScore() > passingScore).map(n -> n.name)
				.sorted(Collections.reverseOrder()).collect(Collectors.toList());
		return list;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Mike", 80));
		students.add(new Student("James", 57));
		students.add(new Student("Alan", 21));

		studentsThatPass(students.stream(), 50).forEach(System.out::println);

		// String s = "Hellow world Preadeep kumar";
		System.out.println("Enter any string::");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		Map<Character, Long> map = s.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
	}
}