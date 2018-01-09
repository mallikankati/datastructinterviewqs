package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TwoSum {

	private static final Logger logger = Logger.getLogger(TwoSum.class
			.getName());

	// Q5:Given an array of integers, find two numbers such that they add up to
	// a specific target number
	// Ex: {2, 7, 11, 15} target is 9, it should return {0, 1} as indexes
	public static int[] twoSum(int[] arr, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				result[0] = map.get(arr[i]);
				result[1] = i;
			} else {
				map.put((target - arr[i]), i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arrs = { 3, 5, 10, 6, 4, 1 };
		// Q5
		logger.info("Q6 Two sum:" + Arrays.toString(twoSum(arrs, 11)));
	}
}
