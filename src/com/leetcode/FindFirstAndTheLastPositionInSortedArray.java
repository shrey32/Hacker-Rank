package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class FindFirstAndTheLastPositionInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(search(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(search(new int[] { 5, 7, 7, 8, 8, 10 }, 7)));
		System.out.println(Arrays.toString(search(new int[] { 5, 7, 7, 8, 8, 10 }, 3)));
		System.out.println(Arrays.toString(search(new int[] {}, 0)));
	}

	public static int[] search(int[] a, int key) {
		int[] res = new int[] { -1, -1 };
		int len = a.length;
		int lo = 0;
		int hi = len - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == key) {
				res[0] = mid;
				hi = mid - 1;
			}
			if (a[mid] < key)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		lo = 0;
		hi = len - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == key) {
				res[1] = mid;
				lo = mid + 1;
			}
			if (a[mid] < key)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return res;
	}

}
