package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		print(rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}

	public static int[][] rotate(int[][] matrix) {

		int n = matrix.length;

		// row to columns
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			reverse(matrix[i]);
		}
		return matrix;
	}

	private static void reverse(int[] ar) {
		for (int i = 0; i < ar.length / 2; i++) {
			int temp = ar[i];
			ar[i] = ar[ar.length - 1 - i];
			ar[ar.length - 1 - i] = temp;
		}
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
