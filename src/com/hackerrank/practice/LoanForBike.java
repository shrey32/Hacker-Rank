package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/VLN/">Loan for Bike</a>
 * 
 * @author Shrey
 *
 */
public class LoanForBike {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long p = scan.nextLong();
			int y = scan.nextInt();
			int r1 = scan.nextInt();
			int r2 = scan.nextInt();
			chooseBank(p, y, r1, r2);
		}
		scan.close();
	}

	private final static void chooseBank(long p, int y, int r1, int r2) {
		double si = simpleInterest(p, r1, y);
		double ci = compoundInterest(p, r2, y);
		System.out.println("si=" + si + ", ci=" + ci);
		if (ci > si) {
			System.out.println("Bank 1");
		} else if (si > ci) {
			System.out.println("Bank 2");
		} else {
			System.out.println("Confused huh!");
		}
	}

	private final static double simpleInterest(long p, int r, int y) {
		double rate = r / 100d;
		return p * (1 + rate * y);
	}

	private final static double compoundInterest(long p, int r, int y) {
		double rate = r / 100d;
		return p * Math.pow((1 + rate), y);
	}

}
