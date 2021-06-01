package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] > 0) {
					// System.out.println("curr=>"+curr);
					max = Math.max(max, dfs(grid, i, j, m, n));
				}
			}
		}
		return max;
	}

	private static int dfs(int[][] grid, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] < 1)
			return 0;
		grid[i][j] = 0;
		return 1 + dfs(grid, i + 1, j, m, n) + dfs(grid, i, j + 1, m, n) + dfs(grid, i - 1, j, m, n)
				+ dfs(grid, i, j - 1, m, n);
	}

}
