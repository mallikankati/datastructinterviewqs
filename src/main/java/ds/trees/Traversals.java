package ds.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

	public static List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorderHelper(root, res);
		return res;
	}

	private static void inorderHelper(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				inorderHelper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				inorderHelper(root.right, res);
			}
		}
	}

	public static List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}

	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int levelNum = q.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = q.poll();
				subList.add(node.val);
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			list.add(subList);
		}
		return list;
	}

	public static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int count = 0;
		while (!q.isEmpty()) {
			int levelNum = q.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = q.poll();
				if (count % 2 == 0)
					subList.add(node.val);
				else
					subList.add(0, node.val);

				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			list.add(subList);
			count++;
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(Arrays.asList(1, 2, 3));
		System.out.println("Inorder traversal recursive:"
				+ inorderTraversalRecursive(root));
		System.out.println("Inorder traversal iterative:"
				+ inorderTraversalIterative(root));
		root = TreeNode.createTree(Arrays.asList(9, 3, 20, 15, 7));
		System.out.println("Levelorder:" + levelOrderTraversal(root));
		System.out.println("ZigZag Levelorder:" + zigzagLevelOrderTraversal(root));
	}
}
