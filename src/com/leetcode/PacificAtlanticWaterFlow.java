package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class PacificAtlanticWaterFlow {

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> ans = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ans;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] pacToAtl = new boolean[m][n];
		boolean[][] atlToPac = new boolean[m][n];

		for (int j = 0; j < n; j++) {
			dfs(0, j, matrix, pacToAtl, Integer.MIN_VALUE);
			dfs(m - 1, j, matrix, atlToPac, Integer.MIN_VALUE);
		}

		for (int i = 0; i < m; i++) {
			dfs(i, 0, matrix, pacToAtl, Integer.MIN_VALUE);
			dfs(i, n - 1, matrix, atlToPac, Integer.MIN_VALUE);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacToAtl[i][j] && atlToPac[i][j]) {
					ans.add(Arrays.asList(i, j));
				}
			}
		}
		return ans;
	}

	public void dfs(int i, int j, int[][] matrix, boolean[][] path, int lastHeight) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n || path[i][j] || matrix[i][j] < lastHeight)
			return;

		path[i][j] = true;
		dfs(i + 1, j, matrix, path, matrix[i][j]);
		dfs(i - 1, j, matrix, path, matrix[i][j]);
		dfs(i, j + 1, matrix, path, matrix[i][j]);
		dfs(i, j - 1, matrix, path, matrix[i][j]);
	}
}
