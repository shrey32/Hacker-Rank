package com.hackerrank.dynamicprogramming;

public class StockMaximize {

	public static void main(String[] args) {
		System.out.println(stockMax(new int[] { 1, 2, 3, 4 }));// 6
		System.out.println(stockMax(new int[] { 5, 3, 2 }));// 0
		System.out.println(stockMax(new int[] { 1, 2, 100 })); // 197
		System.out.println(stockMax(new int[] { 1, 3, 1, 2 }));// 3
	}

	static long stockMax(int[] prices) {
		long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i > -1 ; i--) {
            if (prices[i] >= maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;
	}

}
