package ds.arrays;

import java.util.Arrays;
import java.util.logging.Logger;

public class RotateBackward {
	private static final Logger logger = Logger.getLogger(RotateBackward.class
			.getName());

	// Q1: Rotate an array of n elements to the right by k steps
	// Ex: [1, 2, 3, 4, 5, 6] if we rotate k =2 it should be [5, 6, 1, 2, 3, 4]
	// space O(1) and complexity O(n*k)
	public static void rotateArray(int[] arr, int k) {
		if (k > arr.length) {
			throw new RuntimeException("steps is more than array length");
		}
		k %= arr.length;
		reverseArray(arr, 0, arr.length - 1);
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, k, arr.length - 1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}

	public static void main(String[] args) {
		// Q1
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArray(arr, 3);
		logger.info("Q1 rotate array:" + Arrays.toString(arr));
	}
}
