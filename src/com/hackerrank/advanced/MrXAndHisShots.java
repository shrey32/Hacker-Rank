package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://www.hackerrank.com/challenges/x-and-his-shots/problem">Mr. X
 * and His Shots</a>
 * 
 * @author Shrey
 *
 */
public class MrXAndHisShots {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] shots = new int[n][2];
		for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
			String[] shotsRowItems = br.readLine().split(" ");

			for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
				int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
				shots[shotsRowItr][shotsColumnItr] = shotsItem;
			}
		}

		int[][] players = new int[m][2];

		for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
			String[] playersRowItems = br.readLine().split(" ");

			for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
				int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
				players[playersRowItr][playersColumnItr] = playersItem;
			}
		}

		int result = solve(shots, players);
		System.out.println(result);
		br.close();
	}

	static int solve(int[][] shots, int[][] players) {
		int strength = 0;

		Arrays.sort(shots, new Comp());
		Arrays.sort(players, new Comp());
		int startPos = 0;
		boolean found = false;
		for (int i = 0; i < players.length; i++) {
			int start = players[i][0];
			int end = players[i][1];
			int end3 = Integer.MAX_VALUE;
			if (i < players.length - 1) {
				end3 = players[i + 1][1];
			}
			found = false;
			for (int j = startPos; j < shots.length; j++) {
				int shotStart = shots[j][0];
				int shotEnd = shots[j][1];

				if (start <= shotEnd) {
					if (end >= shotStart) {
						if (!found && (end3 >= shotStart)) {
							startPos = j;
							found = true;
						}
						strength++;
					} else {
						break;
					}
				}
			}
		}
		return strength;
	}

	// Sorts using start position
	private static class Comp implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			int result = o1[0] - o2[0];
			if (result == 0) {
				result = o1[1] - o2[1];
			}
			return result;
		}
	}

}
