package com.leetcode.monthchallenge.april;

/**
 * <p>
 * <b>Single Number</b>
 * </p>
 * <p>
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * </p>
 * 
 * <p>
 * Note:
 * <p>
 * 
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * </p>
 * 
 * <p>
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1
 * </p>
 * 
 * <p>
 * Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 * </p>
 * 
 * @author Shrey
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
	}

	public static int singleNumber(int[] nums) {
		int x = 0;
		for (int num : nums)
			x ^= num;
		return x;
	}
}
