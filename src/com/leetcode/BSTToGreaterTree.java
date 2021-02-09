package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class BSTToGreaterTree {

	public static void main(String[] args) {
		print(convertBST(input1()));
		print(convertBST(input2()));
		print(convertBST(input3()));
	}

	Integer greaterNodeSum = 0;

	public TreeNode convertBSTOptimized(TreeNode root) {
		if (root == null) {
			return null;
		}
		convertBSTOptimized(root.right);
		root.val = root.val + greaterNodeSum;
		greaterNodeSum = root.val;
		convertBSTOptimized(root.left);
		return root;

	}

	public static TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		int total = total(root);
		inorder(root, total, 0);
		return root;
	}

	public static void inorder(TreeNode root, int total, int prevTotal) {
		if (root == null)
			return;
		inorder(root.right, total, prevTotal);
		int temp = root.val;
		root.val = total - prevTotal;
		prevTotal += temp;
		inorder(root.right, total, prevTotal);
	}

	private static void print(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.val + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		System.out.println();
	}

	public static int total(TreeNode root) {
		if (root == null)
			return 0;
		int sum = root.val;
		sum += total(root.left);
		sum += total(root.right);
		return sum;
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

	private static TreeNode input1() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		return root;
	}

	private static TreeNode input2() {
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(1);
		return root;
	}

	private static TreeNode input3() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-4);
		root.left.right = new TreeNode(1);
		return root;
	}

}
