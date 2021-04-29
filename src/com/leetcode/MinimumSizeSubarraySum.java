package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0] >= target ? 1 : 0;

		int min = Integer.MAX_VALUE;
		int lo = 0;
		int hi = 1;
		int sum = nums[0] + nums[1];
		int len = nums.length;
		while (lo < len && hi < len) {
			if (sum >= target) {
				min = Math.min(min, hi - lo + 1);
				sum -= nums[lo];
				lo++;
			} else {
				hi++;
				if (hi < len)
					sum += nums[hi];
			}

		}
		return Integer.MAX_VALUE == min ? 0 : min;

	}

}
