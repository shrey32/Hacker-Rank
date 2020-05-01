package com.leetcode.monthchallenge.april;

/**
 * <b>Binary Tree Maximum Path Sum</b>
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * </p>
 * 
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [1,2,3]
 * </p>
 * <p>
 * <b>Output:</b> 6
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [-10,9,20,null,null,15,7]
 * </p>
 * <p>
 * <b>Output:</b> 42
 * </p>
 * 
 * 
 * @author Shrey
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	public static int maxPathSum(TreeNode root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public static int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);

		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

		return current;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
