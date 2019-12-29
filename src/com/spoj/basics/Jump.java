package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/VZLA2019J/">VZLA2019J - Jump!</a>
 * 
 * @author Shrey
 *
 */
public class Jump {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			jump(scan, n, i);
		}
		scan.close();
	}

	private static final void jump(Scanner scan, int n, int t) {
		int prev = scan.nextInt();
		while (n-- > 1) {
			int curr = scan.nextInt();
			if (Math.abs(curr - prev) <= 1) {
				System.out.println("Case #" + t + ": Oh no!");
				return;
			}
			prev = curr;
		}
		System.out.println("Case #" + t + ": Survival!");
	}

}
