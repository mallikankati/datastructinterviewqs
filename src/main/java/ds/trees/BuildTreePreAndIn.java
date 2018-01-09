package ds.trees;

public class BuildTreePreAndIn {

	// Given preorder and inorder traversal of a tree, construct the binary
	// tree.
	// Note:You may assume that duplicates do not exist in the tree.

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private static TreeNode build(int[] preorder, int preLow, int preHigh,
			int[] inorder, int inLow, int inHigh) {
		if (preLow > preHigh || inLow > inHigh)
			return null;
		TreeNode root = new TreeNode(preorder[preLow]);
		int inorderRoot = inLow;
		for (int i = inLow; i <= inHigh; i++) {
			if (inorder[i] == root.val) {
				inorderRoot = i;
				break;
			}
		}
		int leftTreeLen = inorderRoot - inLow;
		root.left = build(preorder, preLow + 1, preLow + leftTreeLen, inorder,
				inLow, inorderRoot - 1);
		root.right = build(preorder, preLow + leftTreeLen + 1, preHigh,
				inorder, inorderRoot + 1, inHigh);
		return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = {7,10,4,3,1,2,8,11};
		int[] inorder = {4,10,3,1,7,11,8,2};
		TreeNode root = buildTree(preorder, inorder);
		System.out.println("Levelorder :" + Traversals.levelOrderTraversal(root));
		System.out.println("inorder :" + Traversals.inorderTraversalIterative(root));
	}
}
