package ds.trees;

import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

	public void addNode(int val) {
		if (val < this.val) {
			if (this.left != null) {
				this.left.addNode(val);
			} else {
				this.left = new TreeNode(val);
			}
		} else {
			if (this.right != null) {
				this.right.addNode(val);
			} else {
				this.right = new TreeNode(val);
			}
		}
	}

	public static TreeNode createTree(List<Integer> list) {
		TreeNode root = null;
		for (int val : list) {
			if (root == null) {
				root = new TreeNode(val);
			} else {
				root.addNode(val);
			}
		}
		return root;
	}

	public String toString() {
		return "val :" + this.val;
	}
}
