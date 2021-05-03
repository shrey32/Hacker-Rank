package com.crackingthecodinginterview;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class SmallestDifference {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(smallestDifference(new int[] { 1, 3, 15, 11, 2 }, new int[] { 23, 127, 235, 19, 8 })));
		System.out.println(Arrays.toString(smallestDifference(new int[] { 10, 5, 40 }, new int[] { 50, 90, 80 })));
	}

	public static int[] smallestDifference(int[] a, int[] b) {
		int[] res = new int[2];
		int min = Integer.MAX_VALUE;
		int p1 = 0, p2 = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		while (p1 < a.length && p2 < b.length) {
			int diff = Math.abs(a[p1] - b[p2]);
			if (diff >= 0 && diff < min) {
				res[0] = a[p1];
				res[1] = b[p2];
				min = diff;
			}
			if (a[p1] < b[p2])
				p1++;
			else
				p2++;
		}

		System.out.println(min);
		return res;
	}

}
