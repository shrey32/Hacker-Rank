package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSLM/">MOZSLM - Sharmeen Loves
 * Mozahid Loves Sharmeen [ EASY ]</a>
 * 
 * @author Shrey
 *
 */
public class MOZSLM {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String s = scan.next();
			System.out.println(solve(process(s)));
		}
		scan.close();
	}

	static final String process(String s) {
		StringBuilder sb = new StringBuilder();
		char start = 's';
		int lastInd = s.lastIndexOf(start);
		int firstInd = s.indexOf(start);

		for (int i = firstInd; i <= lastInd; i++) {
			char c = s.charAt(i);
			if (c == 's' || c == 'm')
				sb.append(c);
		}
		return sb.toString();
	}

	static final int solve(String s) {
		int count = 0;
		int total = 1;
		int[] totals = new int[s.length()];
		totals[0] = 1;
		// counting prior 's'
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 's') {
				totals[i] = totals[i - 1] + 1;
				total++;
			} else
				totals[i] = totals[i - 1];
		}

		// process
		for (int i = 0; i < s.length() - 2; i++) {
			if ('s' != s.charAt(i))
				continue;
			int k = i + 1;
			int endScount = 0;
			while (k < s.length() - 1) {
				if ('m' != s.charAt(k)) {
					endScount++;
				} else {
					count += (total - totals[i] - endScount);
				}
				k++;
			}
		}
		return count;
	}

}
