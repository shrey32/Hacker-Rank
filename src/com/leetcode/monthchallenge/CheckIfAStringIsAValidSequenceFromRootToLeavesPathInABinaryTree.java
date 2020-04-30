package com.leetcode.monthchallenge;

/**
 * 
 * @author Shrey
 *
 */
public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

	public boolean isValidSequence(TreeNode root, int[] ar) {
		return isValidSequence(root, ar, 0);
	}

	public boolean isValidSequence(TreeNode root, int[] ar, int i) {
		if (root == null) {
			return ar.length == 0;
		}

		if (i < ar.length && (root.left == null && root.right == null)
				&& (root.val == ar[i] && root.val == ar[ar.length - 1])) {
			return true;
		}

		return (i < ar.length && (root.val == ar[i]
				&& (isValidSequence(root.left, ar, i + 1) || isValidSequence(root.right, ar, i + 1))));
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
