import java.util.Arrays;

// The main method must be in a class named "Main".
class ArrayMergeSorted {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		int[] arr1 = { 1, 3, 5, 7 ,9,11};
		int[] arr2 = { 2, 4, 6, 8 ,10};

		System.out.println("Merged array:" + Arrays.toString(mergeArray(arr1, arr2)));
	}

	public static int[] mergeArray(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] merged = new int[n + m];
		int i = 0, j = 0, k = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				merged[k++] = arr1[i++];
			} else {
				merged[k++] = arr2[j++];
			}
		}
		// Copy any remaining elements from arr1
		while (i < n) {
			merged[k++] = arr1[i++];
		}

		// Copy any remaining elements from arr2
		while (j < m) {
			merged[k++] = arr2[j++];
		}
		return merged;
	}
}