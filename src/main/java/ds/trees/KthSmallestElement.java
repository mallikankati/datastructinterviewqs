package ds.trees;

import java.util.Stack;

public class KthSmallestElement {

	public static int kthSmallestElement(TreeNode root, int k) {
		if (root == null || k <= 0) {
			return -1;
		}
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (--k == 0)
				break;
			curr = curr.right;
		}
		return curr.val;
	}
}
