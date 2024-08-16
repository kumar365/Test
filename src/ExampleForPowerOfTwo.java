
public class ExampleForPowerOfTwo {

	// Function to check if x is power of 2
	// Time Complexity: O(log2n)
	// Auxiliary Space: O(1)
	static boolean isPowerOfTwo(int n) {
		if (n == 0) {
			return false;
		}

		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}

	// Function to efficiently check for power for 2
	static boolean isPowerOfTwoNew(int n) {

		// First n in the below expression is for the case when n is 0
		// System.out.println(n & (n - 1));
		return n != 0 && ((n & (n - 1)) == 0);
	}

	// Driver program
	public static void main(String args[]) {
		if (isPowerOfTwo(31))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (isPowerOfTwo(64))
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println();
		if (isPowerOfTwoNew(256))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (isPowerOfTwoNew(11))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
