package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class SearchInARotatedArray {

	public static void main(String[] args) {
		int[] a = new int[] { 15, 16, 19, 20, 25, 26, 3, 4, 5, 7, 10, 14 };
		System.out.println(searchInRotatedArray(a, 5));// 8
		System.out.println(searchInRotatedArray(a, 15));
	}

	public static int searchInRotatedArray(int[] a, int target) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == target)
				return mid;
			if (a[mid] <= a[hi]) {
				if (target > a[mid] && target <= a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				if (target < a[mid] && target >= a[lo]) {
					hi = mid - 1;
				} else
					lo = mid + 1;
			}
		}
		return -1;
	}

}
