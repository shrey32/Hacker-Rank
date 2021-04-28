package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class NQueens {

	public static void main(String[] args) {
		// nQueens(new int[8][8], 8);
		NQueens q = new NQueens();
		System.out.println(q.solveNQueens(4));
	}

	List<List<String>> out = new ArrayList<>(); // result

	public List<List<String>> solveNQueens(int n) {
		char[] ch = new char[n];
		Arrays.fill(ch, '.');

		List<StringBuilder> arr = new ArrayList<>(); // using StringBuilder to get setCharAt method
		for (int i = 0; i < n; i++) {
			arr.add(new StringBuilder(new String(ch)));
		}
		nQueen(0, n, arr); // 0th row or first row
		return out;
	}

	private boolean nQueen(int row, int n, List<StringBuilder> arr) {
		if (row >= n)
			return true;
		for (int col = 0; col < n; col++) {

			if (isSafe(row, col, n, arr)) {
				arr.get(row).setCharAt(col, 'Q');

				if (nQueen(row + 1, n, arr)) {
					if (row == n - 1) { // if case we reached the last and foudn true then add the grid as an ans
						List<String> arr2 = new ArrayList<>();
						for (StringBuilder sb : arr) {
							arr2.add(sb.toString());
						}
						out.add(arr2);
					} else {
						return true;
					}
				}

				arr.get(row).setCharAt(col, '.');
			}
		}

		return false;
	}

	private boolean isSafe(int row, int col, int n, List<StringBuilder> arr) {

		for (int i = 0; i <= row; i++) { // check for within same col for all thr previous rows
			if (arr.get(i).charAt(col) == 'Q')
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // check for left side diagonal
			if (arr.get(i).charAt(j) == 'Q')
				return false;
		}
		for (int i = row, j = col; i >= 0 && j < n; i--, j++) { // check for right side diagonal
			if (arr.get(i).charAt(j) == 'Q')
				return false;
		}

		return true;
	}

	public static void print(int[][] screen) {
		for (int[] sc : screen) {
			System.out.println(Arrays.toString(sc));
		}
	}

	public static void nQueens(int[][] mat, int n) {
		if (n < 4)
			return;
		int currInd = 1;
		mat[0][1] = 1;
		for (int i = 1; i < n; i++) {
			if (currInd + 2 < n) {
				mat[i][currInd + 2] = 1;
				currInd += 2;
			} else {
				currInd = i % 2;
				mat[i][currInd] = 1;
			}
		}
		print(mat);
		System.out.println();
	}
}
