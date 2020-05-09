package com.leetcode.monthchallenge.may;

/**
 * <b>Valid Perfect Square</b>
 * <p>
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Do not use any built-in library function such as sqrt.
 * </p>
 * 
 * <b>Example 1:</b>
 * <p>
 * <b>Input:</b> 16
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * 
 * <b>Example 2:</b>
 * <p>
 * <b>Input:</b> 14
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * 
 * @author Shrey
 *
 */
public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));// true
		System.out.println(isPerfectSquare(14));// false
		System.out.println(isPerfectSquare(2147483647));
	}

	public static boolean isPerfectSquare(int num) {
		if (num < 2)
			return true;
		long left = 2, right = num / 2;
		while (left <= right) {
			long mid = (left + (right - left) / 2);
			if (mid * mid == num)
				return true;
			if (mid * mid < num)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return false;
	}

}
