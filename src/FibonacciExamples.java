import java.util.Arrays;

class FibonacciExamples {
	static int array[];

	public static void main(String args[]) {
		fibonacci1(10);
		fibonacci2(10);
		fibRecursive(10);
	}

	public static void fibonacci1(int n) {
		System.out.println("From fibonacci1");
		int n1 = 0, n2 = 1, n3;
		System.out.print(n1 + " " + n2);// printing 0 and 1
		// loop starts from 2 because 0 and 1 are printed
		for (int i = 2; i < n; ++i) {
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
		System.out.println();
		System.out.println();
	}

	public static void fibonacci2(int n) {
		System.out.println("From fibonacci2");
		int array[] = new int[n];
		// The space used here is O(N)
		array[0] = 0;
		array[1] = 1;
		for (int k = 2; k < n; k++) {
			array[k] = array[k - 1] + array[k - 2];
		}
		System.out.println("All numbers in Fibonacci series is " + Arrays.toString(array));
		// The array is traversed only once so time complexity is O(N)
		System.out.println("The (" + n + "th number)  in Fibonacci series is : " + array[n - 1]);
		System.out.println();
	}

	public static void fibRecursive(int n) {
		System.out.println("From fibRecursive");
		array = new int[n];
		array[0] = 0;
		array[1] = 1;
		System.out.println("The (" + n + "th number) in Fibonacci series using recursion is : " + fibRecursion(n));
		System.out.println("All numbers in Fibonacci series is : " + Arrays.toString(array));
	}

	public static int fibRecursion(int n) {
		if (n == 1) {
			return array[0];
		}
		if (n == 2) {
			return array[1];
		} else {
			array[n - 1] = fibRecursion(n - 1) + fibRecursion(n - 2);
			return (array[n - 1]);
		}
	}
}