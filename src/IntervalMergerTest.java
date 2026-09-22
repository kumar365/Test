import java.util.Arrays;

public class IntervalMergerTest {
	public static void main(String[] args) {
		IntervalMerger merger = new IntervalMerger();

		System.out.println("=== RUNNING INTERVAL MERGER TESTS ===\n");

		// Case 1: Standard overlapping intervals
		int[][] input1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		runTestCase("Case 1: Standard Overlap", input1, merger);

		// Case 2: Adjacent/touching edges
		int[][] input2 = { { 1, 4 }, { 4, 5 } };
		runTestCase("Case 2: Edge Touching Overlap", input2, merger);

		// Case 3: Completely nested intervals
		int[][] input3 = { { 1, 10 }, { 2, 6 }, { 3, 5 } };
		runTestCase("Case 3: Nested Intervals", input3, merger);

		// Case 4: No overlapping segments
		int[][] input4 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		runTestCase("Case 4: No Overlaps", input4, merger);

		// Case 5: Single element sequence
		int[][] input5 = { { 1, 5 } };
		runTestCase("Case 5: Single Interval", input5, merger);
	}

	// Helper method to execute and print the results cleanly
	private static void runTestCase(String testName, int[][] input, IntervalMerger merger) {
		System.out.println("--- " + testName + " ---");
		System.out.println("Input:  " + Arrays.deepToString(input));

		int[][] result = merger.merge(input);

		System.out.println("Result: " + Arrays.deepToString(result));
		System.out.println();
	}

}
