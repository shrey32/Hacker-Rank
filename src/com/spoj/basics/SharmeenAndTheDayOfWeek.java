package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSATDOW/">MOZSATDOW - Sharmeen and
 * the day of week</a>
 * 
 * @author Shrey
 *
 */
public class SharmeenAndTheDayOfWeek {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(dayOfWeek(n));
		scan.close();
	}

	private static final String dayOfWeek(int n) {
		String[] days = { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" };
		return days[n % days.length];
	}

}
