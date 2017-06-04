package com.hackerrank.warmup;

/**
 * 
 * @author Shrey
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int n = 8;
		int[][] ar = new int[n][n];
		for (int i = 0, count = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ar[i][j] = count++;
			}
		}
		print(ar, n);
		System.out.println();
		spiralMatrix(ar, n);
	}

	public static void print(int[][] ar, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void spiralMatrix(int[][] ar, int n) {
		int count = 0, i = 0, j = 0, i1 = 0, j1 = 0, rowc = 0, colc = 0;
		while (count < (n * n)) {
			if (i + 1 < (n - rowc)) {
				System.out.print(ar[i][j] + " ");
				i++;
				i1 = i;
				count++;
			} else if (j + 1 < (n - colc)) {
				System.out.print(ar[i][j] + " ");
				j++;
				j1 = j;
				count++;
			} else if (i1 - 1 >= (0 + rowc)) {
				System.out.print(ar[i1][j1] + " ");
				i1--;
				count++;
			} else if (j1 - 1 >= (0 + colc)) {
				System.out.print(ar[i1][j1] + " ");
				j1--;
				count++;
			} else {
				if (n % 2 != 0 && rowc == ((n - 1) / 2)) {
					count++;
					System.out.print(ar[rowc][colc]);
				}
				rowc++;
				colc++;
				i = rowc;
				j = colc;
			}
		}
	}

}
