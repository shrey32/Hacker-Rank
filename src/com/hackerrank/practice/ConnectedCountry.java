package com.hackerrank.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/CONGRAPH/">CONGRAPH - Connected
 * country</a>
 * 
 * @author Shrey
 *
 */
public class ConnectedCountry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		List<Node> graphs = new ArrayList<>();
		Map<Integer, Node> map = new HashMap<>(n);
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			Node found = map.get(a);
			if (found == null)
				found = find(graphs, a);
			if (found == null) {
				found = getNode(a);
				found.left = getNode(b);
				graphs.add(found);
				map.put(a, found);
			} else if (found != null) {
				if (found.left == null) {
					found.left = getNode(b);
					map.put(b, found.left);
				}else if (found.right == null) {
					found.right = getNode(b);
					map.put(b, found.right);
				}
			}
		}
		System.out.println(graphs.size() - 1);
		scan.close();
	}

	private static Node find(List<Node> graphs, int data) {
		if (graphs.isEmpty())
			return null;

		for (Node root : graphs) {
			Node found = find(root, data);
			if (found != null)
				return found;
		}
		return null;
	}

	private static final Node find(Node root, int data) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node temp = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.data == data)
				return temp;

			if (temp.left != null)
				queue.add(temp.left);

			if (temp.right != null)
				queue.add(temp.right);
		}
		return null;
	}

	private static Node getNode(int data) {
		Node n = new Node(data);
		return n;
	}

	private static final class Node {

		int data = -1;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}
	}

}
