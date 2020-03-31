package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		System.out.println(connect(testData1()));
	}

	public static List<Node> bfs(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<Node> nodeList = new ArrayList<>();
		nodeList.add(root);
		while (!queue.isEmpty()) {

			Node temp = queue.poll();

			if (temp.left != null) {
				queue.add(temp.left);
				nodeList.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
				nodeList.add(temp.right);
			}
		}

		return nodeList;
	}

	public static Node connect(Node root) {
		if (root == null)
			return null;
		List<Node> nodeList = bfs(root);
		int itr = 1;
		int level = 1;
		int limit = 2;
		int height = height(root);
		while (level++ < height) {
			for (int i = 0; i < limit - 1; i++) {
				Node left = nodeList.get(itr++);
				Node right = nodeList.get(itr);
				left.next = right;
			}
			limit *= 2;
			itr++;
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

	private static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node(int _val) {
			val = _val;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Queue<Node> queue = new LinkedList<>();
			queue.add(this);
			while (!queue.isEmpty()) {

				Node temp = queue.poll();
				sb.append(temp.val + " ");
				if (temp.next != null)
					System.out.println(temp.val + "'s next is " + temp.next.val);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

			return sb.toString();
		}
	}

	private static Node testData1() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(root);
		return root;
	}
}
