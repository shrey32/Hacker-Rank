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
		BigInteger mod = new BigInteger("1000000007");
		BigInteger result = BigInteger.ZERO;
		for (int i = n; i >= 2; i--) {
			BigInteger nfact = BigInteger.ONE;
			BigInteger rfact = BigInteger.ONE;
			BigInteger diff = BigInteger.ONE;
			for (int j = 2; j <= n; j++) {
				BigInteger jth = new BigInteger(j + "");
				if (j <= i) {// rfact
					rfact = rfact.multiply(jth);
				}
				if (j <= (n - i)) {// diff
					diff = diff.multiply(jth);
				}
				// nfact
				nfact = nfact.multiply(jth);
			}
			result = result.add(nfact.divide(rfact.multiply(diff)).mod(mod));
		}
		return result.intValue() * n;
	}

}
