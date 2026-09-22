package JavaConcurrencyExamples;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
	private static final ForkJoinPool forkPool = new ForkJoinPool();
	private static final Long[] memo = new Long[101];

	static class Fibonacci extends RecursiveTask<Long> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final long n;

		public Fibonacci(long n) {
			this.n = n;
		}

		@Override
		protected Long compute() {
			if (n <= 1) {
				return n;
			}
			if (memo[(int) n] != null) {
				return memo[(int) n];
			}
			Fibonacci f1 = new Fibonacci(n - 1);
			Fibonacci f2 = new Fibonacci(n - 2);

			f1.fork();
			Long resultF2 = f2.fork().join();
			Long resultF1 = f1.join();
			Long result = resultF1 + resultF2;
			memo[(int) n] = result;
			return result;
		}
	}

	static class SumArray extends RecursiveAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final int threshold = 10;
		private final int[] array;
		private final int start;
		private final int end;

		public SumArray(int[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}

		@Override
		protected void compute() {
			if (end - start <= threshold) {
				int sum = 0;
				for (int i = start; i < end; i++) {
					sum += array[i];
				}
				System.out.println("Sum of range " + start + " to " + (end - 1) + ": " + sum);
			} else {
				int middle = (start + end) / 2;
				SumArray array1 = new SumArray(array, start, middle);
				SumArray array2 = new SumArray(array, middle, end);
				invokeAll(array1, array2);
			}
		}
	}

	public static void main(String[] args) {
		Fibonacci question = new Fibonacci(10);
		Long result = forkPool.invoke(question);
		System.out.println("Fibonacci of 10: " + result);
		int[] array = new int[100];
		for (int i = 0; i < 100; i++) {
			array[i] = i + 1;
		}

		SumArray array1 = new SumArray(array, 0, array.length);
		forkPool.invoke(array1);
		forkPool.shutdown();
	}
}