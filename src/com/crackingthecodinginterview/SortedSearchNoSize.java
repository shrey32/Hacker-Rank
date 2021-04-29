package com.crackingthecodinginterview;

/**
 * <p>
 * Sorted Search, No Size: You are given an array like data structure Listy
 * which lacks a size method. It does, however, have an elementAt ( i) method
 * that returns the element at index i in 0( 1) time. If i is beyond the bounds
 * of the data structure, it returns -1. (For this reason, the data structure
 * only supports positive integers.) Given a Li sty which contains sorted,
 * positive integers, find the index at which an element x occurs. If x occurs
 * multiple times, you may return any index.
 * </p>
 * 
 * @author Shrey
 *
 */
public class SortedSearchNoSize {

	public static void main(String[] args) {
		int[] a = new int[] { 4, 5, 6, 7, 8, 9, 10 };
		Listy li = new Listy(a);
		System.out.println(search(li, 9));
		System.out.println(search(li, 18));
		System.out.println(search(li, 4));
	}

	public static int search(Listy li, int key) {
		int lo = 0;
		int hi = Integer.MAX_VALUE;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (li.elementAt(mid) == key)
				return mid;
			if (li.elementAt(mid) == -1 || key < li.elementAt(mid)) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	public static class Listy {

		int[] a;

		public Listy(int[] a) {
			this.a = a;
		}

		public int elementAt(int i) {
			if (i >= a.length)
				return -1;
			return a[i];
		}

	}

}
