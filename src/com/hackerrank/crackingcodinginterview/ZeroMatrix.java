package com.hackerrank.crackingcodinginterview;

/**
 * 
 * <p>
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 * </p>
 * 
 * @author Shrey
 *
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		zeroMatrix(mat);
		print(mat);
		System.out.println();
		mat = new int[][] { { 1, 1, 1, 5 }, { 1, 1, 1, 5 }, { 1, 0, 1, 5 }, { 1, 1, 1, 5 } };
		zeroMatrix(mat);
		print(mat);
		System.out.println();
		mat = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 }, { 1, 3, 1, 5 } };
		zeroMatrix(mat);
		print(mat);
	}

	public static void zeroMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		boolean hasZeroInRow = false;
		boolean hasZeroInColumn = false;

		for (int i = 1; i < m; i++) {
			if (mat[i][0] == 0) {
				hasZeroInRow = true;
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			if (mat[0][i] == 0) {
				hasZeroInColumn = true;
				break;
			}
		}

		// update first row & column once we find zero in any other row and column
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[0][j] = 0;
					mat[i][0] = 0;
				}
			}
		}

		// update entire row
		for (int i = 1; i < m; i++) {
			if (mat[i][0] == 0) {
				for (int j = 1; j < n; j++)
					mat[i][j] = 0;
			}
		}

		// update entire column if any element in a row is 0
		for (int j = 0; j < n; j++) {
			if (mat[0][j] == 0) {
				for (int i = 1; i < m; i++)
					mat[i][j] = 0;
			}
		}

		if (mat[0][0] == 0) {
			for (int i = 0; i < m; i++) {
				mat[i][0] = 0;
			}
			for (int j = 0; j < n; j++) {
				mat[0][j] = 0;
			}
		}

		if (hasZeroInRow) {
			for (int k = 0; k < m; k++) {
				mat[k][0] = 0;
			}
		}

		if (hasZeroInColumn) {
			for (int k = 0; k < n; k++) {
				mat[0][k] = 0;
			}
		}
	}

	public static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
