package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class BrokenCalculator {

	public static void main(String[] args) {

		System.out.println(brokenCalc(2, 3));// 2
		System.out.println(brokenCalc(3, 10));// 3
		System.out.println(brokenCalc(5, 8));// 2
		System.out.println(brokenCalc(1024, 1));// 1023
		System.out.println(brokenCalc(1, 1000000000));// 1023
	}

	public static int brokenCalc(int x, int y) {
		if (x >= y)
			return x - y;
		return 1 + brokenCalc(x, y % 2 == 0 ? y / 2 : y + 1);
	}

}
