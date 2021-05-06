package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class PondSizes {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
		System.out.println(pondSizes(mat));
	}

	public static List<Integer> pondSizes(int[][] mat) {
		List<Integer> sizes = new ArrayList<>();
		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					int count = traverse(i, j, m, n, mat);
					if (count != 0)
						sizes.add(count);
				}
			}
		}

		return sizes;
	}

	public static int traverse(int i, int j, int m, int n, int[][] mat) {
		if (i < 0 || j < 0 || i >= m || j >= n || mat[i][j] != 0) {
			return 0;
		}
		mat[i][j] = -1;
		int size = 1;
		size += traverse(i, j + 1, m, n, mat);
		size += traverse(i, j - 1, m, n, mat);
		size += traverse(i + 1, j, m, n, mat);
		size += traverse(i + 1, j - 1, m, n, mat);
		size += traverse(i + 1, j + 1, m, n, mat);
		return size;
	}
}
