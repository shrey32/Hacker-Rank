package com.hackerrank.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/lazy-white-falcon/problem">Lazy White
 * Falcon</a>
 * 
 * @author Shrey
 *
 */
public class LazyWhiteFalconOptimized {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		Map<Integer, Node> map = new HashMap<>(n);
		for (int k = 0; k < n - 1; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			Node parent = map.get(i);
			if (parent == null) {
				parent = new Node(0);
				map.put(i, parent);
			}
			Node child = map.get(j);
			if (child == null) {
				child = new Node(0);
				map.put(j, child);
			}
			parent.children.put(j, child);
			child.children.put(i, parent);
		}
		Map<Pair, Integer> result = new HashMap<>(q);
		for (int i = 0; i < q; i++) {
			int identifier = scan.nextInt();
			int u = scan.nextInt();
			int v = scan.nextInt();
			if (identifier == 1) {
				map.get(u).value = v;
			} else if (identifier == 2) {
				int s = Math.min(u, v);
				int e = Math.max(u, v);
				Pair p = new Pair(s, e);
				if (result.containsKey(p))
					System.out.println(result.get(p));
				else {
					int sum = 0;
					Node start = null;
					for (int j = s; j <= e; j++) {
						if (start == null)
							start = map.get(j);
						else if (start.children.containsKey(j))
							start = start.children.get(j);
						sum += start.value;
					}
					result.put(p, sum);
					System.out.println(sum);
				}
			}
		}
		scan.close();
	}

	private static class Pair {
		int u, v;

		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + u;
			result = prime * result + v;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (u != other.u)
				return false;
			if (v != other.v)
				return false;
			return true;
		}

	}

	private static class Node {
		int value;
		Map<Integer, Node> children = new HashMap<>();

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "(" + value + ",{" + children + "})";
		}
	}

}
