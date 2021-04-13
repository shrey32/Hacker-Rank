package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class PathExistBetweenTwoNodesInDirectedGraph {

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdge(0, 3);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 7);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 3);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		System.out.println(graph.isPathExist(0, 7));
		System.out.println(graph.isPathExist(0, 1));
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
		}

		public boolean isPathExist(int src, int dest) {
			boolean[] visited = new boolean[numVertices];
			for (int k = 0; k < numVertices; k++) {
				if (visited[k])
					continue;
				boolean exist = isPathExist(k, dest, visited);
				if (exist)
					return true;
			}
			return false;
		}

		public boolean isPathExist(int v, int dest, boolean[] visited) {
			visited[v] = true;
			for (int i = 0; i < numVertices; i++) {
				if (this.matrix[v][i] && !visited[i]) {
					if (i == dest && this.matrix[v][i])
						return true;
					boolean exists = isPathExist(i, dest, visited);
					if (exists)
						return true;
				}
			}
			return false;
		}

	}

}
