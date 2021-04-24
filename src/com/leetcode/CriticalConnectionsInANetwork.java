package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class CriticalConnectionsInANetwork {

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (List<Integer> connection : connections) {
			int u = connection.get(0);
			int v = connection.get(1);
			if (!graph.containsKey(u))
				graph.put(u, new LinkedList<>());
			if (!graph.containsKey(v))
				graph.put(v, new LinkedList<>());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int[] rank = new int[n];
		for (int i = 0; i < n; ++i) {
			rank[i] = i;
		}
		List<List<Integer>> res = new LinkedList<>();
		boolean[] visited = new boolean[n];
		dfs(visited, rank, -1, 0, 0, graph, res);
		return res;
	}

	public void dfs(boolean[] visited, int[] rank, int prev, int curr, int currRank, Map<Integer, List<Integer>> graph,
			List<List<Integer>> res) {
		rank[curr] = currRank;
		visited[curr] = true;
		for (int next : graph.get(curr)) {
			if (next == prev)
				continue;
			if (!visited[next])
				dfs(visited, rank, curr, next, currRank + 1, graph, res);
			rank[curr] = Math.min(rank[curr], rank[next]);
			if (rank[next] == currRank + 1) {
				res.add(Arrays.asList(curr, next));
			}
		}
	}

}
