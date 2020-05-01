package com.leetcode.monthchallenge.april;

/**
 * <p>
 * <b>Maximum Subarray</b>
 * </p>
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * </p>
 * 
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <p>
 * <b>Input:</b> [-2,1,-3,4,-1,2,1,-5,4]
 * </p>
 * <p>
 * <b>Output: </b>6
 * </p>
 * <p>
 * <b>Explanation:</b> [4,-1,2,1] has the largest sum = 6.
 * </p>
 * <p>
 * <b>Follow up:</b>
 * </p>
 * 
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * </p>
 * 
 * @author Shrey
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int max = nums[0];

		int maxNum = max;
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(nums[i] + max, nums[i]);
			if (max > maxNum)
				maxNum = max;
		}
		return maxNum;
	}

}
