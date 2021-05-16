package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class RouteBetweenTwoNodes {

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(2, 4);
		System.out.println("[0,4]=>"+graph.isRouteExist(0, 4));// false
		System.out.println("[1,5]=>"+graph.isRouteExist(1, 5));// true
		System.out.println("[2,4]=>"+graph.isRouteExist(2, 4));// true
		System.out.println("[1,2]=>"+graph.isRouteExist(1, 2));// false
		graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(5, 4);
		System.out.println("[0,4]=>"+graph.isRouteExist(0, 4));// true
		System.out.println("[3,4]=>"+graph.isRouteExist(3, 4));// true
		System.out.println("[4,0]=>"+graph.isRouteExist(4, 0));// true
	}

	private static class Graph {
		private int v;

		private List<List<Integer>> adjList = new ArrayList<>();

		public Graph(int v) {
			this.v = v;
			for (int i = 0; i < v; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		public void addEdge(int u, int w) {
			this.adjList.get(u).add(w);
			this.adjList.get(w).add(u);
		}

		public boolean isRouteExist(int start, int end) {
			boolean[] visited = new boolean[this.v];
			List<Integer> nodes = adjList.get(start);
			for (int node : nodes) {
				if (!visited[node]) {
					dfs(node, visited, end);
				}
			}
			return visited[end];
		}

		private void dfs(int n, boolean[] visited, int end) {
			visited[n] = true;
			if (end == n)
				return;
			for (int node : adjList.get(n)) {
				if (!visited[node]) {
					dfs(node, visited, end);
				}
			}
		}
	}

}
