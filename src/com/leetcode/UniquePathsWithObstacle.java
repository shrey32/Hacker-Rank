package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class UniquePathsWithObstacle {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					continue;
				if (i == 0 && j > 0 && dp[i][j - 1] == 0)
					continue;
				if (j == 0 && i > 0 && dp[i - 1][j] == 0)
					continue;
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

}
