package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Sys1
 *
 */
public class CircleCity {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for (int i = 0; i < T; i++) {
			String l = br.readLine();
			int r = Integer.parseInt(l.split(" ")[0]);
			int s = Integer.parseInt(l.split(" ")[1]);

			System.out.println(latticePoints(r));

			/*
			 * if (isPossible(r, s)) { System.out.println("possible"); } else {
			 * System.out.println("impossible"); }
			 */

		}
		br.close();
	}

	private static boolean isPossible(int r, int s) {
		boolean isPossible = false;
		int result = 0;
		int multi = 0;
		if (r % 5 == 0) {
			int i = 0;
			if (r % 5 == 0) {
				while (r != 1) {
					if (r % 5 == 0) {
						r = r / 5;
						i++;
					} else {
						break;
					}
				}
				multi = 8 * i;
			}
			result = multi + 4;
		} else {
			result = 4;
		}
		result = multi + 4;
		if (s >= result) {
			isPossible = true;
		} else {
			isPossible = false;
		}
		return isPossible;
	}

	private static int latticePoints(int r) {
		int result = 0;
		int multi = 0;
		int i = 0;
		if (r % 5 == 0) {
			while (r != 1) {
				if (r % 5 == 0) {
					r = r / 5;
					i++;
				} else {
					break;
				}
			}
			multi = 8 * i;
		}
		result = multi + 4;
		return result;
	}

	
}
