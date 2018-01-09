package ds.arrays;

import java.util.Arrays;
import java.util.logging.Logger;

public class MergeTwoSortedArrays {
	private static final Logger logger = Logger
			.getLogger(MergeTwoSortedArrays.class.getName());

	// Q6: Merge two sorted array into one array
	// Ex: arr1 ={1, 3, 4, 5}, arr2 = {2, 4, 6, 8} final array = {1, 2, 3, 4, 4,
	// 5, 6, 8}
	// O(n1 + n2) Time and O(n1 + n2) Extra Space
	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] results = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				results[k++] = arr1[i++];
			} else {
				results[k++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			results[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			results[k++] = arr2[j++];
		}
		return results;
	}

	public static void main(String[] args) {
		// Q6
		int[] arr1 = { 1, 3, 4, 5 };
		int[] arr2 = { 2, 4, 6 };
		logger.info("Q6 merge two sorted arrays:"
				+ Arrays.toString(mergeTwoSortedArrays(arr1, arr2)));

	}
}
