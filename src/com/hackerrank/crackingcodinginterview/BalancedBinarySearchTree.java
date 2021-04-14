package com.hackerrank.crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class BalancedBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode balanceBST(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		// System.out.println(list);
		return balance(list, 0, list.size() - 1);
	}

	public void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

	private TreeNode balance(List<Integer> list, int start, int end) {

		if (start > end)
			return null;

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = balance(list, start, mid - 1);
		root.right = balance(list, mid + 1, end);
		return root;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
