package com.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Shrey
 *
 */
public class DiameterOfABinaryTree {

	public static int diameter(TreeNode root) {
		AtomicInteger ai = new AtomicInteger(0);
		helper(root, ai);
		return ai.get();
	}

	private static int helper(TreeNode root, AtomicInteger ai) {
		if (root == null)
			return 0;
		int left = helper(root.left, ai);
		int right = helper(root.right, ai);
		
		ai.set(Math.max(ai.get(),left+right));
		
		return Math.max(left, right) + 1;
	}

	private static class TreeNode {
		TreeNode left, right;
	}

}
