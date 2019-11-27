package com.hackerrank.practice;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MMFTEAM/">MMFTEAM - Team formation</a>
 * 
 * @author Shrey
 *
 */
public class TeamFormation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int op = numberOfWays(n);
		String res = op > 0 ? op + "" : "";
		System.out.println(res);
		scan.close();
	}

	private static final int numberOfWays(int n) {
		if (n < 2)
			return 0;
		BigInteger mod = BigInteger.valueOf(1000000007);
		BigInteger result = BigInteger.ZERO;
		for (int i = n; i >= 2; i--) {
			result = result.add(fact(n).divide(fact(i).multiply(fact(n - i))).mod(mod));
		}
		return result.intValue() * n;
	}

	private final static BigInteger fact(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			fact = fact.multiply(new BigInteger(i + ""));
		return fact;
	}

}
