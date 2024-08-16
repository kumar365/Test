
public class ExampleProgram4 {
	public static boolean palindromCheck(String s) {
		boolean result = false;
		if (s.equals(new StringBuilder(s).reverse().toString())) {
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(palindromCheck("madam"));
		System.out.println(palindromCheck("sir"));
	}
}
