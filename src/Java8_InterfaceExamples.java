// A simple program to Test Interface default methods in java
interface TestInterface1 {
	// abstract method
	public void square(int a);

	// default method
	default void show() {
		System.out.println("Default Method from TestInterface1 Executed");
	}

}

interface TestInterface2 {
	// abstract method
	public void square(int a);

	// default method
	default void show() {
		System.out.println("Default Method show from TestInterface2 Executed");
	}

	static void showNew() {
		System.out.println("Static Method showNew from TestInterface2 Executed");
	}
}

interface TestInterface3 {
	// abstract method
	public void square(int a);

	// static method
	static void show() {
		System.out.println("Static Method show from TestInterface3 Executed");
	}

	static void showNew() {
		System.out.println("Static Method showNew from TestInterface3 Executed");
	}
} 

class Java8_InterfaceExamples implements TestInterface1, TestInterface2, TestInterface3 {
	// implementation of square abstract method
	@Override
	public void square(int a) {
		System.out.println(a * a);
	}

	// TestInterface1, TestInterface2 have the same default method so compiler will
	// force you to override show method in sub class
	@Override
	public void show() {
		TestInterface1.super.show();
		TestInterface2.super.show();
	}

	public static void main(String args[]) {
		Java8_InterfaceExamples ie = new Java8_InterfaceExamples();
		ie.square(4);

		// default method executed
		ie.show();
		// static method executed
		TestInterface3.show();
		TestInterface2.showNew();
		TestInterface3.showNew();
	}
}