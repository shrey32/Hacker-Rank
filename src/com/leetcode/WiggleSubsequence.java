package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class WiggleSubsequence {

	public static void main(String[] args) {
		System.out.println(wiggleMaxLength(new int[] { 0, 0 }));// 1
		System.out.println(wiggleMaxLength(new int[] { 3, 3, 3, 2, 5 }));// 3
		System.out.println(wiggleMaxLength(new int[] { 1, 1, 7, 4, 9, 2, 5 }));// 6
		System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));// 6
		System.out.println(wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));// 7
		System.out.println(wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));// 2
	}

	public static int wiggleMaxLength(int[] a) {
		int pos = 1;
		int neg = 1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				pos = neg + 1;
			} else if (a[i] > a[i + 1]) {
				neg = pos + 1;
			}
		}
		return Math.max(pos, neg);
	}
}
