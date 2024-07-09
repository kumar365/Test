
public class A2Test {
	public static void main(String[] args) {
		A1 a = new A2();
		//a.abc(); //compile time error as a does not have method abc()
		a.xyz();
	}
}
