package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class DeepestLeavesSum {

	public static int deepestLeavesSum(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;

		int maxDepth = height(root);
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					q.offer(temp.left);
					sum += temp.left.val;
				}
				if (temp.right != null) {
					q.offer(temp.right);
					sum += temp.right.val;
				}
			}
			level++;
			if (level == maxDepth)
				return sum;
		}
		return 0;
	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;
	}

}
