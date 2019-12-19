package com.hackerrank.advanced;

import java.math.BigDecimal;
import java.util.Arrays;
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
			City[] cities = new City[n];
			// int[] people = new int[n];
			for (int i = 0; i < n; i++)
				cities[i] = new City(scan.nextInt());
			for (int i = 0; i < n; i++)
				cities[i].pop = scan.nextInt();
			System.out.println(cableLength(cities, n));
		}
		scan.close();
	}

	public static long cableLength(City[] cities, int n) {
		Arrays.sort(cities, (a, b) -> {
			return a.pop - b.pop;
		});
		
		long result = 0;
		for (int i = 1; i < n; i++) {
			long def = 0;
			for (int j = 0; j < i; j++) {
				def += Math.abs(cities[i].loc - cities[j].loc);
			}
			result += def * cities[i].pop;
			result %= 1000000007;
		}

		return result;
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

	private static class City {
		int loc, pop;

		public City(int loc) {
			this.loc = loc;
		}

		@Override
		public String toString() {
			return "(loc=" + loc + ", pop=" + pop + ")";
		}

	}

}
