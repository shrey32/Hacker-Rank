package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePathsDP(2, 2)); // 2
		System.out.println(uniquePathsDP(3, 2)); // 2
		System.out.println(uniquePathsDP(23, 12)); // 2
		// System.out.println(uniquePaths(3, 2)); // 3
		// System.out.println(uniquePaths(23, 12)); // 3
	}

	public static int uniquePaths(int m, int n) {

		Queue<Cordinate> queue = new LinkedList<>();
		queue.add(new Cordinate(1, 1));
		int count = 0;
		while (!queue.isEmpty()) {

			Cordinate cord = queue.poll();
			if (cord.i == n && cord.j == m) {
				count++;
			}

			if (cord.j + 1 < m + 1) // right
				queue.add(new Cordinate(cord.i, cord.j + 1));

			if (cord.i + 1 < n + 1) // down
				queue.add(new Cordinate(cord.i + 1, cord.j));

		}
		return count;
	}

	public static int uniquePathsDP(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	private static class Cordinate {
		int i, j;

		public Cordinate(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public String toString() {
			return "[" + i + "," + j + "]";
		}
	}

}
