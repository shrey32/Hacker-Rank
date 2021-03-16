package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));// 8
		System.out.println(maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3));// 6
	}

	public static int maxProfit(int[] prices, int fee) {
		// what is the max value before we reach the min value
		int n = prices.length;
		int noStocks = 0;
		int oneStocks = -prices[0];

		for (int i = 1; i < n; i++) {
			noStocks = Math.max(noStocks, oneStocks + prices[i] - fee);
			oneStocks = Math.max(oneStocks, noStocks - prices[i]);
		}

		return noStocks;
	}

}
