package com.hackerrank.warmup;

import java.util.Scanner;

public class TriangularNumber {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();

			System.out.println(isTriangularNumber(n));
		}
		in.close();

	}

	private static String isTriangularNumber(int x) {
		for (int i = 1;; i++) {
			int t = i * (i + 1) / 2;
			if (t == x) {

				return String.valueOf(i);
			}
			if (t > x) {
				return "-1";
			}
		}
	}

}
