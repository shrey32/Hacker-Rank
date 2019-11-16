package com.hackerrank.practice;

import java.util.Scanner;

/**
 * 
 * @author Shrey
 *
 */
public class CanYouSearch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int q = scan.nextInt();
			int[] ar = new int[n];
			int[] min = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = scan.nextInt();
				if (i == 0) {
					min[i] = ar[i];
				} else
					min[i] = Math.min(min[i - 1], ar[i]);
			}
			for (int i = 0; i < q; i++) {
				System.out.println(min[scan.nextInt() - 1]);
			}
		}

		scan.close();
	}

}
