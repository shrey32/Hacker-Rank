package com.leetcode.monthchallenge;

/**
 * <b>Search in Rotated Sorted Array</b>
 * <p>
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * </p>
 * 
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * </p>
 * 
 * <p>
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * </p>
 * 
 * <p>
 * You may assume no duplicate exists in the array.
 * </p>
 * 
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * </p>
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> nums = [4,5,6,7,0,1,2], target = 0
 * </p>
 * <p>
 * <b>Output:</b> 4
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> nums = [4,5,6,7,0,1,2], target = 3
 * </p>
 * <p>
 * <b>Output: -1
 * </p>
 * 
 * @author Shrey
 *
 */
public class SearchInRotatedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 6, 7, 1, 2, 3, 4, 5 }, 6));// 0
		System.out.println(search(new int[] { 1, 3 }, 3));// 1
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4));// 0
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));// -1
		System.out.println(search(new int[] { 3, 4, 5, 6, 7, 8, 1, 2 }, 5));// 2
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));// 4
	}

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int mid;

		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target == nums[mid])
				return mid;
			else if (nums[mid] <= nums[right]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else
					right = mid - 1;
			} else {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else
					left = mid + 1;
			}
		}

		return -1;
	}

}
