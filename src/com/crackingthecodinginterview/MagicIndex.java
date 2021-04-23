package com.crackingthecodinginterview;

/**
 * /** A magic index in an array A[0...n] is defined to be an index such that
 * A[i] = i. Given a sorted array of distinct integers, write a method to find a
 * magic index, if one exists, in array A.
 *
 * FOLLOW UP What if the values are not distinct?
 *
 * @author Shrey
 *
 */
public class MagicIndex {

	public static void main(String[] args) {
		int[] a = new int[] { -1, 0, 1, 3, 5, 7, 9 };
		System.out.println(getMagicIndex(a, 0, a.length - 1));
		a = new int[] { -1, 0, 2, 2, 2, 2, 3, 4, 6, 9, 11, 12, 13 };
		System.out.println(getMagicIndex(a, 0, a.length - 1));
		a = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println(getMagicIndex(a, 0, a.length - 1));
		a = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println(getMagicIndex(a, 0, a.length - 1));
	}

	private static int getMagicIndex(int[] a, int start, int end) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (a[mid] == mid) {
			return mid;
		} else if (a[mid] < mid) {
			return getMagicIndex(a, mid + 1, end);
		} else {
			return getMagicIndex(a, start, mid - 1);
		}
	}

}
