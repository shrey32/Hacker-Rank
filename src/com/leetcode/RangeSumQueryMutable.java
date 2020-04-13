package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RangeSumQueryMutable {

	public static void main(String[] args) {
		NumArray na = new NumArray(new int[] { 1, 3, 5 });
		System.out.println(na.sumRange(0, 2));// 9
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));// 8
	}

	private static class NumArray {

		private int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length + 1];
			for (int i = 1; i <= nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i - 1];
			}
		}

		public void update(int i, int val) {
			int temp = dp[i + 1] - dp[i];
			int diff = val - temp;
			for (int j = i + 1; j < dp.length; j++) {
				dp[j] = dp[j] + diff;
			}
		}

		public int sumRange(int i, int j) {
			return dp[j + 1] - dp[i];
		}
	}

}
