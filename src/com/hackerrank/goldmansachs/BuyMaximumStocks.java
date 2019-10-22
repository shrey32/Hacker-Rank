package com.hackerrank.goldmansachs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 Submissions
 Leaderboard
 Discussions
 Editorial 
 In a stock market, there is a product with its infinite stocks. The stock prices are given for  days, where denotes the price of the stock on the  day. There is a rule that a customer can buy at most  stock on the  day. If the customer has an amount of  dollars initially, find out the maximum number of stocks they can buy?

 For example, for  days the price of a stock is given as . You can buy  stock worth  on day , stocks worth  each on day  and  stocks worth  each on day . If , you can buy all the stocks (total ) for .

 Input Format

 The first line contains an integer  denoting the number of days. 
 The next line contains  space-separated integers where  integer denotes the price of the stock on the day. Next line contains a positive integer  which is the initial amount with the customer.

 Constraints

 Output Format

 Print the maximum number of stock that a customer can buy.

 Sample Input 0

 3
 10 7 19
 45
 Sample Output 0

 4
 Explanation 0

 The customer can purchase  stock on day ,  stock on day  and  stock on day  for ,  and  respectively. Hence, total amount is  and number of stocks purchased is .
 */
/**
 * 
 * @author Shrey
 *
 */
public class BuyMaximumStocks {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] data = br.readLine().trim().split(" ");
		Long k = Long.parseLong(br.readLine().trim());
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			Pair p = new Pair(Integer.parseInt(data[i]), i + 1);
			pairs.add(p);
		}
		pairs.sort((Pair o1, Pair o2) -> o1.getValue() - o2.getValue());
		System.out.println(numberOfStocks(pairs, k));
		br.close();
	}

	private static long numberOfStocks(List<Pair> pairs, long k) {
		long totalStocks = 0;
		long totalAmount = 0;
		for (Pair p : pairs) {
			int ith = p.getValue();
			int day = p.getDay();
			int maxStocksCouldBeBought = (ith * day);
			if (totalAmount + maxStocksCouldBeBought > k) {
				int num = 1;
				while (totalAmount <= k) {
					if ((totalAmount += (ith * num)) <= k) {
						totalAmount += (ith * num);
						totalStocks += num;
					}
					num++;
				}
			} else {
				totalAmount = maxStocksCouldBeBought;
				totalStocks += day;
			}
		}
		return totalStocks;
	}

	static class Pair {

		private int value = 0, day = 0;

		public Pair(int value, int day) {
			this.value = value;
			this.day = day;
		}

		public int getValue() {
			return value;
		}

		public int getDay() {
			return day;
		}

		@Override
		public String toString() {
			return "Pair [value=" + value + ", day=" + day + "]";
		}
	}

	private static long numberOfStocks(String[] data, long k) {
		long totalStocks = 0;
		long totalAmount = 0;
		for (int i = 0; i < data.length; i++) {
			int ith = Integer.parseInt(data[i]);
			int maxStocksCouldBeBought = (ith * (i + 1));
			if (totalAmount + maxStocksCouldBeBought > k) {
				int num = 1;
				while (totalAmount <= k) {
					if ((totalAmount += (ith * num)) <= k) {
						totalAmount += (ith * num);
						totalStocks += num;
					}
					num++;
				}
			} else {
				totalStocks += (i + 1);
			}
		}
		return totalStocks;
	}

}
