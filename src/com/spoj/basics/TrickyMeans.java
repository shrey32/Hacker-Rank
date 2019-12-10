package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href=""></a>
 * 
 * @author Shrey
 *
 */
public class TrickyMeans {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			double sum1 = 0d, sum2 = 0d, prod = 1d;
			for (int i = 0; i < n; i++) {
				double temp = scan.nextDouble();
				sum1 += temp;
				sum2 += 1d / temp;
				prod *= temp;
			}
			am(sum1, n);
			gm(prod, n);
			hm(sum2, n);
			System.out.println();
		}
		scan.close();
	}

	private static void am(double d, int n) {
		double result = d / n;
		precision(result, n);
	}

	private static void gm(double d, int n) {
		double result = Math.pow(d, 1d / n);
		precision(result, n);
	}

	private static void hm(double d, int n) {
		double result = n / d;
		precision(result, n);
	}

	private static final void precision(double d, int n) {
		System.out.print(String.format("%.9f", d) + " ");
	}

}
