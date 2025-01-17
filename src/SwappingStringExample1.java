
// Java program to swap pair of characters of a string using arrays
public class SwappingStringExample1 {
	// Function to swap pair of characters of a string
	public static String swapPair(String str) {
		if (str == null || str.isEmpty()) {// Checking if string is null or empty then return str
			return str;
		}
		// Converting the given string into a character array
		char[] chArray = str.toCharArray();
		System.out.println("String length::" + chArray.length + " Order (" + chArray.length / 2 + ")");// O(n/2)

		// Traverse the character array
		for (int i = 0; i < chArray.length - 1; i += 2) {
			System.out.println("i::" + i);
			// Swapping the characters
			char temp = chArray[i];
			chArray[i] = chArray[i + 1];
			chArray[i + 1] = temp;
		}
		// Converting the result into a string and return
		return new String(chArray);
	}

	public static void main(String args[]) {
		String str1 = "Java";

		String str2 = "GeeksForGeeks";

		String str3 = "a";

		// Print the result
		System.out.println(str1 + ":: After swap ::" + swapPair(str1));
		System.out.println(str2 + ":: After swap ::" + swapPair(str2));
		System.out.println(str3 + ":: After swap ::" + swapPair(str3));
	}
}
