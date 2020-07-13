package com.leetcode.monthchallenge.july;

public class ArrangeCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(5));// 2
		System.out.println(arrangeCoins(8));// 3
		System.out.println(arrangeCoins(2147483647));// 65535
	}

	public static int arrangeCoins(int n) {
		return (int)(Math.sqrt((8L * n + 1)) - 1)/2;
	}

}
