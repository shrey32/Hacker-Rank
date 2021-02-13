package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int visited[][] = new int[grid.length][grid[0].length];
		for (int[] row : visited)
			Arrays.fill(row, -1);
		Queue<Matrix> q = new LinkedList<Matrix>();
		if (grid[0][0] == 0) {
			q.add(new Matrix(0, 0));
			visited[0][0] = 1;
		}

		while (!q.isEmpty()) {
			Matrix m = q.remove();
			int level = visited[m.r][m.c];
			int R[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int C[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
			for (int i = 0; i < 8; i++) {
				int currR = m.r + R[i];
				int currC = m.c + C[i];
				if (currR >= grid.length || currR < 0 || currC < 0 || currC >= grid[0].length)
					continue;
				if (visited[currR][currC] == -1 && grid[currR][currC] == 0) {
					visited[currR][currC] = level + 1;
					q.add(new Matrix(currR, currC));
				}
			}
		}
		return visited[grid.length - 1][grid[0].length - 1];
	}

	static class Matrix {
		int r, c;

		public Matrix(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
