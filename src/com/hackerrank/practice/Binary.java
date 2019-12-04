package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/G11/">G11 - Binary</a>
 * 
 * @author Shrey
 *
 */
public class Binary {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		Binary b = new Binary();
		for (char c : s.toCharArray()) {
			b.root = b.insert(b.root, c);
		}
		b.inOrder();
		b.preOrder();
		b.postOrder();
		scan.close();
	}

	private Node root;

	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}

	private void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print((char)root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * 
	 */
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

	private void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print((char)root.data);
	}

	/**
	 * process left,process root, process right subtree
	 */
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}

	private void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print((char)root.data);
		inOrder(root.right);
	}

	int height(Node n) {
		if (n == null)
			return 0;
		return n.height;
	}

	// Get Balance factor of node N
	int getHeightDifference(Node n) {
		if (n == null)
			return 0;
		return height(n.left) - height(n.right);
	}

	Node rotateRight(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	Node rotateLeft(Node n) {
		Node y = n.right;
		Node t2 = y.left;

		// Perform rotation
		y.left = n;
		n.right = t2;

		// Update heights
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	Node insert(Node node, int data) {
		if (node == null)
			return (new Node(data));
		if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		else
			return node;

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int diff = getHeightDifference(node);

		if (diff > 1 && data < node.left.data)
			return rotateRight(node);
		if (diff < -1 && data > node.right.data)
			return rotateLeft(node);
		if (diff > 1 && data > node.left.data) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (diff < -1 && data < node.right.data) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	class Node {
		int data, height = 1;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

}
