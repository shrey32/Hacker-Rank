package com.leetcode.monthchallenge.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 
 * @author Shrey
 *
 */
public class BinaryTreeLevelOrderTraversal2 {

	public static void main(String[] args) {
		System.out.println(levelOrderBottom(getInput1()));
		System.out.println(levelOrderBottom(getInput2()));
		System.out.println(levelOrderBottom(getInput3()));
		System.out.println(levelOrderBottom(getInput4()));
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int level = 1;
		while (!queue.isEmpty()) {

			List<Integer> list = new ArrayList<>();
			List<TreeNode> tempNodes = new ArrayList<>();
			int start = 0;
			while (start < level && !queue.isEmpty()) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				tempNodes.add(temp);
				start++;
			}

			result.add(list);

			for (TreeNode temp : tempNodes) {
				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			level += level;

		}
		Collections.reverse(result);

		return result;
	}

	private static TreeNode getInput1() {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		return node;
	}

	private static TreeNode getInput2() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		return node;
	}

	private static TreeNode getInput3() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		return node;
	}
	
	private static TreeNode getInput4() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.right.left = new TreeNode(9);
		node.right.left.right = new TreeNode(10);
		return node;
	}
	
}
