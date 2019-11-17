package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/G10_2/">G10_2 - Tavas and Nafas</a>
 * 
 * @author Shrey
 *
 */
public class TavasAndNafas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		convert(n);
		scan.close();
	}

	private final static void convert(int n) {
		String[] nums = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		if (n < 19) {
			System.out.print(nums[n]);
			System.out.println();
			return;
		}
		int div = n / 10;

		switch (div) {
		case 2:
			System.out.print("twenty");
			break;
		case 3:
			System.out.print("thirty");
			break;
		case 4:
			System.out.print("forty");
			break;
		case 5:
			System.out.print("fifty");
			break;
		case 6:
			System.out.print("sixty");
			break;
		case 7:
			System.out.print("seventy");
			break;
		case 8:
			System.out.print("eighty");
			break;
		case 9:
			System.out.print("ninety");
			break;
		case 10:
			System.out.println("hundred");
		}
		if (n % 10 > 0) {
			System.out.print("-");
			convert(n % 10);
		}
	}

}
