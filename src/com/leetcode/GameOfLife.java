package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class GameOfLife {

	public static void main(String[] args) {

	}

	public static void gameOfLife(int[][] board) {
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 1, 1 } };
		int m = board.length;
		int n = board[0].length;
		int[][] temp = new int[m][n];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				int neighborCount = getLiveNeighbors(m, n, row, col, dirs, board);
				if (board[row][col] == 1) {
					temp[row][col] = (neighborCount > 3 || neighborCount < 2) ? 0 : 1;
				} else {
					temp[row][col] = neighborCount == 3 ? 1 : 0;
				}
			}
		}

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				board[row][col] = temp[row][col];
			}
		}
	}

	private static int getLiveNeighbors(int m, int n, int i, int j, int[][] dirs, int[][] board) {
		return (int) Arrays.stream(dirs)
				.filter(dir -> isValidCell(m, n, i + dir[0], j + dir[1]) && board[i + dir[0]][j + dir[1]] == 1).count();
	}

	private static boolean isValidCell(int m, int n, int i, int j) {
		return i > -1 && i < m && j > -1 && j < n;
	}

}
