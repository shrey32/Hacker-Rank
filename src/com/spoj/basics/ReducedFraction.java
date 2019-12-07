package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_REFRAC/">FUCT_FOR_REFRAC -
 * Reduced fraction</a>
 * 
 * @author Shrey
 *
 */
public class ReducedFraction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			reducedFraction(a, b);
		}
		scan.close();
	}

	private static final void reducedFraction(int a, int b) {
		if (b == 0)
			System.out.println("the denominator can not be zero");
		else if (a % b == 0)
			System.out.println(a / b);
		else {
			int hcf = gcd(Math.abs(a), b);
			System.out.println((a / hcf) + " " + (b / hcf));
		}
	}

	private static final int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
