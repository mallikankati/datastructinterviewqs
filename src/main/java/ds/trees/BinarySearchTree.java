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
	public void delete(int value) {
		
	}

	public void print() {
		List<List<Integer>> list = Traversals.levelOrderTraversal(head);
		System.out.println(list);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for (int i : new int[] { 12, 5, 15, 3, 7, 13, 17, 1, 9, 19}) {
			bst.insert(i);
		}
		bst.print();
		
		TreeNode temp = bst.find(1);
		System.out.println(temp);
		temp = bst.find(80);
		System.out.println(temp);
	}
}
