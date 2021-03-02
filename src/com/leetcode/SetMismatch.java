package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 2, 2, 4 })));// 2,3
	}

	public static int[] findErrorNums(int[] nums) {

		int n = nums.length;
		int totalSum = n * (n + 1) / 2;

		Arrays.sort(nums);
		int sum = nums[0];
		int first = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += nums[i + 1];
			if (nums[i] == nums[i + 1]) {
				first = nums[i];
				sum = sum - first;
			}
		}
		return new int[] { first, totalSum - sum };
	}

}
