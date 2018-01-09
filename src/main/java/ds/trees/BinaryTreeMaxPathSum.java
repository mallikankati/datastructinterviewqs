package ds.trees;

import java.util.Arrays;

public class BinaryTreeMaxPathSum {
	// Given a binary tree, find the maximum path sum.

	// For this problem, a path is defined as any sequence of nodes from some
	// starting node to any node in the tree along the parent-child connections.
	// The path must contain at least one node and does not need to go through
	// the root.

	public static int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(root, max);
		return max[0];
	}

	private static int maxPathSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;
		int leftMax = Math.max(0, maxPathSum(root.left, max));
		int rightMax = Math.max(0, maxPathSum(root.right, max));
		max[0] = Math.max(max[0], root.val + leftMax + rightMax);
		return root.val + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(Arrays.asList(9, 3, 20, 15, 7));
		System.out.println("Maxpath sum:" + maxPathSum(root));
	}
}
