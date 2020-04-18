package com.leetcode;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));// 3
		System.out.println(coinChange(new int[] { 2 }, 3));// -1
	}

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0; // 0 ways to generate 0 cents

		for (int a = 1; a <= amount; a++) {
			for (int coin : coins) {
				if (coin <= a) {
					dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

}
