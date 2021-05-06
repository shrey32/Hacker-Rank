package com.crackingthecodinginterview;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] mat = spiral(4);
		print(mat);
	}

	public static int[][] spiral(int n) {
		int[][] mat = new int[n][n];
		int init = n;
		StringBuilder pattern = new StringBuilder(init + "");
		while (--init > 0) {
			for (int i = 0; i < 2; i++)
				pattern.append(init);
		}
		System.out.println(pattern);
		int row = 0, col = 0;
		boolean isRow = true;
		boolean isRight = true;
		boolean isDown = true;
		int val = 1;
		for (int i = 0; i < pattern.length(); i++) {
			int len = Character.digit(pattern.charAt(i), 10);
			for (int j = 0; j < len; j++) {
				if (isRow && isRight) {
					// coord.add(Arrays.asList(row, col++));
					mat[row][col++] = val++;
					if (j + 1 == len) {
						isDown = true;
						col--;
						row++;
					}
				} else if (!isRow && isDown) {
					mat[row++][col] = val++;
					if (j + 1 == len) {
						isRight = false;
						row--;
						col--;
					}
				} else if (isRow && !isRight) {
					mat[row][col--] = val++;
					if (j + 1 == len) {
						isDown = false;
						col++;
						row--;
					}
				} else if (!isRow && !isDown) {
					mat[row--][col] = val++;
					if (j + 1 == len) {
						isRight = true;
						row++;
						col++;
					}
				}
			}
			isRow = !isRow;
		}

		return mat;
	}

	public static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
}
