package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_INVPYRA/">FUCT_FOR_INVPYRA -
 * Inverted pyramid</a>
 * 
 * @author Shrey
 *
 */
public class InvertedPyramid {

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

		int start = 2 * n - 1;
		for (int i = 1; i <= n; i++) {

			if (i > 1)
				for (int j = 1; j < i; j++)
					System.out.print("  ");

			for (int k = 1; k <= start; k++)
				System.out.print("* ");

			System.out.println();
			start -= 2;
		}
	}

}
