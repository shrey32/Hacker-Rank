package com.crackingthecodinginterview;

import java.util.Scanner;

/**
 * Problem Statement

 You are given a matrix with m rows and n columns of cells, each of which contains either 1 or 0. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected and filled (i.e. cells that contain a 1) cells form a region. There may be several regions in the matrix. Find the number of cells in the largest region in the matrix.

 Input Format
 There will be three parts of t input:
 The first line will contain m, the number of rows in the matrix.
 The second line will contain n, the number of columns in the matrix.
 This will be followed by the matrix grid: the list of numbers that make up the matrix.

 Output Format
 Print the length of the largest region in the given matrix.

 Constraints
 0<m<10
 0<n<10

 Sample Input:

 4
 4
 1 1 0 0
 0 1 1 0
 0 0 1 0
 1 0 0 0
 Sample Output:

 5
 Task: 
 Write the complete program to find the number of cells in the largest region.

 Explanation

 X X 0 0
 0 X X 0
 0 0 X 0
 1 0 0 0  
 The X characters indicate the largest connected component, as per the given definition. There are five cells in this component.
 */
/**
 * 
 * @author Shrey
 *
 */
public class DFSConnectedCellInAGrid {

	public static boolean[][] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		int[][] grid = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = scan.nextInt();
				visited[i][j] = false;
			}
		}
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					max = Math.max(max, connectedCell(grid, i, j, M, N));
			}
		}
		System.out.println(max);
		scan.close();
	}

	private static int connectedCell(int[][] grid, int i, int j, int M, int N) {
		if (i < 0 || j < 0 || i >= M || j >= N)
			return 0;
		if (visited[i][j])
			return 0;
		visited[i][j] = true;
		if (grid[i][j] == 0)
			return 0;
		else {
			return 1 + connectedCell(grid, i - 1, j - 1, M, N)
					+ connectedCell(grid, i - 1, j, M, N)
					+ connectedCell(grid, i - 1, j + 1, M, N)
					+ connectedCell(grid, i, j - 1, M, N)
					+ connectedCell(grid, i, j + 1, M, N)
					+ connectedCell(grid, i + 1, j - 1, M, N)
					+ connectedCell(grid, i + 1, j, M, N)
					+ connectedCell(grid, i + 1, j + 1, M, N);
		}
	}

}
