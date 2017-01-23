package com.hackerrank.datastructures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

	void topView(Node root) {
		if (root == null)
			return;
		topView(root.left, true);
		System.out.print(root.data + " ");
		topView(root.right, false);
	}

	void topView(Node root, boolean toLeft) {
		if (root == null)
			return;
		if (toLeft) {
			topView(root.left, toLeft);
			System.out.print(root.data + " ");
		} else {
			System.out.print(root.data + " ");
			topView(root.right, toLeft);
		}
	}

	void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.print(tmp.data + " ");
			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
	}
}
