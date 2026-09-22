import java.util.Arrays;

public class ArraySortWithoutMethod {

	public static void main(String[] args) {
		// Sample unsorted arrays (resetting for each test)
		int[] dataForBubble = { 64, 34, 25, 12, 22, 11, 90 };
		int[] dataForSelection = { 64, 34, 25, 12, 22, 11, 90 };
		int[] dataForInsertion = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("--- 1. BUBBLE SORT ---");
		System.out.println("Before: " + Arrays.toString(dataForBubble));
		bubbleSort(dataForBubble);
		System.out.println("After:  " + Arrays.toString(dataForBubble) + "\n");

		System.out.println("--- 2. SELECTION SORT ---");
		System.out.println("Before: " + Arrays.toString(dataForSelection));
		selectionSort(dataForSelection);
		System.out.println("After:  " + Arrays.toString(dataForSelection) + "\n");

		System.out.println("--- 3. INSERTION SORT ---");
		System.out.println("Before: " + Arrays.toString(dataForInsertion));
		insertionSort(dataForInsertion);
		System.out.println("After:  " + Arrays.toString(dataForInsertion));
	}

	/**
	 * 1. Bubble Sort Implementation Strategy: Repeatedly steps through the list,
	 * compares adjacent elements, and swaps them if they are in the wrong order.
	 */
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			// Last i elements are already in place
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// Standard swap using temp
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// Optimization: If no two elements were swapped by inner loop, then break
			if (!swapped) {
				break;
			}
		}
	}

	/**
	 * 2. Selection Sort Implementation Strategy: Divides the array into a sorted
	 * and an unsorted part. Repeatedly finds the minimum element from the unsorted
	 * part and moves it to the front.
	 */
	public static void selectionSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			// Assume the first unsorted element is the minimum
			int minIndex = i;

			// Search through the remaining unsorted elements
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first unsorted element
			if (minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}

	/**
	 * 3. Insertion Sort Implementation Strategy: Virtually splits the array into
	 * sorted and unsorted parts. Values from the unsorted part are picked and
	 * placed at the correct position in the sorted part.
	 */
	public static void insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}
