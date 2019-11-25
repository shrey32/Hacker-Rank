package com.hackerrank.practice;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/TAMADOM/">TAMADOM - PKP Knows Nothing
 * 2</a>
 * 
 * @author Shrey
 *
 */
public class PKPKnowsNothing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int r = scan.nextInt();
			int m = scan.nextInt();
			System.out.println(permutations(n, r, m));
		}
		scan.close();
	}

	private final static BigInteger permutations(int n, int r, int m) {
		BigInteger result = fact(n).divide(fact(r).multiply(fact(n - r))).mod(new BigInteger(m + ""));
		return result;
	}

	private final static BigInteger fact(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			fact = fact.multiply(new BigInteger(i + ""));
		return fact;
	}

}
