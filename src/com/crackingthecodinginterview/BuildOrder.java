package com.crackingthecodinginterview;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class BuildOrder {

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		// directed graph
		graph.addEdge(4, 1);// d->a
		graph.addEdge(2, 6);// b->f
		graph.addEdge(4, 2);// d->b
		graph.addEdge(1, 6);// a->f
		graph.addEdge(5, 5);// e->e
		graph.addEdge(3, 4);// c->d
		System.out.println(graph.findOrder()); //[f,e,a,b,d,c][6,5,1,2,4,3]
	}

	private static class Graph {

		private int vertices;
		private List<List<Integer>> adjList;

		public Graph(int vertices) {
			this.vertices = vertices;
			this.adjList = new ArrayList<>();
			for (int i = 0; i <= vertices; i++) {
				this.adjList.add(i, new ArrayList<>());
			}
		}

		public void addEdge(int src, int dest) {
			this.adjList.get(src).add(dest);
		}

		public List<Integer> findOrder() {
			boolean[] visited = new boolean[this.vertices + 1];
			List<Integer> order = new ArrayList<>();
			for (int i = 1; i <= this.vertices; i++) {
				if (!visited[i]) {
					dfs(i, visited, order);
				}
			}
			return order;
		}

		public void dfs(int i, boolean[] visited, List<Integer> order) {
			visited[i] = true;
			for (int ver : this.adjList.get(i)) {
				if (!visited[ver]) {
					dfs(ver, visited, order);
				}
			}
			order.add(i);
		}

	}

}
