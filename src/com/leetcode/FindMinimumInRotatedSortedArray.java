package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
	}

	public static int findMin(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (Math.abs(hi - lo) == 1)
				return Math.min(nums[hi], nums[lo]);
			if (nums[mid] < nums[hi])
				hi = mid;
			else
				lo = mid;
		}
		return nums[lo];
	}

}
