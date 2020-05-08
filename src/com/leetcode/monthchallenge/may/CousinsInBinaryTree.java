package com.leetcode.monthchallenge.may;

/**
 * <b>Cousins in Binary Tree</b>
 * <p>
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * </p>
 * 
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * </p>
 * 
 * <p>
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * </p>
 * 
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * </p>
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * 
 * <p>
 * <b>Input:</b> root = [1,2,3,4], x = 4, y = 3
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * <b>Example 2:</b>
 * 
 * 
 * <p>
 * <b>Input:</b> root = [1,2,3,null,4,null,5], x = 5, y = 4
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * <b>Example 3:</b>
 * 
 * 
 * 
 * <p>
 * <b>Input:</b> root = [1,2,3,null,4], x = 2, y = 3
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * 
 * 
 * <b>Note:</b>
 * 
 * <li>The number of nodes in the tree will be between 2 and 100.</li>
 * <li>Each node has a unique integer value from 1 to 100.</li>
 * 
 * @author Shrey
 *
 */
public class CousinsInBinaryTree {

	TreeNode xParent = null, yParent = null;
	int xDepth = -1, yDepth = -2;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null, x, y, 0);
		return xDepth == yDepth && xParent != yParent;
	}

	private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
		if (root == null)
			return;
		if (x == root.val) {
			xParent = parent;
			xDepth = depth;
		} else if (y == root.val) {
			yParent = parent;
			yDepth = depth;
		} else {
			// if we found x node or found y node then we don't need to dfs deeper
			// because x and y must be the same depth
			dfs(root.left, root, x, y, depth + 1);
			dfs(root.right, root, x, y, depth + 1);
		}
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
