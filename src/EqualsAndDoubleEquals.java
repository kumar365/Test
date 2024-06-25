
public class EqualsAndDoubleEquals {

	public static void main(String[] args) {
		equalsAndDoubleEqualsCheck();
	}

	public static void equalsAndDoubleEqualsCheck() {
		String s1 = new String("kumar");
		String s2 = new String("kumar");
		System.out.println(s1 == s2);
		System.out.println("s1.equals(s2) :: " + s1.equals(s2));
		System.out.println();

		String s3 = "kumar";
		String s4 = "kumar";
		System.out.println(s3 == s4);
		System.out.println("s3.equals(s4) :: " + s3.equals(s4));
		System.out.println();

		String s5 = new String("kumar");
		String s6 = "kumar";
		System.out.println(s5 == s6);
		System.out.println("s5.equals(s6) :: " + s5.equals(s6));
		System.out.println();

		String s7 = s1;
		System.out.println(s1 == s7);
		System.out.println("s1.equals(s7) :: " + s1.equals(s7));
		System.out.println();
		
		String s8 = s4;
		System.out.println(s4 == s8);
		System.out.println("s4.equals(s8) :: " + s4.equals(s8));
	}
}
