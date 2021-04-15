package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class CheckBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return height(root) == -1 ? false : true;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}

	private static class TreeNode {
		TreeNode left, right;
	}

}
