package com.hackerrank.datastructures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 The height of a binary tree is the number of nodes on the largest path from root to any leaf. You are given a pointer to the root of a binary tree. Return the height of the tree. 
 You only have to complete the function.

 Input Format

 You are given a function,

 int height_of_bt(node * root)
 {

 }
 Output Format

 Return a single value equal to the height of the binary tree.

 Sample Input

 3
 /   \
 5     2
 / \    /
 1   4  6
 /
 7
 Sample Output

 4
 Explanation

 The maximum length root to leaf path is 3->2->6->7. There are 4 nodes in this path. Therefore the height of the binary tree = 4.
 */
/**
 * 
 * @author Shrey
 *
 */
public class HeightOfBST {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String line = br.readLine();
		Node node = null;
		for (String s : line.split(" ")) {
			node = insert(node, Integer.valueOf(s));
		}
		height(node);
	}

	private static class Node {
		public int data;
		public Node left, right;

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right
					+ "]";
		}
	}

	/**
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	private static Node insert(Node root, int value) {
		if (root == null) {
			Node n = new Node();
			n.data = value;
			return n;
		}
		if (root.data > value) {
			// left
			root.left = insert(root.left, value);
		} else if (root.data < value) {
			// right
			root.right = insert(root.right, value);
		} else {
			root.data = value;
		}
		return root;
	}

	private static int height(Node root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}
}
