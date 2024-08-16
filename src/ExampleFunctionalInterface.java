
// Some Built-in Java Functional Interfaces
// 1) Runnable –> This interface only contains the run() method.
// 2) Comparable –> This interface only contains the compareTo() method.
// 3) ActionListener –> This interface only contains the actionPerformed() method.
// 4) Callable –> This interface only contains the call() method.

// Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:
// 1) Consumer 
// 2) Predicate 
// 3) Function 
// 4) Supplier

// Consumer, Predicate, and Function, likewise have additions that are provided beneath – 
// 1) Consumer -> Bi-Consumer
// 2) Predicate -> Bi-Predicate
// 3) Function -> Bi-Function, Unary Operator, Binary Operator 

//Java program to demonstrate lambda expressions to implement a user defined functional interface.
@FunctionalInterface
interface Square {
	int calculate(int x);
}

@FunctionalInterface
interface Addition {
	int sum(int x, int y);
}

class ExampleFunctionalInterface {
	public static void main(String args[]) {

		int a = 5;
		// lambda expression to define the calculate method
		Square s = (int x) -> x * x; // functional interface implementation provided using lambda expressions

		// parameter passed and return type must be same as defined in the prototype
		int ans = s.calculate(a);
		System.out.println("Square result::" + ans);

		int b = 10;
		// lambda expression to define the sum method
		Addition ad = (int x, int y) -> x + y;// functional interface implementation provided using lambda expressions
		int adAns = ad.sum(a, b);
		System.out.println("Addition result::" + adAns);
	}
}
