// Some Built-in Java Functional Interfaces
// 1) Runnable –> This interface only contains the run() method.
// 2) Comparable –> This interface only contains the compareTo() method.
// 3) ActionListener –> This interface only contains the actionPerformed() method.
// 4) Callable –> This interface only contains the call() method.

// Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:
// 1) Consumer –> Represents an operation that accepts a single input argument and returns no result (void). 
// 2) Predicate –> Represents a boolean-valued function that takes one argument and returns true or false
// 3) Function –> Represents a function that accepts one argument of type T and produces a result of type R
// 4) Supplier –> Represents a supplier of results; it takes no arguments but produces a value of type T

// Consumer, Predicate, and Function, likewise have additions that are provided beneath – 
// 1) Consumer -> Bi-Consumer
// 2) Predicate -> Bi-Predicate
// 3) Function -> Bi-Function, Unary Operator, Binary Operator 

//Java program to demonstrate lambda expressions to implement a user defined functional interface.
package Java8Examples;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Square {
	int calculate(int x);
}

@FunctionalInterface
interface Addition {
	int sum(int x, int y);
}

class FunctionalInterfaceExample {
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

		consumerEample();
		predicateEample();
		functionEample();
		supplierEample();
	}

	private static void consumerEample() {
		System.out.println("Consumer Eample");
		List<String> cities = new ArrayList<>();
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Goa");
		cities.add("Pune");
		
        // no return value
		Consumer<String> printConsumer = city -> System.out.println(city);
		cities.forEach(printConsumer);
	}

	private static void predicateEample() {
		System.out.println("Predicate Eample");
		List<String> cities = new ArrayList<>();
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Goa");
		cities.add("Pune");

		// return always true/false value
		Predicate<String> filterCity = city -> city.equals("Mumbai");
		cities.stream().filter(filterCity).forEach(System.out::println);
		/* cities.stream().filter(city -> city.equals("Mumbai")).forEach(System.out::println); */
	}

	private static void functionEample() {
		System.out.println("Function Eample");
		List<String> cities = new ArrayList<>();
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Goa");
		cities.add("Pune");

		// takes one argument and return value
		Function<String, Character> getFirstCharFunction = city -> {
			return city.charAt(0);
		};
		cities.stream().map(getFirstCharFunction).forEach(System.out::println);
	}

	private static void supplierEample() {
		System.out.println("Supplier Eample");
		// takes zero arguments and return 1 or more values
		Supplier<String[]> citySupplier = () -> {
			return new String[] { "Mumbai", "Delhi", "Goa", "Pune" };
		};
		Arrays.asList(citySupplier.get()).forEach(System.out::println);
	}

}
