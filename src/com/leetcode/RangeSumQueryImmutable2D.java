package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RangeSumQueryImmutable2D {

	public static void main(String[] args) {
		NumMatrix numMatrix = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
				{ 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));// 8
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));// 11
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));// 12
	}

	private static class NumMatrix {

		private int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;
			int row = matrix.length;
			int col = matrix[0].length;
			dp = new int[row + 1][col + 1];
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					dp[i][j] = dp[i][j - 1] + matrix[i - 1][j - 1];
				}
			}

		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (dp == null)
				return 0;
			int sum = 0;
			for (int i = row1; i <= row2; i++)
				sum += dp[i + 1][col2 + 1] - dp[i + 1][col1];
			return sum;
		}
	}

}
