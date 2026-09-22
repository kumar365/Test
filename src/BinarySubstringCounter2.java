import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BinarySubstringCounter2 {
	public static int countSubstrings(String s) {
		if (s == null || s.isEmpty())
			return 0;

		List<Integer> groups = new ArrayList<>();
		int count = 1;

		// Step 1: Identify consecutive group lengths
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				groups.add(count);
				count = 1;
			}
		}
		groups.add(count);

		// Step 2 & 3: Use IntStream to find min of adjacent groups and sum them
		return IntStream.range(0, groups.size() - 1).map(i -> Math.min(groups.get(i), groups.get(i + 1))).sum();
	}

	public static void main(String[] args) {
		String input = "010011"; // Substrings: "01", "10", "0011", "01"
		System.out.println("Total count: " + countSubstrings(input)); // Output: 4
	}
}
