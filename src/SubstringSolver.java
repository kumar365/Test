import java.util.HashMap;
import java.util.Map;

public class SubstringSolver {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty())
			return 0;

		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>(); // Tracks character positions

		// Sliding window defined by pointers 'left' and 'right'
		for (int right = 0, left = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			if (map.containsKey(currentChar)) {
				// Jump left pointer forward past the previous instance of currentChar
				left = Math.max(left, map.get(currentChar) + 1);
			}

			map.put(currentChar, right);
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		SubstringSolver solver = new SubstringSolver();

		// Array of test strings
		String[] testCases = { "abcabcbb", // Expected: 3 ("abc")
				"bbbbb", // Expected: 1 ("b")
				"pwwkew", // Expected: 3 ("wke")
				"", // Expected: 0
				" ", // Expected: 1 (" ")
				"au", // Expected: 2 ("au")
				"dvdf" // Expected: 3 ("vdf")
		};

		// Execute and print results
		System.out.println("--- Testing Longest Substring Without Repeating Characters ---");
		for (String test : testCases) {
			int result = solver.lengthOfLongestSubstring(test);
			// Formatting for clean alignment
			System.out.printf("Input: \"%s\"%s -> Longest Length: %d%n", test, test.length() < 5 ? "\t" : "", 
					result);
		}
	}
}
