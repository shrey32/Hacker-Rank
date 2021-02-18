package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ArtihmeticSlices {

	public static void main(String[] args) {
		System.out.println(new int[] { 1, 3, 5, 7, 9 });
	}

	public static int numberOfArithmeticSlices(int[] a) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < a.length - 2; i++) {
			if (a[i] - a[i + 1] == a[i + 1] - a[i + 2]) {
				count++;
				sum += count;
			} else
				count = 0;
		}
		return sum;
	}

}
