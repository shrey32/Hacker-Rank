package com.spoj.basics;

import java.util.Scanner;

/**
 * 
 * <a href="https://www.spoj.com/problems/RG102/">RG102 - NEW YEAR GRADO 10</a>
 * 
 * @author Shrey
 *
 */
public class TimeRemainingForNewYear {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String time = scan.next();
		while (!"00:00".equals(time)) {
			String[] timeAr = time.split(":");
			int hh = Integer.parseInt(timeAr[0]);
			int mm = Integer.parseInt(timeAr[1]);
			System.out.println(missingMinutes(hh, mm));
		}
		scan.close();
	}

	private static final int missingMinutes(int hh, int mm) {
		int minutesRemaining = 60 - mm;
		int hoursRemaing = 24 - (hh + (mm + minutesRemaining) / 60);
		return hoursRemaing * 60 + minutesRemaining;
	}

}
