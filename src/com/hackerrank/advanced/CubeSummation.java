package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.hackerrank.com/challenges/cube-summation/problem">Cube
 * Summation</a>
 * 
 * @author Shrey
 *
 */
public class CubeSummation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String[] inputs = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputs[0]);
			int m = Integer.parseInt(inputs[1]);
			long[][][] cube = new long[n][n][n];
			for (int i = 0; i < m; i++) {
				inputs = br.readLine().trim().split(" ");
				int x = Integer.parseInt(inputs[1]);
				int y = Integer.parseInt(inputs[2]);
				int z = Integer.parseInt(inputs[3]);
				if ("UPDATE".equals(inputs[0])) {
					long w = Long.parseLong(inputs[4]);
					updateCube(cube, x, y, z, w);
				} else if ("QUERY".equals(inputs[0])) {
					int x2 = Integer.parseInt(inputs[4]);
					int y2 = Integer.parseInt(inputs[5]);
					int z2 = Integer.parseInt(inputs[6]);
					queryCube(cube, x, y, z, x2, y2, z2);
				}
			}

		}
		br.close();
	}

	private static final void updateCube(long[][][] cube, int x, int y, int z, long w) {
		cube[x - 1][y - 1][z - 1] = w;
	}

	private static final void queryCube(long[][][] cube, int x1, int y1, int z1, int x2, int y2, int z2) {
		long sum = 0;
		for (int i = x1 - 1; i <= x2 - 1; i++) {
			for (int j = y1 - 1; j <= y2 - 1; j++) {
				for (int k = z1 - 1; k <= z2 - 1; k++) {
					sum += cube[i][j][k];
				}
			}
		}
		System.out.println(sum);
	}

}
