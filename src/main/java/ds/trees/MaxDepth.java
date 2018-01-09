package ds.trees;

import java.util.Arrays;
import java.util.Stack;

public class MaxDepth {

	// Given a binary tree, find its maximum depth.

	// The maximum depth is the number of nodes along the longest path from the
	// root node down to the farthest leaf node.
	public static int maxDepthRecursive(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(maxDepthRecursive(root.left),
				maxDepthRecursive(root.right));
	}

	public static int maxDepthIterative(TreeNode root) {
		int max = 0;
		int depth = 1;
		TreeNode curr = root;
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
		while (curr != null || !nodeStack.isEmpty()) {
			if (curr != null) {
				nodeStack.push(curr);
				depthStack.push(depth);
				curr = curr.left;
				depth++;
			} else {
				curr = nodeStack.pop();
				depth = depthStack.pop();
				if (depth > max) {
					max = depth;
				}
				curr = curr.right;
				depth++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(Arrays.asList(9, 3, 20, 15, 7));
		System.out.println("Maxdepth recursive :" + maxDepthRecursive(root));
		System.out.println("Maxdepth iterative :" + maxDepthIterative(root));
	}
}
