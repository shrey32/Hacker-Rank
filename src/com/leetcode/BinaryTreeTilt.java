package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class BinaryTreeTilt {

	public static void main(String[] args) {
		System.out.println(findTilt(input1()));
		System.out.println(findTilt(input2()));
	}

	static int sum = 0;

	public static int findTilt(TreeNode root) {
		sum = 0;
		helper(root);
		return sum;
	}

	private static int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		sum += Math.abs(left - right);
		return left + right + root.val;
	}

	private static TreeNode input1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		return root;
	}

	private static TreeNode input2() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}
	}

}
