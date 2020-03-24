package com.leetcode;

public class NumberOfIslands {

	public static void main(String[] args) {
		// 1
		int[][] grid = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(numberOfIslands(grid));
		// 2
		int[][] grid1 = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(numberOfIslands(grid1));
	}

	public static int numberOfIslands(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] visited = new boolean[r][c];
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					dfs(grid, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == 0)
			return;
		visited[i][j] = true;
		dfs(grid, visited, i, j + 1);
		dfs(grid, visited, i + 1, j);
		dfs(grid, visited, i, j - 1);
		dfs(grid, visited, i - 1, j);
	}

}
