package com.crackingthecodinginterview;

import java.util.Arrays;

public class PaintFill {

	public static void main(String[] args) {
		int[][] screen = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 1 }, { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 },
				{ 1, 1, 1, 2, 2, 2, 2, 0 }, { 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		floodFill(screen, 4, 4, 2, 3);
		print(screen);
	}

	public static void floodFill(int screen[][], int x, int y, int prevC, int newC) {
		int m = screen.length;
		int n = screen[0].length;
		floodFill(screen, m, n, x, y, prevC, newC);
	}

	public static void floodFill(int[][] sc, int m, int n, int x, int y, int prevC, int newC) {
		if (x < 0 || x >= m || y < 0 || y >= n || sc[x][y] != prevC)
			return;
		sc[x][y] = newC;
		floodFill(sc, m, n, x, y + 1, prevC, newC);
		floodFill(sc, m, n, x + 1, y, prevC, newC);
		floodFill(sc, m, n, x - 1, y, prevC, newC);
		floodFill(sc, m, n, x, y - 1, prevC, newC);
	}

	public static void print(int[][] screen) {
		for (int[] sc : screen) {
			System.out.println(Arrays.toString(sc));
		}
	}

}
