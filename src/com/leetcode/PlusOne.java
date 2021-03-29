package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 3, 4 })));// 1,3,5
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9 })));// 1,0,0,0
		System.out.println(Arrays.toString(plusOne(new int[] { 8, 6 })));// 8,7
	}

	public static int[] plusOne(int[] digits) {
		int carryOver = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int curr = digits[i] + carryOver;
			if (i == digits.length - 1) {
				curr = curr + 1;
			}
			digits[i] = curr % 10;
			carryOver = curr / 10;
		}
		if (carryOver > 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = carryOver;
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			return newDigits;
		}
		return digits;
	}

}
