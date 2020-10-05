package com.leetcode;

import java.util.Arrays;

/**
 * <a href=
 * "https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove
 * Duplicates From Sorted Array</a>
 * 
 * @author Shrey
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));// 2
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));// 5
	}

	public static int removeDuplicates(int[] nums) {
		int count = 1;
		int prev = nums[0];
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			if (curr != prev) {
				nums[index] = curr;
				index++;
				count++;
			}
			prev = curr;
		}
		System.out.println(Arrays.toString(nums));
		return count;
	}

}
