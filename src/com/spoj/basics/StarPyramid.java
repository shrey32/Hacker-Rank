package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_PYRAMID/">FUCT_FOR_PYRAMID -
 * Star pyramid</a>
 * 
 * @author Shrey
 *
 */
public class StarPyramid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		draw(n);
		scan.close();
	}

	private final static void draw(int n) {

		int start = 1;
		int space = n - 1;
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= space; j++)
				System.out.print("  ");

			for (int k = 1; k <= start; k++)
				System.out.print("* ");

			System.out.println();
			start += 2;
			space--;
		}
	}
}
