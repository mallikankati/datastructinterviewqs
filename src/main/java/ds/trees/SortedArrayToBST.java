package ds.trees;

public class SortedArrayToBST {

	public static TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length <= 0)
			return null;
		TreeNode root = bstHelper(num, 0, num.length - 1);
		return root;
	}

	private static TreeNode bstHelper(int[] num, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = bstHelper(num, low, mid - 1);
		node.right = bstHelper(num, mid + 1, high);
		return node;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		TreeNode root = sortedArrayToBST(arr);
		System.out.println("Level order :"
				+ Traversals.levelOrderTraversal(root));
		System.out.println("Inorder :"
				+ Traversals.inorderTraversalIterative(root));
	}
}
