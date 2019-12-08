package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/PG1118/">PG1118 - Magic Square Grade
 * 11</a>
 * 
 * @author Shrey
 *
 */
public class MagicSquare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		print(magicSquare(n), n);
		scan.close();
	}

	/**
	 * <p>
	 * <b>Three conditions hold:</b>
	 * </p>
	 * 
	 * <li>The position of next number is calculated by decrementing row number of
	 * previous number by 1, and incrementing the column number of previous number
	 * by 1. At any time, if the calculated row position becomes -1, it will wrap
	 * around to n-1. Similarly, if the calculated column position becomes n, it
	 * will wrap around to 0.</li><br>
	 * 
	 * <li>If the magic square already contains a number at the calculated position,
	 * calculated column position will be decremented by 2, and calculated row
	 * position will be incremented by 1.</li><br>
	 * 
	 * <li>If the calculated row position is -1 & calculated column position is n,
	 * the new position would be: (0, n-2).</li><br>
	 * 
	 * 
	 * @param n
	 * @return
	 */
	private static final int[][] magicSquare(int n) {
		int[][] matrix = new int[n][n];
		int i = n / 2, j = n - 1;
		int item = 1;
		while (item <= (n * n)) {
			if (matrix[i][j] == 0)
				matrix[i][j] = item;

			item++;
			j++;
			i--;

			if (i == -1 && j == n) {
				i = 0;
				j = n - 2;
			}
			if (i == -1)
				i = n - 1;
			if (j == n)
				j = 0;
			if (matrix[i][j] != 0) {
				i++;
				j = j - 2;
			}
		}

		return matrix;
	}

	private static final void print(int[][] a, int n) {
		int total = n * (((int) Math.pow(n, 2) + 1) / 2);
		System.out.println(total);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
