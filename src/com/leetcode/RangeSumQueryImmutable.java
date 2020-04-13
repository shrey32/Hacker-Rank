package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		NumArray na = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(na.sumRange(0, 2));// 1
		System.out.println(na.sumRange(2, 5));// -1
		System.out.println(na.sumRange(0, 5));// -3
	}

	private static class NumArray {

		private int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length + 1];
			for (int i = 1; i <= nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			return dp[j + 1] - dp[i];
		}
	}

}
