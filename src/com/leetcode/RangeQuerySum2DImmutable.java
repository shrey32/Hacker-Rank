package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class RangeQuerySum2DImmutable {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		maxSubMatrix(mat);
	}

	public static void maxSubMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + mat[i][j] - dp[i][j];
			}
		}
		int[][] queries = { { 2, 1, 4, 3 }, { 1, 1, 2, 2 }, { 1, 2, 2, 4 } };

		for (int[] query : queries) {
			System.out.println(sumRegion(dp, query[0], query[1], query[2], query[3]));
		}
	}

	public static int sumRegion(int[][] dp, int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}

}
