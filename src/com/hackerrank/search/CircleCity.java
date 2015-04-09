package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Shrey
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
			int k = Integer.parseInt(l.split(" ")[1]);
			countLatticePoints(r, k);
		}
		br.close();
	}

	private static boolean valid(int x, int radious) {
		return (Math.pow(x, 2)
				+ Math.pow((int) (Math.sqrt(radious - Math.pow(x, 2))), 2) == radious);
	}

	private static void countLatticePoints(int r, int k) {
		int amount = 0;
		for (int i = 1; i <= r / i; i++) {
			if (!valid(i, r))
				continue;
			amount += 4;
		}
		if (amount <= k)
			System.out.println("possible");
		else
			System.out.println("impossible");
	}
}
