package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

	public static void main(String[] args) {
		FlipBinaryTreeToMatchPreorderTraversal a = new FlipBinaryTreeToMatchPreorderTraversal();
		System.out.println(a.flipMatchVoyage(input1(), new int[] { 1, 3, 2 }));// [1]
		a = new FlipBinaryTreeToMatchPreorderTraversal();
		System.out.println(a.flipMatchVoyage(input1(), new int[] { 1, 2, 3 }));// []
		a = new FlipBinaryTreeToMatchPreorderTraversal();
		System.out.println(a.flipMatchVoyage(input2(), new int[] { 2, 1 }));// [-1]
		a = new FlipBinaryTreeToMatchPreorderTraversal();
		System.out.println(a.flipMatchVoyage(input3(), new int[] { 1, 3, 2, 4, 5 }));// [-1]
	}

	int ind = 0;
	List<Integer> result = new ArrayList<>();

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		dfs(root, voyage);
		return result;
	}

	public void dfs(TreeNode root, int[] voyage) {
		if (root == null || (!result.isEmpty() && result.get(0) == -1))
			return;
		if (root.val != voyage[ind++])
			result = Arrays.asList(-1);
		else if (root.left != null && root.left.val != voyage[ind]) {
			result.add(root.val);
			dfs(root.right, voyage);
			dfs(root.left, voyage);
		} else {
			dfs(root.left, voyage);
			dfs(root.right, voyage);
		}
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private static TreeNode input1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		return root;
	}

	private static TreeNode input2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}

	private static TreeNode input3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		return root;
	}

}
