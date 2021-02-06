package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class RightViewOfBinaryTree {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty() && root != null) {
			result.add(q.peek().val);
			for (int i = q.size(); i > 0; i--) {
				root = q.poll();
				if (root.right != null)
					q.add(root.right);
				if (root.left != null)
					q.add(root.left);
			}
		}

		return result;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}

}
