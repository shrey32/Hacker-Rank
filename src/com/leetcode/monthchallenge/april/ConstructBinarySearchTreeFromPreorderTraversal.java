package com.leetcode.monthchallenge.april;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Construct Binary Search Tree from Preorder Traversal</b>
 * <p>
 * Return the root node of a binary search tree that matches the given preorder
 * traversal.
 * </p>
 * 
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any
 * descendant of node.left has a value < node.val, and any descendant of
 * node.right has a value > node.val. Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then
 * traverses node.right.)
 * </p>
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [8,5,1,7,10,12]
 * </p>
 * <p>
 * <b>Output:</b> [8,5,10,1,7,null,12]
 * </p>
 * 
 * 
 * 
 * <b>Note:</b>
 * 
 * <li>1 <= preorder.length <= 100</li>
 * <li>The values of preorder are distinct.</li>
 * 
 * @author Shrey
 *
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		System.out.println(bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 }));
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0)
			return null;
		TreeNode root = null;
		for (int val : preorder) {
			root = insert(root, val);
		}
		return root;
	}

	private static TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);

		if (val > root.val) {
			root.right = insert(root.right, val);
		} else if (val < root.val) {
			root.left = insert(root.left, val);
		}
		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(this);
			while (!queue.isEmpty()) {
				TreeNode curr = queue.poll();
				sb.append(curr.val + " ");
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			return sb.toString();
		}

	}

}
