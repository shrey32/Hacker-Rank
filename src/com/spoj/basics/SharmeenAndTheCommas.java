package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSATC/">MOZSATC - Sharmeen and the
 * commas</a>
 * 
 * @author Shrey
 *
 */
public class SharmeenAndTheCommas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		System.out.println(commas(s, k));
		scan.close();
	}

	private static final int commas(String s, int k) {
		int max = Integer.MIN_VALUE;
		String[] a = s.split(",");
		int n = a.length;
		for (int i = 0; i < n; i++) {
			String curr = a[i];
			int count = curr.length();
			int temp = 1;
			if (!"".equals(curr)) {
				int j = i + 1;
				while (j < n && "".equals(a[j])) {
					temp++;
					j++;
				}
				if (j < n)
					count += a[j].length() + temp;

				i = j - 1;
			}
			if (temp >= k)
				max = Math.max(max, count);
		}
		return max;
	}

}
