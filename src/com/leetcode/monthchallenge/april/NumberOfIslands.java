package com.leetcode.monthchallenge.april;

/**
 * 
 * <b>Number of Islands</b>
 * 
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b><br>
 * 11110<br>
 * 11010<br>
 * 11000<br>
 * 00000<br>
 * 
 * <p>
 * <b>Output:</b>1
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b><br>
 * 11000<br>
 * 11000<br>
 * 00100<br>
 * 00011<br>
 * 
 * <p>
 * <b>Output:</b>3
 * </p>
 * 
 * @author Shrey
 *
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(numIslands(grid));
		// 2
		int[][] grid1 = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(numIslands(grid1));
	}

	public static int numIslands(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, row, col, grid, visited);
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int i, int j, int row, int col, int[][] grid, boolean[][] visited) {
		if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || grid[i][j] != 1)
			return;

		visited[i][j] = true;

		dfs(i, j + 1, row, col, grid, visited);
		dfs(i + 1, j, row, col, grid, visited);
		dfs(i, j - 1, row, col, grid, visited);
		dfs(i - 1, j, row, col, grid, visited);
	}

}
