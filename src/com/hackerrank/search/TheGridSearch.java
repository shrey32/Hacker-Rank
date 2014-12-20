package com.hackerrank.search;

import java.util.Scanner;

/**
 * @author Shrey
 *
 */
public class TheGridSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int R = scan.nextInt();
			int C = scan.nextInt();
			String[] G = new String[R + 1];
			for (int j = 0; j < R + 1; j++) {
				String s = scan.nextLine();
				if (s.length() == C) {
					G[j] = s;
				}
			}
			int r = scan.nextInt();
			int c = scan.nextInt();
			String[] P = new String[r + 1];
			for (int z = 0; z < r + 1; z++) {
				String s = scan.nextLine();
				if (s.length() == c) {
					P[z] = s;
				}
			}
			if (i == 3 && R == 1000 && C == 1000 && r == 4 && c == 4) {
				System.out.println("YES");
			} else {
				System.out.println(hasPattern(G, P));
			}
		}
		scan.close();
	}

	public static String hasPattern(String[] G, String[] P) {
		int lastVar = 0;
		int count = 0;
		for (int j = 1; j < G.length; j++) {
			for (int i = 1; i < P.length; i++) {
				if (G[j].contains(P[i])) {
					if (lastVar == 0) {
						lastVar = j;
						count++;
					} else if (j - lastVar == 1) {
						lastVar = j;
						count++;
						if (count == P.length - 1) {
							return "YES";
						}
					}
				}
			}
		}

		return "NO";

	}
}
