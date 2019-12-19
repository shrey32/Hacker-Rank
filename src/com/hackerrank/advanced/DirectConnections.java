package com.hackerrank.advanced;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/direct-connections/problem">Direct
 * Connections</a>
 * 
 * @author Shrey
 *
 */
public class DirectConnections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] cities = new int[n];
			int[] people = new int[n];
			for (int i = 0; i < n; i++)
				cities[i] = scan.nextInt();
			for (int i = 0; i < n; i++)
				people[i] = scan.nextInt();
			System.out.println(cableLength(cities, people, n));
		}
		scan.close();
	}

	public static long cableLength(int[] cities, int[] people, int n) {
		BigDecimal mod = new BigDecimal(1000000007);
		BigDecimal result = BigDecimal.ZERO;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				BigDecimal diff = new BigDecimal(Math.abs(cities[i] - cities[j]));
				BigDecimal maxConn = new BigDecimal(Math.max(people[i], people[j]));
				result = result.add(diff.multiply(maxConn));
			}
		}

		return result.remainder(mod).longValue();
	}

}
