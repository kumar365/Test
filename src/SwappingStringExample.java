import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Java program to swap pair of characters of a string using streams
public class SwappingStringExample {

	public static String swapPair(String str) {
		if (str == null || str.isEmpty()) { // Checking if string is null or empty then return str
			return str;
		}
		String swapped = IntStream.range(0, str.length())// .peek(i -> System.out.println("i= " + i + " i % 2= " + i % 2))
				.map(i -> i % 2 == 0 ? (i == str.length() - 1 ? i : i + 1) : i - 1)// .peek(System.out::println)
				.mapToObj(i -> String.valueOf(str.charAt(i))).collect(Collectors.joining());
		return swapped;
	}

	public static void main(String[] args) {

		String str1 = "Java";

		String str2 = "GeeksForGeeks";

		String str3 = "a";

		// Print the result
		System.out.println(str1 + ":: After swap ::" + swapPair(str1));
		System.out.println(str2 + ":: After swap ::" + swapPair(str2));
		System.out.println(str3 + ":: After swap ::" + swapPair(str3));
	}

}
