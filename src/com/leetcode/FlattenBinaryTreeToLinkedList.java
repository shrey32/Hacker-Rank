package com.leetcode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flat(TreeNode root) {
		helper(root);
	}

	private TreeNode helper(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = helper(root.left);
		TreeNode right = helper(root.left);

		if (left == null && right == null)
			return root;
		if (left != null && right == null) {
			root.right = root.left;
			root.left = null;
			return left;
		}
		if (left == null && right != null) {
			return right;
		}
		if (left != null && right != null) {
			TreeNode temp = root.right;
			root.right = root.left;
			left.right = temp;
			root.left = null;
			return right;
		}

		return root;
	}

	private static class TreeNode {
		TreeNode left, right;
	}

}
