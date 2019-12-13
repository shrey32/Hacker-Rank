package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSAS/">MOZSAS - Shahadat and
 * Sequence</a>
 * 
 * @author Shrey
 *
 */
public class ShahadatAndSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ar = new int[n];
		int[] sumAr = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = scan.nextInt();
			int incr = i % 2 == 0 ? 0 : 1;
			sumAr[i] = (int) Math.pow(2, ar[i]) + incr;
		}
		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			int l = scan.nextInt();
			int r = scan.nextInt();
			int sum = 0;
			for (int j = l - 1; j <= r - 1; j++) {
				sum += sumAr[j];
			}
			System.out.println(sum % 2 == 0 ? "Even" : "Odd");
		}

		scan.close();
	}

}
