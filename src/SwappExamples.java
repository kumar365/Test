import java.util.Scanner;

public class SwappExamples {
	public static void main(String[] args) {
		// swappNumbersWithTempVariable();
		swappNumbersWithTempVariable(20, 10);
		swappNumbersWithOutTempVariable(36, 22);
		swappStringsWithTempVariable("ram", "laxman");
		swappStringsWithOutTempVariable("ramesh", "suresh");
	}

	@SuppressWarnings("resource")
	public static void swappNumbersWithTempVariable() {
		System.out.println("In side swappNumbersWithTempVariable");
		int x, y, t;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of X and Y");
		x = sc.nextInt();
		y = sc.nextInt();
		System.out.println("Before swapping numbers: " + x + "  " + y);
		/* swapping */
		t = x;
		x = y;
		y = t;
		System.out.println("After swapping: " + x + "   " + y);
		System.out.println();
	}

	public static void swappNumbersWithTempVariable(int x, int y) {
		System.out.println("In side swappNumbersWithTempVariable");
		int t = x;
		System.out.println("Before swapping numbers: " + x + "  " + y);
		/* swapping */
		x = y;
		y = t;
		System.out.println("After swapping: " + x + "   " + y);
		System.out.println();
	}

	public static void swappNumbersWithOutTempVariable(int x, int y) {
		System.out.println("In side swappNumbersWithOutTempVariable");
		System.out.println("Before swapping numbers: " + x + "  " + y);
		/* swapping */
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("After swapping: " + x + "   " + y);
	}

	public static void swappStringsWithTempVariable(String x, String y) {
		System.out.println("In side swappStringsWithTempVariable");
		String t = x;
		System.out.println("Before swapping strings: " + x + "  " + y);
		/* swapping */
		x = y;
		y = t;
		System.out.println("After swapping: " + x + "   " + y);
		System.out.println();
	}

	public static void swappStringsWithOutTempVariable(String x, String y) {
		System.out.println("In side swappStringsWithOutTempVariable");
		System.out.println("Before swapping strings: " + x + "  " + y);
		/* swapping */
		x = x + y;
		y = x.substring(0, x.length() - y.length());
		x = x.substring(y.length());
		System.out.println("After swapping: " + x + "   " + y);
	}
}
