package com.hackerrank.datastructures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given a pointer to the root of a binary tree; print the values in post-order traversal.

 You only have to complete the function.

 Input Format 
 You are given a function,

 void Postorder(node *root) {

 }
 Output Format 
 Print the values on a single line separated by space.

 Sample Input

 3
 /   \
 5     2
 / \    /
 1   4  6
 Sample Output

 1 4 5 6 2 3
 */
/**
 * 
 * @author Shrey
 *
 */
public class PostOrderTraversal {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String line = br.readLine();
		Node node = null;
		for (String s : line.split(" ")) {
			node = insert(node, Integer.valueOf(s));
		}
		postOrderTraversal(node);
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

	private static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}
}
