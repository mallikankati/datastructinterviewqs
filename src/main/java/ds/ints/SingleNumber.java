package ds.ints;

public class SingleNumber {

	// Given an array of integers, every element appears twice except for one.
	// Find that single one.

	// Note:Your algorithm should have a linear runtime complexity. Could you
	// implement it without using extra memory?
	// Ex: input = {1, 1, 2, 2, 4,4,3, 5,5}, output = 3
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int single = nums[0];
		for (int i = 1; i < nums.length; i++) {
			single ^= nums[i];
		}
		return single;
	}

	public static void main(String[] args) {
		System.out.println("Array {1,1, 2,2, 4, 4, 3, 5,5} :"
				+ singleNumber(new int[] { 1, 1, 2, 2, 4, 4, 3, 5, 5 }));
	}
}
