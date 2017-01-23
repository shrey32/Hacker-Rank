package com.hackerrank.datastructures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Shrey
 *
 */
public class BinarySearchTreeInsertion {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		Node node = null;
		for (String s : line.split(" ")) {
			node = Insert(node, Integer.valueOf(s));
		}
		n = Integer.parseInt(br.readLine());
		node = Insert(node, n);
		System.out.println(node);
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

	private static Node Insert(Node root, int value) {
		if (root == null) {
			Node n = new Node();
			n.data = value;
			return n;
		}
		if (root.data > value) {
			// left
			root.left = Insert(root.left, value);
		} else if (root.data < value) {
			// right
			root.right = Insert(root.right, value);
		} else {
			root.data = value;
		}
		return root;
	}

	boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;
		return (checkBST(root.left, min, root.data - 1) && checkBST(root.right,
				root.data + 1, max));
	}
}
