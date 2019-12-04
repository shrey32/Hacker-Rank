package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_SUM2DIG/">FUCT_FOR_SUM2DIG -
 * Sum 2 digits</a>
 * 
 * @author Shrey
 *
 */
public class SumTwoDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		print(n);
		scan.close();
	}

	static void print(int n) {
		int a = 1;
		int b = n - a;

		while (a <= 10 && b >= 0) {
			System.out.println(a + "" + b + " = " + a + " + " + b + " = " + n);
			a++;
			b--;
		}

	}

}
