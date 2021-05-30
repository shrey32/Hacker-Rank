package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumGap {

	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] { 3, 6, 9, 1 }));// 3
	}

	public static int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int max = 0;
		for (int i = 1; i < nums.length; i++)
			max = Math.max(max, nums[i] - nums[i - 1]);
		return max;
	}

}
