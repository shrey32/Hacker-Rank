package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class ConstructABinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int[] preIdx = { 0 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return buildTree(preorder, inorder, 0, inorder.length - 1, preIdx, map);
	}

	private static TreeNode buildTree(int[] pre, int[] in, int inStart, int inEnd, int[] preIdx,
			Map<Integer, Integer> map) {
		if (inStart > inEnd)
			return null;
		TreeNode curr = new TreeNode(pre[preIdx[0]++]);
		if (inStart == inEnd)
			return curr;
		int idx = map.get(curr.val);
		curr.left = buildTree(pre, in, inStart, idx - 1, preIdx, map);
		curr.right = buildTree(pre, in, idx + 1, inEnd, preIdx, map);
		return curr;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}
