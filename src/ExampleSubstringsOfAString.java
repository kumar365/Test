
//Java Program to split a string into all possible substrings excluding the string with 0 characters i.e. "" 

import java.util.ArrayList;

class ExampleSubstringsOfAString {

	// function to split a string into all its substrings and return the list as an
	// object of ArrayList
	public static ArrayList<String> splitSubstrings(String string) {

		// variables to traverse through the string
		int i, j;

		// to store the length of the string
		int stringLength = string.length();

		// List object to store the list of all substrings of the string s
		ArrayList<String> subStringList = new ArrayList<String>();

		// first for loop
		for (i = 0; i < stringLength; i++) {

			for (j = i + 1; j <= stringLength; j++) {

				subStringList.add(string.substring(i, j));
			}

		} // end of first for loop

		// returning the list (object of ArrayList) of substrings of string s
		return subStringList;
	}

	public static void main(String[] args) {

		// here "The Cat" is our input string
		String stringInput = "The Cat";

		ArrayList<String> subStringList = splitSubstrings(stringInput);

		System.out.println("\nSubstring list printed as an ArrayList : ");
		System.out.println(subStringList);

		System.out.println("\n\nAll substrings printed 1 per line : ");
		int count = 1;

		// each substring would be printed within double quotes
		for (String str : subStringList) {
			System.out.println("(" + count + ") \"" + str + "\"");
			count++;
		}
	}
}
// Time Complexity: O(n2) where n is the length of  a string  