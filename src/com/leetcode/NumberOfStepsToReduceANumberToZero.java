package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class NumberOfStepsToReduceANumberToZero {

	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));// 6
		System.out.println(numberOfSteps(8));// 4
		System.out.println(numberOfSteps(123));// 12
	}

	public static int numberOfSteps(int num) {
		if (num == 0)
			return 0;
		return 1 + ((num % 2 == 0) ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
	}

}
