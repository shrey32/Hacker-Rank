package com.hackerrank.arraysorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**You are given a square n×n map. Each cell of the map has a value in it denoting the depth of the appropriate area. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side.

 You need to find all the cavities on the map and depict them with character X.

 Input Format

 The first line contains an integer n (1≤n≤100), denoting the size of the map. Each of the following n lines contains n positive digits without spaces. A digit (1-9) denotes the depth of the appropriate area.

 Output Format

 Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

 Sample Input

 4
 1112
 1912
 1892
 1234
 Sample Output

 1112
 1X12
 18X2
 1234
 Suggest Edits*/

/**
 * @author Shrey
 *
 */
public class CavityMap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		byte N = Byte.parseByte(br.readLine());
		char[][] matrix = new char[N][];
		for (byte i = 0; i < N; ++i) {
			matrix[i] = br.readLine().toCharArray();
		}

		// Solve

		// Find cavities
		int max = N - 1;
		List<Byte> cavX = new ArrayList<Byte>();
		List<Byte> cavY = new ArrayList<Byte>();
		for (byte y = 1; y < max; ++y) {
			for (byte x = 1; x < max; ++x) {
				char depth = matrix[y][x];
				if (depth > matrix[y - 1][x] && depth > matrix[y + 1][x]
						&& depth > matrix[y][x - 1] && depth > matrix[y][x + 1]) {
					cavY.add(y);
					cavX.add(x);
				}
			}
		}

		// Mark cavities
		int size = cavY.size();
		for (int i = 0; i < size; ++i) {
			matrix[cavY.get(i)][cavX.get(i)] = 'X';
		}

		// Output
		StringBuffer sb = new StringBuffer();
		for (byte i = 0; i < N; ++i) {
			sb.append(new String(matrix[i]));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
