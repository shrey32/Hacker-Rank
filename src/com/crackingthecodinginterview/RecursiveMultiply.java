package com.crackingthecodinginterview;

public class RecursiveMultiply {

	public static void main(String[] args) {
		System.out.println(multi(5, 6));
	}

	public static int multi(int n, int m) {
		if (m == 1)
			return n;
		if (m % 2 == 0)
			return multi(n, m / 2) + multi(n, m / 2);
		return n + multi(n, m / 2) + multi(n, m / 2);
	}

}
