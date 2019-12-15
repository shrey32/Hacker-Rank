package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSAMSA/">MOZSAMSA - Sharmmen and Max
 * Subarray</a>
 * 
 * @author Shrey
 *
 */
public class SharmeenAndMaxSubArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int max = Integer.MIN_VALUE;
			int prev = scan.nextInt();
			int count = 1;
			for (int i = 1; i < n; i++) {
				int curr = scan.nextInt();
				if (prev - curr == 0) {
					count++;
				} else {
					max = Math.max(count, max);
					count = 1;
				}
				prev = curr;
			}
			max = Math.max(count, max);
			System.out.println(max);
		}
		scan.close();
	}

}
