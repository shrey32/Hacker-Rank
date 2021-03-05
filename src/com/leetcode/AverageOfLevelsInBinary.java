package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class AverageOfLevelsInBinary {

	public static void main(String[] args) {

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		for (; q.size() > 0;) {
			int len = q.size();
			double sum = 0;
			for (int i = 0; i < len; i++) {
				TreeNode temp = q.poll();
				sum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			list.add(sum / len);
		}

		return list;
	}

}
