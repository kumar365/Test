
//Java Program to Count Total Number of Vowels and Consonants in a String 

//Main class
class ExampleVowelAndConsonantCount {

	// To prints number of vowels and consonants
	public static void vowelAndConsonantCount(String str) {
		// Initially initializing elements with zero as till now we have not traversed
		int vCount = 0, cCount = 0;

		// Declaring a reference String which contains all the vowels
		String refString = "aeiouAEIOU";

		for (int i = 0; i < str.length(); i++) {

			// Check for any special characters present in the given string
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				if (refString.indexOf(str.charAt(i)) != -1)
					vCount++;
				else
					cCount++;
			}
		}

		// Print and display number of vowels and consonants on console
		System.out.println("Number of Vowels = " + vCount + "\nNumber of Consonants = " + cCount);
		System.out.println("Number of Vowels & Consonants= " + (vCount + cCount));
	}

	// Main driver method
	public static void main(String[] args) {
		// Custom string as input
		String str = "#GeeksforGeeks";

		String str1 = "R V S P Kumar Kakumani";

		String str2 = "Rama Venkata Siva Pradeep Kumar Kakumani";

		vowelAndConsonantCount(str);
		System.out.println();
		vowelAndConsonantCount(str1);
		System.out.println();
		vowelAndConsonantCount(str2);
	}
}
