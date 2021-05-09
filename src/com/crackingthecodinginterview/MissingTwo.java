package com.crackingthecodinginterview;

import java.util.Arrays;

/**
 * 
 * You are given an array with all the numbers from 1 to N appearing exactly
 * once, except for one number that is missing. How can you find the missing
 * number in O(N) time and 0(1) space? What if there were two numbers missing?
 * 
 * @author Shrey
 *
 */
public class MissingTwo {

	public static void main(String[] args) {
		System.out.println(missingOneNumber(new int[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 }, 10));
		System.out.println(Arrays.toString(missingTwoNumber(new int[] { 1, 2, 3, 5, 6, 7, 8, 9 }, 10)));
	}

	public static int missingOneNumber(int[] a, int n) {
		int sum1 = sum(a);
		int sum2 = totalSumTillN(n);
		return sum2 - sum1;
	}

	public static int[] missingTwoNumber(int[] a, int n) {
		int sum1 = sum(a);
		int sum2 = totalSumTillN(n);
		int diff = sum2 - sum1;
		Arrays.sort(a);
		for (int i = 1; i < n; i++) {
			if (i - 1 < a.length && a[i - 1] != i) {
				return new int[] { i, diff - i };
			}
		}
		return new int[] {};
	}

	private static int sum(int[] a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}

	private static int totalSumTillN(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}

}
