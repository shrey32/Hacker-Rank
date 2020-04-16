package com.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
		int[] dp = new int[n];
		int max = -1;
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
