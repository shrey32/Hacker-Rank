package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_ARROW/">FUCT_FOR_ARROW -
 * Right arrow</a>
 * 
 * @author Shrey
 *
 */
public class RightArrow {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if (n < 0)
			System.out.println("accept positive integer greater than 2 only!");
		else
			draw(n);
		scan.close();
	}

	private final static void draw(int n) {

		int half = (n + 1) / 2;
		for (int i = 1; i <= half; i++) {// forward
			if (i == 1) {
				for (int j = 1; j <= n; j++) {
					System.out.print("*");
					if (j < n)
						System.out.print(" ");
				}
				System.out.println();
			} else if (i <= half) {
				for (int k = 1; k < i; k++)
					System.out.print("  ");
				for (int k = i; k <= (n + (i - 1)); k++) {
					if (k == i || k == n + i - 1)
						System.out.print("* ");
					else
						System.out.print("  ");
				}
				System.out.println();
			}
		}

		int start = n % 2 != 0 ? half : half + 1;

		for (int i = half + 1; i <= n; i++) {
			if (i == n) {
				for (int j = 1; j <= n; j++) {
					System.out.print("*");
					if (j < n)
						System.out.print(" ");
				}
				System.out.println();
			} else {
				for (int k = --start; k > 1; k--)
					System.out.print("  ");
				for (int k = i; k <= (n + (i - 1)); k++) {
					if (k == i || k == n + i - 1)
						System.out.print("* ");
					else
						System.out.print("  ");
				}
				System.out.println();
			}
		}
	}

}
