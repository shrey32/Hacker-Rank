package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(mat);
		print(mat);
	}

	public static void rotate(int[][] mat) {
		transpose(mat);
		// reverse rows
		reverse(mat);
	}

	// rows to column
	private static void transpose(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = i; j < mat[i].length; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}

	private static void reverse(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			int len = mat[i].length;
			for (int j = 0, k = len - 1; j < len / 2; j++, k--) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][k];
				mat[i][k] = temp;
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
