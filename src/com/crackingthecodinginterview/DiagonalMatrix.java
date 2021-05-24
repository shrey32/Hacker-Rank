package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class DiagonalMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		diagonalMatrix(mat);
		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		diagonalMatrix(mat);
		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		diagonalMatrix(mat);
		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
		diagonalMatrix(mat);
	}

	private static void diagonalMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int i = 0, j = 0;
		int k = 0;
		while (k < m * n) {
			int tempi = i;
			int tempj = j;
			while (tempi >= 0 && tempi < m && tempj >= 0 && tempj < n) {
				System.out.print(mat[tempi][tempj] + " ");
				tempi++;
				tempj--;
				k++;
			}
			System.out.println();
			if (j + 1 >= n) {
				i++;
			} else if (tempj < 0) {
				j++;
			}
		}
		System.out.println();
	}

}
