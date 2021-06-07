package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 25 }));// 15
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));// 6
	}

	/**
	 * 
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[n];
	}

}
