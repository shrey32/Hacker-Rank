package com.leetcode;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.LinkedHashMap;

/**
 * @author Shrey
 * 
 */
public class VerticalOrderTraversalOfABinaryTree {

	public static void main(String[] args) {
		System.out.println(verticalTraversal(input1()));
		System.out.println(verticalTraversal(input2()));
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null)
			return Arrays.asList();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Point> coordinates = new LinkedList<>();
		List<Point> points = new LinkedList<>();
		queue.add(root);
		coordinates.add(new Point(root.val, 0, 0));

		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();
			Point pos = coordinates.poll();
			points.add(pos);

			if (temp.left != null) {
				queue.add(temp.left);
				coordinates.add(new Point(temp.left.val, pos.x - 1, pos.y - 1));
			}

			if (temp.right != null) {
				queue.add(temp.right);
				coordinates.add(new Point(temp.right.val, pos.x + 1, pos.y - 1));
			}
		}

		return new ArrayList<>(points.stream().sorted((a, b) -> {
			return new Integer(a.x).compareTo(b.x);
		}).collect(Collectors.groupingBy(Point::getX, LinkedHashMap::new,
				Collectors.mapping(Point::getVal, Collectors.toList()))).values());

	}

	public static class Point {
		private int val, x, y;

		public Point(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getVal() {
			return val;
		}

		@Override
		public String toString() {
			return "[" + val + "(" + x + "," + y + ")]";
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}

	private static TreeNode input1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}

	private static TreeNode input2() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}

}
