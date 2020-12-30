package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * <a href=
 * "https://leetcode.com/explore/featured/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3585/">Pseudo-Palindromic
 * Paths in a Binary Tree</a>
 * 
 * @author Shrey
 *
 */
public class PseudoPalindromicPathsInABinaryTree {

	public static void main(String[] args) {
		System.out.println(pseudoPalindromicPaths(getTestInput1()));//2
		System.out.println(pseudoPalindromicPaths(getTestInput2()));//1
		System.out.println(pseudoPalindromicPaths(getTestInput3()));//0
	}

	public static int pseudoPalindromicPaths(TreeNode root) {
		List<Map<Integer, Integer>> pathsFromRoot = new LinkedList<>();
		dfs(root, pathsFromRoot);
		return countPalindromes(pathsFromRoot);
	}

	private static void dfs(TreeNode root, List<Map<Integer, Integer>> pathsFromRoot) {
		if (root == null)
			return;
		dfs(root, true, null, pathsFromRoot);
	}

	private static void dfs(TreeNode node, boolean isRoot, Map<Integer, Integer> path,
			List<Map<Integer, Integer>> pathsFromRoot) {
		if (node == null) {
			return;
		}
		if (isRoot) {
			// left
			Map<Integer, Integer> path1 = new HashMap<>();
			path1.put(node.val, 1);
			dfs(node.left, false, path1, pathsFromRoot);
			// right
			Map<Integer, Integer> path2 = new HashMap<>();
			path2.put(node.val, 1);
			dfs(node.right, false, path2, pathsFromRoot);
			
			if (node.left == null && node.right == null) {
				pathsFromRoot.add(path1);
			}
			
		} else {

			Map<Integer, Integer> path1 = new HashMap<>();
			path1.putAll(path);
			path1.put(node.val, path1.getOrDefault(node.val, 0) + 1);

			Map<Integer, Integer> path2 = new HashMap<>();
			path2.putAll(path);
			path2.put(node.val, path2.getOrDefault(node.val, 0) + 1);

			if (node.left == null && node.right == null) {
				pathsFromRoot.add(path1);
			} else {
				dfs(node.left, false, path1, pathsFromRoot);
				dfs(node.right, false, path2, pathsFromRoot);
			}
		}

	}

	private static int countPalindromes(List<Map<Integer, Integer>> pathsFromRoot) {
		int count = 0;
		for (Map<Integer, Integer> path : pathsFromRoot) {
			if (hasSingleOddFreq(path))
				count++;
		}
		return count;
	}

	private static boolean hasSingleOddFreq(Map<Integer, Integer> path) {
		int singleOddFreq = 0;
		for (int val : path.values()) {
			if (val % 2 != 0)
				singleOddFreq++;
			if (singleOddFreq > 1)
				return false;
		}
		return true;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	private static TreeNode getTestInput1() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		return root;
	}

	private static TreeNode getTestInput2() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(1);
		return root;
	}
	
	private static TreeNode getTestInput3() {
		TreeNode root = new TreeNode(9);
		return root;
	}
}
