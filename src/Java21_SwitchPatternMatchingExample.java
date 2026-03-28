//3. Pattern Matching for Switch (JEP 441)
//   This feature extends switch statements and expressions to allow pattern matching, enhancing readability and expressiveness.
public class Java21_SwitchPatternMatchingExample {
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		Object obj = "Hello";

		String result = switch (obj) {
		case Integer i -> "It's an Integer: " + i;
		case String s -> "It's a String: " + s.toUpperCase();
		case null -> "It's null";
		default -> "Unknown type";
		};
		System.out.println(result);
	}
}
