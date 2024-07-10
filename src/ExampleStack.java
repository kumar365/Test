import java.util.Stack;

public class ExampleStack {
	public static void main(String[] args) {
		// Create a new stack
		Stack<Integer> stack = new Stack<>();

		// Push elements onto the stack
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println("Stack push sequence: 1 2 3 4");
		System.out.print("Stack pop sequence:");
		// Pop elements from the stack
		while (!stack.isEmpty()) {
			System.out.print(" " + stack.pop());
		}
	}
}
