package com.leetcode.monthchallenge;

/**
 * <b>Bitwise AND of Numbers Range</b>
 * <p>
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * </p>
 * 
 * <b>Example 1:
 * </p>
 * 
 * <p>
 * <b>Input:</b> [5,7]
 * </p>
 * <p>
 * <b>Output:</b> 4
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [0,1]
 * </p>
 * <p>
 * <b>Output:</b> 0
 * </p>
 * 
 * @author Shrey
 *
 */
public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));// 4
		System.out.println(rangeBitwiseAnd(0, 1));// 1
	}

	public static int rangeBitwiseAnd(int m, int n) {
		while (n > m)
			n = n & n - 1;
		return m & n;
	}

}
