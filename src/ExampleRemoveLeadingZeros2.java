
public class ExampleRemoveLeadingZeros2 {
	public static void main(String[] args) {
		String str = "0000012356900";
		String newstr = "";
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				index = i;
				break;
			}
		}
		newstr = str.substring(index, str.length());

		// Printing leading zeros inside string
		System.out.println(newstr);
	}
}
// Time Complexity: O(n), where n is the length of the input string ‘str’. 
// The algorithm performs a single loop through the length of the string to find the first non-zero character.
// Auxiliary Space Complexity: O(n), where n is the length of the input string ‘str’. 
// The algorithm requires a string variable ‘newstr’ to store the modified string without leading zeros.
