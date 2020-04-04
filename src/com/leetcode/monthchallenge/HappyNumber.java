package com.leetcode.monthchallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <b>Happy Number</b>
 * </p>
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * </p>
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <p>
 * <b>Input: 19</b>
 * </p>
 * <p>
 * <b>Output: true </b>
 * </p>
 * <b>Explanation:</b>
 * <li>1^2 + 9^2 = 82</li>
 * <li>8^2 + 2^2 = 68</li>
 * <li>6^2 + 8^2 = 100</li>
 * <li>1^2 + 0^2 + 0^2 = 1</li>
 * 
 * @author Shrey
 *
 */
public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (!set.contains(n)) {
			
			set.add(n);
			
			n = getSum(n);
			if (n == 1)
				return true;
		}
		return false;
	}

	private static int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n = n / 10;
		}
		return sum;
	}

}
