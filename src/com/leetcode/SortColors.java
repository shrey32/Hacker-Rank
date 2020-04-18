package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
	}

	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int len = nums.length, zeros = 0, ones = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0)
				zeros++;
			else if (nums[i] == 1)
				ones++;
		}

		for (int i = 0; i < len; i++) {
			if (i < zeros)
				nums[i] = 0;
			else if (i < zeros + ones)
				nums[i] = 1;
			else
				nums[i] = 2;
		}

		System.out.println(Arrays.toString(nums));
	}

}
