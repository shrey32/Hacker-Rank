package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class TopViewOfBinaryTree {

	public static List<Integer> topViewOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		dfsL(root, res);
		dfsR(root, res);
		return res;
	}

	private static void dfsL(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		dfsL(root.left, res);
		res.add(root.val);
	}

	private static void dfsR(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		dfsR(root.right, res);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

	}

}
