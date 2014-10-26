package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Shrey
 *
 */
public class ChocolateFeast {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int numOfTestCases = scan.nextInt();
		for (int i = 0; i < numOfTestCases; i++) {
			int money = scan.nextInt();
			int chocValue = scan.nextInt();
			int chocPerWrapper = scan.nextInt();
			System.out.println(getChoclateCount(money, chocValue,
					chocPerWrapper));
		}
		scan.close();
	}

	public static int getChoclateCount(int money, int chocValue,
			int chocPerWrapper) {

		int numOfChoc = 0;
		int chocWrapper = 0;
		numOfChoc = money / chocValue;
		chocWrapper = numOfChoc;
		int rem = 0;
		int chocWrapper1 = 0;
		while (chocWrapper != 0) {
			chocWrapper1 = chocWrapper + rem;
			chocWrapper = chocWrapper1 / chocPerWrapper;
			rem = chocWrapper1 % chocPerWrapper;

			if (chocWrapper != 0) {
				numOfChoc = numOfChoc + chocWrapper;
			} else {
				break;
			}
		}
		return numOfChoc;
	}
}
