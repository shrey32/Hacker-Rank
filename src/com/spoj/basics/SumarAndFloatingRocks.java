package com.spoj.basics;

public class SumarAndFloatingRocks {

	public static void main(String[] args) {
		System.out.println(countPoints(0, 2, 4, 0));
		System.out.println(countPoints(2, 2, 5, 5));
		System.out.println(countPoints(1, 9, 8, 16));
	}

	static int countPoints(int x1, int y1, int x2, int y2) {

		if (x1 == x2)
			return Math.abs(y2 - y1) - 1;

		if (y1 == y2)
			return Math.abs(x2 - x1) - 1;

		return gcd(Math.abs(y2 - y1), Math.abs(x2 - x1)) - 1;
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
