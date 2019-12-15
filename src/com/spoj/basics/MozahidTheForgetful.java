package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZMTF/">MOZMTF - Mozahid the
 * forgetful</a>
 * 
 */
public class MozahidTheForgetful {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int digits = scan.nextInt();
		int sum = scan.nextInt();
		int digitSum = 0;
		int n = digits;
		while (n > 0) {
			int mod = n % 10;
			n = n / 10;
			digitSum += mod;
		}
		System.out.println(sum - digitSum + "" + digits);
		scan.close();
	}

}
