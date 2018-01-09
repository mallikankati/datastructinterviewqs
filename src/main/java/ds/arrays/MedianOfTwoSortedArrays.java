package ds.arrays;

import java.util.logging.Logger;

public class MedianOfTwoSortedArrays {

	private static final Logger logger = Logger
			.getLogger(MedianOfTwoSortedArrays.class.getName());

	// Median of two sorted arrays finding in O(log(m+n)) efficient solution
	// Other solution is merge two arrays and find the middle element in case of
	// odd length otherwise avg of two elements in the middle
	// Ex: arr1 = {1, 2, 5, 7}, arr2 = {3, 6, 10}, median = 5
	// Ex: Ex: arr1 = {1, 2, 5, 7}, arr2 = {3, 6}, median = 4
	// Note: This code fails for scenario {}, {1}
	public static double medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
		double med = 0.0;
		int m = arr1.length;
		int n = arr2.length;
		if (n > m) {
			return medianOfTwoSortedArrays(arr2, arr1);
		}
		int imin = 0, imax = m, mid = (m + n + 1) / 2;
		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = mid - i;
			if (i < imax && arr1.length > 0 && arr2.length > 0
					&& arr2[j - 1] > arr1[i]) {
				imin = imin + 1; // i is too small
			} else if (i > imin && arr1[i - 1] > arr2[j - 1]) {
				imax = imax - 1; // i is too big
			} else { // i is at perfect length
				int maxLeft = 0;
				if (i == 0 && arr2.length > 0)
					maxLeft = arr2[j - 1];
				else if (j == 0 && arr1.length > 0)
					maxLeft = arr1[i - 1];
				else if (arr1.length > 0 && arr2.length > 0)
					maxLeft = Math.max(arr1[i - 1], arr2[j - 1]);
				if ((m + n) % 2 == 1)
					return maxLeft;

				int minRight = 0;
				if (i == m)
					minRight = arr2[j];
				else if (j == n)
					minRight = arr1[i];
				else
					minRight = Math.min(arr2[j], arr1[i]);

				return (maxLeft + minRight) / 2;
			}
		}
		return med;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 5, 7 };
		int[] arr2 = { 3, 6, 10 };
		logger.info("Median of sorted array :"
				+ medianOfTwoSortedArrays(arr1, arr2));
		arr1 = new int[] { 1, 2, 5, 7 };
		arr2 = new int[] { 3, 6 };
		logger.info("Median of sorted array :"
				+ medianOfTwoSortedArrays(arr1, arr2));
		arr1 = new int[] { 1, 3 };
		arr2 = new int[] { 2 };
		logger.info("Median of sorted array :"
				+ medianOfTwoSortedArrays(arr1, arr2));
		arr1 = new int[] { 2 };
		arr2 = new int[] {};
		logger.info("Median of sorted array :"
				+ medianOfTwoSortedArrays(arr1, arr2));
	}
}
