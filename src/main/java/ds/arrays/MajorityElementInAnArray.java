package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementInAnArray {

	// Given an array of size n, find the majority element. The majority element
	// is the element that appears more than n/2 times.

	// You may assume that the array is non-empty and the majority element
	// always exist in the array.
	public static int majorityElement(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int k : nums) {
			map.put(k, map.getOrDefault(k, 0) + 1);
		}
		Map.Entry<Integer, Integer> majorityElement = null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (majorityElement == null
					|| entry.getValue() > majorityElement.getValue()) {
				majorityElement = entry;
			}
		}
		return majorityElement.getKey();
	}
}
