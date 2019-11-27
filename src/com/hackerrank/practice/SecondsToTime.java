package com.hackerrank.practice;

import java.util.Scanner;

/**
 * 
 * <a href="https://www.spoj.com/problems/FUCT_IF_SEC2TIME/">FUCT_IF_SEC2TIME -
 * Second to time hh_mm_ss</a>
 * 
 * @author Shrey
 *
 */
public class SecondsToTime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		secondsToTime(n);
		scan.close();
	}

	private final static void secondsToTime(int n) {
		if (n < 0) {
			System.out.println("total second must be a positive integer");
			return;
		}
		int ss = n % 60;
		int mm = n / 60;
		int mins = mm % 60;
		int hh = mm / 60;
		System.out.print((hh <= 9 ? "0" + hh : hh) + ":");
		System.out.print((mins <= 9 ? "0" + mins : mins) + ":");
		System.out.print((ss <= 9 ? "0" + ss : ss));
		System.out.println();
	}

}
