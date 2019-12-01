package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_RHOMBUS/">FUCT_FOR_RHOMBUS -
 * Rhombus</a>
 * 
 * @author Shrey
 *
 */
public class Rhombus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		draw(n);
		scan.close();
	}

	private static final void draw(int n) {

		int rows = 2 * n - 1;
		int outerSpaceOne = 2 * (n - 1);
		int innerSpaceOne = 3;
		int outerSpaceTwo = 2 * (n - 1);
		int innerSpaceTwo = 3;

		for (int i = 1; i <= rows; i++) {
			if (i == 1 || i == rows) {// first and last
				for (int j = 1; j <= 2 * (n - 1); j++)
					System.out.print(" ");
				System.out.print("*");
				outerSpaceOne -= 2;
			} else if (i <= n) {// middle
				for (int j = 1; j <= outerSpaceOne; j++)
					System.out.print(" ");
				System.out.print("*");
				for (int j = 1; j <= innerSpaceOne; j++)
					System.out.print(" ");
				System.out.print("*");
				innerSpaceOne += 4;
				outerSpaceOne -= 2;
			} else {
				for (int j = 1; j <= outerSpaceTwo; j++)
					System.out.print(" ");
				System.out.print("*");
				for (int j = 1; j <= innerSpaceTwo; j++)
					System.out.print(" ");
				System.out.print("*");
				innerSpaceTwo -= 4;
				outerSpaceTwo += 2;
			}

			if (i == n) {
				outerSpaceTwo = outerSpaceOne + (2 * 2);
				innerSpaceTwo = innerSpaceOne - (4 * 2);
			}
			System.out.println();
		}
	}

}
