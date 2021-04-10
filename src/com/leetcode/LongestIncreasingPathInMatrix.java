package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
	}

	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int curr = dfs(matrix, i, j, m, n, dp);
				max = Math.max(max, curr);
			}
		}
		return max;
	}

	public static int dfs(int[][] mat, int i, int j, int m, int n, int[][] dp) {
		if (dp[i][j] != 0)
			return dp[i][j];
		int initialLen = 1;

		for (int[] dir : dirs) {
			int nextI = i + dir[0];
			int nextJ = j + dir[1];
			if (nextI >= m || nextJ >= n || nextI < 0 || nextJ < 0 || mat[i][j] >= mat[nextI][nextJ])
				continue;
			initialLen = Math.max(initialLen, 1 + dfs(mat, nextI, nextJ, m, n, dp));
		}
		dp[i][j] = initialLen;
		return initialLen;
	}

}
