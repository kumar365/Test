
public class ExampleRemoveLeadingZeros1 {
	// Method 1 to Remove leading zeros in a string
	public static String removeZero(String str) {

		// Count leading zeros
		// Initially setting loop counter to 0
		int i = 0;

		while (i < str.length() && str.charAt(i) == '0') {
			i++;
		}

		// Converting string into StringBuffer object
		// as strings are immutable
		StringBuffer sb = new StringBuffer(str);

		// The StringBuffer replace function removes
		// i characters from given index (0 here)
		sb.replace(0, i, "");

		// Returning string after removing zeros
		return sb.toString();
	}

	// Method 2
	// Main driver method
	public static void main(String[] args) {

		// Sample string input
		String str = "00000123569";

		String str2 = "000001235690";

		// Calling method 1 to count leading zeroes in above string
		str = removeZero(str);

		// Printing leading zeros inside string
		System.out.println(str);

		// Calling method 1 to count leading zeroes in above string
		str2 = removeZero(str2);

		// Printing leading zeros inside string
		System.out.println(str2);
	}
}
// Time Complexity: O(n), where n is the length of the input string.This is because the program iterates through 
// the input string once to count the leading zeroes and then again to remove them using the StringBuffer replace function. 
// Auxiliary Space: O(n) , as the program creates a new StringBuffer object with the same length as the input string.
