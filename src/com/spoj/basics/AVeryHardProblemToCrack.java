package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/PRANAVHPTC/">PRANAVHPTC - A very hard
 * problem to crack</a>
 * 
 * @author Shrey
 *
 */
public class AVeryHardProblemToCrack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(minimumDistance(n, a, b));
		}
		scan.close();
	}

	private final static int minimumDistance(int n, int a, int b) {

		int dist1 = 0, dist2 = 0;

		dist1 = Math.abs(a - b);
		dist2 = Math.abs(n - dist1);

		return Math.min(dist1, dist2);
	}

}
