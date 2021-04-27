package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class FindTheBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode prev = null;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (i == 0 && temp != null) {
					prev = temp;
				}
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
		}
		return prev.val;
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
