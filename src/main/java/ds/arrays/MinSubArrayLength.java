package ds.arrays;

import java.util.logging.Logger;

public class MinSubArrayLength {
	private static final Logger logger = Logger
			.getLogger(MinSubArrayLength.class.getName());

	// Q7: Given an array of n positive integers and a positive integer target,
	// find the minimal length of a subarray of which the sum >= s. If there
	// isn't one, return 0 instead.
	// Ex: array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal
	// length of 2
	public static int minSubArrayLen(int[] arr, int target) {
		int minLen = Integer.MAX_VALUE;
		int i = 0, j = 0;
		int sum = 0;
		while (j < arr.length) {
			if (sum < target) {
				sum += arr[j++];
			} else {
				minLen = Math.min(minLen, j - i);
				if (i == j - 1) {
					return 1;
				}
				sum -= arr[i];
				i++;
			}
		}
		while (sum >= target && i < arr.length) {
			minLen = Math.min(minLen, j - i);
			sum -= arr[i++];
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		// Q7
		int[] arr3 = { 2, 3, 1, 2, 4, 3 };
		logger.info("Q7 minSubarrayLen :" + minSubArrayLen(arr3, 8));

	}
}
