package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TrimABinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;
		List<Integer> list = levelOrder(root);
		TreeNode node = null;
		for (int val : list) {
			if (val <= high && val >= low) {
				node = insert(node, val);
			}
		}
		return node;
	}

	public TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			TreeNode n = new TreeNode();
			n.val = value;
			return n;
		}
		if (root.val > value) {
			// left
			root.left = insert(root.left, value);
		} else if (root.val < value) {
			// right
			root.right = insert(root.right, value);
		} else {
			root.val = value;
		}
		return root;
	}

	public List<Integer> levelOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			list.add(tmp.val);
			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return list;
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
