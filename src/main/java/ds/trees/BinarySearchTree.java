package ds.trees;

import java.util.List;

public class BinarySearchTree {

	private TreeNode head = null;

	// Insert the node if not exists
	public void insert(int value) {
		if (head == null) {
			head = new TreeNode(value);
		} else {
			head.addNode(value);
		}
	}

	// find the node if exists otherwise returns null
	public TreeNode find(int value) {
		TreeNode curr = head;
		while (curr != null) {
			if (curr.val != value && value < curr.val) {
				curr = curr.left;
			} else if (value > curr.val) {
				curr = curr.right;
			} else {
				// it should be curr node;
				break;
			}
		}
		return curr;
	}

	// remove the node from BST if exists
	public boolean delete(int value) {
		TreeNode current = head;
		TreeNode parent = null;
		while (current != null) {
			if (current.val > value) {
				parent = current;
				current = current.left;
			} else if (current.val < value) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}
		if (current == null) {
			return false;
		}

		// CASE 1: If current has no right child
		if (current.right == null) {
			if (parent == null) {
				head = current.left;
			} else {
				if (parent.val > current.val) {
					parent.left = current.left;
				} else if (parent.val < current.val) {
					parent.right = current.left;
				}
			}
			// CASE 2: if current right child has no left child
		} else if (current.right.left == null) {
			current.right.left = current.left;
			if (parent == null) {
				head = current.right;
			} else {
				if (parent.val > current.val) {
					parent.left = current.right;
				} else if (parent.val < current.val) {
					parent.right = current.right;
				}
			}
			// CASE 3: if current right child has left child, replace current
			// with current right child's left most descendent
		} else {
			// Left most child of the right child
			TreeNode leftMost = current.right.left, leftMostParent = current.right;
			while (leftMost.left != null) {
				leftMostParent = leftMost;
				leftMost = leftMost.left;
			}
			// parents left subtree becomes the leftmost right subtree
			leftMostParent.left = leftMost.right;

			leftMost.left = current.left;
			leftMost.right = current.right;

			if (parent == null) {
				head = current.right;
			} else {
				if (parent.val > current.val) {
					parent.left = current.right;
				} else if (parent.val < current.val) {
					parent.right = current.right;
				}
			}
		}
		return false;
	}

	public void print() {
		List<List<Integer>> list = Traversals.levelOrderTraversal(head);
		System.out.println(list);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for (int i : new int[] { 12, 5, 15, 3, 7, 13, 17, 1, 9, 19 }) {
			bst.insert(i);
		}
		bst.print();

		TreeNode temp = bst.find(1);
		System.out.println(temp);
		temp = bst.find(80);
		System.out.println(temp);
	}
}
