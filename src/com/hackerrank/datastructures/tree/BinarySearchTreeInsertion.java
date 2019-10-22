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

	static Node leastCommonAncestor(Node root, int v1, int v2) {
		if (root == null)
			return null;
		Node p1 = findParent(root, v1);
		Node p2 = findParent(root, v2);
		if (p2.data == v1)
			return p2;
		if (p1.data == p2.data)
			return p1;
		while (p1.data != p2.data) {
			p1 = findParent(root, p1.data);
			p2 = findParent(root, p2.data);
		}
		return p1;
	}

	static Node findParent(Node root, int val) {
		if (root == null)
			return null;
		if (root.data > val) {
			if (root.left != null && root.left.data == val)
				return root;
			return findParent(root.left, val);
		} else if (root.data < val) {
			if (root.right != null && root.right.data == val)
				return root;
			return findParent(root.right, val);
		} else {
			return root;
		}
	}

	static boolean find(Node n, int data) {
		if (n == null)
			return false;
		if (n.data > data) {
			// search in left child
			return find(n.left, data);
		} else if (n.data < data) {
			// search in right child
			return find(n.right, data);
		} else if (n.data == data) {
			// root
			return true;
		} else {
			// not found in tree
			return false;
		}
	}

	boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (min > root.data || max < root.data)
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

	/**
	 * Delete a node the tree with value n. Its O(lgn)
	 * 
	 * @param n
	 * @return
	 */
	static boolean delete(Node root, int data, boolean val) {
		if (root == null)
			return false;
		if (!find(root, data))
			return false;
		root = delete(root, data);
		return true;
	}

	private static Node delete(Node root, int data) {
		Node p, p2, n;
		if (root.data == data) {
			Node lt, rt;
			lt = root.left;
			rt = root.right;
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.left != null)
					p = p.left;
				p.left = lt;
				return p2;
			}
		}
		if (data < root.data) {
			n = delete(root.left, data);
			root.left = n;
		} else {
			n = delete(root.right, data);
			root.right = n;
		}
		return root;
	}

}
