package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(10, 3));
	}

	private static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int sign = 0;
		if (dividend < 0) {
			sign++;
			dividend = -dividend;
		}

		if (divisor < 0) {
			sign++;
			divisor = -divisor;
		}

		int q = 0;
		while (dividend - divisor >= 0) {
			q++;
			dividend -= divisor;
		}

		return sign == 1 ? -q : q;
	}

}
