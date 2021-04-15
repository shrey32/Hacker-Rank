package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return findLCA(root, p, q);
	}

	public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root.val == p.val || root.val == q.val)
			return root;

		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;
	}

}
