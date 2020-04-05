package com.leetcode.monthchallenge;

/**
 * 
 * <b>Best Time to Buy and Sell Stock II</b>
 * <p>
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * </p>
 * 
 * <p>
 * <b>Note:</b> You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [7,1,5,3,6,4]
 * </p>
 * <p>
 * <b>Output:</b> 7
 * </p>
 * <p>
 * <b>Explanation:</b>
 * <p>
 * Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * </p>
 * <p>
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * </p>
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [1,2,3,4,5]
 * </p>
 * <p>
 * <b>Output:</b> 4
 * </p>
 * <p>
 * <b>Explanation:</b>
 * <p>
 * Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * </p>
 * <p>
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 * </p>
 * </p>
 * <b>Example 3:</b>
 * 
 * <p>
 * <b>Input:</b> [7,6,4,3,1]
 * </p>
 * <p>
 * <b>Output:</b> 0
 * </p>
 * <p>
 * <b>Explanation:</b> In this case, no transaction is done, i.e. max profit =
 * 0.
 * </p>
 * 
 * 
 * @author Shrey
 *
 */
public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));// 7
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));// 4
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));// 0
	}

	/**
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int diff = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				diff += prices[i] - prices[i - 1];
		}
		return diff;
	}

}
