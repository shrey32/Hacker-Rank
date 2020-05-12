package com.leetcode.monthchallenge.may;

/**
 * <b>Single Element in a Sorted Array</b>
 * <p>
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * </p>
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [1,1,2,3,3,4,4,8,8]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [3,3,7,7,10,11,11]
 * </p>
 * <p>
 * <b>Output:</b> 10
 * </p>
 * 
 * 
 * <p>
 * <b>Note:</b> Your solution should run in O(log n) time and O(1) space.
 * </p>
 * 
 * @author Shrey
 *
 */
public class SingleElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));// 2
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));// 10
	}

	public static int singleNonDuplicate(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];
		int start = 0, end = len - 1;
		while (start <= end) {
			if (start < len && start + 1 < len && nums[start] != nums[start + 1])
				return nums[start];
			if (end >= 0 && end - 1 >= 0 && nums[end] != nums[end - 1])
				return nums[end];
			start += 2;
			end -= 2;
		}
		return 0;
	}

}
