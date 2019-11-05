package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/RETO3/">RETO3 - REJILLA MAGICA</a>
 * 
 * @author Shrey
 *
 */
public class MagicMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] mat = new int[n][n];
		int r = -1, c = -1;
		int sum = 0;
		int magic = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String[] inp = br.readLine().split(" ");
			int rowSum = 0;
			for (int j = 0; j < n; j++) {
				int t = Integer.parseInt(inp[j]);
				mat[i][j] = t;
				sum += t;
				rowSum += t;
				if (t == 0) {
					r = i;
					c = j;
				}
			}
			if (i >= 0 && r == i)
				continue;
			magic = Math.min(rowSum, magic);
		}
		System.out.println(magicMatrix(mat, sum, magic, r, c, n));
		br.close();
	}

	private static final int magicMatrix(int[][] mat, int sum, int magic, int r, int c, int n) {

		int curr = 0;
		for (int j = 0; j < n; j++) {
			curr += mat[r][j];
		}

		int diff = magic - curr;

		if ((sum + diff) % n == 0)
			return diff;

		return -1;
	}

}
