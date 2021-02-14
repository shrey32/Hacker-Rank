package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class IsGraphBipartite {

	public static void main(String[] args) {
		System.out.println(isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }));// false;
		System.out.println(isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));// true;
	}

	public static boolean isBipartite(int[][] graph) {
		int len = graph.length;
		int[] color = new int[len];

		Arrays.fill(color, -1);

		for (int i = 0; i < len; i++) {
			if (color[i] == -1) {
				color[i] = 1;
				if (!dfs(i, graph, color)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(int index, int[][] graph, int[] color) {
		int currentColor = color[index];

		for (int connectingIndex : graph[index]) {
			if (color[connectingIndex] == currentColor) {
				return false;
			}
			if (color[connectingIndex] == -1) {
				color[connectingIndex] = 1 - currentColor;
				if (!dfs(connectingIndex, graph, color)) {
					return false;
				}
			}
		}
		return true;
	}

}