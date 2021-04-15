package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class InorderSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode successor, int key) {
		if (root == null)
			return null;
		if (root.val == key) {// if node found with the key, the successor is the minimum value node in its
								// right subtree (if any)
			if (root.right != null)
				return findLeftMost(root.right);
		} else if (root.val > key) {// if the given key is less than the root node, recur for the left subtree
			successor = root;
			return inorderSuccessor(root.left, successor, key);
		} else {
			// if the given key is more than the root node, recur for the right subtree
			return inorderSuccessor(root.right, successor, key);
		}
		return successor;
	}

	private TreeNode findLeftMost(TreeNode root) {
		TreeNode leftMost = root;
		while (leftMost.left != null) {
			leftMost = leftMost.left;
		}
		return leftMost;
	}

	private class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
