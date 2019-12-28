package com.spoj.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SalesCost {

	public static void main(String[] args) {
		System.out.println(getCheapestCost(input1()));// 7
		System.out.println(getCheapestCost(input2()));// 7
	}

	private static final int getCheapestCost(Node root) {
		if (root == null)
			return 0;
		if (root.children.isEmpty())
			return root.cost;
		int cheapestCost = Integer.MAX_VALUE;
		int sum = root.cost;
		for (int i = 0; i < root.children.size(); i++) {
			Node curr = root.children.get(i);
			sum += getCheapestCost(curr);
			cheapestCost = Math.min(cheapestCost, sum);
			sum = root.cost;
		}
		return cheapestCost;
	}

	private static class Node {
		int cost = 0;
		final List<Node> children;

		public Node(int cost) {
			this.cost = cost;
			this.children = new ArrayList<>();
		}
	}

	private static final Node input1() {
		Node root = new Node(0);
		root.children.add(new Node(5));// 1st level
		root.children.add(new Node(3));
		root.children.add(new Node(6));
		/// --
		root.children.get(0).children.add(new Node(4));// 2nd level
		root.children.get(1).children.add(new Node(2));// 2nd level
		root.children.get(1).children.add(new Node(0));// 2nd level
		root.children.get(2).children.add(new Node(1));// 2nd level
		root.children.get(2).children.add(new Node(5));// 2nd level
		root.children.get(1).children.get(0).children.add(new Node(1));// 3rd level
		root.children.get(1).children.get(1).children.add(new Node(10));// 3rd level
		root.children.get(1).children.get(0).children.get(0).children.add(new Node(1));// 4th level
		return root;
	}

	private static final Node input2() {
		Node root = new Node(20);
		root.children.add(new Node(9));// 1st level
		root.children.add(new Node(25));
		/// --
		root.children.get(0).children.add(new Node(5));// 2nd level
		root.children.get(0).children.add(new Node(12));// 2nd level
		root.children.get(0).children.get(1).children.add(new Node(11));
		root.children.get(0).children.get(1).children.add(new Node(14));
		return root;
	}

}
