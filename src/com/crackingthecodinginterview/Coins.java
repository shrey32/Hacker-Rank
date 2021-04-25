package com.crackingthecodinginterview;

/**
 * <p>
 * : Given an infinite number of quarters (25 cents), dimes (10 cents), nickels
 * (5 cents), and pennies (1 cent), write code to calculate the number of ways
 * of representing n cents 2 10 20 1 4 5 1 10, 10 1 1 5, 15 1 2 5, 10 1 3 5, 5 1
 * 
 * </p>
 * 
 * @author Shrey
 *
 */
public class Coins {

	public static void main(String[] args) {
		System.out.println(change(20));
		System.out.println(makeChange(20, 25));
	}

	public static int change(int n) {
		if (n <= 0)
			return 0;
		return change(n, 25);
	}

	public static int change(int n, int coin) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		int ways = 0;
		switch (coin) {
		case 25:
			ways += change(n - 25, 25);
		case 10:
			ways += change(n - 10, 10);
		case 5:
			ways += change(n - 5, 5);
		case 1:
			ways += change(n - 1, 1);
		}
		return ways;
	}

	private static int makeChange(int n, int coin) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		int ways = 0;
		switch (coin) {
		case 25:
			ways += makeChange(n - 25, 25);
		case 10:
			ways += makeChange(n - 10, 10);
		case 5:
			ways += makeChange(n - 5, 5);
		case 1:
			ways += makeChange(n - 1, 1);
		}
		return ways;
	}

}
