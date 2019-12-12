package com.hackerrank.advanced;

import java.util.Scanner;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/lazy-white-falcon/problem">Lazy White
 * Falcon</a>
 * 
 * @author Shrey
 *
 */
public class LazyWhiteFalcon {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		Graph g = new Graph(n);
		for (int k = 0; k < n - 1; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			g.addEdge(i, j);
		}
		for (int i = 0; i < q; i++) {
			int identifier = scan.nextInt();
			int u = scan.nextInt();
			int v = scan.nextInt();
			if (identifier == 1) {
				g.assignValue(u, v);
			} else if (identifier == 2) {
				System.out.println(g.sumOfConnectedNodes(u, v));
			}
		}
		scan.close();
	}

	private static class Node {
		int value;
		boolean connected = false;

		public Node(int value, boolean connected) {
			this.value = value;
			this.connected = connected;
		}
	}

	private static class Graph {
		private Node[][] matrix;
		private int numVertices;

		public Graph(int numVertices) {
			this.numVertices = numVertices;
			matrix = new Node[numVertices][numVertices];
		}

		public void addEdge(int i, int j) {
			matrix[i][j] = new Node(0, true);
			matrix[j][i] = new Node(0, true);
		}

		public void assignValue(int u, int v) {
			for (int j = 0; j < numVertices; j++) {
				if (matrix[j][u] != null && matrix[j][u].connected) {
					matrix[j][u].value = v;
					break;
				}
			}
		}

		public int sumOfConnectedNodes(int start, int end) {
			boolean[] visited = new boolean[numVertices];
			int sum = 0;
			for (int v = start; v <= end; v++) {
				if (!visited[v]) {
					sum += dfs(v, visited);
				}
			}
			return sum;
		}

		private int dfs(int v, boolean[] visited) {
			int sum = 0;
			for (int i = 0; i < this.numVertices; i++) {
				if (this.matrix[v][i] != null && this.matrix[v][i].connected && !visited[i]) {
					visited[i] = true;
					sum += this.matrix[v][i].value + dfs(i, visited);
				}
			}
			return sum;
		}
	}

}
