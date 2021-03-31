package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
		setZeroes(new int[][] { { 1, 1, 1, 5 }, { 1, 1, 1, 5 }, { 1, 0, 1, 5 }, { 1, 1, 1, 5 } });
		setZeroes(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 }, { 1, 3, 1, 5 } });
	}

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean rowFlag = false;
		boolean colFlag = false;

		// any zeroes exists in 1st element of every row
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				rowFlag = true;
				break;
			}
		}
		// any zeroes exists in 1st element of every column
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				colFlag = true;
				break;
			}
		}

		// mark first element of row and column as 0
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// update rows as 0
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// update column as 0
		for (int j = 0; j < n; j++) { // column
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int i = 1; i < m; i++) {
				matrix[i][0] = 0;
			}
			for (int j = 1; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

		if (rowFlag) {
			for (int k = 0; k < m; k++) {
				matrix[k][0] = 0;
			}
		}

		if (colFlag) {
			for (int k = 0; k < n; k++) {
				matrix[0][k] = 0;
			}
		}

		print(matrix);
	}

	public static void print(int[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
