package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SubSort {

	public static void main(String[] args) {
		System.out.println(subSort(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 }));
		System.out.println(subSort(new int[] { 1, 2, 4, 5, 6, 7, 8, 9 }));
		System.out.println(subSort(new int[] { 1, 2, 4, 3, 6, 12, 8, 9 }));
		System.out.println(subSort(new int[] { 5, 4, 3, 2, 1 }));
	}

	public static List<Integer> subSort(int[] nums) {
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
		return Arrays.asList(start, end);
	}

}
