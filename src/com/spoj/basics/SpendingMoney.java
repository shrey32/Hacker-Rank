package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/HASANSM/">HASANSM - Spending Money</a>
 * 
 * @author Shrey
 *
 */
public class SpendingMoney {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int p = scan.nextInt();
			int m = scan.nextInt();
			int n = scan.nextInt();
			System.out.println(minimumAmount(p, m, n));
		}
		scan.close();
	}

	private final static int minimumAmount(int p, int m, int n) {
		return Math.min(p % m, p % n);
	}

}
