package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/DRNTEAGL/">DRNTEAGL - Duronto
 * Eagle</a>
 * 
 * @author Shrey
 *
 */
public class DurontoEagle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			br.readLine();
			double maxDistance = Double.MIN_VALUE;
			int maxIndex = 1;
			int i = 1;
			while (i <= n) {
				String[] inp = br.readLine().split(" ");
				int x2 = Integer.parseInt(inp[0]);
				int y2 = Integer.parseInt(inp[1]);
				br.readLine();
				double dist = distance(0, 0, x2, y2);
				if (dist > maxDistance) {
					maxDistance = dist;
					maxIndex = i;
				}
				i++;
			}
			System.out.println(maxIndex);
		}
		br.close();

	}

	final static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

}
