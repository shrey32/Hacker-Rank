package com.hackerrank.practice;

import java.util.Scanner;

public class ConnectedCountryUsingGraph {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Graph g = new Graph(n);
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			g.addEdge(a, b);
		}
		System.out.println(g.numOfConnectedComponents() - 1);
		scan.close();
	}

	private static class Graph {
		private boolean[][] matrix;
		private int numVertices;

		public Graph(int numVertices) {
			this.numVertices = numVertices;
			matrix = new boolean[numVertices][numVertices];
		}

		public void addEdge(int i, int j) {
			matrix[i][j] = true;
			matrix[j][i] = true;
		}

		public int numOfConnectedComponents() {
			boolean[] visited = new boolean[numVertices];
			int count = 0;
			for (int v = 0; v < numVertices; v++) {
				if (!visited[v]) {
					dfs(v, visited);
					count++;
				}
			}
			return count;
		}

		private void dfs(int v, boolean[] visited) {
			visited[v] = true;
			for (int i = 0; i < this.numVertices; i++) {
				if (this.matrix[v][i] && !visited[i]) {
					dfs(i, visited);
				}
			}
		}
	}

}
