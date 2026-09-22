import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalMerger {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return intervals;
		}

		// Sort intervals based on starting times using Java 8+ Lambda
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		List<int[]> merged = new ArrayList<>();
		int[] currentInterval = intervals[0];
		merged.add(currentInterval);

		for (int[] nextInterval : intervals) {
			int currentEnd = currentInterval[1];
			int nextStart = nextInterval[0];
			int nextEnd = nextInterval[1];

			if (currentEnd >= nextStart) {
				// Overlapping intervals: mutate the end boundary in-place
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			} else {
				// Non-overlapping interval: update pointer to current tracked segment
				currentInterval = nextInterval;
				merged.add(currentInterval);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}
}
