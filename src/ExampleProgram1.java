
class ExampleProgram1 {

	// Find the count of substrings with equal no. of consecutive 0's and 1's
	static int countSubstring(String S) {
		// To store the total count of substrings
		int result = 0, i = 0, n = S.length();

		// Traversing the string
		while (i < n) {

			// Count of consecutive 0's & 1's
			int count0 = 0, count1 = 0;

			// Counting subarrays of type "01"
			if (S.charAt(i) == '0') {

				// Count the consecutive 0's
				while (i < n && S.charAt(i) == '0') {
					count0++;
					i++;
				}

				int j = i;// If consecutive 0's ends then check for consecutive 1's

				// Counting consecutive 1's
				while (j < n && S.charAt(j) == '1') {
					count1++;
					j++;
				}
			}

			// Counting subarrays of type "10"
			else {

				// Count consecutive 1's
				while (i < n && S.charAt(i) == '1') {
					count1++;
					i++;
				}

				int j = i;// If consecutive 1's ends then check for consecutive 0's

				// Count consecutive 0's
				while (j < n && S.charAt(j) == '0') {
					count0++;
					j++;
				}
			}

			// Update the total count of substrings with minimum of (count0, count1)
			result += Math.min(count0, count1);
		}

		// Return answer
		return result;
	}

	// Driver code
	static public void main(String args[]) {
		String S = "000111001";
		// Function to print the count of substrings
		System.out.println(countSubstring(S));
	}

	// Time Complexity: O(N), where N = length of string.
	// Auxiliary Space: O(1), no extra space is required, so it is a constant.
}
