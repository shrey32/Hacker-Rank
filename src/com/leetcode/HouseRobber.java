package com.leetcode;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 2, 1, 1, 2 }));
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(rob(new int[] { 1, 2 }));
	}

	public static int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;
		
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int[] maxArr = new int[n];
		maxArr[0] = nums[0];
		maxArr[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			maxArr[i] = Math.max(maxArr[i - 1], nums[i] + maxArr[i - 2]);
		}

		return maxArr[n - 1];
	}

}
