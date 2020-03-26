package com.leetcode;

import java.util.Arrays;

public class FirstAndLastPositionOfXInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(firstAndLastPosition(new int[] { 1, 3, 5, 5, 5, 5, 67, 123, 125 }, 5)));
		System.out.println(Arrays.toString(firstAndLastPosition(new int[] { 1, 3, 5, 5, 5, 5, 7, 123, 125 }, 7)));
	}

	private static int[] firstAndLastPosition(int[] a, int x) {
		if (a == null || a.length == 0)
			return new int[] { -1 };

		int index = Arrays.binarySearch(a, x);

		if (index < 0)
			return new int[] { -1 };

		int last = index;
		while (last + 1 < a.length && a[last + 1] == x)
			last++;

		return new int[] { index, last };
	}

}
