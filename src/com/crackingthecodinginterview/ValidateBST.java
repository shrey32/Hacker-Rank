package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class ValidateBST {

	public boolean validateBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (min > root.val || max < root.val)
			return false;
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	private class TreeNode {
		int val;
		TreeNode left, right;
	}

}
