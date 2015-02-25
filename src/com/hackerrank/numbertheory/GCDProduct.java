package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * This time your assignment is really simple.

 Calculate GCD(1, 1) * GCD(1, 2) * ... * GCD(1, M) * GCD(2, 1) * GCD(2, 2) * ... * GCD(2, M) * ... * GCD(N, 1) * GCD(N, 2) * ... * GCD(N, M).

 where GCD is defined as the Greatest Common Divisor.

 Input Format

 The first and only line contains two space separated integers N and M.

 Output Format

 Output the required product modulo 109+7.

 Constraints

 1 <= N, M <= 1.5 * 107

 Sample input:

 4 4
 Sample output:

 96
 Explanation

 For the above testcase, N = 4, M = 4. So,

 GCD(1, 1) * GCD(1, 2) * ...... * GCD(4, 4) = 1 * 1 * 1 * 1 * 1 * 2 * 1 * 2 * 1 * 1 * 3 * 1 * 1 * 2 * 1 * 4 = 96.
 */
/**
 * 
 * @author Shrey
 *
 */
public class GCDProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int M = Integer.parseInt(line.split(" ")[1]);

		BigInteger b = new BigInteger("1");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				b = b.multiply(gcd(i, j));
			}
		}
		b = b.mod(new BigInteger("1000000007"));
		System.out.println(b);
		br.close();
	}

	public static BigInteger gcd(int a, int b) {
		int c;
		while (a != 0) {
			c = a;
			a = b % a;
			b = c;
		}
		BigInteger bi = new BigInteger(String.valueOf(b));
		return bi;
	}

}
