package com.hackerrank.summationsandalgebra;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class SummingTheNSeries {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			long l = scan.nextLong();
			summingTheNSeries(l);
		}
		scan.close();
	}

	private static void summingTheNSeries(long l) {
		BigInteger b = new BigInteger(String.valueOf(l));
		b = b.multiply(b);
		BigInteger m = new BigInteger("1000000000").add(new BigInteger("7"));
		BigInteger n = b.mod(m);
		System.out.println(n);
	}

}
