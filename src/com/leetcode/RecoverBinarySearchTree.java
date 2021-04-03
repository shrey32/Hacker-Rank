package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RecoverBinarySearchTree {

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);

		if (prev != null && prev.val > root.val) {
			if (first == null)
				first = prev;
			second = root;
		}

		prev = root;
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		inorder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
