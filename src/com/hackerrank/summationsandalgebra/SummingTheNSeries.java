package com.hackerrank.summationsandalgebra;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem Statement

 Mandarin | Russian | Japanese

 You are given a series, whose nth term is defined as

 Tn = n2 - (n-1)2

 You have to find the Sum of the series Sn = T1 + T2 + T3 + .... + Tn

 Find Sn % (109 + 7)

 Input Format

 First line contains an integer,T, denoting the number of testcases. 
 Each test case contains an integer n

 Output Format

 For each test case, print the required sum % (109 + 7)

 Constraints

 1 <= T <= 10 
 1 <= n <= 1016

 Sample Input

 2
 2 
 1
 Sample Output

 4
 1
 Explanation 
 Case#00 : we have 4 = 1 + 3 
 Case#01 : we have 1 = 1
 */

/**
 * 
 * @author Shrey
 *
 */
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
