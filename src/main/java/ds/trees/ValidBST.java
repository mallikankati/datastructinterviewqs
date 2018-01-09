package ds.trees;

import java.util.Stack;

public class ValidBST {

	public static boolean isValidBST(TreeNode root) {
		TreeNode curr = root;
		if (curr == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (prev != null && curr.val <= prev.val) {
				return false;
			}
			prev = curr;
			curr = curr.right;
		}
		return true;
	}
}
