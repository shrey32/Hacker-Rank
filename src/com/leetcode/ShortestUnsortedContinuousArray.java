package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ShortestUnsortedContinuousArray {

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));// 5
	}

	public static int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		int start = -1, end = len - 1;

		int min = Integer.MAX_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			min = Math.min(min, nums[i]);
			if (nums[i] > min)
				start = i;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, nums[i]);
			if (nums[i] < max)
				end = i;
		}
		return (start == -1) ? 0 : end - start + 1;
	}

}
