
public class A2Test {
	public static void main(String[] args) {
		A1 a1 = new A2();
		//a1.abc(); //compile time error as a does not have method abc()
		a1.xyz();
	}
}
