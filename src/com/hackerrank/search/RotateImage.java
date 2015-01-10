package com.hackerrank.search;

/**
 * rotate NXN matrix by 90 degree
 */

/**
 * 
 * @author Shrey
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int N = 3;
		
		printMatrix(rotateMatrixBy90(matrix, N, N), N);
		System.out.println();
		printMatrix(rotateMatrixBy90(matrix, N), N);
	}

	// takes additional space
	private static int[][] rotateMatrixBy90(int[][] matrix, int row, int col) {
		int[][] matrix2 = new int[row][col];
		int b = col - 1;
		for (int i = 0; i < row; i++) {
			int a = 0;
			for (int j = 0; j < col; j++) {
				matrix2[a][b] = matrix[i][j];
				a++;
			}
			b--;
		}
		return matrix2;
	}

	private static int[][] rotateMatrixBy90(int[][] matrix, int N) {
		for (int i = 0; i < N / 2; i++) {
			int last = N - 1 - i;
			for (int j = i; j < last; j++) {
				int offset = j - i;
				int top = matrix[i][j];
				matrix[i][j] = matrix[last - offset][i];
				matrix[last - offset][i] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[j][last];
				matrix[j][last] = top;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
