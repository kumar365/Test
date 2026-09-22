package CoreJava;
class ClassExample {
	ClassExample() {
		System.out.println("Constructor");
	}

	static {
		System.out.println("Static block");
	}

	{
		System.out.println("Instance block");
	}

	public static void main(String[] args) {
		ClassExample obj1 = new ClassExample();
		ClassExample obj2 = new ClassExample();
	}
}