package com.leetcode.monthchallenge;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Diameter of Binary Tree</b>
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * </p>
 * 
 * <b>Example:</b>
 * <p>
 * Given a binary tree<br>
 * &nbsp;&nbsp;&nbsp;1<br>
 * &nbsp;&nbsp;/ \<br>
 * &nbsp;2 &nbsp;3<br>
 * &nbsp;/ \ <br>
 * 4 &nbsp;5 <br>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * </p>
 * 
 * <p>
 * <b>Note:</b> The length of path between two nodes is represented by the
 * number of edges between them.
 * </p>
 * 
 * @author Shrey
 *
 */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		System.out.println(diameterOfBinaryTree(input1()));

	}

	public static int diameterOfBinaryTree(TreeNode root) {

		AtomicInteger diameter = new AtomicInteger(0);
		diameter(root, diameter);

		return diameter.get() - 1;
	}

	private static int diameter(TreeNode root, AtomicInteger diameter) {
		if (root == null)
			return 0;

		int lHeight = diameter(root.left, diameter);
		int rHeight = diameter(root.right, diameter);

		int maxDiameter = lHeight + rHeight + 1;

		diameter.set(Math.max(maxDiameter, diameter.get()));

		return Math.max(rHeight, lHeight) + 1;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static TreeNode input1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		return root;
	}

}
