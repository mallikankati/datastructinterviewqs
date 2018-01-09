package ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	// Given a collection of distinct numbers, return all possible permutations.
	// For example,
	// [1,2,3] have the following permutations:
	// [[1,2,3],[1,3,2],[2,1,3], [2,3,1],[3,1,2],[3,2,1] ]
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list,
			List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("[1, 2] :" + permute(new int[] { 1, 2 }));
		System.out.println("[1, 2, 3] :" + permute(new int[] { 1, 2, 3 }));
		System.out
				.println("[1, 2, 3, 4] :" + permute(new int[] { 1, 2, 3, 4 }));
	}
}
