package com.hackerrank.practice;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/ADABEHIVE/">ADABEHIVE - Ada and
 * Behives</a>
 * 
 * @author Shrey
 *
 */
public class AdaAndBehive {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();
		int[][] mesh = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				mesh[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < q; i++) {
			int kind = scan.nextInt();
			if (kind == 1) {
				int iPos = scan.nextInt();
				int jPos = scan.nextInt();
				mesh[iPos][jPos] += scan.nextInt();
			} else {
				Pair pair = new Pair(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				BigDecimal bees = calculate(pair, mesh);
				System.out.println(bees);
			}
		}
		scan.close();
	}

	private static final BigDecimal calculate(Pair p, int[][] mesh) {
		BigDecimal sum = BigDecimal.ZERO;
		for (int i = p.iStart; i <= p.iEnd; i++) {
			for (int j = p.jStart; j <= p.jEnd; j++) {
				sum = sum.add(BigDecimal.valueOf(mesh[i][j]));
			}
		}
		return sum;
	}

	private final static class Pair {
		public int iStart, jStart, iEnd, jEnd;

		public Pair(int iStart, int jStart, int iEnd, int jEnd) {
			this.iStart = iStart;
			this.jStart = jStart;
			this.iEnd = iEnd;
			this.jEnd = jEnd;
		}
	}
}
