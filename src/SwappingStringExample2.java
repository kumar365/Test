// Java program to swap pair of characters of a string
public class SwappingStringExample2 {

	// Function to swap pair of characters of a string
	public static String swapPair(String str) {

		if (str == null || str.isEmpty()) { // Checking if string is null or empty then return str
			return str;
		}

		int len = str.length();
		System.out.println("String length::" + len + " Order (" + len / 2 + ")");// O(n/2)
		// Creating a StringBuffer object with length of the string passed
		StringBuffer sb = new StringBuffer(len);

		// Traverse the string and append the character in the StringBuffer object in
		// reverse order
		for (int i = 0; i < len - 1; i += 2) {
			System.out.println("i::" + i);
			sb.append(str.charAt(i + 1));
			sb.append(str.charAt(i));
		}

		// Checking if the string has odd number of characters then append the last
		// character into StringBuffer object
		if (len % 2 != 0) {
			sb.append(str.charAt(len - 1));
		}

		// Converting the StringBuffer into the string and return
		return sb.toString();
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
