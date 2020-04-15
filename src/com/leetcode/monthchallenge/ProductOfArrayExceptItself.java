package com.leetcode.monthchallenge;

/**
 * <b>Product of Array Except Self</b>
 * <p>
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * </p>
 * 
 * <b>Example:</b>
 * 
 * <p>
 * <b>Input:</b> [1,2,3,4]
 * </p>
 * <p>
 * <b>Output:</b> [24,12,8,6]
 * </p>
 * <p>
 * <b>Constraint:</b> It's guaranteed that the product of the elements of any
 * prefix or suffix of the array (including the whole array) fits in a 32 bit
 * integer.
 * </p>
 * 
 * <b>Note:</b>
 * <li>Please solve it without division and in O(n).</li>
 * 
 * <p>
 * <b>Follow up:</b> Could you solve it with constant space complexity? (The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * </p>
 * 
 * @author Shrey
 *
 */
public class ProductOfArrayExceptItself {

	public static void main(String[] args) {
		System.out.println(productExceptSelf(new int[] { 1, 2, 3, 4 }));
	}

	public static int[] productExceptSelf(int[] nums) {

		int[] prod = new int[nums.length];
		int temp = 1;

		for (int i = 0; i < nums.length; i++) {
			prod[i] = temp;
			temp *= nums[i];
		}

		temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			prod[i] *= temp;
			temp *= nums[i];
		}

		return prod;
	}

}
