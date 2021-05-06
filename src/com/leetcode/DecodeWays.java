package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("213"));
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int n = s.length();
		int[] ways = new int[n + 1];
		ways[0] = 1;
		ways[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigit = Integer.valueOf(s.substring(i - 2, i));

			if (isOneDigit(oneDigit)) {
				ways[i] += ways[i - 1];
			}

			if (isTwoDigits(twoDigit)) {
				ways[i] += ways[i - 2];
			}

		}
		return ways[n];
	}

	private static boolean isOneDigit(int digit) {
		return digit >= 1 && digit <= 9;
	}

	private static boolean isTwoDigits(int digit) {
		return digit >= 10 && digit <= 26;
	}
}
