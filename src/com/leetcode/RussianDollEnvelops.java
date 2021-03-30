package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class RussianDollEnvelops {

	public static void main(String[] args) {
		System.out.println(maxEnvelopes(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } }));
	}

	public static int maxEnvelopes(int[][] nums) {
		Arrays.sort(nums, (a, b) -> a[0] - b[0]);
		int len = nums.length;
		int max = 1;
		int[] dp = new int[len];
		Arrays.fill(dp, 1);
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j][0] < nums[i][0] && nums[j][1] < nums[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
